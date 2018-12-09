package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
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
}
