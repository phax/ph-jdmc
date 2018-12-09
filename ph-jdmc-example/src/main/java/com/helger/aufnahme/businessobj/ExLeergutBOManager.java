package com.helger.aufnahme.businessobj;

import com.helger.commons.state.EChange;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
import com.helger.photon.security.object.BusinessObjectHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExLeergutBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
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

  @Nonnull
  public final EChange updateExLeergutBO(@Nullable final String sExLeergutBOID) {
    final ExLeergutBO aExLeergutBO = getOfID(sExLeergutBOID);
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

  @Nonnull
  public final EChange markDeletedExLeergutBO(@Nullable final String sExLeergutBOID) {
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
    AuditHelper.onAuditDeleteSuccess(ExLeergutBO.OT, aExLeergutBO.getID());
    return EChange.CHANGED;
  }
}
