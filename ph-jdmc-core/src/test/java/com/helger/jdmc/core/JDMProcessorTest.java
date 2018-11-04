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

    aEnum = p.readEnumDef (new File (aSrcDir, "common/EExposition.jdm"));
    assertNotNull (aEnum);

    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EBiotopbaumType.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ECaveClass.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ECaveType.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EDeadwoodCategory.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EDecompositionDegreeClass.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ESpecialStructure.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ETreeHeight.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ETreeKind.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EVitality.jdm"));
    assertNotNull (aEnum);

    aEnum = p.readEnumDef (new File (aSrcDir, "bestand/EStockDeadwood.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "bestand/EStockType.jdm"));
    assertNotNull (aEnum);

    JDMClass aClass;
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/CaveType.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/TreeSize.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/EnabledDescription.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/BiotopbaumDeadwood.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/BiotopbaumDecompositionDegree.jdm"));
    assertNotNull (aClass);

    aClass = p.readClassDef (new File (aSrcDir, "Bestand.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Biotopbaum.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Habitatbaumgruppe.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "BiotopbaumAnzahl.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Stichprobe.jdm"));
    assertNotNull (aClass);

    p.createCode (new File ("../ph-jdmc-example/src/main/java"));
  }
}
