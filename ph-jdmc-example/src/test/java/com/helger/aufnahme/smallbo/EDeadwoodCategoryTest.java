package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.EDeadwoodCategory}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EDeadwoodCategoryTest {

  @Test
  public void testBasic() {
    for (final EDeadwoodCategory e: EDeadwoodCategory.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EDeadwoodCategory.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EDeadwoodCategory.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EDeadwoodCategory.getFromIDOrThrow(e.getID()));
    }
  }
}
