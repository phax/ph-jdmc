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
package com.helger.jdmc.core;

import java.io.File;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.io.file.FilenameHelper;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.lang.GenericReflection;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JJavaName;
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMBaseType;
import com.helger.jdmc.core.datamodel.EJDMConstraintType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.IJDMTypeResolver;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMConstraint;
import com.helger.jdmc.core.datamodel.JDMContext;
import com.helger.jdmc.core.datamodel.JDMEnum;
import com.helger.jdmc.core.datamodel.JDMEnumConstant;
import com.helger.jdmc.core.datamodel.JDMField;
import com.helger.jdmc.core.datamodel.JDMType;
import com.helger.json.IJson;
import com.helger.json.IJsonArray;
import com.helger.json.IJsonObject;
import com.helger.json.IJsonValue;
import com.helger.json.parser.handler.CollectingJsonParserHandler;
import com.helger.json.serialize.JsonReader;

@NotThreadSafe
public class JDMProcessor implements IJDMTypeResolver
{
  private static final Logger LOGGER = LoggerFactory.getLogger (JDMProcessor.class);

  private final String m_sDestinationPackageName;
  private Charset m_aSourceCharset = StandardCharsets.UTF_8;
  private String m_sClassNamePrefix = null;
  private String m_sClassNameSuffix = null;
  private final JDMContext m_aContext = new JDMContext ();
  private final ICommonsList <AbstractJDMClassType> m_aTypes = new CommonsArrayList <> ();

  public JDMProcessor (@Nonnull final String sDestinationPackageName)
  {
    ValueEnforcer.notNull (sDestinationPackageName, "DestinationPackageName");
    m_sDestinationPackageName = sDestinationPackageName;
  }

  @Nonnull
  public final String getDestinationPackageName ()
  {
    return m_sDestinationPackageName;
  }

  @Nonnull
  public final Charset getSourceCharset ()
  {
    return m_aSourceCharset;
  }

  @Nonnull
  public final JDMProcessor setSourceCharset (@Nonnull final Charset aSourceCharset)
  {
    ValueEnforcer.notNull (aSourceCharset, "Charset");
    m_aSourceCharset = aSourceCharset;
    return this;
  }

  @Nullable
  public final String getClassNamePrefix ()
  {
    return m_sClassNamePrefix;
  }

  @Nonnull
  public final JDMProcessor setClassNamePrefix (@Nullable final String sClassNamePrefix)
  {
    m_sClassNamePrefix = sClassNamePrefix;
    return this;
  }

  @Nullable
  public final String getClassNameSuffix ()
  {
    return m_sClassNameSuffix;
  }

  @Nonnull
  public final JDMProcessor setClassNameSuffix (@Nullable final String sClassNameSuffix)
  {
    m_sClassNameSuffix = sClassNameSuffix;
    return this;
  }

  @Nonnull
  public final JDMContext getContext ()
  {
    return m_aContext;
  }

  public static boolean isValidIdentifier (@Nonnull @Nonempty final String s)
  {
    if (!RegExHelper.getAsIdentifier (s).equals (s))
    {
      // Contains illegal chars
      return false;
    }
    if (!JJavaName.isJavaIdentifier (s))
    {
      // It's a reserved name or it contains illegal chars
      return false;
    }
    return true;
  }

  @Nullable
  private IJsonObject _parseJson (@Nonnull final File aSrcFile, @Nonnull final Consumer <? super String> aErrorHdl)
  {
    if (LOGGER.isInfoEnabled ())
      LOGGER.info ("Parsing JSON '" + aSrcFile.getAbsolutePath () + "'");

    final CollectingJsonParserHandler aHandler = new CollectingJsonParserHandler ();
    JsonReader.parseJson (new FileSystemResource (aSrcFile).getReader (m_aSourceCharset), aHandler, x -> {
      x.setTrackPosition (true);
    }, ex -> aErrorHdl.accept (ex.getMessage ()));
    final IJson aJson = aHandler.getJson ();
    if (aJson == null)
    {
      aErrorHdl.accept ("Failed to parse JSON");
      return null;
    }

    if (!aJson.isObject ())
    {
      aErrorHdl.accept ("Parsed JSON is not an object");
      return null;
    }

    return aJson.getAsObject ();
  }

