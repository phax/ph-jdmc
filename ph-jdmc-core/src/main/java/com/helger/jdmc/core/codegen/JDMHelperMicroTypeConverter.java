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

import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JMod;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.convert.IMicroTypeConverter;

final class JDMHelperMicroTypeConverter
{
  private JDMHelperMicroTypeConverter ()
  {}

  private static boolean _isElement ()
  {
    return false;
  }

  static void createMainMicroTypeConverterClass (@Nonnull final JDMCodeGenSettings aSettings,
                                                 @Nonnull final JCodeModel cm,
                                                 @Nonnull final JDMClass aClass,
                                                 @Nonnull final JDefinedClass jInterface,
                                                 @Nonnull final JDefinedClass jDomainClass) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQMicroTypeConverterClassName (), EClassType.CLASS);
    if (aSettings.isUseBusinessObject ())
      jClass._extends (cm.ref (AbstractBusinessObjectMicroTypeConverter.class).narrow (jDomainClass));
    else
      jClass._extends (cm.ref (IMicroTypeConverter.class).narrow (jDomainClass));
    jClass.javadoc ()
          .add ("<p>Default MicroTypeConverter implementation of {@link " + aClass.getFQInterfaceName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

  }
}
