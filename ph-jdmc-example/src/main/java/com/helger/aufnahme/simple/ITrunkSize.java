package com.helger.aufnahme.simple;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link TrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
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
}
