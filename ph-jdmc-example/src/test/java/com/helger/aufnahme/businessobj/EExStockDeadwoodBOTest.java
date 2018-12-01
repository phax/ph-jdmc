package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExStockDeadwoodBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExStockDeadwoodBOTest {

  @Test
  public void testBasic() {
    for (final EExStockDeadwoodBO e: EExStockDeadwoodBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExStockDeadwoodBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExStockDeadwoodBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExStockDeadwoodBO.getFromIDOrThrow(e.getID()));
    }
  }
}
