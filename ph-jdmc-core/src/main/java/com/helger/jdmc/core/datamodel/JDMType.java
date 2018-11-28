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

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.lang.ClassHelper;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JCodeModel;

/**
 * Single type.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMType implements Serializable
{
  private final String m_sShortName;
  private final String m_sPackageName;
  private final String m_sClassName;
  private final boolean m_bIsPrimitive;
  private final boolean m_bImmutable;
  private final boolean m_bSerializable;
  private final boolean m_bIsEnum;
  private EJDMBaseType m_eBaseType;
  private final IJDMTypeTestValueCreator m_aTestValueFactory;

  private JDMType (@Nonnull @Nonempty final String sShortName,
                   @Nonnull final String sPackageName,
                   @Nonnull @Nonempty final String sClassName,
                   final boolean bIsPrimitive,
                   final boolean bImmutable,
                   final boolean bSerializable,
                   final boolean bIsEnum,
                   @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    ValueEnforcer.notEmpty (sShortName, "ShortName");
    ValueEnforcer.notNull (sPackageName, "PackageName");
    ValueEnforcer.notEmpty (sClassName, "ClassName");
    ValueEnforcer.notNull (aTestValueFactory, "TestValueFactory");

    m_sShortName = sShortName;
    m_sPackageName = sPackageName;
    m_sClassName = sClassName;
    m_bIsPrimitive = bIsPrimitive;
    m_bImmutable = bImmutable;
    m_bSerializable = bSerializable;
    m_bIsEnum = bIsEnum;
    if ("boolean".equals (sShortName) || "Boolean".equals (sShortName))
      m_eBaseType = EJDMBaseType.BOOLEAN;
    else
      if ("String".equals (sShortName))
        m_eBaseType = EJDMBaseType.STRING;
      else
        if ("byte".equals (sShortName) ||
            "Byte".equals (sShortName) ||
            "int".equals (sShortName) ||
            "Integer".equals (sShortName) ||
            "long".equals (sShortName) ||
            "Long".equals (sShortName) ||
            "short".equals (sShortName) ||
            "Short".equals (sShortName) ||
            "BigInteger".equals (sShortName))
          m_eBaseType = EJDMBaseType.INTEGER;
        else
          if ("double".equals (sShortName) ||
              "Double".equals (sShortName) ||
              "float".equals (sShortName) ||
              "Float".equals (sShortName) ||
              "BigDecimal".equals (sShortName))
            m_eBaseType = EJDMBaseType.DOUBLE;
          else
            if ("LocalDate".equals (sShortName) ||
                "LocalTime".equals (sShortName) ||
                "LocalDateTime".equals (sShortName) ||
                "OffsetDateTime".equals (sShortName) ||
                "ZonedDateTime".equals (sShortName))
              m_eBaseType = EJDMBaseType.DATETIME;
            else
              m_eBaseType = EJDMBaseType.OBJECT;
    m_aTestValueFactory = aTestValueFactory;
  }

  /**
   * @return The class short name without the package. Neither <code>null</code>
   *         nor empty.
   */
  @Nonnull
  @Nonempty
  public String getShortName ()
  {
    return m_sShortName;
  }

  /**
   * @return The package name only. Never <code>null</code> but maybe empty.
   */
  @Nonnull
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
    return AbstractJDMClassType.getFQCN (m_sPackageName, m_sClassName);
  }

  @Nonnull
  public EJDMBaseType getBaseType ()
  {
    return m_eBaseType;
  }

  /**
   * @return <code>true</code> if this is a primitive type, <code>false</code>
   *         if not.
   */
  public boolean isPrimitive ()
  {
    return m_bIsPrimitive;
  }

  public boolean isImmutable ()
  {
    return m_bImmutable;
  }

  public boolean isSerializable ()
  {
    return m_bSerializable;
  }

  public boolean isEnum ()
  {
    return m_bIsEnum;
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
  public IJExpression createTestValue (@Nonnull final JCodeModel cm)
  {
    return m_aTestValueFactory.createTestValue (cm);
  }

  @Nonnull
  public static JDMType createPrimitiveType (@Nonnull @Nonempty final String sShortName,
                                             @Nonnull @Nonempty final JDMType aClassType,
                                             @Nonnull final IJExpression aTestValue)
  {
    ValueEnforcer.notEmpty (sShortName, "ShortName");
    ValueEnforcer.notNull (aClassType, "ClassType");
    ValueEnforcer.notNull (aTestValue, "TestValue");

    final boolean bIsPrimitive = true;
    final boolean bImmutable = true;
    final boolean bSerializable = true;
    final boolean bIsEnum = false;
    return new JDMType (sShortName,
                        aClassType.getPackageName (),
                        aClassType.getClassName (),
                        bIsPrimitive,
                        bImmutable,
                        bSerializable,
                        bIsEnum,
                        cm -> aTestValue);
  }

  @Nonnull
  public static JDMType createClassType (@Nonnull final String sPackageName,
                                         @Nonnull @Nonempty final String sLocalClassName,
                                         final boolean bImmutable,
                                         final boolean bSerializable,
                                         final boolean bIsEnum,
                                         @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    ValueEnforcer.notNull (sPackageName, "PackageName");
    ValueEnforcer.notEmpty (sLocalClassName, "LocalClassName");
    ValueEnforcer.isTrue (sLocalClassName.indexOf ('.') < 0, "LocalClassName may not contain a dot");
    ValueEnforcer.notNull (aTestValueFactory, "TestValueFactory");

    final boolean bIsPrimitive = false;
    return new JDMType (sLocalClassName,
                        sPackageName,
                        sLocalClassName,
                        bIsPrimitive,
                        bImmutable,
                        bSerializable,
                        bIsEnum,
                        aTestValueFactory);
  }

  @Nonnull
  public static JDMType createClassTypeImmutable (@Nonnull final Class <?> aClass,
                                                  @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    final boolean bSerializable = Serializable.class.isAssignableFrom (aClass);
    final boolean bIsEnum = Enum.class.isAssignableFrom (aClass);
    return createClassType (aClass.getPackage ().getName (),
                            ClassHelper.getClassLocalName (aClass),
                            true,
                            bSerializable,
                            bIsEnum,
                            aTestValueFactory);
  }
}
