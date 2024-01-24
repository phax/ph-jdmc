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
  public IMicroElement convertToMicroElement(@Nonnull final StichprobeDeadwood aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_DOD, aValue.getDoD().getID());
    aElement.setAttribute(ATTR_TREEKIND, aValue.getTreeKind().getID());
    aElement.setAttribute(ATTR_LENGTH, aValue.getLength());
    aElement.setAttribute(ATTR_BHD, aValue.getBHD());
    return aElement;
  }

  @Nonnull
  public StichprobeDeadwood convertToNative(@Nonnull final IMicroElement aElement) {
    final EDecompositionDegreeClass eDoD = EDecompositionDegreeClass.getFromIDOrNull(aElement.getAttributeValue(ATTR_DOD));
    final ETreeKind eTreeKind = ETreeKind.getFromIDOrNull(aElement.getAttributeValue(ATTR_TREEKIND));
    final int nLength = aElement.getAttributeValueAsInt(ATTR_LENGTH, -1);
    final int nBHD = aElement.getAttributeValueAsInt(ATTR_BHD, -1);
    return new StichprobeDeadwood(eDoD, eTreeKind, nLength, nBHD);
  }
}
