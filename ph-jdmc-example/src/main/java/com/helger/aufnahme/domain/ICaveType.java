package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * Interface for class CaveType
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface ICaveType
  extends Serializable
{

  /**
   * Get the value of clazz.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ECaveClass getClazz();

  /**
   * Get the value of type.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ECaveType getType();
}
