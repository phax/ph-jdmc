package com.helger.aufnahme.simple;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.ICaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class CaveType
  implements ICaveType
{
  public static final ObjectType OT = new ObjectType("CaveType");
  private ECaveClass m_eClazz;
  private ECaveType m_eType;

  public CaveType() {
  }

  public CaveType(
    @Nonnull
    final ECaveClass eClazz,
    @Nonnull
    final ECaveType eType) {
    setClazz(eClazz);
    setType(eType);
  }

  public CaveType(
    @Nonnull
    final ICaveType aOther) {
    setClazz(aOther.getClazz());
    setType(aOther.getType());
  }

  @Nonnull
  public final ECaveClass getClazz() {
    return m_eClazz;
  }

  @Nonnull
  public final EChange setClazz(
    @Nonnull
    final ECaveClass eClazz) {
    ValueEnforcer.notNull(eClazz, "Clazz");
    if (eClazz.equals(m_eClazz)) {
      return EChange.UNCHANGED;
    }
    m_eClazz = eClazz;
    return EChange.CHANGED;
  }

  @Nonnull
  public final ECaveType getType() {
    return m_eType;
  }

  @Nonnull
  public final EChange setType(
    @Nonnull
    final ECaveType eType) {
    ValueEnforcer.notNull(eType, "Type");
    if (eType.equals(m_eType)) {
      return EChange.UNCHANGED;
    }
    m_eType = eType;
    return EChange.CHANGED;
  }
}
