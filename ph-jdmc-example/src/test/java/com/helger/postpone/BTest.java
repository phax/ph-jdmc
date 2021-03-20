package com.helger.postpone;

import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.postpone.B}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class BTest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

  @Test
  public void testSetterAndGetter() {
    B x = new B(new C(EE.ONE));
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    B y = new B(new C(EE.ONE));
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    x.setC(new C(EE.ONE));
  }
}
