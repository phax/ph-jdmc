package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExETreeHeightBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExETreeHeightBOTest {

  @Test
  public void testBasic() {
    for (final ExETreeHeightBO e: ExETreeHeightBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExETreeHeightBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExETreeHeightBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExETreeHeightBO.getFromIDOrThrow(e.getID()));
    }
  }
}
