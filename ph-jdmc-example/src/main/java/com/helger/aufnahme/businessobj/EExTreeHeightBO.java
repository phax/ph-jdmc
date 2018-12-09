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
public enum EExTreeHeightBO
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "Klasse 1"),
  TWO("2", "Klasse 2"),
  THREE("3", "Klasse 3");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExTreeHeightBO(
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
  public static EExTreeHeightBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExTreeHeightBO.class, sID);
  }

  @Nullable
  public static EExTreeHeightBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExTreeHeightBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExTreeHeightBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExTreeHeightBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExTreeHeightBO.class, sID);
  }
}