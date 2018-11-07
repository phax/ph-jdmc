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
public enum EVitality
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "vital (ganzheitlich gesund)"),
  TWO("2", "verminderte Vitalit\u00e4t"),
  THREE("3", "eindeutig absterbend"),
  FOUR("4", "tot");
  private final String m_sID;
  private final String m_sDisplayName;

  private EVitality(
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
  public static EVitality getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EVitality.class, sID);
  }

  @Nullable
  public static EVitality getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EVitality eDefault) {
    return EnumHelper.getFromIDOrDefault(EVitality.class, sID, eDefault);
  }

  @Nonnull
  public static EVitality getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EVitality.class, sID);
  }
}
