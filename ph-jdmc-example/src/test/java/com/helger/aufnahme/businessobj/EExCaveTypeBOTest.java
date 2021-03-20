package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExCaveTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExCaveTypeBOTest {

  @Test
  public void testBasic() {
    for (final EExCaveTypeBO e: EExCaveTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExCaveTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExCaveTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExCaveTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
