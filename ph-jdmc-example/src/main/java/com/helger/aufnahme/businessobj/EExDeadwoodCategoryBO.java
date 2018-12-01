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
public enum EExDeadwoodCategoryBO
  implements IHasID<String> , IHasDisplayName
{
  CLASS1("c1", "Klasse I: stehend"),
  CLASS2("c2", "Klasse II: Baumrest stehend"),
  CLASS3("c3", "Klasse III: Hochstumpf (Baumrest zwischen 1 und 3 m hoch), st\u00fcrzt kaum mehr um"),
  CLASS4("c4", "Klasse IV: Stumpf, Stock (=<1m)"),
  CLASS5("c5", "Klasse V: Liegend, ganzer Baum"),
  CLASS6("c6", "Klasse VI: Baumrest liegend"),
  CLASS7("c7", "Klasse VII: Liegende Baumteile");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExDeadwoodCategoryBO(
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
  public static EExDeadwoodCategoryBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExDeadwoodCategoryBO.class, sID);
  }

  @Nullable
  public static EExDeadwoodCategoryBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExDeadwoodCategoryBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExDeadwoodCategoryBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExDeadwoodCategoryBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExDeadwoodCategoryBO.class, sID);
  }
}
