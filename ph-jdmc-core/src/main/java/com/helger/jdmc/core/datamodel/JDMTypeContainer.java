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
import com.helger.commons.state.EChange;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.JExpr;
import com.helger.xml.serialize.read.DOMReader;

/**
 * List of {@link JDMType}.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMTypeContainer implements Serializable
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
    // Primitive types and primitive wrapper types
    final JDMType aBoolean = _register (JDMType.createPredefinedClassTypeImmutable (Boolean.class,
                                                                                    (cm, cs, e) -> cm.ref (Boolean.class)
                                                                                                     .staticRef ("TRUE")));
    _register (JDMType.createPredefinedPrimitiveType ("boolean", aBoolean, (cm, cs, e) -> JExpr.TRUE));
    final JDMType aByte = _register (JDMType.createPredefinedClassTypeImmutable (Byte.class,
                                                                                 (cm, cs, e) -> cm.ref (Byte.class)
                                                                                                  .staticInvoke ("valueOf")
                                                                                                  .arg (JExpr.lit (1).castTo (cm.BYTE))));
    _register (JDMType.createPredefinedPrimitiveType ("byte", aByte, (cm, cs, e) -> JExpr.lit (2)));
    final JDMType aCharacter = _register (JDMType.createPredefinedClassTypeImmutable (Character.class,
                                                                                      (cm, cs, e) -> cm.ref (Character.class)
                                                                                                       .staticInvoke ("valueOf")
                                                                                                       .arg (' ')));
    _register (JDMType.createPredefinedPrimitiveType ("char", aCharacter, (cm, cs, e) -> JExpr.lit ('x')));
    final JDMType aDouble = _register (JDMType.createPredefinedClassTypeImmutable (Double.class,
                                                                                   (cm, cs, e) -> cm.ref (Double.class)
                                                                                                    .staticInvoke ("valueOf")
                                                                                                    .arg (3d)));
    _register (JDMType.createPredefinedPrimitiveType ("double", aDouble, (cm, cs, e) -> JExpr.lit (4d)));
    final JDMType aFloat = _register (JDMType.createPredefinedClassTypeImmutable (Float.class,
                                                                                  (cm, cs, e) -> cm.ref (Float.class)
                                                                                                   .staticInvoke ("valueOf")
                                                                                                   .arg (5f)));
    _register (JDMType.createPredefinedPrimitiveType ("float", aFloat, (cm, cs, e) -> JExpr.lit (6f)));
    final JDMType aInteger = _register (JDMType.createPredefinedClassTypeImmutable (Integer.class,
                                                                                    (cm, cs, e) -> cm.ref (Integer.class)
                                                                                                     .staticInvoke ("valueOf")
                                                                                                     .arg (7)));
    _register (JDMType.createPredefinedPrimitiveType ("int", aInteger, (cm, cs, e) -> JExpr.lit (8)));
    final JDMType aLong = _register (JDMType.createPredefinedClassTypeImmutable (Long.class,
                                                                                 (cm, cs, e) -> cm.ref (Long.class)
                                                                                                  .staticInvoke ("valueOf")
                                                                                                  .arg (9L)));
    _register (JDMType.createPredefinedPrimitiveType ("long", aLong, (cm, cs, e) -> JExpr.lit (10L)));
    final JDMType aShort = _register (JDMType.createPredefinedClassTypeImmutable (Short.class,
                                                                                  (cm,
                                                                                   cs,
                                                                                   e) -> cm.ref (Short.class)
                                                                                           .staticInvoke ("valueOf")
                                                                                           .arg (JExpr.lit (11).castTo (cm.SHORT))));
    _register (JDMType.createPredefinedPrimitiveType ("short", aShort, (cm, cs, e) -> JExpr.lit (12)));

    // Other types
    _register (JDMType.createPredefinedClassTypeImmutable (BigDecimal.class,
                                                           (cm, cs, e) -> cm.ref (MathHelper.class)
                                                                            .staticInvoke ("toBigDecimal")
                                                                            .arg ("12.3456")));
    _register (JDMType.createPredefinedClassTypeImmutable (BigInteger.class,
                                                           (cm, cs, e) -> cm.ref (MathHelper.class)
                                                                            .staticInvoke ("toBigInteger")
                                                                            .arg ("7890")));
    _register (JDMType.createPredefinedClassTypeImmutable (Duration.class,
                                                           (cm, cs, e) -> cm.ref (Duration.class).staticInvoke ("ofDays").arg (1L)));
    _register (JDMType.createPredefinedClassTypeImmutable (Element.class,
                                                           (cm, cs, e) -> cm.ref (DOMReader.class)
                                                                            .staticInvoke ("readXMLDOM")
                                                                            .arg ("<item x='y'/>")
                                                                            .invoke ("getDocumentElement")));
    _register (JDMType.createPredefinedClassTypeImmutable (File.class, (cm, cs, e) -> cm.ref (File.class)._new ().arg ("file.txt")));
    _register (JDMType.createPredefinedClassTypeImmutable (LocalDate.class,
                                                           (cm, cs, e) -> cm.ref (PDTFactory.class).staticInvoke ("getCurrentLocalDate")));
    _register (JDMType.createPredefinedClassTypeImmutable (LocalDateTime.class,
                                                           (cm, cs, e) -> cm.ref (PDTFactory.class)
                                                                            .staticInvoke ("getCurrentLocalDateTime")));
    _register (JDMType.createPredefinedClassTypeImmutable (LocalTime.class,
                                                           (cm, cs, e) -> cm.ref (PDTFactory.class).staticInvoke ("getCurrentLocalTime")));
    if (false)
      _register (JDMType.createPredefinedClassTypeImmutable (Object.class,
                                                             (cm, cs, e) -> JExpr.lit ("object").castTo (cm.ref (Object.class))));
    _register (JDMType.createPredefinedClassTypeImmutable (OffsetDateTime.class,
                                                           (cm, cs, e) -> cm.ref (PDTFactory.class)
                                                                            .staticInvoke ("getCurrentOffsetDateTime")));
    _register (JDMType.createPredefinedClassTypeImmutable (Period.class,
                                                           (cm, cs, e) -> cm.ref (Period.class).staticInvoke ("ofDays").arg (2)));
    _register (JDMType.createPredefinedClassTypeImmutable (QName.class,
                                                           (cm, cs, e) -> cm.ref (QName.class)._new ().arg ("urn:example").arg ("elem")));
    _register (JDMType.createPredefinedClassTypeImmutable (Serializable.class,
                                                           (cm, cs, e) -> JExpr.lit ("object").castTo (cm.ref (Serializable.class))));
    _register (JDMType.createPredefinedClassTypeImmutable (String.class, (cm, cs, e) -> JExpr.lit ("foo")));
    _register (JDMType.createPredefinedClassTypeImmutable (ZonedDateTime.class,
                                                           (cm, cs, e) -> cm.ref (PDTFactory.class)
                                                                            .staticInvoke ("getCurrentZonedDateTime")));
  }

  public JDMTypeContainer ()
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

  /**
   * Register a newly created class or enum in this type container.
   *
   * @param aClass
   *        The created class or enum. May not be <code>null</code>.
   * @param aTestValueFactory
   *        The test value factory to be used. May not be <code>null</code>.
   * @return The created type and never <code>null</code>.
   * @throws IllegalArgumentException
   *         If another type with the same short name is already registered.
   */
  @Nonnull
  public JDMType registerType (@Nonnull final AbstractJDMGenType aClass, @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    final boolean bPredefined = false;
    final boolean bImmutable = aClass.isEnum ();
    final boolean bSerializable = true;
    final boolean bEnum = aClass.isEnum ();
    final JDMType aType = JDMType.createClassType (aClass.getPackageName (),
                                                   aClass.getClassName (),
                                                   bPredefined,
                                                   bImmutable,
                                                   bSerializable,
                                                   bEnum,
                                                   aTestValueFactory);
    return _register (aType);
  }

  @Nonnull
  public EChange unregisterType (@Nonnull final AbstractJDMGenType aClass)
  {
    return m_aTypes.removeObject (aClass.getClassName ());
  }

  @Nonnull
  public Iterable <JDMType> getTypes ()
  {
    return m_aTypes.values ();
  }
}
