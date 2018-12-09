package com.helger.aufnahme.small;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.small.IStichprobeDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class StichprobeDeadwood
  implements IStichprobeDeadwood
{
  public static final ObjectType OT = new ObjectType("StichprobeDeadwood");
  private EDecompositionDegreeClass m_eDoD;
  private ETreeKind m_eTreeKind;
  private int m_nLength;
  private int m_nBHD;

  public StichprobeDeadwood() {
  }

  public StichprobeDeadwood(
    @Nonnull
    final EDecompositionDegreeClass eDoD,
    @Nonnull
    final ETreeKind eTreeKind, final int nLength, final int nBHD) {
    setDoD(eDoD);
    setTreeKind(eTreeKind);
    setLength(nLength);
    setBHD(nBHD);
  }

  public StichprobeDeadwood(
    @Nonnull
    final IStichprobeDeadwood aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setDoD(aOther.getDoD());
    setTreeKind(aOther.getTreeKind());
    setLength(aOther.getLength());
    setBHD(aOther.getBHD());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final StichprobeDeadwood rhs = ((StichprobeDeadwood) o);
    if (!EqualsHelper.equals(m_eDoD, rhs.m_eDoD)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eTreeKind, rhs.m_eTreeKind)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nLength, rhs.m_nLength)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nBHD, rhs.m_nBHD)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_eDoD).append(m_eTreeKind).append(m_nLength).append(m_nBHD).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("DoD", m_eDoD).append("treeKind", m_eTreeKind).append("length", m_nLength).append("BHD", m_nBHD).getToString();
  }

  @Nonnull
  public final EDecompositionDegreeClass getDoD() {
    return m_eDoD;
  }

  @Nonnull
  final EChange setDoD(
    @Nonnull
    final EDecompositionDegreeClass eDoD) {
    ValueEnforcer.notNull(eDoD, "DoD");
    if (eDoD.equals(m_eDoD)) {
      return EChange.UNCHANGED;
    }
    m_eDoD = eDoD;
    return EChange.CHANGED;
  }

  @Nonnull
  public final ETreeKind getTreeKind() {
    return m_eTreeKind;
  }

  @Nonnull
  final EChange setTreeKind(
    @Nonnull
    final ETreeKind eTreeKind) {
    ValueEnforcer.notNull(eTreeKind, "TreeKind");
    if (eTreeKind.equals(m_eTreeKind)) {
      return EChange.UNCHANGED;
    }
    m_eTreeKind = eTreeKind;
    return EChange.CHANGED;
  }

  public final int getLength() {
    return m_nLength;
  }

  @Nonnull
  final EChange setLength(final int nLength) {
    if (nLength == m_nLength) {
      return EChange.UNCHANGED;
    }
    m_nLength = nLength;
    return EChange.CHANGED;
  }

  public final int getBHD() {
    return m_nBHD;
  }

  @Nonnull
  final EChange setBHD(final int nBHD) {
    if (nBHD == m_nBHD) {
      return EChange.UNCHANGED;
    }
    m_nBHD = nBHD;
    return EChange.CHANGED;
  }
}
