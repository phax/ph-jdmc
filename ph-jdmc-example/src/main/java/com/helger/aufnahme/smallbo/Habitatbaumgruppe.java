package com.helger.aufnahme.smallbo;

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
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.smallbo.IHabitatbaumgruppe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Habitatbaumgruppe
  extends AbstractBusinessObject
  implements IHabitatbaumgruppe
{
  public static final ObjectType OT = new ObjectType("Habitatbaumgruppe");
  private int m_nHBGNr;
  private final ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private final ICommonsList<IBiotopbaum> m_aHBGzBB = new CommonsArrayList<>();
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

  public Habitatbaumgruppe(final int nHBGNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final ICommonsList<IBiotopbaum> aHBGzBB,
    @Nonnull final LocalDate aDate,
    @Nonnull final String sStandort,
    final boolean bOneLevel,
    final boolean bLight,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bHomogen,
    @Nonnull final EExposition eExposition,
    @Nullable final String sHanglage,
    final int nAreaSize,
    final boolean bOnlyBB,
    @Nonnull final String sBeschreibung) {
    this(StubObject.createForCurrentUser(), nHBGNr, aPics, aHBGzBB, aDate, sStandort, bOneLevel, bLight, bClosedCrown, bNoSun, bHomogen, eExposition, sHanglage, nAreaSize, bOnlyBB, sBeschreibung);
  }

  protected Habitatbaumgruppe(@Nonnull final StubObject aStubObject,
    final int nHBGNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final ICommonsList<IBiotopbaum> aHBGzBB,
    @Nonnull final LocalDate aDate,
    @Nonnull final String sStandort,
    final boolean bOneLevel,
    final boolean bLight,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bHomogen,
    @Nonnull final EExposition eExposition,
    @Nullable final String sHanglage,
    final int nAreaSize,
    final boolean bOnlyBB,
    @Nonnull final String sBeschreibung) {
    super(aStubObject);
    setHBGNr(nHBGNr);
    setPics(aPics);
    setHBGzBB(aHBGzBB);
    setDate(aDate);
    setStandort(sStandort);
    setOneLevel(bOneLevel);
    setLight(bLight);
    setClosedCrown(bClosedCrown);
    setNoSun(bNoSun);
    setHomogen(bHomogen);
    setExposition(eExposition);
    setHanglage(sHanglage);
    setAreaSize(nAreaSize);
    setOnlyBB(bOnlyBB);
    setBeschreibung(sBeschreibung);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("HBGNr", m_nHBGNr).append("pics", m_aPics).append("HBGzBB", m_aHBGzBB).append("date", m_aDate).append("Standort", m_sStandort).append("oneLevel", m_bOneLevel).append("light", m_bLight).append("closedCrown", m_bClosedCrown).append("noSun", m_bNoSun).append("homogen", m_bHomogen).append("exposition", m_eExposition).append("Hanglage", m_sHanglage).append("areaSize", m_nAreaSize).append("onlyBB", m_bOnlyBB).append("Beschreibung", m_sBeschreibung).getToString();
  }

  public final int getHBGNr() {
    return m_nHBGNr;
  }

  @Nonnull
  final EChange setHBGNr(final int nHBGNr) {
    if (nHBGNr == m_nHBGNr) {
      return EChange.UNCHANGED;
    }
    m_nHBGNr = nHBGNr;
    return EChange.CHANGED;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<File> pics() {
    return m_aPics;
  }

  @Nonnull
  final EChange setPics(@Nonnull @Nonempty final ICommonsList<File> aPics) {
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
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaum> HBGzBB() {
    return m_aHBGzBB;
  }

  @Nonnull
  final EChange setHBGzBB(@Nonnull final ICommonsList<IBiotopbaum> aHBGzBB) {
    ValueEnforcer.notNull(aHBGzBB, "HBGzBB");
    // Ensure the same implementation type
    final ICommonsList<IBiotopbaum> aRealList = new CommonsArrayList<>(aHBGzBB);
    if (aRealList.equals(m_aHBGzBB)) {
      return EChange.UNCHANGED;
    }
    m_aHBGzBB.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  public final LocalDate getDate() {
    return m_aDate;
  }

  @Nonnull
  final EChange setDate(@Nonnull final LocalDate aDate) {
    ValueEnforcer.notNull(aDate, "Date");
    if (aDate.equals(m_aDate)) {
      return EChange.UNCHANGED;
    }
    m_aDate = aDate;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getStandort() {
    return m_sStandort;
  }

  @Nonnull
  final EChange setStandort(@Nonnull final String sStandort) {
    ValueEnforcer.notNull(sStandort, "Standort");
    if (sStandort.equals(m_sStandort)) {
      return EChange.UNCHANGED;
    }
    m_sStandort = sStandort;
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

  public final boolean isLight() {
    return m_bLight;
  }

  @Nonnull
  final EChange setLight(final boolean bLight) {
    if (bLight == m_bLight) {
      return EChange.UNCHANGED;
    }
    m_bLight = bLight;
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

  public final boolean isHomogen() {
    return m_bHomogen;
  }

  @Nonnull
  final EChange setHomogen(final boolean bHomogen) {
    if (bHomogen == m_bHomogen) {
      return EChange.UNCHANGED;
    }
    m_bHomogen = bHomogen;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExposition getExposition() {
    return m_eExposition;
  }

  @Nonnull
  final EChange setExposition(@Nonnull final EExposition eExposition) {
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
  final EChange setHanglage(@Nullable final String sHanglage) {
    if (EqualsHelper.equals(sHanglage, m_sHanglage)) {
      return EChange.UNCHANGED;
    }
    m_sHanglage = sHanglage;
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

  public final boolean isOnlyBB() {
    return m_bOnlyBB;
  }

  @Nonnull
  final EChange setOnlyBB(final boolean bOnlyBB) {
    if (bOnlyBB == m_bOnlyBB) {
      return EChange.UNCHANGED;
    }
    m_bOnlyBB = bOnlyBB;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getBeschreibung() {
    return m_sBeschreibung;
  }

  @Nonnull
  final EChange setBeschreibung(@Nonnull final String sBeschreibung) {
    ValueEnforcer.notNull(sBeschreibung, "Beschreibung");
    if (sBeschreibung.equals(m_sBeschreibung)) {
      return EChange.UNCHANGED;
    }
    m_sBeschreibung = sBeschreibung;
    return EChange.CHANGED;
  }
}
