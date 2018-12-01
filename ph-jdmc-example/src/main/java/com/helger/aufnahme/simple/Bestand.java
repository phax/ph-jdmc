package com.helger.aufnahme.simple;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IBestand}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class Bestand
  implements IBestand
{
  public static final ObjectType OT = new ObjectType("Bestand");
  private int m_nBNr;
  private final ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private LocalDate m_aDate;
  private String m_sVerortung;
  private final ICommonsList<IHabitatbaumgruppe> m_aBZHBG = new CommonsArrayList<>();
  private int m_nAreaSize;
  private String m_sBeschreib;
  private boolean m_bSameAge;
  private boolean m_bOneLevel;
  private EStockType m_eStockType;
  private String m_sUsageDescription;
  private String m_sGesellschaft;
  private boolean m_bKronenschluss;
  private boolean m_bLightWoods;
  private boolean m_bUnterwuchs;
  private EStockDeadwood m_eTotSteh;
  private String m_sTotStehBesch;
  private EStockDeadwood m_eTotLieg;
  private String m_sTotLiegBesch;

  public Bestand() {
  }

  public Bestand(final int nBNr,
    @Nonnull
    @Nonempty
    final ICommonsList<File> aPics,
    @Nonnull
    final LocalDate aDate,
    @Nullable
    final String sVerortung,
    @Nonnull
    final ICommonsList<IHabitatbaumgruppe> aBZHBG, final int nAreaSize,
    @Nonnull
    final String sBeschreib, final boolean bSameAge, final boolean bOneLevel,
    @Nonnull
    final EStockType eStockType,
    @Nonnull
    final String sUsageDescription,
    @Nonnull
    final String sGesellschaft, final boolean bKronenschluss, final boolean bLightWoods, final boolean bUnterwuchs,
    @Nonnull
    final EStockDeadwood eTotSteh,
    @Nonnull
    final String sTotStehBesch,
    @Nonnull
    final EStockDeadwood eTotLieg,
    @Nonnull
    final String sTotLiegBesch) {
    setBNr(nBNr);
    setPics(aPics);
    setDate(aDate);
    setVerortung(sVerortung);
    setBZHBG(aBZHBG);
    setAreaSize(nAreaSize);
    setBeschreib(sBeschreib);
    setSameAge(bSameAge);
    setOneLevel(bOneLevel);
    setStockType(eStockType);
    setUsageDescription(sUsageDescription);
    setGesellschaft(sGesellschaft);
    setKronenschluss(bKronenschluss);
    setLightWoods(bLightWoods);
    setUnterwuchs(bUnterwuchs);
    setTotSteh(eTotSteh);
    setTotStehBesch(sTotStehBesch);
    setTotLieg(eTotLieg);
    setTotLiegBesch(sTotLiegBesch);
  }

  public Bestand(
    @Nonnull
    final IBestand aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setBNr(aOther.getBNr());
    setPics(aOther.pics());
    setDate(aOther.getDate());
    setVerortung(aOther.getVerortung());
    setBZHBG(aOther.bZHBG());
    setAreaSize(aOther.getAreaSize());
    setBeschreib(aOther.getBeschreib());
    setSameAge(aOther.isSameAge());
    setOneLevel(aOther.isOneLevel());
    setStockType(aOther.getStockType());
    setUsageDescription(aOther.getUsageDescription());
    setGesellschaft(aOther.getGesellschaft());
    setKronenschluss(aOther.isKronenschluss());
    setLightWoods(aOther.isLightWoods());
    setUnterwuchs(aOther.isUnterwuchs());
    setTotSteh(aOther.getTotSteh());
    setTotStehBesch(aOther.getTotStehBesch());
    setTotLieg(aOther.getTotLieg());
    setTotLiegBesch(aOther.getTotLiegBesch());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final Bestand rhs = ((Bestand) o);
    if (!EqualsHelper.equals(m_nBNr, rhs.m_nBNr)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aPics, rhs.m_aPics)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aDate, rhs.m_aDate)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sVerortung, rhs.m_sVerortung)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aBZHBG, rhs.m_aBZHBG)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nAreaSize, rhs.m_nAreaSize)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sBeschreib, rhs.m_sBeschreib)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bSameAge, rhs.m_bSameAge)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bOneLevel, rhs.m_bOneLevel)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eStockType, rhs.m_eStockType)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sUsageDescription, rhs.m_sUsageDescription)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sGesellschaft, rhs.m_sGesellschaft)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bKronenschluss, rhs.m_bKronenschluss)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bLightWoods, rhs.m_bLightWoods)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bUnterwuchs, rhs.m_bUnterwuchs)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eTotSteh, rhs.m_eTotSteh)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sTotStehBesch, rhs.m_sTotStehBesch)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eTotLieg, rhs.m_eTotLieg)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sTotLiegBesch, rhs.m_sTotLiegBesch)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_nBNr).append(m_aPics).append(m_aDate).append(m_sVerortung).append(m_aBZHBG).append(m_nAreaSize).append(m_sBeschreib).append(m_bSameAge).append(m_bOneLevel).append(m_eStockType).append(m_sUsageDescription).append(m_sGesellschaft).append(m_bKronenschluss).append(m_bLightWoods).append(m_bUnterwuchs).append(m_eTotSteh).append(m_sTotStehBesch).append(m_eTotLieg).append(m_sTotLiegBesch).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("BNr", m_nBNr).append("pics", m_aPics).append("date", m_aDate).append("Verortung", m_sVerortung).append("BZHBG", m_aBZHBG).append("areaSize", m_nAreaSize).append("Beschreib", m_sBeschreib).append("sameAge", m_bSameAge).append("oneLevel", m_bOneLevel).append("stockType", m_eStockType).append("usageDescription", m_sUsageDescription).append("Gesellschaft", m_sGesellschaft).append("Kronenschluss", m_bKronenschluss).append("lightWoods", m_bLightWoods).append("Unterwuchs", m_bUnterwuchs).append("TotSteh", m_eTotSteh).append("TotStehBesch", m_sTotStehBesch).append("TotLieg", m_eTotLieg).append("TotLiegBesch", m_sTotLiegBesch).getToString();
  }

  public final int getBNr() {
    return m_nBNr;
  }

  @Nonnull
  final EChange setBNr(final int nBNr) {
    if (nBNr == m_nBNr) {
      return EChange.UNCHANGED;
    }
    m_nBNr = nBNr;
    return EChange.CHANGED;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<File> pics() {
    return m_aPics;
  }

  @Nonnull
  final EChange setPics(
    @Nonnull
    @Nonempty
    final ICommonsList<File> aPics) {
    ValueEnforcer.notEmpty(aPics, "Pics");
    // Ensure the same implementation type
    final ICommonsList<File> aRealList = new CommonsArrayList<>(aPics);
    if (aRealList.equals(m_aPics)) {
      return EChange.UNCHANGED;
    }
    m_aPics.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  public final LocalDate getDate() {
    return m_aDate;
  }

  @Nonnull
  final EChange setDate(
    @Nonnull
    final LocalDate aDate) {
    ValueEnforcer.notNull(aDate, "Date");
    if (aDate.equals(m_aDate)) {
      return EChange.UNCHANGED;
    }
    m_aDate = aDate;
    return EChange.CHANGED;
  }

  @Nullable
  public final String getVerortung() {
    return m_sVerortung;
  }

  @Nonnull
  final EChange setVerortung(
    @Nullable
    final String sVerortung) {
    if (EqualsHelper.equals(sVerortung, m_sVerortung)) {
      return EChange.UNCHANGED;
    }
    m_sVerortung = sVerortung;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IHabitatbaumgruppe> bZHBG() {
    return m_aBZHBG;
  }

  @Nonnull
  final EChange setBZHBG(
    @Nonnull
    final ICommonsList<IHabitatbaumgruppe> aBZHBG) {
    ValueEnforcer.notNull(aBZHBG, "BZHBG");
    // Ensure the same implementation type
    final ICommonsList<IHabitatbaumgruppe> aRealList = new CommonsArrayList<>(aBZHBG);
    if (aRealList.equals(m_aBZHBG)) {
      return EChange.UNCHANGED;
    }
    m_aBZHBG.setAll(aRealList);
    return EChange.CHANGED;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  @Nonnull
  final EChange setAreaSize(final int nAreaSize) {
    if (nAreaSize == m_nAreaSize) {
      return EChange.UNCHANGED;
    }
    m_nAreaSize = nAreaSize;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getBeschreib() {
    return m_sBeschreib;
  }

  @Nonnull
  final EChange setBeschreib(
    @Nonnull
    final String sBeschreib) {
    ValueEnforcer.notNull(sBeschreib, "Beschreib");
    if (sBeschreib.equals(m_sBeschreib)) {
      return EChange.UNCHANGED;
    }
    m_sBeschreib = sBeschreib;
    return EChange.CHANGED;
  }

  public final boolean isSameAge() {
    return m_bSameAge;
  }

  @Nonnull
  final EChange setSameAge(final boolean bSameAge) {
    if (bSameAge == m_bSameAge) {
      return EChange.UNCHANGED;
    }
    m_bSameAge = bSameAge;
    return EChange.CHANGED;
  }

  public final boolean isOneLevel() {
    return m_bOneLevel;
  }

  @Nonnull
  final EChange setOneLevel(final boolean bOneLevel) {
    if (bOneLevel == m_bOneLevel) {
      return EChange.UNCHANGED;
    }
    m_bOneLevel = bOneLevel;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EStockType getStockType() {
    return m_eStockType;
  }

  @Nonnull
  final EChange setStockType(
    @Nonnull
    final EStockType eStockType) {
    ValueEnforcer.notNull(eStockType, "StockType");
    if (eStockType.equals(m_eStockType)) {
      return EChange.UNCHANGED;
    }
    m_eStockType = eStockType;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getUsageDescription() {
    return m_sUsageDescription;
  }

  @Nonnull
  final EChange setUsageDescription(
    @Nonnull
    final String sUsageDescription) {
    ValueEnforcer.notNull(sUsageDescription, "UsageDescription");
    if (sUsageDescription.equals(m_sUsageDescription)) {
      return EChange.UNCHANGED;
    }
    m_sUsageDescription = sUsageDescription;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getGesellschaft() {
    return m_sGesellschaft;
  }

  @Nonnull
  final EChange setGesellschaft(
    @Nonnull
    final String sGesellschaft) {
    ValueEnforcer.notNull(sGesellschaft, "Gesellschaft");
    if (sGesellschaft.equals(m_sGesellschaft)) {
      return EChange.UNCHANGED;
    }
    m_sGesellschaft = sGesellschaft;
    return EChange.CHANGED;
  }

  public final boolean isKronenschluss() {
    return m_bKronenschluss;
  }

  @Nonnull
  final EChange setKronenschluss(final boolean bKronenschluss) {
    if (bKronenschluss == m_bKronenschluss) {
      return EChange.UNCHANGED;
    }
    m_bKronenschluss = bKronenschluss;
    return EChange.CHANGED;
  }

  public final boolean isLightWoods() {
    return m_bLightWoods;
  }

  @Nonnull
  final EChange setLightWoods(final boolean bLightWoods) {
    if (bLightWoods == m_bLightWoods) {
      return EChange.UNCHANGED;
    }
    m_bLightWoods = bLightWoods;
    return EChange.CHANGED;
  }

  public final boolean isUnterwuchs() {
    return m_bUnterwuchs;
  }

  @Nonnull
  final EChange setUnterwuchs(final boolean bUnterwuchs) {
    if (bUnterwuchs == m_bUnterwuchs) {
      return EChange.UNCHANGED;
    }
    m_bUnterwuchs = bUnterwuchs;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EStockDeadwood getTotSteh() {
    return m_eTotSteh;
  }

  @Nonnull
  final EChange setTotSteh(
    @Nonnull
    final EStockDeadwood eTotSteh) {
    ValueEnforcer.notNull(eTotSteh, "TotSteh");
    if (eTotSteh.equals(m_eTotSteh)) {
      return EChange.UNCHANGED;
    }
    m_eTotSteh = eTotSteh;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getTotStehBesch() {
    return m_sTotStehBesch;
  }

  @Nonnull
  final EChange setTotStehBesch(
    @Nonnull
    final String sTotStehBesch) {
    ValueEnforcer.notNull(sTotStehBesch, "TotStehBesch");
    if (sTotStehBesch.equals(m_sTotStehBesch)) {
      return EChange.UNCHANGED;
    }
    m_sTotStehBesch = sTotStehBesch;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EStockDeadwood getTotLieg() {
    return m_eTotLieg;
  }

  @Nonnull
  final EChange setTotLieg(
    @Nonnull
    final EStockDeadwood eTotLieg) {
    ValueEnforcer.notNull(eTotLieg, "TotLieg");
    if (eTotLieg.equals(m_eTotLieg)) {
      return EChange.UNCHANGED;
    }
    m_eTotLieg = eTotLieg;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getTotLiegBesch() {
    return m_sTotLiegBesch;
  }

  @Nonnull
  final EChange setTotLiegBesch(
    @Nonnull
    final String sTotLiegBesch) {
    ValueEnforcer.notNull(sTotLiegBesch, "TotLiegBesch");
    if (sTotLiegBesch.equals(m_sTotLiegBesch)) {
      return EChange.UNCHANGED;
    }
    m_sTotLiegBesch = sTotLiegBesch;
    return EChange.CHANGED;
  }
}
