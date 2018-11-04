package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * Interface for class TreeSize
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface ITreeSize
  extends Serializable
{

  /**
   * Brusthöhendurchmesser; Mittendurchmesser in cm
   * 
   * @return
   *     The requested value.
   */
  short getBHD();

  /**
   * Baumhöhe/Stammlänge
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ETreeHeight getHoehe();
}
