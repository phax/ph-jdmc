/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IStichprobe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Stichprobe
  implements IStichprobe
{
  public static final ObjectType OT = new ObjectType("Stichprobe");
  private int m_nStichNr;
  private IReservat m_aStichNrzR;
  private final ICommonsList<File> m_aPics = new CommonsArrayList<>();
  private LocalDate m_aDate;
  private int m_nSize;
  private EExposition m_eExposition;
  private String m_sHanglage;
  private String m_sGesellschaft;
  private double m_dBKL0;
  private double m_dBKL1;
  private double m_dBKL2;
  private double m_dBKL3;
  private double m_dBKL4;
  private double m_dBKL5;
  private double m_dBKL6;
  private double m_dBKL7;
  private double m_dBKL8;
  private double m_dBKL9;
  private String m_sUsage;
  private String m_sUsageDesc;
  private final ICommonsList<IBiotopbaum> m_aTrees = new CommonsArrayList<>();
  private String m_sDesc;
  private boolean m_bSameAge;
  private boolean m_bOneLevel;
  private final ICommonsList<IStichprobeDeadwood> m_aTotSteh = new CommonsArrayList<>();
  private final ICommonsList<IStichprobeDeadwood> m_aTotLieg1 = new CommonsArrayList<>();
  private final ICommonsList<IStichprobeDeadwood> m_aTotLieg2 = new CommonsArrayList<>();

  public Stichprobe() {
  }

  public Stichprobe(final int nStichNr,
    @Nonnull final IReservat aStichNrzR,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    final int nSize,
    @Nonnull final EExposition eExposition,
    @Nullable final String sHanglage,
    @Nonnull final String sGesellschaft,
    final double dBKL0,
    final double dBKL1,
    final double dBKL2,
    final double dBKL3,
    final double dBKL4,
    final double dBKL5,
    final double dBKL6,
    final double dBKL7,
    final double dBKL8,
    final double dBKL9,
    @Nonnull final String sUsage,
    @Nonnull final String sUsageDesc,
    @Nonnull final ICommonsList<IBiotopbaum> aTrees,
    @Nonnull final String sDesc,
    final boolean bSameAge,
    final boolean bOneLevel,
    @Nonnull final ICommonsList<IStichprobeDeadwood> aTotSteh,
    @Nonnull final ICommonsList<IStichprobeDeadwood> aTotLieg1,
    @Nonnull final ICommonsList<IStichprobeDeadwood> aTotLieg2) {
    setStichNr(nStichNr);
    setStichNrzR(aStichNrzR);
    setPics(aPics);
    setDate(aDate);
    setSize(nSize);
    setExposition(eExposition);
    setHanglage(sHanglage);
    setGesellschaft(sGesellschaft);
    setBKL0(dBKL0);
    setBKL1(dBKL1);
    setBKL2(dBKL2);
    setBKL3(dBKL3);
    setBKL4(dBKL4);
    setBKL5(dBKL5);
    setBKL6(dBKL6);
    setBKL7(dBKL7);
    setBKL8(dBKL8);
    setBKL9(dBKL9);
    setUsage(sUsage);
    setUsageDesc(sUsageDesc);
    setTrees(aTrees);
    setDesc(sDesc);
    setSameAge(bSameAge);
    setOneLevel(bOneLevel);
    setTotSteh(aTotSteh);
    setTotLieg1(aTotLieg1);
    setTotLieg2(aTotLieg2);
  }

  public Stichprobe(@Nonnull final IStichprobe aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setStichNr(aOther.getStichNr());
    setStichNrzR(aOther.getStichNrzR());
    setPics(aOther.pics());
    setDate(aOther.getDate());
    setSize(aOther.getSize());
    setExposition(aOther.getExposition());
    setHanglage(aOther.getHanglage());
    setGesellschaft(aOther.getGesellschaft());
    setBKL0(aOther.getBKL0());
    setBKL1(aOther.getBKL1());
    setBKL2(aOther.getBKL2());
    setBKL3(aOther.getBKL3());
    setBKL4(aOther.getBKL4());
    setBKL5(aOther.getBKL5());
    setBKL6(aOther.getBKL6());
    setBKL7(aOther.getBKL7());
    setBKL8(aOther.getBKL8());
    setBKL9(aOther.getBKL9());
    setUsage(aOther.getUsage());
    setUsageDesc(aOther.getUsageDesc());
    setTrees(aOther.trees());
    setDesc(aOther.getDesc());
    setSameAge(aOther.isSameAge());
    setOneLevel(aOther.isOneLevel());
    setTotSteh(aOther.totSteh());
    setTotLieg1(aOther.totLieg1());
    setTotLieg2(aOther.totLieg2());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final Stichprobe rhs = ((Stichprobe) o);
    if (!EqualsHelper.equals(m_nStichNr, rhs.m_nStichNr)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aStichNrzR, rhs.m_aStichNrzR)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aPics, rhs.m_aPics)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aDate, rhs.m_aDate)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nSize, rhs.m_nSize)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eExposition, rhs.m_eExposition)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sHanglage, rhs.m_sHanglage)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sGesellschaft, rhs.m_sGesellschaft)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL0, rhs.m_dBKL0)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL1, rhs.m_dBKL1)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL2, rhs.m_dBKL2)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL3, rhs.m_dBKL3)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL4, rhs.m_dBKL4)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL5, rhs.m_dBKL5)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL6, rhs.m_dBKL6)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL7, rhs.m_dBKL7)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL8, rhs.m_dBKL8)) {
      return false;
    }
    if (!EqualsHelper.equals(m_dBKL9, rhs.m_dBKL9)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sUsage, rhs.m_sUsage)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sUsageDesc, rhs.m_sUsageDesc)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aTrees, rhs.m_aTrees)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sDesc, rhs.m_sDesc)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bSameAge, rhs.m_bSameAge)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bOneLevel, rhs.m_bOneLevel)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aTotSteh, rhs.m_aTotSteh)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aTotLieg1, rhs.m_aTotLieg1)) {
      return false;
    }
    if (!EqualsHelper.equals(m_aTotLieg2, rhs.m_aTotLieg2)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_nStichNr).append(m_aStichNrzR).append(m_aPics).append(m_aDate).append(m_nSize).append(m_eExposition).append(m_sHanglage).append(m_sGesellschaft).append(m_dBKL0).append(m_dBKL1).append(m_dBKL2).append(m_dBKL3).append(m_dBKL4).append(m_dBKL5).append(m_dBKL6).append(m_dBKL7).append(m_dBKL8).append(m_dBKL9).append(m_sUsage).append(m_sUsageDesc).append(m_aTrees).append(m_sDesc).append(m_bSameAge).append(m_bOneLevel).append(m_aTotSteh).append(m_aTotLieg1).append(m_aTotLieg2).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("StichNr", m_nStichNr).append("StichNrzR", m_aStichNrzR).append("pics", m_aPics).append("date", m_aDate).append("size", m_nSize).append("exposition", m_eExposition).append("Hanglage", m_sHanglage).append("Gesellschaft", m_sGesellschaft).append("BKL0", m_dBKL0).append("BKL1", m_dBKL1).append("BKL2", m_dBKL2).append("BKL3", m_dBKL3).append("BKL4", m_dBKL4).append("BKL5", m_dBKL5).append("BKL6", m_dBKL6).append("BKL7", m_dBKL7).append("BKL8", m_dBKL8).append("BKL9", m_dBKL9).append("usage", m_sUsage).append("usageDesc", m_sUsageDesc).append("trees", m_aTrees).append("desc", m_sDesc).append("sameAge", m_bSameAge).append("oneLevel", m_bOneLevel).append("TotSteh", m_aTotSteh).append("TotLieg1", m_aTotLieg1).append("TotLieg2", m_aTotLieg2).getToString();
  }

  public final int getStichNr() {
    return m_nStichNr;
  }

  @Nonnull
  final EChange setStichNr(final int nStichNr) {
    if (nStichNr == m_nStichNr) {
      return EChange.UNCHANGED;
    }
    m_nStichNr = nStichNr;
    return EChange.CHANGED;
  }

  @Nonnull
  public final IReservat getStichNrzR() {
    return m_aStichNrzR;
  }

  @Nonnull
  final EChange setStichNrzR(@Nonnull final IReservat aStichNrzR) {
    ValueEnforcer.notNull(aStichNrzR, "StichNrzR");
    if (aStichNrzR.equals(m_aStichNrzR)) {
      return EChange.UNCHANGED;
    }
    m_aStichNrzR = aStichNrzR;
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

  public final int getSize() {
    return m_nSize;
  }

  @Nonnull
  final EChange setSize(final int nSize) {
    if (nSize == m_nSize) {
      return EChange.UNCHANGED;
    }
    m_nSize = nSize;
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

  @Nonnull
  public final String getGesellschaft() {
    return m_sGesellschaft;
  }

  @Nonnull
  final EChange setGesellschaft(@Nonnull final String sGesellschaft) {
    ValueEnforcer.notNull(sGesellschaft, "Gesellschaft");
    if (sGesellschaft.equals(m_sGesellschaft)) {
      return EChange.UNCHANGED;
    }
    m_sGesellschaft = sGesellschaft;
    return EChange.CHANGED;
  }

  public final double getBKL0() {
    return m_dBKL0;
  }

  @Nonnull
  final EChange setBKL0(final double dBKL0) {
    if (dBKL0 == m_dBKL0) {
      return EChange.UNCHANGED;
    }
    m_dBKL0 = dBKL0;
    return EChange.CHANGED;
  }

  public final double getBKL1() {
    return m_dBKL1;
  }

  @Nonnull
  final EChange setBKL1(final double dBKL1) {
    if (dBKL1 == m_dBKL1) {
      return EChange.UNCHANGED;
    }
    m_dBKL1 = dBKL1;
    return EChange.CHANGED;
  }

  public final double getBKL2() {
    return m_dBKL2;
  }

  @Nonnull
  final EChange setBKL2(final double dBKL2) {
    if (dBKL2 == m_dBKL2) {
      return EChange.UNCHANGED;
    }
    m_dBKL2 = dBKL2;
    return EChange.CHANGED;
  }

  public final double getBKL3() {
    return m_dBKL3;
  }

  @Nonnull
  final EChange setBKL3(final double dBKL3) {
    if (dBKL3 == m_dBKL3) {
      return EChange.UNCHANGED;
    }
    m_dBKL3 = dBKL3;
    return EChange.CHANGED;
  }

  public final double getBKL4() {
    return m_dBKL4;
  }

  @Nonnull
  final EChange setBKL4(final double dBKL4) {
    if (dBKL4 == m_dBKL4) {
      return EChange.UNCHANGED;
    }
    m_dBKL4 = dBKL4;
    return EChange.CHANGED;
  }

  public final double getBKL5() {
    return m_dBKL5;
  }

  @Nonnull
  final EChange setBKL5(final double dBKL5) {
    if (dBKL5 == m_dBKL5) {
      return EChange.UNCHANGED;
    }
    m_dBKL5 = dBKL5;
    return EChange.CHANGED;
  }

  public final double getBKL6() {
    return m_dBKL6;
  }

  @Nonnull
  final EChange setBKL6(final double dBKL6) {
    if (dBKL6 == m_dBKL6) {
      return EChange.UNCHANGED;
    }
    m_dBKL6 = dBKL6;
    return EChange.CHANGED;
  }

  public final double getBKL7() {
    return m_dBKL7;
  }

  @Nonnull
  final EChange setBKL7(final double dBKL7) {
    if (dBKL7 == m_dBKL7) {
      return EChange.UNCHANGED;
    }
    m_dBKL7 = dBKL7;
    return EChange.CHANGED;
  }

  public final double getBKL8() {
    return m_dBKL8;
  }

  @Nonnull
  final EChange setBKL8(final double dBKL8) {
    if (dBKL8 == m_dBKL8) {
      return EChange.UNCHANGED;
    }
    m_dBKL8 = dBKL8;
    return EChange.CHANGED;
  }

  public final double getBKL9() {
    return m_dBKL9;
  }

  @Nonnull
  final EChange setBKL9(final double dBKL9) {
    if (dBKL9 == m_dBKL9) {
      return EChange.UNCHANGED;
    }
    m_dBKL9 = dBKL9;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getUsage() {
    return m_sUsage;
  }

  @Nonnull
  final EChange setUsage(@Nonnull final String sUsage) {
    ValueEnforcer.notNull(sUsage, "Usage");
    if (sUsage.equals(m_sUsage)) {
      return EChange.UNCHANGED;
    }
    m_sUsage = sUsage;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getUsageDesc() {
    return m_sUsageDesc;
  }

  @Nonnull
  final EChange setUsageDesc(@Nonnull final String sUsageDesc) {
    ValueEnforcer.notNull(sUsageDesc, "UsageDesc");
    if (sUsageDesc.equals(m_sUsageDesc)) {
      return EChange.UNCHANGED;
    }
    m_sUsageDesc = sUsageDesc;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaum> trees() {
    return m_aTrees;
  }

  @Nonnull
  final EChange setTrees(@Nonnull final ICommonsList<IBiotopbaum> aTrees) {
    ValueEnforcer.notNull(aTrees, "Trees");
    // Ensure the same implementation type
    final ICommonsList<IBiotopbaum> aRealList = new CommonsArrayList<>(aTrees);
    if (aRealList.equals(m_aTrees)) {
      return EChange.UNCHANGED;
    }
    m_aTrees.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getDesc() {
    return m_sDesc;
  }

  @Nonnull
  final EChange setDesc(@Nonnull final String sDesc) {
    ValueEnforcer.notNull(sDesc, "Desc");
    if (sDesc.equals(m_sDesc)) {
      return EChange.UNCHANGED;
    }
    m_sDesc = sDesc;
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
  @ReturnsMutableObject
  public final ICommonsList<IStichprobeDeadwood> totSteh() {
    return m_aTotSteh;
  }

  @Nonnull
  final EChange setTotSteh(@Nonnull final ICommonsList<IStichprobeDeadwood> aTotSteh) {
    ValueEnforcer.notNull(aTotSteh, "TotSteh");
    // Ensure the same implementation type
    final ICommonsList<IStichprobeDeadwood> aRealList = new CommonsArrayList<>(aTotSteh);
    if (aRealList.equals(m_aTotSteh)) {
      return EChange.UNCHANGED;
    }
    m_aTotSteh.setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IStichprobeDeadwood> totLieg1() {
    return m_aTotLieg1;
  }

  @Nonnull
  final EChange setTotLieg1(@Nonnull final ICommonsList<IStichprobeDeadwood> aTotLieg1) {
    ValueEnforcer.notNull(aTotLieg1, "TotLieg1");
    // Ensure the same implementation type
    final ICommonsList<IStichprobeDeadwood> aRealList = new CommonsArrayList<>(aTotLieg1);
    if (aRealList.equals(m_aTotLieg1)) {
      return EChange.UNCHANGED;
    }
    m_aTotLieg1 .setAll(aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IStichprobeDeadwood> totLieg2() {
    return m_aTotLieg2;
  }

  @Nonnull
  final EChange setTotLieg2(@Nonnull final ICommonsList<IStichprobeDeadwood> aTotLieg2) {
    ValueEnforcer.notNull(aTotLieg2, "TotLieg2");
    // Ensure the same implementation type
    final ICommonsList<IStichprobeDeadwood> aRealList = new CommonsArrayList<>(aTotLieg2);
    if (aRealList.equals(m_aTotLieg2)) {
      return EChange.UNCHANGED;
    }
    m_aTotLieg2 .setAll(aRealList);
    return EChange.CHANGED;
  }
}
