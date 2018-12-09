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
public enum EExVitalityBO
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "vital (ganzheitlich gesund)"),
  TWO("2", "verminderte Vitalit\u00e4t"),
  THREE("3", "eindeutig absterbend"),
  FOUR("4", "tot");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExVitalityBO(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EExVitalityBO getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EExVitalityBO.class, sID);
  }

  @Nullable
  public static EExVitalityBO getFromIDOrDefault(@Nullable final String sID, @Nullable final EExVitalityBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExVitalityBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExVitalityBO getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EExVitalityBO.class, sID);
  }
}
