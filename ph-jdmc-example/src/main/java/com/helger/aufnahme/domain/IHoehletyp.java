package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * Interface for class Hoehletyp
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IHoehletyp
  extends Serializable
{

  /**
   * Get the value of Klasse.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getKlasse();

  /**
   * Get the value of Typ.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getTyp();
}
