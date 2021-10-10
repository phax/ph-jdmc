/*
 * Copyright (C) 2018-2021 Philip Helger (www.helger.com)
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
import com.helger.commons.annotation.MustImplementComparable;
import com.helger.commons.annotation.MustImplementEqualsAndHashcode;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.hashcode.HashCodeGenerator;
import com.helger.commons.lang.ClassHelper;
import com.helger.jcodemodel.IJExpression;
import com.helger.jdmc.core.codegen.JDMCodeGenSettings;
import com.helger.jdmc.core.codegen.JDMCodeModel;

/**
 * Single type.
 *
 * @author Philip Helger
 */
@NotThreadSafe
@MustImplementEqualsAndHashcode
@MustImplementComparable
public class JDMType implements Serializable, Comparable <JDMType>
{
  private final String m_sShortName;
  private final String m_sPackageName;
  private final String m_sClassName;
  private final boolean m_bPrimitive;
  private final boolean m_bPredefined;
  private final boolean m_bImmutable;
  private final boolean m_bSerializable;
  private final boolean m_bEnum;
  private final EJDMBaseType m_eBaseType;
  private final IJDMTypeTestValueCreator m_aTestValueFactory;

  private JDMType (@Nonnull @Nonempty final String sShortName,
                   @Nonnull final String sPackageName,
                   @Nonnull @Nonempty final String sClassName,
                   final boolean bPrimitive,
                   final boolean bPredefined,
                   final boolean bImmutable,
                   final boolean bSerializable,
                   final boolean bEnum,
                   @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    ValueEnforcer.notEmpty (sShortName, "ShortName");
    ValueEnforcer.notNull (sPackageName, "PackageName");
    ValueEnforcer.notEmpty (sClassName, "ClassName");
    ValueEnforcer.notNull (aTestValueFactory, "TestValueFactory");

    m_sShortName = sShortName;
    m_sPackageName = sPackageName;
    m_sClassName = sClassName;
    m_bPrimitive = bPrimitive;
    m_bPredefined = bPredefined;
    m_bImmutable = bImmutable;
    m_bSerializable = bSerializable;
    m_bEnum = bEnum;
    m_eBaseType = EJDMBaseType.getFromShortName (sShortName);
    m_aTestValueFactory = aTestValueFactory;
  }

  /**
   * @return The class short name without the package. Neither <code>null</code>
   *         nor empty. For primitive types, this is e.g. "int". For regular
   *         classes it is the class local name which is the same as
   *         {@link #getClassName()}.
   * @see #getClassName()
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
   * @return The class name. It differs from the short name if
   *         {@link #isPrimitive()} is <code>true</code>.
   * @see #getShortName()
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
    return AbstractJDMGenType.getFQCN (m_sPackageName, m_sClassName);
  }

  /**
   * @return {@link #getPackageName()} + ".I" + {@link #getClassName()}
   */
  @Nonnull
  @Nonempty
  public String getInterfaceFQCN ()
  {
    return AbstractJDMGenType.getFQCN (m_sPackageName, "I" + m_sClassName);
  }

  /**
   * @return The heuristically determined base type. Never <code>null</code>.
   */
  @Nonnull
  public EJDMBaseType getBaseType ()
  {
    return m_eBaseType;
  }

  /**
   * @return <code>true</code> if this is a primitive type (boolean, byte, char,
   *         double, float, int, long, short), <code>false</code> if not.
   */
  public final boolean isPrimitive ()
  {
    return m_bPrimitive;
  }

  /**
   * @return <code>true</code> if it is a predefined type, <code>false</code> if
   *         it is a type representing a generated class.
   */
  public final boolean isPredefined ()
  {
    return m_bPredefined;
  }

  /**
   * @return <code>true</code> if the content of the data type is immutable
   *         (like String), <code>false</code> if it is mutable (and has e.g.
   *         setter)
   */
  public final boolean isImmutable ()
  {
    return m_bImmutable;
  }

  /**
   * @return <code>true</code> if the created class implements
   *         <code>java.io.Serializable</code>, <code>false</code> if not.
   */
  public final boolean isSerializable ()
  {
    return m_bSerializable;
  }

  /**
   * @return <code>true</code> if it is an enumeration, <code>false</code> if
   *         not.
   */
  public final boolean isEnum ()
  {
    return m_bEnum;
  }

