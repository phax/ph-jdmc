package com.helger.aufnahme.simple;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.IStichprobeDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class StichprobeDeadwoodMicroTypeConverter
  implements IMicroTypeConverter<StichprobeDeadwood>
{
  private static final String ATTR_DOD = "dod";
  private static final String ATTR_TREEKIND = "treekind";
  private static final String ATTR_LENGTH = "length";
  private static final String ATTR_BHD = "bhd";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final StichprobeDeadwood aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_DOD, aValue.getDoD().getID());
    aElement.setAttribute(ATTR_TREEKIND, aValue.getTreeKind().getID());
    aElement.setAttribute(ATTR_LENGTH, aValue.getLength());
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    return aElement;
  }

  @Nonnull
  public StichprobeDeadwood convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final EDecompositionDegreeClass eDoD = EDecompositionDegreeClass.getFromIDOrNull(aElement.getAttributeValue(ATTR_DOD));
    final ETreeKind eTreeKind = ETreeKind.getFromIDOrNull(aElement.getAttributeValue(ATTR_TREEKIND));
    final int nLength = aElement.getAttributeValueAsInt(ATTR_LENGTH, -1);
    final int nBHD = aElement.getAttributeValueAsInt(ATTR_BHD, -1);
    return new StichprobeDeadwood(eDoD, eTreeKind, nLength, nBHD);
  }
}
