/**
 * Copyright (C) 2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.jdmc.core.codegen;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.io.file.FileOperationManager;
import com.helger.commons.state.EChange;
import com.helger.commons.string.StringHelper;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JAnnotationUse;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCommentPart;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JReturn;
import com.helger.jcodemodel.JVar;
import com.helger.jcodemodel.writer.JCMWriter;
import com.helger.jcodemodel.writer.ProgressCodeWriter.IProgressTracker;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMEnum;
import com.helger.jdmc.core.datamodel.JDMField;
import com.helger.jdmc.core.datamodel.JDMType;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import com.helger.tenancy.AbstractBusinessObject;
import com.helger.tenancy.IBusinessObject;

@NotThreadSafe
public class JDMCodeGenerator
{
  public static final String AUTHOR = "JDMCodeGenerator";
  private static final Logger LOGGER = LoggerFactory.getLogger (JDMCodeGenerator.class);

  private final JDMProcessor m_aProcessor;
  private final JDMCodeGenSettings m_aSettings = new JDMCodeGenSettings ();

  public JDMCodeGenerator (@Nonnull final JDMProcessor aProcessor)
  {
    ValueEnforcer.notNull (aProcessor, "Processor");
    m_aProcessor = aProcessor;
  }

  @Nonnull
  @ReturnsMutableObject
  public final JDMCodeGenSettings settings ()
  {
    return m_aSettings;
  }

  @Nonnull
  private JDefinedClass _createMainJavaInterface (@Nonnull final JDMCodeModel cm,
                                                  @Nonnull final JDMClass aClass) throws JClassAlreadyExistsException
  {
    final JDefinedClass jInterface = cm._class (JMod.PUBLIC, aClass.getFQInterfaceName (), EClassType.INTERFACE);
    if (m_aSettings.isUseBusinessObject ())
      jInterface._implements (IBusinessObject.class);
    else
      jInterface._implements (Serializable.class);
    jInterface.javadoc ().add ("<p>Interface for class {@link " + aClass.getClassName () + "}</p>\n");
    jInterface.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jInterface.javadoc ().addAuthor ().add (AUTHOR);

    for (final JDMField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsPrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);
      // Create getter

      // Find type name
      final String sJavaTypeName1 = aField.getType ().getJavaFQCN (eMultiplicity);
      final String sJavaTypeName2;
      final AbstractJDMClassType aExistingClass = m_aProcessor.findTypeByName (sJavaTypeName1);
      if (aExistingClass != null && aExistingClass instanceof JDMClass)
      {
        // It's one of our created classes - add an "I" prefix
        sJavaTypeName2 = aExistingClass.getFQInterfaceName ();
      }
      else
        sJavaTypeName2 = sJavaTypeName1;

      // List or field?
      AbstractJType jReturnType = cm.ref (sJavaTypeName2);
      if (eMultiplicity.isOpenEnded ())
        jReturnType = cm.ref (ICommonsList.class).narrow (jReturnType);

      final JMethod aMethodGet = jInterface.method (0,
                                                    jReturnType,
                                                    aField.getMethodGetterName (eMultiplicity.isOpenEnded ()));

      final boolean bIsStringType = "String".equals (sJavaTypeName2);

      // Annotations
      if (!bIsPrimitive)
      {
        if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
          aMethodGet.annotate (Nullable.class);
        else
          aMethodGet.annotate (Nonnull.class);
        if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
          aMethodGet.annotate (Nonempty.class);
        if (eMultiplicity.isOpenEnded ())
          aMethodGet.annotate (ReturnsMutableObject.class);
      }

      // Java docs
      {
        if (aField.hasComment ())
          aMethodGet.javadoc ().add (aField.getComment ());
        else
          aMethodGet.javadoc ().add ("Get the value of " + aField.getOriginalFieldName () + ".");

        final JCommentPart aReturn = aMethodGet.javadoc ().addReturn ();
        aReturn.add ("The requested value.");
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            aReturn.add (" May be <code>null</code>.");
          else
          {
            if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
              aReturn.add (" May neither be <code>null</code> nor empty.");
            else
              aReturn.add (" May not be <code>null</code>.");
          }
        }
      }

      if (!bIsPrimitive && eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
      {
        // Create the default "hasXXX" method
        final JMethod aMethodHas = jInterface.method (JMod.DEFAULT, cm.BOOLEAN, aField.getMethodHasName ());
        if (bIsStringType)
        {
          aMethodHas.body ()
                    ._return (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (JExpr.invoke (aMethodGet)));
        }
        else
          aMethodHas.body ()._return (JExpr.invoke (aMethodGet).neNull ());
      }
    }
    return jInterface;
  }

  @Nonnull
  private JDefinedClass _createMainJavaClass (@Nonnull final JDMCodeModel cm,
                                              @Nonnull final JDMClass aClass,
                                              @Nonnull final JDefinedClass jInterface) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQClassName (), EClassType.CLASS);
    if (m_aSettings.isUseBusinessObject ())
      jClass._extends (AbstractBusinessObject.class);
    jClass._implements (jInterface);
    jClass.annotate (NotThreadSafe.class);
    jClass.javadoc ().add ("<p>Default implementation of {@link " + aClass.getFQInterfaceName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (AUTHOR);

    final JFieldVar jOT = jClass.field (JMod.PUBLIC_STATIC_FINAL,
                                        ObjectType.class,
                                        "OT",
                                        cm.ref (ObjectType.class)._new ().arg (aClass.getClassName ()));

    final AbstractJClass jEChange = cm.ref (EChange.class);

    final boolean bHasFields = aClass.fields ().isNotEmpty ();
    final JMethod jCtor1;
    JInvocation jC1CallsC2 = null;
    final JMethod jCtor2;
    final JMethod jCtor3;
    JVar jC3Arg = null;
    final JMethod jEquals;
    JVar jEqualsParam = null;
    final JMethod jHashcode;
    JInvocation jHashcodeInvocation = null;
    final JMethod jToString;
    JInvocation jToStringInvocation = null;
    if (m_aSettings.isUseBusinessObject ())
    {
      final AbstractJClass jSO = cm.ref ("com.helger.photon.security.object.StubObject");

      jCtor1 = jClass.constructor (JMod.PUBLIC);
      jC1CallsC2 = JInvocation._this ();
      jC1CallsC2.arg (jSO.staticInvoke ("createForCurrentUser"));
      jCtor1.body ().add (jC1CallsC2);

      jCtor2 = jClass.constructor (JMod.PROTECTED);
      final JVar jC2Stub = jCtor2.param (JMod.FINAL, jSO, "aStubObject");
      jC2Stub.annotate (Nonnull.class);
      jCtor2.body ().add (JInvocation._super ().arg (jC2Stub));

      jCtor3 = null;

      // equals and hashCode are in parent class already
      jEquals = null;
      jHashcode = null;

      final JMethod jGetOT = jClass.method (JMod.PUBLIC | JMod.FINAL, ObjectType.class, "getObjectType");
      jGetOT.annotate (Nonnull.class);
      jGetOT.body ()._return (jOT);

      if (bHasFields)
      {
        jToString = jClass.method (JMod.PUBLIC, cm.ref (String.class), "toString");
        jToString.annotate (Override.class);
        jToStringInvocation = cm.ref (ToStringGenerator.class)
                                .staticInvoke ("getDerived")
                                .arg (JExpr._super ().invoke ("toString"));
      }
      else
        jToString = null;
    }
    else
    {
      jCtor1 = jClass.constructor (JMod.PUBLIC);

      if (bHasFields)
        jCtor2 = jClass.constructor (JMod.PUBLIC);
      else
        jCtor2 = null;

      jCtor3 = jClass.constructor (JMod.PUBLIC);
      jC3Arg = jCtor3.param (JMod.FINAL, jInterface, "aOther");
      jC3Arg.annotate (Nonnull.class);
      jCtor3.body ().add (cm.ref (ValueEnforcer.class).staticInvoke ("notNull").arg (jC3Arg).arg ("Other"));

      if (bHasFields)
      {
        jEquals = jClass.method (JMod.PUBLIC, cm.BOOLEAN, "equals");
        jEquals.annotate (Override.class);
        final JVar jEqualsArg = jEquals.param (JMod.FINAL, cm.ref (Object.class), "o");
        jEquals.body ()._if (jEqualsArg.eq (JExpr._this ()), new JReturn (JExpr.TRUE));
        jEquals.body ()
               ._if (jEqualsArg.eqNull ().cor (JExpr.invokeThis ("getClass").ne (jEqualsArg.invoke ("getClass"))),
                     new JReturn (JExpr.FALSE));
        jEqualsParam = jEquals.body ().decl (JMod.FINAL, jClass, "rhs", jEqualsArg.castTo (jClass));

        jHashcode = jClass.method (JMod.PUBLIC, cm.INT, "hashCode");
        jHashcode.annotate (Override.class);
        jHashcodeInvocation = cm.ref (HashCodeGenerator.class)._new ().arg (JExpr._this ());

        jToString = jClass.method (JMod.PUBLIC, cm.ref (String.class), "toString");
        jToString.annotate (Override.class);
        jToStringInvocation = cm.ref (ToStringGenerator.class)._new ().arg (JExpr._this ());
      }
      else
      {
        jEquals = null;
        jHashcode = null;
        jToString = null;
      }
    }

    for (final JDMField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsPrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);

      // Create getter

      // Find type name
      final String sJavaTypeName1 = aField.getType ().getJavaFQCN (eMultiplicity);
      final String sJavaTypeName2;
      final AbstractJDMClassType aExistingClass = m_aProcessor.findTypeByName (sJavaTypeName1);
      if (aExistingClass != null && aExistingClass instanceof JDMClass)
      {
        // It's one of our created classes - add an "I" prefix
        sJavaTypeName2 = aExistingClass.getFQInterfaceName ();
      }
      else
        sJavaTypeName2 = sJavaTypeName1;

      // List or field?
      AbstractJType jFieldType = cm.ref (sJavaTypeName2);
      IJExpression aFieldInit = null;
      boolean bFieldIsFinal = false;
      if (eMultiplicity.isOpenEnded ())
      {
        jFieldType = cm.ref (ICommonsList.class).narrow (jFieldType);
        aFieldInit = cm.ref (CommonsArrayList.class).narrowEmpty ()._new ();
        bFieldIsFinal = true;
      }

      // Class field
      final JVar jField = jClass.field (JMod.PRIVATE | (bFieldIsFinal ? JMod.FINAL : 0),
                                        jFieldType,
                                        aField.getJavaMemberName (eMultiplicity),
                                        aFieldInit);

      final String sVarName = aField.getJavaVarName (eMultiplicity);
      if (m_aSettings.isUseBusinessObject ())
      {
        final JVar jC1Arg = jCtor1.param (JMod.FINAL, jFieldType, sVarName);
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            jC1Arg.annotate (Nullable.class);
          else
            jC1Arg.annotate (Nonnull.class);
          if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
            jC1Arg.annotate (Nonempty.class);
        }
        jC1CallsC2.arg (jC1Arg);

        if (jCtor2 != null)
        {
          final JVar jC2Arg = jCtor2.param (JMod.FINAL, jFieldType, sVarName);
          if (!bIsPrimitive)
          {
            if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
              jC2Arg.annotate (Nullable.class);
            else
              jC2Arg.annotate (Nonnull.class);
            if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
              jC2Arg.annotate (Nonempty.class);
          }
          jCtor2.body ().add (JExpr.invoke (aField.getMethodSetterName ()).arg (jC2Arg));
        }
      }
      else
      {
        final JVar jC2Arg = jCtor2.param (JMod.FINAL, jFieldType, sVarName);
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            jC2Arg.annotate (Nullable.class);
          else
            jC2Arg.annotate (Nonnull.class);
          if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
            jC2Arg.annotate (Nonempty.class);
        }
        jCtor2.body ().add (JExpr.invoke (aField.getMethodSetterName ()).arg (jC2Arg));

        jCtor3.body ()
              .add (JExpr.invoke (aField.getMethodSetterName ())
                         .arg (jC3Arg.invoke (aField.getMethodGetterName (eMultiplicity.isOpenEnded ()))));

        if (jEquals != null)
          jEquals.body ()
                 ._if (cm.ref (EqualsHelper.class)
                         .staticInvoke ("equals")
                         .arg (jField)
                         .arg (jEqualsParam.ref (jField))
                         .not (),
                       new JReturn (JExpr.FALSE));

        if (jHashcodeInvocation != null)
          jHashcodeInvocation = jHashcodeInvocation.invoke ("append").arg (jField);
      }

      // toString
      if (jToStringInvocation != null)
        jToStringInvocation = jToStringInvocation.invoke ("append")
                                                 .arg (JExpr.lit (aField.getFieldName ()))
                                                 .arg (jField);

      // Getter
      {
        final JMethod aMethodGet = jClass.method (JMod.PUBLIC | JMod.FINAL,
                                                  jFieldType,
                                                  aField.getMethodGetterName (eMultiplicity.isOpenEnded ()));

        // Annotations
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            aMethodGet.annotate (Nullable.class);
          else
            aMethodGet.annotate (Nonnull.class);
          if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
            aMethodGet.annotate (Nonempty.class);
          if (eMultiplicity.isOpenEnded ())
            aMethodGet.annotate (ReturnsMutableObject.class);
        }
        aMethodGet.body ()._return (jField);
      }

      // Setter
      {
        final JMethod aMethodSet = jClass.method ((m_aSettings.isSetterArePackagePrivate () ? 0 : JMod.PUBLIC) |
                                                  JMod.FINAL,
                                                  jEChange,
                                                  aField.getMethodSetterName ());
        aMethodSet.annotate (Nonnull.class);
        final JVar jParam = aMethodSet.param (JMod.FINAL, jFieldType, aField.getJavaVarName (eMultiplicity));
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            jParam.annotate (Nullable.class);
          else
            jParam.annotate (Nonnull.class);
          if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
            jParam.annotate (Nonempty.class);
        }

        final JBlock aBody = aMethodSet.body ();

        if (!bIsPrimitive)
        {
          // Use param name without prefix
          final String sParamNameLit = jParam.name ().substring (1);
          if (eMultiplicity.isMin1 ())
          {
            if (eMultiplicity.isOpenEnded ())
              aBody.add (cm.ref (ValueEnforcer.class).staticInvoke ("notEmpty").arg (jParam).arg (sParamNameLit));
            else
              aBody.add (cm.ref (ValueEnforcer.class).staticInvoke ("notNull").arg (jParam).arg (sParamNameLit));
          }
          else
          {
            if (eMultiplicity.isOpenEnded ())
              aBody.add (cm.ref (ValueEnforcer.class).staticInvoke ("notNull").arg (jParam).arg (sParamNameLit));
          }
        }

        if (bIsPrimitive)
        {
          // if (param == field) return EChange.UNCHANGED
          aBody._if (jParam.eq (jField))._then ()._return (jEChange.staticRef ("UNCHANGED"));
          aBody.assign (jField, jParam);
        }
        else
          if (eMultiplicity.isOpenEnded ())
          {
            // List
            aBody.addSingleLineComment ("Ensure the same implementation type");
            final JVar jTmpVar = aBody.decl (JMod.FINAL,
                                             jField.type (),
                                             "aRealList",
                                             cm.ref (CommonsArrayList.class).narrowEmpty ()._new ().arg (jParam));
            aBody._if (jTmpVar.invoke ("equals").arg (jField))._then ()._return (jEChange.staticRef ("UNCHANGED"));
            aBody.add (jField.invoke ("setAll").arg (jTmpVar));
          }
          else
          {
            if (eMultiplicity.isMin1 ())
            {
              // if (param.equals (field)) return EChange.UNCHANGED
              aBody._if (jParam.invoke ("equals").arg (jField))._then ()._return (jEChange.staticRef ("UNCHANGED"));
            }
            else
            {
              // if (EqualsHelper.equals (param, field)) return
              // EChange.UNCHANGED
              aBody._if (cm.ref (EqualsHelper.class).staticInvoke ("equals").arg (jParam).arg (jField))
                   ._then ()
                   ._return (jEChange.staticRef ("UNCHANGED"));
            }
            aBody.assign (jField, jParam);
          }

        aBody._return (jEChange.staticRef ("CHANGED"));
      }
    }

    // Finalize methods
    if (jEquals != null)
      jEquals.body ()._return (JExpr.TRUE);
    if (jHashcode != null)
      jHashcode.body ()._return (jHashcodeInvocation.invoke ("getHashCode"));
    if (jToString != null)
      jToString.body ()._return (jToStringInvocation.invoke ("getToString"));

    return jClass;
  }

  public void createMainJavaClasses (@Nonnull final JDMCodeModel cm, @Nonnull final ICommonsList <JDMClass> aClasses)
  {
    for (final JDMClass aClass : aClasses)
    {
      try
      {
        final JDefinedClass jInterface = _createMainJavaInterface (cm, aClass);
        final JDefinedClass jDomainClass = _createMainJavaClass (cm, aClass, jInterface);
        JDMHelperMicroTypeConverter.createMainMicroTypeConverterClass (m_aSettings,
                                                                       cm,
                                                                       aClass,
                                                                       jInterface,
                                                                       jDomainClass);
      }
      catch (final JClassAlreadyExistsException ex)
      {
        throw new IllegalStateException (ex);
      }
    }
  }

  public void createTestJavaSelfTest (@Nonnull final JDMCodeModel cm)
  {
    try
    {
      final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                                  AbstractJDMClassType.getFQCN (m_aProcessor.getDestinationPackageName (),
                                                                                "JDMSelfTest"),
                                                  EClassType.CLASS);
      jTestClass.javadoc ().add ("This is the self-test class of JDM\n");
      jTestClass.javadoc ().add ("This class was initially automatically created\n");
      jTestClass.javadoc ().addAuthor ().add (AUTHOR);

      final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testSetterAndGetter");
      jMethod.annotate (Test.class);
      jMethod.annotate (SuppressWarnings.class)
             .paramArray (JAnnotationUse.SPECIAL_KEY_VALUE, new String [] { "unused", "cast" });

      int nCount = 0;
      for (final JDMType aType : CollectionHelper.getSorted (m_aProcessor.getContext ().types ().getTypes (),
                                                             Comparator.comparing (JDMType::getClassName)))
      {
        final JVar aVar = jMethod.body ().decl (cm.ref (aType, EJDMMultiplicity.MANDATORY), "var" + nCount);
        jMethod.body ().assign (aVar, aType.createTestValue (cm));
        if (!aType.isPrimitive () && aType.isImmutable ())
          jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertNotNull").arg (aVar));

        ++nCount;
      }
    }
    catch (final JClassAlreadyExistsException ex)
    {
      throw new IllegalStateException (ex);
    }
  }

  public void createTestJavaClasses (@Nonnull final JDMCodeModel cm, @Nonnull final ICommonsList <JDMClass> aClasses)
  {
    for (final JDMClass aClass : aClasses)
    {
      try
      {
        final AbstractJClass jClass = cm.ref (aClass.getFQClassName ());
        final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                                    aClass.getFQTestClassName (),
                                                    EClassType.CLASS);
        jTestClass.javadoc ().add ("This is the test class for class {@link " + aClass.getFQClassName () + "}\n");
        jTestClass.javadoc ().add ("This class was initially automatically created\n");
        jTestClass.javadoc ().addAuthor ().add (AUTHOR);

        if (m_aSettings.isUseBusinessObject ())
        {
          // JUnit 4 test rule
          final JVar jRule = jTestClass.field (JMod.PUBLIC | JMod.FINAL,
                                               cm.ref (TestRule.class),
                                               "m_aRule",
                                               cm.ref (PhotonBasicWebTestRule.class)._new ());
          jRule.annotate (Rule.class);
        }

        if (m_aSettings.isUseBusinessObject ())
        {
          // TODO
        }
        else
        {
          final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testSetterAndGetter");
          jMethod.annotate (Test.class);
          jMethod.body ().decl (jClass, "x", jClass._new ());

          // TODO
        }
      }
      catch (final JClassAlreadyExistsException ex)
      {
        throw new IllegalStateException (ex);
      }
    }
  }

  /**
   * Run the main code creation
   *
   * @param aDestDir
   *        The directory to create the code in. Must stop before "src". The
   *        folders "src/main/java" and "src/test/java" are appended on demand.
   * @throws IOException
   *         On write error
   */
  public void createCode (@Nonnull final File aDestDir) throws IOException
  {
    ValueEnforcer.notNull (aDestDir, "DestDir");

    final ICommonsList <JDMClass> aClasses = m_aProcessor.getAllReadClasses ();
    final ICommonsList <JDMEnum> aEnums = m_aProcessor.getAllReadEnums ();

    {
      final File aSrcMainJava = new File (aDestDir, "src/main/java");
      final File aSrcMainResources = new File (aDestDir, "src/main/resources");

      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcMainJava);
      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcMainResources);

      final JDMCodeModel cm = new JDMCodeModel ();

      // Create all classes
      createMainJavaClasses (cm, aClasses);

      // Create all enums
      JDMHelperEnum.createMainJavaEnums (cm, aEnums);

      new JCMWriter (cm).setCharset (StandardCharsets.UTF_8)
                        .setIndentString ("  ")
                        .build (aSrcMainJava, aSrcMainResources, (IProgressTracker) null);
    }

    {
      final File aSrcTestJava = new File (aDestDir, "src/test/java");
      final File aSrcTestResources = new File (aDestDir, "src/test/resources");

      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcTestJava);
      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcTestResources);

      final JDMCodeModel cm = new JDMCodeModel ();

      createTestJavaSelfTest (cm);

      // Create all classes
      createTestJavaClasses (cm, aClasses);

      // Create all enums
      JDMHelperEnum.createTestJavaEnums (cm, aEnums);

      new JCMWriter (cm).setCharset (StandardCharsets.UTF_8)
                        .setIndentString ("  ")
                        .build (aSrcTestJava, aSrcTestResources, (IProgressTracker) null);
    }

    LOGGER.info ("Done creating code in " + aDestDir.getAbsolutePath ());
  }
}
