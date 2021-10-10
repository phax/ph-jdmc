/*
 * Copyright (C) 2018-2021 Philip Helger (www.helger.com)
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
package com.helger.jdmc.core.datamodel;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.helger.commons.state.ETriState;
import com.helger.jdmc.core.codegen.JDMCodeGenSettings;

/**
 * Per-classType configuration. E.g. read from the <code>$settings</code> key in
 * a JDM file.
 *
 * @author Philip Helger
 */
public class JDMGenClassSettings implements Serializable
{
  private ETriState m_eUseBusinessObject = ETriState.UNDEFINED;
  private ETriState m_eSetterArePackagePrivate = ETriState.UNDEFINED;
  private ETriState m_eCreateMicroTypeConverter = ETriState.UNDEFINED;
  private ETriState m_eCreateManager = ETriState.UNDEFINED;

  public JDMGenClassSettings ()
  {}

  @Nonnull
  public ETriState getUseBusinessObjects ()
  {
    return m_eUseBusinessObject;
  }

  @Nonnull
  public JDMGenClassSettings setUseBusinessObjects (final boolean b)
  {
    m_eUseBusinessObject = ETriState.valueOf (b);
    return this;
  }

  @Nonnull
  public ETriState getSetterArePackagePrivate ()
  {
    return m_eSetterArePackagePrivate;
  }

  @Nonnull
  public JDMGenClassSettings setSetterArePackagePrivate (final boolean b)
  {
    m_eSetterArePackagePrivate = ETriState.valueOf (b);
    return this;
  }

  @Nonnull
  public ETriState getCreateMicroTypeConverter ()
  {
    return m_eCreateMicroTypeConverter;
  }

  @Nonnull
  public JDMGenClassSettings setCreateMicroTypeConverter (final boolean b)
  {
    m_eCreateMicroTypeConverter = ETriState.valueOf (b);
    return this;
  }

  @Nonnull
  public ETriState getCreateManager ()
  {
    return m_eCreateManager;
  }

  @Nonnull
  public JDMGenClassSettings setCreateManager (final boolean b)
  {
    m_eCreateManager = ETriState.valueOf (b);
    return this;
  }

  public void applyToSettings (@Nonnull final JDMCodeGenSettings aPerClassSettings)
  {
    if (m_eUseBusinessObject.isDefined ())
      aPerClassSettings.setUseBusinessObject (m_eUseBusinessObject.getAsBooleanValue ());
    if (m_eSetterArePackagePrivate.isDefined ())
      aPerClassSettings.setSetterArePackagePrivate (m_eSetterArePackagePrivate.getAsBooleanValue ());
    if (m_eCreateMicroTypeConverter.isDefined ())
      aPerClassSettings.setCreateMicroTypeConverter (m_eCreateMicroTypeConverter.getAsBooleanValue ());
    if (m_eCreateManager.isDefined ())
      aPerClassSettings.setCreateManager (m_eCreateManager.getAsBooleanValue ());
  }
}
