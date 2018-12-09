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
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO.InitSettings;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;

@Immutable
final class JDMCodeGenManager
{
  private JDMCodeGenManager ()
  {}

  public static void createMainManagerClass (@Nonnull final JDMCodeGenSettings aSettings,
                                             @Nonnull final JDMCodeModel cm,
                                             @Nonnull final JDMClass aClass,
                                             @Nonnull final JDefinedClass jInterface,
                                             @Nonnull final JDefinedClass jDomainClass) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQManagerClassName (), EClassType.CLASS);
    jClass._extends (cm.ref (AbstractPhotonMapBasedWALDAO.class).narrow (jInterface, jDomainClass));
    jClass.javadoc ()
          .add ("<p>Default Manager implementation of for class {@link " + aClass.getFQClassName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add (JDMCodeGenerator.AUTHOR);

    // Constructor 1
    {
      final JMethod jCtor = jClass.constructor (JMod.PUBLIC);
      final JVar jParam = jCtor.param (JMod.FINAL, cm.ref (String.class), "sFilename");
      jParam.annotate (Nullable.class);
      jCtor._throws (DAOException.class);
      jCtor.body ().add (JInvocation._super ().arg (jDomainClass.dotclass ()).arg (jParam));
    }

    // Constructor 2
    {
      final JMethod jCtor = jClass.constructor (JMod.PUBLIC);
      final JVar jParam1 = jCtor.param (JMod.FINAL, cm.ref (String.class), "sFilename");
      jParam1.annotate (Nullable.class);
      final JVar jParam2 = jCtor.param (JMod.FINAL, cm.ref (InitSettings.class).narrow (jDomainClass), "aInitSettings");
      jParam2.annotate (Nonnull.class);
      jCtor._throws (DAOException.class);
      jCtor.body ().add (JInvocation._super ().arg (jDomainClass.dotclass ()).arg (jParam1).arg (jParam2));
    }

    // createMethod
    if (false)
    {
      final JMethod jCreate = jClass.method (JMod.PUBLIC | JMod.FINAL, jInterface, "create" + jDomainClass.name ());
      jCreate.annotate (Nonnull.class);
    }
  }
}
