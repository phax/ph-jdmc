package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExCaveClassBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExCaveClassBOTest {

  @Test
  public void testBasic() {
    for (final EExCaveClassBO e: EExCaveClassBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExCaveClassBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExCaveClassBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExCaveClassBO.getFromIDOrThrow(e.getID()));
    }
  }
}
