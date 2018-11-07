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
import com.helger.commons.string.StringHelper;
import com.helger.photon.core.userdata.UserDataObject;

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
    _register (JDMType.createClassTypeImmutable (BigDecimal.class));
    _register (JDMType.createClassTypeImmutable (BigInteger.class));
    final JDMType aBoolean = _register (JDMType.createClassTypeImmutable (Boolean.class));
    _register (JDMType.createPrimitiveType ("boolean", aBoolean));
    final JDMType aByte = _register (JDMType.createClassTypeImmutable (Byte.class));
    _register (JDMType.createPrimitiveType ("byte", aByte));
    final JDMType aCharacter = _register (JDMType.createClassTypeImmutable (Character.class));
    _register (JDMType.createPrimitiveType ("char", aCharacter));
    final JDMType aDouble = _register (JDMType.createClassTypeImmutable (Double.class));
    _register (JDMType.createPrimitiveType ("double", aDouble));
    _register (JDMType.createClassTypeImmutable (Duration.class));
    _register (JDMType.createClassTypeImmutable (Element.class));
    final JDMType aFloat = _register (JDMType.createClassTypeImmutable (Float.class));
    _register (JDMType.createPrimitiveType ("float", aFloat));
    final JDMType aInteger = _register (JDMType.createClassTypeImmutable (Integer.class));
    _register (JDMType.createPrimitiveType ("int", aInteger));
    _register (JDMType.createClassTypeImmutable (LocalDate.class));
    _register (JDMType.createClassTypeImmutable (LocalDateTime.class));
    _register (JDMType.createClassTypeImmutable (LocalTime.class));
    final JDMType aLong = _register (JDMType.createClassTypeImmutable (Long.class));
    _register (JDMType.createPrimitiveType ("long", aLong));
    _register (JDMType.createClassTypeImmutable (Object.class));
    _register (JDMType.createClassTypeImmutable (OffsetDateTime.class));
    _register (JDMType.createClassTypeImmutable (Period.class));
    _register (JDMType.createClassTypeImmutable (QName.class));
    _register (JDMType.createClassTypeImmutable (Serializable.class));
    final JDMType aShort = _register (JDMType.createClassTypeImmutable (Short.class));
    _register (JDMType.createPrimitiveType ("short", aShort));
    _register (JDMType.createClassTypeImmutable (String.class));
    _register (JDMType.createClassTypeImmutable (UserDataObject.class));
    _register (JDMType.createClassTypeImmutable (ZonedDateTime.class));
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
  public JDMType registerType (@Nonnull final AbstractJDMType aClass)
  {
    final boolean bIsImmutable = aClass.isEnum ();
    final boolean bIsSerializable = true;
    final boolean bIsEnum = aClass.isEnum ();
    final JDMType aType = JDMType.createClassType (aClass.getPackageName (),
                                                   aClass.getClassName (),
                                                   bIsImmutable,
                                                   bIsSerializable,
                                                   bIsEnum);
    return _register (aType);
  }
}
