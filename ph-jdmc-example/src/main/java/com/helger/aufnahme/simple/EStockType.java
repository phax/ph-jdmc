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
package com.helger.aufnahme.simple;

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
public enum EStockType
  implements IHasID<String> , IHasDisplayName
{
  _0("0", "keine Bestockung, aktuelle Schlagfl\u00e4che"),
  _1("1", "sp\u00e4rliche Verj\u00fcngung"),
  _2("2", "Jungwuchs (Verj\u00fcngung bis 1,3m)"),
  _3("3", "Dickung (beginnender Kronenschluss \u00fcber 1,3m; Holz <10 cm BHD"),
  _4("4", "Stangenholz (10-20 cm BHD)"),
  _5("5", "Baumholz (\u00fcber 20 cm BHD)"),
  _6("6", "Altholz (hiebsreif)"),
  _7("7", "Altholz verlichtet (schwach bestockt)"),
  _8("8", "Plenterwald (alle Bestandsklassem kommen auf kleinster Fl\u00e4che vor)"),
  OTHER("other", "Sonstiges");
  private final String m_sID;
  private final String m_sDisplayName;

  private EStockType(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EStockType getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EStockType.class, sID);
  }

  @Nullable
  public static EStockType getFromIDOrDefault(@Nullable final String sID, @Nullable final EStockType eDefault) {
    return EnumHelper.getFromIDOrDefault(EStockType.class, sID, eDefault);
  }

  @Nonnull
  public static EStockType getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EStockType.class, sID);
  }
}
