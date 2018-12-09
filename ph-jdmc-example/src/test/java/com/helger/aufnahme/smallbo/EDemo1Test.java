package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.EDemo1}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EDemo1Test {

  @Test
  public void testBasic() {
    for (final EDemo1 e: EDemo1 .values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EDemo1 .getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EDemo1 .getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EDemo1 .getFromIDOrThrow(e.getID()));
    }
  }
}
