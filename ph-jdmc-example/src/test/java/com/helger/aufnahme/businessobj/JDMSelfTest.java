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
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.math.MathHelper;
import com.helger.xml.serialize.read.DOMReader;
import javax.xml.namespace.QName;
import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Element;


/**
 * This is the self-test class of JDM
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class JDMSelfTest {

  @Test
  @SuppressWarnings({
    "unused",
    "cast"
  })
  public void testSetterAndGetter() {
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
    var4 = 0;
    Byte var5;
    var5 = Byte.valueOf(((byte) 0));
    Assert.assertNotNull(var5);
    Character var6;
    var6 = Character.valueOf(' ');
    Assert.assertNotNull(var6);
    char var7;
    var7 = ' ';
    double var8;
    var8 = 0.0;
    Double var9;
    var9 = Double.valueOf(0.0);
    Assert.assertNotNull(var9);
    Duration var10;
    var10 = Duration.ofDays(0L);
    Assert.assertNotNull(var10);
    Element var11;
    var11 = DOMReader.readXMLDOM("<item/>").getDocumentElement();
    Assert.assertNotNull(var11);
    ExBestandBO var12;
    var12 = null;
    ExBiotopbaumBO var13;
    var13 = null;
    ExBiotopbaumDeadwoodBO var14;
    var14 = null;
    ExBiotopbaumDecompositionDegreeBO var15;
    var15 = null;
    ExCaveTypeBO var16;
    var16 = null;
    ExEBiotopbaumTypeBO var17;
    var17 = ExEBiotopbaumTypeBO.TOTHOLZ;
    Assert.assertNotNull(var17);
    ExECaveClassBO var18;
    var18 = ExECaveClassBO.ONE;
    Assert.assertNotNull(var18);
    ExECaveTypeBO var19;
    var19 = ExECaveTypeBO._1;
    Assert.assertNotNull(var19);
    ExEDeadwoodCategoryBO var20;
    var20 = ExEDeadwoodCategoryBO.CLASS1;
    Assert.assertNotNull(var20);
    ExEDecompositionDegreeClassBO var21;
    var21 = ExEDecompositionDegreeClassBO.CLASS0;
    Assert.assertNotNull(var21);
    ExEExpositionBO var22;
    var22 = ExEExpositionBO.N;
    Assert.assertNotNull(var22);
    ExESpecialStructureBO var23;
    var23 = ExESpecialStructureBO._1;
    Assert.assertNotNull(var23);
    ExEStockDeadwoodBO var24;
    var24 = ExEStockDeadwoodBO._0;
    Assert.assertNotNull(var24);
    ExEStockTypeBO var25;
    var25 = ExEStockTypeBO._0;
    Assert.assertNotNull(var25);
    ExETreeHeightBO var26;
    var26 = ExETreeHeightBO.ONE;
    Assert.assertNotNull(var26);
    ExETreeKindBO var27;
    var27 = ExETreeKindBO.Bergahorn;
    Assert.assertNotNull(var27);
    ExEUsagePeriodBO var28;
    var28 = ExEUsagePeriodBO.NONE;
    Assert.assertNotNull(var28);
    ExEUsageTypeBO var29;
    var29 = ExEUsageTypeBO.Hochwald;
    Assert.assertNotNull(var29);
    ExEVitalityBO var30;
    var30 = ExEVitalityBO.ONE;
    Assert.assertNotNull(var30);
    ExHabitatbaumgruppeBO var31;
    var31 = null;
    ExLeergutBO var32;
    var32 = null;
    ExReservatBO var33;
    var33 = null;
    ExStichprobeBO var34;
    var34 = null;
    ExStichprobeDeadwoodBO var35;
    var35 = null;
    ExTrunkSizeBO var36;
    var36 = null;
    File var37;
    var37 = new File("file.txt");
    Assert.assertNotNull(var37);
    float var38;
    var38 = 0.0F;
    Float var39;
    var39 = Float.valueOf(0.0F);
    Assert.assertNotNull(var39);
    int var40;
    var40 = 0;
    Integer var41;
    var41 = Integer.valueOf(0);
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
    var45 = Long.valueOf(0L);
    Assert.assertNotNull(var45);
    long var46;
    var46 = 0L;
    Object var47;
    var47 = ((Object)"object");
    Assert.assertNotNull(var47);
    OffsetDateTime var48;
    var48 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var48);
    Period var49;
    var49 = Period.ofDays(0);
    Assert.assertNotNull(var49);
    QName var50;
    var50 = new QName("urn:example", "elem");
    Assert.assertNotNull(var50);
    Serializable var51;
    var51 = ((Serializable)"object");
    Assert.assertNotNull(var51);
    Short var52;
    var52 = Short.valueOf(((short) 0));
    Assert.assertNotNull(var52);
    short var53;
    var53 = 0;
    String var54;
    var54 = "foo";
    Assert.assertNotNull(var54);
    ZonedDateTime var55;
    var55 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var55);
  }
}
