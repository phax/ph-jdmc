package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nullable;


/**
 * Interface for class EnabledDescription
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IEnabledDescription
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
   * Get the value of description.
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getDescription();

  default boolean hasDescription() {
    return (getDescription()!= null);
  }
}
