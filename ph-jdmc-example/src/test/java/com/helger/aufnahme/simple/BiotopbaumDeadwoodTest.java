package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.BiotopbaumDeadwood}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class BiotopbaumDeadwoodTest {

  @Test
  public void testDefaultCtor() {
    BiotopbaumDeadwood x = new BiotopbaumDeadwood();
    Assert.assertEquals(x, new BiotopbaumDeadwood());
    Assert.assertNull(x.getType());
    x.isEnabled();
    x.getLength();
    x.getBHD();
  }

  @Test
  public void testSetterAndGetter() {
    BiotopbaumDeadwood x = new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    BiotopbaumDeadwood y = new BiotopbaumDeadwood(x);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertFalse(x.setType(EDeadwoodCategory.CLASS1).isChanged());
    Assert.assertFalse(x.setEnabled(true).isChanged());
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
  }
}
