/**
 * Copyright (C) 2018-2020 Philip Helger (www.helger.com)
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
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.CommonsLinkedHashSet;
import com.helger.commons.collection.impl.ICommonsIterable;
import com.helger.commons.collection.impl.ICommonsOrderedSet;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;

/**
 * Constraint types in relationship to the base types
 * 
 * @author Philip Helger
 */
public enum EJDMConstraintType implements IHasID <String>, IHasDisplayName
{
  MIN_LENGTH ("minLength", "Minimum length", EJDMConstraintDataType.INT_GE0, EJDMBaseType.STRING),
  MAX_LENGTH ("maxLength", "Maximum length", EJDMConstraintDataType.INT_GE0, EJDMBaseType.STRING),
  MIN_VALUE_INCL ("minInclusive",
                  "Minimum value (inclusive)",
                  EJDMConstraintDataType.DEPENDS_SINGLE_VALUE,
                  EJDMBaseType.INTEGER,
                  EJDMBaseType.DOUBLE,
                  EJDMBaseType.DATETIME),
  MIN_VALUE_EXCL ("minExclusive",
                  "Minimum value (exclusive)",
                  EJDMConstraintDataType.DEPENDS_SINGLE_VALUE,
                  EJDMBaseType.INTEGER,
                  EJDMBaseType.DOUBLE,
                  EJDMBaseType.DATETIME),
  MAX_VALUE_INCL ("maxInclusive",
                  "Maximum value (inclusive)",
                  EJDMConstraintDataType.DEPENDS_SINGLE_VALUE,
                  EJDMBaseType.INTEGER,
                  EJDMBaseType.DOUBLE,
                  EJDMBaseType.DATETIME),
  MAX_VALUE_EXCL ("maxExclusive",
                  "Maximum value (exclusive)",
                  EJDMConstraintDataType.DEPENDS_SINGLE_VALUE,
                  EJDMBaseType.INTEGER,
                  EJDMBaseType.DOUBLE,
                  EJDMBaseType.DATETIME),
  FRACTION_DIGITS ("fractionDigits", "Number of fraction digits", EJDMConstraintDataType.INT_GT0, EJDMBaseType.DOUBLE),
  PATTERN ("pattern", "Regular expression", EJDMConstraintDataType.STRING, EJDMBaseType.STRING);

  private final String m_sID;
  private final String m_sDisplayName;
  private final EJDMConstraintDataType m_eConstraintDataType;
  private final ICommonsOrderedSet <EJDMBaseType> m_aBaseTypesApplicableOn;

  private EJDMConstraintType (@Nonnull @Nonempty final String sID,
                              @Nonnull @Nonempty final String sDisplayName,
                              @Nonnull final EJDMConstraintDataType eConstraintDataType,
                              @Nonnull @Nonempty final EJDMBaseType... aBaseTypesApplicableOn)
  {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
    m_eConstraintDataType = eConstraintDataType;
    m_aBaseTypesApplicableOn = new CommonsLinkedHashSet <> (aBaseTypesApplicableOn);
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

  @Nonnull
  public EJDMConstraintDataType getConstraintDataType ()
  {
    return m_eConstraintDataType;
  }

  public boolean isApplicableOn (@Nullable final EJDMBaseType eBaseDataType)
  {
    return m_aBaseTypesApplicableOn.contains (eBaseDataType);
  }

  @Nonnull
  public ICommonsIterable <EJDMBaseType> getBaseTypesApplicableOn ()
  {
    return m_aBaseTypesApplicableOn;
  }

  @Nullable
  public static EJDMConstraintType findFirstForBaseType (@Nullable final EJDMBaseType eBaseType)
  {
    if (eBaseType != null)
      for (final EJDMConstraintType e : values ())
        if (e.isApplicableOn (eBaseType))
          return e;
    return null;
  }

  @Nullable
  public static EJDMConstraintType getFromIDOrNull (@Nullable final String sID)
  {
    return EnumHelper.getFromIDOrNull (EJDMConstraintType.class, sID);
  }

  @Nullable
  public static EJDMConstraintType getFromIDOrDefault (@Nullable final String sID,
                                                       @Nullable final EJDMConstraintType eDefault)
  {
    return EnumHelper.getFromIDOrDefault (EJDMConstraintType.class, sID, eDefault);
  }
}
