package com.helger.aufnahme.businessobj;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link ExStichprobeDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IExStichprobeDeadwoodBO
  extends IBusinessObject
{

  /**
   * Zersetzungsgrad
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExDecompositionDegreeClassBO getDoD();

  /**
   * Baumart laut Aufnahmeblatt
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExTreeKindBO getTreeKind();

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
