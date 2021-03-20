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
    // Registration of com.helger.aufnahme.businessobj.ExStichprobeBO must be done manually!
    aRegistry.registerMicroElementTypeConverter(ExLeergutBO.class, new ExLeergutBOMicroTypeConverter());
  }
}
