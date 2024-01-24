/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.aufnahme.simple;

import java.io.File;
import java.time.LocalDate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

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


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IBiotopbaum}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Biotopbaum
  implements IBiotopbaum
{
  public static final ObjectType OT = new ObjectType("Biotopbaum");
  private int m_nBBNr;
  private final ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private LocalDate m_aDate;
  private final ICommonsList<EBiotopbaumType> m_aType = new CommonsArrayList<>();
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
  private final ICommonsList<ICaveType> m_aCaves = new CommonsArrayList<>();
  private final ICommonsList<ITrunkSize> m_aTrunk = new CommonsArrayList<>();
  private EVitality m_eVitality;
  private final ICommonsList<ESpecialStructure> m_aSpecialStructure = new CommonsArrayList<>();
  private String m_sOtherSpecial;
  private boolean m_bAspirant;
  private String m_sAspirantDesc;
  private boolean m_bMarked;
  private String m_sMarkedDesc;
  private final ICommonsList<IBiotopbaumDeadwood> m_aDeadwoodCats = new CommonsArrayList<>();
  private final ICommonsList<IBiotopbaumDecompositionDegree> m_aDeadwoodDoD = new CommonsArrayList<>();

  public Biotopbaum() {
  }

  public Biotopbaum(final int nBBNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    @Nonnull @Nonempty final ICommonsList<EBiotopbaumType> aType,
    @Nullable final String sLocation,
    @Nonnull final EExposition eExposition,
    @Nullable final String sHanglage,
    final boolean bEinschichtig,
    final boolean bSolitary,
    final boolean bLightLocation,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bUeberSun,
    final boolean bHomogene,
    @Nonnull final String sBeschreibung,
    @Nonnull final ETreeKind eTreeKind,
    @Nonnull final ICommonsList<ICaveType> aCaves,
    @Nonnull @Nonempty final ICommonsList<ITrunkSize> aTrunk,
    @Nonnull final EVitality eVitality,
    @Nonnull final ICommonsList<ESpecialStructure> aSpecialStructure,
    @Nullable final String sOtherSpecial,
    final boolean bAspirant,
    @Nullable final String sAspirantDesc,
    final boolean bMarked,
    @Nullable final String sMarkedDesc,
    @Nonnull final ICommonsList<IBiotopbaumDeadwood> aDeadwoodCats,
    @Nonnull final ICommonsList<IBiotopbaumDecompositionDegree> aDeadwoodDoD) {
    setBBNr(nBBNr);
    setPics(aPics);
    setDate(aDate);
    setType(aType);
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
    setSpecialStructure(aSpecialStructure);
    setOtherSpecial(sOtherSpecial);
    setAspirant(bAspirant);
    setAspirantDesc(sAspirantDesc);
    setMarked(bMarked);
    setMarkedDesc(sMarkedDesc);
    setDeadwoodCats(aDeadwoodCats);
    setDeadwoodDoD(aDeadwoodDoD);
  }

  public Biotopbaum(@Nonnull final IBiotopbaum aOther) {
    ValueEnforcer.notNull(aOther, "Other");
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

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final Biotopbaum rhs = ((Biotopbaum) o);
    if (!EqualsHelper.equals(m_nBBNr, rhs.m_nBBNr)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aPics, rhs.m_aPics)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aDate, rhs.m_aDate)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aType, rhs.m_aType)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sLocation, rhs.m_sLocation)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eExposition, rhs.m_eExposition)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sHanglage, rhs.m_sHanglage)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bEinschichtig, rhs.m_bEinschichtig)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bSolitary, rhs.m_bSolitary)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bLightLocation, rhs.m_bLightLocation)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bClosedCrown, rhs.m_bClosedCrown)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bNoSun, rhs.m_bNoSun)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bUeberSun, rhs.m_bUeberSun)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bHomogene, rhs.m_bHomogene)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sBeschreibung, rhs.m_sBeschreibung)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eTreeKind, rhs.m_eTreeKind)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aCaves, rhs.m_aCaves)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aTrunk, rhs.m_aTrunk)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eVitality, rhs.m_eVitality)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aSpecialStructure, rhs.m_aSpecialStructure)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sOtherSpecial, rhs.m_sOtherSpecial)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bAspirant, rhs.m_bAspirant)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sAspirantDesc, rhs.m_sAspirantDesc)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bMarked, rhs.m_bMarked)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sMarkedDesc, rhs.m_sMarkedDesc)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aDeadwoodCats, rhs.m_aDeadwoodCats)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aDeadwoodDoD, rhs.m_aDeadwoodDoD)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_nBBNr).append(m_aPics).append(m_aDate).append(m_aType).append(m_sLocation).append(m_eExposition).append(m_sHanglage).append(m_bEinschichtig).append(m_bSolitary).append(m_bLightLocation).append(m_bClosedCrown).append(m_bNoSun).append(m_bUeberSun).append(m_bHomogene).append(m_sBeschreibung).append(m_eTreeKind).append(m_aCaves).append(m_aTrunk).append(m_eVitality).append(m_aSpecialStructure).append(m_sOtherSpecial).append(m_bAspirant).append(m_sAspirantDesc).append(m_bMarked).append(m_sMarkedDesc).append(m_aDeadwoodCats).append(m_aDeadwoodDoD).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("BBNr", m_nBBNr).append("pics", m_aPics).append("date", m_aDate).append("type", m_aType).append("location", m_sLocation).append("exposition", m_eExposition).append("Hanglage", m_sHanglage).append("einschichtig", m_bEinschichtig).append("solitary", m_bSolitary).append("lightLocation", m_bLightLocation).append("closedCrown", m_bClosedCrown).append("noSun", m_bNoSun).append("ueberSun", m_bUeberSun).append("homogene", m_bHomogene).append("Beschreibung", m_sBeschreibung).append("treeKind", m_eTreeKind).append("caves", m_aCaves).append("trunk", m_aTrunk).append("vitality", m_eVitality).append("specialStructure", m_aSpecialStructure).append("otherSpecial", m_sOtherSpecial).append("aspirant", m_bAspirant).append("aspirantDesc", m_sAspirantDesc).append("marked", m_bMarked).append("markedDesc", m_sMarkedDesc).append("deadwoodCats", m_aDeadwoodCats).append("deadwoodDoD", m_aDeadwoodDoD).getToString();
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
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList<EBiotopbaumType> type() {
    return m_aType;
  }

  @Nonnull
  final EChange setType(@Nonnull @Nonempty final ICommonsList<EBiotopbaumType> aType) {
    ValueEnforcer.notEmpty(aType, "Type");
    // Ensure the same implementation type
    final ICommonsList<EBiotopbaumType> aRealList = new CommonsArrayList<>(aType);
    if (aRealList.equals(m_aType)) {
      return EChange.UNCHANGED;
    }
    m_aType.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nullable
  public final String getLocation() {
    return m_sLocation;
  }

  @Nonnull
  final EChange setLocation(@Nullable final String sLocation) {
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
  final EChange setBeschreibung(@Nonnull final String sBeschreibung) {
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
  final EChange setTreeKind(@Nonnull final ETreeKind eTreeKind) {
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
  final EChange setCaves(@Nonnull final ICommonsList<ICaveType> aCaves) {
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
  final EChange setTrunk(@Nonnull @Nonempty final ICommonsList<ITrunkSize> aTrunk) {
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
  final EChange setVitality(@Nonnull final EVitality eVitality) {
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
    return m_aSpecialStructure;
  }

  @Nonnull
  final EChange setSpecialStructure(@Nonnull final ICommonsList<ESpecialStructure> aSpecialStructure) {
    ValueEnforcer.notNull(aSpecialStructure, "SpecialStructure");
    // Ensure the same implementation type
    final ICommonsList<ESpecialStructure> aRealList = new CommonsArrayList<>(aSpecialStructure);
    if (aRealList.equals(m_aSpecialStructure)) {
      return EChange.UNCHANGED;
    }
    m_aSpecialStructure.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nullable
  public final String getOtherSpecial() {
    return m_sOtherSpecial;
  }

  @Nonnull
  final EChange setOtherSpecial(@Nullable final String sOtherSpecial) {
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
  final EChange setAspirantDesc(@Nullable final String sAspirantDesc) {
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
  final EChange setMarkedDesc(@Nullable final String sMarkedDesc) {
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
  final EChange setDeadwoodCats(@Nonnull final ICommonsList<IBiotopbaumDeadwood> aDeadwoodCats) {
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
  final EChange setDeadwoodDoD(@Nonnull final ICommonsList<IBiotopbaumDecompositionDegree> aDeadwoodDoD) {
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
