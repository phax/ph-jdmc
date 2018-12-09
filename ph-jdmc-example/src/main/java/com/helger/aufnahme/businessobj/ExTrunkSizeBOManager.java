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
}
