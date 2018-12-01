package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEUsagePeriodBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEUsagePeriodBOTest {

  @Test
  public void testBasic() {
    for (final ExEUsagePeriodBO e: ExEUsagePeriodBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEUsagePeriodBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEUsagePeriodBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEUsagePeriodBO.getFromIDOrThrow(e.getID()));
    }
  }
}
