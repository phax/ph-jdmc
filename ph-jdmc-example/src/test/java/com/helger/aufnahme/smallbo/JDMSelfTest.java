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
package com.helger.aufnahme.smallbo;

import java.io.File;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.Period;
import java.time.ZonedDateTime;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.math.MathHelper;
import com.helger.photon.basic.mock.PhotonBasicWebTestRule;
import com.helger.xml.serialize.read.DOMReader;
import javax.xml.namespace.QName;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.w3c.dom.Element;


/**
 * This is the self-test class of JDM
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class JDMSelfTest {
  @Rule
  public final TestRule m_aRule = new PhotonBasicWebTestRule();

  @Test
  @SuppressWarnings({
    "unused",
    "cast"
  })
  public void testMockValueCreation() {
    IBestand var0;
    var0 = new Bestand(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo")), 8, "foo", true, true, EStockType._0, EStockType._0, "foo", "foo", true, true, true, EStockDeadwood._0, "foo", EStockDeadwood._0, "foo");
    BigDecimal var1;
    var1 = MathHelper.toBigDecimal("12.3456");
    Assert.assertNotNull(var1);
    BigInteger var2;
    var2 = MathHelper.toBigInteger("7890");
    Assert.assertNotNull(var2);
    IBiotopbaum var3;
    var3 = new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)));
    IBiotopbaumDeadwood var4;
    var4 = new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8);
    IBiotopbaumDecompositionDegree var5;
    var5 = new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8);
    Boolean var6;
    var6 = Boolean.TRUE;
    Assert.assertNotNull(var6);
    boolean var7;
    var7 = true;
    byte var8;
    var8 = 2;
    Byte var9;
    var9 = Byte.valueOf(((byte) 1));
    Assert.assertNotNull(var9);
    ICaveType var10;
    var10 = new CaveType(ECaveClass.ONE, ECaveType._1);
    Character var11;
    var11 = Character.valueOf(' ');
    Assert.assertNotNull(var11);
    char var12;
    var12 = 'x';
    double var13;
    var13 = 4.0;
    Double var14;
    var14 = Double.valueOf(3.0);
    Assert.assertNotNull(var14);
    Duration var15;
    var15 = Duration.ofDays(1L);
    Assert.assertNotNull(var15);
    EBiotopbaumType var16;
    var16 = EBiotopbaumType.TOTHOLZ;
    Assert.assertNotNull(var16);
    ECaveClass var17;
    var17 = ECaveClass.ONE;
    Assert.assertNotNull(var17);
    ECaveType var18;
    var18 = ECaveType._1;
    Assert.assertNotNull(var18);
    EDeadwoodCategory var19;
    var19 = EDeadwoodCategory.CLASS1;
    Assert.assertNotNull(var19);
    EDecompositionDegreeClass var20;
    var20 = EDecompositionDegreeClass.CLASS0;
    Assert.assertNotNull(var20);
    EDemo1 var21;
    var21 = EDemo1 .RED;
    Assert.assertNotNull(var21);
    EDemo2 var22;
    var22 = EDemo2 .ALPHA;
    Assert.assertNotNull(var22);
    EExposition var23;
    var23 = EExposition.N;
    Assert.assertNotNull(var23);
    ESpecialStructure var24;
    var24 = ESpecialStructure._1;
    Assert.assertNotNull(var24);
    EStockDeadwood var25;
    var25 = EStockDeadwood._0;
    Assert.assertNotNull(var25);
    EStockType var26;
    var26 = EStockType._0;
    Assert.assertNotNull(var26);
    ETreeHeight var27;
    var27 = ETreeHeight.ONE;
    Assert.assertNotNull(var27);
    ETreeKind var28;
    var28 = ETreeKind.Bergahorn;
    Assert.assertNotNull(var28);
    EUsagePeriod var29;
    var29 = EUsagePeriod.NONE;
    Assert.assertNotNull(var29);
    EUsageType var30;
    var30 = EUsageType.Hochwald;
    Assert.assertNotNull(var30);
    EVitality var31;
    var31 = EVitality.ONE;
    Assert.assertNotNull(var31);
    Element var32;
    var32 = DOMReader.readXMLDOM("<item x='y'/>").getDocumentElement();
    Assert.assertNotNull(var32);
    File var33;
    var33 = new File("file.txt");
    Assert.assertNotNull(var33);
    float var34;
    var34 = 6.0F;
    Float var35;
    var35 = Float.valueOf(5.0F);
    Assert.assertNotNull(var35);
    IHabitatbaumgruppe var36;
    var36 = new Habitatbaumgruppe(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExposition.N, "foo", 8, true, "foo");
    int var37;
    var37 = 8;
    Integer var38;
    var38 = Integer.valueOf(7);
    Assert.assertNotNull(var38);
    ILeergut var39;
    var39 = new Leergut();
    LocalDate var40;
    var40 = PDTFactory.getCurrentLocalDate();
    Assert.assertNotNull(var40);
    LocalDateTime var41;
    var41 = PDTFactory.getCurrentLocalDateTime();
    Assert.assertNotNull(var41);
    LocalTime var42;
    var42 = PDTFactory.getCurrentLocalTime();
    Assert.assertNotNull(var42);
    Long var43;
    var43 = Long.valueOf(9L);
    Assert.assertNotNull(var43);
    long var44;
    var44 = 10L;
    OffsetDateTime var45;
    var45 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var45);
    Period var46;
    var46 = Period.ofDays(2);
    Assert.assertNotNull(var46);
    QName var47;
    var47 = new QName("urn:example", "elem");
    Assert.assertNotNull(var47);
    IReservat var48;
    var48 = new Reservat(8, "foo", 8);
    Serializable var49;
    var49 = ((Serializable)"object");
    Assert.assertNotNull(var49);
    Short var50;
    var50 = Short.valueOf(((short) 11));
    Assert.assertNotNull(var50);
    short var51;
    var51 = 12;
    IStichprobe var52;
    var52 = new Stichprobe(8, new Reservat(8, "foo", 8), new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), 8, EExposition.N, "foo", "foo", 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, "foo", "foo", new CommonsArrayList<>(new Biotopbaum(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EBiotopbaumType.TOTHOLZ), "foo", EExposition.N, "foo", true, true, true, true, true, true, true, "foo", ETreeKind.Bergahorn, new CommonsArrayList<>(new CaveType(ECaveClass.ONE, ECaveType._1)), new CommonsArrayList<>(new TrunkSize(8, ETreeHeight.ONE)), EVitality.ONE, new CommonsArrayList<>(ESpecialStructure._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new BiotopbaumDeadwood(EDeadwoodCategory.CLASS1, true, 8, 8)), new CommonsArrayList<>(new BiotopbaumDecompositionDegree(EDecompositionDegreeClass.CLASS0, true, 8, 8)))), "foo", true, true, new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)), new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)), new CommonsArrayList<>(new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8)));
    IStichprobeDeadwood var53;
    var53 = new StichprobeDeadwood(EDecompositionDegreeClass.CLASS0, ETreeKind.Bergahorn, 8, 8);
    String var54;
    var54 = "foo";
    Assert.assertNotNull(var54);
    ITrunkSize var55;
    var55 = new TrunkSize(8, ETreeHeight.ONE);
    ZonedDateTime var56;
    var56 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var56);
  }
}
