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
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
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

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param nBBNr
   *     Schlüsselfeld.
   * @param aPics
   *     Foto. May neither be <code>null</code> nor empty.
   * @param aDate
   *     Aufnahmedatum. May not be <code>null</code>.
   * @param aType
   *     Biotopbaum-Typ (Hauptauswahlkriterium). May neither be <code>null</code> nor empty.
   * @param sLocation
   *     allg. Beschreibung des Standorts. May be <code>null</code>.
   * @param eExposition
   *     Exposition. May not be <code>null</code>.
   * @param sHanglage
   *     Angabe von Neigungen: keine, Angabe von Neigungen, Freitext. May be <code>null</code>.
   * @param bEinschichtig
   *     Wald, einschichtig (1 Baumschicht, kaum Unterwuchs) oder mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht).
   * @param bSolitary
   *     Solitärbaum.
   * @param bLightLocation
   *     lichter Bestand (Besonnung).
   * @param bClosedCrown
   *     geschlossene Kronendach.
   * @param bNoSun
   *     explitzit keine Besonnung.
   * @param bUeberSun
   *     Überhälter, mind. 25% oder weniger als 25% des Stammes besonnt.
   * @param bHomogene
   *     eingebettet in homogenene oder heterogene Umgebung.
   * @param sBeschreibung
   *     Bemerkungen/ (ausführliche) Beschreibung. May not be <code>null</code>.
   * @param eTreeKind
   *     Baumart laut Aufnahmeblatt. May not be <code>null</code>.
   * @param aCaves
   *     Höhlentyp und Anzahl mit Klasseneinteilung (Checkbox, mehrere möglich; dann noch Klassenangaben; C22-35 im Aufnahmemanual). May not be <code>null</code>.
   * @param aTrunk
   *     Daten zum Stamm/zu den Stämmen. May neither be <code>null</code> nor empty.
   * @param eVitality
   *     Vitalität. May not be <code>null</code>.
   * @param aSpecialStructure
   *     Baum-Sonderstrukturen (Mehrfachnennung möglich). May not be <code>null</code>.
   * @param sOtherSpecial
   *     Sonstige Sonderstrukturen inkl. Beschreibung. May be <code>null</code>.
   * @param bAspirant
   *     Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe).
   * @param sAspirantDesc
   *     Beschreibung Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe). May be <code>null</code>.
   * @param bMarked
   *     bestehende Markierung.
   * @param sMarkedDesc
   *     Beschreibung bestehende Markierung. May be <code>null</code>.
   * @param aDeadwoodCats
   *     Totholzkategorien (bei toten Bäumen). May not be <code>null</code>.
   * @param aDeadwoodDoD
   *     Totholzmengen aufgeteilt in die Zersetzungsklassen. May not be <code>null</code>.
   * @return
   *     The created object and never <code>null</code>.
   */
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

  /**
   * Update an existing object with new values.
   * 
   * @param sExBiotopbaumBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param nBBNr
   *     Schlüsselfeld.
   * @param aPics
   *     Foto. May neither be <code>null</code> nor empty.
   * @param aDate
   *     Aufnahmedatum. May not be <code>null</code>.
   * @param aType
   *     Biotopbaum-Typ (Hauptauswahlkriterium). May neither be <code>null</code> nor empty.
   * @param sLocation
   *     allg. Beschreibung des Standorts. May be <code>null</code>.
   * @param eExposition
   *     Exposition. May not be <code>null</code>.
   * @param sHanglage
   *     Angabe von Neigungen: keine, Angabe von Neigungen, Freitext. May be <code>null</code>.
   * @param bEinschichtig
   *     Wald, einschichtig (1 Baumschicht, kaum Unterwuchs) oder mehrschichtiger Bestand (Unterwuchs, Strauchsch., evtl. 2. Baumschicht).
   * @param bSolitary
   *     Solitärbaum.
   * @param bLightLocation
   *     lichter Bestand (Besonnung).
   * @param bClosedCrown
   *     geschlossene Kronendach.
   * @param bNoSun
   *     explitzit keine Besonnung.
   * @param bUeberSun
   *     Überhälter, mind. 25% oder weniger als 25% des Stammes besonnt.
   * @param bHomogene
   *     eingebettet in homogenene oder heterogene Umgebung.
   * @param sBeschreibung
   *     Bemerkungen/ (ausführliche) Beschreibung. May not be <code>null</code>.
   * @param eTreeKind
   *     Baumart laut Aufnahmeblatt. May not be <code>null</code>.
   * @param aCaves
   *     Höhlentyp und Anzahl mit Klasseneinteilung (Checkbox, mehrere möglich; dann noch Klassenangaben; C22-35 im Aufnahmemanual). May not be <code>null</code>.
   * @param aTrunk
   *     Daten zum Stamm/zu den Stämmen. May neither be <code>null</code> nor empty.
   * @param eVitality
   *     Vitalität. May not be <code>null</code>.
   * @param aSpecialStructure
   *     Baum-Sonderstrukturen (Mehrfachnennung möglich). May not be <code>null</code>.
   * @param sOtherSpecial
   *     Sonstige Sonderstrukturen inkl. Beschreibung. May be <code>null</code>.
   * @param bAspirant
   *     Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe).
   * @param sAspirantDesc
   *     Beschreibung Anwärter in nächster Umgebung (Potenzial für Habitatbaumgruppe). May be <code>null</code>.
   * @param bMarked
   *     bestehende Markierung.
   * @param sMarkedDesc
   *     Beschreibung bestehende Markierung. May be <code>null</code>.
   * @param aDeadwoodCats
   *     Totholzkategorien (bei toten Bäumen). May not be <code>null</code>.
   * @param aDeadwoodDoD
   *     Totholzmengen aufgeteilt in die Zersetzungsklassen. May not be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
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
    // Check preconditions
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
    // Success audit
    AuditHelper.onAuditModifySuccess(ExBiotopbaumBO.OT, "all", aExBiotopbaumBO.getID(), Integer.valueOf(nBBNr), aPics, aDate, aType, sLocation, eExposition, sHanglage, Boolean.valueOf(bEinschichtig), Boolean.valueOf(bSolitary), Boolean.valueOf(bLightLocation), Boolean.valueOf(bClosedCrown), Boolean.valueOf(bNoSun), Boolean.valueOf(bUeberSun), Boolean.valueOf(bHomogene), sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, aSpecialStructure, sOtherSpecial, Boolean.valueOf(bAspirant), sAspirantDesc, Boolean.valueOf(bMarked), sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
    return EChange.CHANGED;
  }

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExBiotopbaumBOUndeleted(String)} method.
   * 
   * @param sExBiotopbaumBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBiotopbaumBODeleted(@Nullable final String sExBiotopbaumBOID) {
    // Check preconditions
    final ExBiotopbaumBO aExBiotopbaumBO = getOfID(sExBiotopbaumBOID);
    if (aExBiotopbaumBO == null) {
      AuditHelper.onAuditDeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExBiotopbaumBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExBiotopbaumBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExBiotopbaumBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExBiotopbaumBODeleted(String)} method.
   * 
   * @param sExBiotopbaumBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExBiotopbaumBOUndeleted(@Nullable final String sExBiotopbaumBOID) {
    // Check preconditions
    final ExBiotopbaumBO aExBiotopbaumBO = getOfID(sExBiotopbaumBOID);
    if (aExBiotopbaumBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExBiotopbaumBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExBiotopbaumBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExBiotopbaumBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExBiotopbaumBO.OT, sExBiotopbaumBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExBiotopbaumBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExBiotopbaumBO(@Nullable final String sExBiotopbaumBOID) {
    final ExBiotopbaumBO aDeletedExBiotopbaumBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExBiotopbaumBO = internalDeleteItem(sExBiotopbaumBOID);
      if (aDeletedExBiotopbaumBO == null) {
        AuditHelper.onAuditDeleteFailure(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExBiotopbaumBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExBiotopbaumBO.OT, sExBiotopbaumBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExBiotopbaumBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExBiotopbaumBO getExBiotopbaumBOOfID(@Nullable final String sExBiotopbaumBOID) {
    return getOfID(sExBiotopbaumBOID);
  }
}
