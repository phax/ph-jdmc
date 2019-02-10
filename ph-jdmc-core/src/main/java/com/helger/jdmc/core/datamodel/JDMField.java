/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
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
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.JCommentPart;

/**
 * Single field.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMField implements Serializable
{
  private final String m_sOriginalFieldName;
  private final String m_sFieldName;
  private final JDMType m_aType;
  private final EJDMMultiplicity m_eMultiplicity;
  private final String m_sComment;
  private final ICommonsList <JDMConstraint> m_aConstraints;

  @Nonnull
  @Nonempty
  private static String _getCleanedName (@Nonnull @Nonempty final String sStr)
  {
    // replace "_x" with "X"
    String s = sStr;
    while (true)
    {
      final int i = s.indexOf ('_');
      if (i < 0 || i == s.length () - 1)
        break;
      final char cNext = s.charAt (i + 1);
      if (Character.isLowerCase (cNext))
      {
        // "_x" => "X"
        s = s.substring (0, i) + Character.toUpperCase (cNext) + s.substring (i + 2);
      }
      else
      {
        // Cut "_"
        s = s.substring (0, i) + s.substring (i + 1);
      }
    }
    return s;
  }

  @Nonnull
  private static String _getStartUC (@Nonnull final String s)
  {
    // According to JavaBeans standard
    // Thus "fooBah" becomes "FooBah" and "x" becomes "X", but "URL" stays as it
    // is
    if (s.length () == 0)
      return s;
    if (s.length () > 1 && Character.isUpperCase (s.charAt (1)) && Character.isUpperCase (s.charAt (0)))
      return s;
    final char [] chars = s.toCharArray ();
    chars[0] = Character.toUpperCase (chars[0]);
    return new String (chars);
  }

  @Nonnull
  private static String _getStartLC (@Nonnull final String s)
  {
    // According to JavaBeans standard
    // Thus "FooBah" becomes "fooBah" and "X" becomes "x", but "URL" stays as it
    // is
    if (s.length () == 0)
      return s;
    if (s.length () > 1 && Character.isUpperCase (s.charAt (1)) && Character.isUpperCase (s.charAt (0)))
      return s;
    final char [] chars = s.toCharArray ();
    chars[0] = Character.toLowerCase (chars[0]);
    return new String (chars);
  }

  /**
   * Constructor
   *
   * @param sFieldName
   *        Original field name. May neither be <code>null</code> nor empty.
   * @param aType
   *        The type to use. Either one of the predefined types or a created
   *        type.
   * @param eMultiplicity
   *        Multiplicity of the field. May not be <code>null</code>.
   * @param sComment
   *        Optional textual comment of the field. May be <code>null</code>.
   * @param aConstraints
   *        Optional list of field constraints. May be <code>null</code>.
   */
  public JDMField (@Nonnull @Nonempty final String sFieldName,
                   @Nonnull final JDMType aType,
                   @Nonnull final EJDMMultiplicity eMultiplicity,
                   @Nullable final String sComment,
                   @Nullable final ICommonsList <JDMConstraint> aConstraints)
  {
    ValueEnforcer.notEmpty (sFieldName, "FieldName");
    ValueEnforcer.notNull (aType, "Type");
    ValueEnforcer.notNull (eMultiplicity, "Multiplicity");
    m_sOriginalFieldName = sFieldName;
    m_sFieldName = _getCleanedName (sFieldName);
    m_aType = aType;
    m_eMultiplicity = eMultiplicity;
    m_sComment = sComment;
    m_aConstraints = new CommonsArrayList <> (aConstraints);
  }

  /**
   * @return The original field name with all "_" contained.
   */
  @Nonnull
  @Nonempty
  public String getOriginalFieldName ()
  {
    return m_sOriginalFieldName;
  }

  /**
   * @return The cleaned field name without any "_" contained.
   */
  @Nonnull
  @Nonempty
  public String getFieldName ()
  {
    return m_sFieldName;
  }

  @Nonnull
  @Nonempty
  public String getMethodGetterName (final boolean bIsOpenEnded)
  {
    if (bIsOpenEnded)
    {
      // Lists have names likes "name()"
      return _getStartLC (m_sFieldName);
    }

    return (m_aType.getBaseType ().isBoolean () ? "is" : "get") + _getStartUC (m_sFieldName);
  }

  @Nonnull
  @Nonempty
  public String getMethodHasName ()
  {
    return "has" + _getStartUC (m_sFieldName);
  }

  @Nonnull
  @Nonempty
  public String getMethodSetterName ()
  {
    return "set" + _getStartUC (m_sFieldName);
  }

  @Nonnull
  @Nonempty
  public String getJavaVarName (@Nonnull final EJDMMultiplicity eMultiplicity)
  {
    final char cPrefix;
    if (eMultiplicity.isOpenEnded ())
      cPrefix = 'a';
    else
      cPrefix = m_aType.isEnum () ? 'e'
                                  : m_aType.isJavaPrimitive (eMultiplicity) ||
                                    m_aType.getBaseType ().isString () ? m_aType.getBaseType ().getPrefix () : 'a';
    return cPrefix + _getStartUC (m_sFieldName);
  }

  @Nonnull
  @Nonempty
  public String getJavaMemberName (@Nonnull final EJDMMultiplicity eMultiplicity)
  {
    return "m_" + getJavaVarName (eMultiplicity);
  }

  @Nonnull
  @Nonempty
  public String getJavaStaticName (@Nonnull final EJDMMultiplicity eMultiplicity)
  {
    return "s_" + getJavaVarName (eMultiplicity);
  }

  /**
   * @return The type of the field. Never <code>null</code>.
   */
  @Nonnull
  public JDMType getType ()
  {
    return m_aType;
  }

  @Nonnull
  public EJDMMultiplicity getMultiplicity ()
  {
    return m_eMultiplicity;
  }

  @Nullable
  public String getComment ()
  {
    return m_sComment;
  }

  @Nonnull
  public String getJavaDocSuffix ()
  {
    final String sSuffix;
    if (m_aType.isJavaPrimitive (m_eMultiplicity))
      sSuffix = "";
    else
    {
      if (m_eMultiplicity == EJDMMultiplicity.OPTIONAL)
        sSuffix = " May be <code>null</code>.";
      else
      {
        if (m_eMultiplicity == EJDMMultiplicity.MANDATORY_OR_MORE)
          sSuffix = " May neither be <code>null</code> nor empty.";
        else
          sSuffix = " May not be <code>null</code>.";
      }
    }
    return sSuffix;
  }

  @Nonnull
  public String getParamJavaDoc ()
  {
    final String sBase;
    if (StringHelper.hasNoText (m_sComment))
      sBase = m_aType.getClassName () + " value.";
    else
      if (m_sComment.endsWith ("."))
        sBase = m_sComment;
      else
        sBase = m_sComment + ".";

    return JCommentPart.getHTMLEscaped (sBase) + getJavaDocSuffix ();
  }

  public boolean hasComment ()
  {
    return StringHelper.hasText (m_sComment);
  }

  @Nonnull
  @ReturnsMutableObject
  public ICommonsList <JDMConstraint> constraints ()
  {
    return m_aConstraints;
  }
}
