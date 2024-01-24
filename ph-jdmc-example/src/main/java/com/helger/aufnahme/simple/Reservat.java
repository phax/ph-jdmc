/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
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
package com.helger.aufnahme.simple;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.IReservat}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class Reservat
  implements IReservat
{
  public static final ObjectType OT = new ObjectType("Reservat");
  private int m_nRNr;
  private String m_sName;
  private int m_nAreaSize;

  public Reservat() {
  }

  public Reservat(final int nRNr, @Nonnull final String sName, final int nAreaSize) {
    setRNr(nRNr);
    setName(sName);
    setAreaSize(nAreaSize);
  }

  public Reservat(@Nonnull final IReservat aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setRNr(aOther.getRNr());
    setName(aOther.getName());
    setAreaSize(aOther.getAreaSize());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final Reservat rhs = ((Reservat) o);
    if (!EqualsHelper.equals(m_nRNr, rhs.m_nRNr)) {
      return false;
    }
    if (!EqualsHelper.equals(m_sName, rhs.m_sName)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nAreaSize, rhs.m_nAreaSize)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_nRNr).append(m_sName).append(m_nAreaSize).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("RNr", m_nRNr).append("name", m_sName).append("areaSize", m_nAreaSize).getToString();
  }

  public final int getRNr() {
    return m_nRNr;
  }

  @Nonnull
  final EChange setRNr(final int nRNr) {
    if (nRNr == m_nRNr) {
      return EChange.UNCHANGED;
    }
    m_nRNr = nRNr;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getName() {
    return m_sName;
  }

  @Nonnull
  final EChange setName(@Nonnull final String sName) {
    ValueEnforcer.notNull(sName, "Name");
    if (sName.equals(m_sName)) {
      return EChange.UNCHANGED;
    }
    m_sName = sName;
    return EChange.CHANGED;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  @Nonnull
  final EChange setAreaSize(final int nAreaSize) {
    if (nAreaSize == m_nAreaSize) {
      return EChange.UNCHANGED;
    }
    m_nAreaSize = nAreaSize;
    return EChange.CHANGED;
  }
}
