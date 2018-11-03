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
package com.helger.jdmc.core;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.ICommonsMap;
import com.helger.commons.string.StringHelper;
import com.helger.photon.core.userdata.UserDataObject;

@NotThreadSafe
public class JDMTypes
{
  private final ICommonsMap <String, JDMType> m_aTypeHierarchy = new CommonsHashMap <> ();

  private void _register (@Nonnull final JDMType aType)
  {
    final String sShortName = aType.getShortName ();
    if (m_aTypeHierarchy.containsKey (sShortName))
      throw new IllegalArgumentException ("A type with the name '" + sShortName + "' is already registered");
    m_aTypeHierarchy.put (sShortName, aType);
  }

  private void _registerStandardTypes ()
  {
    _register (JDMType.createPrimitiveType ("boolean", "Boolean"));
    _register (JDMType.createPrimitiveType ("byte", "Byte"));
    _register (JDMType.createPrimitiveType ("char", "Character"));
    _register (JDMType.createPrimitiveType ("double", "Double"));
    _register (JDMType.createPrimitiveType ("float", "Float"));
    _register (JDMType.createPrimitiveType ("int", "Integer"));
    _register (JDMType.createPrimitiveType ("long", "Long"));
    _register (JDMType.createPrimitiveType ("short", "Short"));
    _register (JDMType.createClassType (String.class));
    _register (JDMType.createClassType (LocalDate.class));
    _register (JDMType.createClassType (LocalTime.class));
    _register (JDMType.createClassType (LocalDateTime.class));
    _register (JDMType.createClassType (BigDecimal.class));
    _register (JDMType.createClassType (BigInteger.class));
    _register (JDMType.createClassType (UserDataObject.class));
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
  public JDMType ensureTypeIsPresent (@Nonnull final String sPackageName, @Nonnull final String sLocalClassName)
  {
    JDMType aType = findType (sLocalClassName);
    if (aType == null)
    {
      aType = JDMType.createClassType (sPackageName, sLocalClassName);
      _register (aType);
    }
    return aType;
  }

  @Nonnull
  public JDMType registerType (@Nonnull final JDMClass aClass)
  {
    final JDMType aType = JDMType.createClassType (aClass.getPackageName (), aClass.getClassName ());
    _register (aType);
    return aType;
  }
}
