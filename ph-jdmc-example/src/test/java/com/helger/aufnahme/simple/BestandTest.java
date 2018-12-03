package com.helger.aufnahme.simple;

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.Bestand}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class BestandTest {

  @Test
  public void testDefaultCtor() {
    Bestand x = new Bestand();
    Assert.assertEquals(x, new Bestand());
    x.getBNr();
    Assert.assertNotNull(x.pics());
    Assert.assertNull(x.getDate());
    Assert.assertNull(x.getVerortung());
    Assert.assertNotNull(x.bZHBG());
    x.getAreaSize();
    Assert.assertNull(x.getBeschreib());
    x.isSameAge();
    x.isOneLevel();
    Assert.assertNull(x.getStockType());
    Assert.assertNull(x.getUsageDescription());
    Assert.assertNull(x.getGesellschaft());
    x.isKronenschluss();
    x.isLightWoods();
    x.isUnterwuchs();
    Assert.assertNull(x.getTotSteh());
    Assert.assertNull(x.getTotStehBesch());
    Assert.assertNull(x.getTotLieg());
    Assert.assertNull(x.getTotLiegBesch());
  }

  @Test
  public void testSetterAndGetter() {
    Bestand x = new Bestand(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new Habitatbaumgruppe()), 8, "foo", true, true, EStockType._0, "foo", "foo", true, true, true, EStockDeadwood._0, "foo", EStockDeadwood._0, "foo");
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Bestand y = new Bestand(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new Habitatbaumgruppe()), 8, "foo", true, true, EStockType._0, "foo", "foo", true, true, true, EStockDeadwood._0, "foo", EStockDeadwood._0, "foo");
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    Bestand z = new Bestand(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    Assert.assertFalse(x.setBNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setVerortung("foo").isChanged());
    Assert.assertFalse(x.setBZHBG(new CommonsArrayList<>(new Habitatbaumgruppe())).isChanged());
    Assert.assertFalse(x.setAreaSize(8).isChanged());
    Assert.assertFalse(x.setBeschreib("foo").isChanged());
    Assert.assertFalse(x.setSameAge(true).isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    Assert.assertFalse(x.setStockType(EStockType._0).isChanged());
    Assert.assertFalse(x.setUsageDescription("foo").isChanged());
    Assert.assertFalse(x.setGesellschaft("foo").isChanged());
    Assert.assertFalse(x.setKronenschluss(true).isChanged());
    Assert.assertFalse(x.setLightWoods(true).isChanged());
    Assert.assertFalse(x.setUnterwuchs(true).isChanged());
    Assert.assertFalse(x.setTotSteh(EStockDeadwood._0).isChanged());
    Assert.assertFalse(x.setTotStehBesch("foo").isChanged());
    Assert.assertFalse(x.setTotLieg(EStockDeadwood._0).isChanged());
    Assert.assertFalse(x.setTotLiegBesch("foo").isChanged());
  }
}
