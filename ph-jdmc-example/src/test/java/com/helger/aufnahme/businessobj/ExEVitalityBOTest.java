package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEVitalityBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEVitalityBOTest {

  @Test
  public void testBasic() {
    for (final ExEVitalityBO e: ExEVitalityBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEVitalityBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEVitalityBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEVitalityBO.getFromIDOrThrow(e.getID()));
    }
  }
}
