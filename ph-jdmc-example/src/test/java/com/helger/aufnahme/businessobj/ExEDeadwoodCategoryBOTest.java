package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEDeadwoodCategoryBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEDeadwoodCategoryBOTest {

  @Test
  public void testBasic() {
    for (final ExEDeadwoodCategoryBO e: ExEDeadwoodCategoryBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEDeadwoodCategoryBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEDeadwoodCategoryBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEDeadwoodCategoryBO.getFromIDOrThrow(e.getID()));
    }
  }
}
