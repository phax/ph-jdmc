package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExBiotopbaumDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumDeadwoodBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExBiotopbaumDeadwoodBO>
{
  private static final String ATTR_TYPE = "type";
  private static final String ATTR_ENABLED = "enabled";
  private static final String ATTR_LENGTH = "length";
  private static final String ATTR_BHD = "bhd";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final ExBiotopbaumDeadwoodBO aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_TYPE, aValue.getType().getID());
    aElement.setAttribute(ATTR_ENABLED, aValue.isEnabled());
    aElement.setAttribute(ATTR_LENGTH, aValue.getLength());
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    return aElement;
  }

  @Nonnull
  public ExBiotopbaumDeadwoodBO convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final EExDeadwoodCategoryBO eType = EExDeadwoodCategoryBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TYPE));
    final boolean bEnabled = aElement.getAttributeValueWithConversion(ATTR_ENABLED, boolean.class);
    final int nLength = aElement.getAttributeValueWithConversion(ATTR_LENGTH, int.class);
    final int nBHD = aElement.getAttributeValueWithConversion(ATTR_BHD, int.class);
    return new ExBiotopbaumDeadwoodBO(super.getStubObject(aElement), eType, bEnabled, nLength, nBHD);
  }
}
