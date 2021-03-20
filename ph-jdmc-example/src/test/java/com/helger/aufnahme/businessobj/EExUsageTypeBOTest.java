package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExUsageTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExUsageTypeBOTest {

  @Test
  public void testBasic() {
    for (final EExUsageTypeBO e: EExUsageTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExUsageTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExUsageTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExUsageTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
