package com.helger.aufnahme.simple;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.ITrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class TrunkSize
  implements ITrunkSize
{
  public static final ObjectType OT = new ObjectType("TrunkSize");
  private int m_nBHD;
  private ETreeHeight m_eHeight;

  public TrunkSize() {
  }

  public TrunkSize(final int nBHD,
    @Nonnull
    final ETreeHeight eHeight) {
    setBHD(nBHD);
    setHeight(eHeight);
  }

  public TrunkSize(
    @Nonnull
    final ITrunkSize aOther) {
    setBHD(aOther.getBHD());
    setHeight(aOther.getHeight());
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

  @Nonnull
  public final ETreeHeight getHeight() {
    return m_eHeight;
  }

  @Nonnull
  public final EChange setHeight(
    @Nonnull
    final ETreeHeight eHeight) {
    ValueEnforcer.notNull(eHeight, "Height");
    if (eHeight.equals(m_eHeight)) {
      return EChange.UNCHANGED;
    }
    m_eHeight = eHeight;
    return EChange.CHANGED;
  }
}
