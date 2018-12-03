package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.Reservat}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ReservatTest {

  @Test
  public void testDefaultCtor() {
    Reservat x = new Reservat();
    Assert.assertEquals(x, new Reservat());
    x.getRNr();
    Assert.assertNull(x.getName());
    x.getAreaSize();
  }

  @Test
  public void testSetterAndGetter() {
    Reservat x = new Reservat(8, "foo", 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Reservat y = new Reservat(x);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertFalse(x.setRNr(8).isChanged());
    Assert.assertFalse(x.setName("foo").isChanged());
    Assert.assertFalse(x.setAreaSize(8).isChanged());
  }
}
