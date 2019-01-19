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
import javax.annotation.concurrent.ThreadSafe;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBestandBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
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

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param nBNr
   *     Schlüsselfeld.
   * @param aPics
   *     Foto-Nr. May neither be <code>null</code> nor empty.
   * @param aDate
   *     LocalDate value. May not be <code>null</code>.
   * @param sVerortung
   *     GPS-Punkte oder Verweis auf Polygon. May be <code>null</code>.
   * @param aBZHBG
   *     Habitatbaumgruppen. May not be <code>null</code>.
   * @param nAreaSize
   *     Größe in m².
   * @param sBeschreib
   *     Bestand-Beschreibung. May not be <code>null</code>.
   * @param bSameAge
   *     gleichaltrig oder ungleichaltrig.
   * @param bOneLevel
   *     einschichtig oder mehrschichtig.
   * @param eStockType
   *     Bestandesklasse. May not be <code>null</code>.
   * @param eStockTypeOpt
   *     Bestandesklasse optional. May be <code>null</code>.
   * @param sUsageDescription
   *     Beschreibung Nutzungsspuren. May not be <code>null</code>.
   * @param sGesellschaft
   *     Waldgesellschaft oder Waldgruppe. May not be <code>null</code>.
   * @param bKronenschluss
   *     Boolean value.
   * @param bLightWoods
   *     räumig oder lückig stehendes Holz (lichter Bestand).
   * @param bUnterwuchs
   *     Unterwuchs.
   * @param eTotSteh
   *     Schätzung Totholz stehend. May not be <code>null</code>.
   * @param sTotStehBesch
   *     Beschreibung Totholz stehend (geklumpt, Art, Herkunft, Zersetzungsgrade). May not be <code>null</code>.
   * @param eTotLieg
   *     Schätzung Totholz liegend. May not be <code>null</code>.
   * @param sTotLiegBesch
   *     Beschreibung Totholz liegend (geklumpt, Art, Herkunft, Zersetzungsgrade). May not be <code>null</code>.
   * @return
   *     The created object and never <code>null</code>.
   */
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
    @Nullable final EExStockTypeBO eStockTypeOpt,
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
    final ExBestandBO aExBestandBO = new ExBestandBO(nBNr, aPics, aDate, sVerortung, aBZHBG, nAreaSize, sBeschreib, bSameAge, bOneLevel, eStockType, eStockTypeOpt, sUsageDescription, sGesellschaft, bKronenschluss, bLightWoods, bUnterwuchs, eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
    // Save internally
    m_aRWLock.writeLock().lock();
    try {
      internalCreateItem(aExBestandBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditCreateSuccess(ExBestandBO.OT, aExBestandBO.getID(), Integer.valueOf(nBNr), aPics, aDate, sVerortung, aBZHBG, Integer.valueOf(nAreaSize), sBeschreib, Boolean.valueOf(bSameAge), Boolean.valueOf(bOneLevel), eStockType, eStockTypeOpt, sUsageDescription, sGesellschaft, Boolean.valueOf(bKronenschluss), Boolean.valueOf(bLightWoods), Boolean.valueOf(bUnterwuchs), eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
    return aExBestandBO;
  }

  /**
   * Update an existing object with new values.
   * 
   * @param sExBestandBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param nBNr
   *     Schlüsselfeld.
   * @param aPics
   *     Foto-Nr. May neither be <code>null</code> nor empty.
   * @param aDate
   *     LocalDate value. May not be <code>null</code>.
   * @param sVerortung
   *     GPS-Punkte oder Verweis auf Polygon. May be <code>null</code>.
   * @param aBZHBG
   *     Habitatbaumgruppen. May not be <code>null</code>.
   * @param nAreaSize
   *     Größe in m².
   * @param sBeschreib
   *     Bestand-Beschreibung. May not be <code>null</code>.
   * @param bSameAge
   *     gleichaltrig oder ungleichaltrig.
   * @param bOneLevel
   *     einschichtig oder mehrschichtig.
   * @param eStockType
   *     Bestandesklasse. May not be <code>null</code>.
   * @param eStockTypeOpt
   *     Bestandesklasse optional. May be <code>null</code>.
   * @param sUsageDescription
   *     Beschreibung Nutzungsspuren. May not be <code>null</code>.
   * @param sGesellschaft
   *     Waldgesellschaft oder Waldgruppe. May not be <code>null</code>.
   * @param bKronenschluss
   *     Boolean value.
   * @param bLightWoods
   *     räumig oder lückig stehendes Holz (lichter Bestand).
   * @param bUnterwuchs
   *     Unterwuchs.
   * @param eTotSteh
   *     Schätzung Totholz stehend. May not be <code>null</code>.
   * @param sTotStehBesch
   *     Beschreibung Totholz stehend (geklumpt, Art, Herkunft, Zersetzungsgrade). May not be <code>null</code>.
   * @param eTotLieg
   *     Schätzung Totholz liegend. May not be <code>null</code>.
   * @param sTotLiegBesch
   *     Beschreibung Totholz liegend (geklumpt, Art, Herkunft, Zersetzungsgrade). May not be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
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
    @Nullable final EExStockTypeBO eStockTypeOpt,
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
    // Check preconditions
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
      eChange = eChange.or(aExBestandBO.setStockTypeOpt(eStockTypeOpt));
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
    AuditHelper.onAuditModifySuccess(ExBestandBO.OT, "all", aExBestandBO.getID(), Integer.valueOf(nBNr), aPics, aDate, sVerortung, aBZHBG, Integer.valueOf(nAreaSize), sBeschreib, Boolean.valueOf(bSameAge), Boolean.valueOf(bOneLevel), eStockType, eStockTypeOpt, sUsageDescription, sGesellschaft, Boolean.valueOf(bKronenschluss), Boolean.valueOf(bLightWoods), Boolean.valueOf(bUnterwuchs), eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExBestandBOUndeleted(String)} method.
   * 
   * @param sExBestandBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBestandBODeleted(@Nullable final String sExBestandBOID) {
    // Check preconditions
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
    AuditHelper.onAuditDeleteSuccess(ExBestandBO.OT, sExBestandBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExBestandBODeleted(String)} method.
   * 
   * @param sExBestandBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBestandBOUndeleted(@Nullable final String sExBestandBOID) {
    // Check preconditions
    final ExBestandBO aExBestandBO = getOfID(sExBestandBOID);
    if (aExBestandBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExBestandBO.OT, sExBestandBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExBestandBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExBestandBO.OT, sExBestandBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExBestandBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExBestandBO.OT, sExBestandBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExBestandBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExBestandBO.OT, sExBestandBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExBestandBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExBestandBO(@Nullable final String sExBestandBOID) {
    final ExBestandBO aDeletedExBestandBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExBestandBO = internalDeleteItem(sExBestandBOID);
      if (aDeletedExBestandBO == null) {
        AuditHelper.onAuditDeleteFailure(ExBestandBO.OT, sExBestandBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExBestandBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBestandBO.OT, sExBestandBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExBestandBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExBestandBO getExBestandBOOfID(@Nullable final String sExBestandBOID) {
    return getOfID(sExBestandBOID);
  }
}
