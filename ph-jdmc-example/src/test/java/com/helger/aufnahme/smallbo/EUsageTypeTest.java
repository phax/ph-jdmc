package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.EUsageType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EUsageTypeTest {

  @Test
  public void testBasic() {
    for (final EUsageType e: EUsageType.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EUsageType.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EUsageType.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EUsageType.getFromIDOrThrow(e.getID()));
    }
  }
}
