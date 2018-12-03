package com.helger.aufnahme.simple;

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.Stichprobe}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class StichprobeTest {

  @Test
  public void testDefaultCtor() {
    Stichprobe x = new Stichprobe();
    Assert.assertEquals(x, new Stichprobe());
    x.getStichNr();
    Assert.assertNull(x.getStichNrzR());
    Assert.assertNotNull(x.pics());
    Assert.assertNull(x.getDate());
    x.getSize();
    Assert.assertNull(x.getExposition());
    Assert.assertNull(x.getHanglage());
    Assert.assertNull(x.getGesellschaft());
    x.getBKL0();
    x.getBKL1();
    x.getBKL2();
    x.getBKL3();
    x.getBKL4();
    x.getBKL5();
    x.getBKL6();
    x.getBKL7();
    x.getBKL8();
    x.getBKL9();
    Assert.assertNull(x.getUsage());
    Assert.assertNull(x.getUsageDesc());
    Assert.assertNotNull(x.trees());
    Assert.assertNull(x.getDesc());
    x.isSameAge();
    x.isOneLevel();
    Assert.assertNotNull(x.totSteh());
    Assert.assertNotNull(x.totLieg1());
    Assert.assertNotNull(x.totLieg2());
  }

  @Test
  public void testSetterAndGetter() {
    Stichprobe x = new Stichprobe(8, new Reservat(), new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), 8, EExposition.N, "foo", "foo", 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, "foo", "foo", new CommonsArrayList<>(new Biotopbaum()), "foo", true, true, new CommonsArrayList<>(new StichprobeDeadwood()), new CommonsArrayList<>(new StichprobeDeadwood()), new CommonsArrayList<>(new StichprobeDeadwood()));
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Stichprobe y = new Stichprobe(x);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertFalse(x.setStichNr(8).isChanged());
    Assert.assertFalse(x.setStichNrzR(new Reservat()).isChanged());
    Assert.assertFalse(x.setPics(new CommonsArrayList<>(new File("file.txt"))).isChanged());
    Assert.assertFalse(x.setDate(PDTFactory.getCurrentLocalDate()).isChanged());
    Assert.assertFalse(x.setSize(8).isChanged());
    Assert.assertFalse(x.setExposition(EExposition.N).isChanged());
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
    Assert.assertFalse(x.setTrees(new CommonsArrayList<>(new Biotopbaum())).isChanged());
    Assert.assertFalse(x.setDesc("foo").isChanged());
    Assert.assertFalse(x.setSameAge(true).isChanged());
    Assert.assertFalse(x.setOneLevel(true).isChanged());
    Assert.assertFalse(x.setTotSteh(new CommonsArrayList<>(new StichprobeDeadwood())).isChanged());
    Assert.assertFalse(x.setTotLieg1(new CommonsArrayList<>(new StichprobeDeadwood())).isChanged());
    Assert.assertFalse(x.setTotLieg2(new CommonsArrayList<>(new StichprobeDeadwood())).isChanged());
  }
}
