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
package com.helger.aufnahme.small;

import java.io.Serializable;

import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link TrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface ITrunkSize
  extends Serializable
{

  /**
   * Brusthöhendurchmesser; Mittendurchmesser in cm
   * 
   * @return
   *     The requested value.
   */
  int getBHD();

  /**
   * Baumhöhe/Stammlänge
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ETreeHeight getHeight();

  @Nonnull
  default String getHeightID() {
    return getHeight().getID();
  }
}
