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
public enum ESpecialStructure
  implements IHasID<String> , IHasDisplayName
{
  _1("1", "mit Pilzbefall (z.B. Konsolen) (Anzahl)"),
  _2("2", "mit Verletzungen, sich l\u00f6sende Rinde (mindestens 50 % des Baumumfanges sollten betroffen sein)"),
  _3("3", "mit Verletzungen, sich l\u00f6sende Rinde (weniger als 50 % des Baumumfanges sollten betroffen sein)"),
  _4("4", "andere Verletzungen"),
  _5("5", "mit ausgebrochenem Zwiesel"),
  _6("6", "Spuren abgefallener \u00c4ste (noch kein Loch)"),
  _7("7", "Moos- Flechtenbewuchs > 25 % Stammbedeckung"),
  _8("8", "Schling- und Kletterpfanzenwuchs > 25 % Stammbedeckung"),
  _9("9", "markante Wuchsform (z.B. alter Hudebaum)"),
  _10("10", "Kennzeichen f\u00fcr Krankheiten oder schon absterbend "),
  _11("11", "fehlende, ausgebrochene Prim\u00e4rkrone ausgebrochener Krone (mind. 50 % der Krone m\u00fcssen fehlen )"),
  _12("12", "mit Bartflechten "),
  _13("13", "mit Epiphythen (Misteln)"),
  _14("14", "mit Rissbildung z.B. durch Blitzeinschlag"),
  _15("15", "keine Totholzanteile"),
  _16("16", "< 25 % Totholz"),
  _17("17", "Totholzanteil > 25% Anteil"),
  _18("18", "Totholzanteil in Krone"),
  _19("19", "Totholzanteil Stamm"),
  _20("20", "Totholzanteil Astmaterial (nicht Krone)"),
  _21("21", "Wurzelteller "),
  _22("22", "Saftflussstellen"),
  _23("23", "Grobborkigkeit");
  private final String m_sID;
  private final String m_sDisplayName;

  private ESpecialStructure(
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
  public static ESpecialStructure getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ESpecialStructure.class, sID);
  }

  @Nullable
  public static ESpecialStructure getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ESpecialStructure eDefault) {
    return EnumHelper.getFromIDOrDefault(ESpecialStructure.class, sID, eDefault);
  }

  @Nonnull
  public static ESpecialStructure getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ESpecialStructure.class, sID);
  }
}