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
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMField;
import com.helger.jdmc.core.datamodel.JDMType;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistrarSPI;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistry;
import com.helger.xml.microdom.convert.MicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;

final class JDMCodeGenMicroTypeConverter
{
  private JDMCodeGenMicroTypeConverter ()
  {}

  private static boolean _isString (@Nonnull final JDMType aType)
  {
    return aType.getShortName ().equals ("String");
  }

  private static boolean _isElement (@Nonnull final JDMField aField)
  {
    if (aField.getMultiplicity ().isOpenEnded ())
    {
      // Lists are always elements
      return true;
    }
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
    if (_isString (aField.getType ()))
    {
      // Special predefined types that should be elements
      return true;
    }
    if (!aField.getType ().isPredefined ())
    {
      // Nested, created types, are always elements, except for enums
      return true;
    }

    // Assume attribute (e.g. LocalDate etc.)
    return false;
  }

  static void createMainMicroTypeConverterClass (@Nonnull final JDMCodeGenSettings aSettings,
                                                 @Nonnull final JDMCodeModel cm,
                                                 @Nonnull final JDMClass aClass,
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

    for (final JDMField aField : aClass.fields ())
    {
      final boolean bIsPrimitive = aField.getType ().isPrimitive ();
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsOpenEnded = eMultiplicity.isOpenEnded ();

      final boolean bIsElement = _isElement (aField);
      final JFieldVar jFieldName = jClass.field (JMod.PRIVATE | JMod.STATIC | JMod.FINAL,
                                                 cm.ref (String.class),
                                                 (bIsElement ? "ELEMENT_" : "ATTR_") +
                                                                        aField.getOriginalFieldName ()
                                                                              .toUpperCase (Locale.ROOT),
                                                 JExpr.lit (aField.getFieldName ().toLowerCase (Locale.ROOT)));

      // To MicroElement
      {
        final boolean bHasHasMethod = !bIsPrimitive && eMultiplicity.isMin0 () && !bIsOpenEnded;
        if (bIsElement)
        {
          final IJStatement aExec;
          if (bIsOpenEnded)
          {
            final JForEach jForEach = new JForEach (JMods.forVar (JMod.FINAL),
                                                    cm.ref (aField.getType ()),
                                                    "aItem",
                                                    jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded)));
            jForEach.body ()
                    .add (jElement.invoke ("appendChild")
                                  .arg (cm.ref (MicroTypeConverter.class)
                                          .staticInvoke ("convertToMicroElement")
                                          .arg (jForEach.var ())
                                          .arg (jToNS)
                                          .arg (jFieldName)));
            aExec = jForEach;
          }
          else
            if (_isString (aField.getType ()))
            {
              aExec = jElement.invoke ("appendElement")
                              .arg (jToNS)
                              .arg (jFieldName)
                              .invoke ("appendText")
                              .arg (jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded)));
            }
            else
            {
              aExec = jElement.invoke ("appendChild")
                              .arg (cm.ref (MicroTypeConverter.class)
                                      .staticInvoke ("convertToMicroElement")
                                      .arg (jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded)))
                                      .arg (jToNS)
                                      .arg (jFieldName));
            }

          if (bHasHasMethod)
            jToMicroElement.body ()._if (jToObj.invoke (aField.getMethodHasName ()), aExec);
          else
            jToMicroElement.body ().add (aExec);
        }
        else
        {
          // attribute
          if (aField.getType ().isEnum ())
          {
            final IJStatement aExec = jElement.invoke ("setAttribute")
                                              .arg (jFieldName)
                                              .arg (jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded))
                                                          .invoke ("getID"));
            if (bHasHasMethod)
              jToMicroElement.body ()._if (jToObj.invoke (aField.getMethodHasName ()), aExec);
            else
              jToMicroElement.body ().add (aExec);
          }
          else
            if (aField.getType ().isPrimitive ())
            {
              jToMicroElement.body ()
                             .add (jElement.invoke ("setAttribute")
                                           .arg (jFieldName)
                                           .arg (jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded))));
            }
            else
            {
              jToMicroElement.body ()
                             .add (jElement.invoke ("setAttributeWithConversion")
                                           .arg (jFieldName)
                                           .arg (jToObj.invoke (aField.getMethodGetterName (bIsOpenEnded))));
            }
        }
      }

      // To Native
      {
        // List or field?
        final AbstractJType jFieldElementType = cm.ref (aField.getType (), eMultiplicity);
        AbstractJType jFieldType = jFieldElementType;
        IJExpression aInit = null;
        if (bIsOpenEnded)
        {
          jFieldType = cm.ref (ICommonsList.class).narrow (jFieldType);
          aInit = cm.ref (CommonsArrayList.class).narrowEmpty ()._new ();
        }
        else
          if (bIsElement)
          {
            if (_isString (aField.getType ()))
            {
              aInit = cm.ref (MicroHelper.class)
                        .staticInvoke ("getChildTextContent")
                        .arg (jToNativeElement)
                        .arg (jFieldName);
            }
            else
            {
              aInit = cm.ref (MicroTypeConverter.class)
                        .staticInvoke ("convertToNative")
                        .arg (jToNativeElement.invoke ("getFirstChildElement").arg (jFieldName))
                        .arg (JExpr.dotClass (jFieldElementType));
            }
          }
          else
          {
            // Attribute
            if (aField.getType ().isEnum ())
              aInit = cm.ref (aField.getType ().getFQCN ())
                        .staticInvoke ("getFromIDOrNull")
                        .arg (jToNativeElement.invoke ("getAttributeValue").arg (jFieldName));
            else
              if (jFieldType == cm.BOOLEAN)
                aInit = jToNativeElement.invoke ("getAttributeValueAsBool").arg (jFieldName).arg (JExpr.FALSE);
              else
                if (jFieldType == cm.BYTE)
                  aInit = jToNativeElement.invoke ("getAttributeValueAsInt").arg (jFieldName).arg (-1).castTo (cm.BYTE);
                else
                  if (jFieldType == cm.DOUBLE)
                    aInit = jToNativeElement.invoke ("getAttributeValueAsDouble")
                                            .arg (jFieldName)
                                            .arg (cm.ref (Double.class).staticRef ("NaN"));
                  else
                    if (jFieldType == cm.FLOAT)
                      aInit = jToNativeElement.invoke ("getAttributeValueAsFloat")
                                              .arg (jFieldName)
                                              .arg (cm.ref (Float.class).staticRef ("NaN"));
                    else
                      if (jFieldType == cm.INT)
                        aInit = jToNativeElement.invoke ("getAttributeValueAsInt").arg (jFieldName).arg (-1);
                      else
                        if (jFieldType == cm.LONG)
                          aInit = jToNativeElement.invoke ("getAttributeValueAsLong").arg (jFieldName).arg (-1);
                        else
                          if (jFieldType == cm.SHORT)
                            aInit = jToNativeElement.invoke ("getAttributeValueAsInt")
                                                    .arg (jFieldName)
                                                    .arg (-1)
                                                    .castTo (cm.SHORT);
                          else
                            aInit = jToNativeElement.invoke ("getAttributeValueWithConversion")
                                                    .arg (jFieldName)
                                                    .arg (JExpr.dotClass (jFieldType));

          }

        final JVar jVar = jToNative.body ().decl (JMod.FINAL, jFieldType, aField.getJavaVarName (eMultiplicity), aInit);
        aParamsToNative.add (jVar);

        if (bIsOpenEnded)
        {
          final JForEach jForEach = jToNative.body ()
                                             .forEach (JMod.FINAL,
                                                       cm.ref (IMicroElement.class),
                                                       "aChild",
                                                       jToNativeElement.invoke ("getAllChildElements")
                                                                       .arg (jFieldName));
          jForEach.body ()
                  .add (jVar.invoke ("add")
                            .arg (cm.ref (MicroTypeConverter.class)
                                    .staticInvoke ("convertToNative")
                                    .arg (jForEach.var ())
                                    .arg (JExpr.dotClass (jFieldElementType))));
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
  }

  static void createMainMicroTypeConverterRegistrarClass (@Nonnull final JDMCodeModel cm,
                                                          @Nonnull final ICommonsList <? extends AbstractJDMClassType> aClasses) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                            AbstractJDMClassType.getFQCN (aClasses.getFirst ().getPackageName (),
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

    for (final AbstractJDMClassType aClass : aClasses)
    {
      jMethod.body ()
             .add (jParam.invoke ("registerMicroElementTypeConverter")
                         .arg (cm.ref (aClass.getFQClassName ()).dotclass ())
                         .arg (cm.ref (aClass.getFQMicroTypeConverterClassName ())._new ()));
    }
    cm.spiImplMap ().register (IMicroTypeConverterRegistrarSPI.class, jClass.fullName ());
  }
}
