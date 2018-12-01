package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExLeergutBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExLeergutBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExLeergutBO>
{

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final ExLeergutBO aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    return aElement;
  }

  @Nonnull
  public ExLeergutBO convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    return new ExLeergutBO(super.getStubObject(aElement));
  }
}
