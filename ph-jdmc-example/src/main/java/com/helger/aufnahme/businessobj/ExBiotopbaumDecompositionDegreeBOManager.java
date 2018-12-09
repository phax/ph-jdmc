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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDecompositionDegreeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
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
}
