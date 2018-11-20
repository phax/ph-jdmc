package com.helger.aufnahme.businessobj;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link BiotopbaumDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IBiotopbaumDeadwood
  extends IBusinessObject
{

  /**
   * Totholzkategorie
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EDeadwoodCategory getType();

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
