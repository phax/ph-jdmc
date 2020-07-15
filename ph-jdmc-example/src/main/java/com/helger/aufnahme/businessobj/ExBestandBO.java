/**
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
import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * <p>
 * Default implementation of
 * {@link com.helger.aufnahme.businessobj.IExBestandBO}
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class ExBestandBO extends AbstractBusinessObject implements IExBestandBO
{
  public static final ObjectType OT = new ObjectType ("ExBestandBO");
  private int m_nBNr;
  private final ICommonsList <File> m_aPics = new CommonsArrayList <> ();
  private LocalDate m_aDate;
  private String m_sVerortung;
  private final ICommonsList <IExHabitatbaumgruppeBO> m_aBZHBG = new CommonsArrayList <> ();
  private Integer m_aAreaSize;
  private Long m_aAreaSizeLong;
  private Float m_aAreaSizeFloat;
  private Double m_aAreaSizeDouble;
  private String m_sBeschreib;
  private boolean m_bSameAge;
  private boolean m_bOneLevel;
  private EExStockTypeBO m_eStockType;
  private EExStockTypeBO m_eStockTypeOpt;
  private String m_sUsageDescription;
  private String m_sGesellschaft;
  private boolean m_bKronenschluss;
  private boolean m_bLightWoods;
  private boolean m_bUnterwuchs;
  private EExStockDeadwoodBO m_eTotSteh;
  private String m_sTotStehBesch;
  private EExStockDeadwoodBO m_eTotLieg;
  private String m_sTotLiegBesch;

  public ExBestandBO (final int nBNr,
                      @Nonnull @Nonempty final ICommonsList <File> aPics,
                      @Nonnull final LocalDate aDate,
                      @Nullable final String sVerortung,
                      @Nonnull final ICommonsList <IExHabitatbaumgruppeBO> aBZHBG,
                      @Nullable final Integer aAreaSize,
                      @Nullable final Long aAreaSizeLong,
                      @Nullable final Float aAreaSizeFloat,
                      @Nullable final Double aAreaSizeDouble,
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
                      @Nonnull final String sTotLiegBesch)
  {
    this (StubObject.createForCurrentUser (),
          nBNr,
          aPics,
          aDate,
          sVerortung,
          aBZHBG,
          aAreaSize,
          aAreaSizeLong,
          aAreaSizeFloat,
          aAreaSizeDouble,
          sBeschreib,
          bSameAge,
          bOneLevel,
          eStockType,
          eStockTypeOpt,
          sUsageDescription,
          sGesellschaft,
          bKronenschluss,
          bLightWoods,
          bUnterwuchs,
          eTotSteh,
          sTotStehBesch,
          eTotLieg,
          sTotLiegBesch);
  }

  protected ExBestandBO (@Nonnull final StubObject aStubObject,
                         final int nBNr,
                         @Nonnull @Nonempty final ICommonsList <File> aPics,
                         @Nonnull final LocalDate aDate,
                         @Nullable final String sVerortung,
                         @Nonnull final ICommonsList <IExHabitatbaumgruppeBO> aBZHBG,
                         @Nullable final Integer aAreaSize,
                         @Nullable final Long aAreaSizeLong,
                         @Nullable final Float aAreaSizeFloat,
                         @Nullable final Double aAreaSizeDouble,
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
                         @Nonnull final String sTotLiegBesch)
  {
    super (aStubObject);
    setBNr (nBNr);
    setPics (aPics);
    setDate (aDate);
    setVerortung (sVerortung);
    setBZHBG (aBZHBG);
    setAreaSize (aAreaSize);
    setAreaSizeLong (aAreaSizeLong);
    setAreaSizeFloat (aAreaSizeFloat);
    setAreaSizeDouble (aAreaSizeDouble);
    setBeschreib (sBeschreib);
    setSameAge (bSameAge);
    setOneLevel (bOneLevel);
    setStockType (eStockType);
    setStockTypeOpt (eStockTypeOpt);
    setUsageDescription (sUsageDescription);
    setGesellschaft (sGesellschaft);
    setKronenschluss (bKronenschluss);
    setLightWoods (bLightWoods);
    setUnterwuchs (bUnterwuchs);
    setTotSteh (eTotSteh);
    setTotStehBesch (sTotStehBesch);
    setTotLieg (eTotLieg);
    setTotLiegBesch (sTotLiegBesch);
  }

  @Nonnull
  public final ObjectType getObjectType ()
  {
    return OT;
  }

  @Override
  public String toString ()
  {
    return ToStringGenerator.getDerived (super.toString ())
                            .append ("BNr", m_nBNr)
                            .append ("pics", m_aPics)
                            .append ("date", m_aDate)
                            .append ("Verortung", m_sVerortung)
                            .append ("BZHBG", m_aBZHBG)
                            .append ("areaSize", m_aAreaSize)
                            .append ("areaSizeLong", m_aAreaSizeLong)
                            .append ("areaSizeFloat", m_aAreaSizeFloat)
                            .append ("areaSizeDouble", m_aAreaSizeDouble)
                            .append ("Beschreib", m_sBeschreib)
                            .append ("sameAge", m_bSameAge)
                            .append ("oneLevel", m_bOneLevel)
                            .append ("stockType", m_eStockType)
                            .append ("stockTypeOpt", m_eStockTypeOpt)
                            .append ("usageDescription", m_sUsageDescription)
                            .append ("Gesellschaft", m_sGesellschaft)
                            .append ("Kronenschluss", m_bKronenschluss)
                            .append ("lightWoods", m_bLightWoods)
                            .append ("Unterwuchs", m_bUnterwuchs)
                            .append ("TotSteh", m_eTotSteh)
                            .append ("TotStehBesch", m_sTotStehBesch)
                            .append ("TotLieg", m_eTotLieg)
                            .append ("TotLiegBesch", m_sTotLiegBesch)
                            .getToString ();
  }

  public final int getBNr ()
  {
    return m_nBNr;
  }

  @Nonnull
  final EChange setBNr (final int nBNr)
  {
    if (nBNr == m_nBNr)
    {
      return EChange.UNCHANGED;
    }
    m_nBNr = nBNr;
    return EChange.CHANGED;
  }

  @Nonnull
  @Nonempty
  @ReturnsMutableObject
  public final ICommonsList <File> pics ()
  {
    return m_aPics;
  }

  @Nonnull
  final EChange setPics (@Nonnull @Nonempty final ICommonsList <File> aPics)
  {
    ValueEnforcer.notEmpty (aPics, "Pics");
    // Ensure the same implementation type
    final ICommonsList <File> aRealList = new CommonsArrayList <> (aPics);
    if (aRealList.equals (m_aPics))
    {
      return EChange.UNCHANGED;
    }
    m_aPics.setAll (aRealList);
    return EChange.CHANGED;
  }

  @Nonnull
  public final LocalDate getDate ()
  {
    return m_aDate;
  }

  @Nonnull
  final EChange setDate (@Nonnull final LocalDate aDate)
  {
    ValueEnforcer.notNull (aDate, "Date");
    if (aDate.equals (m_aDate))
    {
      return EChange.UNCHANGED;
    }
    m_aDate = aDate;
    return EChange.CHANGED;
  }

  @Nullable
  public final String getVerortung ()
  {
    return m_sVerortung;
  }

  @Nonnull
  final EChange setVerortung (@Nullable final String sVerortung)
  {
    if (EqualsHelper.equals (sVerortung, m_sVerortung))
    {
      return EChange.UNCHANGED;
    }
    m_sVerortung = sVerortung;
    return EChange.CHANGED;
  }

  @Nonnull
  @ReturnsMutableObject
  public final ICommonsList <IExHabitatbaumgruppeBO> BZHBG ()
  {
    return m_aBZHBG;
  }

  @Nonnull
  final EChange setBZHBG (@Nonnull final ICommonsList <IExHabitatbaumgruppeBO> aBZHBG)
  {
    ValueEnforcer.notNull (aBZHBG, "BZHBG");
    // Ensure the same implementation type
    final ICommonsList <IExHabitatbaumgruppeBO> aRealList = new CommonsArrayList <> (aBZHBG);
    if (aRealList.equals (m_aBZHBG))
    {
      return EChange.UNCHANGED;
    }
    m_aBZHBG.setAll (aRealList);
    return EChange.CHANGED;
  }

  @Nullable
  public final Integer getAreaSize ()
  {
    return m_aAreaSize;
  }

  @Nonnull
  final EChange setAreaSize (@Nullable final Integer aAreaSize)
  {
    if (EqualsHelper.equals (aAreaSize, m_aAreaSize))
    {
      return EChange.UNCHANGED;
    }
    m_aAreaSize = aAreaSize;
    return EChange.CHANGED;
  }

  @Nullable
  public final Long getAreaSizeLong ()
  {
    return m_aAreaSizeLong;
  }

  @Nonnull
  final EChange setAreaSizeLong (@Nullable final Long aAreaSizeLong)
  {
    if (EqualsHelper.equals (aAreaSizeLong, m_aAreaSizeLong))
    {
      return EChange.UNCHANGED;
    }
    m_aAreaSizeLong = aAreaSizeLong;
    return EChange.CHANGED;
  }

  @Nullable
  public final Float getAreaSizeFloat ()
  {
    return m_aAreaSizeFloat;
  }

  @Nonnull
  final EChange setAreaSizeFloat (@Nullable final Float aAreaSizeFloat)
  {
    if (EqualsHelper.equals (aAreaSizeFloat, m_aAreaSizeFloat))
    {
      return EChange.UNCHANGED;
    }
    m_aAreaSizeFloat = aAreaSizeFloat;
    return EChange.CHANGED;
  }

  @Nullable
  public final Double getAreaSizeDouble ()
  {
    return m_aAreaSizeDouble;
  }

  @Nonnull
  final EChange setAreaSizeDouble (@Nullable final Double aAreaSizeDouble)
  {
    if (EqualsHelper.equals (aAreaSizeDouble, m_aAreaSizeDouble))
    {
      return EChange.UNCHANGED;
    }
    m_aAreaSizeDouble = aAreaSizeDouble;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getBeschreib ()
  {
    return m_sBeschreib;
  }

  @Nonnull
  final EChange setBeschreib (@Nonnull final String sBeschreib)
  {
    ValueEnforcer.notNull (sBeschreib, "Beschreib");
    if (sBeschreib.equals (m_sBeschreib))
    {
      return EChange.UNCHANGED;
    }
    m_sBeschreib = sBeschreib;
    return EChange.CHANGED;
  }

  public final boolean isSameAge ()
  {
    return m_bSameAge;
  }

  @Nonnull
  final EChange setSameAge (final boolean bSameAge)
  {
    if (bSameAge == m_bSameAge)
    {
      return EChange.UNCHANGED;
    }
    m_bSameAge = bSameAge;
    return EChange.CHANGED;
  }

  public final boolean isOneLevel ()
  {
    return m_bOneLevel;
  }

  @Nonnull
  final EChange setOneLevel (final boolean bOneLevel)
  {
    if (bOneLevel == m_bOneLevel)
    {
      return EChange.UNCHANGED;
    }
    m_bOneLevel = bOneLevel;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExStockTypeBO getStockType ()
  {
    return m_eStockType;
  }

  @Nonnull
  final EChange setStockType (@Nonnull final EExStockTypeBO eStockType)
  {
    ValueEnforcer.notNull (eStockType, "StockType");
    if (eStockType.equals (m_eStockType))
    {
      return EChange.UNCHANGED;
    }
    m_eStockType = eStockType;
    return EChange.CHANGED;
  }

  @Nullable
  public final EExStockTypeBO getStockTypeOpt ()
  {
    return m_eStockTypeOpt;
  }

  @Nonnull
  final EChange setStockTypeOpt (@Nullable final EExStockTypeBO eStockTypeOpt)
  {
    if (EqualsHelper.equals (eStockTypeOpt, m_eStockTypeOpt))
    {
      return EChange.UNCHANGED;
    }
    m_eStockTypeOpt = eStockTypeOpt;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getUsageDescription ()
  {
    return m_sUsageDescription;
  }

  @Nonnull
  final EChange setUsageDescription (@Nonnull final String sUsageDescription)
  {
    ValueEnforcer.notNull (sUsageDescription, "UsageDescription");
    if (sUsageDescription.equals (m_sUsageDescription))
    {
      return EChange.UNCHANGED;
    }
    m_sUsageDescription = sUsageDescription;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getGesellschaft ()
  {
    return m_sGesellschaft;
  }

  @Nonnull
  final EChange setGesellschaft (@Nonnull final String sGesellschaft)
  {
    ValueEnforcer.notNull (sGesellschaft, "Gesellschaft");
    if (sGesellschaft.equals (m_sGesellschaft))
    {
      return EChange.UNCHANGED;
    }
    m_sGesellschaft = sGesellschaft;
    return EChange.CHANGED;
  }

  public final boolean isKronenschluss ()
  {
    return m_bKronenschluss;
  }

  @Nonnull
  final EChange setKronenschluss (final boolean bKronenschluss)
  {
    if (bKronenschluss == m_bKronenschluss)
    {
      return EChange.UNCHANGED;
    }
    m_bKronenschluss = bKronenschluss;
    return EChange.CHANGED;
  }

  public final boolean isLightWoods ()
  {
    return m_bLightWoods;
  }

  @Nonnull
  final EChange setLightWoods (final boolean bLightWoods)
  {
    if (bLightWoods == m_bLightWoods)
    {
      return EChange.UNCHANGED;
    }
    m_bLightWoods = bLightWoods;
    return EChange.CHANGED;
  }

  public final boolean isUnterwuchs ()
  {
    return m_bUnterwuchs;
  }

  @Nonnull
  final EChange setUnterwuchs (final boolean bUnterwuchs)
  {
    if (bUnterwuchs == m_bUnterwuchs)
    {
      return EChange.UNCHANGED;
    }
    m_bUnterwuchs = bUnterwuchs;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExStockDeadwoodBO getTotSteh ()
  {
    return m_eTotSteh;
  }

  @Nonnull
  final EChange setTotSteh (@Nonnull final EExStockDeadwoodBO eTotSteh)
  {
    ValueEnforcer.notNull (eTotSteh, "TotSteh");
    if (eTotSteh.equals (m_eTotSteh))
    {
      return EChange.UNCHANGED;
    }
    m_eTotSteh = eTotSteh;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getTotStehBesch ()
  {
    return m_sTotStehBesch;
  }

  @Nonnull
  final EChange setTotStehBesch (@Nonnull final String sTotStehBesch)
  {
    ValueEnforcer.notNull (sTotStehBesch, "TotStehBesch");
    if (sTotStehBesch.equals (m_sTotStehBesch))
    {
      return EChange.UNCHANGED;
    }
    m_sTotStehBesch = sTotStehBesch;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExStockDeadwoodBO getTotLieg ()
  {
    return m_eTotLieg;
  }

  @Nonnull
  final EChange setTotLieg (@Nonnull final EExStockDeadwoodBO eTotLieg)
  {
    ValueEnforcer.notNull (eTotLieg, "TotLieg");
    if (eTotLieg.equals (m_eTotLieg))
    {
      return EChange.UNCHANGED;
    }
    m_eTotLieg = eTotLieg;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getTotLiegBesch ()
  {
    return m_sTotLiegBesch;
  }

  @Nonnull
  final EChange setTotLiegBesch (@Nonnull final String sTotLiegBesch)
  {
    ValueEnforcer.notNull (sTotLiegBesch, "TotLiegBesch");
    if (sTotLiegBesch.equals (m_sTotLiegBesch))
    {
      return EChange.UNCHANGED;
    }
    m_sTotLiegBesch = sTotLiegBesch;
    return EChange.CHANGED;
  }
}
