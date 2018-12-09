package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
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
}
