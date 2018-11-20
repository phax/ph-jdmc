package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ETreeHeight}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ETreeHeightTest {

  @Test
  public void testBasic() {
    for (final ETreeHeight e: ETreeHeight.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ETreeHeight.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ETreeHeight.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ETreeHeight.getFromIDOrThrow(e.getID()));
    }
  }
}
