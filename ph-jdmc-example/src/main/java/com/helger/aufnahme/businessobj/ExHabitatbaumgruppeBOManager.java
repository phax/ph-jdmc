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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExHabitatbaumgruppeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExHabitatbaumgruppeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExHabitatbaumgruppeBO, ExHabitatbaumgruppeBO>
{

  public ExHabitatbaumgruppeBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExHabitatbaumgruppeBO.class, sFilename);
  }

  public ExHabitatbaumgruppeBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExHabitatbaumgruppeBO> aInitSettings)
    throws DAOException
  {
    super(ExHabitatbaumgruppeBO.class, sFilename, aInitSettings);
  }

  @Nonnull
  public final IExHabitatbaumgruppeBO createExHabitatbaumgruppeBO(final int nHBGNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final ICommonsList<IExBiotopbaumBO> aHBGzBB,
    @Nonnull final LocalDate aDate,
    @Nonnull final String sStandort,
    final boolean bOneLevel,
    final boolean bLight,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bHomogen,
    @Nonnull final EExExpositionBO eExposition,
    @Nullable final String sHanglage,
    final int nAreaSize,
    final boolean bOnlyBB,
    @Nonnull final String sBeschreibung) {
    // Create new object
    final ExHabitatbaumgruppeBO aExHabitatbaumgruppeBO = new ExHabitatbaumgruppeBO(nHBGNr, aPics, aHBGzBB, aDate, sStandort, bOneLevel, bLight, bClosedCrown, bNoSun, bHomogen, eExposition, sHanglage, nAreaSize, bOnlyBB, sBeschreibung);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExHabitatbaumgruppeBO.OT, aExHabitatbaumgruppeBO.getID(), Integer.valueOf(nHBGNr), aPics, aHBGzBB, aDate, sStandort, Boolean.valueOf(bOneLevel), Boolean.valueOf(bLight), Boolean.valueOf(bClosedCrown), Boolean.valueOf(bNoSun), Boolean.valueOf(bHomogen), eExposition, sHanglage, Integer.valueOf(nAreaSize), Boolean.valueOf(bOnlyBB), sBeschreibung);
    return aExHabitatbaumgruppeBO;
  }
}
