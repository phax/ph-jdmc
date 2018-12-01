package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEBiotopbaumTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEBiotopbaumTypeBOTest {

  @Test
  public void testBasic() {
    for (final ExEBiotopbaumTypeBO e: ExEBiotopbaumTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEBiotopbaumTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEBiotopbaumTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEBiotopbaumTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
