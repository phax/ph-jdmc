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

import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import com.helger.xml.mock.XMLTestHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * This is the test class for class
 * {@link com.helger.aufnahme.businessobj.ExBiotopbaumDecompositionDegreeBO}
 * This class was initially automatically created
 * 
 * @author JDMCodeGenerator
 */
public final class ExBiotopbaumDecompositionDegreeBOTest
{
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule ();

  @Test
  public void testSetterAndGetter ()
  {
    ExBiotopbaumDecompositionDegreeBO x = new ExBiotopbaumDecompositionDegreeBO (EExDecompositionDegreeClassBO.CLASS0, true, 8, 8);
    Assert.assertTrue (StringHelper.hasText (x.toString ()));
    ExBiotopbaumDecompositionDegreeBO y = new ExBiotopbaumDecompositionDegreeBO (EExDecompositionDegreeClassBO.CLASS0, true, 8, 8);
    Assert.assertTrue (StringHelper.hasText (y.toString ()));
    Assert.assertNotSame (x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    x.setType (EExDecompositionDegreeClassBO.CLASS0);
    Assert.assertFalse (x.setEnabled (true).isChanged ());
    Assert.assertFalse (x.setLength (8).isChanged ());
    Assert.assertFalse (x.setBHD (8).isChanged ());
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion (x);
  }
}
