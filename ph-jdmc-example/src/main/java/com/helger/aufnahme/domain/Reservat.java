package com.helger.aufnahme.domain;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IReservat}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Reservat
  implements IReservat
{
  private int m_nRNr;
  private String m_sName;
  private int m_nAreaSize;

  public final int getRNr() {
    return m_nRNr;
  }

  @Nonnull
  public final EChange setRNr(final int nRNr) {
    if (nRNr == m_nRNr) {
      return EChange.UNCHANGED;
    }
    m_nRNr = nRNr;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getName() {
    return m_sName;
  }

  @Nonnull
  public final EChange setName(
    @Nonnull
    final String sName) {
    ValueEnforcer.notNull(sName, "Name");
    if (sName.equals(m_sName)) {
      return EChange.UNCHANGED;
    }
    m_sName = sName;
    return EChange.CHANGED;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  @Nonnull
  public final EChange setAreaSize(final int nAreaSize) {
    if (nAreaSize == m_nAreaSize) {
      return EChange.UNCHANGED;
    }
    m_nAreaSize = nAreaSize;
    return EChange.CHANGED;
  }
}
