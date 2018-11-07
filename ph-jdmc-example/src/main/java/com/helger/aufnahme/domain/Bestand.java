package com.helger.aufnahme.domain;

import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IBestand}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Bestand
  implements IBestand
{
  private int m_nBNr;
  private ICommonsList<UserDataObject> m_aPics;
  private LocalDate m_aDate;
  private String m_sVerortung;
  private ICommonsList<IHabitatbaumgruppe> m_aBZHBG;
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

  public final int getBNr() {
    return m_nBNr;
  }

  public final void setBNr(int nBNr) {
    m_nBNr = nBNr;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<UserDataObject> pics() {
    return m_aPics;
  }

  public final void setPics(
    @Nonnull
    @Nonempty
    ICommonsList<UserDataObject> aPics) {
    m_aPics = aPics;
  }

  @Nonnull
  public final LocalDate getDate() {
    return m_aDate;
  }

  public final void setDate(
    @Nonnull
    LocalDate aDate) {
    m_aDate = aDate;
  }

  @Nullable
  public final String getVerortung() {
    return m_sVerortung;
  }

  public final void setVerortung(
    @Nullable
    String sVerortung) {
    m_sVerortung = sVerortung;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IHabitatbaumgruppe> bZHBG() {
    return m_aBZHBG;
  }

  public final void setBZHBG(
    @Nonnull
    ICommonsList<IHabitatbaumgruppe> aBZHBG) {
    m_aBZHBG = aBZHBG;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  public final void setAreaSize(int nAreaSize) {
    m_nAreaSize = nAreaSize;
  }

  @Nonnull
  public final String getBeschreib() {
    return m_sBeschreib;
  }

  public final void setBeschreib(
    @Nonnull
    String sBeschreib) {
    m_sBeschreib = sBeschreib;
  }

  public final boolean isSameAge() {
    return m_bSameAge;
  }

  public final void setSameAge(boolean bSameAge) {
    m_bSameAge = bSameAge;
  }

  public final boolean isOneLevel() {
    return m_bOneLevel;
  }

  public final void setOneLevel(boolean bOneLevel) {
    m_bOneLevel = bOneLevel;
  }

  @Nonnull
  public final EStockType getStockType() {
    return m_eStockType;
  }

  public final void setStockType(
    @Nonnull
    EStockType eStockType) {
    m_eStockType = eStockType;
  }

  @Nonnull
  public final String getUsageDescription() {
    return m_sUsageDescription;
  }

  public final void setUsageDescription(
    @Nonnull
    String sUsageDescription) {
    m_sUsageDescription = sUsageDescription;
  }

  @Nonnull
  public final String getGesellschaft() {
    return m_sGesellschaft;
  }

  public final void setGesellschaft(
    @Nonnull
    String sGesellschaft) {
    m_sGesellschaft = sGesellschaft;
  }

  public final boolean isKronenschluss() {
    return m_bKronenschluss;
  }

  public final void setKronenschluss(boolean bKronenschluss) {
    m_bKronenschluss = bKronenschluss;
  }

  public final boolean isLightWoods() {
    return m_bLightWoods;
  }

  public final void setLightWoods(boolean bLightWoods) {
    m_bLightWoods = bLightWoods;
  }

  public final boolean isUnterwuchs() {
    return m_bUnterwuchs;
  }

  public final void setUnterwuchs(boolean bUnterwuchs) {
    m_bUnterwuchs = bUnterwuchs;
  }

  @Nonnull
  public final EStockDeadwood getTotSteh() {
    return m_eTotSteh;
  }

  public final void setTotSteh(
    @Nonnull
    EStockDeadwood eTotSteh) {
    m_eTotSteh = eTotSteh;
  }

  @Nonnull
  public final String getTotStehBesch() {
    return m_sTotStehBesch;
  }

  public final void setTotStehBesch(
    @Nonnull
    String sTotStehBesch) {
    m_sTotStehBesch = sTotStehBesch;
  }

  @Nonnull
  public final EStockDeadwood getTotLieg() {
    return m_eTotLieg;
  }

  public final void setTotLieg(
    @Nonnull
    EStockDeadwood eTotLieg) {
    m_eTotLieg = eTotLieg;
  }

  @Nonnull
  public final String getTotLiegBesch() {
    return m_sTotLiegBesch;
  }

  public final void setTotLiegBesch(
    @Nonnull
    String sTotLiegBesch) {
    m_sTotLiegBesch = sTotLiegBesch;
  }
}
