package com.helger.aufnahme.simple;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IBiotopbaumDecompositionDegree}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class BiotopbaumDecompositionDegree
  implements IBiotopbaumDecompositionDegree
{
  public static final ObjectType OT = new ObjectType("BiotopbaumDecompositionDegree");
  private EDecompositionDegreeClass m_eType;
  private boolean m_bEnabled;
  private int m_nLength;
  private int m_nBHD;

  public BiotopbaumDecompositionDegree() {
  }

  public BiotopbaumDecompositionDegree(
    @Nonnull
    final EDecompositionDegreeClass eType, final boolean bEnabled, final int nLength, final int nBHD) {
    setType(eType);
    setEnabled(bEnabled);
    setLength(nLength);
    setBHD(nBHD);
  }

  public BiotopbaumDecompositionDegree(
    @Nonnull
    final IBiotopbaumDecompositionDegree aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setType(aOther.getType());
    setEnabled(aOther.isEnabled());
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
    final BiotopbaumDecompositionDegree rhs = ((BiotopbaumDecompositionDegree) o);
    if (!EqualsHelper.equals(m_eType, rhs.m_eType)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bEnabled, rhs.m_bEnabled)) {
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
    return new HashCodeGenerator(this).append(m_eType).append(m_bEnabled).append(m_nLength).append(m_nBHD).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("type", m_eType).append("enabled", m_bEnabled).append("length", m_nLength).append("BHD", m_nBHD).getToString();
  }

  @Nonnull
  public final EDecompositionDegreeClass getType() {
    return m_eType;
  }

  @Nonnull
  final EChange setType(
    @Nonnull
    final EDecompositionDegreeClass eType) {
    ValueEnforcer.notNull(eType, "Type");
    if (eType.equals(m_eType)) {
      return EChange.UNCHANGED;
    }
    m_eType = eType;
    return EChange.CHANGED;
  }

  public final boolean isEnabled() {
    return m_bEnabled;
  }

  @Nonnull
  final EChange setEnabled(final boolean bEnabled) {
    if (bEnabled == m_bEnabled) {
      return EChange.UNCHANGED;
    }
    m_bEnabled = bEnabled;
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
