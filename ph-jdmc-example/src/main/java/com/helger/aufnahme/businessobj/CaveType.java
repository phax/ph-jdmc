package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.ICaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class CaveType
  extends AbstractBusinessObject
  implements ICaveType
{
  public static final ObjectType OT = new ObjectType("CaveType");
  private ECaveClass m_eClazz;
  private ECaveType m_eType;

  public CaveType(
    @Nonnull
    final ECaveClass eClazz,
    @Nonnull
    final ECaveType eType) {
    this(StubObject.createForCurrentUser(), eClazz, eType);
  }

  protected CaveType(final StubObject aStubObject,
    @Nonnull
    final ECaveClass eClazz,
    @Nonnull
    final ECaveType eType) {
    super(aStubObject);
    setClazz(eClazz);
    setType(eType);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
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
