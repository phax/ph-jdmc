package com.helger.aufnahme.simple;

import com.helger.commons.ValueEnforcer;
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
