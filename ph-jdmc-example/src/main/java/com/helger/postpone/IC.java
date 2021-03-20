package com.helger.postpone;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link C}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IC
  extends IBusinessObject
{

  /**
   * Get the value of e.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EE getE();

  @Nonnull
  default String getEID() {
    return getE().getID();
  }
}
