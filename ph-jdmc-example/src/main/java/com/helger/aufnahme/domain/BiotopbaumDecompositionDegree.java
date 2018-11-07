package com.helger.aufnahme.domain;

import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IBiotopbaumDecompositionDegree}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class BiotopbaumDecompositionDegree
  implements IBiotopbaumDecompositionDegree
{
  private EDecompositionDegreeClass m_eType;
  private boolean m_bEnabled;
  private int m_nLength;
  private int m_nBHD;

  @Nonnull
  public final EDecompositionDegreeClass getType() {
    return m_eType;
  }

  public final void setType(
    @Nonnull
    EDecompositionDegreeClass eType) {
    m_eType = eType;
  }

  public final boolean isEnabled() {
    return m_bEnabled;
  }

  public final void setEnabled(boolean bEnabled) {
    m_bEnabled = bEnabled;
  }

  public final int getLength() {
    return m_nLength;
  }

  public final void setLength(int nLength) {
    m_nLength = nLength;
  }

  public final int getBHD() {
    return m_nBHD;
  }

  public final void setBHD(int nBHD) {
    m_nBHD = nBHD;
  }
}
