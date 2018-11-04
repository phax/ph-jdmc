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
 * <p>Interface for class {@link Bestand}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
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
  ICommonsList<UserDataObject> pics();

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
    return (getVerortung()!= null);
  }

  /**
   * Habitatbaumgruppen
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IHabitatbaumgruppe> bZHBG();

  /**
   * Größe in m²
   * 
   * @return
   *     The requested value.
   */
  int getAreaSize();

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

  /**
   * Beschreibung Totholz liegend (geklumpt, Art, Herkunft, Zersetzungsgrade)
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getTotLiegBesch();
}
