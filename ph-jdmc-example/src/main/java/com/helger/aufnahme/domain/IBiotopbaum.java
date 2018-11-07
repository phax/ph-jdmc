/**
 * Copyright (C) 2018 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
 * <p>Interface for class {@link Biotopbaum}</p>
 * <p>This class was initially automatically created</p>
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
  ICommonsList<UserDataObject> pics();

  /**
   * Aufnahmedatum
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  LocalDate getDate();

  /**
   * Biotopbaum-Typ (Hauptauswahlkriterium)
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<EBiotopbaumType> type();

  /**
   * allg. Beschreibung des Standorts
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getLocation();

  default boolean hasLocation() {
    return (getLocation()!= null);
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
   * Wald, einschichtig (1 Baumschicht, kaum Unterwuchs) oder mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht)
   * 
   * @return
   *     The requested value.
   */
  boolean isEinschichtig();

  /**
   * Solitärbaum
   * 
   * @return
   *     The requested value.
   */
  boolean isSolitary();

  /**
   * lichter Bestand (Besonnung)
   * 
   * @return
   *     The requested value.
   */
  boolean isLightLocation();

  /**
   * geschlossene Kronendach
   * 
   * @return
   *     The requested value.
   */
  boolean isClosedCrown();

  /**
   * explitzit keine Besonnung
   * 
   * @return
   *     The requested value.
   */
  boolean isNoSun();

  /**
   * Überhälter, mind. 25% oder weniger als 25% des Stammes besonnt
   * 
   * @return
   *     The requested value.
   */
  boolean isUeberSun();

  /**
   * eingebettet in homogenene oder heterogene Umgebung
   * 
   * @return
   *     The requested value.
   */
  boolean isHomogene();

  /**
   * Bemerkungen/ (ausführliche) Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBeschreibung();

  /**
   * Baumart laut Aufnahmeblatt
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ETreeKind getTreeKind();

  /**
   * Höhlentyp und Anzahl mit Klasseneinteilung (Checkbox, mehrere möglich; dann noch Klassenangaben; C22-35 im Aufnahmemanual)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<ICaveType> caves();

  /**
   * Daten zum Stamm/zu den Stämmen
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<ITrunkSize> trunk();

  /**
   * Vitalität
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EVitality getVitality();

  /**
   * Baum-Sonderstrukturen (Mehrfachnennung möglich)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<ESpecialStructure> specialStructure();

  /**
   * Sonstige Sonderstrukturen inkl. Beschreibung
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getOtherSpecial();

  default boolean hasOtherSpecial() {
    return (getOtherSpecial()!= null);
  }

  /**
   * Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe)
   * 
   * @return
   *     The requested value.
   */
  boolean isAspirant();

  /**
   * Beschreibung Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe)
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getAspirantDesc();

  default boolean hasAspirantDesc() {
    return (getAspirantDesc()!= null);
  }

  /**
   * bestehende Markierung
   * 
   * @return
   *     The requested value.
   */
  boolean isMarked();

  /**
   * Beschreibung bestehende Markierung
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getMarkedDesc();

  default boolean hasMarkedDesc() {
    return (getMarkedDesc()!= null);
  }

  /**
   * Totholzkategorien (bei toten Bäumen)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IBiotopbaumDeadwood> deadwoodCats();

  /**
   * Totholzmengen aufgeteilt in die Zersetzungsklassen
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IBiotopbaumDecompositionDegree> deadwoodDoD();
}
