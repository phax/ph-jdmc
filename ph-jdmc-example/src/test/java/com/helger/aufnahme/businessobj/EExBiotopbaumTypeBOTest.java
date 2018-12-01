package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExBiotopbaumTypeBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExBiotopbaumTypeBOTest {

  @Test
  public void testBasic() {
    for (final EExBiotopbaumTypeBO e: EExBiotopbaumTypeBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExBiotopbaumTypeBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExBiotopbaumTypeBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExBiotopbaumTypeBO.getFromIDOrThrow(e.getID()));
    }
  }
}
