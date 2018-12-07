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
    EExExpositionBO var16;
    var16 = EExExpositionBO.N;
    Assert.assertNotNull(var16);
    EExSpecialStructureBO var17;
    var17 = EExSpecialStructureBO._1;
    Assert.assertNotNull(var17);
    EExStockDeadwoodBO var18;
    var18 = EExStockDeadwoodBO._0;
    Assert.assertNotNull(var18);
    EExStockTypeBO var19;
    var19 = EExStockTypeBO._0;
    Assert.assertNotNull(var19);
    EExTreeHeightBO var20;
    var20 = EExTreeHeightBO.ONE;
    Assert.assertNotNull(var20);
    EExTreeKindBO var21;
    var21 = EExTreeKindBO.Bergahorn;
    Assert.assertNotNull(var21);
    EExUsagePeriodBO var22;
    var22 = EExUsagePeriodBO.NONE;
    Assert.assertNotNull(var22);
    EExUsageTypeBO var23;
    var23 = EExUsageTypeBO.Hochwald;
    Assert.assertNotNull(var23);
    EExVitalityBO var24;
    var24 = EExVitalityBO.ONE;
    Assert.assertNotNull(var24);
    Element var25;
    var25 = DOMReader.readXMLDOM("<item x='y'/>").getDocumentElement();
    Assert.assertNotNull(var25);
    IExBestandBO var26;
    var26 = new ExBestandBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), "foo", new CommonsArrayList<>(new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo")), 8, "foo", true, true, EExStockTypeBO._0, "foo", "foo", true, true, true, EExStockDeadwoodBO._0, "foo", EExStockDeadwoodBO._0, "foo");
    IExBiotopbaumBO var27;
    var27 = new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)));
    IExBiotopbaumDeadwoodBO var28;
    var28 = new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8);
    IExBiotopbaumDecompositionDegreeBO var29;
    var29 = new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8);
    IExCaveTypeBO var30;
    var30 = new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1);
    IExHabitatbaumgruppeBO var31;
    var31 = new ExHabitatbaumgruppeBO(8, new CommonsArrayList<>(new File("file.txt")), new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), PDTFactory.getCurrentLocalDate(), "foo", true, true, true, true, true, EExExpositionBO.N, "foo", 8, true, "foo");
    IExLeergutBO var32;
    var32 = new ExLeergutBO();
    IExReservatBO var33;
    var33 = new ExReservatBO(8, "foo", 8);
    IExStichprobeBO var34;
    var34 = new ExStichprobeBO(8, new ExReservatBO(8, "foo", 8), new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), 8, EExExpositionBO.N, "foo", "foo", 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, 4.0, "foo", "foo", new CommonsArrayList<>(new ExBiotopbaumBO(8, new CommonsArrayList<>(new File("file.txt")), PDTFactory.getCurrentLocalDate(), new CommonsArrayList<>(EExBiotopbaumTypeBO.TOTHOLZ), "foo", EExExpositionBO.N, "foo", true, true, true, true, true, true, true, "foo", EExTreeKindBO.Bergahorn, new CommonsArrayList<>(new ExCaveTypeBO(EExCaveClassBO.ONE, EExCaveTypeBO._1)), new CommonsArrayList<>(new ExTrunkSizeBO(8, EExTreeHeightBO.ONE)), EExVitalityBO.ONE, new CommonsArrayList<>(EExSpecialStructureBO._1), "foo", true, "foo", true, "foo", new CommonsArrayList<>(new ExBiotopbaumDeadwoodBO(EExDeadwoodCategoryBO.CLASS1, true, 8, 8)), new CommonsArrayList<>(new ExBiotopbaumDecompositionDegreeBO(EExDecompositionDegreeClassBO.CLASS0, true, 8, 8)))), "foo", true, true, new CommonsArrayList<>(new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8)), new CommonsArrayList<>(new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8)), new CommonsArrayList<>(new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8)));
    IExStichprobeDeadwoodBO var35;
    var35 = new ExStichprobeDeadwoodBO(EExDecompositionDegreeClassBO.CLASS0, EExTreeKindBO.Bergahorn, 8, 8);
    IExTrunkSizeBO var36;
    var36 = new ExTrunkSizeBO(8, EExTreeHeightBO.ONE);
    File var37;
    var37 = new File("file.txt");
    Assert.assertNotNull(var37);
    float var38;
    var38 = 6.0F;
    Float var39;
    var39 = Float.valueOf(5.0F);
    Assert.assertNotNull(var39);
    int var40;
    var40 = 8;
    Integer var41;
    var41 = Integer.valueOf(7);
    Assert.assertNotNull(var41);
    LocalDate var42;
    var42 = PDTFactory.getCurrentLocalDate();
    Assert.assertNotNull(var42);
    LocalDateTime var43;
    var43 = PDTFactory.getCurrentLocalDateTime();
    Assert.assertNotNull(var43);
    LocalTime var44;
    var44 = PDTFactory.getCurrentLocalTime();
    Assert.assertNotNull(var44);
    Long var45;
    var45 = Long.valueOf(9L);
    Assert.assertNotNull(var45);
    long var46;
    var46 = 10L;
    OffsetDateTime var47;
    var47 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var47);
    Period var48;
    var48 = Period.ofDays(2);
    Assert.assertNotNull(var48);
    QName var49;
    var49 = new QName("urn:example", "elem");
    Assert.assertNotNull(var49);
    Serializable var50;
    var50 = ((Serializable)"object");
    Assert.assertNotNull(var50);
    Short var51;
    var51 = Short.valueOf(((short) 11));
    Assert.assertNotNull(var51);
    short var52;
    var52 = 12;
    String var53;
    var53 = "foo";
    Assert.assertNotNull(var53);
    ZonedDateTime var54;
    var54 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var54);
  }
}
