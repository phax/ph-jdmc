package com.helger.aufnahme.small;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.small.EVitality}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EVitalityTest {

  @Test
  public void testBasic() {
    for (final EVitality e: EVitality.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EVitality.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EVitality.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EVitality.getFromIDOrThrow(e.getID()));
    }
  }
}
