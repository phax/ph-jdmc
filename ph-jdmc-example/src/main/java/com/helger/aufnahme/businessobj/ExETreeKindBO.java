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
public enum ExETreeKindBO
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

  private ExETreeKindBO(
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
  public static ExETreeKindBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ExETreeKindBO.class, sID);
  }

  @Nullable
  public static ExETreeKindBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ExETreeKindBO eDefault) {
    return EnumHelper.getFromIDOrDefault(ExETreeKindBO.class, sID, eDefault);
  }

  @Nonnull
  public static ExETreeKindBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ExETreeKindBO.class, sID);
  }
}
