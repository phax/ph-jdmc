package com.helger.postpone;

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
public enum EE
  implements IHasID<String> , IHasDisplayName
{
  ONE("1", "1"),
  TWO("2", "2"),
  THREE("3", "3"),
  FOUR("4", "4");
  private final String m_sID;
  private final String m_sDisplayName;

  private EE(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EE getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EE.class, sID);
  }

  @Nullable
  public static EE getFromIDOrDefault(@Nullable final String sID, @Nullable final EE eDefault) {
    return EnumHelper.getFromIDOrDefault(EE.class, sID, eDefault);
  }

  @Nonnull
  public static EE getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EE.class, sID);
  }
}
