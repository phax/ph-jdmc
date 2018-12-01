package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExECaveClassBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExECaveClassBOTest {

  @Test
  public void testBasic() {
    for (final ExECaveClassBO e: ExECaveClassBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExECaveClassBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExECaveClassBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExECaveClassBO.getFromIDOrThrow(e.getID()));
    }
  }
}
