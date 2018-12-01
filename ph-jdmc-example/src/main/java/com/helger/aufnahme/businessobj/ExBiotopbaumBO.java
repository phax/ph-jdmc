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
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExBiotopbaumBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumBO
  extends AbstractBusinessObject
  implements IExBiotopbaumBO
{
  public static final ObjectType OT = new ObjectType("ExBiotopbaumBO");
  private int m_nBBNr;
  private final ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private LocalDate m_aDate;
  private final ICommonsList<EExBiotopbaumTypeBO> m_eType = new CommonsArrayList<>();
  private String m_sLocation;
  private EExExpositionBO m_eExposition;
  private String m_sHanglage;
  private boolean m_bEinschichtig;
  private boolean m_bSolitary;
  private boolean m_bLightLocation;
  private boolean m_bClosedCrown;
  private boolean m_bNoSun;
  private boolean m_bUeberSun;
  private boolean m_bHomogene;
  private String m_sBeschreibung;
  private EExTreeKindBO m_eTreeKind;
  private final ICommonsList<IExCaveTypeBO> m_aCaves = new CommonsArrayList<>();
  private final ICommonsList<IExTrunkSizeBO> m_aTrunk = new CommonsArrayList<>();
  private EExVitalityBO m_eVitality;
  private final ICommonsList<EExSpecialStructureBO> m_eSpecialStructure = new CommonsArrayList<>();
  private String m_sOtherSpecial;
  private boolean m_bAspirant;
  private String m_sAspirantDesc;
  private boolean m_bMarked;
  private String m_sMarkedDesc;
  private final ICommonsList<IExBiotopbaumDeadwoodBO> m_aDeadwoodCats = new CommonsArrayList<>();
  private final ICommonsList<IExBiotopbaumDecompositionDegreeBO> m_aDeadwoodDoD = new CommonsArrayList<>();

  public ExBiotopbaumBO(final int nBBNr,
    @Nonnull
    @Nonempty
    final ICommonsList<File> aPics,
    @Nonnull
    final LocalDate aDate,
    @Nonnull
    @Nonempty
    final ICommonsList<EExBiotopbaumTypeBO> eType,
    @Nullable
    final String sLocation,
    @Nonnull
    final EExExpositionBO eExposition,
    @Nullable
    final String sHanglage, final boolean bEinschichtig, final boolean bSolitary, final boolean bLightLocation, final boolean bClosedCrown, final boolean bNoSun, final boolean bUeberSun, final boolean bHomogene,
    @Nonnull
    final String sBeschreibung,
    @Nonnull
    final EExTreeKindBO eTreeKind,
    @Nonnull
    final ICommonsList<IExCaveTypeBO> aCaves,
    @Nonnull
    @Nonempty
    final ICommonsList<IExTrunkSizeBO> aTrunk,
    @Nonnull
    final EExVitalityBO eVitality,
    @Nonnull
    final ICommonsList<EExSpecialStructureBO> eSpecialStructure,
    @Nullable
    final String sOtherSpecial, final boolean bAspirant,
    @Nullable
    final String sAspirantDesc, final boolean bMarked,
    @Nullable
    final String sMarkedDesc,
    @Nonnull
    final ICommonsList<IExBiotopbaumDeadwoodBO> aDeadwoodCats,
    @Nonnull
    final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD) {
    this(StubObject.createForCurrentUser(), nBBNr, aPics, aDate, eType, sLocation, eExposition, sHanglage, bEinschichtig, bSolitary, bLightLocation, bClosedCrown, bNoSun, bUeberSun, bHomogene, sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, eSpecialStructure, sOtherSpecial, bAspirant, sAspirantDesc, bMarked, sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
  }

  protected ExBiotopbaumBO(
    @Nonnull
    final StubObject aStubObject, final int nBBNr,
    @Nonnull
    @Nonempty
    final ICommonsList<File> aPics,
    @Nonnull
    final LocalDate aDate,
    @Nonnull
    @Nonempty
    final ICommonsList<EExBiotopbaumTypeBO> eType,
    @Nullable
    final String sLocation,
    @Nonnull
    final EExExpositionBO eExposition,
    @Nullable
    final String sHanglage, final boolean bEinschichtig, final boolean bSolitary, final boolean bLightLocation, final boolean bClosedCrown, final boolean bNoSun, final boolean bUeberSun, final boolean bHomogene,
    @Nonnull
    final String sBeschreibung,
    @Nonnull
    final EExTreeKindBO eTreeKind,
    @Nonnull
    final ICommonsList<IExCaveTypeBO> aCaves,
    @Nonnull
    @Nonempty
    final ICommonsList<IExTrunkSizeBO> aTrunk,
    @Nonnull
    final EExVitalityBO eVitality,
    @Nonnull
    final ICommonsList<EExSpecialStructureBO> eSpecialStructure,
    @Nullable
    final String sOtherSpecial, final boolean bAspirant,
    @Nullable
    final String sAspirantDesc, final boolean bMarked,
    @Nullable
    final String sMarkedDesc,
    @Nonnull
    final ICommonsList<IExBiotopbaumDeadwoodBO> aDeadwoodCats,
    @Nonnull
    final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD) {
    super(aStubObject);
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

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("BBNr", m_nBBNr).append("pics", m_aPics).append("date", m_aDate).append("type", m_eType).append("location", m_sLocation).append("exposition", m_eExposition).append("Hanglage", m_sHanglage).append("einschichtig", m_bEinschichtig).append("solitary", m_bSolitary).append("lightLocation", m_bLightLocation).append("closedCrown", m_bClosedCrown).append("noSun", m_bNoSun).append("ueberSun", m_bUeberSun).append("homogene", m_bHomogene).append("Beschreibung", m_sBeschreibung).append("treeKind", m_eTreeKind).append("caves", m_aCaves).append("trunk", m_aTrunk).append("vitality", m_eVitality).append("specialStructure", m_eSpecialStructure).append("otherSpecial", m_sOtherSpecial).append("aspirant", m_bAspirant).append("aspirantDesc", m_sAspirantDesc).append("marked", m_bMarked).append("markedDesc", m_sMarkedDesc).append("deadwoodCats", m_aDeadwoodCats).append("deadwoodDoD", m_aDeadwoodDoD).getToString();
  }

  public final int getBBNr() {
    return m_nBBNr;
  }

  @Nonnull
  final EChange setBBNr(final int nBBNr) {
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

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<EExBiotopbaumTypeBO> type() {
    return m_eType;
  }

  @Nonnull
  final EChange setType(
    @Nonnull
    @Nonempty
    final ICommonsList<EExBiotopbaumTypeBO> eType) {
    ValueEnforcer.notEmpty(eType, "Type");
    // Ensure the same implementation type
    final ICommonsList<EExBiotopbaumTypeBO> aRealList = new CommonsArrayList<>(eType);
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
  final EChange setLocation(
    @Nullable
    final String sLocation) {
    if (EqualsHelper.equals(sLocation, m_sLocation)) {
      return EChange.UNCHANGED;
    }
    m_sLocation = sLocation;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExExpositionBO getExposition() {
    return m_eExposition;
  }

  @Nonnull
  final EChange setExposition(
    @Nonnull
    final EExExpositionBO eExposition) {
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
  final EChange setHanglage(
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
  final EChange setEinschichtig(final boolean bEinschichtig) {
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
  final EChange setSolitary(final boolean bSolitary) {
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
  final EChange setLightLocation(final boolean bLightLocation) {
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
  final EChange setClosedCrown(final boolean bClosedCrown) {
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
  final EChange setNoSun(final boolean bNoSun) {
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
  final EChange setUeberSun(final boolean bUeberSun) {
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
  final EChange setHomogene(final boolean bHomogene) {
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
  final EChange setBeschreibung(
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
  public final EExTreeKindBO getTreeKind() {
    return m_eTreeKind;
  }

  @Nonnull
  final EChange setTreeKind(
    @Nonnull
    final EExTreeKindBO eTreeKind) {
    ValueEnforcer.notNull(eTreeKind, "TreeKind");
    if (eTreeKind.equals(m_eTreeKind)) {
      return EChange.UNCHANGED;
    }
    m_eTreeKind = eTreeKind;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IExCaveTypeBO> caves() {
    return m_aCaves;
  }

  @Nonnull
  final EChange setCaves(
    @Nonnull
    final ICommonsList<IExCaveTypeBO> aCaves) {
    ValueEnforcer.notNull(aCaves, "Caves");
    // Ensure the same implementation type
    final ICommonsList<IExCaveTypeBO> aRealList = new CommonsArrayList<>(aCaves);
    if (aRealList.equals(m_aCaves)) {
      return EChange.UNCHANGED;
    }
    m_aCaves.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<IExTrunkSizeBO> trunk() {
    return m_aTrunk;
  }

  @Nonnull
  final EChange setTrunk(
    @Nonnull
    @Nonempty
    final ICommonsList<IExTrunkSizeBO> aTrunk) {
    ValueEnforcer.notEmpty(aTrunk, "Trunk");
    // Ensure the same implementation type
    final ICommonsList<IExTrunkSizeBO> aRealList = new CommonsArrayList<>(aTrunk);
    if (aRealList.equals(m_aTrunk)) {
      return EChange.UNCHANGED;
    }
    m_aTrunk.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExVitalityBO getVitality() {
    return m_eVitality;
  }

  @Nonnull
  final EChange setVitality(
    @Nonnull
    final EExVitalityBO eVitality) {
    ValueEnforcer.notNull(eVitality, "Vitality");
    if (eVitality.equals(m_eVitality)) {
      return EChange.UNCHANGED;
    }
    m_eVitality = eVitality;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<EExSpecialStructureBO> specialStructure() {
    return m_eSpecialStructure;
  }

  @Nonnull
  final EChange setSpecialStructure(
    @Nonnull
    final ICommonsList<EExSpecialStructureBO> eSpecialStructure) {
    ValueEnforcer.notNull(eSpecialStructure, "SpecialStructure");
    // Ensure the same implementation type
    final ICommonsList<EExSpecialStructureBO> aRealList = new CommonsArrayList<>(eSpecialStructure);
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
  final EChange setOtherSpecial(
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
  final EChange setAspirant(final boolean bAspirant) {
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
  final EChange setAspirantDesc(
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
  final EChange setMarked(final boolean bMarked) {
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
  final EChange setMarkedDesc(
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
  public final ICommonsList<IExBiotopbaumDeadwoodBO> deadwoodCats() {
    return m_aDeadwoodCats;
  }

  @Nonnull
  final EChange setDeadwoodCats(
    @Nonnull
    final ICommonsList<IExBiotopbaumDeadwoodBO> aDeadwoodCats) {
    ValueEnforcer.notNull(aDeadwoodCats, "DeadwoodCats");
    // Ensure the same implementation type
    final ICommonsList<IExBiotopbaumDeadwoodBO> aRealList = new CommonsArrayList<>(aDeadwoodCats);
    if (aRealList.equals(m_aDeadwoodCats)) {
      return EChange.UNCHANGED;
    }
    m_aDeadwoodCats.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IExBiotopbaumDecompositionDegreeBO> deadwoodDoD() {
    return m_aDeadwoodDoD;
  }

  @Nonnull
  final EChange setDeadwoodDoD(
    @Nonnull
    final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD) {
    ValueEnforcer.notNull(aDeadwoodDoD, "DeadwoodDoD");
    // Ensure the same implementation type
    final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aRealList = new CommonsArrayList<>(aDeadwoodDoD);
    if (aRealList.equals(m_aDeadwoodDoD)) {
      return EChange.UNCHANGED;
    }
    m_aDeadwoodDoD.setAll(aRealList);
    return EChange.CHANGED;
  }
}
