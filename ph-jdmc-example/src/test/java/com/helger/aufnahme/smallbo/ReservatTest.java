package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.Reservat}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ReservatTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    Reservat x = new Reservat(8, "foo", 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Reservat y = new Reservat(8, "foo", 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse(x.setRNr(8).isChanged());
    Assert.assertFalse(x.setName("foo").isChanged());
    Assert.assertFalse(x.setAreaSize(8).isChanged());
  }
}
