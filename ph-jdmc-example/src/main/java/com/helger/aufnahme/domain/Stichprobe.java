package com.helger.aufnahme.domain;

import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IStichprobe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Stichprobe
  implements IStichprobe
{
  private int m_nStichNr;
  private IReservat m_aStichNrzR;
  private ICommonsList<UserDataObject> m_aPics;
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
  private ICommonsList<IBiotopbaum> m_aTrees;
  private String m_sDesc;
  private boolean m_bSameAge;
  private boolean m_bOneLevel;
  private ICommonsList<IStichprobeDeadwood> m_aTotSteh;
  private ICommonsList<IStichprobeDeadwood> m_aTotLieg1;
  private ICommonsList<IStichprobeDeadwood> m_aTotLieg2;

  public final int getStichNr() {
    return m_nStichNr;
  }

  public final void setStichNr(int nStichNr) {
    m_nStichNr = nStichNr;
  }

  @Nonnull
  public final IReservat getStichNrzR() {
    return m_aStichNrzR;
  }

  public final void setStichNrzR(
    @Nonnull
    IReservat aStichNrzR) {
    m_aStichNrzR = aStichNrzR;
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

  public final int getSize() {
    return m_nSize;
  }

  public final void setSize(int nSize) {
    m_nSize = nSize;
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

  @Nonnull
  public final String getGesellschaft() {
    return m_sGesellschaft;
  }

  public final void setGesellschaft(
    @Nonnull
    String sGesellschaft) {
    m_sGesellschaft = sGesellschaft;
  }

  public final double getBKL0() {
    return m_dBKL0;
  }

  public final void setBKL0(double dBKL0) {
    m_dBKL0 = dBKL0;
  }

  public final double getBKL1() {
    return m_dBKL1;
  }

  public final void setBKL1(double dBKL1) {
    m_dBKL1 = dBKL1;
  }

  public final double getBKL2() {
    return m_dBKL2;
  }

  public final void setBKL2(double dBKL2) {
    m_dBKL2 = dBKL2;
  }

  public final double getBKL3() {
    return m_dBKL3;
  }

  public final void setBKL3(double dBKL3) {
    m_dBKL3 = dBKL3;
  }

  public final double getBKL4() {
    return m_dBKL4;
  }

  public final void setBKL4(double dBKL4) {
    m_dBKL4 = dBKL4;
  }

  public final double getBKL5() {
    return m_dBKL5;
  }

  public final void setBKL5(double dBKL5) {
    m_dBKL5 = dBKL5;
  }

  public final double getBKL6() {
    return m_dBKL6;
  }

  public final void setBKL6(double dBKL6) {
    m_dBKL6 = dBKL6;
  }

  public final double getBKL7() {
    return m_dBKL7;
  }

  public final void setBKL7(double dBKL7) {
    m_dBKL7 = dBKL7;
  }

  public final double getBKL8() {
    return m_dBKL8;
  }

  public final void setBKL8(double dBKL8) {
    m_dBKL8 = dBKL8;
  }

  public final double getBKL9() {
    return m_dBKL9;
  }

  public final void setBKL9(double dBKL9) {
    m_dBKL9 = dBKL9;
  }

  @Nonnull
  public final String getUsage() {
    return m_sUsage;
  }

  public final void setUsage(
    @Nonnull
    String sUsage) {
    m_sUsage = sUsage;
  }

  @Nonnull
  public final String getUsageDesc() {
    return m_sUsageDesc;
  }

  public final void setUsageDesc(
    @Nonnull
    String sUsageDesc) {
    m_sUsageDesc = sUsageDesc;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IBiotopbaum> trees() {
    return m_aTrees;
  }

  public final void setTrees(
    @Nonnull
    ICommonsList<IBiotopbaum> aTrees) {
    m_aTrees = aTrees;
  }

  @Nonnull
  public final String getDesc() {
    return m_sDesc;
  }

  public final void setDesc(
    @Nonnull
    String sDesc) {
    m_sDesc = sDesc;
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
  @ReturnsMutableObject
  public final ICommonsList<IStichprobeDeadwood> totSteh() {
    return m_aTotSteh;
  }

  public final void setTotSteh(
    @Nonnull
    ICommonsList<IStichprobeDeadwood> aTotSteh) {
    m_aTotSteh = aTotSteh;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IStichprobeDeadwood> totLieg1() {
    return m_aTotLieg1;
  }

  public final void setTotLieg1(
    @Nonnull
    ICommonsList<IStichprobeDeadwood> aTotLieg1) {
    m_aTotLieg1 = aTotLieg1;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList<IStichprobeDeadwood> totLieg2() {
    return m_aTotLieg2;
  }

  public final void setTotLieg2(
    @Nonnull
    ICommonsList<IStichprobeDeadwood> aTotLieg2) {
    m_aTotLieg2 = aTotLieg2;
  }
}
