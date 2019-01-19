package com.helger.aufnahme.businessobj;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link ExReservatBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IExReservatBO
  extends IBusinessObject
{

  /**
   * Schlüsselfeld
   * 
   * @return
   *     The requested value.
   */
  int getRNr();

  /**
   * Name des Reservats
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getName();

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value.
   */
  int getAreaSize();
}
