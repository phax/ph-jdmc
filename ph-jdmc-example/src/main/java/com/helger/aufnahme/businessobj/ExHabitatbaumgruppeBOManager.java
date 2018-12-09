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

  @Nonnull
  public final EChange updateExHabitatbaumgruppeBO(@Nullable final String sExHabitatbaumgruppeBOID,
    final int nHBGNr,
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
    final ExHabitatbaumgruppeBO aExHabitatbaumgruppeBO = getOfID(sExHabitatbaumgruppeBOID);
    if (aExHabitatbaumgruppeBO == null) {
      AuditHelper.onAuditModifyFailure(ExHabitatbaumgruppeBO.OT, "all", sExHabitatbaumgruppeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExHabitatbaumgruppeBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExHabitatbaumgruppeBO.OT, "all", sExHabitatbaumgruppeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHBGNr(nHBGNr));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setPics(aPics));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHBGzBB(aHBGzBB));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setDate(aDate));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setStandort(sStandort));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setOneLevel(bOneLevel));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setLight(bLight));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setClosedCrown(bClosedCrown));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setNoSun(bNoSun));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHomogen(bHomogen));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setExposition(eExposition));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setHanglage(sHanglage));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setAreaSize(nAreaSize));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setOnlyBB(bOnlyBB));
      eChange = eChange.or(aExHabitatbaumgruppeBO.setBeschreibung(sBeschreibung));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExHabitatbaumgruppeBO);
      internalUpdateItem(aExHabitatbaumgruppeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExHabitatbaumgruppeBO.OT, "all", aExHabitatbaumgruppeBO.getID(), Integer.valueOf(nHBGNr), aPics, aHBGzBB, aDate, sStandort, Boolean.valueOf(bOneLevel), Boolean.valueOf(bLight), Boolean.valueOf(bClosedCrown), Boolean.valueOf(bNoSun), Boolean.valueOf(bHomogen), eExposition, sHanglage, Integer.valueOf(nAreaSize), Boolean.valueOf(bOnlyBB), sBeschreibung);
    return EChange.CHANGED;
  }
}
