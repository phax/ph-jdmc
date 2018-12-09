package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
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
}
