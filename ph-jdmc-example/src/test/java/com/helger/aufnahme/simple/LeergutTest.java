/*
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
 * This is the test class for class {@link com.helger.aufnahme.simple.Leergut}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class LeergutTest {

  @Test
  public void testDefaultCtor() {
    Leergut x = new Leergut();
    Assert.assertEquals(x, new Leergut());
  }

  @Test
  public void testSetterAndGetter() {
    Leergut x = new Leergut();
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Leergut y = new Leergut();
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, y);
    // Test all setters
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion(x);
  }
}
