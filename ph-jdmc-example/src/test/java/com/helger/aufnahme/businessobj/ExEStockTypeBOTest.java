package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEStockTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEStockTypeBOTest {

  @Test
  public void testBasic() {
    for (final ExEStockTypeBO e: ExEStockTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEStockTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEStockTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEStockTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
