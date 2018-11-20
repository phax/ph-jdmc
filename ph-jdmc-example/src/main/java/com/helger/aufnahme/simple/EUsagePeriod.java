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
public enum EUsagePeriod
  implements IHasID<String> , IHasDisplayName
{
  NONE("none", "keine"),
  HISTORIC("historic", "historisch"),
  CURRENT("current", "aktuell");
  private final String m_sID;
  private final String m_sDisplayName;

  private EUsagePeriod(
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
  public static EUsagePeriod getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EUsagePeriod.class, sID);
  }

  @Nullable
  public static EUsagePeriod getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EUsagePeriod eDefault) {
    return EnumHelper.getFromIDOrDefault(EUsagePeriod.class, sID, eDefault);
  }

  @Nonnull
  public static EUsagePeriod getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EUsagePeriod.class, sID);
  }
}
