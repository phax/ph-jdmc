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
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.ICaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class CaveTypeMicroTypeConverter
  implements IMicroTypeConverter<CaveType>
{
  private static final String ATTR_CLAZZ = "clazz";
  private static final String ATTR_TYPE = "type";

  @Nonnull
  public IMicroElement convertToMicroElement(@Nonnull final CaveType aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_CLAZZ, aValue.getClazz().getID());
    aElement.setAttribute(ATTR_TYPE, aValue.getType().getID());
    return aElement;
  }

  @Nonnull
  public CaveType convertToNative(@Nonnull final IMicroElement aElement) {
    final ECaveClass eClazz = ECaveClass.getFromIDOrNull(aElement.getAttributeValue(ATTR_CLAZZ));
    final ECaveType eType = ECaveType.getFromIDOrNull(aElement.getAttributeValue(ATTR_TYPE));
    return new CaveType(eClazz, eType);
  }
}