  @Nonnull
  private String _getAdoptedTypeName (@Nonnull final String sTypeName)
  {
    String ret = sTypeName;
    if (StringHelper.hasText (m_sClassNamePrefix))
      ret = m_sClassNamePrefix + ret;
    if (StringHelper.hasText (m_sClassNameSuffix))
      ret = ret + m_sClassNameSuffix;
    return ret;
  }

  private void _handleClassTypeSettings (@Nonnull final AbstractJDMClassType aType,
                                         @Nonnull final IJson aFieldDef,
                                         @Nonnull final Consumer <? super String> aErrorHdl)
  {
    if (!aFieldDef.isObject ())
      aErrorHdl.accept ("The per-type configuration must be an object");
    else
      for (final Map.Entry <String, IJson> aEntry : aFieldDef.getAsObject ())
      {
        final String sKey = aEntry.getKey ();
        final IJson aValue = aEntry.getValue ();
        if ("createManager".equals (sKey))
        {
          if (aValue.isValue ())
            aType.settings ().setCreateManager (aValue.getAsValue ().getAsBoolean ());
          else
            aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
        }
        else
          if ("businessObject".equals (sKey))
          {
            if (aValue.isValue ())
              aType.settings ().setUseBusinessObjects (aValue.getAsValue ().getAsBoolean ());
            else
              aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
          }
          else
            if ("setterArePackagePrivate".equals (sKey))
            {
              if (aValue.isValue ())
                aType.settings ().setSetterArePackagePrivate (aValue.getAsValue ().getAsBoolean ());
              else
                aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
            }
            else
              aErrorHdl.accept ("The configuration property '" + sKey + "' is unknown");
      }
  }

  @Nullable
  public JDMClass readClassDef (@Nonnull final File aSrcFile)
  {
    return readClassDef (aSrcFile, LOGGER::error);
  }

  @Nullable
  public JDMClass readClassDef (@Nonnull final File aSrcFile, @Nonnull final Consumer <? super String> aErrorHdl)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

    // Basic parsing
    final IJsonObject aJsonObj = _parseJson (aSrcFile, aErrorHdl);
    if (aJsonObj == null)
      return null;

    // Build class
    final String sLocalClassName = _getAdoptedTypeName (FilenameHelper.getBaseName (aSrcFile));
    final JDMClass ret = new JDMClass (m_sDestinationPackageName, sLocalClassName);

