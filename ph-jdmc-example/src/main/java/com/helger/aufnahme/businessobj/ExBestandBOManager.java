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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBestandBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBestandBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBestandBO, ExBestandBO>
{

  public ExBestandBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExBestandBO.class, sFilename);
  }

  public ExBestandBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExBestandBO> aInitSettings)
    throws DAOException
  {
    super(ExBestandBO.class, sFilename, aInitSettings);
  }

  @Nonnull
  public final IExBestandBO createExBestandBO(final int nBNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    @Nullable final String sVerortung,
    @Nonnull final ICommonsList<IExHabitatbaumgruppeBO> aBZHBG,
    final int nAreaSize,
    @Nonnull final String sBeschreib,
    final boolean bSameAge,
    final boolean bOneLevel,
    @Nonnull final EExStockTypeBO eStockType,
    @Nonnull final String sUsageDescription,
    @Nonnull final String sGesellschaft,
    final boolean bKronenschluss,
    final boolean bLightWoods,
    final boolean bUnterwuchs,
    @Nonnull final EExStockDeadwoodBO eTotSteh,
    @Nonnull final String sTotStehBesch,
    @Nonnull final EExStockDeadwoodBO eTotLieg,
    @Nonnull final String sTotLiegBesch) {
    // Create new object
    final ExBestandBO aExBestandBO = new ExBestandBO(nBNr, aPics, aDate, sVerortung, aBZHBG, nAreaSize, sBeschreib, bSameAge, bOneLevel, eStockType, sUsageDescription, sGesellschaft, bKronenschluss, bLightWoods, bUnterwuchs, eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExBestandBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExBestandBO.OT, aExBestandBO.getID(), Integer.valueOf(nBNr), aPics, aDate, sVerortung, aBZHBG, Integer.valueOf(nAreaSize), sBeschreib, Boolean.valueOf(bSameAge), Boolean.valueOf(bOneLevel), eStockType, sUsageDescription, sGesellschaft, Boolean.valueOf(bKronenschluss), Boolean.valueOf(bLightWoods), Boolean.valueOf(bUnterwuchs), eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
    return aExBestandBO;
  }

  @Nonnull
  public final EChange updateExBestandBO(@Nullable final String sExBestandBOID,
    final int nBNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    @Nullable final String sVerortung,
    @Nonnull final ICommonsList<IExHabitatbaumgruppeBO> aBZHBG,
    final int nAreaSize,
    @Nonnull final String sBeschreib,
    final boolean bSameAge,
    final boolean bOneLevel,
    @Nonnull final EExStockTypeBO eStockType,
    @Nonnull final String sUsageDescription,
    @Nonnull final String sGesellschaft,
    final boolean bKronenschluss,
    final boolean bLightWoods,
    final boolean bUnterwuchs,
    @Nonnull final EExStockDeadwoodBO eTotSteh,
    @Nonnull final String sTotStehBesch,
    @Nonnull final EExStockDeadwoodBO eTotLieg,
    @Nonnull final String sTotLiegBesch) {
    final ExBestandBO aExBestandBO = getOfID(sExBestandBOID);
    if (aExBestandBO == null) {
      AuditHelper.onAuditModifyFailure(ExBestandBO.OT, "all", sExBestandBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBestandBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExBestandBO.OT, "all", sExBestandBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExBestandBO.setBNr(nBNr));
      eChange = eChange.or(aExBestandBO.setPics(aPics));
      eChange = eChange.or(aExBestandBO.setDate(aDate));
      eChange = eChange.or(aExBestandBO.setVerortung(sVerortung));
      eChange = eChange.or(aExBestandBO.setBZHBG(aBZHBG));
      eChange = eChange.or(aExBestandBO.setAreaSize(nAreaSize));
      eChange = eChange.or(aExBestandBO.setBeschreib(sBeschreib));
      eChange = eChange.or(aExBestandBO.setSameAge(bSameAge));
      eChange = eChange.or(aExBestandBO.setOneLevel(bOneLevel));
      eChange = eChange.or(aExBestandBO.setStockType(eStockType));
      eChange = eChange.or(aExBestandBO.setUsageDescription(sUsageDescription));
      eChange = eChange.or(aExBestandBO.setGesellschaft(sGesellschaft));
      eChange = eChange.or(aExBestandBO.setKronenschluss(bKronenschluss));
      eChange = eChange.or(aExBestandBO.setLightWoods(bLightWoods));
      eChange = eChange.or(aExBestandBO.setUnterwuchs(bUnterwuchs));
      eChange = eChange.or(aExBestandBO.setTotSteh(eTotSteh));
      eChange = eChange.or(aExBestandBO.setTotStehBesch(sTotStehBesch));
      eChange = eChange.or(aExBestandBO.setTotLieg(eTotLieg));
      eChange = eChange.or(aExBestandBO.setTotLiegBesch(sTotLiegBesch));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExBestandBO);
      internalUpdateItem(aExBestandBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditModifySuccess(ExBestandBO.OT, "all", aExBestandBO.getID(), Integer.valueOf(nBNr), aPics, aDate, sVerortung, aBZHBG, Integer.valueOf(nAreaSize), sBeschreib, Boolean.valueOf(bSameAge), Boolean.valueOf(bOneLevel), eStockType, sUsageDescription, sGesellschaft, Boolean.valueOf(bKronenschluss), Boolean.valueOf(bLightWoods), Boolean.valueOf(bUnterwuchs), eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
    return EChange.CHANGED;
  }

  @Nonnull
  public final EChange markDeletedExBestandBO(@Nullable final String sExBestandBOID) {
    final ExBestandBO aExBestandBO = getOfID(sExBestandBOID);
    if (aExBestandBO == null) {
      AuditHelper.onAuditDeleteFailure(ExBestandBO.OT, sExBestandBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBestandBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExBestandBO.OT, sExBestandBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExBestandBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExBestandBO.OT, sExBestandBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExBestandBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBestandBO.OT, aExBestandBO.getID());
    return EChange.CHANGED;
  }
}
