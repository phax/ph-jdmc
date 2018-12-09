package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExCaveTypeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class ExCaveTypeBO
  extends AbstractBusinessObject
  implements IExCaveTypeBO
{
  public static final ObjectType OT = new ObjectType("ExCaveTypeBO");
  private EExCaveClassBO m_eClazz;
  private EExCaveTypeBO m_eType;

  public ExCaveTypeBO(@Nonnull final EExCaveClassBO eClazz, @Nonnull final EExCaveTypeBO eType) {
    this(StubObject.createForCurrentUser(), eClazz, eType);
  }

  protected ExCaveTypeBO(@Nonnull final StubObject aStubObject, @Nonnull final EExCaveClassBO eClazz, @Nonnull final EExCaveTypeBO eType) {
    super(aStubObject);
    setClazz(eClazz);
    setType(eType);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("clazz", m_eClazz).append("type", m_eType).getToString();
  }

  @Nonnull
  public final EExCaveClassBO getClazz() {
    return m_eClazz;
  }

  @Nonnull
  final EChange setClazz(@Nonnull final EExCaveClassBO eClazz) {
    ValueEnforcer.notNull(eClazz, "Clazz");
    if (eClazz.equals(m_eClazz)) {
      return EChange.UNCHANGED;
    }
    m_eClazz = eClazz;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExCaveTypeBO getType() {
    return m_eType;
  }

  @Nonnull
  final EChange setType(@Nonnull final EExCaveTypeBO eType) {
    ValueEnforcer.notNull(eType, "Type");
    if (eType.equals(m_eType)) {
      return EChange.UNCHANGED;
    }
    m_eType = eType;
    return EChange.CHANGED;
  }
}
