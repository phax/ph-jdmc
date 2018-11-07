package com.helger.aufnahme.domain;

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

  public final void setRNr(int nRNr) {
    m_nRNr = nRNr;
  }

  @Nonnull
  public final String getName() {
    return m_sName;
  }

  public final void setName(
    @Nonnull
    String sName) {
    m_sName = sName;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  public final void setAreaSize(int nAreaSize) {
    m_nAreaSize = nAreaSize;
  }
}
