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
public enum ExECaveClassBO
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "I"),
  TWO("2", "II"),
  THREE("3", "III");
  private final String m_sID;
  private final String m_sDisplayName;

  private ExECaveClassBO(
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
  public static ExECaveClassBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ExECaveClassBO.class, sID);
  }

  @Nullable
  public static ExECaveClassBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ExECaveClassBO eDefault) {
    return EnumHelper.getFromIDOrDefault(ExECaveClassBO.class, sID, eDefault);
  }

  @Nonnull
  public static ExECaveClassBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ExECaveClassBO.class, sID);
  }
}
