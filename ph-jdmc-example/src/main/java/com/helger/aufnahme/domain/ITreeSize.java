package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link TreeSize}</p>
 * <p>This class was initially automatically created</p>
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
