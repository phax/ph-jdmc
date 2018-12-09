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

import java.io.IOException;
import java.util.Comparator;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.rules.TestRule;

import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.mock.SPITestHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JAnnotationUse;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMField;
import com.helger.jdmc.core.datamodel.JDMType;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import com.helger.xml.mock.XMLTestHelper;

@Immutable
final class JDMCodeGenTest
{
  private static final String ORG_JUNIT_TEST_FQCN = "org.junit.Test";

  private JDMCodeGenTest ()
  {}

  static void createTestJavaClass (@Nonnull final JDMCodeGenSettings aSettings,
                                   @Nonnull final JDMCodeModel cm,
                                   @Nonnull final JDMClass aClass) throws JClassAlreadyExistsException
  {
    final AbstractJClass jClass = cm.ref (aClass.getFQClassName ());
    final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                                aClass.getFQTestClassName (),
                                                EClassType.CLASS);
    jTestClass.javadoc ().add ("This is the test class for class {@link " + aClass.getFQClassName () + "}\n");
    jTestClass.javadoc ().add ("This class was initially automatically created\n");
    jTestClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    if (aSettings.isUseBusinessObject ())
    {
      // JUnit 4 test rule
      final JVar jRule = jTestClass.field (JMod.PUBLIC | JMod.FINAL,
                                           cm.ref (TestRule.class),
                                           "m_aRule",
                                           cm.ref (PhotonBasicWebTestRule.class)._new ());
      jRule.annotate (Rule.class);
    }

    if (!aSettings.isUseBusinessObject ())
    {
      final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testDefaultCtor");
      // Use String to avoid Eclipse treats this as a real test
      jMethod.annotate (cm.ref (ORG_JUNIT_TEST_FQCN));
      final JVar jObj = jMethod.body ().decl (jClass, "x", jClass._new ());
      jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertEquals").arg (jObj).arg (jClass._new ()));

      for (final JDMField aField : aClass.fields ())
      {
        final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
        final boolean bIsOpenEnded = eMultiplicity.isOpenEnded ();
        if (aField.getType ().isJavaPrimitive (eMultiplicity))
        {
          // No testing
          jMethod.body ().add (jObj.invoke (aField.getMethodGetterName (bIsOpenEnded)));
        }
        else
        {
          if (bIsOpenEnded)
            jMethod.body ()
                   .add (cm.ref (Assert.class)
                           .staticInvoke ("assertNotNull")
                           .arg (jObj.invoke (aField.getMethodGetterName (bIsOpenEnded))));
          else
            jMethod.body ()
                   .add (cm.ref (Assert.class)
                           .staticInvoke ("assertNull")
                           .arg (jObj.invoke (aField.getMethodGetterName (bIsOpenEnded))));
        }
      }
    }

