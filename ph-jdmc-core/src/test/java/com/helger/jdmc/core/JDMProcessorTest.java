/**
 * Copyright (C) 2018 Philip Helger (www.helger.com)
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

import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMEnum;

/**
 * Test class for class {@link JDMProcessor}.
 *
 * @author Philip Helger
 */
public final class JDMProcessorTest
{
  @Test
  public void testReadSimple () throws IOException
  {
    final File aSrcDir = new File ("src/test/resources/aufnahme");

    final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.domain");

    JDMEnum aEnum;
    aEnum = p.readEnumDef (new File (aSrcDir, "EBaumArt.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "EBiotopbaumType.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "ECaveClass.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "ECaveType.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "EDeadwoodCategory.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "EDecompositionDegreeClass.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "EExposition.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "EHeight.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "ESpecialStructure.json"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "EVitality.json"));
    assertNotNull (aEnum);

    JDMClass aClass;
    aClass = p.readClassDef (new File (aSrcDir, "Bestand.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Habitatbaumgruppe.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "CaveType.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "TreeSize.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "EnabledDescription.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "BiotopbaumDeadwood.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "BiotopbaumDecompositionDegree.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Biotopbaum.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "BiotopbaumAnzahl.json"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Stichprobe.json"));
    assertNotNull (aClass);

    p.createCode (new File ("../ph-jdmc-example/src/main/java"));
  }
}
