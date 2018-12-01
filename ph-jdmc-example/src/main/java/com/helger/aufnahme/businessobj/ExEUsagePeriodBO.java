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
public enum ExEUsagePeriodBO
  implements IHasID<String> , IHasDisplayName
{
  NONE("none", "keine"),
  HISTORIC("historic", "historisch"),
  CURRENT("current", "aktuell");
  private final String m_sID;
  private final String m_sDisplayName;

  private ExEUsagePeriodBO(
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
  public static ExEUsagePeriodBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ExEUsagePeriodBO.class, sID);
  }

  @Nullable
  public static ExEUsagePeriodBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ExEUsagePeriodBO eDefault) {
    return EnumHelper.getFromIDOrDefault(ExEUsagePeriodBO.class, sID, eDefault);
  }

  @Nonnull
  public static ExEUsagePeriodBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ExEUsagePeriodBO.class, sID);
  }
}
