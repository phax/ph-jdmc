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
public enum EExposition
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

  private EExposition(
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
  public static EExposition getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExposition.class, sID);
  }

  @Nullable
  public static EExposition getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExposition eDefault) {
    return EnumHelper.getFromIDOrDefault(EExposition.class, sID, eDefault);
  }

  @Nonnull
  public static EExposition getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExposition.class, sID);
  }
}