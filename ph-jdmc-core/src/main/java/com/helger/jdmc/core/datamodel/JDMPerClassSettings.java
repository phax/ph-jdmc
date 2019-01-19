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
package com.helger.jdmc.core.datamodel;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.helger.commons.state.ETriState;
import com.helger.jdmc.core.codegen.JDMCodeGenSettings;

/**
 * Per-classType configuration. E.g. read from the <code>$config</code> key in a
 * JDM file.
 *
 * @author Philip Helger
 */
public class JDMPerClassSettings implements Serializable
{
  private ETriState m_eCreateManager = ETriState.UNDEFINED;
  private ETriState m_eUseBusinessObject = ETriState.UNDEFINED;

  public JDMPerClassSettings ()
  {}

  @Nonnull
  public ETriState getCreateManager ()
  {
    return m_eCreateManager;
  }

  @Nonnull
  public JDMPerClassSettings setCreateManager (final boolean b)
  {
    m_eCreateManager = ETriState.valueOf (b);
    return this;
  }

  @Nonnull
  public ETriState getUseBusinessObjects ()
  {
    return m_eUseBusinessObject;
  }

  @Nonnull
  public JDMPerClassSettings setUseBusinessObjects (final boolean b)
  {
    m_eUseBusinessObject = ETriState.valueOf (b);
    return this;
  }

  public void applyToSettings (@Nonnull final JDMCodeGenSettings aPerClassSettings)
  {
    if (m_eCreateManager.isDefined ())
      aPerClassSettings.setCreateManager (m_eCreateManager.getAsBooleanValue ());
    if (m_eUseBusinessObject.isDefined ())
      aPerClassSettings.setUseBusinessObject (m_eUseBusinessObject.getAsBooleanValue ());
  }
}