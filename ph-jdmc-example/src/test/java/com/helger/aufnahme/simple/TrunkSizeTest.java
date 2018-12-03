package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.TrunkSize}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class TrunkSizeTest {

  @Test
  public void testDefaultCtor() {
    TrunkSize x = new TrunkSize();
    Assert.assertEquals(x, new TrunkSize());
    x.getBHD();
    Assert.assertNull(x.getHeight());
  }

  @Test
  public void testSetterAndGetter() {
    TrunkSize x = new TrunkSize(8, ETreeHeight.ONE);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    TrunkSize y = new TrunkSize(x);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertFalse(x.setBHD(8).isChanged());
    Assert.assertFalse(x.setHeight(ETreeHeight.ONE).isChanged());
  }
}
