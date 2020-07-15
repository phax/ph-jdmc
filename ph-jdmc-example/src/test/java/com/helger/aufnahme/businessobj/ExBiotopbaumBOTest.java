/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.aufnahme.businessobj;

import java.io.File;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.string.StringHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import com.helger.xml.mock.XMLTestHelper;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

/**
 * This is the test class for class
 * {@link com.helger.aufnahme.businessobj.ExBiotopbaumBO} This class was
 * initially automatically created
 * 
 * @author JDMCodeGenerator
 */
public final class ExBiotopbaumBOTest
{
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule ();

  @Test
  public void testSetterAndGetter ()
  {
    ExBiotopbaumBO x = new ExBiotopbaumBO (8,
                                           new CommonsArrayList <> (new File ("file.txt")),
                                           PDTFactory.getCurrentLocalDate (),
                                           new CommonsArrayList <> (EExBiotopbaumTypeBO.TOTHOLZ),
                                           "foo",
                                           EExExpositionBO.N,
                                           "foo",
                                           true,
                                           true,
                                           true,
                                           true,
                                           true,
                                           true,
                                           true,
                                           "foo",
                                           EExTreeKindBO.Bergahorn,
                                           new CommonsArrayList <> (new ExCaveTypeBO (EExCaveClassBO.ONE, EExCaveTypeBO._1)),
                                           new CommonsArrayList <> (new ExTrunkSizeBO (8, EExTreeHeightBO.ONE)),
                                           EExVitalityBO.ONE,
                                           new CommonsArrayList <> (EExSpecialStructureBO._1),
                                           "foo",
                                           true,
                                           "foo",
                                           true,
                                           "foo",
                                           new CommonsArrayList <> (new ExBiotopbaumDeadwoodBO (EExDeadwoodCategoryBO.CLASS1, true, 8, 8)),
                                           new CommonsArrayList <> (new ExBiotopbaumDecompositionDegreeBO (EExDecompositionDegreeClassBO.CLASS0,
                                                                                                           true,
                                                                                                           8,
                                                                                                           8)));
    Assert.assertTrue (StringHelper.hasText (x.toString ()));
    ExBiotopbaumBO y = new ExBiotopbaumBO (8,
                                           new CommonsArrayList <> (new File ("file.txt")),
                                           PDTFactory.getCurrentLocalDate (),
                                           new CommonsArrayList <> (EExBiotopbaumTypeBO.TOTHOLZ),
                                           "foo",
                                           EExExpositionBO.N,
                                           "foo",
                                           true,
                                           true,
                                           true,
                                           true,
                                           true,
                                           true,
                                           true,
                                           "foo",
                                           EExTreeKindBO.Bergahorn,
                                           new CommonsArrayList <> (new ExCaveTypeBO (EExCaveClassBO.ONE, EExCaveTypeBO._1)),
                                           new CommonsArrayList <> (new ExTrunkSizeBO (8, EExTreeHeightBO.ONE)),
                                           EExVitalityBO.ONE,
                                           new CommonsArrayList <> (EExSpecialStructureBO._1),
                                           "foo",
                                           true,
                                           "foo",
                                           true,
                                           "foo",
                                           new CommonsArrayList <> (new ExBiotopbaumDeadwoodBO (EExDeadwoodCategoryBO.CLASS1, true, 8, 8)),
                                           new CommonsArrayList <> (new ExBiotopbaumDecompositionDegreeBO (EExDecompositionDegreeClassBO.CLASS0,
                                                                                                           true,
                                                                                                           8,
                                                                                                           8)));
    Assert.assertTrue (StringHelper.hasText (y.toString ()));
    Assert.assertNotSame (x, y);
    // Objects are not equal, because they have different IDs
    // Test all setters
    Assert.assertFalse (x.setBBNr (8).isChanged ());
    Assert.assertFalse (x.setPics (new CommonsArrayList <> (new File ("file.txt"))).isChanged ());
    Assert.assertFalse (x.setDate (PDTFactory.getCurrentLocalDate ()).isChanged ());
    x.setType (new CommonsArrayList <> (EExBiotopbaumTypeBO.TOTHOLZ));
    Assert.assertFalse (x.setLocation ("foo").isChanged ());
    x.setExposition (EExExpositionBO.N);
    Assert.assertFalse (x.setHanglage ("foo").isChanged ());
    Assert.assertFalse (x.setEinschichtig (true).isChanged ());
    Assert.assertFalse (x.setSolitary (true).isChanged ());
    Assert.assertFalse (x.setLightLocation (true).isChanged ());
    Assert.assertFalse (x.setClosedCrown (true).isChanged ());
    Assert.assertFalse (x.setNoSun (true).isChanged ());
    Assert.assertFalse (x.setUeberSun (true).isChanged ());
    Assert.assertFalse (x.setHomogene (true).isChanged ());
    Assert.assertFalse (x.setBeschreibung ("foo").isChanged ());
    x.setTreeKind (EExTreeKindBO.Bergahorn);
    x.setCaves (new CommonsArrayList <> (new ExCaveTypeBO (EExCaveClassBO.ONE, EExCaveTypeBO._1)));
    x.setTrunk (new CommonsArrayList <> (new ExTrunkSizeBO (8, EExTreeHeightBO.ONE)));
    x.setVitality (EExVitalityBO.ONE);
    x.setSpecialStructure (new CommonsArrayList <> (EExSpecialStructureBO._1));
    Assert.assertFalse (x.setOtherSpecial ("foo").isChanged ());
    Assert.assertFalse (x.setAspirant (true).isChanged ());
    Assert.assertFalse (x.setAspirantDesc ("foo").isChanged ());
    Assert.assertFalse (x.setMarked (true).isChanged ());
    Assert.assertFalse (x.setMarkedDesc ("foo").isChanged ());
    x.setDeadwoodCats (new CommonsArrayList <> (new ExBiotopbaumDeadwoodBO (EExDeadwoodCategoryBO.CLASS1, true, 8, 8)));
    x.setDeadwoodDoD (new CommonsArrayList <> (new ExBiotopbaumDecompositionDegreeBO (EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)));
    // Check XML conversion
    XMLTestHelper.testMicroTypeConversion (x);
    // Test setters with null
    Assert.assertTrue (x.setLocation (null).isChanged ());
    Assert.assertTrue (x.setHanglage (null).isChanged ());
    Assert.assertTrue (x.setOtherSpecial (null).isChanged ());
    Assert.assertTrue (x.setAspirantDesc (null).isChanged ());
    Assert.assertTrue (x.setMarkedDesc (null).isChanged ());
    // Check XML conversion again
    XMLTestHelper.testMicroTypeConversion (x);
  }
}
