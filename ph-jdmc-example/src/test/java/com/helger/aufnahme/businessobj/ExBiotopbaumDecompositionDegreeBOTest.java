package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDecompositionDegreeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExBiotopbaumDecompositionDegreeBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExBiotopbaumDecompositionDegreeBO x = new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    x.setType(EExDecompositionDegreeClassBO.CLASS0);
    Assert.assertFalse(x.setEnabled(true).isChanged());
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
  }
}
