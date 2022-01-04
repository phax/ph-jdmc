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
package com.helger.selfref;

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
 * <p>Default implementation of {@link com.helger.selfref.ISelfRefDemo1}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class SelfRefDemo1
  extends AbstractBusinessObject
  implements com.helger.selfref.ISelfRefDemo1
{
  public static final ObjectType OT = new ObjectType("SelfRefDemo1");
  private com.helger.selfref.ISelfRefDemo1 m_aDummy1;

  public SelfRefDemo1(@Nullable final com.helger.selfref.ISelfRefDemo1 aDummy1) {
    this(StubObject.createForCurrentUser(), aDummy1);
  }

  protected SelfRefDemo1(@Nonnull final StubObject aStubObject, @Nullable final com.helger.selfref.ISelfRefDemo1 aDummy1) {
    super(aStubObject);
    setDummy1(aDummy1);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("dummy1", m_aDummy1).getToString();
  }

  @Nullable
  public final com.helger.selfref.ISelfRefDemo1 getDummy1() {
    return m_aDummy1;
  }

  @Nonnull
  final EChange setDummy1(@Nullable final com.helger.selfref.ISelfRefDemo1 aDummy1) {
    if (EqualsHelper.equals(aDummy1, m_aDummy1)) {
      return EChange.UNCHANGED;
    }
    m_aDummy1 = aDummy1;
    return EChange.CHANGED;
  }
}
