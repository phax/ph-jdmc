package com.helger.postpone;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.postpone.EE}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EETest {

  @Test
  public void testBasic() {
    for (final EE e: EE.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EE.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EE.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EE.getFromIDOrThrow(e.getID()));
    }
  }
}
