/*
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.state.EChange;
import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.app.dao.AbstractPhotonMapBasedWALDAO;
import com.helger.photon.audit.AuditHelper;
import com.helger.photon.security.object.BusinessObjectHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExStichprobeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@ThreadSafe
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

  /**
   * Create a new object and add it to the internal map.
   * 
   * @param nStichNr
   *     Schlüsselfeld.
   * @param aStichNrzR
   *     Zugehörig zu Reservat. May not be <code>null</code>.
   * @param aPics
   *     Fotos. May neither be <code>null</code> nor empty.
   * @param aDate
   *     LocalDate value. May not be <code>null</code>.
   * @param nSize
   *     Größe in m² bei Abweichung von Radius.
   * @param eExposition
   *     Exposition. May not be <code>null</code>.
   * @param sHanglage
   *     Angabe von Neigungen. May be <code>null</code>.
   * @param sGesellschaft
   *     Waldgesellschaft oder Waldgruppe. May not be <code>null</code>.
   * @param dBKL0
   *     Bestandesklasse 0, Flächenanteil in Zehntel.
   * @param dBKL1
   *     Bestandesklasse 1, Flächenanteil in Zehntel.
   * @param dBKL2
   *     Bestandesklasse 2, Flächenanteil in Zehntel.
   * @param dBKL3
   *     Bestandesklasse 3, Flächenanteil in Zehntel.
   * @param dBKL4
   *     Bestandesklasse 4, Flächenanteil in Zehntel.
   * @param dBKL5
   *     Bestandesklasse 5, Flächenanteil in Zehntel.
   * @param dBKL6
   *     Bestandesklasse 6, Flächenanteil in Zehntel.
   * @param dBKL7
   *     Bestandesklasse 7, Flächenanteil in Zehntel.
   * @param dBKL8
   *     Bestandesklasse 8, Flächenanteil in Zehntel.
   * @param dBKL9
   *     Bestandesklasse 9, Flächenanteil in Zehntel.
   * @param sUsage
   *     Beschreibung Nutzungsspuren. May not be <code>null</code>.
   * @param sUsageDesc
   *     allgemeine Beschreibung. May not be <code>null</code>.
   * @param aTrees
   *     Biotopbäume innerhalb Stichprobenpunkt. May not be <code>null</code>.
   * @param sDesc
   *     Beschreibung. May not be <code>null</code>.
   * @param bSameAge
   *     gleichaltrig oder ungleichaltrig.
   * @param bOneLevel
   *     einschichtig oder mehrschichtig.
   * @param aTotSteh
   *     Stehendes Totholz (Vollaufnahme) ab &gt;= 5cm BHD. May not be <code>null</code>.
   * @param aTotLieg1
   *     Liegendes Totholz (Line-intersect, Transekt 1) ab Mindestdurchmesser &gt;= 10 cm. May not be <code>null</code>.
   * @param aTotLieg2
   *     Liegendes Totholz (Line-intersect, Transekt 2) ab Mindestdurchmesser &gt;= 10 cm. May not be <code>null</code>.
   * @return
   *     The created object and never <code>null</code>.
   */
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

  /**
   * Update an existing object with new values.
   * 
   * @param sExStichprobeBOID
   *     ID of the object to be updated. May be <code>null</code>.
   * @param nStichNr
   *     Schlüsselfeld.
   * @param aStichNrzR
   *     Zugehörig zu Reservat. May not be <code>null</code>.
   * @param aPics
   *     Fotos. May neither be <code>null</code> nor empty.
   * @param aDate
   *     LocalDate value. May not be <code>null</code>.
   * @param nSize
   *     Größe in m² bei Abweichung von Radius.
   * @param eExposition
   *     Exposition. May not be <code>null</code>.
   * @param sHanglage
   *     Angabe von Neigungen. May be <code>null</code>.
   * @param sGesellschaft
   *     Waldgesellschaft oder Waldgruppe. May not be <code>null</code>.
   * @param dBKL0
   *     Bestandesklasse 0, Flächenanteil in Zehntel.
   * @param dBKL1
   *     Bestandesklasse 1, Flächenanteil in Zehntel.
   * @param dBKL2
   *     Bestandesklasse 2, Flächenanteil in Zehntel.
   * @param dBKL3
   *     Bestandesklasse 3, Flächenanteil in Zehntel.
   * @param dBKL4
   *     Bestandesklasse 4, Flächenanteil in Zehntel.
   * @param dBKL5
   *     Bestandesklasse 5, Flächenanteil in Zehntel.
   * @param dBKL6
   *     Bestandesklasse 6, Flächenanteil in Zehntel.
   * @param dBKL7
   *     Bestandesklasse 7, Flächenanteil in Zehntel.
   * @param dBKL8
   *     Bestandesklasse 8, Flächenanteil in Zehntel.
   * @param dBKL9
   *     Bestandesklasse 9, Flächenanteil in Zehntel.
   * @param sUsage
   *     Beschreibung Nutzungsspuren. May not be <code>null</code>.
   * @param sUsageDesc
   *     allgemeine Beschreibung. May not be <code>null</code>.
   * @param aTrees
   *     Biotopbäume innerhalb Stichprobenpunkt. May not be <code>null</code>.
   * @param sDesc
   *     Beschreibung. May not be <code>null</code>.
   * @param bSameAge
   *     gleichaltrig oder ungleichaltrig.
   * @param bOneLevel
   *     einschichtig oder mehrschichtig.
   * @param aTotSteh
   *     Stehendes Totholz (Vollaufnahme) ab &gt;= 5cm BHD. May not be <code>null</code>.
   * @param aTotLieg1
   *     Liegendes Totholz (Line-intersect, Transekt 1) ab Mindestdurchmesser &gt;= 10 cm. May not be <code>null</code>.
   * @param aTotLieg2
   *     Liegendes Totholz (Line-intersect, Transekt 2) ab Mindestdurchmesser &gt;= 10 cm. May not be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if something was changed, {@link EChange#UNCHANGED} otherwise. Never <code>null</code>.
   */
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
    // Check preconditions
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

  /**
   * Mark an existing object as deleted. This means the object is still present and can be restored using the {@link #markExStichprobeBOUndeleted(String)} method.
   * 
   * @param sExStichprobeBOID
   *     ID of the object to be marked as deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was marked as deleted {@link EChange#UNCHANGED} if the object does not exist or was already deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExStichprobeBODeleted(@Nullable final String sExStichprobeBOID) {
    // Check preconditions
    final ExStichprobeBO aExStichprobeBO = getOfID(sExStichprobeBOID);
    if (aExStichprobeBO == null) {
      AuditHelper.onAuditDeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (aExStichprobeBO.isDeleted()) {
      AuditHelper.onAuditDeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "already-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as deleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setDeletionNow(aExStichprobeBO).isUnchanged()) {
        AuditHelper.onAuditDeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "already-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemDeleted(aExStichprobeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExStichprobeBO.OT, sExStichprobeBOID, "mark-deleted");
    return EChange.CHANGED;
  }

  /**
   * Restore an existing object that was marked deleted using the {@link #markExStichprobeBODeleted(String)} method.
   * 
   * @param sExStichprobeBOID
   *     ID of the object to be marked as undeleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was undeleted {@link EChange#UNCHANGED} if the object does not exist or was not deleted. Never <code>null</code>.
   */
  @Nonnull
  public final EChange markExStichprobeBOUndeleted(@Nullable final String sExStichprobeBOID) {
    // Check preconditions
    final ExStichprobeBO aExStichprobeBO = getOfID(sExStichprobeBOID);
    if (aExStichprobeBO == null) {
      AuditHelper.onAuditUndeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "no-such-id");
      return EChange.UNCHANGED;
    }
    if (!aExStichprobeBO.isDeleted()) {
      AuditHelper.onAuditUndeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "not-deleted");
      return EChange.UNCHANGED;
    }
    // Mark internally as undeleted
    m_aRWLock.writeLock().lock();
    try {
      if (BusinessObjectHelper.setUndeletionNow(aExStichprobeBO).isUnchanged()) {
        AuditHelper.onAuditUndeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "not-deleted");
        return EChange.UNCHANGED;
      }
      internalMarkItemUndeleted(aExStichprobeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditUndeleteSuccess(ExStichprobeBO.OT, sExStichprobeBOID);
    return EChange.CHANGED;
  }

  /**
   * Delete an existing object so that it can <b>NOT</b> be restored afterwards.
   * Note: if an object was previously marked as deleted it can finally be deleted with this method.
   * 
   * @param sExStichprobeBOID
   *     ID of the object to be deleted. May be <code>null</code>.
   * @return
   *     {@link EChange#CHANGED} if the object was deleted {@link EChange#UNCHANGED} if the object does not exist. Never <code>null</code>.
   */
  @Nonnull
  public final EChange deleteExStichprobeBO(@Nullable final String sExStichprobeBOID) {
    final ExStichprobeBO aDeletedExStichprobeBO;
    // Delete internally
    m_aRWLock.writeLock().lock();
    try {
      aDeletedExStichprobeBO = internalDeleteItem(sExStichprobeBOID);
      if (aDeletedExStichprobeBO == null) {
        AuditHelper.onAuditDeleteFailure(ExStichprobeBO.OT, sExStichprobeBOID, "no-such-id");
        return EChange.UNCHANGED;
      }
      BusinessObjectHelper.setDeletionNow(aDeletedExStichprobeBO);
    } finally {
      m_aRWLock.writeLock().unlock();
    }
    // Success audit
    AuditHelper.onAuditDeleteSuccess(ExStichprobeBO.OT, sExStichprobeBOID, "removed");
    return EChange.CHANGED;
  }

  /**
   * Get the object with the provided ID.
   * 
   * @param sExStichprobeBOID
   *     ID of the object to be retrieved. May be <code>null</code>.
   * @return
   *     The object with the ID or <code>null</code> if no such object is present.
   */
  @Nullable
  public final IExStichprobeBO getExStichprobeBOOfID(@Nullable final String sExStichprobeBOID) {
    return getOfID(sExStichprobeBOID);
  }
}
