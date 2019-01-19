package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExDemo2BO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExDemo2BOTest {

  @Test
  public void testBasic() {
    for (final EExDemo2BO e: EExDemo2BO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExDemo2BO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExDemo2BO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExDemo2BO.getFromIDOrThrow(e.getID()));
    }
  }
}
