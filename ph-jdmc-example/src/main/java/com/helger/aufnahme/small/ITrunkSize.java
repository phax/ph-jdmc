package com.helger.aufnahme.small;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link TrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface ITrunkSize
  extends Serializable
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

  @Nonnull
  default String getHeightID() {
    return getHeight().getID();
  }
}
