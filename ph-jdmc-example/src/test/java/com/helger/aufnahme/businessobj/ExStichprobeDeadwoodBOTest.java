package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import com.helger.xml.mock.XMLTestHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExStichprobeDeadwoodBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExStichprobeDeadwoodBOTest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

  @Test
  public void testSetterAndGetter() {
    ExStichprobeDeadwoodBO x = new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    ExStichprobeDeadwoodBO y = new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    x.setDoD(EExDecompositionDegreeClassBO.CLASS0);
    x.setTreeKind(EExTreeKindBO.Bergahorn);
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion(x);
  }
}
