package com.helger.aufnahme.domain;

import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.ITrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class TrunkSize
  implements ITrunkSize
{
  private int m_nBHD;
  private ETreeHeight m_eHeight;

  public final int getBHD() {
    return m_nBHD;
  }

  public final void setBHD(int nBHD) {
    m_nBHD = nBHD;
  }

  @Nonnull
  public final ETreeHeight getHeight() {
    return m_eHeight;
  }

  public final void setHeight(
    @Nonnull
    ETreeHeight eHeight) {
    m_eHeight = eHeight;
  }
}
