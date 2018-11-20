package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.EDecompositionDegreeClass}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class EDecompositionDegreeClassTest {

  @Test
  public void testBasic() {
    for (final EDecompositionDegreeClass e: EDecompositionDegreeClass.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, EDecompositionDegreeClass.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, EDecompositionDegreeClass.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, EDecompositionDegreeClass.getFromIDOrThrow(e.getID()));
    }
  }
}
