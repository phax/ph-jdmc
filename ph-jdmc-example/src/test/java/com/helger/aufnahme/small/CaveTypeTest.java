/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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
package com.helger.aufnahme.small;

import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.CaveType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class CaveTypeTest {

  @Test
  public void testDefaultCtor() {
    CaveType x = new CaveType();
    Assert.assertEquals(x, new CaveType());
    Assert.assertNull(x.getClazz());
    Assert.assertNull(x.getType());
  }

  @Test
  public void testSetterAndGetter() {
    CaveType x = new CaveType(ECaveClass.ONE, ECaveType._1);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    CaveType y = new CaveType(ECaveClass.ONE, ECaveType._1);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, y);
    // Test copy ctor
    CaveType z = new CaveType(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, z);
    // Test all setters
    Assert.assertFalse(x.setClazz(ECaveClass.ONE).isChanged());
    Assert.assertFalse(x.setType(ECaveType._1).isChanged());
  }
}
