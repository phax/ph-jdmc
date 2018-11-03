package com.helger.aufnahme.domain;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * Interface for class BiotopbaumAnzahl
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IBiotopbaumAnzahl
  extends Serializable
{

  /**
   * Nrn die mit Manual Biotopbaum aufgenommen wurden
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBNr();

  /**
   * Get the value of Anzahl.
   * 
   * @return
   *     The requested value.
   */
  int getAnzahl();
}
