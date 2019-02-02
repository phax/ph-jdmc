package com.helger.aufnahme.businessobj;

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
    BigDecimal var0;
    var0 = MathHelper.toBigDecimal("12.3456");
    Assert.assertNotNull(var0);
    BigInteger var1;
    var1 = MathHelper.toBigInteger("7890");
    Assert.assertNotNull(var1);
    Boolean var2;
    var2 = Boolean.TRUE;
    Assert.assertNotNull(var2);
    boolean var3;
    var3 = true;
    byte var4;
    var4 = 2;
    Byte var5;
    var5 = Byte.valueOf(((byte) 1));
    Assert.assertNotNull(var5);
    Character var6;
    var6 = Character.valueOf(' ');
    Assert.assertNotNull(var6);
    char var7;
    var7 = 'x';
    double var8;
    var8 = 4.0;
    Double var9;
    var9 = Double.valueOf(3.0);
    Assert.assertNotNull(var9);
    Duration var10;
    var10 = Duration.ofDays(1L);
    Assert.assertNotNull(var10);
    EExBiotopbaumTypeBO var11;
    var11 = EExBiotopbaumTypeBO.TOTHOLZ;
    Assert.assertNotNull(var11);
    EExCaveClassBO var12;
    var12 = EExCaveClassBO.ONE;
    Assert.assertNotNull(var12);
    EExCaveTypeBO var13;
    var13 = EExCaveTypeBO._1;
    Assert.assertNotNull(var13);
    EExDeadwoodCategoryBO var14;
    var14 = EExDeadwoodCategoryBO.CLASS1;
    Assert.assertNotNull(var14);
    EExDecompositionDegreeClassBO var15;
    var15 = EExDecompositionDegreeClassBO.CLASS0;
    Assert.assertNotNull(var15);
    EExDemo1BO var16;
    var16 = EExDemo1BO.RED;
    Assert.assertNotNull(var16);
    EExDemo2BO var17;
    var17 = EExDemo2BO.ALPHA;
    Assert.assertNotNull(var17);
    EExExpositionBO var18;
    var18 = EExExpositionBO.N;
    Assert.assertNotNull(var18);
    EExSpecialStructureBO var19;
    var19 = EExSpecialStructureBO._1;
    Assert.assertNotNull(var19);
    EExStockDeadwoodBO var20;
    var20 = EExStockDeadwoodBO._0;
    Assert.assertNotNull(var20);
    EExStockTypeBO var21;
    var21 = EExStockTypeBO._0;
    Assert.assertNotNull(var21);
    EExTreeHeightBO var22;
    var22 = EExTreeHeightBO.ONE;
    Assert.assertNotNull(var22);
    EExTreeKindBO var23;
    var23 = EExTreeKindBO.Bergahorn;
    Assert.assertNotNull(var23);
    EExUsagePeriodBO var24;
    var24 = EExUsagePeriodBO.NONE;
    Assert.assertNotNull(var24);
    EExUsageTypeBO var25;
    var25 = EExUsageTypeBO.Hochwald;
    Assert.assertNotNull(var25);
    EExVitalityBO var26;
    var26 = EExVitalityBO.ONE;
    Assert.assertNotNull(var26);
    Element var27;
    var27 = DOMReader.readXMLDOM("<item x='y'/>").getDocumentElement();
    Assert.assertNotNull(var27);
    IExBestandBO var28;
    var28 = new ExBestandBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")), 8, 10L, 6.0F, 4.0, "foo", true, true, EExStockTypeBO._0, EExStockTypeBO._0, "foo", "foo", true, true, true, EExStockDeadwoodBO._0, "foo", EExStockDeadwoodBO._0, "foo");
    IExBiotopbaumBO var29;
    var29 = new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)));
    IExBiotopbaumDeadwoodBO var30;
    var30 = new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8);
    IExBiotopbaumDecompositionDegreeBO var31;
    var31 = new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8);
    IExCaveTypeBO var32;
    var32 = new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1);
    IExHabitatbaumgruppeBO var33;
    var33 = new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo");
    IExLeergutBO var34;
    var34 = new ExLeergutBO();
    IExReservatBO var35;
    var35 = new ExReservatBO(8, "foo", 8);
    IExStichprobeBO var36;
    var36 = new ExStichprobeBO(8, new ExReservatBO(8, "foo", 8), new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), 8, EExExpositionBO.N, "foo", "foo", 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, "foo", "foo", new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), "foo", true, true, new CommonsArrayList<>(new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8)), new CommonsArrayList<>(new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8)), new CommonsArrayList<>(new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8)));
    IExStichprobeDeadwoodBO var37;
    var37 = new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8);
    IExTrunkSizeBO var38;
    var38 = new ExTrunkSizeBO(8, EExTreeHeightBO.ONE);
    File var39;
    var39 = new File("file.txt");
    Assert.assertNotNull(var39);
    float var40;
    var40 = 6.0F;
    Float var41;
    var41 = Float.valueOf(5.0F);
    Assert.assertNotNull(var41);
    int var42;
    var42 = 8;
    Integer var43;
    var43 = Integer.valueOf(7);
    Assert.assertNotNull(var43);
    LocalDate var44;
    var44 = PDTFactory.getCurrentLocalDate();
    Assert.assertNotNull(var44);
    LocalDateTime var45;
    var45 = PDTFactory.getCurrentLocalDateTime();
    Assert.assertNotNull(var45);
    LocalTime var46;
    var46 = PDTFactory.getCurrentLocalTime();
    Assert.assertNotNull(var46);
    Long var47;
    var47 = Long.valueOf(9L);
    Assert.assertNotNull(var47);
    long var48;
    var48 = 10L;
    OffsetDateTime var49;
    var49 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var49);
    Period var50;
    var50 = Period.ofDays(2);
    Assert.assertNotNull(var50);
    QName var51;
    var51 = new QName("urn:example", "elem");
    Assert.assertNotNull(var51);
    Serializable var52;
    var52 = ((Serializable)"object");
    Assert.assertNotNull(var52);
    Short var53;
    var53 = Short.valueOf(((short) 11));
    Assert.assertNotNull(var53);
    short var54;
    var54 = 12;
    String var55;
    var55 = "foo";
    Assert.assertNotNull(var55);
    ZonedDateTime var56;
    var56 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var56);
  }
}
