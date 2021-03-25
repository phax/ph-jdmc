/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
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
package com.helger.aufnahme.simple;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.string.StringHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Interface for class {@link Bestand}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IBestand
  extends Serializable
{

  /**
   * Schlüsselfeld
   * 
   * @return
   *     The requested value.
   */
  int getBNr();

  /**
   * Foto-Nr
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<File> pics();

  /**
   * Get the value of date.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  LocalDate getDate();

  /**
   * GPS-Punkte oder Verweis auf Polygon
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getVerortung();

  default boolean hasVerortung() {
    return StringHelper.hasText(getVerortung());
  }

  /**
   * Habitatbaumgruppen
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IHabitatbaumgruppe> BZHBG();

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  Integer getAreaSize();

  default boolean hasAreaSize() {
    return (getAreaSize()!= null);
  }

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  Long getAreaSizeLong();

  default boolean hasAreaSizeLong() {
    return (getAreaSizeLong()!= null);
  }

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  Float getAreaSizeFloat();

  default boolean hasAreaSizeFloat() {
    return (getAreaSizeFloat()!= null);
  }

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  Double getAreaSizeDouble();

  default boolean hasAreaSizeDouble() {
    return (getAreaSizeDouble()!= null);
  }

  /**
   * Bestand-Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBeschreib();

  /**
   * gleichaltrig oder ungleichaltrig
   * 
   * @return
   *     The requested value.
   */
  boolean isSameAge();

  /**
   * einschichtig oder mehrschichtig
   * 
   * @return
   *     The requested value.
   */
  boolean isOneLevel();

  /**
   * Bestandesklasse
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EStockType getStockType();

  @Nonnull
  default String getStockTypeID() {
    return getStockType().getID();
  }

  /**
   * Bestandesklasse optional
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  EStockType getStockTypeOpt();

  default boolean hasStockTypeOpt() {
    return (getStockTypeOpt()!= null);
  }

  @Nullable
  default String getStockTypeOptID() {
    final EStockType aObj = getStockTypeOpt();
    return ((aObj == null)?null:aObj.getID());
  }

  /**
   * Beschreibung Nutzungsspuren
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getUsageDescription();

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
  boolean isLightWoods();

  /**
   * Unterwuchs
   * 
   * @return
   *     The requested value.
   */
  boolean isUnterwuchs();

  /**
   * Schätzung Totholz stehend
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EStockDeadwood getTotSteh();

  @Nonnull
  default String getTotStehID() {
    return getTotSteh().getID();
  }

  /**
   * Beschreibung Totholz stehend (geklumpt, Art, Herkunft, Zersetzungsgrade)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getTotStehBesch();

  /**
   * Schätzung Totholz liegend
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EStockDeadwood getTotLieg();

  @Nonnull
  default String getTotLiegID() {
    return getTotLieg().getID();
  }

  /**
   * Beschreibung Totholz liegend (geklumpt, Art, Herkunft, Zersetzungsgrade)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getTotLiegBesch();
}
