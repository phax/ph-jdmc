package com.helger.aufnahme.smallbo;

import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.smallbo.ILeergut}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Leergut
  extends AbstractBusinessObject
  implements ILeergut
{
  public static final ObjectType OT = new ObjectType("Leergut");

  public Leergut() {
    this(StubObject.createForCurrentUser());
  }

  protected Leergut(@Nonnull final StubObject aStubObject) {
    super(aStubObject);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }
}
