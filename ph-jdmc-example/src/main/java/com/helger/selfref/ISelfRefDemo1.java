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
package com.helger.selfref;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nullable;

/**
 * <p>
 * Interface for class {@link SelfRefDemo1}
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
public interface ISelfRefDemo1 extends IBusinessObject
{

  /**
   * Get the value of dummy1.
   * 
   * @return The requested value. May be <code>null</code>.
   */
  @Nullable
  com.helger.selfref.ISelfRefDemo1 getDummy1 ();

  default boolean hasDummy1 ()
  {
    return (getDummy1 () != null);
  }
}
