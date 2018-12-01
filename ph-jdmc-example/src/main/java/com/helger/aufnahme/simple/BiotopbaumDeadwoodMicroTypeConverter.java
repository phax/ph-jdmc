package com.helger.aufnahme.simple;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.IBiotopbaumDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class BiotopbaumDeadwoodMicroTypeConverter
  extends IMicroTypeConverter<BiotopbaumDeadwood>
{
  private static final String ATTR_TYPE = "type";
  private static final String ATTR_ENABLED = "enabled";
  private static final String ATTR_LENGTH = "length";
  private static final String ATTR_BHD = "bhd";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final BiotopbaumDeadwood aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_TYPE, aValue.getType().getID());
    aElement.setAttribute(ATTR_ENABLED, aValue.isEnabled());
    aElement.setAttribute(ATTR_LENGTH, aValue.getLength());
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    return aElement;
  }

  @Nonnull
  public BiotopbaumDeadwood convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final EDeadwoodCategory eType = EDeadwoodCategory.getFromIDOrNull(aElement.getAttributeValue(ATTR_TYPE));
    final boolean bEnabled = aElement.getAttributeValueWithConversion(ATTR_ENABLED, boolean.class);
    final int nLength = aElement.getAttributeValueWithConversion(ATTR_LENGTH, int.class);
    final int nBHD = aElement.getAttributeValueWithConversion(ATTR_BHD, int.class);
    return new BiotopbaumDeadwood(eType, bEnabled, nLength, nBHD);
  }
}
