package com.helger.aufnahme.businessobj;

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
public enum ExEExpositionBO
  implements IHasID<String> , IHasDisplayName
{
  N("n", "Norden"),
  NO("ne", "Nordosten"),
  O("e", "Osten"),
  SO("se", "S\u00fcdosten"),
  S("s", "S\u00fcden"),
  SW("sw", "S\u00fcdwesten"),
  W("w", "Westen"),
  NW("nw", "Nordwesten"),
  NONE("none", "keine"),
  VIA_GIS("gis", "\u00fcber GIS bestimmen");
  private final String m_sID;
  private final String m_sDisplayName;

  private ExEExpositionBO(
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
  public static ExEExpositionBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ExEExpositionBO.class, sID);
  }

  @Nullable
  public static ExEExpositionBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ExEExpositionBO eDefault) {
    return EnumHelper.getFromIDOrDefault(ExEExpositionBO.class, sID, eDefault);
  }

  @Nonnull
  public static ExEExpositionBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ExEExpositionBO.class, sID);
  }
}
