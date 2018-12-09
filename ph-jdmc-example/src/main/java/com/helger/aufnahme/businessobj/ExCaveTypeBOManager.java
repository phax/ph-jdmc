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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExCaveTypeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
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

  @Nonnull
  public final EChange updateExCaveTypeBO(@Nullable final String sExCaveTypeBOID, @Nonnull final EExCaveClassBO eClazz, @Nonnull final EExCaveTypeBO eType) {
    final ExCaveTypeBO aExCaveTypeBO = getOfID(sExCaveTypeBOID);
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

  @Nonnull
  public final EChange markDeletedExCaveTypeBO(@Nullable final String sExCaveTypeBOID) {
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
    AuditHelper.onAuditDeleteSuccess(ExCaveTypeBO.OT, aExCaveTypeBO.getID());
    return EChange.CHANGED;
  }
}
