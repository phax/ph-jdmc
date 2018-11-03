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
package com.helger.jdmc.core;

import javax.annotation.Nonnull;

import com.helger.commons.ValueEnforcer;

public enum EJDMMultiplicity
{
  MANDATORY (""),
  OPTIONAL ("?"),
  MANDATORY_OR_MORE ("+"),
  OPTIONAL_OR_MORE ("*");

  private final String m_sSuffix;

  private EJDMMultiplicity (@Nonnull final String sSuffix)
  {
    m_sSuffix = sSuffix;
  }

  @Nonnull
  public String getSuffix ()
  {
    return m_sSuffix;
  }

  public boolean isMin0 ()
  {
    return this == OPTIONAL || this == OPTIONAL_OR_MORE;
  }

  public boolean isMin1 ()
  {
    return this == MANDATORY || this == MANDATORY_OR_MORE;
  }

  public boolean isMax1 ()
  {
    return this == MANDATORY || this == OPTIONAL;
  }

  public boolean isOpenEnded ()
  {
    return this == MANDATORY_OR_MORE || this == OPTIONAL_OR_MORE;
  }

  @Nonnull
  public static EJDMMultiplicity getFromTypeName (@Nonnull final String sTypeName)
  {
    ValueEnforcer.notNull (sTypeName, "TypeName");
    if (sTypeName.endsWith (OPTIONAL.getSuffix ()))
      return OPTIONAL;
    if (sTypeName.endsWith (MANDATORY_OR_MORE.getSuffix ()))
      return MANDATORY_OR_MORE;
    if (sTypeName.endsWith (OPTIONAL_OR_MORE.getSuffix ()))
      return OPTIONAL_OR_MORE;
    return MANDATORY;
  }
}
