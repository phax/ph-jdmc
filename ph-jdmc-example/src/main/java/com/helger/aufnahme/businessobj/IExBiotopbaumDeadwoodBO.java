package com.helger.aufnahme.businessobj;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link ExBiotopbaumDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IExBiotopbaumDeadwoodBO
  extends IBusinessObject
{

  /**
   * Totholzkategorie
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExDeadwoodCategoryBO getType();

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
