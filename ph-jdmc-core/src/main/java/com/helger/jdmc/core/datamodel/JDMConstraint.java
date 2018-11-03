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

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.ICommonsList;

@NotThreadSafe
public class JDMConstraint
{
  private final EJDMConstraintType m_eConstraintType;
  private final ICommonsList <Serializable> m_aValues;

  public JDMConstraint (@Nonnull final EJDMConstraintType eConstraintType,
                        @Nonnull @Nonempty final ICommonsList <Serializable> aValues)
  {
    ValueEnforcer.notNull (eConstraintType, "ConstraintType");
    ValueEnforcer.notEmpty (aValues, "Values");
    m_eConstraintType = eConstraintType;
    m_aValues = aValues.getClone ();
  }

  @Nonnull
  public EJDMConstraintType getConstraintType ()
  {
    return m_eConstraintType;
  }

  @Nonnull
  @ReturnsMutableObject
  public ICommonsList <Serializable> values ()
  {
    return m_aValues;
  }
}
