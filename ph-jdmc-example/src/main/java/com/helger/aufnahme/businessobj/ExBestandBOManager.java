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
}
