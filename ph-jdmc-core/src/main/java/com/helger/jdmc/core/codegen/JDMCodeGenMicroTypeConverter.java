/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
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

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.helger.commons.annotation.IsSPIImplementation;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.IJStatement;
import com.helger.jcodemodel.JBlock;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JFieldVar;
import com.helger.jcodemodel.JForEach;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JMods;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.datamodel.AbstractJDMGenType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMGenClass;
import com.helger.jdmc.core.datamodel.JDMGenField;
import com.helger.jdmc.core.datamodel.JDMType;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistrarSPI;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistry;
import com.helger.xml.microdom.convert.MicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;

@Immutable
final class JDMCodeGenMicroTypeConverter
{
  private JDMCodeGenMicroTypeConverter ()
  {}

  private static boolean _isString (@Nonnull final JDMType aType)
  {
    return aType.getShortName ().equals ("String");
  }

  private static boolean _isElement (@Nonnull final JDMGenField aField)
  {
    if (aField.getType ().isPrimitive ())
    {
      // Primitive types are always attributes
      return false;
    }
    if (aField.getType ().isEnum ())
    {
      // Enums are always attributes
      return false;
    }
    if (!aField.getType ().isPredefined ())
    {
      // Nested, created types, are always elements, except for enums
      return true;
    }
    if (_isString (aField.getType ()))
    {
      // Special predefined types that should be elements
      return true;
    }

    // Assume attribute (e.g. LocalDate etc.)
    return false;
  }

