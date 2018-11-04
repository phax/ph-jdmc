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
 * Interface for class Habitatbaumgruppe
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
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
  ICommonsList<UserDataObject> pics();

  /**
   * zugehörige Biotopbäume
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  @ReturnsMutableObject
  ICommonsList<IBiotopbaum> hBGzBB();

  default boolean hasHBGzBB() {
    return (hBGzBB()!= null);
  }

  /**
   * zugehörig zu Bestand Nr.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  IBestand getHBGzB();

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
  boolean isLicht();

  /**
   * geschlossene Kronendach
   * 
   * @return
   *     The requested value.
   */
  boolean isClosed();

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
   * Größe (in m²)
   * 
   * @return
   *     The requested value.
   */
  int getAreSize();

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
