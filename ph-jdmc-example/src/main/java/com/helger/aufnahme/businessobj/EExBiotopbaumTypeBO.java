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
public enum EExBiotopbaumTypeBO
  implements IHasID<String> , IHasDisplayName
{
  TOTHOLZ("dead", "Totholz (eindeutig)"),
  SPECIAL("special", "Sonderstrukturen"),
  TREE("tree", "m\u00e4chtiger Baum  / Uraltbaum (BHD)"),
  ALTERNATIVE("alt", "Anw\u00e4rter/Alternative f\u00fcr Netzwerk"),
  OTHER("other", "sonstiger Biotopbaum");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExBiotopbaumTypeBO(
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
  public static EExBiotopbaumTypeBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExBiotopbaumTypeBO.class, sID);
  }

  @Nullable
  public static EExBiotopbaumTypeBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExBiotopbaumTypeBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExBiotopbaumTypeBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExBiotopbaumTypeBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExBiotopbaumTypeBO.class, sID);
  }
}
