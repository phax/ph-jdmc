/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
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
package com.helger.aufnahme.businessobj;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;


/**
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public enum EExVitalityBO
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "vital (ganzheitlich gesund)"),
  TWO("2", "verminderte Vitalit\u00e4t"),
  THREE("3", "eindeutig absterbend"),
  FOUR("4", "tot");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExVitalityBO(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EExVitalityBO getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EExVitalityBO.class, sID);
  }

  @Nullable
  public static EExVitalityBO getFromIDOrDefault(@Nullable final String sID, @Nullable final EExVitalityBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExVitalityBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExVitalityBO getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EExVitalityBO.class, sID);
  }
}
