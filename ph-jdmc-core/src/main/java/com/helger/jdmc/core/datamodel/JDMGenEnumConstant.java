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
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.string.StringHelper;

/**
 * Single enum constant.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMGenEnumConstant implements Serializable
{
  private final String m_sName;
  private final String m_sID;
  private final String m_sDisplayName;
  private final String m_sComment;

  public JDMGenEnumConstant (@Nonnull @Nonempty final String sName,
                             @Nonnull @Nonempty final String sID,
                             @Nonnull @Nonempty final String sDisplayName,
                             @Nullable final String sComment)
  {
    ValueEnforcer.notEmpty (sName, "Name");
    ValueEnforcer.notEmpty (sID, "ID");
    ValueEnforcer.notEmpty (sDisplayName, "DisplayName");
    m_sName = sName;
    m_sID = sID;
    m_sDisplayName = sDisplayName;
    m_sComment = sComment;
  }

  @Nonnull
  @Nonempty
  public String getName ()
  {
    return m_sName;
  }

  @Nonnull
  @Nonempty
  public String getID ()
  {
    return m_sID;
  }

  @Nonnull
  @Nonempty
  public String getDisplayName ()
  {
    return m_sDisplayName;
  }

  @Nullable
  public String getComment ()
  {
    return m_sComment;
  }

  public boolean hasComment ()
  {
    return StringHelper.hasText (m_sComment);
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final JDMGenEnumConstant rhs = (JDMGenEnumConstant) o;
    return m_sName.equals (rhs.m_sName);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sName).getHashCode ();
  }
}
