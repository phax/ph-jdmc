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
public enum EHeight
  implements IHasID<String> , IHasDisplayName
{

  /**
   * Baumhöhen Klasse 1
   */
  ONE("1", "Klasse 1"),
  TWO("2", "Klasse 2"),
  THREE("3", "Klasse 3");
  private final String m_sID;
  private final String m_sDisplayName;

  private EHeight(
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
  public static EHeight getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EHeight.class, sID);
  }

  @Nullable
  public static EHeight getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EHeight eDefault) {
    return EnumHelper.getFromIDOrDefault(EHeight.class, sID, eDefault);
  }

  @Nonnull
  public static EHeight getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EHeight.class, sID);
  }
}
