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

import com.helger.commons.annotation.IsSPIImplementation;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistrarSPI;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistry;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;

/**
 * <p>
 * Default MicroTypeConverter registrar of this project
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
@Immutable
@IsSPIImplementation
public final class MicroTypeConverterRegistrar implements IMicroTypeConverterRegistrarSPI
{

  public void registerMicroTypeConverter (@Nonnull final IMicroTypeConverterRegistry aRegistry)
  {
    aRegistry.registerMicroElementTypeConverter (CaveType.class, new CaveTypeMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (TrunkSize.class, new TrunkSizeMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (BiotopbaumDeadwood.class, new BiotopbaumDeadwoodMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (BiotopbaumDecompositionDegree.class,
                                                 new BiotopbaumDecompositionDegreeMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (StichprobeDeadwood.class, new StichprobeDeadwoodMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (Biotopbaum.class, new BiotopbaumMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (Habitatbaumgruppe.class, new HabitatbaumgruppeMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (Bestand.class, new BestandMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (Reservat.class, new ReservatMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (Stichprobe.class, new StichprobeMicroTypeConverter ());
    aRegistry.registerMicroElementTypeConverter (Leergut.class, new LeergutMicroTypeConverter ());
  }
}
