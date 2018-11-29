/**
 * Copyright (C) 2018 Philip Helger (www.helger.com)
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
package com.helger.jdmc.core.datamodel;

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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.xml.namespace.QName;

import org.w3c.dom.Element;

import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.ICommonsMap;
import com.helger.commons.datetime.PDTFactory;
import com.helger.commons.math.MathHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.JExpr;
import com.helger.xml.serialize.read.DOMReader;

/**
 * List of {@link JDMType}.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMTypes
{
  private final ICommonsMap <String, JDMType> m_aTypes = new CommonsHashMap <> ();

  @Nonnull
  private JDMType _register (@Nonnull final JDMType aType)
  {
    final String sShortName = aType.getShortName ();
    if (m_aTypes.containsKey (sShortName))
      throw new IllegalArgumentException ("A type with the name '" + sShortName + "' is already registered");
    m_aTypes.put (sShortName, aType);
    return aType;
  }

  private void _registerStandardTypes ()
  {
    _register (JDMType.createClassTypeImmutable (BigDecimal.class,
                                                 (cm) -> cm.ref (MathHelper.class)
                                                           .staticInvoke ("toBigDecimal")
                                                           .arg ("12.3456")));
    _register (JDMType.createClassTypeImmutable (BigInteger.class,
                                                 (cm) -> cm.ref (MathHelper.class)
                                                           .staticInvoke ("toBigInteger")
                                                           .arg ("7890")));
    final JDMType aBoolean = _register (JDMType.createClassTypeImmutable (Boolean.class,
                                                                          cm -> cm.ref (Boolean.class)
                                                                                  .staticRef ("TRUE")));
    _register (JDMType.createPrimitiveType ("boolean", aBoolean, cm -> JExpr.TRUE));
    final JDMType aByte = _register (JDMType.createClassTypeImmutable (Byte.class,
                                                                       cm -> cm.ref (Byte.class)
                                                                               .staticInvoke ("valueOf")
                                                                               .arg (JExpr.lit (0).castTo (cm.BYTE))));
    _register (JDMType.createPrimitiveType ("byte", aByte, cm -> JExpr.lit (0)));
    final JDMType aCharacter = _register (JDMType.createClassTypeImmutable (Character.class,
                                                                            cm -> cm.ref (Character.class)
                                                                                    .staticInvoke ("valueOf")
                                                                                    .arg (' ')));
    _register (JDMType.createPrimitiveType ("char", aCharacter, cm -> JExpr.lit (' ')));
    final JDMType aDouble = _register (JDMType.createClassTypeImmutable (Double.class,
                                                                         cm -> cm.ref (Double.class)
                                                                                 .staticInvoke ("valueOf")
                                                                                 .arg (0d)));
    _register (JDMType.createPrimitiveType ("double", aDouble, cm -> JExpr.lit (0d)));
    _register (JDMType.createClassTypeImmutable (Duration.class,
                                                 cm -> cm.ref (Duration.class).staticInvoke ("ofDays").arg (0L)));
    _register (JDMType.createClassTypeImmutable (Element.class,
                                                 cm -> cm.ref (DOMReader.class)
                                                         .staticInvoke ("readXMLDOM")
                                                         .arg ("<item/>")
                                                         .invoke ("getDocumentElement")));
    _register (JDMType.createClassTypeImmutable (File.class, cm -> cm.ref (File.class)._new ().arg ("file.txt")));
    final JDMType aFloat = _register (JDMType.createClassTypeImmutable (Float.class,
                                                                        cm -> cm.ref (Float.class)
                                                                                .staticInvoke ("valueOf")
                                                                                .arg (0f)));
    _register (JDMType.createPrimitiveType ("float", aFloat, cm -> JExpr.lit (0f)));
    final JDMType aInteger = _register (JDMType.createClassTypeImmutable (Integer.class,
                                                                          cm -> cm.ref (Integer.class)
                                                                                  .staticInvoke ("valueOf")
                                                                                  .arg (0)));
    _register (JDMType.createPrimitiveType ("int", aInteger, cm -> JExpr.lit (0)));
    _register (JDMType.createClassTypeImmutable (LocalDate.class,
                                                 cm -> cm.ref (PDTFactory.class).staticInvoke ("getCurrentLocalDate")));
    _register (JDMType.createClassTypeImmutable (LocalDateTime.class,
                                                 cm -> cm.ref (PDTFactory.class)
                                                         .staticInvoke ("getCurrentLocalDateTime")));
    _register (JDMType.createClassTypeImmutable (LocalTime.class,
                                                 cm -> cm.ref (PDTFactory.class).staticInvoke ("getCurrentLocalTime")));
    final JDMType aLong = _register (JDMType.createClassTypeImmutable (Long.class,
                                                                       cm -> cm.ref (Long.class)
                                                                               .staticInvoke ("valueOf")
                                                                               .arg (0L)));
    _register (JDMType.createPrimitiveType ("long", aLong, cm -> JExpr.lit (0L)));
    _register (JDMType.createClassTypeImmutable (Object.class,
                                                 cm -> JExpr.lit ("object").castTo (cm.ref (Object.class))));
    _register (JDMType.createClassTypeImmutable (OffsetDateTime.class,
                                                 cm -> cm.ref (PDTFactory.class)
                                                         .staticInvoke ("getCurrentOffsetDateTime")));
    _register (JDMType.createClassTypeImmutable (Period.class,
                                                 cm -> cm.ref (Period.class).staticInvoke ("ofDays").arg (0)));
    _register (JDMType.createClassTypeImmutable (QName.class,
                                                 cm -> cm.ref (QName.class)._new ().arg ("urn:example").arg ("elem")));
    _register (JDMType.createClassTypeImmutable (Serializable.class,
                                                 cm -> JExpr.lit ("object").castTo (cm.ref (Serializable.class))));
    final JDMType aShort = _register (JDMType.createClassTypeImmutable (Short.class,
                                                                        cm -> cm.ref (Short.class)
                                                                                .staticInvoke ("valueOf")
                                                                                .arg (JExpr.lit (0)
                                                                                           .castTo (cm.SHORT))));
    _register (JDMType.createPrimitiveType ("short", aShort, cm -> JExpr.lit (0)));
    _register (JDMType.createClassTypeImmutable (String.class, cm -> JExpr.lit ("foo")));
    _register (JDMType.createClassTypeImmutable (ZonedDateTime.class,
                                                 cm -> cm.ref (PDTFactory.class)
                                                         .staticInvoke ("getCurrentZonedDateTime")));
  }

  public JDMTypes ()
  {
    _registerStandardTypes ();
  }

  @Nullable
  public JDMType findType (@Nullable final String sShortName)
  {
    if (StringHelper.hasNoText (sShortName))
      return null;
    return m_aTypes.get (sShortName);
  }

  @Nonnull
  public JDMType registerType (@Nonnull final AbstractJDMClassType aClass,
                               @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    final boolean bIsImmutable = aClass.isEnum ();
    final boolean bIsSerializable = true;
    final boolean bIsEnum = aClass.isEnum ();
    final JDMType aType = JDMType.createClassType (aClass.getPackageName (),
                                                   aClass.getClassName (),
                                                   bIsImmutable,
                                                   bIsSerializable,
                                                   bIsEnum,
                                                   aTestValueFactory);
    return _register (aType);
  }

  @Nonnull
  public Iterable <JDMType> getTypes ()
  {
    return m_aTypes.values ();
  }
}
