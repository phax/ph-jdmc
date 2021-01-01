/**
 * Copyright (C) 2018-2021 Philip Helger (www.helger.com)
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
import com.helger.jdmc.core.datamodel.JDMGenClass;

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
    p.reader ()
     .addEnumDef (new File (aSrcDir, "demo/EDemo1.jdm"))
     .addEnumDef (new File (aSrcDir, "demo/EDemo2.jdm"))
     .addEnumDef (new File (aSrcDir, "demo/EDemo3.jdm"))
     .addEnumDef (new File (aSrcDir, "common/EDecompositionDegreeClass.jdm"))
     .addEnumDef (new File (aSrcDir, "common/EExposition.jdm"))
     .addEnumDef (new File (aSrcDir, "common/ETreeKind.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/EBiotopbaumType.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/ECaveClass.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/ECaveType.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/EDeadwoodCategory.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/ESpecialStructure.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/ETreeHeight.jdm"))
     .addEnumDef (new File (aSrcDir, "biotopbaum/EVitality.jdm"))
     .addEnumDef (new File (aSrcDir, "bestand/EStockDeadwood.jdm"))
     .addEnumDef (new File (aSrcDir, "bestand/EStockType.jdm"))
     .addEnumDef (new File (aSrcDir, "stichprobe/EUsagePeriod.jdm"))
     .addEnumDef (new File (aSrcDir, "stichprobe/EUsageType.jdm"))
     .addClassDef (new File (aSrcDir, "biotopbaum/CaveType.jdm"))
     .addClassDef (new File (aSrcDir, "biotopbaum/TrunkSize.jdm"))
     .addClassDef (new File (aSrcDir, "biotopbaum/BiotopbaumDeadwood.jdm"))
     .addClassDef (new File (aSrcDir, "biotopbaum/BiotopbaumDecompositionDegree.jdm"))
     .addClassDef (new File (aSrcDir, "stichprobe/StichprobeDeadwood.jdm"))
     .addClassDef (new File (aSrcDir, "Biotopbaum.jdm"))
     .addClassDef (new File (aSrcDir, "Habitatbaumgruppe.jdm"))
     .addClassDef (new File (aSrcDir, "Bestand.jdm"))
     .addClassDef (new File (aSrcDir, "Reservat.jdm"))
     .addClassDef (new File (aSrcDir, "Stichprobe.jdm"))
     .addClassDef (new File (aSrcDir, "Leergut.jdm"))
     .readAll ();
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
      cg.defaultSettings ().setUseBusinessObject (false).setCreateManager (false);
      cg.createCode (DIR_EXAMPLE);
    }
    // Second run - read SPI now
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.businessobj");
      p.setClassNamePrefix ("Ex").setClassNameSuffix ("BO");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.defaultSettings ().setUseBusinessObject (true).setSetterArePackagePrivate (true).setReadExistingSPIFiles (true);
      cg.createCode (DIR_EXAMPLE);
    }
    // Third run - as little as possible
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.small");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.defaultSettings ().setUseBusinessObject (false).setCreateManager (false).setCreateMicroTypeConverter (false);
      cg.createCode (DIR_EXAMPLE);
    }
    // 4th run - as little as possible but BO
    {
      final JDMProcessor p = new JDMProcessor ("com.helger.aufnahme.smallbo");
      _applyTestJDM (p);
      final JDMCodeGenerator cg = new JDMCodeGenerator (p);
      cg.defaultSettings ().setUseBusinessObject (true).setCreateManager (false).setCreateMicroTypeConverter (false);
      cg.createCode (DIR_EXAMPLE);
    }
  }

  @Test
  public void testPostpone () throws Exception
  {
    final JDMProcessor p = new JDMProcessor ("com.helger.postpone");
    final File aSrcDir = new File ("src/test/resources/postpone");

    // A references B
    // B references C
    // C references E
    p.reader ()
     .addClassDef (new File (aSrcDir, "A.jdm"))
     .addClassDef (new File (aSrcDir, "B.jdm"))
     .addClassDef (new File (aSrcDir, "C.jdm"))
     .addEnumDef (new File (aSrcDir, "E.jdm"))
     .readAll ();

    final JDMCodeGenerator cg = new JDMCodeGenerator (p);
    cg.defaultSettings ().setUseBusinessObject (true).setCreateManager (false).setCreateMicroTypeConverter (false);
    cg.createCode (DIR_EXAMPLE);
  }

  @Test
  public void testSelfReference () throws Exception
  {
    final JDMProcessor p = new JDMProcessor ("com.helger.selfref");
    final File aSrcDir = new File ("src/test/resources/selfref");

    JDMGenClass aClass;
    aClass = p.readClassDef (new File (aSrcDir, "SelfRefDemo1.jdm"));
    assertNotNull (aClass);
    final JDMCodeGenerator cg = new JDMCodeGenerator (p);
    cg.defaultSettings ().setUseBusinessObject (true).setCreateManager (false).setCreateMicroTypeConverter (false);
    cg.createCode (DIR_EXAMPLE);
  }
}
