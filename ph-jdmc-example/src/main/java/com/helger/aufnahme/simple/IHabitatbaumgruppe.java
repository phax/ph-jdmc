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
 * <p>Interface for class {@link Habitatbaumgruppe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IHabitatbaumgruppe
  extends Serializable
{

  /**
   * Schlüsselfeld
   * 
   * @return
   *     The requested value.
   */
  int getHBGNr();

  /**
   * Fotos
   * 
   * @return
   *     The requested value. May neither be <code>null</code> nor empty.
   */
  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  ICommonsList<File> pics();

  /**
   * zugehörige Biotopbäume
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IBiotopbaum> hBGzBB();

  /**
   * Get the value of date.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  LocalDate getDate();

  /**
   * allg. Beschreibung  Freitext
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getStandort();

  /**
   * Wald, einschichtig (1 Baumschicht, kaum Unterwuchs) oder mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht)
   * 
   * @return
   *     The requested value.
   */
  boolean isOneLevel();

  /**
   * lichter Bestand (Besonnung)
   * 
   * @return
   *     The requested value.
   */
  boolean isLight();

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
   * eingebettet in homogenene oder heterogene Umgebung
   * 
   * @return
   *     The requested value.
   */
  boolean isHomogen();

  /**
   * Exposition
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExposition getExposition();

  @Nonnull
  default String getExpositionID() {
    return getExposition().getID();
  }

  /**
   * Angabe von Neigungen: keine, Angabe von Neigungen, Freitext
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getHanglage();

  default boolean hasHanglage() {
    return StringHelper.hasText(getHanglage());
  }

  /**
   * Größe (in m²)
   * 
   * @return
   *     The requested value.
   */
  int getAreaSize();

  /**
   * Habitatbaumgruppe NUR aus schon kartierten Biotopbäumen oder  auch aus anderen Bäumen bestehend
   * 
   * @return
   *     The requested value.
   */
  boolean isOnlyBB();

  /**
   * Freitext 
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getBeschreibung();
}
