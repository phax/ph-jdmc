package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExposition}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExpositionTest {

  @Test
  public void testBasic() {
    for (final EExposition e: EExposition.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExposition.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExposition.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExposition.getFromIDOrThrow(e.getID()));
    }
  }
}
