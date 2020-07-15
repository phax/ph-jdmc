/**
 * Copyright (C) 2018-2020 Philip Helger (www.helger.com)
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

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.StringHelper;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JCodeModelException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JReturn;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.AbstractJDMGenType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMGenClass;
import com.helger.jdmc.core.datamodel.JDMGenField;
import com.helger.tenancy.AbstractBusinessObject;
import com.helger.tenancy.IBusinessObject;

@Immutable
public class JDMCodeGenBase
{
  private JDMCodeGenBase ()
  {}

  @Nonnull
  private static AbstractJClass _resolveType (@Nonnull final JDMProcessor aProcessor,
                                              @Nonnull final JCodeModel cm,
                                              @Nonnull final String sType)
  {
    final AbstractJDMGenType aExistingClass = aProcessor.findGenTypeByName (sType);
    String sRealType = sType;
    if (aExistingClass != null && aExistingClass instanceof JDMGenClass)
    {
      // It's one of our created classes - add an "I" prefix
      sRealType = aExistingClass.getFQInterfaceName ();
    }

    return cm.ref (sRealType);
  }

  @Nonnull
  static JDefinedClass createMainJavaInterface (@Nonnull final JDMProcessor aProcessor,
                                                @Nonnull final JDMCodeGenSettings aSettings,
                                                @Nonnull final JDMCodeModel cm,
                                                @Nonnull final JDMGenClass aClass) throws JCodeModelException
  {
    final JDefinedClass jInterface = cm._class (JMod.PUBLIC, aClass.getFQInterfaceName (), EClassType.INTERFACE);
    if (aSettings.isUseBusinessObject ())
      jInterface._implements (IBusinessObject.class);
    else
      jInterface._implements (Serializable.class);
    jInterface.javadoc ().add ("<p>Interface for class {@link " + aClass.getClassName () + "}</p>\n");
    jInterface.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jInterface.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    for (final JDMGenField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsEffectivePrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);
      final boolean bIsOpenEnded = eMultiplicity.isOpenEnded ();
      final boolean bIsStringType = "String".equals (aField.getType ().getShortName ());

      // Create getter

      // List or field?
      AbstractJClass jReturnType = _resolveType (aProcessor, cm, aField.getType ().getJavaFQCN (eMultiplicity));
      if (bIsOpenEnded)
        jReturnType = cm.ref (ICommonsList.class).narrow (jReturnType);

      final JMethod aMethodGet = jInterface.method (0, jReturnType, aField.getMethodGetterName (bIsOpenEnded));

      // Annotations
      if (!bIsEffectivePrimitive)
      {
        if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
          aMethodGet.annotate (Nullable.class);
        else
          aMethodGet.annotate (Nonnull.class);
        if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
          aMethodGet.annotate (Nonempty.class);
        if (bIsOpenEnded)
          aMethodGet.annotate (ReturnsMutableObject.class);
      }

      // Java docs
      {
        if (aField.hasComment ())
          aMethodGet.javadoc ().addMasked (aField.getComment ());
        else
          aMethodGet.javadoc ().add ("Get the value of " + aField.getOriginalFieldName () + ".");

        aMethodGet.javadoc ().addReturn ().add ("The requested value." + aField.getJavaDocSuffix ());
      }

      if (!bIsEffectivePrimitive && eMultiplicity == EJDMMultiplicity.OPTIONAL)
      {
        // Create the default "hasXXX" method
        final JMethod aMethodHas = jInterface.method (JMod.DEFAULT, cm.BOOLEAN, aField.getMethodHasName ());
        if (bIsStringType)
        {
          aMethodHas.body ()._return (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (JExpr.invoke (aMethodGet)));
        }
        else
          aMethodHas.body ()._return (JExpr.invoke (aMethodGet).neNull ());
      }

      if (aField.getType ().isEnum () && !bIsOpenEnded)
      {
        // Create the get...ID method for enums
        final JMethod aMethodGetID = jInterface.method (JMod.DEFAULT,
                                                        cm.ref (String.class),
                                                        aField.getMethodGetterName (bIsOpenEnded) + "ID");
        if (eMultiplicity.isMin0 ())
        {
          aMethodGetID.annotate (Nullable.class);
          final JVar jVar = aMethodGetID.body ().decl (JMod.FINAL, jReturnType, "aObj", JExpr.invoke (aMethodGet));
          aMethodGetID.body ()._return (JExpr.cond (jVar.eqNull (), JExpr._null (), jVar.invoke ("getID")));
        }
        else
        {
          aMethodGetID.annotate (Nonnull.class);
          aMethodGetID.body ()._return (JExpr.invoke (aMethodGet).invoke ("getID"));
        }
      }
    }
    return jInterface;
  }

  @Nonnull
  static JDefinedClass createMainJavaClass (@Nonnull final JDMCodeGenSettings aSettings,
                                            @Nonnull final JDMCodeModel cm,
                                            @Nonnull final JDMGenClass aClass,
                                            @Nonnull final JDefinedClass jInterface) throws JCodeModelException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQClassName (), EClassType.CLASS);
    if (aSettings.isUseBusinessObject ())
      jClass._extends (AbstractBusinessObject.class);
    jClass._implements (jInterface);
    jClass.annotate (NotThreadSafe.class);
    jClass.javadoc ().add ("<p>Default implementation of {@link " + aClass.getFQInterfaceName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

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
    if (aSettings.isUseBusinessObject ())
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
        jToStringInvocation = cm.ref (ToStringGenerator.class).staticInvoke ("getDerived").arg (JExpr._super ().invoke ("toString"));
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

      if (bHasFields)
      {
        jCtor3 = jClass.constructor (JMod.PUBLIC);
        jC3Arg = jCtor3.param (JMod.FINAL, jInterface, "aOther");
        jC3Arg.annotate (Nonnull.class);
        jCtor3.body ().add (cm.ref (ValueEnforcer.class).staticInvoke ("notNull").arg (jC3Arg).arg ("Other"));
      }
      else
        jCtor3 = null;

      jEquals = jClass.method (JMod.PUBLIC, cm.BOOLEAN, "equals");
      jEquals.annotate (Override.class);
      final JVar jEqualsArg = jEquals.param (JMod.FINAL, cm.ref (Object.class), "o");
      jEquals.body ()._if (jEqualsArg.eq (JExpr._this ()), new JReturn (JExpr.TRUE));
      jEquals.body ()
             ._if (jEqualsArg.eqNull ().cor (JExpr.invokeThis ("getClass").ne (jEqualsArg.invoke ("getClass"))), new JReturn (JExpr.FALSE));
      if (bHasFields)
        jEqualsParam = jEquals.body ().decl (JMod.FINAL, jClass, "rhs", jEqualsArg.castTo (jClass));

      jHashcode = jClass.method (JMod.PUBLIC, cm.INT, "hashCode");
      jHashcode.annotate (Override.class);
      jHashcodeInvocation = cm.ref (HashCodeGenerator.class)._new ().arg (JExpr._this ());

      jToString = jClass.method (JMod.PUBLIC, cm.ref (String.class), "toString");
      jToString.annotate (Override.class);
      jToStringInvocation = cm.ref (ToStringGenerator.class)._new ().arg (JExpr._this ());
    }

    for (final JDMGenField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsEffectivePrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);

      // Create getter

      // List or field?
      AbstractJType jFieldType = cm.ref (aField.getType (), eMultiplicity);
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
      if (aSettings.isUseBusinessObject ())
      {
        final JVar jC1Arg = jCtor1.param (JMod.FINAL, jFieldType, sVarName);
        if (!bIsEffectivePrimitive)
        {
          if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
            jC1Arg.annotate (Nullable.class);
          else
            jC1Arg.annotate (Nonnull.class);
          if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
            jC1Arg.annotate (Nonempty.class);
        }
        jC1CallsC2.arg (jC1Arg);

        if (jCtor2 != null)
        {
          final JVar jC2Arg = jCtor2.param (JMod.FINAL, jFieldType, sVarName);
          if (!bIsEffectivePrimitive)
          {
            if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
              jC2Arg.annotate (Nullable.class);
            else
              jC2Arg.annotate (Nonnull.class);
            if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
              jC2Arg.annotate (Nonempty.class);
          }
          jCtor2.body ().add (JExpr.invoke (aField.getMethodSetterName ()).arg (jC2Arg));
        }
      }
      else
      {
        final JVar jC2Arg = jCtor2.param (JMod.FINAL, jFieldType, sVarName);
        if (!bIsEffectivePrimitive)
        {
          if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
            jC2Arg.annotate (Nullable.class);
          else
            jC2Arg.annotate (Nonnull.class);
          if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
            jC2Arg.annotate (Nonempty.class);
        }
        jCtor2.body ().add (JExpr.invoke (aField.getMethodSetterName ()).arg (jC2Arg));

        jCtor3.body ()
              .add (JExpr.invoke (aField.getMethodSetterName ())
                         .arg (jC3Arg.invoke (aField.getMethodGetterName (eMultiplicity.isOpenEnded ()))));

        if (jEquals != null)
          jEquals.body ()
                 ._if (cm.ref (EqualsHelper.class).staticInvoke ("equals").arg (jField).arg (jEqualsParam.ref (jField)).not (),
                       new JReturn (JExpr.FALSE));

        if (jHashcodeInvocation != null)
          jHashcodeInvocation = jHashcodeInvocation.invoke ("append").arg (jField);
      }

      // toString
      if (jToStringInvocation != null)
        jToStringInvocation = jToStringInvocation.invoke ("append").arg (JExpr.lit (aField.getFieldName ())).arg (jField);

      // Getter
      {
        final JMethod aMethodGet = jClass.method (JMod.PUBLIC | JMod.FINAL,
                                                  jFieldType,
                                                  aField.getMethodGetterName (eMultiplicity.isOpenEnded ()));

        // Annotations
        if (!bIsEffectivePrimitive)
        {
          if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
            aMethodGet.annotate (Nullable.class);
          else
            aMethodGet.annotate (Nonnull.class);
          if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
            aMethodGet.annotate (Nonempty.class);
          if (eMultiplicity.isOpenEnded ())
            aMethodGet.annotate (ReturnsMutableObject.class);
        }
        aMethodGet.body ()._return (jField);
      }

      // Setter
      {
        final JMethod aMethodSet = jClass.method ((aSettings.isSetterArePackagePrivate () ? 0 : JMod.PUBLIC) | JMod.FINAL,
                                                  jEChange,
                                                  aField.getMethodSetterName ());
        aMethodSet.annotate (Nonnull.class);
        final JVar jParam = aMethodSet.param (JMod.FINAL, jFieldType, aField.getJavaVarName (eMultiplicity));
        if (!bIsEffectivePrimitive)
        {
          if (eMultiplicity == EJDMMultiplicity.OPTIONAL)
            jParam.annotate (Nullable.class);
          else
            jParam.annotate (Nonnull.class);
          if (eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
            jParam.annotate (Nonempty.class);
        }

        final JBlock aBody = aMethodSet.body ();

        if (!bIsEffectivePrimitive)
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

        if (bIsEffectivePrimitive)
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
}
