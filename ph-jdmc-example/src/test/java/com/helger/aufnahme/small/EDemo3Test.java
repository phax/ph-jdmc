package com.helger.aufnahme.small;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.EDemo3}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EDemo3Test {

  @Test
  public void testBasic() {
    for (final EDemo3 e: EDemo3 .values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EDemo3 .getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EDemo3 .getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EDemo3 .getFromIDOrThrow(e.getID()));
    }
  }
}
