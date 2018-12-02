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
    var26 = null;
    IExBiotopbaumBO var27;
    var27 = null;
    IExBiotopbaumDeadwoodBO var28;
    var28 = null;
    IExBiotopbaumDecompositionDegreeBO var29;
    var29 = null;
    IExCaveTypeBO var30;
    var30 = null;
    IExHabitatbaumgruppeBO var31;
    var31 = null;
    IExLeergutBO var32;
    var32 = null;
    IExReservatBO var33;
    var33 = null;
    IExStichprobeBO var34;
    var34 = null;
    IExStichprobeDeadwoodBO var35;
    var35 = null;
    IExTrunkSizeBO var36;
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
    OffsetDateTime var47;
    var47 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var47);
    Period var48;
    var48 = Period.ofDays(0);
    Assert.assertNotNull(var48);
    QName var49;
    var49 = new QName("urn:example", "elem");
    Assert.assertNotNull(var49);
    Serializable var50;
    var50 = ((Serializable)"object");
    Assert.assertNotNull(var50);
    Short var51;
    var51 = Short.valueOf(((short) 0));
    Assert.assertNotNull(var51);
    short var52;
    var52 = 0;
    String var53;
    var53 = "foo";
    Assert.assertNotNull(var53);
    ZonedDateTime var54;
    var54 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var54);
  }
}
