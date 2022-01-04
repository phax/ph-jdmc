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
 * <p>Default implementation of {@link com.helger.aufnahme.smallbo.IBiotopbaumDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class BiotopbaumDeadwood
  extends AbstractBusinessObject
  implements IBiotopbaumDeadwood
{
  public static final ObjectType OT = new ObjectType("BiotopbaumDeadwood");
  private EDeadwoodCategory m_eType;
  private boolean m_bEnabled;
  private int m_nLength;
  private int m_nBHD;

  public BiotopbaumDeadwood(@Nonnull final EDeadwoodCategory eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    this(StubObject.createForCurrentUser(), eType, bEnabled, nLength, nBHD);
  }

  protected BiotopbaumDeadwood(@Nonnull final StubObject aStubObject,
    @Nonnull final EDeadwoodCategory eType,
    final boolean bEnabled,
    final int nLength,
    final int nBHD) {
    super(aStubObject);
    setType(eType);
    setEnabled(bEnabled);
    setLength(nLength);
    setBHD(nBHD);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("type", m_eType).append("enabled", m_bEnabled).append("length", m_nLength).append("BHD", m_nBHD).getToString();
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
