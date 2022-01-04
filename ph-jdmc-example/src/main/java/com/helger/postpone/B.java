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
package com.helger.postpone;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;


/**
 * <p>Default implementation of {@link com.helger.postpone.IB}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class B
  extends AbstractBusinessObject
  implements IB
{
  public static final ObjectType OT = new ObjectType("B");
  private IC m_aC;

  public B(@Nonnull final IC aC) {
    this(StubObject.createForCurrentUser(), aC);
  }

  protected B(@Nonnull final StubObject aStubObject, @Nonnull final IC aC) {
    super(aStubObject);
    setC(aC);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("c", m_aC).getToString();
  }

  @Nonnull
  public final IC getC() {
    return m_aC;
  }

  @Nonnull
  final EChange setC(@Nonnull final IC aC) {
    ValueEnforcer.notNull(aC, "C");
    if (aC.equals(m_aC)) {
      return EChange.UNCHANGED;
    }
    m_aC = aC;
    return EChange.CHANGED;
  }
}
