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
public enum EExCaveClassBO
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "I"),
  TWO("2", "II"),
  THREE("3", "III");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExCaveClassBO(
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
  public static EExCaveClassBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExCaveClassBO.class, sID);
  }

  @Nullable
  public static EExCaveClassBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExCaveClassBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExCaveClassBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExCaveClassBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExCaveClassBO.class, sID);
  }
}