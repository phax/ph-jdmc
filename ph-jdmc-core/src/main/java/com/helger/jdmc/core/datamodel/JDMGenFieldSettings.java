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

/**
 * Per-field settings read from a JDM file.
 *
 * @author Philip Helger
 */
public class JDMGenFieldSettings implements Serializable
{
  private ETriState m_eIsReference = ETriState.UNDEFINED;

  public JDMGenFieldSettings ()
  {}

  @Nonnull
  public ETriState getIsReference ()
  {
    return m_eIsReference;
  }

  @Nonnull
  public JDMGenFieldSettings setIsReference (final boolean b)
  {
    m_eIsReference = ETriState.valueOf (b);
    return this;
  }
}
