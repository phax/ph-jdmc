package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEUsageTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEUsageTypeBOTest {

  @Test
  public void testBasic() {
    for (final ExEUsageTypeBO e: ExEUsageTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEUsageTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEUsageTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEUsageTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
