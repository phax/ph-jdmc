package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEStockDeadwoodBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEStockDeadwoodBOTest {

  @Test
  public void testBasic() {
    for (final ExEStockDeadwoodBO e: ExEStockDeadwoodBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEStockDeadwoodBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEStockDeadwoodBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEStockDeadwoodBO.getFromIDOrThrow(e.getID()));
    }
  }
}
