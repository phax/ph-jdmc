/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import org.junit.Assert;
import org.junit.Test;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JCodeModelException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JEnumConstant;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JForEach;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.datamodel.JDMGenEnum;
import com.helger.jdmc.core.datamodel.JDMGenEnumConstant;

/**
 * Enumeration specific code generation helper
 *
 * @author Philip Helger
 */
@Immutable
final class JDMCodeGenEnum
{
  private JDMCodeGenEnum ()
  {}

  static void createMainJavaEnums (@Nonnull final JDMCodeModel cm,
                                   @Nonnull final ICommonsList <JDMGenEnum> aEnums) throws JCodeModelException
  {
    final AbstractJType jString = cm.ref (String.class);
    for (final JDMGenEnum aEnum : aEnums)
    {
      final JDefinedClass jEnum = cm._class (JMod.PUBLIC, aEnum.getFQClassName (), EClassType.ENUM);
      jEnum._implements (cm.ref (IHasID.class).narrow (jString));
      jEnum._implements (cm.ref (IHasDisplayName.class));
      jEnum.javadoc ().add ("This class was initially automatically created\n");
      jEnum.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

      for (final JDMGenEnumConstant aEnumConstant : aEnum.enumConstants ())
      {
        final JEnumConstant jEnumConstant = jEnum.enumConstant (aEnumConstant.getName ())
                                                 .arg (JExpr.lit (aEnumConstant.getID ()))
                                                 .arg (JExpr.lit (aEnumConstant.getDisplayName ()));
        if (aEnumConstant.hasComment ())
          jEnumConstant.javadoc ().add (aEnumConstant.getComment ());
      }

      final JVar jFieldID = jEnum.field (JMod.PRIVATE | JMod.FINAL, jString, "m_sID");
      final JVar jFieldDisplayName = jEnum.field (JMod.PRIVATE | JMod.FINAL, jString, "m_sDisplayName");

      {
        final JMethod jMethod = jEnum.constructor (JMod.PRIVATE);
        final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
        jID.annotate (Nonnull.class);
        jID.annotate (Nonempty.class);
        final JVar jDisplayName = jMethod.param (JMod.FINAL, jString, "sDisplayName");
        jDisplayName.annotate (Nonnull.class);
        jDisplayName.annotate (Nonempty.class);
        jMethod.body ().assign (jFieldID, jID);
        jMethod.body ().assign (jFieldDisplayName, jDisplayName);
      }

      {
        final JMethod jMethod = jEnum.method (JMod.PUBLIC, jString, "getID");
        jMethod.annotate (Nonnull.class);
        jMethod.annotate (Nonempty.class);
        jMethod.body ()._return (jFieldID);
      }

      {
        final JMethod jMethod = jEnum.method (JMod.PUBLIC, jString, "getDisplayName");
        jMethod.annotate (Nonnull.class);
        jMethod.annotate (Nonempty.class);
        jMethod.body ()._return (jFieldDisplayName);
      }

      {
        final JMethod jMethod = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrNull");
        jMethod.annotate (Nullable.class);
        final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
        jID.annotate (Nullable.class);
        jMethod.body ()._return (cm.ref (EnumHelper.class).staticInvoke ("getFromIDOrNull").arg (jEnum.dotclass ()).arg (jID));
      }

      {
        final JMethod jMethod = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrDefault");
        jMethod.annotate (Nullable.class);
        final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
        jID.annotate (Nullable.class);
        final JVar jDefault = jMethod.param (JMod.FINAL, jEnum, "eDefault");
        jDefault.annotate (Nullable.class);
        jMethod.body ()
               ._return (cm.ref (EnumHelper.class).staticInvoke ("getFromIDOrDefault").arg (jEnum.dotclass ()).arg (jID).arg (jDefault));
      }

      {
        final JMethod jMethod = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrThrow");
        jMethod.annotate (Nonnull.class);
        final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
        jID.annotate (Nullable.class);
        jMethod.body ()._return (cm.ref (EnumHelper.class).staticInvoke ("getFromIDOrThrow").arg (jEnum.dotclass ()).arg (jID));
      }
    }
  }

  static void createTestJavaEnums (@Nonnull final JDMCodeModel cm,
                                   @Nonnull final ICommonsList <JDMGenEnum> aEnums) throws JCodeModelException
  {
    for (final JDMGenEnum aEnum : aEnums)
    {
      final AbstractJClass jEnum = cm.ref (aEnum.getFQClassName ());
      final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL, aEnum.getFQTestClassName (), EClassType.CLASS);
      jTestClass.javadoc ().add ("This is the test class for class {@link " + aEnum.getFQClassName () + "}\n");
      jTestClass.javadoc ().add ("This class was initially automatically created\n");
      jTestClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

      final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testBasic");
      jMethod.annotate (Test.class);
      final JForEach jForEach = jMethod.body ().forEach (JMod.FINAL, jEnum, "e", jEnum.staticInvoke ("values"));
      jForEach.body ()
              .add (cm.ref (Assert.class)
                      .staticInvoke ("assertTrue")
                      .arg (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (jForEach.var ().invoke ("getID"))));
      jForEach.body ()
              .add (cm.ref (Assert.class)
                      .staticInvoke ("assertTrue")
                      .arg (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (jForEach.var ().invoke ("getDisplayName"))));
      jForEach.body ()
              .add (cm.ref (Assert.class)
                      .staticInvoke ("assertSame")
                      .arg (jForEach.var ())
                      .arg (jEnum.staticInvoke ("getFromIDOrNull").arg (jForEach.var ().invoke ("getID"))));
      jForEach.body ()
              .add (cm.ref (Assert.class)
                      .staticInvoke ("assertSame")
                      .arg (jForEach.var ())
                      .arg (jEnum.staticInvoke ("getFromIDOrDefault").arg (jForEach.var ().invoke ("getID")).argNull ()));
      jForEach.body ()
              .add (cm.ref (Assert.class)
                      .staticInvoke ("assertSame")
                      .arg (jForEach.var ())
                      .arg (jEnum.staticInvoke ("getFromIDOrThrow").arg (jForEach.var ().invoke ("getID"))));
    }
  }
}
