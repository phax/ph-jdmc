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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExLeergutBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExLeergutBOManager
  extends AbstractPhotonMapBasedWALDAO<IExLeergutBO, ExLeergutBO>
{

  public ExLeergutBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExLeergutBO.class, sFilename);
  }

  public ExLeergutBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExLeergutBO> aInitSettings)
    throws DAOException
  {
    super(ExLeergutBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExLeergutBO createExLeergutBO() {
    // Create new object
    final ExLeergutBO aExLeergutBO = new ExLeergutBO();
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExLeergutBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExLeergutBO.OT, aExLeergutBO.getID());
    return aExLeergutBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExLeergutBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExLeergutBO(@Nullable final String sExLeergutBOID) {
    final ExLeergutBO aExLeergutBO = getOfID(sExLeergutBOID);
    // Check preconditions
    if (aExLeergutBO == null) {
      AuditHelper.onAuditModifyFailure(ExLeergutBO.OT, "all", sExLeergutBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExLeergutBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExLeergutBO.OT, "all", sExLeergutBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExLeergutBO);
      internalUpdateItem(aExLeergutBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExLeergutBO.OT, "all", aExLeergutBO.getID());
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExLeergutBOUndeleted(String)} method.
   * 
   * @param sExLeergutBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExLeergutBODeleted(@Nullable final String sExLeergutBOID) {
    // Check preconditions
    final ExLeergutBO aExLeergutBO = getOfID(sExLeergutBOID);
    if (aExLeergutBO == null) {
      AuditHelper.onAuditDeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExLeergutBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExLeergutBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExLeergutBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExLeergutBO.OT, sExLeergutBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExLeergutBODeleted(String)} method.
   * 
   * @param sExLeergutBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExLeergutBOUndeleted(@Nullable final String sExLeergutBOID) {
    // Check preconditions
    final ExLeergutBO aExLeergutBO = getOfID(sExLeergutBOID);
    if (aExLeergutBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExLeergutBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExLeergutBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExLeergutBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExLeergutBO.OT, sExLeergutBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExLeergutBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExLeergutBO(@Nullable final String sExLeergutBOID) {
    final ExLeergutBO aDeletedExLeergutBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExLeergutBO = internalDeleteItem(sExLeergutBOID);
      if (aDeletedExLeergutBO == null) {
        AuditHelper.onAuditDeleteFailure(ExLeergutBO.OT, sExLeergutBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExLeergutBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExLeergutBO.OT, sExLeergutBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExLeergutBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExLeergutBO getExLeergutBOOfID(@Nullable final String sExLeergutBOID) {
    return getOfID(sExLeergutBOID);
  }
}
