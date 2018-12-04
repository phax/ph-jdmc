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

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.helger.tenancy.IBusinessObject;

public final class JDMCodeGenSettings implements Serializable
{
  private boolean m_bUseBusinessObject = false;
  private boolean m_bSetterArePackagePrivate = true;
  private boolean m_bReadExistingSPIFiles = false;

  public boolean isUseBusinessObject ()
  {
    return m_bUseBusinessObject;
  }

  /**
   * Should the {@link IBusinessObject} base interface etc. be used for the
   * created objects?
   *
   * @param bUseBusinessObject
   *        <code>true</code> to enable it, <code>false</code> to disable it.
   * @return this for chaining
   */
  @Nonnull
  public JDMCodeGenSettings setUseBusinessObject (final boolean bUseBusinessObject)
  {
    m_bUseBusinessObject = bUseBusinessObject;
    return this;
  }

  public boolean isSetterArePackagePrivate ()
  {
    return m_bSetterArePackagePrivate;
  }

  /**
   * Should the setter of the domain object implementation package private or
   * public.
   *
   * @param bSetterArePackagePrivate
   *        <code>true</code> for package private, <code>false</code> for
   *        public.
   * @return this for chaining
   */
  @Nonnull
  public JDMCodeGenSettings setSetterArePackagePrivate (final boolean bSetterArePackagePrivate)
  {
    m_bSetterArePackagePrivate = bSetterArePackagePrivate;
    return this;
  }

  public boolean isReadExistingSPIFiles ()
  {
    return m_bReadExistingSPIFiles;
  }

  /**
   * Should existing SPI META-INF/services files be read or not. By default this
   * does not happen.
   *
   * @param bReadExistingSPIFiles
   *        <code>true</code> to read them, <code>false</code> if not.
   * @return this for chaining
   */
  @Nonnull
  public JDMCodeGenSettings setReadExistingSPIFiles (final boolean bReadExistingSPIFiles)
  {
    m_bReadExistingSPIFiles = bReadExistingSPIFiles;
    return this;
  }
}
