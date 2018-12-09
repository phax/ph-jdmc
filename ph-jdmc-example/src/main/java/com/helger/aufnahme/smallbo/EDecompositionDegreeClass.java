package com.helger.aufnahme.smallbo;

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
public enum EDecompositionDegreeClass
  implements IHasID<String> , IHasDisplayName
{
  CLASS0("c0", "Klasse 0"),
  CLASS1("c1", "Klasse 1"),
  CLASS2("c2", "Klasse 2"),
  CLASS3("c3", "Klasse 3"),
  CLASS4("c4", "Klasse 4");
  private final String m_sID;
  private final String m_sDisplayName;

  private EDecompositionDegreeClass(
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
  public static EDecompositionDegreeClass getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EDecompositionDegreeClass.class, sID);
  }

  @Nullable
  public static EDecompositionDegreeClass getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EDecompositionDegreeClass eDefault) {
    return EnumHelper.getFromIDOrDefault(EDecompositionDegreeClass.class, sID, eDefault);
  }

  @Nonnull
  public static EDecompositionDegreeClass getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EDecompositionDegreeClass.class, sID);
  }
}
