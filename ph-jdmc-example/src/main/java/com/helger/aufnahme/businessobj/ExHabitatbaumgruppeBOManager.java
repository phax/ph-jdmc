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
package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.state.EChange;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.audit.AuditHelper;
import com.helger.photon.security.object.BusinessObjectHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExHabitatbaumgruppeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExHabitatbaumgruppeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExHabitatbaumgruppeBO, ExHabitatbaumgruppeBO>
{

  public ExHabitatbaumgruppeBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExHabitatbaumgruppeBO.class, sFilename);
  }

  public ExHabitatbaumgruppeBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExHabitatbaumgruppeBO> aInitSettings)
    throws DAOException
  {
    super(ExHabitatbaumgruppeBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param nHBGNr
   *     Schlüsselfeld.
   * @param aPics
   *     Fotos. May neither be <code>null</code> nor empty.
   * @param aHBGzBB
   *     zugehörige Biotopbäume. May not be <code>null</code>.
   * @param aDate
   *     LocalDate value. May not be <code>null</code>.
   * @param sStandort
   *     allg. Beschreibung  Freitext. May not be <code>null</code>.
   * @param bOneLevel
   *     Wald, einschichtig (1 Baumschicht, kaum Unterwuchs) oder mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht).
   * @param bLight
   *     lichter Bestand (Besonnung).
   * @param bClosedCrown
   *     geschlossene Kronendach.
   * @param bNoSun
   *     explitzit keine Besonnung.
   * @param bHomogen
   *     eingebettet in homogenene oder heterogene Umgebung.
   * @param eExposition
   *     Exposition. May not be <code>null</code>.
   * @param sHanglage
   *     Angabe von Neigungen: keine, Angabe von Neigungen, Freitext. May be <code>null</code>.
   * @param nAreaSize
   *     Größe (in m²).
   * @param bOnlyBB
   *     Habitatbaumgruppe NUR aus schon kartierten Biotopbäumen oder  auch aus anderen Bäumen bestehend.
   * @param sBeschreibung
   *     Freitext . May not be <code>null</code>.
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExHabitatbaumgruppeBO createExHabitatbaumgruppeBO(final int nHBGNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final ICommonsList<IExBiotopbaumBO> aHBGzBB,
    @Nonnull final LocalDate aDate,
    @Nonnull final String sStandort,
    final boolean bOneLevel,
    final boolean bLight,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bHomogen,
    @Nonnull final EExExpositionBO eExposition,
    @Nullable final String sHanglage,
    final int nAreaSize,
    final boolean bOnlyBB,
    @Nonnull final String sBeschreibung) {
    // Create new object
    final ExHabitatbaumgruppeBO aExHabitatbaumgruppeBO = new ExHabitatbaumgruppeBO(nHBGNr, aPics, aHBGzBB, aDate, sStandort, bOneLevel, bLight, bClosedCrown, bNoSun, bHomogen, eExposition, sHanglage, nAreaSize, bOnlyBB, sBeschreibung);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExHabitatbaumgruppeBO.OT, aExHabitatbaumgruppeBO.getID(), Integer.valueOf(nHBGNr), aPics, aHBGzBB, aDate, sStandort, Boolean.valueOf(bOneLevel), Boolean.valueOf(bLight), Boolean.valueOf(bClosedCrown), Boolean.valueOf(bNoSun), Boolean.valueOf(bHomogen), eExposition, sHanglage, Integer.valueOf(nAreaSize), Boolean.valueOf(bOnlyBB), sBeschreibung);
    return aExHabitatbaumgruppeBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExHabitatbaumgruppeBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param nHBGNr
   *     Schlüsselfeld.
   * @param aPics
   *     Fotos. May neither be <code>null</code> nor empty.
   * @param aHBGzBB
   *     zugehörige Biotopbäume. May not be <code>null</code>.
   * @param aDate
   *     LocalDate value. May not be <code>null</code>.
   * @param sStandort
   *     allg. Beschreibung  Freitext. May not be <code>null</code>.
   * @param bOneLevel
   *     Wald, einschichtig (1 Baumschicht, kaum Unterwuchs) oder mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht).
   * @param bLight
   *     lichter Bestand (Besonnung).
   * @param bClosedCrown
   *     geschlossene Kronendach.
   * @param bNoSun
   *     explitzit keine Besonnung.
   * @param bHomogen
   *     eingebettet in homogenene oder heterogene Umgebung.
   * @param eExposition
   *     Exposition. May not be <code>null</code>.
   * @param sHanglage
   *     Angabe von Neigungen: keine, Angabe von Neigungen, Freitext. May be <code>null</code>.
   * @param nAreaSize
   *     Größe (in m²).
   * @param bOnlyBB
   *     Habitatbaumgruppe NUR aus schon kartierten Biotopbäumen oder  auch aus anderen Bäumen bestehend.
   * @param sBeschreibung
   *     Freitext . May not be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExHabitatbaumgruppeBO(@Nullable final String sExHabitatbaumgruppeBOID,
    final int nHBGNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final ICommonsList<IExBiotopbaumBO> aHBGzBB,
    @Nonnull final LocalDate aDate,
    @Nonnull final String sStandort,
    final boolean bOneLevel,
    final boolean bLight,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bHomogen,
    @Nonnull final EExExpositionBO eExposition,
    @Nullable final String sHanglage,
    final int nAreaSize,
    final boolean bOnlyBB,
    @Nonnull final String sBeschreibung) {
    final ExHabitatbaumgruppeBO aExHabitatbaumgruppeBO = getOfID(sExHabitatbaumgruppeBOID);
    // Check preconditions
    if (aExHabitatbaumgruppeBO == null) {
      AuditHelper.onAuditModifyFailure(ExHabitatbaumgruppeBO.OT, "all", sExHabitatbaumgruppeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExHabitatbaumgruppeBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExHabitatbaumgruppeBO.OT, "all", sExHabitatbaumgruppeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHBGNr(nHBGNr));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setPics(aPics));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHBGzBB(aHBGzBB));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setDate(aDate));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setStandort(sStandort));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setOneLevel(bOneLevel));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setLight(bLight));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setClosedCrown(bClosedCrown));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setNoSun(bNoSun));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHomogen(bHomogen));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setExposition(eExposition));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHanglage(sHanglage));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setAreaSize(nAreaSize));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setOnlyBB(bOnlyBB));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setBeschreibung(sBeschreibung));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExHabitatbaumgruppeBO);
      internalUpdateItem(aExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExHabitatbaumgruppeBO.OT, "all", aExHabitatbaumgruppeBO.getID(), Integer.valueOf(nHBGNr), aPics, aHBGzBB, aDate, sStandort, Boolean.valueOf(bOneLevel), Boolean.valueOf(bLight), Boolean.valueOf(bClosedCrown), Boolean.valueOf(bNoSun), Boolean.valueOf(bHomogen), eExposition, sHanglage, Integer.valueOf(nAreaSize), Boolean.valueOf(bOnlyBB), sBeschreibung);
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExHabitatbaumgruppeBOUndeleted(String)} method.
   * 
   * @param sExHabitatbaumgruppeBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExHabitatbaumgruppeBODeleted(@Nullable final String sExHabitatbaumgruppeBOID) {
    // Check preconditions
    final ExHabitatbaumgruppeBO aExHabitatbaumgruppeBO = getOfID(sExHabitatbaumgruppeBOID);
    if (aExHabitatbaumgruppeBO == null) {
      AuditHelper.onAuditDeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExHabitatbaumgruppeBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExHabitatbaumgruppeBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExHabitatbaumgruppeBODeleted(String)} method.
   * 
   * @param sExHabitatbaumgruppeBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExHabitatbaumgruppeBOUndeleted(@Nullable final String sExHabitatbaumgruppeBOID) {
    // Check preconditions
    final ExHabitatbaumgruppeBO aExHabitatbaumgruppeBO = getOfID(sExHabitatbaumgruppeBOID);
    if (aExHabitatbaumgruppeBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExHabitatbaumgruppeBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExHabitatbaumgruppeBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExHabitatbaumgruppeBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExHabitatbaumgruppeBO(@Nullable final String sExHabitatbaumgruppeBOID) {
    final ExHabitatbaumgruppeBO aDeletedExHabitatbaumgruppeBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExHabitatbaumgruppeBO = internalDeleteItem(sExHabitatbaumgruppeBOID);
      if (aDeletedExHabitatbaumgruppeBO == null) {
        AuditHelper.onAuditDeleteFailure(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExHabitatbaumgruppeBO.OT, sExHabitatbaumgruppeBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExHabitatbaumgruppeBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExHabitatbaumgruppeBO getExHabitatbaumgruppeBOOfID(@Nullable final String sExHabitatbaumgruppeBOID) {
    return getOfID(sExHabitatbaumgruppeBOID);
  }
}
