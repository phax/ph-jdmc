package com.helger.aufnahme.simple;

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.Habitatbaumgruppe}
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
    Assert.assertNotNull(x.hBGzBB());
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
    Habitatbaumgruppe x = new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum()), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo");
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Habitatbaumgruppe y = new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum()), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo");
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    Habitatbaumgruppe z = new Habitatbaumgruppe(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    Assert.assertFalse(x.setHBGNr(8).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setHBGzBB(new CommonsArrayList<>(new Biotopbaum())).isChanged());
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
  }
}
