package com.helger.aufnahme.simple;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.ITrunkSize}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class TrunkSizeMicroTypeConverter
  extends IMicroTypeConverter<TrunkSize>
{
  private static final String ATTR_BHD = "bhd";
  private static final String ATTR_HEIGHT = "height";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final TrunkSize aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    aElement.setAttribute(ATTR_HEIGHT, aValue.getHeight().getID());
    return aElement;
  }

  @Nonnull
  public TrunkSize convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final int nBHD = aElement.getAttributeValueWithConversion(ATTR_BHD, int.class);
    final ETreeHeight eHeight = ETreeHeight.getFromIDOrNull(aElement.getAttributeValue(ATTR_HEIGHT));
    return new TrunkSize(nBHD, eHeight);
  }
}
