package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
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
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExReservatBO x = new ExReservatBO(8, "foo", 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Assert.assertFalse(x.setRNr(8).isChanged());
    Assert.assertFalse(x.setName("foo").isChanged());
    Assert.assertFalse(x.setAreaSize(8).isChanged());
  }
}
