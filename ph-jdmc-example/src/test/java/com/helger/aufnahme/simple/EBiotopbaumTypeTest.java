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

import org.junit.Assert;
import org.junit.Test;

import com.helger.commons.string.StringHelper;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.EBiotopbaumType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EBiotopbaumTypeTest {

  @Test
  public void testBasic() {
    for (final EBiotopbaumType e: EBiotopbaumType.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EBiotopbaumType.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EBiotopbaumType.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EBiotopbaumType.getFromIDOrThrow(e.getID()));
    }
  }
}
