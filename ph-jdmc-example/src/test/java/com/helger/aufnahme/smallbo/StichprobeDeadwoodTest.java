package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.StichprobeDeadwood}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class StichprobeDeadwoodTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  public void testSetterAndGetter() {
    StichprobeDeadwood x = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(x.toString()));
    StichprobeDeadwood y = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    Assert.assertTrue(StringHelper.hasText(y.toString()));
    Assert.assertNotSame(x, y);
    // Test all setters
    x.setDoD(EDecompositionDegreeClass.CLASS0);
    x.setTreeKind(ETreeKind.Bergahorn);
    Assert.assertFalse(x.setLength(8).isChanged());
    Assert.assertFalse(x.setBHD(8).isChanged());
  }
}
