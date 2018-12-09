package com.helger.aufnahme.businessobj;

import com.helger.commons.state.EChange;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
import com.helger.photon.security.object.BusinessObjectHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExReservatBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExReservatBOManager
  extends AbstractPhotonMapBasedWALDAO<IExReservatBO, ExReservatBO>
{

  public ExReservatBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExReservatBO.class, sFilename);
  }

  public ExReservatBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExReservatBO> aInitSettings)
    throws DAOException
  {
    super(ExReservatBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param nRNr
   *     Schlüsselfeld.
   * @param sName
   *     Name des Reservats. May not be <code>null</code>.
   * @param nAreaSize
   *     Größe in m².
   * @return
   *     The created object and never <code>null</code>.
   */
  @Nonnull
  public final IExReservatBO createExReservatBO(final int nRNr, @Nonnull final String sName, final int nAreaSize) {
    // Create new object
    final ExReservatBO aExReservatBO = new ExReservatBO(nRNr, sName, nAreaSize);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExReservatBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExReservatBO.OT, aExReservatBO.getID(), Integer.valueOf(nRNr), sName, Integer.valueOf(nAreaSize));
    return aExReservatBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExReservatBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param nRNr
   *     Schlüsselfeld.
   * @param sName
   *     Name des Reservats. May not be <code>null</code>.
   * @param nAreaSize
   *     Größe in m².
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
  @Nonnull
  public final EChange updateExReservatBO(@Nullable final String sExReservatBOID,
    final int nRNr,
    @Nonnull final String sName,
    final int nAreaSize) {
    final ExReservatBO aExReservatBO = getOfID(sExReservatBOID);
    // Check preconditions
    if (aExReservatBO == null) {
      AuditHelper.onAuditModifyFailure(ExReservatBO.OT, "all", sExReservatBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExReservatBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExReservatBO.OT, "all", sExReservatBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExReservatBO.setRNr(nRNr));
      eChange = eChange.or(aExReservatBO.setName(sName));
      eChange = eChange.or(aExReservatBO.setAreaSize(nAreaSize));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExReservatBO);
      internalUpdateItem(aExReservatBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExReservatBO.OT, "all", aExReservatBO.getID(), Integer.valueOf(nRNr), sName, Integer.valueOf(nAreaSize));
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExReservatBOUndeleted(String)} method.
   * 
   * @param sExReservatBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExReservatBODeleted(@Nullable final String sExReservatBOID) {
    // Check preconditions
    final ExReservatBO aExReservatBO = getOfID(sExReservatBOID);
    if (aExReservatBO == null) {
      AuditHelper.onAuditDeleteFailure(ExReservatBO.OT, sExReservatBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExReservatBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExReservatBO.OT, sExReservatBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExReservatBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExReservatBO.OT, sExReservatBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExReservatBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExReservatBO.OT, sExReservatBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExReservatBODeleted(String)} method.
   * 
   * @param sExReservatBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExReservatBOUndeleted(@Nullable final String sExReservatBOID) {
    // Check preconditions
    final ExReservatBO aExReservatBO = getOfID(sExReservatBOID);
    if (aExReservatBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExReservatBO.OT, sExReservatBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExReservatBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExReservatBO.OT, sExReservatBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExReservatBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExReservatBO.OT, sExReservatBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExReservatBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExReservatBO.OT, sExReservatBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExReservatBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExReservatBO(@Nullable final String sExReservatBOID) {
    final ExReservatBO aDeletedExReservatBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExReservatBO = internalDeleteItem(sExReservatBOID);
      if (aDeletedExReservatBO == null) {
        AuditHelper.onAuditDeleteFailure(ExReservatBO.OT, sExReservatBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExReservatBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExReservatBO.OT, sExReservatBOID, "removed");
    return EChange.CHANGED;
  }
}
