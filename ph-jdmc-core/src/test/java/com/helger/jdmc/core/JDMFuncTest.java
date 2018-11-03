/**
 * Copyright (C) 2014-2018 Philip Helger
 * http://www.helger.com
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
package com.helger.jdmc.core;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public final class JDMFuncTest
{
  @Test
  public void testReadSimple () throws IOException
  {
    final JDMProcessor p = new JDMProcessor ("com.helger.bozoo.test");
    JDMClass aClass;
    aClass = p.processFile (new File ("src/test/resources/jdm/Bestand.json"));
    assertNotNull (aClass);
    aClass = p.processFile (new File ("src/test/resources/jdm/Habitatbaumgruppe.json"));
    assertNotNull (aClass);
    aClass = p.processFile (new File ("src/test/resources/jdm/Hoehletyp.json"));
    assertNotNull (aClass);
    aClass = p.processFile (new File ("src/test/resources/jdm/Stammtyp.json"));
    assertNotNull (aClass);
    aClass = p.processFile (new File ("src/test/resources/jdm/Biotopbaum.json"));
    assertNotNull (aClass);
    aClass = p.processFile (new File ("src/test/resources/jdm/BiotopbaumAnzahl.json"));
    assertNotNull (aClass);
    aClass = p.processFile (new File ("src/test/resources/jdm/Stichprobe.json"));
    assertNotNull (aClass);

    p.extractCommonEnums ();

    p.createJavaClasses (new File ("src/test/java"));
  }
}
