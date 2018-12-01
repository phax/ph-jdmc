package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExCaveTypeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExCaveTypeBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExCaveTypeBO>
{
  private static final String ATTR_CLAZZ = "clazz";
  private static final String ATTR_TYPE = "type";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final ExCaveTypeBO aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_CLAZZ, aValue.getClazz().getID());
    aElement.setAttribute(ATTR_TYPE, aValue.getType().getID());
    return aElement;
  }

  @Nonnull
  public ExCaveTypeBO convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final EExCaveClassBO eClazz = EExCaveClassBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_CLAZZ));
    final EExCaveTypeBO eType = EExCaveTypeBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TYPE));
    return new ExCaveTypeBO(super.getStubObject(aElement), eClazz, eType);
  }
}
