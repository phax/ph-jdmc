/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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
package com.helger.aufnahme.small;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public enum EDeadwoodCategory
  implements IHasID<String> , IHasDisplayName
{
  CLASS1("c1", "Klasse I: stehend"),
  CLASS2("c2", "Klasse II: Baumrest stehend"),
  CLASS3("c3", "Klasse III: Hochstumpf (Baumrest zwischen 1 und 3 m hoch), st\u00fcrzt kaum mehr um"),
  CLASS4("c4", "Klasse IV: Stumpf, Stock (=<1m)"),
  CLASS5("c5", "Klasse V: Liegend, ganzer Baum"),
  CLASS6("c6", "Klasse VI: Baumrest liegend"),
  CLASS7("c7", "Klasse VII: Liegende Baumteile");
  private final String m_sID;
  private final String m_sDisplayName;

  private EDeadwoodCategory(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
  }

  @Nonnull
  @Nonempty
  public String getID() {
    return m_sID;
  }

  @Nonnull
  @Nonempty
  public String getDisplayName() {
    return m_sDisplayName;
  }

  @Nullable
  public static EDeadwoodCategory getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EDeadwoodCategory.class, sID);
  }

  @Nullable
  public static EDeadwoodCategory getFromIDOrDefault(@Nullable final String sID, @Nullable final EDeadwoodCategory eDefault) {
    return EnumHelper.getFromIDOrDefault(EDeadwoodCategory.class, sID, eDefault);
  }

  @Nonnull
  public static EDeadwoodCategory getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EDeadwoodCategory.class, sID);
  }
}
