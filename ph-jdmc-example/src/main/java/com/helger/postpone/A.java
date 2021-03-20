package com.helger.postpone;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.postpone.IA}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class A
  extends AbstractBusinessObject
  implements IA
{
  public static final ObjectType OT = new ObjectType("A");
  private IB m_aB;

  public A(@Nonnull final IB aB) {
    this(StubObject.createForCurrentUser(), aB);
  }

  protected A(@Nonnull final StubObject aStubObject, @Nonnull final IB aB) {
    super(aStubObject);
    setB(aB);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("b", m_aB).getToString();
  }

  @Nonnull
  public final IB getB() {
    return m_aB;
  }

  @Nonnull
  final EChange setB(@Nonnull final IB aB) {
    ValueEnforcer.notNull(aB, "B");
    if (aB.equals(m_aB)) {
      return EChange.UNCHANGED;
    }
    m_aB = aB;
    return EChange.CHANGED;
  }
}
