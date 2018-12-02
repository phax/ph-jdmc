package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExTrunkSizeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExTrunkSizeBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExTrunkSizeBO>
{
  private static final String ATTR_BHD = "bhd";
  private static final String ATTR_HEIGHT = "height";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final ExTrunkSizeBO aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    aElement.setAttribute(ATTR_HEIGHT, aValue.getHeight().getID());
    return aElement;
  }

  @Nonnull
  public ExTrunkSizeBO convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final int nBHD = aElement.getAttributeValueAsInt(ATTR_BHD, -1);
    final EExTreeHeightBO eHeight = EExTreeHeightBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_HEIGHT));
    return new ExTrunkSizeBO(super.getStubObject(aElement), nBHD, eHeight);
  }
}
