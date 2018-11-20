package com.helger.aufnahme.simple;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.simple.ETreeKind}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ETreeKindTest {

  @Test
  public void testBasic() {
    for (final ETreeKind e: ETreeKind.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ETreeKind.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ETreeKind.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ETreeKind.getFromIDOrThrow(e.getID()));
    }
  }
}
