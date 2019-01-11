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

import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.string.StringHelper;
import com.helger.xml.mock.XMLTestHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.StichprobeDeadwood}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class StichprobeDeadwoodTest {

  @Test
  public void testDefaultCtor() {
    StichprobeDeadwood x = new StichprobeDeadwood();
    Assert.assertEquals(x, new StichprobeDeadwood());
    Assert.assertNull(x.getDoD());
    Assert.assertNull(x.getTreeKind());
    x.getLength();
    x.getBHD();
  }

  @Test
  public void testSetterAndGetter() {
    StichprobeDeadwood x = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    StichprobeDeadwood y = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, y);
    // Test copy ctor
    StichprobeDeadwood z = new StichprobeDeadwood(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, z);
    // Test all setters
    Assert.assertFalse(x.setDoD(EDecompositionDegreeClass.CLASS0).isChanged());
    Assert.assertFalse(x.setTreeKind(ETreeKind.Bergahorn).isChanged());
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion(x);
  }
}
