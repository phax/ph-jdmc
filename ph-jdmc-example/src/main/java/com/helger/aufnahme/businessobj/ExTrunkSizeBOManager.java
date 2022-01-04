/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExTrunkSizeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExTrunkSizeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExTrunkSizeBO, ExTrunkSizeBO>
{

  public ExTrunkSizeBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExTrunkSizeBO.class, sFilename);
  }

  public ExTrunkSizeBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExTrunkSizeBO> aInitSettings)
    throws DAOException
  {
    super(ExTrunkSizeBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param nBHD
   *     Brusthöhendurchmesser; Mittendurchmesser in cm.
   * @param eHeight
   *     Baumhöhe/Stammlänge. May not be <code>null</code>.
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExTrunkSizeBO createExTrunkSizeBO(final int nBHD, @Nonnull final EExTreeHeightBO eHeight) {
    // Create new object
    final ExTrunkSizeBO aExTrunkSizeBO = new ExTrunkSizeBO(nBHD, eHeight);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExTrunkSizeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExTrunkSizeBO.OT, aExTrunkSizeBO.getID(), Integer.valueOf(nBHD), eHeight);
    return aExTrunkSizeBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExTrunkSizeBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param nBHD
   *     Brusthöhendurchmesser; Mittendurchmesser in cm.
   * @param eHeight
   *     Baumhöhe/Stammlänge. May not be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExTrunkSizeBO(@Nullable final String sExTrunkSizeBOID, final int nBHD, @Nonnull final EExTreeHeightBO eHeight) {
    final ExTrunkSizeBO aExTrunkSizeBO = getOfID(sExTrunkSizeBOID);
    // Check preconditions
    if (aExTrunkSizeBO == null) {
      AuditHelper.onAuditModifyFailure(ExTrunkSizeBO.OT, "all", sExTrunkSizeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExTrunkSizeBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExTrunkSizeBO.OT, "all", sExTrunkSizeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExTrunkSizeBO.setBHD(nBHD));
      eChange = eChange.or(aExTrunkSizeBO.setHeight(eHeight));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExTrunkSizeBO);
      internalUpdateItem(aExTrunkSizeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExTrunkSizeBO.OT, "all", aExTrunkSizeBO.getID(), Integer.valueOf(nBHD), eHeight);
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExTrunkSizeBOUndeleted(String)} method.
   * 
   * @param sExTrunkSizeBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExTrunkSizeBODeleted(@Nullable final String sExTrunkSizeBOID) {
    // Check preconditions
    final ExTrunkSizeBO aExTrunkSizeBO = getOfID(sExTrunkSizeBOID);
    if (aExTrunkSizeBO == null) {
      AuditHelper.onAuditDeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExTrunkSizeBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExTrunkSizeBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExTrunkSizeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExTrunkSizeBODeleted(String)} method.
   * 
   * @param sExTrunkSizeBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExTrunkSizeBOUndeleted(@Nullable final String sExTrunkSizeBOID) {
    // Check preconditions
    final ExTrunkSizeBO aExTrunkSizeBO = getOfID(sExTrunkSizeBOID);
    if (aExTrunkSizeBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExTrunkSizeBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExTrunkSizeBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExTrunkSizeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExTrunkSizeBO.OT, sExTrunkSizeBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExTrunkSizeBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExTrunkSizeBO(@Nullable final String sExTrunkSizeBOID) {
    final ExTrunkSizeBO aDeletedExTrunkSizeBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExTrunkSizeBO = internalDeleteItem(sExTrunkSizeBOID);
      if (aDeletedExTrunkSizeBO == null) {
        AuditHelper.onAuditDeleteFailure(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExTrunkSizeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExTrunkSizeBO.OT, sExTrunkSizeBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExTrunkSizeBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExTrunkSizeBO getExTrunkSizeBOOfID(@Nullable final String sExTrunkSizeBOID) {
    return getOfID(sExTrunkSizeBOID);
  }
}
