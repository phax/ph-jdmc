package com.helger.aufnahme.simple;

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
    Bestand var0;
    var0 = null;
    BigDecimal var1;
    var1 = MathHelper.toBigDecimal("12.3456");
    Assert.assertNotNull(var1);
    BigInteger var2;
    var2 = MathHelper.toBigInteger("7890");
    Assert.assertNotNull(var2);
    Biotopbaum var3;
    var3 = null;
    BiotopbaumDeadwood var4;
    var4 = null;
    BiotopbaumDecompositionDegree var5;
    var5 = null;
    Boolean var6;
    var6 = Boolean.TRUE;
    Assert.assertNotNull(var6);
    boolean var7;
    var7 = true;
    byte var8;
    var8 = 0;
    Byte var9;
    var9 = Byte.valueOf(((byte) 0));
    Assert.assertNotNull(var9);
    CaveType var10;
    var10 = null;
    Character var11;
    var11 = Character.valueOf(' ');
    Assert.assertNotNull(var11);
    char var12;
    var12 = ' ';
    double var13;
    var13 = 0.0;
    Double var14;
    var14 = Double.valueOf(0.0);
    Assert.assertNotNull(var14);
    Duration var15;
    var15 = Duration.ofDays(0L);
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
    EExposition var21;
    var21 = EExposition.N;
    Assert.assertNotNull(var21);
    ESpecialStructure var22;
    var22 = ESpecialStructure._1;
    Assert.assertNotNull(var22);
    EStockDeadwood var23;
    var23 = EStockDeadwood._0;
    Assert.assertNotNull(var23);
    EStockType var24;
    var24 = EStockType._0;
    Assert.assertNotNull(var24);
    ETreeHeight var25;
    var25 = ETreeHeight.ONE;
    Assert.assertNotNull(var25);
    ETreeKind var26;
    var26 = ETreeKind.Bergahorn;
    Assert.assertNotNull(var26);
    EUsagePeriod var27;
    var27 = EUsagePeriod.NONE;
    Assert.assertNotNull(var27);
    EUsageType var28;
    var28 = EUsageType.Hochwald;
    Assert.assertNotNull(var28);
    EVitality var29;
    var29 = EVitality.ONE;
    Assert.assertNotNull(var29);
    Element var30;
    var30 = DOMReader.readXMLDOM("<item/>").getDocumentElement();
    Assert.assertNotNull(var30);
    File var31;
    var31 = new File("file.txt");
    Assert.assertNotNull(var31);
    float var32;
    var32 = 0.0F;
    Float var33;
    var33 = Float.valueOf(0.0F);
    Assert.assertNotNull(var33);
    Habitatbaumgruppe var34;
    var34 = null;
    int var35;
    var35 = 0;
    Integer var36;
    var36 = Integer.valueOf(0);
    Assert.assertNotNull(var36);
    LocalDate var37;
    var37 = PDTFactory.getCurrentLocalDate();
    Assert.assertNotNull(var37);
    LocalDateTime var38;
    var38 = PDTFactory.getCurrentLocalDateTime();
    Assert.assertNotNull(var38);
    LocalTime var39;
    var39 = PDTFactory.getCurrentLocalTime();
    Assert.assertNotNull(var39);
    Long var40;
    var40 = Long.valueOf(0L);
    Assert.assertNotNull(var40);
    long var41;
    var41 = 0L;
    Object var42;
    var42 = ((Object)"object");
    Assert.assertNotNull(var42);
    OffsetDateTime var43;
    var43 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var43);
    Period var44;
    var44 = Period.ofDays(0);
    Assert.assertNotNull(var44);
    QName var45;
    var45 = new QName("urn:example", "elem");
    Assert.assertNotNull(var45);
    Reservat var46;
    var46 = null;
    Serializable var47;
    var47 = ((Serializable)"object");
    Assert.assertNotNull(var47);
    Short var48;
    var48 = Short.valueOf(((short) 0));
    Assert.assertNotNull(var48);
    short var49;
    var49 = 0;
    Stichprobe var50;
    var50 = null;
    StichprobeDeadwood var51;
    var51 = null;
    String var52;
    var52 = "foo";
    Assert.assertNotNull(var52);
    TrunkSize var53;
    var53 = null;
    ZonedDateTime var54;
    var54 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var54);
  }
}
