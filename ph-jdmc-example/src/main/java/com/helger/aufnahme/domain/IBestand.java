package com.helger.aufnahme.domain;

import java.io.Serializable;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;


/**
 * Interface for class Bestand
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IBestand
  extends Serializable
{

  /**
   * Get the value of BNr.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBNr();

  /**
   * Foto-Nr in BNr integriert zB B1_1;B1_2
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<UserDataObject> fotoNr();

  /**
   * Get the value of Datum.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  LocalDate getDatum();

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value.
   */
  short getGroesse();

  /**
   * Bestand-Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBeschreib();

  /**
   * gleichaltrig
   * 
   * @return
   *     The requested value.
   */
  boolean isGleich();

  /**
   * ungleichaltrig
   * 
   * @return
   *     The requested value.
   */
  boolean isUngleich();

  /**
   * einschichtig
   * 
   * @return
   *     The requested value.
   */
  boolean isEinschicht();

  /**
   * mehrschichtig
   * 
   * @return
   *     The requested value.
   */
  boolean isMehrschicht();

  /**
   * irgendwas zwischen 1 und 9
   * 
   * @return
   *     The requested value.
   */
  short getBestandesklasse();

  /**
   * Beschreibung Nutzungsspuren
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getNutzung();

  /**
   * Waldgesellschaft oder Waldgruppe
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getGesellschaft();

  /**
   * Get the value of Kronenschluss.
   * 
   * @return
   *     The requested value.
   */
  boolean isKronenschluss();

  /**
   * räumig oder lückig stehendes Holz (lichter Bestand)
   * 
   * @return
   *     The requested value.
   */
  boolean isLicht();

  /**
   * Get the value of Unterwuchs.
   * 
   * @return
   *     The requested value.
   */
  boolean isUnterwuchs();

  /**
   * Schätzung Totholz stehend
   * 
   * @return
   *     The requested value.
   */
  short getTotholzStehend();

  /**
   * Beschreibung Totholz stehend
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getStehendBesch();

  /**
   * Schätzung Totholz liegend
   * 
   * @return
   *     The requested value.
   */
  short getTotLieg();

  /**
   * Beschreibung Totholz liegend
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getTotLiegBesch();

  /**
   * Schätzung Totholz stehend
   * 
   * @return
   *     The requested value.
   */
  short getTotSteh();

  /**
   * Beschreibung Totholz stehend
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getTotStehBesch();
}
