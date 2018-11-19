package com.helger.aufnahme.simple;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IBiotopbaumDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class BiotopbaumDeadwood
  implements IBiotopbaumDeadwood
{
  public static final ObjectType OT = new ObjectType("BiotopbaumDeadwood");
  private EDeadwoodCategory m_eType;
  private boolean m_bEnabled;
  private int m_nLength;
  private int m_nBHD;

  public BiotopbaumDeadwood() {
  }

  public BiotopbaumDeadwood(
    @Nonnull
    final EDeadwoodCategory eType, final boolean bEnabled, final int nLength, final int nBHD) {
    setType(eType);
    setEnabled(bEnabled);
    setLength(nLength);
    setBHD(nBHD);
  }

  public BiotopbaumDeadwood(
    @Nonnull
    final IBiotopbaumDeadwood aOther) {
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
    final BiotopbaumDeadwood rhs = ((BiotopbaumDeadwood) o);
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

  @Nonnull
  public final EDeadwoodCategory getType() {
    return m_eType;
  }

  @Nonnull
  public final EChange setType(
    @Nonnull
    final EDeadwoodCategory eType) {
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
  public final EChange setEnabled(final boolean bEnabled) {
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
  public final EChange setLength(final int nLength) {
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
  public final EChange setBHD(final int nBHD) {
    if (nBHD == m_nBHD) {
      return EChange.UNCHANGED;
    }
    m_nBHD = nBHD;
    return EChange.CHANGED;
  }
}
