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
}
