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
package com.helger.jdmc.core.datamodel;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.string.StringHelper;

@NotThreadSafe
public abstract class AbstractJDMType
{
  private final String m_sPackageName;
  private final String m_sClassName;

  @Nonnull
  @Nonempty
  public static String getFQCN (@Nonnull final String sPackageName, @Nonnull @Nonempty final String sClassName)
  {
    return (StringHelper.hasText (sPackageName) ? sPackageName + "." : "") + sClassName;
  }

  public AbstractJDMType (@Nonnull final String sPackageName, @Nonnull @Nonempty final String sClassName)
  {
    ValueEnforcer.notNull (sPackageName, "PackageName");
    ValueEnforcer.notEmpty (sClassName, "ClassName");
    m_sPackageName = sPackageName;
    m_sClassName = sClassName;
  }

  @Nonnull
  @Nonempty
  public final String getPackageName ()
  {
    return m_sPackageName;
  }

  /**
   * @return The class name without a package.
   */
  @Nonnull
  @Nonempty
  public final String getClassName ()
  {
    return m_sClassName;
  }

  @Nonnull
  @Nonempty
  public final String getFQInterfaceName ()
  {
    return getFQCN (m_sPackageName, "I" + m_sClassName);
  }

  @Nonnull
  @Nonempty
  public final String getFQClassName ()
  {
    return getFQCN (m_sPackageName, m_sClassName);
  }

  public final boolean isClass ()
  {
    return this instanceof JDMClass;
  }

  public final boolean isEnum ()
  {
    return this instanceof JDMEnum;
  }
}
