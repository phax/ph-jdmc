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
package com.helger.aufnahme.small;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.small.IBiotopbaumDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class BiotopbaumDeadwood
  implements IBiotopbaumDeadwood
{
  public static final ObjectType OT = new ObjectType("BiotopbaumDeadwood");
  private EDeadwoodCategory m_eType;
  private boolean m_bEnabled;
  private int m_nLength;
  private int m_nBHD;

  public BiotopbaumDeadwood() {
  }

  public BiotopbaumDeadwood(@Nonnull final EDeadwoodCategory eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    setType(eType);
    setEnabled(bEnabled);
    setLength(nLength);
    setBHD(nBHD);
  }

  public BiotopbaumDeadwood(@Nonnull final IBiotopbaumDeadwood aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setType(aOther.getType());
    setEnabled(aOther.isEnabled());
    setLength(aOther.getLength());
    setBHD(aOther.getBHD());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final BiotopbaumDeadwood rhs = ((BiotopbaumDeadwood) o);
    if (!EqualsHelper.equals(m_eType, rhs.m_eType)) {
      return false;
    }
    if (!EqualsHelper.equals(m_bEnabled, rhs.m_bEnabled)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nLength, rhs.m_nLength)) {
      return false;
    }
    if (!EqualsHelper.equals(m_nBHD, rhs.m_nBHD)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_eType).append(m_bEnabled).append(m_nLength).append(m_nBHD).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("type", m_eType).append("enabled", m_bEnabled).append("length", m_nLength).append("BHD", m_nBHD).getToString();
  }

  @Nonnull
  public final EDeadwoodCategory getType() {
    return m_eType;
  }

  @Nonnull
  final EChange setType(@Nonnull final EDeadwoodCategory eType) {
    ValueEnforcer.notNull(eType, "Type");
    if (eType.equals(m_eType)) {
      return EChange.UNCHANGED;
    }
    m_eType = eType;
    return EChange.CHANGED;
  }

  public final boolean isEnabled() {
    return m_bEnabled;
  }

  @Nonnull
  final EChange setEnabled(final boolean bEnabled) {
    if (bEnabled == m_bEnabled) {
      return EChange.UNCHANGED;
    }
    m_bEnabled = bEnabled;
    return EChange.CHANGED;
  }

  public final int getLength() {
    return m_nLength;
  }

  @Nonnull
  final EChange setLength(final int nLength) {
    if (nLength == m_nLength) {
      return EChange.UNCHANGED;
    }
    m_nLength = nLength;
    return EChange.CHANGED;
  }

  public final int getBHD() {
    return m_nBHD;
  }

  @Nonnull
  final EChange setBHD(final int nBHD) {
    if (nBHD == m_nBHD) {
      return EChange.UNCHANGED;
    }
    m_nBHD = nBHD;
    return EChange.CHANGED;
  }
}
