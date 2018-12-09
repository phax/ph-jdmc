package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExStichprobeDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExStichprobeDeadwoodBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExStichprobeDeadwoodBO>
{
  private static final String ATTR_DOD = "dod";
  private static final String ATTR_TREEKIND = "treekind";
  private static final String ATTR_LENGTH = "length";
  private static final String ATTR_BHD = "bhd";

  @Nonnull
  public IMicroElement convertToMicroElement(@Nonnull final ExStichprobeDeadwoodBO aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_DOD, aValue.getDoD().getID());
    aElement.setAttribute(ATTR_TREEKIND, aValue.getTreeKind().getID());
    aElement.setAttribute(ATTR_LENGTH, aValue.getLength());
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    return aElement;
  }

  @Nonnull
  public ExStichprobeDeadwoodBO convertToNative(@Nonnull final IMicroElement aElement) {
    final EExDecompositionDegreeClassBO eDoD = EExDecompositionDegreeClassBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_DOD));
    final EExTreeKindBO eTreeKind = EExTreeKindBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TREEKIND));
    final int nLength = aElement.getAttributeValueAsInt(ATTR_LENGTH, -1);
    final int nBHD = aElement.getAttributeValueAsInt(ATTR_BHD, -1);
    return new ExStichprobeDeadwoodBO(super.getStubObject(aElement), eDoD, eTreeKind, nLength, nBHD);
  }
}
