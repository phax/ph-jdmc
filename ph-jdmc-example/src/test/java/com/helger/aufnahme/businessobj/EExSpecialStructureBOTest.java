package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExSpecialStructureBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExSpecialStructureBOTest {

  @Test
  public void testBasic() {
    for (final EExSpecialStructureBO e: EExSpecialStructureBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExSpecialStructureBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExSpecialStructureBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExSpecialStructureBO.getFromIDOrThrow(e.getID()));
    }
  }
}
