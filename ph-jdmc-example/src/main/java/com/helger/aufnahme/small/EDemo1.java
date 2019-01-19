package com.helger.aufnahme.small;

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
public enum EDemo1
  implements IHasID<String> , IHasDisplayName
{
  RED("r", "r"),
  GREEN("g", "g"),
  BLUE("b", "b");
  private final String m_sID;
  private final String m_sDisplayName;

  private EDemo1(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EDemo1 getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EDemo1 .class, sID);
  }

  @Nullable
  public static EDemo1 getFromIDOrDefault(@Nullable final String sID, @Nullable final EDemo1 eDefault) {
    return EnumHelper.getFromIDOrDefault(EDemo1 .class, sID, eDefault);
  }

  @Nonnull
  public static EDemo1 getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EDemo1 .class, sID);
  }
}
