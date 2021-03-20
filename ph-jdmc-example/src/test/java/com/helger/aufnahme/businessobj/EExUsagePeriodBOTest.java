package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExUsagePeriodBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExUsagePeriodBOTest {

  @Test
  public void testBasic() {
    for (final EExUsagePeriodBO e: EExUsagePeriodBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExUsagePeriodBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExUsagePeriodBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExUsagePeriodBO.getFromIDOrThrow(e.getID()));
    }
  }
}
