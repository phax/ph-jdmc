package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExStockTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExStockTypeBOTest {

  @Test
  public void testBasic() {
    for (final EExStockTypeBO e: EExStockTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExStockTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExStockTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExStockTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
