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
package com.helger.aufnahme.small;

import org.junit.Assert;
import org.junit.Test;

import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.string.StringHelper;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.TrunkSize}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class TrunkSizeTest {

  @Test
  public void testDefaultCtor() {
    TrunkSize x = new TrunkSize();
    Assert.assertEquals(x, new TrunkSize());
    x.getBHD();
    Assert.assertNull(x.getHeight());
  }

  @Test
  public void testSetterAndGetter() {
    TrunkSize x = new TrunkSize(8, ETreeHeight.ONE);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    TrunkSize y = new TrunkSize(8, ETreeHeight.ONE);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, y);
    // Test copy ctor
    TrunkSize z = new TrunkSize(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, z);
    // Test all setters
    Assert.assertFalse(x.setBHD(8).isChanged());
    Assert.assertFalse(x.setHeight(ETreeHeight.ONE).isChanged());
  }
}
