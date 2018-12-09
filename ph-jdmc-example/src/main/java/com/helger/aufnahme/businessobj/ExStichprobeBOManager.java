package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExStichprobeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExStichprobeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExStichprobeBO, ExStichprobeBO>
{

  public ExStichprobeBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExStichprobeBO.class, sFilename);
  }

  public ExStichprobeBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExStichprobeBO> aInitSettings)
    throws DAOException
  {
    super(ExStichprobeBO.class, sFilename, aInitSettings);
  }

  @Nonnull
  public final IExStichprobeBO createExStichprobeBO(final int nStichNr,
    @Nonnull final IExReservatBO aStichNrzR,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    final int nSize,
    @Nonnull final EExExpositionBO eExposition,
    @Nullable final String sHanglage,
    @Nonnull final String sGesellschaft,
    final double dBKL0,
    final double dBKL1,
    final double dBKL2,
    final double dBKL3,
    final double dBKL4,
    final double dBKL5,
    final double dBKL6,
    final double dBKL7,
    final double dBKL8,
    final double dBKL9,
    @Nonnull final String sUsage,
    @Nonnull final String sUsageDesc,
    @Nonnull final ICommonsList<IExBiotopbaumBO> aTrees,
    @Nonnull final String sDesc,
    final boolean bSameAge,
    final boolean bOneLevel,
    @Nonnull final ICommonsList<IExStichprobeDeadwoodBO> aTotSteh,
    @Nonnull final ICommonsList<IExStichprobeDeadwoodBO> aTotLieg1,
    @Nonnull final ICommonsList<IExStichprobeDeadwoodBO> aTotLieg2) {
    // Create new object
    final ExStichprobeBO aExStichprobeBO = new ExStichprobeBO(nStichNr, aStichNrzR, aPics, aDate, nSize, eExposition, sHanglage, sGesellschaft, dBKL0, dBKL1, dBKL2, dBKL3, dBKL4, dBKL5, dBKL6, dBKL7, dBKL8, dBKL9, sUsage, sUsageDesc, aTrees, sDesc, bSameAge, bOneLevel, aTotSteh, aTotLieg1, aTotLieg2);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExStichprobeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExStichprobeBO.OT, aExStichprobeBO.getID(), Integer.valueOf(nStichNr), aStichNrzR, aPics, aDate, Integer.valueOf(nSize), eExposition, sHanglage, sGesellschaft, Double.valueOf(dBKL0), Double.valueOf(dBKL1), Double.valueOf(dBKL2), Double.valueOf(dBKL3), Double.valueOf(dBKL4), Double.valueOf(dBKL5), Double.valueOf(dBKL6), Double.valueOf(dBKL7), Double.valueOf(dBKL8), Double.valueOf(dBKL9), sUsage, sUsageDesc, aTrees, sDesc, Boolean.valueOf(bSameAge), Boolean.valueOf(bOneLevel), aTotSteh, aTotLieg1, aTotLieg2);
    return aExStichprobeBO;
  }
}
