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
package com.helger.jdmc.core.datamodel;

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;

/**
 * A single constraint in a type.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMGenConstraint implements Serializable
{
  private final EJDMConstraintType m_eConstraintType;
  private final Serializable m_aValue;

  public JDMGenConstraint (@Nonnull final EJDMConstraintType eConstraintType, @Nonnull final Serializable aValue)
  {
    ValueEnforcer.notNull (eConstraintType, "ConstraintType");
    ValueEnforcer.notNull (aValue, "Value");
    m_eConstraintType = eConstraintType;
    m_aValue = aValue;
  }

  @Nonnull
  public EJDMConstraintType getConstraintType ()
  {
    return m_eConstraintType;
  }

  @Nonnull
  public Serializable getValue ()
  {
    return m_aValue;
  }
}
