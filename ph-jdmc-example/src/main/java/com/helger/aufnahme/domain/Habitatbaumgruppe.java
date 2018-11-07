package com.helger.aufnahme.domain;

import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IHabitatbaumgruppe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Habitatbaumgruppe
  implements IHabitatbaumgruppe
{
  private int m_nHBGNr;
  private ICommonsList<UserDataObject> m_aPics;
  private ICommonsList<IBiotopbaum> m_aHBGzBB;
  private LocalDate m_aDate;
  private String m_sStandort;
  private boolean m_bOneLevel;
  private boolean m_bLight;
  private boolean m_bClosedCrown;
  private boolean m_bNoSun;
  private boolean m_bHomogen;
  private EExposition m_eExposition;
  private String m_sHanglage;
  private int m_nAreaSize;
  private boolean m_bOnlyBB;
  private String m_sBeschreibung;

  public final int getHBGNr() {
    return m_nHBGNr;
  }

  public final void setHBGNr(int nHBGNr) {
    m_nHBGNr = nHBGNr;
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
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaum> hBGzBB() {
    return m_aHBGzBB;
  }

  public final void setHBGzBB(
    @Nonnull
    ICommonsList<IBiotopbaum> aHBGzBB) {
    m_aHBGzBB = aHBGzBB;
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

  @Nonnull
  public final String getStandort() {
    return m_sStandort;
  }

  public final void setStandort(
    @Nonnull
    String sStandort) {
    m_sStandort = sStandort;
  }

  public final boolean isOneLevel() {
    return m_bOneLevel;
  }

  public final void setOneLevel(boolean bOneLevel) {
    m_bOneLevel = bOneLevel;
  }

  public final boolean isLight() {
    return m_bLight;
  }

  public final void setLight(boolean bLight) {
    m_bLight = bLight;
  }

  public final boolean isClosedCrown() {
    return m_bClosedCrown;
  }

  public final void setClosedCrown(boolean bClosedCrown) {
    m_bClosedCrown = bClosedCrown;
  }

  public final boolean isNoSun() {
    return m_bNoSun;
  }

  public final void setNoSun(boolean bNoSun) {
    m_bNoSun = bNoSun;
  }

  public final boolean isHomogen() {
    return m_bHomogen;
  }

  public final void setHomogen(boolean bHomogen) {
    m_bHomogen = bHomogen;
  }

  @Nonnull
  public final EExposition getExposition() {
    return m_eExposition;
  }

  public final void setExposition(
    @Nonnull
    EExposition eExposition) {
    m_eExposition = eExposition;
  }

  @Nullable
  public final String getHanglage() {
    return m_sHanglage;
  }

  public final void setHanglage(
    @Nullable
    String sHanglage) {
    m_sHanglage = sHanglage;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  public final void setAreaSize(int nAreaSize) {
    m_nAreaSize = nAreaSize;
  }

  public final boolean isOnlyBB() {
    return m_bOnlyBB;
  }

  public final void setOnlyBB(boolean bOnlyBB) {
    m_bOnlyBB = bOnlyBB;
  }

  @Nonnull
  public final String getBeschreibung() {
    return m_sBeschreibung;
  }

  public final void setBeschreibung(
    @Nonnull
    String sBeschreibung) {
    m_sBeschreibung = sBeschreibung;
  }
}
