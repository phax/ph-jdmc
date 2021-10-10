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
package com.helger.aufnahme.small;

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.mock.CommonsTestHelper;
import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.Habitatbaumgruppe}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class HabitatbaumgruppeTest {

  @Test
  public void testDefaultCtor() {
    Habitatbaumgruppe x = new Habitatbaumgruppe();
    Assert.assertEquals(x, new Habitatbaumgruppe());
    x.getHBGNr();
    Assert.assertNotNull(x.pics());
    Assert.assertNotNull(x.HBGzBB());
    Assert.assertNull(x.getDate());
    Assert.assertNull(x.getStandort());
    x.isOneLevel();
    x.isLight();
    x.isClosedCrown();
    x.isNoSun();
    x.isHomogen();
    Assert.assertNull(x.getExposition());
    Assert.assertNull(x.getHanglage());
    x.getAreaSize();
    x.isOnlyBB();
    Assert.assertNull(x.getBeschreibung());
  }

  @Test
  public void testSetterAndGetter() {
    Habitatbaumgruppe x = new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo");
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Habitatbaumgruppe y = new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo");
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, y);
    // Test copy ctor
    Habitatbaumgruppe z = new Habitatbaumgruppe(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    CommonsTestHelper.testDefaultImplementationWithEqualContentObject(x, z);
    // Test all setters
    Assert.assertFalse(x.setHBGNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setHBGzBB(new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8))))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setStandort("foo").isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    Assert.assertFalse(x.setLight(true).isChanged());
    Assert.assertFalse(x.setClosedCrown(true).isChanged());
    Assert.assertFalse(x.setNoSun(true).isChanged());
    Assert.assertFalse(x.setHomogen(true).isChanged());
    Assert.assertFalse(x.setExposition(EExposition.N).isChanged());
    Assert.assertFalse(x.setHanglage("foo").isChanged());
    Assert.assertFalse(x.setAreaSize(8).isChanged());
    Assert.assertFalse(x.setOnlyBB(true).isChanged());
    Assert.assertFalse(x.setBeschreibung("foo").isChanged());
    // Test setters with null
    Assert.assertTrue(x.setHanglage(null).isChanged());
  }
}
