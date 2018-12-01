package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExECaveTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExECaveTypeBOTest {

  @Test
  public void testBasic() {
    for (final ExECaveTypeBO e: ExECaveTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExECaveTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExECaveTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExECaveTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
