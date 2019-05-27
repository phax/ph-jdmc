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
package com.helger.aufnahme.simple;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link BiotopbaumDecompositionDegree}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IBiotopbaumDecompositionDegree
  extends Serializable
{

  /**
   * Get the value of type.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EDecompositionDegreeClass getType();

  @Nonnull
  default String getTypeID() {
    return getType().getID();
  }

  /**
   * Get the value of enabled.
   * 
   * @return
   *     The requested value.
   */
  boolean isEnabled();

  /**
   * Länge in cm
   * 
   * @return
   *     The requested value.
   */
  int getLength();

  /**
   * BHD bzw. Mittendurchmesser in cm
   * 
   * @return
   *     The requested value.
   */
  int getBHD();
}