  public boolean isJavaPrimitive (@Nonnull final EJDMMultiplicity eMultiplicity)
  {
    // No optional primitive and no list of primitives
    return isPrimitive () && eMultiplicity == EJDMMultiplicity.MANDATORY;
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
  protected final IJDMTypeTestValueCreator getTestValueFactory ()
  {
    return m_aTestValueFactory;
  }

  @Nonnull
  public IJExpression createTestValue (@Nonnull final JDMCodeModel cm,
                                       @Nonnull final JDMCodeGenSettings cs,
                                       @Nonnull final EJDMMultiplicity eMultiplicity)
  {
    return m_aTestValueFactory.createTestValue (cm, cs, eMultiplicity);
  }

  @Override
  public boolean equals (final Object o)
  {
    if (o == this)
      return true;
    if (o == null || !getClass ().equals (o.getClass ()))
      return false;
    final JDMType rhs = (JDMType) o;
    return m_sShortName.equals (rhs.m_sShortName);
  }

  @Override
  public int hashCode ()
  {
    return new HashCodeGenerator (this).append (m_sShortName).getHashCode ();
  }

  public int compareTo (@Nonnull final JDMType aOther)
  {
    return m_sShortName.compareTo (aOther.m_sShortName);
  }

  @Nonnull
  public static JDMType createPredefinedPrimitiveType (@Nonnull @Nonempty final String sShortName,
                                                       @Nonnull @Nonempty final JDMType aClassType,
                                                       @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    ValueEnforcer.notEmpty (sShortName, "ShortName");
    ValueEnforcer.notNull (aClassType, "ClassType");
    ValueEnforcer.notNull (aTestValueFactory, "TestValueFactory");

    final boolean bPrimitive = true;
    final boolean bPredefined = true;
    final boolean bImmutable = true;
    final boolean bSerializable = true;
    final boolean bIsEnum = false;
    final IJDMTypeTestValueCreator aSpecialTVC = (cm, cs, e) -> {
      if (e == EJDMMultiplicity.MANDATORY)
        return aTestValueFactory.createTestValue (cm, cs, e);
      // Otherwise use the test value of the primtive wrapper type
      return aClassType.getTestValueFactory ().createTestValue (cm, cs, e);
    };
    return new JDMType (sShortName,
                        aClassType.getPackageName (),
                        aClassType.getClassName (),
                        bPrimitive,
                        bPredefined,
                        bImmutable,
                        bSerializable,
                        bIsEnum,
                        aSpecialTVC);
  }

  @Nonnull
  public static JDMType createClassType (@Nonnull final String sPackageName,
                                         @Nonnull @Nonempty final String sLocalClassName,
                                         final boolean bPredefined,
                                         final boolean bImmutable,
                                         final boolean bSerializable,
                                         final boolean bIsEnum,
                                         @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    ValueEnforcer.notNull (sPackageName, "PackageName");
    ValueEnforcer.notEmpty (sLocalClassName, "LocalClassName");
    ValueEnforcer.isTrue (sLocalClassName.indexOf ('.') < 0, "LocalClassName may not contain a dot");
    ValueEnforcer.notNull (aTestValueFactory, "TestValueFactory");

    final boolean bPrimitive = false;
    return new JDMType (sLocalClassName,
                        sPackageName,
                        sLocalClassName,
                        bPrimitive,
                        bPredefined,
                        bImmutable,
                        bSerializable,
                        bIsEnum,
                        aTestValueFactory);
  }

  @Nonnull
  static JDMType createPredefinedClassTypeImmutable (@Nonnull final Class <?> aClass,
                                                     @Nonnull final IJDMTypeTestValueCreator aTestValueFactory)
  {
    final boolean bPredefined = true;
    final boolean bImmutable = true;
    final boolean bSerializable = Serializable.class.isAssignableFrom (aClass);
    final boolean bIsEnum = Enum.class.isAssignableFrom (aClass);
    return createClassType (aClass.getPackage ().getName (),
                            ClassHelper.getClassLocalName (aClass),
                            bPredefined,
                            bImmutable,
                            bSerializable,
                            bIsEnum,
                            aTestValueFactory);
  }
}
