/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
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

/**
 * Type base type
 *
 * @author Philip Helger
 */
public enum EJDMBaseType
{
  BOOLEAN ('b'),
  STRING ('s'),
  INTEGER ('n'),
  DOUBLE ('d'),
  DATETIME ('a'),
  OBJECT ('a');

  private final char m_cPrefix;

  private EJDMBaseType (final char cPrefix)
  {
    m_cPrefix = cPrefix;
  }

  /**
   * @return The prefix for generated code.
   */
  public char getPrefix ()
  {
    return m_cPrefix;
  }

  public boolean isBoolean ()
  {
    return this == BOOLEAN;
  }

  public boolean isString ()
  {
    return this == STRING;
  }

  public boolean isNumeric ()
  {
    return this == INTEGER || this == DOUBLE;
  }
}
