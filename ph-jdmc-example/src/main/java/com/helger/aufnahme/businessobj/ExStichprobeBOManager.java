package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.state.EChange;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.basic.audit.AuditHelper;
import com.helger.photon.security.object.BusinessObjectHelper;
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

  @Nonnull
  public final EChange updateExStichprobeBO(@Nullable final String sExStichprobeBOID,
    final int nStichNr,
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
    final ExStichprobeBO aExStichprobeBO = getOfID(sExStichprobeBOID);
    if (aExStichprobeBO == null) {
      AuditHelper.onAuditModifyFailure(ExStichprobeBO.OT, "all", sExStichprobeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExStichprobeBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExStichprobeBO.OT, "all", sExStichprobeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExStichprobeBO.setStichNr(nStichNr));
      eChange = eChange.or(aExStichprobeBO.setStichNrzR(aStichNrzR));
      eChange = eChange.or(aExStichprobeBO.setPics(aPics));
      eChange = eChange.or(aExStichprobeBO.setDate(aDate));
      eChange = eChange.or(aExStichprobeBO.setSize(nSize));
      eChange = eChange.or(aExStichprobeBO.setExposition(eExposition));
      eChange = eChange.or(aExStichprobeBO.setHanglage(sHanglage));
      eChange = eChange.or(aExStichprobeBO.setGesellschaft(sGesellschaft));
      eChange = eChange.or(aExStichprobeBO.setBKL0(dBKL0));
      eChange = eChange.or(aExStichprobeBO.setBKL1(dBKL1));
      eChange = eChange.or(aExStichprobeBO.setBKL2(dBKL2));
      eChange = eChange.or(aExStichprobeBO.setBKL3(dBKL3));
      eChange = eChange.or(aExStichprobeBO.setBKL4(dBKL4));
      eChange = eChange.or(aExStichprobeBO.setBKL5(dBKL5));
      eChange = eChange.or(aExStichprobeBO.setBKL6(dBKL6));
      eChange = eChange.or(aExStichprobeBO.setBKL7(dBKL7));
      eChange = eChange.or(aExStichprobeBO.setBKL8(dBKL8));
      eChange = eChange.or(aExStichprobeBO.setBKL9(dBKL9));
      eChange = eChange.or(aExStichprobeBO.setUsage(sUsage));
      eChange = eChange.or(aExStichprobeBO.setUsageDesc(sUsageDesc));
      eChange = eChange.or(aExStichprobeBO.setTrees(aTrees));
      eChange = eChange.or(aExStichprobeBO.setDesc(sDesc));
      eChange = eChange.or(aExStichprobeBO.setSameAge(bSameAge));
      eChange = eChange.or(aExStichprobeBO.setOneLevel(bOneLevel));
      eChange = eChange.or(aExStichprobeBO.setTotSteh(aTotSteh));
      eChange = eChange.or(aExStichprobeBO.setTotLieg1(aTotLieg1));
      eChange = eChange.or(aExStichprobeBO.setTotLieg2(aTotLieg2));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExStichprobeBO);
      internalUpdateItem(aExStichprobeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExStichprobeBO.OT, "all", aExStichprobeBO.getID(), Integer.valueOf(nStichNr), aStichNrzR, aPics, aDate, Integer.valueOf(nSize), eExposition, sHanglage, sGesellschaft, Double.valueOf(dBKL0), Double.valueOf(dBKL1), Double.valueOf(dBKL2), Double.valueOf(dBKL3), Double.valueOf(dBKL4), Double.valueOf(dBKL5), Double.valueOf(dBKL6), Double.valueOf(dBKL7), Double.valueOf(dBKL8), Double.valueOf(dBKL9), sUsage, sUsageDesc, aTrees, sDesc, Boolean.valueOf(bSameAge), Boolean.valueOf(bOneLevel), aTotSteh, aTotLieg1, aTotLieg2);
    return EChange.CHANGED;
  }
}
