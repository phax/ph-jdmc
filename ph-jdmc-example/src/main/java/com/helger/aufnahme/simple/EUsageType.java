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
public enum EUsageType
  implements IHasID<String> , IHasDisplayName
{
  Hochwald("high", "Hochwald"),
  Mittelwald("med", "Mittelwald"),
  Niederwald("low", "Niederwald");
  private final String m_sID;
  private final String m_sDisplayName;

  private EUsageType(
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
  public static EUsageType getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EUsageType.class, sID);
  }

  @Nullable
  public static EUsageType getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EUsageType eDefault) {
    return EnumHelper.getFromIDOrDefault(EUsageType.class, sID, eDefault);
  }

  @Nonnull
  public static EUsageType getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EUsageType.class, sID);
  }
}
