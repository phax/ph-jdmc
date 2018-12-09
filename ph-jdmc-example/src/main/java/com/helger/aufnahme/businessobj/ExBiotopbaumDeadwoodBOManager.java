package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
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
}
