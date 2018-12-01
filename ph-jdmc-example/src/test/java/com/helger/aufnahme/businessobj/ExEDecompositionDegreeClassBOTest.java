package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExEDecompositionDegreeClassBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExEDecompositionDegreeClassBOTest {

  @Test
  public void testBasic() {
    for (final ExEDecompositionDegreeClassBO e: ExEDecompositionDegreeClassBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExEDecompositionDegreeClassBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExEDecompositionDegreeClassBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExEDecompositionDegreeClassBO.getFromIDOrThrow(e.getID()));
    }
  }
}
