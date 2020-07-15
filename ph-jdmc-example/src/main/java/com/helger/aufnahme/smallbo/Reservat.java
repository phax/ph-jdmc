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
package com.helger.aufnahme.smallbo;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

/**
 * <p>
 * Default implementation of {@link com.helger.aufnahme.smallbo.IReservat}
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Reservat extends AbstractBusinessObject implements IReservat
{
  public static final ObjectType OT = new ObjectType ("Reservat");
  private int m_nRNr;
  private String m_sName;
  private int m_nAreaSize;

  public Reservat (final int nRNr, @Nonnull final String sName, final int nAreaSize)
  {
    this (StubObject.createForCurrentUser (), nRNr, sName, nAreaSize);
  }

  protected Reservat (@Nonnull final StubObject aStubObject, final int nRNr, @Nonnull final String sName, final int nAreaSize)
  {
    super (aStubObject);
    setRNr (nRNr);
    setName (sName);
    setAreaSize (nAreaSize);
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
                            .append ("RNr", m_nRNr)
                            .append ("name", m_sName)
                            .append ("areaSize", m_nAreaSize)
                            .getToString ();
  }

  public final int getRNr ()
  {
    return m_nRNr;
  }

  @Nonnull
  final EChange setRNr (final int nRNr)
  {
    if (nRNr == m_nRNr)
    {
      return EChange.UNCHANGED;
    }
    m_nRNr = nRNr;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getName ()
  {
    return m_sName;
  }

  @Nonnull
  final EChange setName (@Nonnull final String sName)
  {
    ValueEnforcer.notNull (sName, "Name");
    if (sName.equals (m_sName))
    {
      return EChange.UNCHANGED;
    }
    m_sName = sName;
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
}
