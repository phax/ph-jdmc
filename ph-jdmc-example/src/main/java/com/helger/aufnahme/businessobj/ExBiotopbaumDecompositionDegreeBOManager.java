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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDecompositionDegreeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExBiotopbaumDecompositionDegreeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBiotopbaumDecompositionDegreeBO, ExBiotopbaumDecompositionDegreeBO>
{

  public ExBiotopbaumDecompositionDegreeBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExBiotopbaumDecompositionDegreeBO.class, sFilename);
  }

  public ExBiotopbaumDecompositionDegreeBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExBiotopbaumDecompositionDegreeBO> aInitSettings)
    throws DAOException
  {
    super(ExBiotopbaumDecompositionDegreeBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param eType
   *     EExDecompositionDegreeClassBO value. May not be <code>null</code>.
   * @param bEnabled
   *     Boolean value.
   * @param nLength
   *     Länge in cm.
   * @param nBHD
   *     BHD bzw. Mittendurchmesser in cm.
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExBiotopbaumDecompositionDegreeBO createExBiotopbaumDecompositionDegreeBO(@Nonnull final EExDecompositionDegreeClassBO eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    // Create new object
    final ExBiotopbaumDecompositionDegreeBO aExBiotopbaumDecompositionDegreeBO = new ExBiotopbaumDecompositionDegreeBO(eType, bEnabled, nLength, nBHD);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExBiotopbaumDecompositionDegreeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExBiotopbaumDecompositionDegreeBO.OT, aExBiotopbaumDecompositionDegreeBO.getID(), eType, Boolean.valueOf(bEnabled), Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return aExBiotopbaumDecompositionDegreeBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExBiotopbaumDecompositionDegreeBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param eType
   *     EExDecompositionDegreeClassBO value. May not be <code>null</code>.
   * @param bEnabled
   *     Boolean value.
   * @param nLength
   *     Länge in cm.
   * @param nBHD
   *     BHD bzw. Mittendurchmesser in cm.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExBiotopbaumDecompositionDegreeBO(@Nullable final String sExBiotopbaumDecompositionDegreeBOID,
    @Nonnull final EExDecompositionDegreeClassBO eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    final ExBiotopbaumDecompositionDegreeBO aExBiotopbaumDecompositionDegreeBO = getOfID(sExBiotopbaumDecompositionDegreeBOID);
    // Check preconditions
    if (aExBiotopbaumDecompositionDegreeBO == null) {
      AuditHelper.onAuditModifyFailure(ExBiotopbaumDecompositionDegreeBO.OT, "all", sExBiotopbaumDecompositionDegreeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBiotopbaumDecompositionDegreeBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExBiotopbaumDecompositionDegreeBO.OT, "all", sExBiotopbaumDecompositionDegreeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExBiotopbaumDecompositionDegreeBO.setType(eType));
      eChange = eChange.or(aExBiotopbaumDecompositionDegreeBO.setEnabled(bEnabled));
      eChange = eChange.or(aExBiotopbaumDecompositionDegreeBO.setLength(nLength));
      eChange = eChange.or(aExBiotopbaumDecompositionDegreeBO.setBHD(nBHD));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExBiotopbaumDecompositionDegreeBO);
      internalUpdateItem(aExBiotopbaumDecompositionDegreeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExBiotopbaumDecompositionDegreeBO.OT, "all", aExBiotopbaumDecompositionDegreeBO.getID(), eType, Boolean.valueOf(bEnabled), Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExBiotopbaumDecompositionDegreeBOUndeleted(String)} method.
   * 
   * @param sExBiotopbaumDecompositionDegreeBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBiotopbaumDecompositionDegreeBODeleted(@Nullable final String sExBiotopbaumDecompositionDegreeBOID) {
    // Check preconditions
    final ExBiotopbaumDecompositionDegreeBO aExBiotopbaumDecompositionDegreeBO = getOfID(sExBiotopbaumDecompositionDegreeBOID);
    if (aExBiotopbaumDecompositionDegreeBO == null) {
      AuditHelper.onAuditDeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBiotopbaumDecompositionDegreeBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExBiotopbaumDecompositionDegreeBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExBiotopbaumDecompositionDegreeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExBiotopbaumDecompositionDegreeBODeleted(String)} method.
   * 
   * @param sExBiotopbaumDecompositionDegreeBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBiotopbaumDecompositionDegreeBOUndeleted(@Nullable final String sExBiotopbaumDecompositionDegreeBOID) {
    // Check preconditions
    final ExBiotopbaumDecompositionDegreeBO aExBiotopbaumDecompositionDegreeBO = getOfID(sExBiotopbaumDecompositionDegreeBOID);
    if (aExBiotopbaumDecompositionDegreeBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExBiotopbaumDecompositionDegreeBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExBiotopbaumDecompositionDegreeBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExBiotopbaumDecompositionDegreeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExBiotopbaumDecompositionDegreeBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExBiotopbaumDecompositionDegreeBO(@Nullable final String sExBiotopbaumDecompositionDegreeBOID) {
    final ExBiotopbaumDecompositionDegreeBO aDeletedExBiotopbaumDecompositionDegreeBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExBiotopbaumDecompositionDegreeBO = internalDeleteItem(sExBiotopbaumDecompositionDegreeBOID);
      if (aDeletedExBiotopbaumDecompositionDegreeBO == null) {
        AuditHelper.onAuditDeleteFailure(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExBiotopbaumDecompositionDegreeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBiotopbaumDecompositionDegreeBO.OT, sExBiotopbaumDecompositionDegreeBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExBiotopbaumDecompositionDegreeBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExBiotopbaumDecompositionDegreeBO getExBiotopbaumDecompositionDegreeBOOfID(@Nullable final String sExBiotopbaumDecompositionDegreeBOID) {
    return getOfID(sExBiotopbaumDecompositionDegreeBOID);
  }
}
