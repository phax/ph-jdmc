package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExExpositionBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExExpositionBOTest {

  @Test
  public void testBasic() {
    for (final EExExpositionBO e: EExExpositionBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExExpositionBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExExpositionBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExExpositionBO.getFromIDOrThrow(e.getID()));
    }
  }
}