    // Read all fields
    for (final Map.Entry <String, IJson> aFieldEntry : aJsonObj)
    {
      final String sFieldName = aFieldEntry.getKey ();
      final IJson aFieldDef = aFieldEntry.getValue ();

      if (StringHelper.hasNoText (sFieldName))
      {
        aErrorHdl.accept ("The field name may not be empty");
        return null;
      }
      if ("$settings".equals (sFieldName))
      {
        _handleClassTypeSettings (ret, aFieldDef, aErrorHdl);
        continue;
      }
      if (!isValidIdentifier (sFieldName))
      {
        aErrorHdl.accept ("The field name '" + sFieldName + "' is not a valid identifier");
        return null;
      }
      if (ret.fields ().containsAny (x -> x.getFieldName ().equals (sFieldName)))
      {
        aErrorHdl.accept ("Another field with name '" + sFieldName + "' is already present");
        return null;
      }

      final String sTypeName;
      final String sComment;
      final IJsonObject aJsonConstraints;
      if (aFieldDef.isValue ())
      {
        // type
        final IJsonValue aValue = aFieldDef.getAsValue ();
        sTypeName = aValue.getAsString ();
        sComment = null;
        aJsonConstraints = null;
      }
      else
        if (aFieldDef.isArray ())
        {
          // [type] or
          // [type, constraints] or
          // [type, comment, constraints]
          final IJsonArray aArray = aFieldDef.getAsArray ();
          sTypeName = aArray.getAsString (0);
          final IJson aSecond = aArray.get (1);
          if (aSecond == null)
          {
            sComment = null;
            aJsonConstraints = null;
          }
          else
            if (aSecond.isValue ())
            {
              sComment = aSecond.getAsValue ().getAsString ();
              aJsonConstraints = aArray.getObjectAtIndex (2);
            }
            else
              if (aSecond.isObject ())
              {
                sComment = null;
                aJsonConstraints = aSecond.getAsObject ();
              }
              else
              {
                aErrorHdl.accept ("The field definition of '" + sFieldName + "' is inconsistent");
                return null;
              }

        }
        else
        {
          aErrorHdl.accept ("The field definition of '" + sFieldName + "' is neither a value nor an array");
          return null;
        }

      // Check for +/?/* suffixes
      final EJDMMultiplicity eMultiplicity = EJDMMultiplicity.getFromTypeName (sTypeName);
      final String sEffectiveTypeName = sTypeName.substring (0,
                                                             sTypeName.length () -
                                                                eMultiplicity.getSuffix ().length ());
      if (StringHelper.hasNoText (sEffectiveTypeName))
      {
        aErrorHdl.accept ("The field definition of '" + sFieldName + "' has no typename");
        return null;
      }
      JDMType aType = m_aContext.types ().findType (sEffectiveTypeName);
      if (aType == null)
      {
        // Is the type part of the compilation?
        aType = m_aContext.types ().findType (_getAdoptedTypeName (sEffectiveTypeName));
        if (aType == null)
        {
          // Is the type part of the compilation?
          aType = m_aContext.types ().findType (_getAdoptedEnumName (sEffectiveTypeName));
        }
      }
      if (aType == null)
      {
        aErrorHdl.accept ("The typename '" + sEffectiveTypeName + "' is unknown");
        return null;
      }

      ICommonsList <JDMConstraint> aConstraints = null;
      if (aJsonConstraints != null && aJsonConstraints.isNotEmpty ())
      {
        aConstraints = new CommonsArrayList <> ();
        final EJDMBaseType eFieldBaseType = aType.getBaseType ();
        for (final Map.Entry <String, IJson> aConstraintEntry : aJsonConstraints)
        {
          final String sConstraintName = aConstraintEntry.getKey ();
          final IJson aConstraintDef = aConstraintEntry.getValue ();

          // Resolve constraint type
          final EJDMConstraintType eConstraintType = EJDMConstraintType.getFromIDOrNull (sConstraintName);
          if (eConstraintType == null)
          {
            aErrorHdl.accept ("Field '" + sFieldName + "' defines unknown constraint '" + sConstraintName + "'");
            return null;
          }
          if (!eConstraintType.isApplicableOn (eFieldBaseType))
          {
            aErrorHdl.accept ("Field '" +
                              sFieldName +
                              "' defines constraint '" +
                              sConstraintName +
                              "' which cannot be applied on the underlying type '" +
                              sTypeName +
                              "'");
            return null;
          }

          // Single or multi value constraint?
          final IJson aConstraintDataElement;
          // Single constraint value
          if (aConstraintDef.isValue ())
            aConstraintDataElement = aConstraintDef.getAsValue ();
          else
          {
            aErrorHdl.accept ("Field '" +
                              sFieldName +
                              "' defines constraint '" +
                              sConstraintName +
                              "' which requires a single value");
            return null;
          }

          // Determine the base type of the constraint elements
          EJDMBaseType eConstraintElementType;
          boolean bConvert = false;
          switch (eConstraintType.getConstraintDataType ())
          {
            case DEPENDS_SINGLE_VALUE:
              if (eFieldBaseType.isString () || eFieldBaseType.isNumeric ())
                eConstraintElementType = eFieldBaseType;
              else
              {
                // Fallback: String
                eConstraintElementType = EJDMBaseType.STRING;
                bConvert = true;
              }
              break;
            case INT_GE0:
            case INT_GT0:
              eConstraintElementType = EJDMBaseType.INTEGER;
              break;
            case STRING:
              eConstraintElementType = EJDMBaseType.STRING;
              break;
            default:
              throw new IllegalStateException ("Internal error");
          }
          assert eConstraintElementType == EJDMBaseType.STRING ||
                 eConstraintElementType == EJDMBaseType.INTEGER ||
                 eConstraintElementType == EJDMBaseType.DOUBLE;

          // Read all values
          final Serializable aValue;
          switch (eConstraintElementType)
          {
            case STRING:
            {
              if (bConvert)
              {
                final Class <?> aTargetClass = GenericReflection.getClassFromNameSafe (aType.getFQCN ());
                if (aTargetClass == null)
                {
                  aErrorHdl.accept ("Field '" +
                                    sFieldName +
                                    "' defines constraint '" +
                                    sConstraintName +
                                    "' with illegal type '" +
                                    aType.getFQCN () +
                                    "'");
                  return null;
                }
                aValue = (Serializable) aConstraintDataElement.getAsValue ().getConvertedValue (aTargetClass);
              }
              else
              {
                // Simple values
                aValue = aConstraintDataElement.getAsValue ().getAsString ();
              }
              break;
            }
            case INTEGER:
              aValue = aConstraintDataElement.getAsValue ().getAsBigInteger ();
              break;
            case DOUBLE:
              aValue = aConstraintDataElement.getAsValue ().getAsBigDecimal ();
              break;
            default:
              throw new IllegalStateException ("Internal inconsistency");
          }
          aConstraints.add (new JDMConstraint (eConstraintType, aValue));
        }
      }

      // Add the field with all constraints
      ret.fields ().add (new JDMField (sFieldName, aType, eMultiplicity, sComment, aConstraints));
    }

