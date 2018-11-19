package com.helger.aufnahme.simple;

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
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IBiotopbaum}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Biotopbaum
  implements IBiotopbaum
{
  public static final ObjectType OT = new ObjectType("Biotopbaum");
  private int m_nBBNr;
  private ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private LocalDate m_aDate;
  private ICommonsList<EBiotopbaumType> m_eType = new CommonsArrayList<>();
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
  private ICommonsList<ICaveType> m_aCaves = new CommonsArrayList<>();
  private ICommonsList<ITrunkSize> m_aTrunk = new CommonsArrayList<>();
  private EVitality m_eVitality;
  private ICommonsList<ESpecialStructure> m_eSpecialStructure = new CommonsArrayList<>();
  private String m_sOtherSpecial;
  private boolean m_bAspirant;
  private String m_sAspirantDesc;
  private boolean m_bMarked;
  private String m_sMarkedDesc;
  private ICommonsList<IBiotopbaumDeadwood> m_aDeadwoodCats = new CommonsArrayList<>();
  private ICommonsList<IBiotopbaumDecompositionDegree> m_aDeadwoodDoD = new CommonsArrayList<>();

  public Biotopbaum() {
  }

  public Biotopbaum(final int nBBNr,
    @Nonnull
    @Nonempty
    final ICommonsList<File> aPics,
    @Nonnull
    final LocalDate aDate,
    @Nonnull
    @Nonempty
    final ICommonsList<EBiotopbaumType> eType,
    @Nullable
    final String sLocation,
    @Nonnull
    final EExposition eExposition,
    @Nullable
    final String sHanglage, final boolean bEinschichtig, final boolean bSolitary, final boolean bLightLocation, final boolean bClosedCrown, final boolean bNoSun, final boolean bUeberSun, final boolean bHomogene,
    @Nonnull
    final String sBeschreibung,
    @Nonnull
    final ETreeKind eTreeKind,
    @Nonnull
    final ICommonsList<ICaveType> aCaves,
    @Nonnull
    @Nonempty
    final ICommonsList<ITrunkSize> aTrunk,
    @Nonnull
    final EVitality eVitality,
    @Nonnull
    final ICommonsList<ESpecialStructure> eSpecialStructure,
    @Nullable
    final String sOtherSpecial, final boolean bAspirant,
    @Nullable
    final String sAspirantDesc, final boolean bMarked,
    @Nullable
    final String sMarkedDesc,
    @Nonnull
    final ICommonsList<IBiotopbaumDeadwood> aDeadwoodCats,
    @Nonnull
    final ICommonsList<IBiotopbaumDecompositionDegree> aDeadwoodDoD) {
    setBBNr(nBBNr);
    setPics(aPics);
    setDate(aDate);
    setType(eType);
    setLocation(sLocation);
    setExposition(eExposition);
    setHanglage(sHanglage);
    setEinschichtig(bEinschichtig);
    setSolitary(bSolitary);
    setLightLocation(bLightLocation);
    setClosedCrown(bClosedCrown);
    setNoSun(bNoSun);
    setUeberSun(bUeberSun);
    setHomogene(bHomogene);
    setBeschreibung(sBeschreibung);
    setTreeKind(eTreeKind);
    setCaves(aCaves);
    setTrunk(aTrunk);
    setVitality(eVitality);
    setSpecialStructure(eSpecialStructure);
    setOtherSpecial(sOtherSpecial);
    setAspirant(bAspirant);
    setAspirantDesc(sAspirantDesc);
    setMarked(bMarked);
    setMarkedDesc(sMarkedDesc);
    setDeadwoodCats(aDeadwoodCats);
    setDeadwoodDoD(aDeadwoodDoD);
  }

  public Biotopbaum(
    @Nonnull
    final IBiotopbaum aOther) {
    setBBNr(aOther.getBBNr());
    setPics(aOther.pics());
    setDate(aOther.getDate());
    setType(aOther.type());
    setLocation(aOther.getLocation());
    setExposition(aOther.getExposition());
    setHanglage(aOther.getHanglage());
    setEinschichtig(aOther.isEinschichtig());
    setSolitary(aOther.isSolitary());
    setLightLocation(aOther.isLightLocation());
    setClosedCrown(aOther.isClosedCrown());
    setNoSun(aOther.isNoSun());
    setUeberSun(aOther.isUeberSun());
    setHomogene(aOther.isHomogene());
    setBeschreibung(aOther.getBeschreibung());
    setTreeKind(aOther.getTreeKind());
    setCaves(aOther.caves());
    setTrunk(aOther.trunk());
    setVitality(aOther.getVitality());
    setSpecialStructure(aOther.specialStructure());
    setOtherSpecial(aOther.getOtherSpecial());
    setAspirant(aOther.isAspirant());
    setAspirantDesc(aOther.getAspirantDesc());
    setMarked(aOther.isMarked());
    setMarkedDesc(aOther.getMarkedDesc());
    setDeadwoodCats(aOther.deadwoodCats());
    setDeadwoodDoD(aOther.deadwoodDoD());
  }

  public final int getBBNr() {
    return m_nBBNr;
  }

  @Nonnull
  public final EChange setBBNr(final int nBBNr) {
    if (nBBNr == m_nBBNr) {
      return EChange.UNCHANGED;
    }
    m_nBBNr = nBBNr;
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

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<EBiotopbaumType> type() {
    return m_eType;
  }

  @Nonnull
  public final EChange setType(
    @Nonnull
    @Nonempty
    final ICommonsList<EBiotopbaumType> eType) {
    ValueEnforcer.notEmpty(eType, "Type");
    // Ensure the same implementation type
    final ICommonsList<EBiotopbaumType> aRealList = new CommonsArrayList<>(eType);
    if (aRealList.equals(m_eType)) {
      return EChange.UNCHANGED;
    }
    m_eType.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nullable
  public final String getLocation() {
    return m_sLocation;
  }

  @Nonnull
  public final EChange setLocation(
    @Nullable
    final String sLocation) {
    if (EqualsHelper.equals(sLocation, m_sLocation)) {
      return EChange.UNCHANGED;
    }
    m_sLocation = sLocation;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExposition getExposition() {
    return m_eExposition;
  }

  @Nonnull
  public final EChange setExposition(
    @Nonnull
    final EExposition eExposition) {
    ValueEnforcer.notNull(eExposition, "Exposition");
    if (eExposition.equals(m_eExposition)) {
      return EChange.UNCHANGED;
    }
    m_eExposition = eExposition;
    return EChange.CHANGED;
  }

  @Nullable
  public final String getHanglage() {
    return m_sHanglage;
  }

  @Nonnull
  public final EChange setHanglage(
    @Nullable
    final String sHanglage) {
    if (EqualsHelper.equals(sHanglage, m_sHanglage)) {
      return EChange.UNCHANGED;
    }
    m_sHanglage = sHanglage;
    return EChange.CHANGED;
  }

  public final boolean isEinschichtig() {
    return m_bEinschichtig;
  }

  @Nonnull
  public final EChange setEinschichtig(final boolean bEinschichtig) {
    if (bEinschichtig == m_bEinschichtig) {
      return EChange.UNCHANGED;
    }
    m_bEinschichtig = bEinschichtig;
    return EChange.CHANGED;
  }

  public final boolean isSolitary() {
    return m_bSolitary;
  }

  @Nonnull
  public final EChange setSolitary(final boolean bSolitary) {
    if (bSolitary == m_bSolitary) {
      return EChange.UNCHANGED;
    }
    m_bSolitary = bSolitary;
    return EChange.CHANGED;
  }

  public final boolean isLightLocation() {
    return m_bLightLocation;
  }

  @Nonnull
  public final EChange setLightLocation(final boolean bLightLocation) {
    if (bLightLocation == m_bLightLocation) {
      return EChange.UNCHANGED;
    }
    m_bLightLocation = bLightLocation;
    return EChange.CHANGED;
  }

  public final boolean isClosedCrown() {
    return m_bClosedCrown;
  }

  @Nonnull
  public final EChange setClosedCrown(final boolean bClosedCrown) {
    if (bClosedCrown == m_bClosedCrown) {
      return EChange.UNCHANGED;
    }
    m_bClosedCrown = bClosedCrown;
    return EChange.CHANGED;
  }

  public final boolean isNoSun() {
    return m_bNoSun;
  }

  @Nonnull
  public final EChange setNoSun(final boolean bNoSun) {
    if (bNoSun == m_bNoSun) {
      return EChange.UNCHANGED;
    }
    m_bNoSun = bNoSun;
    return EChange.CHANGED;
  }

  public final boolean isUeberSun() {
    return m_bUeberSun;
  }

  @Nonnull
  public final EChange setUeberSun(final boolean bUeberSun) {
    if (bUeberSun == m_bUeberSun) {
      return EChange.UNCHANGED;
    }
    m_bUeberSun = bUeberSun;
    return EChange.CHANGED;
  }

  public final boolean isHomogene() {
    return m_bHomogene;
  }

  @Nonnull
  public final EChange setHomogene(final boolean bHomogene) {
    if (bHomogene == m_bHomogene) {
      return EChange.UNCHANGED;
    }
    m_bHomogene = bHomogene;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getBeschreibung() {
    return m_sBeschreibung;
  }

  @Nonnull
  public final EChange setBeschreibung(
    @Nonnull
    final String sBeschreibung) {
    ValueEnforcer.notNull(sBeschreibung, "Beschreibung");
    if (sBeschreibung.equals(m_sBeschreibung)) {
      return EChange.UNCHANGED;
    }
    m_sBeschreibung = sBeschreibung;
    return EChange.CHANGED;
  }

  @Nonnull
  public final ETreeKind getTreeKind() {
    return m_eTreeKind;
  }

  @Nonnull
  public final EChange setTreeKind(
    @Nonnull
    final ETreeKind eTreeKind) {
    ValueEnforcer.notNull(eTreeKind, "TreeKind");
    if (eTreeKind.equals(m_eTreeKind)) {
      return EChange.UNCHANGED;
    }
    m_eTreeKind = eTreeKind;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<ICaveType> caves() {
    return m_aCaves;
  }

  @Nonnull
  public final EChange setCaves(
    @Nonnull
    final ICommonsList<ICaveType> aCaves) {
    ValueEnforcer.notNull(aCaves, "Caves");
    // Ensure the same implementation type
    final ICommonsList<ICaveType> aRealList = new CommonsArrayList<>(aCaves);
    if (aRealList.equals(m_aCaves)) {
      return EChange.UNCHANGED;
    }
    m_aCaves.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<ITrunkSize> trunk() {
    return m_aTrunk;
  }

  @Nonnull
  public final EChange setTrunk(
    @Nonnull
    @Nonempty
    final ICommonsList<ITrunkSize> aTrunk) {
    ValueEnforcer.notEmpty(aTrunk, "Trunk");
    // Ensure the same implementation type
    final ICommonsList<ITrunkSize> aRealList = new CommonsArrayList<>(aTrunk);
    if (aRealList.equals(m_aTrunk)) {
      return EChange.UNCHANGED;
    }
    m_aTrunk.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  public final EVitality getVitality() {
    return m_eVitality;
  }

  @Nonnull
  public final EChange setVitality(
    @Nonnull
    final EVitality eVitality) {
    ValueEnforcer.notNull(eVitality, "Vitality");
    if (eVitality.equals(m_eVitality)) {
      return EChange.UNCHANGED;
    }
    m_eVitality = eVitality;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<ESpecialStructure> specialStructure() {
    return m_eSpecialStructure;
  }

  @Nonnull
  public final EChange setSpecialStructure(
    @Nonnull
    final ICommonsList<ESpecialStructure> eSpecialStructure) {
    ValueEnforcer.notNull(eSpecialStructure, "SpecialStructure");
    // Ensure the same implementation type
    final ICommonsList<ESpecialStructure> aRealList = new CommonsArrayList<>(eSpecialStructure);
    if (aRealList.equals(m_eSpecialStructure)) {
      return EChange.UNCHANGED;
    }
    m_eSpecialStructure.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nullable
  public final String getOtherSpecial() {
    return m_sOtherSpecial;
  }

  @Nonnull
  public final EChange setOtherSpecial(
    @Nullable
    final String sOtherSpecial) {
    if (EqualsHelper.equals(sOtherSpecial, m_sOtherSpecial)) {
      return EChange.UNCHANGED;
    }
    m_sOtherSpecial = sOtherSpecial;
    return EChange.CHANGED;
  }

  public final boolean isAspirant() {
    return m_bAspirant;
  }

  @Nonnull
  public final EChange setAspirant(final boolean bAspirant) {
    if (bAspirant == m_bAspirant) {
      return EChange.UNCHANGED;
    }
    m_bAspirant = bAspirant;
    return EChange.CHANGED;
  }

  @Nullable
  public final String getAspirantDesc() {
    return m_sAspirantDesc;
  }

  @Nonnull
  public final EChange setAspirantDesc(
    @Nullable
    final String sAspirantDesc) {
    if (EqualsHelper.equals(sAspirantDesc, m_sAspirantDesc)) {
      return EChange.UNCHANGED;
    }
    m_sAspirantDesc = sAspirantDesc;
    return EChange.CHANGED;
  }

  public final boolean isMarked() {
    return m_bMarked;
  }

  @Nonnull
  public final EChange setMarked(final boolean bMarked) {
    if (bMarked == m_bMarked) {
      return EChange.UNCHANGED;
    }
    m_bMarked = bMarked;
    return EChange.CHANGED;
  }

  @Nullable
  public final String getMarkedDesc() {
    return m_sMarkedDesc;
  }

  @Nonnull
  public final EChange setMarkedDesc(
    @Nullable
    final String sMarkedDesc) {
    if (EqualsHelper.equals(sMarkedDesc, m_sMarkedDesc)) {
      return EChange.UNCHANGED;
    }
    m_sMarkedDesc = sMarkedDesc;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaumDeadwood> deadwoodCats() {
    return m_aDeadwoodCats;
  }

  @Nonnull
  public final EChange setDeadwoodCats(
    @Nonnull
    final ICommonsList<IBiotopbaumDeadwood> aDeadwoodCats) {
    ValueEnforcer.notNull(aDeadwoodCats, "DeadwoodCats");
    // Ensure the same implementation type
    final ICommonsList<IBiotopbaumDeadwood> aRealList = new CommonsArrayList<>(aDeadwoodCats);
    if (aRealList.equals(m_aDeadwoodCats)) {
      return EChange.UNCHANGED;
    }
    m_aDeadwoodCats.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaumDecompositionDegree> deadwoodDoD() {
    return m_aDeadwoodDoD;
  }

  @Nonnull
  public final EChange setDeadwoodDoD(
    @Nonnull
    final ICommonsList<IBiotopbaumDecompositionDegree> aDeadwoodDoD) {
    ValueEnforcer.notNull(aDeadwoodDoD, "DeadwoodDoD");
    // Ensure the same implementation type
    final ICommonsList<IBiotopbaumDecompositionDegree> aRealList = new CommonsArrayList<>(aDeadwoodDoD);
    if (aRealList.equals(m_aDeadwoodDoD)) {
      return EChange.UNCHANGED;
    }
    m_aDeadwoodDoD.setAll(aRealList);
    return EChange.CHANGED;
  }
}
