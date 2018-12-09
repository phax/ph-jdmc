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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
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

  @Nonnull
  public final EChange updateExBiotopbaumDeadwoodBO(@Nullable final String sExBiotopbaumDeadwoodBOID,
    @Nonnull final EExDeadwoodCategoryBO eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    final ExBiotopbaumDeadwoodBO aExBiotopbaumDeadwoodBO = getOfID(sExBiotopbaumDeadwoodBOID);
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
}
