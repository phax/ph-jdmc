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
 * This is the test class for class {@link com.helger.aufnahme.smallbo.Bestand}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class BestandTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    Bestand x = new Bestand(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo")), 8, "foo", true, true, EStockType._0, "foo", "foo", true, true, true, EStockDeadwood._0, "foo", EStockDeadwood._0, "foo");
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Bestand y = new Bestand(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo")), 8, "foo", true, true, EStockType._0, "foo", "foo", true, true, true, EStockDeadwood._0, "foo", EStockDeadwood._0, "foo");
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse(x.setBNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setVerortung("foo").isChanged());
    x.setBZHBG(new CommonsArrayList<>(new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo")));
    Assert.assertFalse(x.setAreaSize(8).isChanged());
    Assert.assertFalse(x.setBeschreib("foo").isChanged());
    Assert.assertFalse(x.setSameAge(true).isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    x.setStockType(EStockType._0);
    Assert.assertFalse(x.setUsageDescription("foo").isChanged());
    Assert.assertFalse(x.setGesellschaft("foo").isChanged());
    Assert.assertFalse(x.setKronenschluss(true).isChanged());
    Assert.assertFalse(x.setLightWoods(true).isChanged());
    Assert.assertFalse(x.setUnterwuchs(true).isChanged());
    x.setTotSteh(EStockDeadwood._0);
    Assert.assertFalse(x.setTotStehBesch("foo").isChanged());
    x.setTotLieg(EStockDeadwood._0);
    Assert.assertFalse(x.setTotLiegBesch("foo").isChanged());
    // Test setters with null
    Assert.assertTrue(x.setVerortung(null).isChanged());
  }
}
