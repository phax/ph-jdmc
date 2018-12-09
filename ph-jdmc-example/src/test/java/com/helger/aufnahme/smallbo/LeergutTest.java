package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.Leergut}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class LeergutTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    Leergut x = new Leergut();
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Leergut y = new Leergut();
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Test all setters
  }
}