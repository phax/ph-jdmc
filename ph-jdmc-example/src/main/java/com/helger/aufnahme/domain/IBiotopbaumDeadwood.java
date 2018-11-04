package com.helger.aufnahme.domain;

import java.io.Serializable;


/**
 * Interface for class BiotopbaumDeadwood
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IBiotopbaumDeadwood
  extends Serializable
{

  /**
   * Get the value of enabled.
   * 
   * @return
   *     The requested value.
   */
  boolean isEnabled();

  /**
   * Länge in cm
   * 
   * @return
   *     The requested value.
   */
  int getLength();

  /**
   * BHD bzw. Mittendurchmesser in cm
   * 
   * @return
   *     The requested value.
   */
  int getBHD();
}
