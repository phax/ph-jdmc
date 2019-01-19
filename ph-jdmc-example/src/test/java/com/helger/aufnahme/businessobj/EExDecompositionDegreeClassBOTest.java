package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EExDecompositionDegreeClassBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EExDecompositionDegreeClassBOTest {

  @Test
  public void testBasic() {
    for (final EExDecompositionDegreeClassBO e: EExDecompositionDegreeClassBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EExDecompositionDegreeClassBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EExDecompositionDegreeClassBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EExDecompositionDegreeClassBO.getFromIDOrThrow(e.getID()));
    }
  }
}
