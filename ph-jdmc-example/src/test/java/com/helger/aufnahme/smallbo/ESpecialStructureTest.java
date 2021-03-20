package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.ESpecialStructure}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ESpecialStructureTest {

  @Test
  public void testBasic() {
    for (final ESpecialStructure e: ESpecialStructure.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ESpecialStructure.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ESpecialStructure.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ESpecialStructure.getFromIDOrThrow(e.getID()));
    }
  }
}
