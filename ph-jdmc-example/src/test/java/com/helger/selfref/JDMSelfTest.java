/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
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
package com.helger.selfref;

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

import javax.xml.namespace.QName;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.w3c.dom.Element;

import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.math.MathHelper;
import com.helger.photon.app.mock.PhotonAppWebTestRule;
import com.helger.xml.serialize.read.DOMReader;


/**
 * This is the self-test class of JDM
 * This class was initially automatically created
 * 
 * 
 * @author JDMCodeGenerator
 */
public final class JDMSelfTest {
  @Rule
  public final TestRule m_aRule = new PhotonAppWebTestRule();

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
    Element var11;
    var11 = DOMReader.readXMLDOM("<item x='y'/>").getDocumentElement();
    Assert.assertNotNull(var11);
    File var12;
    var12 = new File("file.txt");
    Assert.assertNotNull(var12);
    float var13;
    var13 = 6.0F;
    Float var14;
    var14 = Float.valueOf(5.0F);
    Assert.assertNotNull(var14);
    int var15;
    var15 = 8;
    Integer var16;
    var16 = Integer.valueOf(7);
    Assert.assertNotNull(var16);
    LocalDate var17;
    var17 = PDTFactory.getCurrentLocalDate();
    Assert.assertNotNull(var17);
    LocalDateTime var18;
    var18 = PDTFactory.getCurrentLocalDateTime();
    Assert.assertNotNull(var18);
    LocalTime var19;
    var19 = PDTFactory.getCurrentLocalTime();
    Assert.assertNotNull(var19);
    long var20;
    var20 = 10L;
    Long var21;
    var21 = Long.valueOf(9L);
    Assert.assertNotNull(var21);
    OffsetDateTime var22;
    var22 = PDTFactory.getCurrentOffsetDateTime();
    Assert.assertNotNull(var22);
    Period var23;
    var23 = Period.ofDays(2);
    Assert.assertNotNull(var23);
    QName var24;
    var24 = new QName("urn:example", "elem");
    Assert.assertNotNull(var24);
    ISelfRefDemo1 var25;
    var25 = new SelfRefDemo1(null);
    Serializable var26;
    var26 = ((Serializable)"object");
    Assert.assertNotNull(var26);
    Short var27;
    var27 = Short.valueOf(((short) 11));
    Assert.assertNotNull(var27);
    short var28;
    var28 = 12;
    String var29;
    var29 = "foo";
    Assert.assertNotNull(var29);
    ZonedDateTime var30;
    var30 = PDTFactory.getCurrentZonedDateTime();
    Assert.assertNotNull(var30);
  }
}
