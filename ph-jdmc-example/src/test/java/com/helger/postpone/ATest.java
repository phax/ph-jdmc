package com.helger.postpone;

import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.postpone.A}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ATest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

  @Test
  public void testSetterAndGetter() {
    A x = new A(new B(new C(EE.ONE)));
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    A y = new A(new B(new C(EE.ONE)));
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    x.setB(new B(new C(EE.ONE)));
  }
}
