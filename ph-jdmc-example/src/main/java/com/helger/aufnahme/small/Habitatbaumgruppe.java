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
package com.helger.aufnahme.small;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * <p>
 * Default implementation of
 * {@link com.helger.aufnahme.small.IHabitatbaumgruppe}
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Habitatbaumgruppe implements IHabitatbaumgruppe
{
  public static final ObjectType OT = new ObjectType ("Habitatbaumgruppe");
  private int m_nHBGNr;
  private final ICommonsList <File> m_aPics = new CommonsArrayList <> ();
  private final ICommonsList <IBiotopbaum> m_aHBGzBB = new CommonsArrayList <> ();
  private LocalDate m_aDate;
  private String m_sStandort;
  private boolean m_bOneLevel;
  private boolean m_bLight;
  private boolean m_bClosedCrown;
  private boolean m_bNoSun;
  private boolean m_bHomogen;
  private EExposition m_eExposition;
  private String m_sHanglage;
  private int m_nAreaSize;
  private boolean m_bOnlyBB;
  private String m_sBeschreibung;

  public Habitatbaumgruppe ()
  {}

  public Habitatbaumgruppe (final int nHBGNr,
                            @Nonnull @Nonempty final ICommonsList <File> aPics,
                            @Nonnull final ICommonsList <IBiotopbaum> aHBGzBB,
                            @Nonnull final LocalDate aDate,
                            @Nonnull final String sStandort,
                            final boolean bOneLevel,
                            final boolean bLight,
                            final boolean bClosedCrown,
                            final boolean bNoSun,
                            final boolean bHomogen,
                            @Nonnull final EExposition eExposition,
                            @Nullable final String sHanglage,
                            final int nAreaSize,
                            final boolean bOnlyBB,
                            @Nonnull final String sBeschreibung)
  {
    setHBGNr (nHBGNr);
    setPics (aPics);
    setHBGzBB (aHBGzBB);
    setDate (aDate);
    setStandort (sStandort);
    setOneLevel (bOneLevel);
    setLight (bLight);
    setClosedCrown (bClosedCrown);
    setNoSun (bNoSun);
    setHomogen (bHomogen);
    setExposition (eExposition);
    setHanglage (sHanglage);
    setAreaSize (nAreaSize);
    setOnlyBB (bOnlyBB);
    setBeschreibung (sBeschreibung);
  }

  public Habitatbaumgruppe (@Nonnull final IHabitatbaumgruppe aOther)
  {
    ValueEnforcer.notNull (aOther, "Other");
    setHBGNr (aOther.getHBGNr ());
    setPics (aOther.pics ());
    setHBGzBB (aOther.HBGzBB ());
    setDate (aOther.getDate ());
    setStandort (aOther.getStandort ());
    setOneLevel (aOther.isOneLevel ());
    setLight (aOther.isLight ());
    setClosedCrown (aOther.isClosedCrown ());
    setNoSun (aOther.isNoSun ());
    setHomogen (aOther.isHomogen ());
    setExposition (aOther.getExposition ());
    setHanglage (aOther.getHanglage ());
    setAreaSize (aOther.getAreaSize ());
    setOnlyBB (aOther.isOnlyBB ());
    setBeschreibung (aOther.getBeschreibung ());
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
    {
      return true;
    }
    if ((o == null) || (this.getClass () != o.getClass ()))
    {
      return false;
    }
    final Habitatbaumgruppe rhs = ((Habitatbaumgruppe) o);
    if (!EqualsHelper.equals (m_nHBGNr, rhs.m_nHBGNr))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_aPics, rhs.m_aPics))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_aHBGzBB, rhs.m_aHBGzBB))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_aDate, rhs.m_aDate))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_sStandort, rhs.m_sStandort))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_bOneLevel, rhs.m_bOneLevel))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_bLight, rhs.m_bLight))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_bClosedCrown, rhs.m_bClosedCrown))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_bNoSun, rhs.m_bNoSun))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_bHomogen, rhs.m_bHomogen))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_eExposition, rhs.m_eExposition))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_sHanglage, rhs.m_sHanglage))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_nAreaSize, rhs.m_nAreaSize))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_bOnlyBB, rhs.m_bOnlyBB))
    {
      return false;
    }
    if (!EqualsHelper.equals (m_sBeschreibung, rhs.m_sBeschreibung))
    {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_nHBGNr)
                                       .append (m_aPics)
                                       .append (m_aHBGzBB)
                                       .append (m_aDate)
                                       .append (m_sStandort)
                                       .append (m_bOneLevel)
                                       .append (m_bLight)
                                       .append (m_bClosedCrown)
                                       .append (m_bNoSun)
                                       .append (m_bHomogen)
                                       .append (m_eExposition)
                                       .append (m_sHanglage)
                                       .append (m_nAreaSize)
                                       .append (m_bOnlyBB)
                                       .append (m_sBeschreibung)
                                       .getHashCode ();
  }

  @Override
  public String toString ()
  {
    return new ToStringGenerator (this).append ("HBGNr", m_nHBGNr)
                                       .append ("pics", m_aPics)
                                       .append ("HBGzBB", m_aHBGzBB)
                                       .append ("date", m_aDate)
                                       .append ("Standort", m_sStandort)
                                       .append ("oneLevel", m_bOneLevel)
                                       .append ("light", m_bLight)
                                       .append ("closedCrown", m_bClosedCrown)
                                       .append ("noSun", m_bNoSun)
                                       .append ("homogen", m_bHomogen)
                                       .append ("exposition", m_eExposition)
                                       .append ("Hanglage", m_sHanglage)
                                       .append ("areaSize", m_nAreaSize)
                                       .append ("onlyBB", m_bOnlyBB)
                                       .append ("Beschreibung", m_sBeschreibung)
                                       .getToString ();
  }

  public final int getHBGNr ()
  {
    return m_nHBGNr;
  }

  @Nonnull
  final EChange setHBGNr (final int nHBGNr)
  {
    if (nHBGNr == m_nHBGNr)
    {
      return EChange.UNCHANGED;
    }
    m_nHBGNr = nHBGNr;
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
  @ReturnsMutableObject
  public final ICommonsList <IBiotopbaum> HBGzBB ()
  {
    return m_aHBGzBB;
  }

  @Nonnull
  final EChange setHBGzBB (@Nonnull final ICommonsList <IBiotopbaum> aHBGzBB)
  {
    ValueEnforcer.notNull (aHBGzBB, "HBGzBB");
    // Ensure the same implementation type
    final ICommonsList <IBiotopbaum> aRealList = new CommonsArrayList <> (aHBGzBB);
    if (aRealList.equals (m_aHBGzBB))
    {
      return EChange.UNCHANGED;
    }
    m_aHBGzBB.setAll (aRealList);
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

  @Nonnull
  public final String getStandort ()
  {
    return m_sStandort;
  }

  @Nonnull
  final EChange setStandort (@Nonnull final String sStandort)
  {
    ValueEnforcer.notNull (sStandort, "Standort");
    if (sStandort.equals (m_sStandort))
    {
      return EChange.UNCHANGED;
    }
    m_sStandort = sStandort;
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

  public final boolean isLight ()
  {
    return m_bLight;
  }

  @Nonnull
  final EChange setLight (final boolean bLight)
  {
    if (bLight == m_bLight)
    {
      return EChange.UNCHANGED;
    }
    m_bLight = bLight;
    return EChange.CHANGED;
  }

  public final boolean isClosedCrown ()
  {
    return m_bClosedCrown;
  }

  @Nonnull
  final EChange setClosedCrown (final boolean bClosedCrown)
  {
    if (bClosedCrown == m_bClosedCrown)
    {
      return EChange.UNCHANGED;
    }
    m_bClosedCrown = bClosedCrown;
    return EChange.CHANGED;
  }

  public final boolean isNoSun ()
  {
    return m_bNoSun;
  }

  @Nonnull
  final EChange setNoSun (final boolean bNoSun)
  {
    if (bNoSun == m_bNoSun)
    {
      return EChange.UNCHANGED;
    }
    m_bNoSun = bNoSun;
    return EChange.CHANGED;
  }

  public final boolean isHomogen ()
  {
    return m_bHomogen;
  }

  @Nonnull
  final EChange setHomogen (final boolean bHomogen)
  {
    if (bHomogen == m_bHomogen)
    {
      return EChange.UNCHANGED;
    }
    m_bHomogen = bHomogen;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExposition getExposition ()
  {
    return m_eExposition;
  }

  @Nonnull
  final EChange setExposition (@Nonnull final EExposition eExposition)
  {
    ValueEnforcer.notNull (eExposition, "Exposition");
    if (eExposition.equals (m_eExposition))
    {
      return EChange.UNCHANGED;
    }
    m_eExposition = eExposition;
    return EChange.CHANGED;
  }

  @Nullable
  public final String getHanglage ()
  {
    return m_sHanglage;
  }

  @Nonnull
  final EChange setHanglage (@Nullable final String sHanglage)
  {
    if (EqualsHelper.equals (sHanglage, m_sHanglage))
    {
      return EChange.UNCHANGED;
    }
    m_sHanglage = sHanglage;
    return EChange.CHANGED;
  }

  public final int getAreaSize ()
  {
    return m_nAreaSize;
  }

  @Nonnull
  final EChange setAreaSize (final int nAreaSize)
  {
    if (nAreaSize == m_nAreaSize)
    {
      return EChange.UNCHANGED;
    }
    m_nAreaSize = nAreaSize;
    return EChange.CHANGED;
  }

  public final boolean isOnlyBB ()
  {
    return m_bOnlyBB;
  }

  @Nonnull
  final EChange setOnlyBB (final boolean bOnlyBB)
  {
    if (bOnlyBB == m_bOnlyBB)
    {
      return EChange.UNCHANGED;
    }
    m_bOnlyBB = bOnlyBB;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getBeschreibung ()
  {
    return m_sBeschreibung;
  }

  @Nonnull
  final EChange setBeschreibung (@Nonnull final String sBeschreibung)
  {
    ValueEnforcer.notNull (sBeschreibung, "Beschreibung");
    if (sBeschreibung.equals (m_sBeschreibung))
    {
      return EChange.UNCHANGED;
    }
    m_sBeschreibung = sBeschreibung;
    return EChange.CHANGED;
  }
}
