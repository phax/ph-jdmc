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
package com.helger.jdmc.core;

import static org.junit.Assert.assertNotNull;

import java.io.File;

import javax.annotation.Nonnull;

import org.junit.Test;

import com.helger.jdmc.core.codegen.JDMCodeGenerator;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMEnum;

/**
 * Test class for class {@link JDMProcessor}.
 *
 * @author Philip Helger
 */
public final class JDMProcessorTest
{
  private static void _applyTestJDM (@Nonnull final JDMProcessor p)
  {
    final File aSrcDir = new File ("src/test/resources/aufnahme");

    JDMEnum aEnum;

    aEnum = p.readEnumDef (new File (aSrcDir, "demo/EDemo1.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "demo/EDemo2.jdm"));
    assertNotNull (aEnum);

    aEnum = p.readEnumDef (new File (aSrcDir, "common/EDecompositionDegreeClass.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "common/EExposition.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "common/ETreeKind.jdm"));
    assertNotNull (aEnum);

    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EBiotopbaumType.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ECaveClass.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ECaveType.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EDeadwoodCategory.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ESpecialStructure.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/ETreeHeight.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "biotopbaum/EVitality.jdm"));
    assertNotNull (aEnum);

    aEnum = p.readEnumDef (new File (aSrcDir, "bestand/EStockDeadwood.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "bestand/EStockType.jdm"));
    assertNotNull (aEnum);

    aEnum = p.readEnumDef (new File (aSrcDir, "stichprobe/EUsagePeriod.jdm"));
    assertNotNull (aEnum);
    aEnum = p.readEnumDef (new File (aSrcDir, "stichprobe/EUsageType.jdm"));
    assertNotNull (aEnum);

    JDMClass aClass;
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/CaveType.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/TrunkSize.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/BiotopbaumDeadwood.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "biotopbaum/BiotopbaumDecompositionDegree.jdm"));
    assertNotNull (aClass);

    aClass = p.readClassDef (new File (aSrcDir, "stichprobe/StichprobeDeadwood.jdm"));
    assertNotNull (aClass);

    aClass = p.readClassDef (new File (aSrcDir, "Biotopbaum.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Habitatbaumgruppe.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Bestand.jdm"));
    assertNotNull (aClass);

    aClass = p.readClassDef (new File (aSrcDir, "Reservat.jdm"));
    assertNotNull (aClass);
    aClass = p.readClassDef (new File (aSrcDir, "Stichprobe.jdm"));
    assertNotNull (aClass);

    // Test only
    aClass = p.readClassDef (new File (aSrcDir, "Leergut.jdm"));
    assertNotNull (aClass);
  }

  private static final File DIR_EXAMPLE = new File ("../ph-jdmc-example");

  @Test
  public void testCodeCreation () throws Exception
  {
    // Order is important here
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.simple");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.settings ().setUseBusinessObject (false).setCreateManager (false);
      cg.createCode (DIR_EXAMPLE);
    }
    // Second run - read SPI now
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.businessobj");
      p.setClassNamePrefix ("Ex").setClassNameSuffix ("BO");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.settings ().setUseBusinessObject (true).setSetterArePackagePrivate (true).setReadExistingSPIFiles (true);
      cg.createCode (DIR_EXAMPLE);
    }
    // Third run - as little as possible
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.small");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.settings ().setUseBusinessObject (false).setCreateManager (false).setCreateMicroTypeConverter (false);
      cg.createCode (DIR_EXAMPLE);
    }
    // 4th run - as little as possible but BO
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.smallbo");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.settings ().setUseBusinessObject (true).setCreateManager (false).setCreateMicroTypeConverter (false);
      cg.createCode (DIR_EXAMPLE);
    }
  }
}
