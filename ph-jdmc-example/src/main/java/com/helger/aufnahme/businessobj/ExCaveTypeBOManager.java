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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExCaveTypeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExCaveTypeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExCaveTypeBO, ExCaveTypeBO>
{

  public ExCaveTypeBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExCaveTypeBO.class, sFilename);
  }

  public ExCaveTypeBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExCaveTypeBO> aInitSettings)
    throws DAOException
  {
    super(ExCaveTypeBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param eClazz
   *     EExCaveClassBO value. May not be <code>null</code>.
   * @param eType
   *     Höhlentyp. May not be <code>null</code>.
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExCaveTypeBO createExCaveTypeBO(@Nonnull final EExCaveClassBO eClazz, @Nonnull final EExCaveTypeBO eType) {
    // Create new object
    final ExCaveTypeBO aExCaveTypeBO = new ExCaveTypeBO(eClazz, eType);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExCaveTypeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExCaveTypeBO.OT, aExCaveTypeBO.getID(), eClazz, eType);
    return aExCaveTypeBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExCaveTypeBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param eClazz
   *     EExCaveClassBO value. May not be <code>null</code>.
   * @param eType
   *     Höhlentyp. May not be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExCaveTypeBO(@Nullable final String sExCaveTypeBOID, @Nonnull final EExCaveClassBO eClazz, @Nonnull final EExCaveTypeBO eType) {
    final ExCaveTypeBO aExCaveTypeBO = getOfID(sExCaveTypeBOID);
    // Check preconditions
    if (aExCaveTypeBO == null) {
      AuditHelper.onAuditModifyFailure(ExCaveTypeBO.OT, "all", sExCaveTypeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExCaveTypeBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExCaveTypeBO.OT, "all", sExCaveTypeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExCaveTypeBO.setClazz(eClazz));
      eChange = eChange.or(aExCaveTypeBO.setType(eType));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExCaveTypeBO);
      internalUpdateItem(aExCaveTypeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExCaveTypeBO.OT, "all", aExCaveTypeBO.getID(), eClazz, eType);
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExCaveTypeBOUndeleted(String)} method.
   * 
   * @param sExCaveTypeBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExCaveTypeBODeleted(@Nullable final String sExCaveTypeBOID) {
    // Check preconditions
    final ExCaveTypeBO aExCaveTypeBO = getOfID(sExCaveTypeBOID);
    if (aExCaveTypeBO == null) {
      AuditHelper.onAuditDeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExCaveTypeBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExCaveTypeBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExCaveTypeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExCaveTypeBO.OT, sExCaveTypeBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExCaveTypeBODeleted(String)} method.
   * 
   * @param sExCaveTypeBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExCaveTypeBOUndeleted(@Nullable final String sExCaveTypeBOID) {
    // Check preconditions
    final ExCaveTypeBO aExCaveTypeBO = getOfID(sExCaveTypeBOID);
    if (aExCaveTypeBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExCaveTypeBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExCaveTypeBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExCaveTypeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExCaveTypeBO.OT, sExCaveTypeBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExCaveTypeBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExCaveTypeBO(@Nullable final String sExCaveTypeBOID) {
    final ExCaveTypeBO aDeletedExCaveTypeBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExCaveTypeBO = internalDeleteItem(sExCaveTypeBOID);
      if (aDeletedExCaveTypeBO == null) {
        AuditHelper.onAuditDeleteFailure(ExCaveTypeBO.OT, sExCaveTypeBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExCaveTypeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExCaveTypeBO.OT, sExCaveTypeBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExCaveTypeBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExCaveTypeBO getExCaveTypeBOOfID(@Nullable final String sExCaveTypeBOID) {
    return getOfID(sExCaveTypeBOID);
  }
}
