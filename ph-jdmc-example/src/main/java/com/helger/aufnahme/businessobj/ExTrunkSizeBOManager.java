package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExTrunkSizeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
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
}
