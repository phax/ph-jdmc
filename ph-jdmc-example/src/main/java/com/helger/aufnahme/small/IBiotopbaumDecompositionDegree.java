package com.helger.aufnahme.small;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link BiotopbaumDecompositionDegree}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
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

  @Nonnull
  default String getTypeID() {
    return getType().getID();
  }

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
