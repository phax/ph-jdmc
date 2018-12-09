package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExDemo1BO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExDemo1BOTest {

  @Test
  public void testBasic() {
    for (final EExDemo1BO e: EExDemo1BO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExDemo1BO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExDemo1BO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExDemo1BO.getFromIDOrThrow(e.getID()));
    }
  }
}
