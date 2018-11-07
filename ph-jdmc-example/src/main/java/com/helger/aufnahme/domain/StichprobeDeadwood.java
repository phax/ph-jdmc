package com.helger.aufnahme.domain;

import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.IStichprobeDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class StichprobeDeadwood
  implements IStichprobeDeadwood
{
  private EDecompositionDegreeClass m_eDoD;
  private ETreeKind m_eTreeKind;
  private int m_nLength;
  private int m_nBHD;

  @Nonnull
  public final EDecompositionDegreeClass getDoD() {
    return m_eDoD;
  }

  public final void setDoD(
    @Nonnull
    EDecompositionDegreeClass eDoD) {
    m_eDoD = eDoD;
  }

  @Nonnull
  public final ETreeKind getTreeKind() {
    return m_eTreeKind;
  }

  public final void setTreeKind(
    @Nonnull
    ETreeKind eTreeKind) {
    m_eTreeKind = eTreeKind;
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
