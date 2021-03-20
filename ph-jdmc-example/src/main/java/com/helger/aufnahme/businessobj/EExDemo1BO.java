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
public enum EExDemo1BO
  implements IHasID<String> , IHasDisplayName
{
  RED("r", "r"),
  GREEN("g", "g"),
  BLUE("b", "b");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExDemo1BO(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EExDemo1BO getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EExDemo1BO.class, sID);
  }

  @Nullable
  public static EExDemo1BO getFromIDOrDefault(@Nullable final String sID, @Nullable final EExDemo1BO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExDemo1BO.class, sID, eDefault);
  }

  @Nonnull
  public static EExDemo1BO getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EExDemo1BO.class, sID);
  }
}
