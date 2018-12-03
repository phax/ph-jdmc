package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExLeergutBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExLeergutBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExLeergutBO x = new ExLeergutBO();
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    ExLeergutBO y = new ExLeergutBO();
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
  }
}
