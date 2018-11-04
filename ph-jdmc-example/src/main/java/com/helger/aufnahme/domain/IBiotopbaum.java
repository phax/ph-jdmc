package com.helger.aufnahme.domain;

import java.io.Serializable;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.core.userdata.UserDataObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * Interface for class Biotopbaum
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public interface IBiotopbaum
  extends Serializable
{

  /**
   * Schlüsselfeld
   * 
   * @return
   *     The requested value.
   */
  int getBBNr();

  /**
   * Foto
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<UserDataObject> bBFotoNr();

  /**
   * Aufnahmedatum
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  LocalDate getDatum();

  /**
   * Get the value of BBzBNr.
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  IBestand getBBzBNr();

  default boolean hasBBzBNr() {
    return (getBBzBNr()!= null);
  }

  /**
   * Get the value of BBzHBGNr.
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  IHabitatbaumgruppe getBBzHBGNr();

  default boolean hasBBzHBGNr() {
    return (getBBzHBGNr()!= null);
  }

  /**
   * allg. Beschreibung
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getStandort();

  default boolean hasStandort() {
    return (getStandort()!= null);
  }

  /**
   * Exposition
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExposition getExposition();

  /**
   * Angabe von Neigungen: keine, Angabe von Neigungen, Freitext
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getHanglage();

  default boolean hasHanglage() {
    return (getHanglage()!= null);
  }

  /**
   * Wald, einschichtig (1 Baumschicht, kaum Unterwuchs)
   * 
   * @return
   *     The requested value.
   */
  boolean isEinschichtig();

  /**
   * mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht)
   * 
   * @return
   *     The requested value.
   */
  boolean isMehrschichtig();

  /**
   * Solitärbaum
   * 
   * @return
   *     The requested value.
   */
  boolean isSolitaerbaum();

  /**
   * lichter Bestand (Besonnung)
   * 
   * @return
   *     The requested value.
   */
  boolean isLicht();

  /**
   * geschlossene Kronendach
   * 
   * @return
   *     The requested value.
   */
  boolean isGeschlossen();

  /**
   * explitzit keine Besonnung
   * 
   * @return
   *     The requested value.
   */
  boolean isKeineBesonn();

  /**
   * Überhälter, mind. 25% des Stammes besonnt
   * 
   * @return
   *     The requested value.
   */
  boolean isUeberVielSonne();

  /**
   * Überhälter, weniger als 25% des Stammes besonnt
   * 
   * @return
   *     The requested value.
   */
  boolean isUeberWenigSonne();

  /**
   * eingebettet in homogenen Umgebung
   * 
   * @return
   *     The requested value.
   */
  boolean isHomogenUmgeb();

  /**
   * eingebettet in heterogene Umgebung
   * 
   * @return
   *     The requested value.
   */
  boolean isHeterogenUmgeb();

  /**
   * Bemerkungen/ (ausführliche) Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBeschreibung();

  /**
   * Baumart Abkürzung einer Baumart laut Aufnahmeblatt; nur eine möglich; Feld A7-A8 in Aufnahmemanual
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBaumArt();

  /**
   * Biotopbaum-Typ (Hauptauswahlkriterium)
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<String> typ1();

  /**
   * Höhlentyp und Anzahl mit Klasseneinteilung (Checkbox, mehrere möglich; dann noch Klassenangaben; C22-35 im Aufnahmemanual)
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  @ReturnsMutableObject
  ICommonsList<IHoehletyp> hoehletyp();

  default boolean hasHoehletyp() {
    return (hoehletyp()!= null);
  }

  /**
   * Get the value of Stamm.
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<IStammtyp> stamm();

  /**
   * Vitalität
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EVitality getVital();

  /**
   * Baum-Sonderstrukturen (Mehrfachnennung möglich)
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  @ReturnsMutableObject
  ICommonsList<String> sonderstrukturen();

  default boolean hasSonderstrukturen() {
    return (sonderstrukturen()!= null);
  }

  /**
   * Sonstige Sonderstrukturen inkl. Beschreibung
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getSonstigeSonder();

  default boolean hasSonstigeSonder() {
    return (getSonstigeSonder()!= null);
  }

  /**
   * Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getAnwaerter();

  /**
   * bestehende Markierung
   * 
   * @return
   *     The requested value.
   */
  boolean isMarkierung();

  /**
   * Beschreibung bestehende Markierung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getMarkBesch();
}
