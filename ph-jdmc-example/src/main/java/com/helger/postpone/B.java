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
 * <p>Default implementation of {@link com.helger.postpone.IB}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class B
  extends AbstractBusinessObject
  implements IB
{
  public static final ObjectType OT = new ObjectType("B");
  private IC m_aC;

  public B(@Nonnull final IC aC) {
    this(StubObject.createForCurrentUser(), aC);
  }

  protected B(@Nonnull final StubObject aStubObject, @Nonnull final IC aC) {
    super(aStubObject);
    setC(aC);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("c", m_aC).getToString();
  }

  @Nonnull
  public final IC getC() {
    return m_aC;
  }

  @Nonnull
  final EChange setC(@Nonnull final IC aC) {
    ValueEnforcer.notNull(aC, "C");
    if (aC.equals(m_aC)) {
      return EChange.UNCHANGED;
    }
    m_aC = aC;
    return EChange.CHANGED;
  }
}
