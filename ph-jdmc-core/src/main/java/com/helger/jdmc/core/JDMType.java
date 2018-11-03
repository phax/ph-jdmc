/**
 * Copyright (C) 2014-2018 Philip Helger
 * http://www.helger.com
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

import java.io.Serializable;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.lang.ClassHelper;

@NotThreadSafe
public class JDMType
{
  private final String m_sShortName;
  private final String m_sPackageName;
  private final String m_sClassName;
  private final boolean m_bIsPrimitive;
  private EJDMBaseType m_eBaseType;

  private JDMType (@Nonnull @Nonempty final String sShortName,
                   @Nonnull @Nonempty final String sPackageName,
                   @Nonnull @Nonempty final String sClassName,
                   final boolean bIsPrimitive)
  {
    m_sShortName = sShortName;
    m_sPackageName = sPackageName;
    m_sClassName = sClassName;
    m_bIsPrimitive = bIsPrimitive;
    if ("boolean".equals (sShortName))
      m_eBaseType = EJDMBaseType.BOOLEAN;
    else
      if ("String".equals (sShortName))
        m_eBaseType = EJDMBaseType.STRING;
      else
        if ("byte".equals (sShortName) ||
            "int".equals (sShortName) ||
            "long".equals (sShortName) ||
            "short".equals (sShortName) ||
            "BigInteger".equals (sShortName))
          m_eBaseType = EJDMBaseType.INTEGER;
        else
          if ("double".equals (sShortName) || "float".equals (sShortName) || "BigDecimal".equals (sShortName))
            m_eBaseType = EJDMBaseType.DOUBLE;
          else
            if ("LocalDate".equals (sShortName) ||
                "LocalTime".equals (sShortName) ||
                "LocalDateTime".equals (sShortName))
              m_eBaseType = EJDMBaseType.DATETIME;
            else
              m_eBaseType = EJDMBaseType.OBJECT;
  }

  @Nonnull
  @Nonempty
  public String getShortName ()
  {
    return m_sShortName;
  }

  @Nonnull
  @Nonempty
  public String getPackageName ()
  {
    return m_sPackageName;
  }

  /**
   * @return The class name. It differs from the type name if
   *         {@link #isPrimitive()} is <code>true</code>.
   */
  @Nonnull
  @Nonempty
  public String getClassName ()
  {
    return m_sClassName;
  }

  /**
   * @return {@link #getPackageName()} + "." + {@link #getClassName()}
   */
  @Nonnull
  @Nonempty
  public String getFQCN ()
  {
    return JDMClass.getFQCN (m_sPackageName, m_sClassName);
  }

  /**
   * @return <code>true</code> if this is a primitive type, <code>false</code>
   *         if not.
   */
  public boolean isPrimitive ()
  {
    return m_bIsPrimitive;
  }

  @Nonnull
  public EJDMBaseType getBaseType ()
  {
    return m_eBaseType;
  }

  public boolean isJavaPrimitive (@Nonnull final EJDMMultiplicity eMultiplicity)
  {
    return isPrimitive () && eMultiplicity.isMin1 ();
  }

  @Nonnull
  @Nonempty
  public String getJavaFQCN (@Nonnull final EJDMMultiplicity eMultiplicity)
  {
    if (isJavaPrimitive (eMultiplicity))
      return m_sShortName;
    return getFQCN ();
  }

  @Nonnull
  public static JDMType createPrimitiveType (@Nonnull @Nonempty final String sShortName,
                                             @Nonnull @Nonempty final String sLocalClassName)
  {
    ValueEnforcer.notEmpty (sShortName, "ShortName");
    ValueEnforcer.notEmpty (sLocalClassName, "LocalClassName");
    ValueEnforcer.isTrue (sLocalClassName.indexOf ('.') < 0, "LocalClassName may not contain a dot");
    return new JDMType (sShortName, "java.lang", sLocalClassName, true);
  }

  @Nonnull
  public static JDMType createClassType (@Nonnull final String sPackageName,
                                         @Nonnull @Nonempty final String sLocalClassName)
  {
    ValueEnforcer.notNull (sPackageName, "PackageName");
    ValueEnforcer.notEmpty (sLocalClassName, "LocalClassName");
    ValueEnforcer.isTrue (sLocalClassName.indexOf ('.') < 0, "LocalClassName may not contain a dot");
    return new JDMType (sLocalClassName, sPackageName, sLocalClassName, false);
  }

  @Nonnull
  public static JDMType createClassType (@Nonnull final Class <?> aClass)
  {
    ValueEnforcer.isTrue (Serializable.class.isAssignableFrom (aClass),
                          () -> aClass.getName () + " is not Serilizable");
    return createClassType (aClass.getPackage ().getName (), ClassHelper.getClassLocalName (aClass));
  }
}
