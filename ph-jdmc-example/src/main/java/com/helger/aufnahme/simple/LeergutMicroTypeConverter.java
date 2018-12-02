package com.helger.aufnahme.simple;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.ILeergut}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class LeergutMicroTypeConverter
  implements IMicroTypeConverter<Leergut>
{

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final Leergut aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    return aElement;
  }

  @Nonnull
  public Leergut convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    return new Leergut();
  }
}
