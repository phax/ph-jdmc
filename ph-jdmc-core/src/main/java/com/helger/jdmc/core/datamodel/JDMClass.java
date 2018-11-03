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

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.string.StringHelper;

@NotThreadSafe
public class JDMClass
{
  private final String m_sPackageName;
  private final String m_sClassName;
  private final ICommonsList <JDMField> m_aFields = new CommonsArrayList <> ();

  @Nonnull
  @Nonempty
  public static String getFQCN (@Nonnull final String sPackageName, @Nonnull @Nonempty final String sClassName)
  {
    return (StringHelper.hasText (sPackageName) ? sPackageName + "." : "") + sClassName;
  }

  public JDMClass (@Nonnull final String sPackageName, @Nonnull @Nonempty final String sClassName)
  {
    m_sPackageName = sPackageName;
    m_sClassName = sClassName;
  }

  @Nonnull
  @Nonempty
  public String getPackageName ()
  {
    return m_sPackageName;
  }

  /**
   * @return The class name without a package.
   */
  @Nonnull
  @Nonempty
  public String getClassName ()
  {
    return m_sClassName;
  }

  @Nonnull
  @Nonempty
  public String getFQInterfaceName ()
  {
    return getFQCN (m_sPackageName, "I" + m_sClassName);
  }

  @Nonnull
  @Nonempty
  public String getFQClassName ()
  {
    return getFQCN (m_sPackageName, m_sClassName);
  }

  @Nonnull
  @ReturnsMutableObject
  public ICommonsList <JDMField> fields ()
  {
    return m_aFields;
  }
}
