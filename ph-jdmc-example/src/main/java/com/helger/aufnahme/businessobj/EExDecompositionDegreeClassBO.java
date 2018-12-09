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
public enum EExDecompositionDegreeClassBO
  implements IHasID<String> , IHasDisplayName
{
  CLASS0("c0", "Klasse 0"),
  CLASS1("c1", "Klasse 1"),
  CLASS2("c2", "Klasse 2"),
  CLASS3("c3", "Klasse 3"),
  CLASS4("c4", "Klasse 4");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExDecompositionDegreeClassBO(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EExDecompositionDegreeClassBO getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EExDecompositionDegreeClassBO.class, sID);
  }

  @Nullable
  public static EExDecompositionDegreeClassBO getFromIDOrDefault(@Nullable final String sID, @Nullable final EExDecompositionDegreeClassBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExDecompositionDegreeClassBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExDecompositionDegreeClassBO getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EExDecompositionDegreeClassBO.class, sID);
  }
}
