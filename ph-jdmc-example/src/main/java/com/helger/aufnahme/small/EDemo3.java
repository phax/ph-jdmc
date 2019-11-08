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
public enum EDemo3
  implements IHasID<String> , IHasDisplayName
{
  ALPHA("a", "a"),
  RED("RED", "RED"),

  /**
   * The green part.
   */
  GREEN("g", "green"),
  BLUE("b", "blue");
  private final String m_sID;
  private final String m_sDisplayName;

  private EDemo3(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EDemo3 getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EDemo3 .class, sID);
  }

  @Nullable
  public static EDemo3 getFromIDOrDefault(@Nullable final String sID, @Nullable final EDemo3 eDefault) {
    return EnumHelper.getFromIDOrDefault(EDemo3 .class, sID, eDefault);
  }

  @Nonnull
  public static EDemo3 getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EDemo3 .class, sID);
  }
}
