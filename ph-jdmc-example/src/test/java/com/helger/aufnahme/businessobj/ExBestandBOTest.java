package com.helger.aufnahme.businessobj;

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
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExBestandBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExBestandBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExBestandBO x = new ExBestandBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")), 8, "foo", true, true, EExStockTypeBO._0, "foo", "foo", true, true, true, EExStockDeadwoodBO._0, "foo", EExStockDeadwoodBO._0, "foo");
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Assert.assertFalse(x.setBNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setVerortung("foo").isChanged());
    x.setBZHBG(new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")));
    Assert.assertFalse(x.setAreaSize(8).isChanged());
    Assert.assertFalse(x.setBeschreib("foo").isChanged());
    Assert.assertFalse(x.setSameAge(true).isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    x.setStockType(EExStockTypeBO._0);
    Assert.assertFalse(x.setUsageDescription("foo").isChanged());
    Assert.assertFalse(x.setGesellschaft("foo").isChanged());
    Assert.assertFalse(x.setKronenschluss(true).isChanged());
    Assert.assertFalse(x.setLightWoods(true).isChanged());
    Assert.assertFalse(x.setUnterwuchs(true).isChanged());
    x.setTotSteh(EExStockDeadwoodBO._0);
    Assert.assertFalse(x.setTotStehBesch("foo").isChanged());
    x.setTotLieg(EExStockDeadwoodBO._0);
    Assert.assertFalse(x.setTotLiegBesch("foo").isChanged());
  }
}
