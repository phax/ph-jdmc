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
package com.helger.aufnahme.smallbo;

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.Stichprobe}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class StichprobeTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    Stichprobe x = new Stichprobe(8, new Reservat(8, "foo", 8), new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), 8, EExposition.N, "foo", "foo", 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, "foo", "foo", new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), "foo", true, true, new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)), new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)), new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)));
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Stichprobe y = new Stichprobe(8, new Reservat(8, "foo", 8), new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), 8, EExposition.N, "foo", "foo", 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, "foo", "foo", new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), "foo", true, true, new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)), new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)), new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)));
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse(x.setStichNr(8).isChanged());
    x.setStichNrzR(new Reservat(8, "foo", 8));
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setSize(8).isChanged());
    x.setExposition(EExposition.N);
    Assert.assertFalse(x.setHanglage("foo").isChanged());
    Assert.assertFalse(x.setGesellschaft("foo").isChanged());
    Assert.assertFalse(x.setBKL0(4.0).isChanged());
    Assert.assertFalse(x.setBKL1(4.0).isChanged());
    Assert.assertFalse(x.setBKL2(4.0).isChanged());
    Assert.assertFalse(x.setBKL3(4.0).isChanged());
    Assert.assertFalse(x.setBKL4(4.0).isChanged());
    Assert.assertFalse(x.setBKL5(4.0).isChanged());
    Assert.assertFalse(x.setBKL6(4.0).isChanged());
    Assert.assertFalse(x.setBKL7(4.0).isChanged());
    Assert.assertFalse(x.setBKL8(4.0).isChanged());
    Assert.assertFalse(x.setBKL9(4.0).isChanged());
    Assert.assertFalse(x.setUsage("foo").isChanged());
    Assert.assertFalse(x.setUsageDesc("foo").isChanged());
    x.setTrees(new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))));
    Assert.assertFalse(x.setDesc("foo").isChanged());
    Assert.assertFalse(x.setSameAge(true).isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    x.setTotSteh(new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)));
    x.setTotLieg1(new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)));
    x.setTotLieg2(new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)));
    // Test setters with null
    Assert.assertTrue(x.setHanglage(null).isChanged());
  }
}
