package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * Interface for class BiotopbaumDecompositionDegree
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IBiotopbaumDecompositionDegree
  extends Serializable
{

  /**
   * Get the value of type.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EDecompositionDegreeClass getType();

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
