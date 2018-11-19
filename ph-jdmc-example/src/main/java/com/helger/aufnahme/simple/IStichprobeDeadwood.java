package com.helger.aufnahme.simple;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link StichprobeDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public interface IStichprobeDeadwood
  extends Serializable
{

  /**
   * Zersetzungsgrad
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EDecompositionDegreeClass getDoD();

  /**
   * Baumart laut Aufnahmeblatt
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ETreeKind getTreeKind();

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
