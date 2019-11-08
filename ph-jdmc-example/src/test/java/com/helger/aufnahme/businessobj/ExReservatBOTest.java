package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import com.helger.xml.mock.XMLTestHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExReservatBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExReservatBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExReservatBO x = new ExReservatBO(8, "foo", 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    ExReservatBO y = new ExReservatBO(8, "foo", 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse(x.setRNr(8).isChanged());
    Assert.assertFalse(x.setName("foo").isChanged());
    Assert.assertFalse(x.setAreaSize(8).isChanged());
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion(x);
  }
}
