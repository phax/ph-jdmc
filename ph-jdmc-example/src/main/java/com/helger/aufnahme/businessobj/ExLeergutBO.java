package com.helger.aufnahme.businessobj;

import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExLeergutBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class ExLeergutBO
  extends AbstractBusinessObject
  implements IExLeergutBO
{
  public static final ObjectType OT = new ObjectType("ExLeergutBO");

  public ExLeergutBO() {
    this(StubObject.createForCurrentUser());
  }

  protected ExLeergutBO(
    @Nonnull
    final StubObject aStubObject) {
    super(aStubObject);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }
}
