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
package com.helger.aufnahme.smallbo;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.CaveType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class CaveTypeTest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

  @Test
  public void testSetterAndGetter() {
    CaveType x = new CaveType(ECaveClass.ONE, ECaveType._1);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    CaveType y = new CaveType(ECaveClass.ONE, ECaveType._1);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    x.setClazz(ECaveClass.ONE);
    x.setType(ECaveType._1);
  }
}
