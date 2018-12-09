package com.helger.aufnahme.smallbo;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.smallbo.EBiotopbaumType}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EBiotopbaumTypeTest {

  @Test
  public void testBasic() {
    for (final EBiotopbaumType e: EBiotopbaumType.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EBiotopbaumType.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EBiotopbaumType.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EBiotopbaumType.getFromIDOrThrow(e.getID()));
    }
  }
}
