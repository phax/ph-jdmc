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
 * <p>Interface for class {@link Stichprobe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public interface IStichprobe
  extends Serializable
{

  /**
   * Schlüsselfeld
   * 
   * @return
   *     The requested value.
   */
  int getStichNr();

  /**
   * Zugehörig zu Reservat
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  IReservat getStichNrzR();

  /**
   * Fotos
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
   * Größe in m² bei Abweichung von Radius
   * 
   * @return
   *     The requested value.
   */
  int getSize();

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
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  String getHanglage();

  default boolean hasHanglage() {
    return (getHanglage()!= null);
  }

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
  String getUsage();

  /**
   * allgemeine Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getUsageDesc();

  /**
   * Biotopbäume innerhalb Stichprobenpunkt
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IBiotopbaum> trees();

  /**
   * Beschreibung
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  String getDesc();

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
   * Stehendes Totholz (Vollaufnahme) ab >= 5cm BHD
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IStichprobeDeadwood> totSteh();

  /**
   * Liegendes Totholz (Line-intersect, Transekt 1) ab Mindestdurchmesser >= 10 cm
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IStichprobeDeadwood> totLieg1();

  /**
   * Liegendes Totholz (Line-intersect, Transekt 1) ab Mindestdurchmesser >= 10 cm
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  @ReturnsMutableObject
  ICommonsList<IStichprobeDeadwood> totLieg2();
}
