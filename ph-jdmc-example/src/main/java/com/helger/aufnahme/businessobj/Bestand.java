package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IBestand}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Bestand
  extends AbstractBusinessObject
  implements IBestand
{
  public static final ObjectType OT = new ObjectType("Bestand");
  private int m_nBNr;
  private ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private LocalDate m_aDate;
  private String m_sVerortung;
  private ICommonsList<IHabitatbaumgruppe> m_aBZHBG = new CommonsArrayList<>();
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
    this(StubObject.createForCurrentUser(), nBNr, aPics, aDate, sVerortung, aBZHBG, nAreaSize, sBeschreib, bSameAge, bOneLevel, eStockType, sUsageDescription, sGesellschaft, bKronenschluss, bLightWoods, bUnterwuchs, eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
  }

  protected Bestand(final StubObject aStubObject, final int nBNr,
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
    super(aStubObject);
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

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  public final int getBNr() {
    return m_nBNr;
  }

  @Nonnull
  public final EChange setBNr(final int nBNr) {
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
  public final EChange setPics(
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
  public final EChange setDate(
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
  public final EChange setVerortung(
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
  public final EChange setBZHBG(
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
  public final EChange setAreaSize(final int nAreaSize) {
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
  public final EChange setBeschreib(
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
  public final EChange setSameAge(final boolean bSameAge) {
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
  public final EChange setOneLevel(final boolean bOneLevel) {
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
  public final EChange setStockType(
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
  public final EChange setUsageDescription(
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
  public final EChange setGesellschaft(
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
  public final EChange setKronenschluss(final boolean bKronenschluss) {
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
  public final EChange setLightWoods(final boolean bLightWoods) {
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
  public final EChange setUnterwuchs(final boolean bUnterwuchs) {
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
  public final EChange setTotSteh(
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
  public final EChange setTotStehBesch(
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
  public final EChange setTotLieg(
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
  public final EChange setTotLiegBesch(
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
