package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.BiotopbaumDecompositionDegree}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class BiotopbaumDecompositionDegreeTest {

  @Test
  public void testDefaultCtor() {
    BiotopbaumDecompositionDegree x = new BiotopbaumDecompositionDegree();
    Assert.assertEquals(x, new BiotopbaumDecompositionDegree());
    Assert.assertNull(x.getType());
    x.isEnabled();
    x.getLength();
    x.getBHD();
  }

  @Test
  public void testSetterAndGetter() {
    BiotopbaumDecompositionDegree x = new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    BiotopbaumDecompositionDegree y = new BiotopbaumDecompositionDegree(x);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertFalse(x.setType(EDecompositionDegreeClass.CLASS0).isChanged());
    Assert.assertFalse(x.setEnabled(true).isChanged());
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
  }
}
