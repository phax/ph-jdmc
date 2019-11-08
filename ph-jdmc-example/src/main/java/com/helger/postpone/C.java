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
 * <p>Default implementation of {@link com.helger.postpone.IC}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class C
  extends AbstractBusinessObject
  implements IC
{
  public static final ObjectType OT = new ObjectType("C");
  private EE m_eE;

  public C(@Nonnull final EE eE) {
    this(StubObject.createForCurrentUser(), eE);
  }

  protected C(@Nonnull final StubObject aStubObject, @Nonnull final EE eE) {
    super(aStubObject);
    setE(eE);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("e", m_eE).getToString();
  }

  @Nonnull
  public final EE getE() {
    return m_eE;
  }

  @Nonnull
  final EChange setE(@Nonnull final EE eE) {
    ValueEnforcer.notNull(eE, "E");
    if (eE.equals(m_eE)) {
      return EChange.UNCHANGED;
    }
    m_eE = eE;
    return EChange.CHANGED;
  }
}
