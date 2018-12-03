package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.StichprobeDeadwood}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class StichprobeDeadwoodTest {

  @Test
  public void testDefaultCtor() {
    StichprobeDeadwood x = new StichprobeDeadwood();
    Assert.assertEquals(x, new StichprobeDeadwood());
    Assert.assertNull(x.getDoD());
    Assert.assertNull(x.getTreeKind());
    x.getLength();
    x.getBHD();
  }

  @Test
  public void testSetterAndGetter() {
    StichprobeDeadwood x = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    StichprobeDeadwood y = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    Assert.assertEquals(x, y);
    Assert.assertEquals(x.hashCode(), y.hashCode());
    StichprobeDeadwood z = new StichprobeDeadwood(x);
    Assert.assertTrue(StringHelper.hasText(z.toString()));
    Assert.assertNotSame(x, z);
    Assert.assertEquals(x, z);
    Assert.assertEquals(x.hashCode(), z.hashCode());
    Assert.assertFalse(x.setDoD(EDecompositionDegreeClass.CLASS0).isChanged());
    Assert.assertFalse(x.setTreeKind(ETreeKind.Bergahorn).isChanged());
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
  }
}
