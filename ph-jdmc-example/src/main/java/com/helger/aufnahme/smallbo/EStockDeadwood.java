/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
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
package com.helger.aufnahme.smallbo;

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
public enum EStockDeadwood
  implements IHasID<String> , IHasDisplayName
{
  _0("0", "keines"),
  _1("1", "wenig"),
  _2("2", "mittel"),
  _3("3", "viel"),
  _4("4", "sehr viel");
  private final String m_sID;
  private final String m_sDisplayName;

  private EStockDeadwood(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EStockDeadwood getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EStockDeadwood.class, sID);
  }

  @Nullable
  public static EStockDeadwood getFromIDOrDefault(@Nullable final String sID, @Nullable final EStockDeadwood eDefault) {
    return EnumHelper.getFromIDOrDefault(EStockDeadwood.class, sID, eDefault);
  }

  @Nonnull
  public static EStockDeadwood getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EStockDeadwood.class, sID);
  }
}
