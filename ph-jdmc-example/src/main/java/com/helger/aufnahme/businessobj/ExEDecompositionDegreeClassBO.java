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
public enum ExEDecompositionDegreeClassBO
  implements IHasID<String> , IHasDisplayName
{
  CLASS0("c0", "Klasse 0"),
  CLASS1("c1", "Klasse 1"),
  CLASS2("c2", "Klasse 2"),
  CLASS3("c3", "Klasse 3"),
  CLASS4("c4", "Klasse 4");
  private final String m_sID;
  private final String m_sDisplayName;

  private ExEDecompositionDegreeClassBO(
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
  public static ExEDecompositionDegreeClassBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ExEDecompositionDegreeClassBO.class, sID);
  }

  @Nullable
  public static ExEDecompositionDegreeClassBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ExEDecompositionDegreeClassBO eDefault) {
    return EnumHelper.getFromIDOrDefault(ExEDecompositionDegreeClassBO.class, sID, eDefault);
  }

  @Nonnull
  public static ExEDecompositionDegreeClassBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ExEDecompositionDegreeClassBO.class, sID);
  }
}
