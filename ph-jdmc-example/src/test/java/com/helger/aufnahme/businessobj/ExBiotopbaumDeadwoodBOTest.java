package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDeadwoodBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExBiotopbaumDeadwoodBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExBiotopbaumDeadwoodBO x = new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    ExBiotopbaumDeadwoodBO y = new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    x.setType(EExDeadwoodCategoryBO.CLASS1);
    Assert.assertFalse(x.setEnabled(true).isChanged());
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
  }
}
