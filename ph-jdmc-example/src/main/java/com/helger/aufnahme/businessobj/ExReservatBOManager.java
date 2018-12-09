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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExReservatBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
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

  @Nonnull
  public final EChange updateExReservatBO(@Nullable final String sExReservatBOID,
    final int nRNr,
    @Nonnull final String sName,
    final int nAreaSize) {
    final ExReservatBO aExReservatBO = getOfID(sExReservatBOID);
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
    return EChange.CHANGED;
  }
}
