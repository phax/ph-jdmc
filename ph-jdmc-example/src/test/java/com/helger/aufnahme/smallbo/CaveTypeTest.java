package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.CaveType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class CaveTypeTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    CaveType x = new CaveType(ECaveClass.ONE, ECaveType._1);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    CaveType y = new CaveType(ECaveClass.ONE, ECaveType._1);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Test all setters
    x.setClazz(ECaveClass.ONE);
    x.setType(ECaveType._1);
  }
}
