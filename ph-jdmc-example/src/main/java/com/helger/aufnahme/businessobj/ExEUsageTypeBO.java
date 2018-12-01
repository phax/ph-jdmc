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
public enum ExEUsageTypeBO
  implements IHasID<String> , IHasDisplayName
{
  Hochwald("high", "Hochwald"),
  Mittelwald("med", "Mittelwald"),
  Niederwald("low", "Niederwald");
  private final String m_sID;
  private final String m_sDisplayName;

  private ExEUsageTypeBO(
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
  public static ExEUsageTypeBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ExEUsageTypeBO.class, sID);
  }

  @Nullable
  public static ExEUsageTypeBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ExEUsageTypeBO eDefault) {
    return EnumHelper.getFromIDOrDefault(ExEUsageTypeBO.class, sID, eDefault);
  }

  @Nonnull
  public static ExEUsageTypeBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ExEUsageTypeBO.class, sID);
  }
}
