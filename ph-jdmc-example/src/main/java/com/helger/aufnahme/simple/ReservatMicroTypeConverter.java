/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.IReservat}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ReservatMicroTypeConverter
  implements IMicroTypeConverter<Reservat>
{
  private static final String ATTR_RNR = "rnr";
  private static final String ELEMENT_NAME = "name";
  private static final String ATTR_AREASIZE = "areasize";

  @Nonnull
  public IMicroElement convertToMicroElement(@Nonnull final Reservat aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_RNR, aValue.getRNr());
    aElement.appendElement(sNamespaceURI, ELEMENT_NAME).appendText(aValue.getName());
    aElement.setAttribute(ATTR_AREASIZE, aValue.getAreaSize());
    return aElement;
  }

  @Nonnull
  public Reservat convertToNative(@Nonnull final IMicroElement aElement) {
    final int nRNr = aElement.getAttributeValueAsInt(ATTR_RNR, -1);
    final String sName = MicroHelper.getChildTextContent(aElement, ELEMENT_NAME);
    final int nAreaSize = aElement.getAttributeValueAsInt(ATTR_AREASIZE, -1);
    return new Reservat(nRNr, sName, nAreaSize);
  }
}
