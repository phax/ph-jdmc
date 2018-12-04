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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMField;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import com.helger.xml.mock.XMLTestHelper;

@NotThreadSafe
public class JDMCodeGenTest
{
  private JDMCodeGenTest ()
  {}

  static void createTestJavaClasses (@Nonnull final JDMCodeGenSettings aSettings,
                                     @Nonnull final JDMCodeModel cm,
                                     @Nonnull final ICommonsList <JDMClass> aClasses)
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
          jMethod.annotate (Test.class);
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
          jMethod.annotate (Test.class);

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
          {
            jMethod.body ().addSingleLineComment ("Check XML conversion");
            jMethod.body ().add (cm.ref (XMLTestHelper.class).staticInvoke ("testMicroTypeConversion").arg (jX));
          }
        }
      }
      catch (final JClassAlreadyExistsException ex)
      {
        throw new IllegalStateException (ex);
      }
    }
  }
}
