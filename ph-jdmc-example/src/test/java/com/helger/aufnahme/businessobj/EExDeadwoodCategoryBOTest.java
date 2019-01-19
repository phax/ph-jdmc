package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExDeadwoodCategoryBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExDeadwoodCategoryBOTest {

  @Test
  public void testBasic() {
    for (final EExDeadwoodCategoryBO e: EExDeadwoodCategoryBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExDeadwoodCategoryBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExDeadwoodCategoryBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExDeadwoodCategoryBO.getFromIDOrThrow(e.getID()));
    }
  }
}
