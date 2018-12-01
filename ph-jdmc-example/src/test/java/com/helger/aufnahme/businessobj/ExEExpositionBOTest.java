package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEExpositionBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEExpositionBOTest {

  @Test
  public void testBasic() {
    for (final ExEExpositionBO e: ExEExpositionBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEExpositionBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEExpositionBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEExpositionBO.getFromIDOrThrow(e.getID()));
    }
  }
}
