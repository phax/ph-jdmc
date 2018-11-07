package com.helger.aufnahme.domain;

import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.domain.ICaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class CaveType
  implements ICaveType
{
  private ECaveClass m_eClazz;
  private ECaveType m_eType;

  @Nonnull
  public final ECaveClass getClazz() {
    return m_eClazz;
  }

  public final void setClazz(
    @Nonnull
    ECaveClass eClazz) {
    m_eClazz = eClazz;
  }

  @Nonnull
  public final ECaveType getType() {
    return m_eType;
  }

  public final void setType(
    @Nonnull
    ECaveType eType) {
    m_eType = eType;
  }
}
