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
package com.helger.aufnahme.businessobj;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExLeergutBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@NotThreadSafe
public class ExLeergutBO
  extends AbstractBusinessObject
  implements IExLeergutBO
{
  public static final ObjectType OT = new ObjectType("ExLeergutBO");

  public ExLeergutBO() {
    this(StubObject.createForCurrentUser());
  }

  protected ExLeergutBO(@Nonnull final StubObject aStubObject) {
    super(aStubObject);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }
}