  @Nonnull
  static JDefinedClass createMainMicroTypeConverterClass (@Nonnull final JDMCodeGenSettings aSettings,
                                                          @Nonnull final JDMCodeModel cm,
                                                          @Nonnull final JDMGenClass aClass,
                                                          @Nonnull final JDefinedClass jDomainClass) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQMicroTypeConverterClassName (), EClassType.CLASS);
    if (aSettings.isUseBusinessObject ())
      jClass._extends (cm.ref (AbstractBusinessObjectMicroTypeConverter.class).narrow (jDomainClass));
    else
      jClass._implements (cm.ref (IMicroTypeConverter.class).narrow (jDomainClass));
    jClass.javadoc ()
          .add ("<p>Default MicroTypeConverter implementation of {@link " + aClass.getFQInterfaceName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    // Method stub convertToMicroElement
    final JMethod jToMicroElement = jClass.method (JMod.PUBLIC, cm.ref (IMicroElement.class), "convertToMicroElement");
    jToMicroElement.annotate (Nonnull.class);
    final JVar jToObj = jToMicroElement.param (JMod.FINAL, jDomainClass, "aValue");
    jToObj.annotate (Nonnull.class);
    final JVar jToNS = jToMicroElement.param (JMod.FINAL, cm.ref (String.class), "sNamespaceURI");
    jToNS.annotate (Nullable.class);
    final JVar jToTN = jToMicroElement.param (JMod.FINAL, cm.ref (String.class), "sTagName");
    jToTN.annotate (Nonnull.class);
    final JVar jElement = jToMicroElement.body ()
                                         .decl (JMod.FINAL,
                                                cm.ref (IMicroElement.class),
                                                "aElement",
                                                cm.ref (MicroElement.class)._new ().arg (jToNS).arg (jToTN));
    if (aSettings.isUseBusinessObject ())
    {
      jToMicroElement.body ().add (JExpr._super ().invoke ("setObjectFields").arg (jToObj).arg (jElement));
    }

    // Method stub convertToNative
    final JMethod jToNative = jClass.method (JMod.PUBLIC, jDomainClass, "convertToNative");
    jToNative.annotate (Nonnull.class);
    final JVar jToNativeElement = jToNative.param (JMod.FINAL, cm.ref (IMicroElement.class), "aElement");
    jToNativeElement.annotate (Nonnull.class);

    final ICommonsList <JVar> aParamsToNative = new CommonsArrayList <> ();

    for (final JDMGenField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsEffectivePrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);
      final boolean bIsOpenEnded = eMultiplicity.isOpenEnded ();

      final boolean bIsElement = _isElement (aField);
      final JFieldVar jFieldName = jClass.field (JMod.PRIVATE | JMod.STATIC | JMod.FINAL,
                                                 cm.ref (String.class),
                                                 (bIsOpenEnded || bIsElement ? "ELEMENT_" : "ATTR_") +
                                                                        aField.getOriginalFieldName ()
                                                                              .toUpperCase (Locale.ROOT),
                                                 JExpr.lit (aField.getFieldName ().toLowerCase (Locale.ROOT)));

      // To MicroElement
      {
        final boolean bHasHasMethod = !bIsEffectivePrimitive && eMultiplicity == EJDMMultiplicity.OPTIONAL;

        JBlock aExecBlock = jToMicroElement.body ();
        IJExpression jSrcElement = jElement;
        IJExpression jRealName = jFieldName;
        JVar jRealToObj = jToObj;
        IJExpression aValueProvider;
        if (bIsOpenEnded)
        {
          final JForEach jForEach = new JForEach (JMods.forVar (JMod.FINAL),
                                                  cm.ref (aField.getType ()),
                                                  "aItem",
                                                  jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded)));
          aExecBlock.add (jForEach);
          aExecBlock = jForEach.body ();
          jRealToObj = jForEach.var ();

          if (!bIsElement)
          {
            jSrcElement = jElement.invoke ("appendElement").arg (jToNS).arg (jFieldName);
            jRealName = JExpr.lit ("value");
          }
          aValueProvider = jRealToObj;
        }
        else
        {
          aValueProvider = jRealToObj.invoke (aField.getMethodGetterName (bIsOpenEnded));
        }
        final IJStatement aExec;

        if (bIsElement)
        {
          if (_isString (aField.getType ()))
          {
            aExec = jSrcElement.invoke ("appendElement")
                               .arg (jToNS)
                               .arg (jRealName)
                               .invoke ("appendText")
                               .arg (aValueProvider);
          }
          else
          {
            aExec = jSrcElement.invoke ("appendChild")
                               .arg (cm.ref (MicroTypeConverter.class)
                                       .staticInvoke ("convertToMicroElement")
                                       .arg (aValueProvider)
                                       .arg (jToNS)
                                       .arg (jRealName));
          }

          if (bHasHasMethod)
            aExecBlock._if (jRealToObj.invoke (aField.getMethodHasName ()), aExec);
          else
            aExecBlock.add (aExec);
        }
        else
        {
          // attribute
          if (aField.getType ().isEnum ())
          {
            aExec = jSrcElement.invoke ("setAttribute").arg (jRealName).arg (aValueProvider.invoke ("getID"));
            if (bHasHasMethod)
              aExecBlock._if (jRealToObj.invoke (aField.getMethodHasName ()), aExec);
            else
              aExecBlock.add (aExec);
          }
          else
            if (bIsEffectivePrimitive)
            {
              aExecBlock.add (jSrcElement.invoke ("setAttribute").arg (jRealName).arg (aValueProvider));
            }
            else
            {
              aExecBlock.add (jSrcElement.invoke ("setAttributeWithConversion").arg (jRealName).arg (aValueProvider));
            }
        }
      }

      // To Native
      {
        // List or field?
        final AbstractJType jVarType = cm.ref (aField.getType (), eMultiplicity);
        final JForEach jForEach;
        final JVar jToNativeRealElement;
        final IJExpression jRealName;
        if (bIsOpenEnded)
        {
          jForEach = new JForEach (JMods.forVar (JMod.FINAL),
                                   cm.ref (IMicroElement.class),
                                   "aChild",
                                   jToNativeElement.invoke ("getAllChildElements").arg (jFieldName));

          jToNativeRealElement = jForEach.var ();
          jRealName = JExpr.lit ("value");
        }
        else
        {
          jForEach = null;
          jToNativeRealElement = jToNativeElement;
          jRealName = jFieldName;
        }

        final IJExpression jGetValue;
        if (bIsElement)
        {
          if (_isString (aField.getType ()))
          {
            if (bIsOpenEnded)
              jGetValue = jToNativeRealElement.invoke ("getTextContent");
            else
              jGetValue = cm.ref (MicroHelper.class)
                            .staticInvoke ("getChildTextContent")
                            .arg (jToNativeRealElement)
                            .arg (jRealName);
          }
          else
          {
            final AbstractJType jFieldImplementationType = cm.ref (aField.getType ().getFQCN ());
            if (bIsOpenEnded)
              jGetValue = cm.ref (MicroTypeConverter.class)
                            .staticInvoke ("convertToNative")
                            .arg (jToNativeRealElement)
                            .arg (JExpr.dotClass (jFieldImplementationType));
            else
              jGetValue = cm.ref (MicroTypeConverter.class)
                            .staticInvoke ("convertToNative")
                            .arg (jToNativeRealElement.invoke ("getFirstChildElement").arg (jRealName))
                            .arg (JExpr.dotClass (jFieldImplementationType));
          }
        }
        else
        {
          // Attribute
          if (aField.getType ().isEnum ())
            jGetValue = cm.ref (aField.getType ().getFQCN ())
                          .staticInvoke ("getFromIDOrNull")
                          .arg (jToNativeRealElement.invoke ("getAttributeValue").arg (jRealName));
          else
            if (jVarType == cm.BOOLEAN)
              jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsBool").arg (jRealName).arg (JExpr.FALSE);
            else
              if (jVarType == cm.BYTE)
                jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsInt")
                                                .arg (jRealName)
                                                .arg (-1)
                                                .castTo (cm.BYTE);
              else
                if (jVarType == cm.DOUBLE)
                  jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsDouble")
                                                  .arg (jRealName)
                                                  .arg (cm.ref (Double.class).staticRef ("NaN"));
                else
                  if (jVarType == cm.FLOAT)
                    jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsFloat")
                                                    .arg (jRealName)
                                                    .arg (cm.ref (Float.class).staticRef ("NaN"));
                  else
                    if (jVarType == cm.INT)
                      jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsInt").arg (jRealName).arg (-1);
                    else
                      if (jVarType == cm.LONG)
                        jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsLong").arg (jRealName).arg (-1);
                      else
                        if (jVarType == cm.SHORT)
                          jGetValue = jToNativeRealElement.invoke ("getAttributeValueAsInt")
                                                          .arg (jRealName)
                                                          .arg (-1)
                                                          .castTo (cm.SHORT);
                        else
                          jGetValue = jToNativeRealElement.invoke ("getAttributeValueWithConversion")
                                                          .arg (jRealName)
                                                          .arg (JExpr.dotClass (jVarType));

        }

        if (bIsOpenEnded)
        {
          final JVar jVar = jToNative.body ()
                                     .decl (JMod.FINAL,
                                            cm.ref (ICommonsList.class).narrow (jVarType),
                                            aField.getJavaVarName (eMultiplicity),
                                            cm.ref (CommonsArrayList.class).narrowEmpty ()._new ());
          aParamsToNative.add (jVar);

          jToNative.body ().add (jForEach);
          jForEach.body ().add (jVar.invoke ("add").arg (jGetValue));
        }
        else
        {
          final JVar jVar = jToNative.body ()
                                     .decl (JMod.FINAL, jVarType, aField.getJavaVarName (eMultiplicity), jGetValue);
          aParamsToNative.add (jVar);
        }
      }
    }

    {
      jToMicroElement.body ()._return (jElement);
    }

    {
      final JInvocation jInvRet = jDomainClass._new ();
      if (aSettings.isUseBusinessObject ())
        jInvRet.arg (JExpr._super ().invoke ("getStubObject").arg (jToNativeElement));
      for (final JVar aVar : aParamsToNative)
        jInvRet.arg (aVar);
      jToNative.body ()._return (jInvRet);
    }

    return jClass;
  }

  static void createMainMicroTypeConverterRegistrarClass (@Nonnull final String sDestPackageName,
                                                          @Nonnull final JDMCodeModel cm,
                                                          @Nonnull final ICommonsList <? extends AbstractJDMGenType> aClasses) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                            AbstractJDMGenType.getFQCN (sDestPackageName,
                                                                          "MicroTypeConverterRegistrar"),
                                            EClassType.CLASS);
    jClass._implements (cm.ref (IMicroTypeConverterRegistrarSPI.class));
    jClass.javadoc ().add ("<p>Default MicroTypeConverter registrar of this project</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    jClass.annotate (Immutable.class);
    jClass.annotate (IsSPIImplementation.class);

    final JMethod jMethod = jClass.method (JMod.PUBLIC, cm.VOID, "registerMicroTypeConverter");
    final JVar jParam = jMethod.param (JMod.FINAL, cm.ref (IMicroTypeConverterRegistry.class), "aRegistry");
    jParam.annotate (Nonnull.class);

    for (final AbstractJDMGenType aClass : aClasses)
    {
      jMethod.body ()
             .add (jParam.invoke ("registerMicroElementTypeConverter")
                         .arg (cm.ref (aClass.getFQClassName ()).dotclass ())
                         .arg (cm.ref (aClass.getFQMicroTypeConverterClassName ())._new ()));
    }
    cm.spiImplMap ().register (IMicroTypeConverterRegistrarSPI.class, jClass.fullName ());
  }
}
