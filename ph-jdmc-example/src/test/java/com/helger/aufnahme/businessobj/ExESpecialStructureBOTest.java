package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExESpecialStructureBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExESpecialStructureBOTest {

  @Test
  public void testBasic() {
    for (final ExESpecialStructureBO e: ExESpecialStructureBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExESpecialStructureBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExESpecialStructureBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExESpecialStructureBO.getFromIDOrThrow(e.getID()));
    }
  }
}