    if (false)
      if (ret.fields ().isEmpty ())
      {
        aErrorHdl.accept ("No fields found");
        return null;
      }

    // Upon success, register this type
    m_aContext.types ().registerType (ret, (cm, cs) -> {
      JInvocation aNew = cm.ref (ret.getFQClassName ())._new ();
      for (final JDMField aField : ret.fields ())
      {
        IJExpression aTestVal = aField.getType ().createTestValue (cm, cs);
        if (aField.getMultiplicity ().isOpenEnded ())
          aTestVal = cm.ref (CommonsArrayList.class).narrowEmpty ()._new ().arg (aTestVal);
        aNew = aNew.arg (aTestVal);
      }
      return aNew;
    });
    m_aTypes.add (ret);

    return ret;
  }

  @Nonnull
  private String _getAdoptedEnumName (@Nonnull final String sTypeName)
  {
    String ret = sTypeName;
    if (ret.length () >= 2 && ret.charAt (0) == 'E' && Character.isUpperCase (ret.charAt (1)))
    {
      // Cut leading "E" from "EType" but not from "Example"
      ret = ret.substring (1);
    }
    return "E" + _getAdoptedTypeName (ret);
  }

  @Nullable
  public JDMEnum readEnumDef (@Nonnull final File aSrcFile)
  {
    return readEnumDef (aSrcFile, LOGGER::error);
  }

  @Nullable
  public JDMEnum readEnumDef (@Nonnull final File aSrcFile, @Nonnull final Consumer <? super String> aErrorHdl)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

    final IJsonObject aJsonObj = _parseJson (aSrcFile, aErrorHdl);
    if (aJsonObj == null)
      return null;

    // Build class
    final String sLocalClassName = _getAdoptedEnumName (FilenameHelper.getBaseName (aSrcFile));
    final JDMEnum ret = new JDMEnum (m_sDestinationPackageName, sLocalClassName);

    // Read all enum entries
    for (final Map.Entry <String, IJson> aFieldEntry : aJsonObj)
    {
      final String sEnumConstantName = aFieldEntry.getKey ();
      final IJson aEnumDef = aFieldEntry.getValue ();

      if (StringHelper.hasNoText (sEnumConstantName))
      {
        aErrorHdl.accept ("The enum constant name may not be empty");
        return null;
      }
      if ("$settings".equals (sEnumConstantName))
      {
        _handleClassTypeSettings (ret, aEnumDef, aErrorHdl);
        continue;
      }
      if (!isValidIdentifier (sEnumConstantName))
      {
        aErrorHdl.accept ("The enum constant name '" + sEnumConstantName + "' is not a valid identifier");
        return null;
      }
      if (ret.enumConstants ().containsAny (x -> x.getName ().equals (sEnumConstantName)))
      {
        aErrorHdl.accept ("Another enum constant with name '" + sEnumConstantName + "' is already present");
        return null;
      }

      String sID;
      String sDisplayName;
      final String sComment;
      if (aEnumDef.isValue ())
      {
        // ID
        final IJsonValue aValue = aEnumDef.getAsValue ();
        sID = aValue.getAsString ();
        sDisplayName = null;
        sComment = null;
      }
      else
        if (aEnumDef.isArray ())
        {
          // [ID] or
          // [ID, DisplayName] or
          // [ID, DisplayName, Comment]
          final IJsonArray aArray = aEnumDef.getAsArray ();
          sID = aArray.getAsString (0);
          final IJson aSecond = aArray.get (1);
          final IJson aThird = aArray.get (2);
          if (aSecond == null)
            sDisplayName = null;
          else
            if (aSecond.isValue ())
              sDisplayName = aSecond.getAsValue ().getAsString ();
            else
            {
              aErrorHdl.accept ("The enum constant definition of '" +
                                sEnumConstantName +
                                "' is inconsistent (display name)");
              return null;
            }
          if (aThird == null)
            sComment = null;
          else
            if (aThird.isValue ())
              sComment = aThird.getAsValue ().getAsString ();
            else
            {
              aErrorHdl.accept ("The enum constant definition of '" +
                                sEnumConstantName +
                                "' is inconsistent (comment)");
              return null;
            }
        }
        else
        {
          aErrorHdl.accept ("The enum constant definition of '" +
                            sEnumConstantName +
                            "' is neither a value nor an array");
          return null;
        }

      if (sID == null)
        sID = sEnumConstantName;
      if (sDisplayName == null)
        sDisplayName = sID;

      // Add the field with all constraints
      ret.enumConstants ().add (new JDMEnumConstant (sEnumConstantName, sID, sDisplayName, sComment));
    }
    if (ret.enumConstants ().isEmpty ())
    {
      aErrorHdl.accept ("No enum constant found");
      return null;
    }

    // Upon success, register this type
    m_aContext.types ()
              .registerType (ret,
                             (cm, cs) -> cm.ref (ret.getFQClassName ())
                                           .staticRef (ret.enumConstants ().getFirst ().getName ()));
    m_aTypes.add (ret);

    return ret;
  }

  @Nonnull
  public ICommonsList <AbstractJDMClassType> getAllTypes ()
  {
    return m_aTypes.getClone ();
  }

  @Nullable
  public AbstractJDMClassType findTypeByName (@Nonnull final String sFQCN)
  {
    return m_aTypes.findFirst (x -> x.getFQClassName ().equals (sFQCN));
  }

  @Nonnull
  @ReturnsMutableCopy
  public ICommonsList <JDMClass> getAllReadClasses ()
  {
    return CommonsArrayList.createFiltered (m_aTypes,
                                            x -> x instanceof JDMClass,
                                            (Function <AbstractJDMClassType, JDMClass>) x -> (JDMClass) x);
  }

  @Nonnull
  @ReturnsMutableCopy
  public ICommonsList <JDMEnum> getAllReadEnums ()
  {
    return CommonsArrayList.createFiltered (m_aTypes,
                                            x -> x instanceof JDMEnum,
                                            (Function <AbstractJDMClassType, JDMEnum>) x -> (JDMEnum) x);
  }
}
