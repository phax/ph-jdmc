package com.helger.aufnahme.small;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link Reservat}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IReservat
  extends Serializable
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