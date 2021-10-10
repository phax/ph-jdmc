/*
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
public enum ETreeKind
  implements IHasID<String> , IHasDisplayName
{
  Bergahorn("Bergahorn", "Bergahorn"),
  Birke("Birke", "Birke"),
  Buche("Buche", "Buche"),
  Douglasie("Douglasie", "Douglasie"),
  Eberesche("Eberesche", "Eberesche"),
  EdelKastanie("EdelKastanie", "Edel-Kastanie"),
  Eiche("Eiche", "Eiche"),
  Fichte("Fichte", "Fichte"),
  Hainbuche("Hainbuche", "Hainbuche"),
  Kiefer("Kiefer", "Kiefer"),
  Kirsche("Kirsche", "Kirsche"),
  Linde("Linde", "Linde"),
  Laerche("Laerche", "L\u00e4rche"),
  Pappel("Pappel", "Pappel"),
  Robinie("Robinie", "Robinie"),
  RotEiche("Rot-Eiche", "Rot-Eiche"),
  Rosskastanie("RossKastanie", "Ro\u00dfKastanie"),
  Salweide("Salweide", "Salweide"),
  Silberweide("Silberweide", "Silberweide"),
  Spitzahorn("Spitzahorn", "Spitzahorn"),
  StielEiche("StielEiche", "Stiel-Eiche"),
  TraubenEiche("TraubenEiche", "Trauben-Eiche"),
  OTHER("other", "sonstiges");
  private final String m_sID;
  private final String m_sDisplayName;

  private ETreeKind(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static ETreeKind getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(ETreeKind.class, sID);
  }

  @Nullable
  public static ETreeKind getFromIDOrDefault(@Nullable final String sID, @Nullable final ETreeKind eDefault) {
    return EnumHelper.getFromIDOrDefault(ETreeKind.class, sID, eDefault);
  }

  @Nonnull
  public static ETreeKind getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(ETreeKind.class, sID);
  }
}
