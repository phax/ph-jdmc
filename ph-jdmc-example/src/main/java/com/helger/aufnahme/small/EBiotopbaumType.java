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
public enum EBiotopbaumType
  implements IHasID<String> , IHasDisplayName
{
  TOTHOLZ("dead", "Totholz (eindeutig)"),
  SPECIAL("special", "Sonderstrukturen"),
  TREE("tree", "m\u00e4chtiger Baum  / Uraltbaum (BHD)"),
  ALTERNATIVE("alt", "Anw\u00e4rter/Alternative f\u00fcr Netzwerk"),
  OTHER("other", "sonstiger Biotopbaum");
  private final String m_sID;
  private final String m_sDisplayName;

  private EBiotopbaumType(
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
  public static EBiotopbaumType getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EBiotopbaumType.class, sID);
  }

  @Nullable
  public static EBiotopbaumType getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EBiotopbaumType eDefault) {
    return EnumHelper.getFromIDOrDefault(EBiotopbaumType.class, sID, eDefault);
  }

  @Nonnull
  public static EBiotopbaumType getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EBiotopbaumType.class, sID);
  }
}
