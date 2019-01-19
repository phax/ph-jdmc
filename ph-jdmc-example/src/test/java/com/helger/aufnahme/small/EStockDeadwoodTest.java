package com.helger.aufnahme.small;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.EStockDeadwood}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EStockDeadwoodTest {

  @Test
  public void testBasic() {
    for (final EStockDeadwood e: EStockDeadwood.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EStockDeadwood.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EStockDeadwood.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EStockDeadwood.getFromIDOrThrow(e.getID()));
    }
  }
}
