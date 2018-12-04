package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import com.helger.xml.mock.XMLTestHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExCaveTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExCaveTypeBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExCaveTypeBO x = new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    ExCaveTypeBO y = new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Test all setters
    x.setClazz(EExCaveClassBO.ONE);
    x.setType(EExCaveTypeBO._1);
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion(x);
  }
}
