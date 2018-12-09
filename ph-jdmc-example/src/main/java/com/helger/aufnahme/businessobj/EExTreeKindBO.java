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
public enum EExTreeKindBO
  implements IHasID<String> , IHasDisplayName
{
  Bergahorn("Bergahorn", "Bergahorn"),
  Birke("Birke", "Birke"),
  Buche("Buche", "Buche"),
  Douglasie("Douglasie", "Douglasie"),
  Eberesche("Eberesche", "Eberesche"),
  EdelKastanie("EdelKastanie", "Edel-Kastanie"),
  Eiche("Eiche", "Eiche"),
  Fichte("Fichte", "Fichte"),
  Hainbuche("Hainbuche", "Hainbuche"),
  Kiefer("Kiefer", "Kiefer"),
  Kirsche("Kirsche", "Kirsche"),
  Linde("Linde", "Linde"),
  Laerche("Laerche", "L\u00e4rche"),
  Pappel("Pappel", "Pappel"),
  Robinie("Robinie", "Robinie"),
  RotEiche("Rot-Eiche", "Rot-Eiche"),
  Rosskastanie("RossKastanie", "Ro\u00dfKastanie"),
  Salweide("Salweide", "Salweide"),
  Silberweide("Silberweide", "Silberweide"),
  Spitzahorn("Spitzahorn", "Spitzahorn"),
  StielEiche("StielEiche", "Stiel-Eiche"),
  TraubenEiche("TraubenEiche", "Trauben-Eiche"),
  OTHER("other", "sonstiges");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExTreeKindBO(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EExTreeKindBO getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EExTreeKindBO.class, sID);
  }

  @Nullable
  public static EExTreeKindBO getFromIDOrDefault(@Nullable final String sID, @Nullable final EExTreeKindBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExTreeKindBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExTreeKindBO getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EExTreeKindBO.class, sID);
  }
}
