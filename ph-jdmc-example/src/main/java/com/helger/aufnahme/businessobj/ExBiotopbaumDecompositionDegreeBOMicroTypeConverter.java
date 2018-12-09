package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExBiotopbaumDecompositionDegreeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumDecompositionDegreeBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExBiotopbaumDecompositionDegreeBO>
{
  private static final String ATTR_TYPE = "type";
  private static final String ATTR_ENABLED = "enabled";
  private static final String ATTR_LENGTH = "length";
  private static final String ATTR_BHD = "bhd";

  @Nonnull
  public IMicroElement convertToMicroElement(@Nonnull final ExBiotopbaumDecompositionDegreeBO aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_TYPE, aValue.getType().getID());
    aElement.setAttribute(ATTR_ENABLED, aValue.isEnabled());
    aElement.setAttribute(ATTR_LENGTH, aValue.getLength());
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    return aElement;
  }

  @Nonnull
  public ExBiotopbaumDecompositionDegreeBO convertToNative(@Nonnull final IMicroElement aElement) {
    final EExDecompositionDegreeClassBO eType = EExDecompositionDegreeClassBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TYPE));
    final boolean bEnabled = aElement.getAttributeValueAsBool(ATTR_ENABLED, false);
    final int nLength = aElement.getAttributeValueAsInt(ATTR_LENGTH, -1);
    final int nBHD = aElement.getAttributeValueAsInt(ATTR_BHD, -1);
    return new ExBiotopbaumDecompositionDegreeBO(super.getStubObject(aElement), eType, bEnabled, nLength, nBHD);
  }
}
