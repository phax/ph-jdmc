package com.helger.aufnahme.domain;

import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IBiotopbaum}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Biotopbaum
  implements IBiotopbaum
{
  private int m_nBBNr;
  private ICommonsList<UserDataObject> m_aPics;
  private LocalDate m_aDate;
  private ICommonsList<EBiotopbaumType> m_eType;
  private String m_sLocation;
  private EExposition m_eExposition;
  private String m_sHanglage;
  private boolean m_bEinschichtig;
  private boolean m_bSolitary;
  private boolean m_bLightLocation;
  private boolean m_bClosedCrown;
  private boolean m_bNoSun;
  private boolean m_bUeberSun;
  private boolean m_bHomogene;
  private String m_sBeschreibung;
  private ETreeKind m_eTreeKind;
  private ICommonsList<ICaveType> m_aCaves;
  private ICommonsList<ITrunkSize> m_aTrunk;
  private EVitality m_eVitality;
  private ICommonsList<ESpecialStructure> m_eSpecialStructure;
  private String m_sOtherSpecial;
  private boolean m_bAspirant;
  private String m_sAspirantDesc;
  private boolean m_bMarked;
  private String m_sMarkedDesc;
  private ICommonsList<IBiotopbaumDeadwood> m_aDeadwoodCats;
  private ICommonsList<IBiotopbaumDecompositionDegree> m_aDeadwoodDoD;

  public final int getBBNr() {
    return m_nBBNr;
  }

  public final void setBBNr(int nBBNr) {
    m_nBBNr = nBBNr;
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

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<EBiotopbaumType> type() {
    return m_eType;
  }

  public final void setType(
    @Nonnull
    @Nonempty
    ICommonsList<EBiotopbaumType> eType) {
    m_eType = eType;
  }

  @Nullable
  public final String getLocation() {
    return m_sLocation;
  }

  public final void setLocation(
    @Nullable
    String sLocation) {
    m_sLocation = sLocation;
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

  public final boolean isEinschichtig() {
    return m_bEinschichtig;
  }

  public final void setEinschichtig(boolean bEinschichtig) {
    m_bEinschichtig = bEinschichtig;
  }

  public final boolean isSolitary() {
    return m_bSolitary;
  }

  public final void setSolitary(boolean bSolitary) {
    m_bSolitary = bSolitary;
  }

  public final boolean isLightLocation() {
    return m_bLightLocation;
  }

  public final void setLightLocation(boolean bLightLocation) {
    m_bLightLocation = bLightLocation;
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

  public final boolean isUeberSun() {
    return m_bUeberSun;
  }

  public final void setUeberSun(boolean bUeberSun) {
    m_bUeberSun = bUeberSun;
  }

  public final boolean isHomogene() {
    return m_bHomogene;
  }

  public final void setHomogene(boolean bHomogene) {
    m_bHomogene = bHomogene;
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

  @Nonnull
  public final ETreeKind getTreeKind() {
    return m_eTreeKind;
  }

  public final void setTreeKind(
    @Nonnull
    ETreeKind eTreeKind) {
    m_eTreeKind = eTreeKind;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<ICaveType> caves() {
    return m_aCaves;
  }

  public final void setCaves(
    @Nonnull
    ICommonsList<ICaveType> aCaves) {
    m_aCaves = aCaves;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<ITrunkSize> trunk() {
    return m_aTrunk;
  }

  public final void setTrunk(
    @Nonnull
    @Nonempty
    ICommonsList<ITrunkSize> aTrunk) {
    m_aTrunk = aTrunk;
  }

  @Nonnull
  public final EVitality getVitality() {
    return m_eVitality;
  }

  public final void setVitality(
    @Nonnull
    EVitality eVitality) {
    m_eVitality = eVitality;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<ESpecialStructure> specialStructure() {
    return m_eSpecialStructure;
  }

  public final void setSpecialStructure(
    @Nonnull
    ICommonsList<ESpecialStructure> eSpecialStructure) {
    m_eSpecialStructure = eSpecialStructure;
  }

  @Nullable
  public final String getOtherSpecial() {
    return m_sOtherSpecial;
  }

  public final void setOtherSpecial(
    @Nullable
    String sOtherSpecial) {
    m_sOtherSpecial = sOtherSpecial;
  }

  public final boolean isAspirant() {
    return m_bAspirant;
  }

  public final void setAspirant(boolean bAspirant) {
    m_bAspirant = bAspirant;
  }

  @Nullable
  public final String getAspirantDesc() {
    return m_sAspirantDesc;
  }

  public final void setAspirantDesc(
    @Nullable
    String sAspirantDesc) {
    m_sAspirantDesc = sAspirantDesc;
  }

  public final boolean isMarked() {
    return m_bMarked;
  }

  public final void setMarked(boolean bMarked) {
    m_bMarked = bMarked;
  }

  @Nullable
  public final String getMarkedDesc() {
    return m_sMarkedDesc;
  }

  public final void setMarkedDesc(
    @Nullable
    String sMarkedDesc) {
    m_sMarkedDesc = sMarkedDesc;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaumDeadwood> deadwoodCats() {
    return m_aDeadwoodCats;
  }

  public final void setDeadwoodCats(
    @Nonnull
    ICommonsList<IBiotopbaumDeadwood> aDeadwoodCats) {
    m_aDeadwoodCats = aDeadwoodCats;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaumDecompositionDegree> deadwoodDoD() {
    return m_aDeadwoodDoD;
  }

  public final void setDeadwoodDoD(
    @Nonnull
    ICommonsList<IBiotopbaumDecompositionDegree> aDeadwoodDoD) {
    m_aDeadwoodDoD = aDeadwoodDoD;
  }
}
