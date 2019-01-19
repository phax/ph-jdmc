package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.EDemo2}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EDemo2Test {

  @Test
  public void testBasic() {
    for (final EDemo2 e: EDemo2 .values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EDemo2 .getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EDemo2 .getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EDemo2 .getFromIDOrThrow(e.getID()));
    }
  }
}
