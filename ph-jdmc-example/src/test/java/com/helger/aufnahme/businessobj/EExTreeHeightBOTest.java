package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExTreeHeightBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExTreeHeightBOTest {

  @Test
  public void testBasic() {
    for (final EExTreeHeightBO e: EExTreeHeightBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExTreeHeightBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExTreeHeightBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExTreeHeightBO.getFromIDOrThrow(e.getID()));
    }
  }
}
