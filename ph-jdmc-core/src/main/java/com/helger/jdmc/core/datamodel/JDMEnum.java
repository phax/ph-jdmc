/**
 * Copyright (C) 2018 Philip Helger (www.helger.com)
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
package com.helger.jdmc.core.datamodel;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;

@NotThreadSafe
public class JDMEnum extends AbstractJDMType
{
  private final ICommonsList <JDMEnumConstant> m_aEnumConstants = new CommonsArrayList <> ();

  public JDMEnum (@Nonnull final String sPackageName, @Nonnull @Nonempty final String sClassName)
  {
    super (sPackageName, sClassName);
  }

  @Nonnull
  @ReturnsMutableObject
  public ICommonsList <JDMEnumConstant> enumConstants ()
  {
    return m_aEnumConstants;
  }
}
