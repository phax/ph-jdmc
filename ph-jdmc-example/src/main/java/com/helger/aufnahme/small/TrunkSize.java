/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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

import com.helger.commons.ValueEnforcer;
import com.helger.commons.equals.EqualsHelper;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.small.ITrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class TrunkSize
  implements ITrunkSize
{
  public static final ObjectType OT = new ObjectType("TrunkSize");
  private int m_nBHD;
  private ETreeHeight m_eHeight;

  public TrunkSize() {
  }

  public TrunkSize(final int nBHD, @Nonnull final ETreeHeight eHeight) {
    setBHD(nBHD);
    setHeight(eHeight);
  }

  public TrunkSize(@Nonnull final ITrunkSize aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setBHD(aOther.getBHD());
    setHeight(aOther.getHeight());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final TrunkSize rhs = ((TrunkSize) o);
    if (!EqualsHelper.equals(m_nBHD, rhs.m_nBHD)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eHeight, rhs.m_eHeight)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_nBHD).append(m_eHeight).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("BHD", m_nBHD).append("height", m_eHeight).getToString();
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

  @Nonnull
  public final ETreeHeight getHeight() {
    return m_eHeight;
  }

  @Nonnull
  final EChange setHeight(@Nonnull final ETreeHeight eHeight) {
    ValueEnforcer.notNull(eHeight, "Height");
    if (eHeight.equals(m_eHeight)) {
      return EChange.UNCHANGED;
    }
    m_eHeight = eHeight;
    return EChange.CHANGED;
  }
}
