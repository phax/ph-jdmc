package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ECaveClass}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ECaveClassTest {

  @Test
  public void testBasic() {
    for (final ECaveClass e: ECaveClass.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ECaveClass.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ECaveClass.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ECaveClass.getFromIDOrThrow(e.getID()));
    }
  }
}
