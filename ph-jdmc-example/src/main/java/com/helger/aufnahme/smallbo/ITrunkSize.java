package com.helger.aufnahme.smallbo;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link TrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface ITrunkSize
  extends IBusinessObject
{

  /**
   * Brusthöhendurchmesser; Mittendurchmesser in cm
   * 
   * @return
   *     The requested value.
   */
  int getBHD();

  /**
   * Baumhöhe/Stammlänge
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ETreeHeight getHeight();
}
