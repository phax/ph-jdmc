package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EStockType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EStockTypeTest {

  @Test
  public void testBasic() {
    for (final EStockType e: EStockType.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EStockType.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EStockType.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EStockType.getFromIDOrThrow(e.getID()));
    }
  }
}
