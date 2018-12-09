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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExStichprobeDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExStichprobeDeadwoodBOManager
  extends AbstractPhotonMapBasedWALDAO<IExStichprobeDeadwoodBO, ExStichprobeDeadwoodBO>
{

  public ExStichprobeDeadwoodBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExStichprobeDeadwoodBO.class, sFilename);
  }

  public ExStichprobeDeadwoodBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExStichprobeDeadwoodBO> aInitSettings)
    throws DAOException
  {
    super(ExStichprobeDeadwoodBO.class, sFilename, aInitSettings);
  }

  @Nonnull
  public final IExStichprobeDeadwoodBO createExStichprobeDeadwoodBO(@Nonnull final EExDecompositionDegreeClassBO eDoD,
    @Nonnull final EExTreeKindBO eTreeKind,
    final int nLength,
    final int nBHD) {
    // Create new object
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = new ExStichprobeDeadwoodBO(eDoD, eTreeKind, nLength, nBHD);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExStichprobeDeadwoodBO.OT, aExStichprobeDeadwoodBO.getID(), eDoD, eTreeKind, Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return aExStichprobeDeadwoodBO;
  }

  @Nonnull
  public final EChange updateExStichprobeDeadwoodBO(@Nullable final String sExStichprobeDeadwoodBOID,
    @Nonnull final EExDecompositionDegreeClassBO eDoD,
    @Nonnull final EExTreeKindBO eTreeKind,
    final int nLength,
    final int nBHD) {
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = getOfID(sExStichprobeDeadwoodBOID);
    if (aExStichprobeDeadwoodBO == null) {
      AuditHelper.onAuditModifyFailure(ExStichprobeDeadwoodBO.OT, "all", sExStichprobeDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExStichprobeDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExStichprobeDeadwoodBO.OT, "all", sExStichprobeDeadwoodBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExStichprobeDeadwoodBO.setDoD(eDoD));
      eChange = eChange.or(aExStichprobeDeadwoodBO.setTreeKind(eTreeKind));
      eChange = eChange.or(aExStichprobeDeadwoodBO.setLength(nLength));
      eChange = eChange.or(aExStichprobeDeadwoodBO.setBHD(nBHD));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExStichprobeDeadwoodBO);
      internalUpdateItem(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExStichprobeDeadwoodBO.OT, "all", aExStichprobeDeadwoodBO.getID(), eDoD, eTreeKind, Integer.valueOf(nLength), Integer.valueOf(nBHD));
    return EChange.CHANGED;
  }

  @Nonnull
  public final EChange markDeletedExStichprobeDeadwoodBO(@Nullable final String sExStichprobeDeadwoodBOID) {
    final ExStichprobeDeadwoodBO aExStichprobeDeadwoodBO = getOfID(sExStichprobeDeadwoodBOID);
    if (aExStichprobeDeadwoodBO == null) {
      AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExStichprobeDeadwoodBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExStichprobeDeadwoodBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExStichprobeDeadwoodBO.OT, sExStichprobeDeadwoodBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExStichprobeDeadwoodBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExStichprobeDeadwoodBO.OT, aExStichprobeDeadwoodBO.getID());
    return EChange.CHANGED;
  }
}
