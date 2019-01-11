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
package com.helger.aufnahme.businessobj;

import com.helger.commons.annotation.IsSPIImplementation;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistrarSPI;
import com.helger.xml.microdom.convert.IMicroTypeConverterRegistry;
import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;


/**
 * <p>Default MicroTypeConverter registrar of this project</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
@Immutable
@IsSPIImplementation
public final class MicroTypeConverterRegistrar
  implements IMicroTypeConverterRegistrarSPI
{

  public void registerMicroTypeConverter(@Nonnull final IMicroTypeConverterRegistry aRegistry) {
    aRegistry.registerMicroElementTypeConverter(ExCaveTypeBO.class, new ExCaveTypeBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExTrunkSizeBO.class, new ExTrunkSizeBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExBiotopbaumDeadwoodBO.class, new ExBiotopbaumDeadwoodBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExBiotopbaumDecompositionDegreeBO.class, new ExBiotopbaumDecompositionDegreeBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExStichprobeDeadwoodBO.class, new ExStichprobeDeadwoodBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExBiotopbaumBO.class, new ExBiotopbaumBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExHabitatbaumgruppeBO.class, new ExHabitatbaumgruppeBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExBestandBO.class, new ExBestandBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExReservatBO.class, new ExReservatBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExStichprobeBO.class, new ExStichprobeBOMicroTypeConverter());
    aRegistry.registerMicroElementTypeConverter(ExLeergutBO.class, new ExLeergutBOMicroTypeConverter());
  }
}
