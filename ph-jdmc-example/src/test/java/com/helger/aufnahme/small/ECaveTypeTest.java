package com.helger.aufnahme.small;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.ECaveType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ECaveTypeTest {

  @Test
  public void testBasic() {
    for (final ECaveType e: ECaveType.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ECaveType.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ECaveType.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ECaveType.getFromIDOrThrow(e.getID()));
    }
  }
}
