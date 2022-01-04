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
 * <p>Default implementation of {@link com.helger.postpone.IC}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class C
  extends AbstractBusinessObject
  implements IC
{
  public static final ObjectType OT = new ObjectType("C");
  private EE m_eE;

  public C(@Nonnull final EE eE) {
    this(StubObject.createForCurrentUser(), eE);
  }

  protected C(@Nonnull final StubObject aStubObject, @Nonnull final EE eE) {
    super(aStubObject);
    setE(eE);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("e", m_eE).getToString();
  }

  @Nonnull
  public final EE getE() {
    return m_eE;
  }

  @Nonnull
  final EChange setE(@Nonnull final EE eE) {
    ValueEnforcer.notNull(eE, "E");
    if (eE.equals(m_eE)) {
      return EChange.UNCHANGED;
    }
    m_eE = eE;
    return EChange.CHANGED;
  }
}
