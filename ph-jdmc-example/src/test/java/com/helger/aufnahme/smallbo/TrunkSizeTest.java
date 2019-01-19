package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.TrunkSize}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class TrunkSizeTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    TrunkSize x = new TrunkSize(8, ETreeHeight.ONE);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    TrunkSize y = new TrunkSize(8, ETreeHeight.ONE);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse(x.setBHD(8).isChanged());
    x.setHeight(ETreeHeight.ONE);
  }
}
