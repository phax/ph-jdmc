/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.Biotopbaum}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class BiotopbaumTest {

  @Test
  public void testDefaultCtor() {
    Biotopbaum x = new Biotopbaum();
    Assert.assertEquals(x, new Biotopbaum());
    x.getBBNr();
    Assert.assertNotNull(x.pics());
    Assert.assertNull(x.getDate());
    Assert.assertNotNull(x.type());
    Assert.assertNull(x.getLocation());
    Assert.assertNull(x.getExposition());
    Assert.assertNull(x.getHanglage());
    x.isEinschichtig();
    x.isSolitary();
    x.isLightLocation();
    x.isClosedCrown();
    x.isNoSun();
    x.isUeberSun();
    x.isHomogene();
    Assert.assertNull(x.getBeschreibung());
    Assert.assertNull(x.getTreeKind());
    Assert.assertNotNull(x.caves());
    Assert.assertNotNull(x.trunk());
    Assert.assertNull(x.getVitality());
    Assert.assertNotNull(x.specialStructure());
    Assert.assertNull(x.getOtherSpecial());
    x.isAspirant();
    Assert.assertNull(x.getAspirantDesc());
    x.isMarked();
    Assert.assertNull(x.getMarkedDesc());
    Assert.assertNotNull(x.deadwoodCats());
    Assert.assertNotNull(x.deadwoodDoD());
  }

  @Test
  public void testSetterAndGetter() {
    Biotopbaum x = new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)));
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Biotopbaum y = new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)));
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, y);
    // Test copy ctor
    Biotopbaum z = new Biotopbaum(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, z);
    // Test all setters
    Assert.assertFalse(x.setBBNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setType(new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ)).isChanged());
    Assert.assertFalse(x.setLocation("foo").isChanged());
    Assert.assertFalse(x.setExposition(EExposition.N).isChanged());
    Assert.assertFalse(x.setHanglage("foo").isChanged());
    Assert.assertFalse(x.setEinschichtig(true).isChanged());
    Assert.assertFalse(x.setSolitary(true).isChanged());
    Assert.assertFalse(x.setLightLocation(true).isChanged());
    Assert.assertFalse(x.setClosedCrown(true).isChanged());
    Assert.assertFalse(x.setNoSun(true).isChanged());
    Assert.assertFalse(x.setUeberSun(true).isChanged());
    Assert.assertFalse(x.setHomogene(true).isChanged());
    Assert.assertFalse(x.setBeschreibung("foo").isChanged());
    Assert.assertFalse(x.setTreeKind(ETreeKind.Bergahorn).isChanged());
    Assert.assertFalse(x.setCaves(new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1))).isChanged());
    Assert.assertFalse(x.setTrunk(new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE))).isChanged());
    Assert.assertFalse(x.setVitality(EVitality.ONE).isChanged());
    Assert.assertFalse(x.setSpecialStructure(new CommonsArrayList<>(ESpecialStructure._1)).isChanged());
    Assert.assertFalse(x.setOtherSpecial("foo").isChanged());
    Assert.assertFalse(x.setAspirant(true).isChanged());
    Assert.assertFalse(x.setAspirantDesc("foo").isChanged());
    Assert.assertFalse(x.setMarked(true).isChanged());
    Assert.assertFalse(x.setMarkedDesc("foo").isChanged());
    Assert.assertFalse(x.setDeadwoodCats(new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8))).isChanged());
    Assert.assertFalse(x.setDeadwoodDoD(new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8))).isChanged());
    // Test setters with null
    Assert.assertTrue(x.setLocation(null).isChanged());
    Assert.assertTrue(x.setHanglage(null).isChanged());
    Assert.assertTrue(x.setOtherSpecial(null).isChanged());
    Assert.assertTrue(x.setAspirantDesc(null).isChanged());
    Assert.assertTrue(x.setMarkedDesc(null).isChanged());
  }
}
