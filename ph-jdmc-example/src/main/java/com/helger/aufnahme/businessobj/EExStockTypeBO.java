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
public enum EExStockTypeBO
  implements IHasID<String> , IHasDisplayName
{
  _0("0", "keine Bestockung, aktuelle Schlagfl\u00e4che"),
  _1("1", "sp\u00e4rliche Verj\u00fcngung"),
  _2("2", "Jungwuchs (Verj\u00fcngung bis 1,3m)"),
  _3("3", "Dickung (beginnender Kronenschluss \u00fcber 1,3m; Holz <10 cm BHD"),
  _4("4", "Stangenholz (10-20 cm BHD)"),
  _5("5", "Baumholz (\u00fcber 20 cm BHD)"),
  _6("6", "Altholz (hiebsreif)"),
  _7("7", "Altholz verlichtet (schwach bestockt)"),
  _8("8", "Plenterwald (alle Bestandsklassem kommen auf kleinster Fl\u00e4che vor)"),
  OTHER("other", "Sonstiges");
  private final String m_sID;
  private final String m_sDisplayName;

  private EExStockTypeBO(
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
  public static EExStockTypeBO getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(EExStockTypeBO.class, sID);
  }

  @Nullable
  public static EExStockTypeBO getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final EExStockTypeBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExStockTypeBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExStockTypeBO getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(EExStockTypeBO.class, sID);
  }
}
