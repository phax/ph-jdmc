package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.Leergut}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class LeergutTest {

  @Test
  public void testDefaultCtor() {
    Leergut x = new Leergut();
    Assert.assertEquals(x, new Leergut());
  }

  @Test
  public void testSetterAndGetter() {
    Leergut x = new Leergut();
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Leergut y = new Leergut();
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
  }
}
