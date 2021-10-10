/*
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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExStichprobeDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExStichprobeDeadwoodBOManager
  extends AbstractPhotonMapBasedWALDAO<IExStichprobeDeadwoodBO, ExStichprobeDeadwoodBO>
{

  public ExStichprobeDeadwoodBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExStichprobeDeadwoodBO.class, sFilename);
  }

  public ExStichprobeDeadwoodBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExStichprobeDeadwoodBO> aInitSettings)
    throws DAOException
  {
    super(ExStichprobeDeadwoodBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param eDoD
   *     Zersetzungsgrad. May not be <code>null</code>.
   * @param eTreeKind
   *     Baumart laut Aufnahmeblatt. May not be <code>null</code>.
   * @param nLength
   *     Länge in cm.
   * @param nBHD
   *     BHD bzw. Mittendurchmesser in cm.
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExStichprobeDeadwoodBO createExStichprobeDeadwoodBO(@Nonnull final EExDecompositionDegreeClassBO eDoD,
    @Nonnull final EExTreeKindBO eTreeKind,
    final int nLength,
    final int nBHD) {
    // Create new object
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = new ExStichprobeDeadwoodBO(eDoD, eTreeKind, nLength, nBHD);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExStichprobeDeadwoodBO.OT, aExStichprobeDeadwoodBO.getID(), eDoD, eTreeKind, Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return aExStichprobeDeadwoodBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExStichprobeDeadwoodBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param eDoD
   *     Zersetzungsgrad. May not be <code>null</code>.
   * @param eTreeKind
   *     Baumart laut Aufnahmeblatt. May not be <code>null</code>.
   * @param nLength
   *     Länge in cm.
   * @param nBHD
   *     BHD bzw. Mittendurchmesser in cm.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExStichprobeDeadwoodBO(@Nullable final String sExStichprobeDeadwoodBOID,
    @Nonnull final EExDecompositionDegreeClassBO eDoD,
    @Nonnull final EExTreeKindBO eTreeKind,
    final int nLength,
    final int nBHD) {
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = getOfID(sExStichprobeDeadwoodBOID);
    // Check preconditions
    if (aExStichprobeDeadwoodBO == null) {
      AuditHelper.onAuditModifyFailure(ExStichprobeDeadwoodBO.OT, "all", sExStichprobeDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExStichprobeDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExStichprobeDeadwoodBO.OT, "all", sExStichprobeDeadwoodBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExStichprobeDeadwoodBO.setDoD(eDoD));
      eChange = eChange.or(aExStichprobeDeadwoodBO.setTreeKind(eTreeKind));
      eChange = eChange.or(aExStichprobeDeadwoodBO.setLength(nLength));
      eChange = eChange.or(aExStichprobeDeadwoodBO.setBHD(nBHD));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExStichprobeDeadwoodBO);
      internalUpdateItem(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExStichprobeDeadwoodBO.OT, "all", aExStichprobeDeadwoodBO.getID(), eDoD, eTreeKind, Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExStichprobeDeadwoodBOUndeleted(String)} method.
   * 
   * @param sExStichprobeDeadwoodBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExStichprobeDeadwoodBODeleted(@Nullable final String sExStichprobeDeadwoodBOID) {
    // Check preconditions
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = getOfID(sExStichprobeDeadwoodBOID);
    if (aExStichprobeDeadwoodBO == null) {
      AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExStichprobeDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExStichprobeDeadwoodBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExStichprobeDeadwoodBODeleted(String)} method.
   * 
   * @param sExStichprobeDeadwoodBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExStichprobeDeadwoodBOUndeleted(@Nullable final String sExStichprobeDeadwoodBOID) {
    // Check preconditions
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = getOfID(sExStichprobeDeadwoodBOID);
    if (aExStichprobeDeadwoodBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExStichprobeDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExStichprobeDeadwoodBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExStichprobeDeadwoodBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExStichprobeDeadwoodBO(@Nullable final String sExStichprobeDeadwoodBOID) {
    final ExStichprobeDeadwoodBO aDeletedExStichprobeDeadwoodBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExStichprobeDeadwoodBO = internalDeleteItem(sExStichprobeDeadwoodBOID);
      if (aDeletedExStichprobeDeadwoodBO == null) {
        AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExStichprobeDeadwoodBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExStichprobeDeadwoodBO getExStichprobeDeadwoodBOOfID(@Nullable final String sExStichprobeDeadwoodBOID) {
    return getOfID(sExStichprobeDeadwoodBOID);
  }
}
