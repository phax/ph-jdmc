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
public enum EExStockDeadwoodBO
  implements IHasID<String> , IHasDisplayName
{
  _0("0", "keines"),
  _1("1", "wenig"),
  _2("2", "mittel"),
  _3("3", "viel"),
  _4("4", "sehr viel");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExStockDeadwoodBO(
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
  public static EExStockDeadwoodBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExStockDeadwoodBO.class, sID);
  }

  @Nullable
  public static EExStockDeadwoodBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExStockDeadwoodBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExStockDeadwoodBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExStockDeadwoodBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExStockDeadwoodBO.class, sID);
  }
}