package com.helger.aufnahme.domain;

import java.io.Serializable;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;


/**
 * Interface for class Stichprobe
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IStichprobe
  extends Serializable
{

  /**
   * Schlüsselfeld; im SHAPE
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getStichNr();

  /**
   * Zugehörig zu Reservat
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getStichNrzR();

  /**
   * Foto-Nr in RNr_Nr integriert. zB R1 _1_1;
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
   * Größe in m² bei Abweichung von Radius
   * 
   * @return
   *     The requested value.
   */
  short getGroesse();

  /**
   * Exposition
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExposition getExposition();

  /**
   * Angabe von Neigungen
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getHanglage();

  /**
   * Waldgesellschaft oder Waldgruppe
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getGesellschaft();

  /**
   * Bestandesklasse 0, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL0();

  /**
   * Bestandesklasse 1, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL1();

  /**
   * Bestandesklasse 2, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL2();

  /**
   * Bestandesklasse 3, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL3();

  /**
   * Bestandesklasse 4, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL4();

  /**
   * Bestandesklasse 5, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL5();

  /**
   * Bestandesklasse 6, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL6();

  /**
   * Bestandesklasse 7, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL7();

  /**
   * Bestandesklasse 8, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL8();

  /**
   * Bestandesklasse 9, Flächenanteil in Zehntel
   * 
   * @return
   *     The requested value.
   */
  double getBKL9();

  /**
   * Beschreibung Nutzungsspuren
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getNutzung();

  /**
   * allgemeine Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBeschreibung();

  /**
   * Biotopbäume Anzahl automatische Berechnung!
   * 
   * @return
   *     The requested value.
   */
  short getBBAnzahl();

  /**
   * Biotopbäume innerhalb Stichprobenpunkt; Nrn eingeben
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<IBiotopbaumAnzahl> bBStichpr();

  /**
   * Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getStichBesch();

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
}
