package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExTreeKindBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExTreeKindBOTest {

  @Test
  public void testBasic() {
    for (final EExTreeKindBO e: EExTreeKindBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExTreeKindBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExTreeKindBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExTreeKindBO.getFromIDOrThrow(e.getID()));
    }
  }
}
