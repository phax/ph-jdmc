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
package com.helger.aufnahme.businessobj;

import java.io.File;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import com.helger.xml.mock.XMLTestHelper;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExBestandBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExBestandBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExBestandBO x = new ExBestandBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")), Integer.valueOf(7), Long.valueOf(9L), Float.valueOf(5.0F), Double.valueOf(3.0), "foo", true, true, EExStockTypeBO._0, EExStockTypeBO._0, "foo", "foo", true, true, true, EExStockDeadwoodBO._0, "foo", EExStockDeadwoodBO._0, "foo");
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    ExBestandBO y = new ExBestandBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")), Integer.valueOf(7), Long.valueOf(9L), Float.valueOf(5.0F), Double.valueOf(3.0), "foo", true, true, EExStockTypeBO._0, EExStockTypeBO._0, "foo", "foo", true, true, true, EExStockDeadwoodBO._0, "foo", EExStockDeadwoodBO._0, "foo");
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse(x.setBNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setVerortung("foo").isChanged());
    x.setBZHBG(new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")));
    Assert.assertFalse(x.setAreaSize(Integer.valueOf(7)).isChanged());
    Assert.assertFalse(x.setAreaSizeLong(Long.valueOf(9L)).isChanged());
    Assert.assertFalse(x.setAreaSizeFloat(Float.valueOf(5.0F)).isChanged());
    Assert.assertFalse(x.setAreaSizeDouble(Double.valueOf(3.0)).isChanged());
    Assert.assertFalse(x.setBeschreib("foo").isChanged());
    Assert.assertFalse(x.setSameAge(true).isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    x.setStockType(EExStockTypeBO._0);
    x.setStockTypeOpt(EExStockTypeBO._0);
    Assert.assertFalse(x.setUsageDescription("foo").isChanged());
    Assert.assertFalse(x.setGesellschaft("foo").isChanged());
    Assert.assertFalse(x.setKronenschluss(true).isChanged());
    Assert.assertFalse(x.setLightWoods(true).isChanged());
    Assert.assertFalse(x.setUnterwuchs(true).isChanged());
    x.setTotSteh(EExStockDeadwoodBO._0);
    Assert.assertFalse(x.setTotStehBesch("foo").isChanged());
    x.setTotLieg(EExStockDeadwoodBO._0);
    Assert.assertFalse(x.setTotLiegBesch("foo").isChanged());
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion(x);
    // Test setters with null
    Assert.assertTrue(x.setVerortung(null).isChanged());
    Assert.assertTrue(x.setAreaSize(null).isChanged());
    Assert.assertTrue(x.setAreaSizeLong(null).isChanged());
    Assert.assertTrue(x.setAreaSizeFloat(null).isChanged());
    Assert.assertTrue(x.setAreaSizeDouble(null).isChanged());
    Assert.assertTrue(x.setStockTypeOpt(null).isChanged());
    // Check XML conversion again
    XMLTestHelper.testMicroTypeConversion(x);
  }
}
