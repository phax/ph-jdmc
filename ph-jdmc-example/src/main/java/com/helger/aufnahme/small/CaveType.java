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
 * <p>Default implementation of {@link com.helger.aufnahme.small.ICaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class CaveType
  implements ICaveType
{
  public static final ObjectType OT = new ObjectType("CaveType");
  private ECaveClass m_eClazz;
  private ECaveType m_eType;

  public CaveType() {
  }

  public CaveType(@Nonnull final ECaveClass eClazz, @Nonnull final ECaveType eType) {
    setClazz(eClazz);
    setType(eType);
  }

  public CaveType(@Nonnull final ICaveType aOther) {
    ValueEnforcer.notNull(aOther, "Other");
    setClazz(aOther.getClazz());
    setType(aOther.getType());
  }

  @Override
  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    }
    if ((o == null)||(this.getClass()!= o.getClass())) {
      return false;
    }
    final CaveType rhs = ((CaveType) o);
    if (!EqualsHelper.equals(m_eClazz, rhs.m_eClazz)) {
      return false;
    }
    if (!EqualsHelper.equals(m_eType, rhs.m_eType)) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    return new HashCodeGenerator(this).append(m_eClazz).append(m_eType).getHashCode();
  }

  @Override
  public String toString() {
    return new ToStringGenerator(this).append("clazz", m_eClazz).append("type", m_eType).getToString();
  }

  @Nonnull
  public final ECaveClass getClazz() {
    return m_eClazz;
  }

  @Nonnull
  final EChange setClazz(@Nonnull final ECaveClass eClazz) {
    ValueEnforcer.notNull(eClazz, "Clazz");
    if (eClazz.equals(m_eClazz)) {
      return EChange.UNCHANGED;
    }
    m_eClazz = eClazz;
    return EChange.CHANGED;
  }

  @Nonnull
  public final ECaveType getType() {
    return m_eType;
  }

  @Nonnull
  final EChange setType(@Nonnull final ECaveType eType) {
    ValueEnforcer.notNull(eType, "Type");
    if (eType.equals(m_eType)) {
      return EChange.UNCHANGED;
    }
    m_eType = eType;
    return EChange.CHANGED;
  }
}
