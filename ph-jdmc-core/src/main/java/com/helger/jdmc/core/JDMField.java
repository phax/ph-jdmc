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

import java.util.Locale;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.string.StringHelper;

@NotThreadSafe
public class JDMField
{
  private final String m_sOriginalFieldName;
  private final String m_sFieldName;
  private final JDMType m_aType;
  private final EJDMMultiplicity m_eMultiplicity;
  private final String m_sComment;
  private final ICommonsList <JDMConstraint> m_aConstraints;

  @Nonnull
  @Nonempty
  private static String _getCleanedName (@Nonnull @Nonempty final String sStr)
  {
    // replace "_x" with "X"
    String s = sStr;
    while (true)
    {
      final int i = s.indexOf ('_');
      if (i < 0 || i == s.length () - 1)
        break;
      final char cNext = s.charAt (i + 1);
      if (Character.isLowerCase (cNext))
      {
        // "_x" => "X"
        s = s.substring (0, i) + Character.toUpperCase (cNext) + s.substring (i + 2);
      }
      else
      {
        // Cut "_"
        s = s.substring (0, i) + s.substring (i + 1);
      }
    }
    return s;
  }

  private static String _getStartUC (@Nonnull final String s)
  {
    if (s.length () == 1)
      return s.toUpperCase (Locale.ENGLISH);
    return Character.toUpperCase (s.charAt (0)) + s.substring (1);
  }

  private static String _getStartLC (@Nonnull final String s)
  {
    if (s.length () == 1)
      return s.toLowerCase (Locale.ENGLISH);
    return Character.toLowerCase (s.charAt (0)) + s.substring (1);
  }

  public JDMField (@Nonnull @Nonempty final String sFieldName,
                   @Nonnull final JDMType aType,
                   @Nonnull final EJDMMultiplicity eMultiplicity,
                   @Nullable final String sComment,
                   @Nullable final ICommonsList <JDMConstraint> aConstraints)
  {
    ValueEnforcer.notEmpty (sFieldName, "FieldName");
    ValueEnforcer.notNull (aType, "Type");
    ValueEnforcer.notNull (eMultiplicity, "Multiplicity");
    m_sOriginalFieldName = sFieldName;
    m_sFieldName = _getCleanedName (sFieldName);
    m_aType = aType;
    m_eMultiplicity = eMultiplicity;
    m_sComment = sComment;
    m_aConstraints = new CommonsArrayList <> (aConstraints);
  }

  /**
   * @return The original field name with all "_" contained.
   */
  @Nonnull
  @Nonempty
  public String getOriginalFieldName ()
  {
    return m_sOriginalFieldName;
  }

  /**
   * @return The cleaned field name without any "_" contained.
   */
  @Nonnull
  @Nonempty
  public String getFieldName ()
  {
    return m_sFieldName;
  }

  @Nonnull
  @Nonempty
  public String getGetterName (final boolean bIsOpenEnded)
  {
    if (bIsOpenEnded)
      return _getStartLC (m_sFieldName);

    return (m_aType.getBaseType ().isBoolean () ? "is" : "get") + _getStartUC (m_sFieldName);
  }

  @Nonnull
  @Nonempty
  public String getSetterName ()
  {
    return "set" + _getStartUC (m_sFieldName);
  }

  @Nonnull
  public JDMType getType ()
  {
    return m_aType;
  }

  @Nonnull
  public EJDMMultiplicity getMultiplicity ()
  {
    return m_eMultiplicity;
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

  @Nonnull
  @ReturnsMutableObject
  public ICommonsList <JDMConstraint> constraints ()
  {
    return m_aConstraints;
  }
}
