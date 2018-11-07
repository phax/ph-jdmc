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
package com.helger.aufnahme.domain;

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
 * @author JDMProcessor
 */
public enum StichprobeDeadwood
  implements IHasID<String> , IHasDisplayName
{
  DoD("EDecompositionDegreeClass", "Zersetzungsgrad"),
  treeKind("ETreeKind", "Baumart laut Aufnahmeblatt"),
  length("int", "L\u00e4nge in cm"),
  BHD("int", "BHD bzw. Mittendurchmesser in cm");
  private final String m_sID;
  private final String m_sDisplayName;

  private StichprobeDeadwood(
    @Nonnull
    @Nonempty
    final String sID,
    @Nonnull
    @Nonempty
    final String sDisplayName) {
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
  public static StichprobeDeadwood getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(StichprobeDeadwood.class, sID);
  }

  @Nullable
  public static StichprobeDeadwood getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final StichprobeDeadwood eDefault) {
    return EnumHelper.getFromIDOrDefault(StichprobeDeadwood.class, sID, eDefault);
  }

  @Nonnull
  public static StichprobeDeadwood getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(StichprobeDeadwood.class, sID);
  }
}
