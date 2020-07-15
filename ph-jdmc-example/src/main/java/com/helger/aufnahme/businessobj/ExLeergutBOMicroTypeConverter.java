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
package com.helger.aufnahme.businessobj;

import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * <p>
 * Default MicroTypeConverter implementation of
 * {@link com.helger.aufnahme.businessobj.IExLeergutBO}
 * </p>
 * <p>
 * This class was initially automatically created
 * </p>
 * 
 * @author JDMCodeGenerator
 */
public class ExLeergutBOMicroTypeConverter extends AbstractBusinessObjectMicroTypeConverter <ExLeergutBO>
{

  @Nonnull
  public IMicroElement convertToMicroElement (@Nonnull final ExLeergutBO aValue,
                                              @Nullable final String sNamespaceURI,
                                              @Nonnull final String sTagName)
  {
    final IMicroElement aElement = new MicroElement (sNamespaceURI, sTagName);
    super.setObjectFields (aValue, aElement);
    return aElement;
  }

  @Nonnull
  public ExLeergutBO convertToNative (@Nonnull final IMicroElement aElement)
  {
    return new ExLeergutBO (super.getStubObject (aElement));
  }
}
