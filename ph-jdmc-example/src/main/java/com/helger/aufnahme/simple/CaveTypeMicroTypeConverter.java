package com.helger.aufnahme.simple;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.ICaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class CaveTypeMicroTypeConverter
  extends IMicroTypeConverter<CaveType>
{
  private static final String ATTR_CLAZZ = "clazz";
  private static final String ATTR_TYPE = "type";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final CaveType aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_CLAZZ, aValue.getClazz().getID());
    aElement.setAttribute(ATTR_TYPE, aValue.getType().getID());
    return aElement;
  }

  @Nonnull
  public CaveType convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final ECaveClass eClazz = ECaveClass.getFromIDOrNull(aElement.getAttributeValue(ATTR_CLAZZ));
    final ECaveType eType = ECaveType.getFromIDOrNull(aElement.getAttributeValue(ATTR_TYPE));
    return new CaveType(eClazz, eType);
  }
}
