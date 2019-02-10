package com.helger.selfref;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.selfref.SelfRefDemo1}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class SelfRefDemo1Test {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    SelfRefDemo1 x = new SelfRefDemo1(new SelfRefDemo1(null));
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    SelfRefDemo1 y = new SelfRefDemo1(new SelfRefDemo1(null));
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    x.setDummy1(new SelfRefDemo1(null));
    // Test setters with null
    Assert.assertTrue(x.setDummy1(null).isChanged());
  }
}
