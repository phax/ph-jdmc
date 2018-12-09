package com.helger.aufnahme.small;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.EUsagePeriod}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EUsagePeriodTest {

  @Test
  public void testBasic() {
    for (final EUsagePeriod e: EUsagePeriod.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EUsagePeriod.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EUsagePeriod.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EUsagePeriod.getFromIDOrThrow(e.getID()));
    }
  }
}
