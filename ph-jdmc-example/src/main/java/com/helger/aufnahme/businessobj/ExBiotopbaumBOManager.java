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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBiotopbaumBO, ExBiotopbaumBO>
{

  public ExBiotopbaumBOManager(@Nullable final String sFilename)
    throws DAOException
  {
    super(ExBiotopbaumBO.class, sFilename);
  }

  public ExBiotopbaumBOManager(@Nullable final String sFilename, @Nonnull final AbstractMapBasedWALDAO.InitSettings<ExBiotopbaumBO> aInitSettings)
    throws DAOException
  {
    super(ExBiotopbaumBO.class, sFilename, aInitSettings);
  }

  @Nonnull
  public final IExBiotopbaumBO createExBiotopbaumBO(final int nBBNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    @Nonnull @Nonempty final ICommonsList<EExBiotopbaumTypeBO> aType,
    @Nullable final String sLocation,
    @Nonnull final EExExpositionBO eExposition,
    @Nullable final String sHanglage,
    final boolean bEinschichtig,
    final boolean bSolitary,
    final boolean bLightLocation,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bUeberSun,
    final boolean bHomogene,
    @Nonnull final String sBeschreibung,
    @Nonnull final EExTreeKindBO eTreeKind,
    @Nonnull final ICommonsList<IExCaveTypeBO> aCaves,
    @Nonnull @Nonempty final ICommonsList<IExTrunkSizeBO> aTrunk,
    @Nonnull final EExVitalityBO eVitality,
    @Nonnull final ICommonsList<EExSpecialStructureBO> aSpecialStructure,
    @Nullable final String sOtherSpecial,
    final boolean bAspirant,
    @Nullable final String sAspirantDesc,
    final boolean bMarked,
    @Nullable final String sMarkedDesc,
    @Nonnull final ICommonsList<IExBiotopbaumDeadwoodBO> aDeadwoodCats,
    @Nonnull final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD) {
    // Create new object
    final ExBiotopbaumBO aExBiotopbaumBO = new ExBiotopbaumBO(nBBNr, aPics, aDate, aType, sLocation, eExposition, sHanglage, bEinschichtig, bSolitary, bLightLocation, bClosedCrown, bNoSun, bUeberSun, bHomogene, sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, aSpecialStructure, sOtherSpecial, bAspirant, sAspirantDesc, bMarked, sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExBiotopbaumBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExBiotopbaumBO.OT, aExBiotopbaumBO.getID(), Integer.valueOf(nBBNr), aPics, aDate, aType, sLocation, eExposition, sHanglage, Boolean.valueOf(bEinschichtig), Boolean.valueOf(bSolitary), Boolean.valueOf(bLightLocation), Boolean.valueOf(bClosedCrown), Boolean.valueOf(bNoSun), Boolean.valueOf(bUeberSun), Boolean.valueOf(bHomogene), sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, aSpecialStructure, sOtherSpecial, Boolean.valueOf(bAspirant), sAspirantDesc, Boolean.valueOf(bMarked), sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
    return aExBiotopbaumBO;
  }

  @Nonnull
  public final EChange updateExBiotopbaumBO(@Nullable final String sExBiotopbaumBOID,
    final int nBBNr,
    @Nonnull @Nonempty final ICommonsList<File> aPics,
    @Nonnull final LocalDate aDate,
    @Nonnull @Nonempty final ICommonsList<EExBiotopbaumTypeBO> aType,
    @Nullable final String sLocation,
    @Nonnull final EExExpositionBO eExposition,
    @Nullable final String sHanglage,
    final boolean bEinschichtig,
    final boolean bSolitary,
    final boolean bLightLocation,
    final boolean bClosedCrown,
    final boolean bNoSun,
    final boolean bUeberSun,
    final boolean bHomogene,
    @Nonnull final String sBeschreibung,
    @Nonnull final EExTreeKindBO eTreeKind,
    @Nonnull final ICommonsList<IExCaveTypeBO> aCaves,
    @Nonnull @Nonempty final ICommonsList<IExTrunkSizeBO> aTrunk,
    @Nonnull final EExVitalityBO eVitality,
    @Nonnull final ICommonsList<EExSpecialStructureBO> aSpecialStructure,
    @Nullable final String sOtherSpecial,
    final boolean bAspirant,
    @Nullable final String sAspirantDesc,
    final boolean bMarked,
    @Nullable final String sMarkedDesc,
    @Nonnull final ICommonsList<IExBiotopbaumDeadwoodBO> aDeadwoodCats,
    @Nonnull final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD) {
    final ExBiotopbaumBO aExBiotopbaumBO = getOfID(sExBiotopbaumBOID);
    if (aExBiotopbaumBO == null) {
      AuditHelper.onAuditModifyFailure(ExBiotopbaumBO.OT, "all", sExBiotopbaumBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBiotopbaumBO.isDeleted()) {
      AuditHelper.onAuditModifyFailure(ExBiotopbaumBO.OT, "all", sExBiotopbaumBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Update internally
    m_aRWLock.writeLock().lock();
    try {
      EChange eChange = EChange.UNCHANGED;
      eChange = eChange.or(aExBiotopbaumBO.setBBNr(nBBNr));
      eChange = eChange.or(aExBiotopbaumBO.setPics(aPics));
      eChange = eChange.or(aExBiotopbaumBO.setDate(aDate));
      eChange = eChange.or(aExBiotopbaumBO.setType(aType));
      eChange = eChange.or(aExBiotopbaumBO.setLocation(sLocation));
      eChange = eChange.or(aExBiotopbaumBO.setExposition(eExposition));
      eChange = eChange.or(aExBiotopbaumBO.setHanglage(sHanglage));
      eChange = eChange.or(aExBiotopbaumBO.setEinschichtig(bEinschichtig));
      eChange = eChange.or(aExBiotopbaumBO.setSolitary(bSolitary));
      eChange = eChange.or(aExBiotopbaumBO.setLightLocation(bLightLocation));
      eChange = eChange.or(aExBiotopbaumBO.setClosedCrown(bClosedCrown));
      eChange = eChange.or(aExBiotopbaumBO.setNoSun(bNoSun));
      eChange = eChange.or(aExBiotopbaumBO.setUeberSun(bUeberSun));
      eChange = eChange.or(aExBiotopbaumBO.setHomogene(bHomogene));
      eChange = eChange.or(aExBiotopbaumBO.setBeschreibung(sBeschreibung));
      eChange = eChange.or(aExBiotopbaumBO.setTreeKind(eTreeKind));
      eChange = eChange.or(aExBiotopbaumBO.setCaves(aCaves));
      eChange = eChange.or(aExBiotopbaumBO.setTrunk(aTrunk));
      eChange = eChange.or(aExBiotopbaumBO.setVitality(eVitality));
      eChange = eChange.or(aExBiotopbaumBO.setSpecialStructure(aSpecialStructure));
      eChange = eChange.or(aExBiotopbaumBO.setOtherSpecial(sOtherSpecial));
      eChange = eChange.or(aExBiotopbaumBO.setAspirant(bAspirant));
      eChange = eChange.or(aExBiotopbaumBO.setAspirantDesc(sAspirantDesc));
      eChange = eChange.or(aExBiotopbaumBO.setMarked(bMarked));
      eChange = eChange.or(aExBiotopbaumBO.setMarkedDesc(sMarkedDesc));
      eChange = eChange.or(aExBiotopbaumBO.setDeadwoodCats(aDeadwoodCats));
      eChange = eChange.or(aExBiotopbaumBO.setDeadwoodDoD(aDeadwoodDoD));
      if (eChange.isUnchanged()) {
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setLastModificationNow(aExBiotopbaumBO);
      internalUpdateItem(aExBiotopbaumBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    return EChange.CHANGED;
  }
}
