package com.helger.aufnahme.businessobj;

import com.helger.commons.string.StringHelper;
import org.junit.Assert;
import org.junit.Test;


/**
 * This is the test class for class {@link com.helger.aufnahme.businessobj.ExETreeKindBO}
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class ExETreeKindBOTest {

  @Test
  public void testBasic() {
    for (final ExETreeKindBO e: ExETreeKindBO.values()) {
      Assert.assertTrue(StringHelper.hasText(e.getID()));
      Assert.assertTrue(StringHelper.hasText(e.getDisplayName()));
      Assert.assertSame(e, ExETreeKindBO.getFromIDOrNull(e.getID()));
      Assert.assertSame(e, ExETreeKindBO.getFromIDOrDefault(e.getID(), null));
      Assert.assertSame(e, ExETreeKindBO.getFromIDOrThrow(e.getID()));
    }
  }
}