    {
      final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testSetterAndGetter");
      // Use String to avoid Eclipse treats this as a real test
      jMethod.annotate (cm.ref (ORG_JUNIT_TEST_FQCN));

      // Ctor with all params
      JInvocation aNew = jClass._new ();
      for (final JDMField aField : aClass.fields ())
      {
        IJExpression aTestVal = aField.getType ().createTestValue (cm, aSettings);
        if (aField.getMultiplicity ().isOpenEnded ())
          aTestVal = cm.ref (CommonsArrayList.class).narrowEmpty ()._new ().arg (aTestVal);
        aNew = aNew.arg (aTestVal);
      }
      final JVar jX = jMethod.body ().decl (jClass, "x", aNew);
      jMethod.body ()
             .add (cm.ref (Assert.class)
                     .staticInvoke ("assertTrue")
                     .arg (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (jX.invoke ("toString"))));
      {
        // Empty ctor again
        final JVar jY = jMethod.body ().decl (jClass, "y", aNew);
        jMethod.body ()
               .add (cm.ref (Assert.class)
                       .staticInvoke ("assertTrue")
                       .arg (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (jY.invoke ("toString"))));
        jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertNotSame").arg (jX).arg (jY));
        if (!aSettings.isUseBusinessObject ())
        {
          jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertEquals").arg (jX).arg (jY));
          jMethod.body ()
                 .add (cm.ref (Assert.class)
                         .staticInvoke ("assertEquals")
                         .arg (jX.invoke ("hashCode"))
                         .arg (jY.invoke ("hashCode")));
          jMethod.body ()
                 .add (cm.ref (CommonsTestHelper.class)
                         .staticInvoke ("testDefaultImplementationWithEqualContentObject")
                         .arg (jX)
                         .arg (jY));
        }
      }
      if (!aSettings.isUseBusinessObject () && aClass.fields ().isNotEmpty ())
      {
        // Copy ctor
        jMethod.body ().addSingleLineComment ("Test copy ctor");
        final JVar jZ = jMethod.body ().decl (jClass, "z", jClass._new ().arg (jX));
        jMethod.body ()
               .add (cm.ref (Assert.class)
                       .staticInvoke ("assertTrue")
                       .arg (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (jZ.invoke ("toString"))));
        jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertNotSame").arg (jX).arg (jZ));
        jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertEquals").arg (jX).arg (jZ));
        jMethod.body ()
               .add (cm.ref (Assert.class)
                       .staticInvoke ("assertEquals")
                       .arg (jX.invoke ("hashCode"))
                       .arg (jZ.invoke ("hashCode")));
        jMethod.body ()
               .add (cm.ref (CommonsTestHelper.class)
                       .staticInvoke ("testDefaultImplementationWithEqualContentObject")
                       .arg (jX)
                       .arg (jZ));
      }

      // Invoke all setters
      jMethod.body ().addSingleLineComment ("Test all setters");
      for (final JDMField aField : aClass.fields ())
      {
        IJExpression aTestVal = aField.getType ().createTestValue (cm, aSettings);
        if (aField.getMultiplicity ().isOpenEnded ())
          aTestVal = cm.ref (CommonsArrayList.class).narrowEmpty ()._new ().arg (aTestVal);

        final JInvocation jSet = jX.invoke (aField.getMethodSetterName ()).arg (aTestVal);
        if (aSettings.isUseBusinessObject () && !aField.getType ().isPredefined ())
          jMethod.body ().add (jSet);
        else
          jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertFalse").arg (jSet.invoke ("isChanged")));
      }

      // Check micro type conversion
      if (aSettings.isCreateMicroTypeConverter ())
      {
        jMethod.body ().addSingleLineComment ("Check XML conversion");
        jMethod.body ().add (cm.ref (XMLTestHelper.class).staticInvoke ("testMicroTypeConversion").arg (jX));
      }
    }
  }

  static void createTestJavaSelfTest (@Nonnull final JDMProcessor aProcessor,
                                      @Nonnull final JDMCodeGenSettings aSettings,
                                      @Nonnull final JDMCodeModel cm) throws JClassAlreadyExistsException
  {
    final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                                AbstractJDMClassType.getFQCN (aProcessor.getDestinationPackageName (),
                                                                              "JDMSelfTest"),
                                                EClassType.CLASS);
    jTestClass.javadoc ().add ("This is the self-test class of JDM\n");
    jTestClass.javadoc ().add ("This class was initially automatically created\n");
    jTestClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    if (aSettings.isUseBusinessObject ())
    {
      // JUnit 4 test rule
      final JVar jRule = jTestClass.field (JMod.PUBLIC | JMod.FINAL,
                                           cm.ref (TestRule.class),
                                           "m_aRule",
                                           cm.ref (PhotonBasicWebTestRule.class)._new ());
      jRule.annotate (Rule.class);
    }

    final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testMockValueCreation");
    // Use String to avoid Eclipse treats this as a real test
    jMethod.annotate (cm.ref (ORG_JUNIT_TEST_FQCN));
    jMethod.annotate (SuppressWarnings.class)
           .paramArray (JAnnotationUse.SPECIAL_KEY_VALUE, new String [] { "unused", "cast" });

    int nCount = 0;
    for (final JDMType aType : CollectionHelper.getSorted (aProcessor.getContext ().types ().getTypes (),
                                                           Comparator.comparing (JDMType::getClassName)))
    {
      final JVar aVar = jMethod.body ().decl (cm.ref (aType, EJDMMultiplicity.MANDATORY), "var" + nCount);
      jMethod.body ().assign (aVar, aType.createTestValue (cm, aSettings));
      if (!aType.isPrimitive () && aType.isImmutable ())
        jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertNotNull").arg (aVar));

      ++nCount;
    }
  }

  static void createSPITest (@Nonnull final String sDestPackageName,
                             @Nonnull final JDMCodeModel cm) throws JClassAlreadyExistsException
  {
    final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                                AbstractJDMClassType.getFQCN (sDestPackageName, "JDMSPITest"),
                                                EClassType.CLASS);
    jTestClass.javadoc ().add ("Test all SPI implementations of this project\n");
    jTestClass.javadoc ().add ("This class was initially automatically created\n");
    jTestClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testSPI");
    // Use String to avoid Eclipse treats this as a real test
    jMethod.annotate (cm.ref (ORG_JUNIT_TEST_FQCN));
    jMethod._throws (IOException.class);
    jMethod.body ().add (cm.ref (SPITestHelper.class).staticInvoke ("testIfAllSPIImplementationsAreValid"));
  }
}