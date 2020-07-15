/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.aufnahme.simple;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * Default MicroTypeConverter implementation of
 * {@link com.helger.aufnahme.simple.ITrunkSize}
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
public class TrunkSizeMicroTypeConverter implements IMicroTypeConverter <TrunkSize>
{
  private static final String ATTR_BHD = "bhd";
  private static final String ATTR_HEIGHT = "height";

  @Nonnull
  public IMicroElement convertToMicroElement (@Nonnull final TrunkSize aValue,
                                              @Nullable final String sNamespaceURI,
                                              @Nonnull final String sTagName)
  {
    final IMicroElement aElement = new MicroElement (sNamespaceURI, sTagName);
    aElement.setAttribute (ATTR_BHD, aValue.getBHD ());
    aElement.setAttribute (ATTR_HEIGHT, aValue.getHeight ().getID ());
    return aElement;
  }

  @Nonnull
  public TrunkSize convertToNative (@Nonnull final IMicroElement aElement)
  {
    final int nBHD = aElement.getAttributeValueAsInt (ATTR_BHD, -1);
    final ETreeHeight eHeight = ETreeHeight.getFromIDOrNull (aElement.getAttributeValue (ATTR_HEIGHT));
    return new TrunkSize (nBHD, eHeight);
  }
}
