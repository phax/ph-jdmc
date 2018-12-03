package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExTrunkSizeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExTrunkSizeBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExTrunkSizeBO x = new ExTrunkSizeBO(8, EExTreeHeightBO.ONE);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    Assert.assertFalse(x.setBHD(8).isChanged());
    x.setHeight(EExTreeHeightBO.ONE);
  }
}
