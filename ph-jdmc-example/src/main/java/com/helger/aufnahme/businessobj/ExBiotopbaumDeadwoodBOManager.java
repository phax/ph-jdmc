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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
public class ExBiotopbaumDeadwoodBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBiotopbaumDeadwoodBO, ExBiotopbaumDeadwoodBO>
{

  public ExBiotopbaumDeadwoodBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExBiotopbaumDeadwoodBO.class, sFilename);
  }

  public ExBiotopbaumDeadwoodBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExBiotopbaumDeadwoodBO> aInitSettings)
    throws DAOException
  {
    super(ExBiotopbaumDeadwoodBO.class, sFilename, aInitSettings);
  }

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param eType
   *     Totholzkategorie. May not be <code>null</code>.
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
  public final IExBiotopbaumDeadwoodBO createExBiotopbaumDeadwoodBO(@Nonnull final EExDeadwoodCategoryBO eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    // Create new object
    final ExBiotopbaumDeadwoodBO aExBiotopbaumDeadwoodBO = new ExBiotopbaumDeadwoodBO(eType, bEnabled, nLength, nBHD);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExBiotopbaumDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExBiotopbaumDeadwoodBO.OT, aExBiotopbaumDeadwoodBO.getID(), eType, Boolean.valueOf(bEnabled), Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return aExBiotopbaumDeadwoodBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExBiotopbaumDeadwoodBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param eType
   *     Totholzkategorie. May not be <code>null</code>.
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
  public final EChange updateExBiotopbaumDeadwoodBO(@Nullable final String sExBiotopbaumDeadwoodBOID,
    @Nonnull final EExDeadwoodCategoryBO eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    final ExBiotopbaumDeadwoodBO aExBiotopbaumDeadwoodBO = getOfID(sExBiotopbaumDeadwoodBOID);
    // Check preconditions
    if (aExBiotopbaumDeadwoodBO == null) {
      AuditHelper.onAuditModifyFailure(ExBiotopbaumDeadwoodBO.OT, "all", sExBiotopbaumDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBiotopbaumDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExBiotopbaumDeadwoodBO.OT, "all", sExBiotopbaumDeadwoodBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExBiotopbaumDeadwoodBO.setType(eType));
      eChange = eChange.or(aExBiotopbaumDeadwoodBO.setEnabled(bEnabled));
      eChange = eChange.or(aExBiotopbaumDeadwoodBO.setLength(nLength));
      eChange = eChange.or(aExBiotopbaumDeadwoodBO.setBHD(nBHD));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExBiotopbaumDeadwoodBO);
      internalUpdateItem(aExBiotopbaumDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExBiotopbaumDeadwoodBO.OT, "all", aExBiotopbaumDeadwoodBO.getID(), eType, Boolean.valueOf(bEnabled), Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExBiotopbaumDeadwoodBOUndeleted(String)} method.
   * 
   * @param sExBiotopbaumDeadwoodBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBiotopbaumDeadwoodBODeleted(@Nullable final String sExBiotopbaumDeadwoodBOID) {
    // Check preconditions
    final ExBiotopbaumDeadwoodBO aExBiotopbaumDeadwoodBO = getOfID(sExBiotopbaumDeadwoodBOID);
    if (aExBiotopbaumDeadwoodBO == null) {
      AuditHelper.onAuditDeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBiotopbaumDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExBiotopbaumDeadwoodBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExBiotopbaumDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExBiotopbaumDeadwoodBODeleted(String)} method.
   * 
   * @param sExBiotopbaumDeadwoodBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBiotopbaumDeadwoodBOUndeleted(@Nullable final String sExBiotopbaumDeadwoodBOID) {
    // Check preconditions
    final ExBiotopbaumDeadwoodBO aExBiotopbaumDeadwoodBO = getOfID(sExBiotopbaumDeadwoodBOID);
    if (aExBiotopbaumDeadwoodBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExBiotopbaumDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExBiotopbaumDeadwoodBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExBiotopbaumDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExBiotopbaumDeadwoodBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExBiotopbaumDeadwoodBO(@Nullable final String sExBiotopbaumDeadwoodBOID) {
    final ExBiotopbaumDeadwoodBO aDeletedExBiotopbaumDeadwoodBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExBiotopbaumDeadwoodBO = internalDeleteItem(sExBiotopbaumDeadwoodBOID);
      if (aDeletedExBiotopbaumDeadwoodBO == null) {
        AuditHelper.onAuditDeleteFailure(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExBiotopbaumDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBiotopbaumDeadwoodBO.OT, sExBiotopbaumDeadwoodBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExBiotopbaumDeadwoodBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExBiotopbaumDeadwoodBO getExBiotopbaumDeadwoodBOOfID(@Nullable final String sExBiotopbaumDeadwoodBOID) {
    return getOfID(sExBiotopbaumDeadwoodBOID);
  }
}
