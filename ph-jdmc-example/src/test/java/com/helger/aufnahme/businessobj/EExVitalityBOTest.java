package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExVitalityBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExVitalityBOTest {

  @Test
  public void testBasic() {
    for (final EExVitalityBO e: EExVitalityBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExVitalityBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExVitalityBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExVitalityBO.getFromIDOrThrow(e.getID()));
    }
  }
}
