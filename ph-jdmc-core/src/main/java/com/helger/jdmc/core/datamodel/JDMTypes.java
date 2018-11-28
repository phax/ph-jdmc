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
  private final ICommonsMap <String, JDMType> m_aTypeHierarchy = new CommonsHashMap <> ();

  @Nonnull
  private JDMType _register (@Nonnull final JDMType aType)
  {
    final String sShortName = aType.getShortName ();
    if (m_aTypeHierarchy.containsKey (sShortName))
      throw new IllegalArgumentException ("A type with the name '" + sShortName + "' is already registered");
    m_aTypeHierarchy.put (sShortName, aType);
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
                                                                          (cm, cls) -> cm.ref (cls)
                                                                                         .staticRef ("TRUE")));
    _register (JDMType.createPrimitiveType ("boolean", aBoolean, JExpr.TRUE));
    final JDMType aByte = _register (JDMType.createClassTypeImmutable (Byte.class,
                                                                       (cm, cls) -> cm.ref (cls)
                                                                                      .staticInvoke ("valueOf")
                                                                                      .arg (0)));
    _register (JDMType.createPrimitiveType ("byte", aByte, JExpr.lit (0)));
    final JDMType aCharacter = _register (JDMType.createClassTypeImmutable (Character.class,
                                                                            (cm, cls) -> cm.ref (cls)
                                                                                           .staticInvoke ("valueOf")
                                                                                           .arg (' ')));
    _register (JDMType.createPrimitiveType ("char", aCharacter, JExpr.lit (' ')));
    final JDMType aDouble = _register (JDMType.createClassTypeImmutable (Double.class,
                                                                         (cm, cls) -> cm.ref (cls)
                                                                                        .staticInvoke ("valueOf")
                                                                                        .arg (0d)));
    _register (JDMType.createPrimitiveType ("double", aDouble, JExpr.lit (0d)));
    _register (JDMType.createClassTypeImmutable (Duration.class,
                                                 (cm, cls) -> cm.ref (cls).staticInvoke ("ofDays").arg (0L)));
    _register (JDMType.createClassTypeImmutable (Element.class,
                                                 cm -> cm.ref (DOMReader.class)
                                                         .staticInvoke ("readXMLDOM")
                                                         .arg ("<item/>")
                                                         .invoke ("getDocumentElement")));
    _register (JDMType.createClassTypeImmutable (File.class, (cm, cls) -> cm.ref (cls)._new ().arg ("file.txt")));
    final JDMType aFloat = _register (JDMType.createClassTypeImmutable (Float.class,
                                                                        (cm, cls) -> cm.ref (cls)
                                                                                       .staticInvoke ("valueOf")
                                                                                       .arg (0f)));
    _register (JDMType.createPrimitiveType ("float", aFloat, JExpr.lit (0f)));
    final JDMType aInteger = _register (JDMType.createClassTypeImmutable (Integer.class,
                                                                          (cm, cls) -> cm.ref (cls)
                                                                                         .staticInvoke ("valueOf")
                                                                                         .arg (0)));
    _register (JDMType.createPrimitiveType ("int", aInteger, JExpr.lit (0)));
    _register (JDMType.createClassTypeImmutable (LocalDate.class,
                                                 cm -> cm.ref (PDTFactory.class).staticInvoke ("getCurrentLocalDate")));
    _register (JDMType.createClassTypeImmutable (LocalDateTime.class,
                                                 cm -> cm.ref (PDTFactory.class)
                                                         .staticInvoke ("getCurrentLocalDateTime")));
    _register (JDMType.createClassTypeImmutable (LocalTime.class,
                                                 cm -> cm.ref (PDTFactory.class).staticInvoke ("getCurrentLocalTime")));
    final JDMType aLong = _register (JDMType.createClassTypeImmutable (Long.class,
                                                                       (cm, cls) -> cm.ref (cls)
                                                                                      .staticInvoke ("valueOf")
                                                                                      .arg (0L)));
    _register (JDMType.createPrimitiveType ("long", aLong, JExpr.lit (0L)));
    _register (JDMType.createClassTypeImmutable (Object.class,
                                                 (cm, cls) -> JExpr.lit ("object").castTo (cm.ref (cls))));
    _register (JDMType.createClassTypeImmutable (OffsetDateTime.class,
                                                 cm -> cm.ref (PDTFactory.class)
                                                         .staticInvoke ("getCurrentOffsetDateTime")));
    _register (JDMType.createClassTypeImmutable (Period.class,
                                                 (cm, cls) -> cm.ref (cls).staticInvoke ("ofDays").arg (0)));
    _register (JDMType.createClassTypeImmutable (QName.class,
                                                 (cm, cls) -> cm.ref (cls)._new ().arg ("urn:example").arg ("elem")));
    _register (JDMType.createClassTypeImmutable (Serializable.class,
                                                 (cm, cls) -> JExpr.lit ("object").castTo (cm.ref (cls))));
    final JDMType aShort = _register (JDMType.createClassTypeImmutable (Short.class,
                                                                        (cm, cls) -> cm.ref (cls)
                                                                                       .staticInvoke ("valueOf")
                                                                                       .arg (0)));
    _register (JDMType.createPrimitiveType ("short", aShort, JExpr.lit (0)));
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
    return m_aTypeHierarchy.get (sShortName);
  }

  @Nonnull
  public JDMType registerType (@Nonnull final AbstractJDMType aClass,
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
}
