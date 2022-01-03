/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
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
import com.helger.commons.collection.impl.CommonsHashMap;
import com.helger.commons.collection.impl.CommonsLinkedHashMap;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.collection.impl.ICommonsMap;
import com.helger.commons.collection.impl.ICommonsOrderedMap;
import com.helger.commons.io.file.FilenameHelper;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.lang.GenericReflection;
import com.helger.commons.mutable.MutableInt;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JInvocation;
import com.helger.jcodemodel.JJavaName;
import com.helger.jdmc.core.datamodel.AbstractJDMGenType;
import com.helger.jdmc.core.datamodel.EJDMBaseType;
import com.helger.jdmc.core.datamodel.EJDMConstraintType;
import com.helger.jdmc.core.datamodel.EJDMDefinitionType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.IJDMGenTypeResolver;
import com.helger.jdmc.core.datamodel.JDMContext;
import com.helger.jdmc.core.datamodel.JDMGenClass;
import com.helger.jdmc.core.datamodel.JDMGenConstraint;
import com.helger.jdmc.core.datamodel.JDMGenEnum;
import com.helger.jdmc.core.datamodel.JDMGenEnumConstant;
import com.helger.jdmc.core.datamodel.JDMGenField;
import com.helger.jdmc.core.datamodel.JDMType;
import com.helger.json.IJson;
import com.helger.json.IJsonArray;
import com.helger.json.IJsonObject;
import com.helger.json.IJsonValue;
import com.helger.json.parser.handler.CollectingJsonParserHandler;
import com.helger.json.serialize.JsonReader;

@NotThreadSafe
public class JDMProcessor implements IJDMGenTypeResolver
{
  private static final Logger LOGGER = LoggerFactory.getLogger (JDMProcessor.class);

  private final String m_sDestinationPackageName;
  private Charset m_aSourceCharset = StandardCharsets.UTF_8;
  private String m_sClassNamePrefix = null;
  private String m_sClassNameSuffix = null;
  private Consumer <? super String> m_aDefaultInfoHdl = LOGGER::info;
  private Consumer <? super String> m_aDefaultErrorHdl = LOGGER::error;
  private final JDMContext m_aContext = new JDMContext ();
  private final ICommonsList <AbstractJDMGenType> m_aReadTypes = new CommonsArrayList <> ();

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
  public Consumer <? super String> getDefaultInfoHdl ()
  {
    return m_aDefaultInfoHdl;
  }

  @Nonnull
  public JDMProcessor setDefaultInfoHdl (@Nonnull final Consumer <? super String> aDefaultInfoHdl)
  {
    ValueEnforcer.notNull (aDefaultInfoHdl, "DefaultInfoHdl");
    m_aDefaultInfoHdl = aDefaultInfoHdl;
    return this;
  }

  @Nonnull
  public Consumer <? super String> getDefaultErrorHdl ()
  {
    return m_aDefaultErrorHdl;
  }

  @Nonnull
  public JDMProcessor setDefaultErrorHdl (@Nonnull final Consumer <? super String> aDefaultErrorHdl)
  {
    ValueEnforcer.notNull (aDefaultErrorHdl, "DefaultErrorHdl");
    m_aDefaultErrorHdl = aDefaultErrorHdl;
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
  private IJsonObject _parseJson (@Nonnull final File aSrcFile,
                                  @Nonnull final Consumer <? super String> aInfoHdl,
                                  @Nonnull final Consumer <? super String> aErrorHdl)
  {
    aInfoHdl.accept ("Parsing JSON '" + aSrcFile.getAbsolutePath () + "'");

    final CollectingJsonParserHandler aHandler = new CollectingJsonParserHandler ();
    JsonReader.parseJson (new FileSystemResource (aSrcFile).getReader (m_aSourceCharset),
                          aHandler,
                          x -> x.setTrackPosition (true),
                          ex -> aErrorHdl.accept (ex.getMessage ()));
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

  private static interface ISettingsCommand
  {
    void applyCommand (@Nonnull AbstractJDMGenType aType,
                       @Nonnull String sKey,
                       @Nonnull IJson aValue,
                       @Nonnull Consumer <? super String> aErrorHdl);
  }

  private static ICommonsMap <String, ISettingsCommand> TYPE_COMMANDS = new CommonsHashMap <> ();
  static
  {
    TYPE_COMMANDS.put ("businessObject", (aType, sKey, aValue, aErrorHdl) -> {
      if (aValue.isValue ())
        aType.settings ().setUseBusinessObjects (aValue.getAsValue ().getAsBoolean ());
      else
        aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
    });
    TYPE_COMMANDS.put ("setterArePackagePrivate", (aType, sKey, aValue, aErrorHdl) -> {
      if (aValue.isValue ())
        aType.settings ().setSetterArePackagePrivate (aValue.getAsValue ().getAsBoolean ());
      else
        aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
    });
    TYPE_COMMANDS.put ("createMicroTypeConverter", (aType, sKey, aValue, aErrorHdl) -> {
      if (aValue.isValue ())
        aType.settings ().setCreateMicroTypeConverter (aValue.getAsValue ().getAsBoolean ());
      else
        aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
    });
    TYPE_COMMANDS.put ("createManager", (aType, sKey, aValue, aErrorHdl) -> {
      if (aValue.isValue ())
        aType.settings ().setCreateManager (aValue.getAsValue ().getAsBoolean ());
      else
        aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
    });
  }

  private static void _handleGenTypeSettings (@Nonnull final AbstractJDMGenType aType,
                                              @Nonnull final IJson aFieldDef,
                                              @Nonnull final Consumer <? super String> aErrorHdl)
  {
    if (!aFieldDef.isObject ())
      aErrorHdl.accept ("The per-type configuration must be an object");
    else
      for (final Map.Entry <String, IJson> aEntry : aFieldDef.getAsObject ())
      {
        final String sKey = aEntry.getKey ();
        final ISettingsCommand aHdl = TYPE_COMMANDS.get (sKey);
        if (aHdl != null)
          aHdl.applyCommand (aType, sKey, aEntry.getValue (), aErrorHdl);
        else
          aErrorHdl.accept ("The configuration property '" + sKey + "' is unknown");
      }
  }

  private static void _handleGenFieldSettings (@Nonnull final JDMGenField aField,
                                               @Nonnull final IJsonObject aFieldDef,
                                               @Nonnull final Consumer <? super String> aErrorHdl)
  {
    for (final Map.Entry <String, IJson> aEntry : aFieldDef)
    {
      final String sKey = aEntry.getKey ();
      final IJson aValue = aEntry.getValue ();
      if ("businessObjectReference".equals (sKey))
      {
        if (aValue.isValue ())
          aField.settings ().setBOReference (aValue.getAsValue ().getAsBoolean ());
        else
          aErrorHdl.accept ("The configuration property '" + sKey + "' requires a JSON value");
      }
      else
        aErrorHdl.accept ("The configuration property '" + sKey + "' is unknown");
    }
  }

  @Nullable
  public JDMGenClass readClassDef (@Nonnull final File aSrcFile)
  {
    return readClassDef (aSrcFile, m_aDefaultInfoHdl, m_aDefaultErrorHdl);
  }

  @Nullable
  public JDMGenClass readClassDef (@Nonnull final File aSrcFile,
                                   @Nonnull final Consumer <? super String> aInfoHdl,
                                   @Nonnull final Consumer <? super String> aErrorHdl)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

    // Basic parsing
    final IJsonObject aJsonObj = _parseJson (aSrcFile, aInfoHdl, aErrorHdl);
    if (aJsonObj == null)
      return null;

    // Build class
    final String sLocalClassName = _getAdoptedTypeName (FilenameHelper.getBaseName (aSrcFile));
    final JDMGenClass ret = new JDMGenClass (m_sDestinationPackageName, sLocalClassName);

    // register this type before the actual fields, so that "self reference"
    // works. In case of error, this must be undone.
    m_aContext.typeContainer ().registerType (ret, (cm, cs, e) -> {
      JInvocation aNew = cm.ref (ret.getFQClassName ())._new ();
      for (final JDMGenField aField : ret.fields ())
      {
        final boolean bIsSelfRef = aField.getType ().getShortName ().equals (ret.getClassName ());
        IJExpression aTestVal = bIsSelfRef ? JExpr._null () : aField.getType ().createTestValue (cm, cs, aField.getMultiplicity ());
        if (aField.getMultiplicity ().isOpenEnded ())
          aTestVal = cm.ref (CommonsArrayList.class).narrowEmpty ()._new ().arg (aTestVal);
        aNew = aNew.arg (aTestVal);
      }
      return aNew;
    });

    // Read all fields
    boolean bError = false;
    fieldloop: for (final Map.Entry <String, IJson> aFieldEntry : aJsonObj)
    {
      final String sFieldName = aFieldEntry.getKey ();
      final IJson aFieldDef = aFieldEntry.getValue ();

      if (StringHelper.hasNoText (sFieldName))
      {
        aErrorHdl.accept ("The field name may not be empty");
        bError = true;
        break fieldloop;
      }
      if ("$settings".equals (sFieldName))
      {
        _handleGenTypeSettings (ret, aFieldDef, aErrorHdl);
        continue;
      }
      if (!isValidIdentifier (sFieldName))
      {
        aErrorHdl.accept ("The field name '" + sFieldName + "' is not a valid identifier");
        bError = true;
        break fieldloop;
      }
      if (ret.fields ().containsAny (x -> x.getFieldName ().equals (sFieldName)))
      {
        aErrorHdl.accept ("Another field with name '" + sFieldName + "' is already present");
        bError = true;
        break fieldloop;
      }

      final String sTypeName;
      final String sComment;
      final IJsonObject aJsonConstraints;
      final IJsonObject aJsonSettings;
      if (aFieldDef.isValue ())
      {
        // type
        final IJsonValue aValue = aFieldDef.getAsValue ();
        sTypeName = aValue.getAsString ();
        sComment = null;
        aJsonConstraints = null;
        aJsonSettings = null;
      }
      else
        if (aFieldDef.isArray ())
        {
          // [type] or
          // [type, constraints] or
          // [type, constraints, settings] or
          // [type, comment, constraints] or
          // [type, comment, constraints, settings]
          final IJsonArray aArray = aFieldDef.getAsArray ();
          sTypeName = aArray.getAsString (0);
          final IJson aSecond = aArray.get (1);
          if (aSecond == null)
          {
            sComment = null;
            aJsonConstraints = null;
            aJsonSettings = null;
          }
          else
            if (aSecond.isValue ())
            {
              sComment = aSecond.getAsValue ().getAsString ();
              aJsonConstraints = aArray.getObjectAtIndex (2);
              aJsonSettings = aArray.getObjectAtIndex (3);
            }
            else
              if (aSecond.isObject ())
              {
                sComment = null;
                aJsonConstraints = aSecond.getAsObject ();
                aJsonSettings = aArray.getObjectAtIndex (2);
              }
              else
              {
                aErrorHdl.accept ("The field definition of '" + sFieldName + "' is inconsistent");
                bError = true;
                break fieldloop;
              }
        }
        else
        {
          // Read from JSON Object
          final IJsonObject aObject = aFieldDef.getAsObject ();
          sTypeName = aObject.getAsString ("type");
          sComment = aObject.getAsString ("comment");
          aJsonConstraints = aObject.getAsObject ("constraints");
          aJsonSettings = aObject.getAsObject ("settings");
        }

      // Check for +/?/* suffixes for multiplicity
      final EJDMMultiplicity eMultiplicity = EJDMMultiplicity.getFromTypeName (sTypeName);
      final String sEffectiveTypeName = sTypeName.substring (0, sTypeName.length () - eMultiplicity.getSuffix ().length ());
      if (StringHelper.hasNoText (sEffectiveTypeName))
      {
        // The type name consists only of the multiplicity suffix :D
        aErrorHdl.accept ("The field definition of '" + sFieldName + "' has no typename");
        bError = true;
        break fieldloop;
      }

      // Try to resolve the type name
      JDMType aType = m_aContext.typeContainer ().findType (sEffectiveTypeName);
      if (aType == null)
      {
        // Is the type part of the compilation?
        aType = m_aContext.typeContainer ().findType (_getAdoptedTypeName (sEffectiveTypeName));
        if (aType == null)
        {
          // Is the type part of the compilation?
          aType = m_aContext.typeContainer ().findType (_getAdoptedEnumName (sEffectiveTypeName));
        }
      }
      if (aType == null)
      {
        aErrorHdl.accept ("The typename '" + sEffectiveTypeName + "' is unknown");
        bError = true;
        break fieldloop;
      }

      // Determine the constraints
      ICommonsList <JDMGenConstraint> aConstraints = null;
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
            bError = true;
            break fieldloop;
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
            bError = true;
            break fieldloop;
          }

          // Single or multi value constraint?
          final IJson aConstraintDataElement;
          // Single constraint value
          if (aConstraintDef.isValue ())
            aConstraintDataElement = aConstraintDef.getAsValue ();
          else
          {
            aErrorHdl.accept ("Field '" + sFieldName + "' defines constraint '" + sConstraintName + "' which requires a single value");
            bError = true;
            break fieldloop;
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
                  bError = true;
                  break fieldloop;
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
          aConstraints.add (new JDMGenConstraint (eConstraintType, aValue));
        }
      }

      // Create the field
      final JDMGenField aGenField = new JDMGenField (sFieldName, aType, eMultiplicity, sComment, aConstraints);
      if (aJsonSettings != null && aJsonSettings.isNotEmpty ())
      {
        // Add settings
        _handleGenFieldSettings (aGenField, aJsonSettings, aErrorHdl);
      }

      // Add to the type
      ret.fields ().add (aGenField);
    }

    if (bError)
    {
      // Undo initial adding
      m_aContext.typeContainer ().unregisterType (ret);
      return null;
    }

    // Empty classes are okay
    if (false)
      if (ret.fields ().isEmpty ())
      {
        aErrorHdl.accept ("No fields found");
        return null;
      }

    // Register as read at the end
    m_aReadTypes.add (ret);

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
  public JDMGenEnum readEnumDef (@Nonnull final File aSrcFile)
  {
    return readEnumDef (aSrcFile, m_aDefaultInfoHdl, m_aDefaultErrorHdl);
  }

  @Nullable
  public JDMGenEnum readEnumDef (@Nonnull final File aSrcFile,
                                 @Nonnull final Consumer <? super String> aInfoHdl,
                                 @Nonnull final Consumer <? super String> aErrorHdl)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

    final IJsonObject aJsonObj = _parseJson (aSrcFile, aInfoHdl, aErrorHdl);
    if (aJsonObj == null)
      return null;

    // Build class
    final String sLocalClassName = _getAdoptedEnumName (FilenameHelper.getBaseName (aSrcFile));
    final JDMGenEnum ret = new JDMGenEnum (m_sDestinationPackageName, sLocalClassName);

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
        _handleGenTypeSettings (ret, aEnumDef, aErrorHdl);
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
              aErrorHdl.accept ("The enum constant definition of '" + sEnumConstantName + "' is inconsistent (display name)");
              return null;
            }
          if (aThird == null)
            sComment = null;
          else
            if (aThird.isValue ())
              sComment = aThird.getAsValue ().getAsString ();
            else
            {
              aErrorHdl.accept ("The enum constant definition of '" + sEnumConstantName + "' is inconsistent (comment)");
              return null;
            }
        }
        else
        {
          // It's an object
          final IJsonObject aObject = aEnumDef.getAsObject ();
          sID = aObject.getAsString ("id");
          sDisplayName = aObject.getAsString ("name");
          sComment = aObject.getAsString ("comment");
        }

      if (sID == null)
        sID = sEnumConstantName;
      if (sDisplayName == null)
        sDisplayName = sID;

      // Add the field with all constraints
      ret.enumConstants ().add (new JDMGenEnumConstant (sEnumConstantName, sID, sDisplayName, sComment));
    }
    if (ret.enumConstants ().isEmpty ())
    {
      aErrorHdl.accept ("No enum constant found");
      return null;
    }

    // Upon success, register this type
    m_aContext.typeContainer ()
              .registerType (ret, (cm, cs, e) -> cm.ref (ret.getFQClassName ()).staticRef (ret.enumConstants ().getFirst ().getName ()));
    m_aReadTypes.add (ret);

    return ret;
  }

  @Nonnull
  public ICommonsList <AbstractJDMGenType> getAllTypes ()
  {
    return m_aReadTypes.getClone ();
  }

  @Nullable
  public AbstractJDMGenType findGenTypeByName (@Nonnull final String sFQCN)
  {
    return m_aReadTypes.findFirst (x -> x.getFQClassName ().equals (sFQCN));
  }

  @Nonnull
  @ReturnsMutableCopy
  public ICommonsList <JDMGenClass> getAllReadClasses ()
  {
    return CommonsArrayList.createFiltered (m_aReadTypes,
                                            x -> x instanceof JDMGenClass,
                                            (Function <AbstractJDMGenType, JDMGenClass>) x -> (JDMGenClass) x);
  }

  @Nonnull
  @ReturnsMutableCopy
  public ICommonsList <JDMGenEnum> getAllReadEnums ()
  {
    return CommonsArrayList.createFiltered (m_aReadTypes,
                                            x -> x instanceof JDMGenEnum,
                                            (Function <AbstractJDMGenType, JDMGenEnum>) x -> (JDMGenEnum) x);
  }

  public static interface IMultiReaderErrorHandler
  {
    void onReadError (@Nonnull EJDMDefinitionType eType,
                      @Nonnull File aFile,
                      @Nonnull ICommonsList <String> aInfos,
                      @Nonnull ICommonsList <String> aErrors);
  }

  /**
   * This class ensures the safe reading of multiple class and enum definitions,
   * taking into account the dependencies between each other.
   *
   * @author Philip Helger
   * @since 0.0.4
   */
  @NotThreadSafe
  public final class MultiReader
  {
    private final ICommonsOrderedMap <File, EJDMDefinitionType> m_aDefs = new CommonsLinkedHashMap <> ();
    private final IMultiReaderErrorHandler m_aDefaultErrHdl = (eType, aFile, aInfoMsgs, aErrorMsgs) -> {
      aInfoMsgs.forEach (m_aDefaultInfoHdl);
      aErrorMsgs.forEach (m_aDefaultErrorHdl);
      throw new IllegalStateException ("Failed to read " + eType.getDisplayName () + " '" + aFile.getAbsolutePath () + "'");
    };
    private boolean m_bReading = false;

    @Nonnull
    public MultiReader addEnumDef (@Nonnull final File aFile)
    {
      ValueEnforcer.notNull (aFile, "File");
      ValueEnforcer.isFalse (m_bReading, "Files were already read - cannot add new files");
      if (m_aDefs.containsKey (aFile))
        throw new IllegalArgumentException ("The file '" + aFile.getAbsolutePath () + "' is already part of the list to be read");
      m_aDefs.put (aFile, EJDMDefinitionType.ENUMERATION);
      return this;
    }

    @Nonnull
    public MultiReader addClassDef (@Nonnull final File aFile)
    {
      ValueEnforcer.notNull (aFile, "File");
      ValueEnforcer.isFalse (m_bReading, "Files were already read - cannot add new files");
      if (m_aDefs.containsKey (aFile))
        throw new IllegalArgumentException ("The file '" + aFile.getAbsolutePath () + "' is already part of the list to be read");
      m_aDefs.put (aFile, EJDMDefinitionType.CLASS);
      return this;
    }

    public void readAll ()
    {
      readAll (m_aDefaultErrHdl);
    }

    public void readAll (@Nonnull final IMultiReaderErrorHandler aErrorHdl)
    {
      ValueEnforcer.notNull (aErrorHdl, "ErrorHdl");
      ValueEnforcer.isFalse (m_bReading, "Definitions were already read");

      m_bReading = true;
      final ICommonsList <String> aInfoMsgs = new CommonsArrayList <> ();
      final ICommonsList <String> aErrorMsgs = new CommonsArrayList <> ();

      // Read all enums - no circular dependencies expected
      for (final Map.Entry <File, EJDMDefinitionType> aEntry : m_aDefs.entrySet ())
        if (aEntry.getValue ().equals (EJDMDefinitionType.ENUMERATION))
        {
          final File aFile = aEntry.getKey ();
          aInfoMsgs.clear ();
          aErrorMsgs.clear ();
          final JDMGenEnum aEnumGen = JDMProcessor.this.readEnumDef (aFile, aInfoMsgs::add, aErrorMsgs::add);
          if (aEnumGen == null)
            aErrorHdl.onReadError (EJDMDefinitionType.ENUMERATION, aFile, aInfoMsgs, aErrorMsgs);
        }

      // Read all classes - may have forward references
      final ICommonsOrderedMap <File, MutableInt> aRestClasses = new CommonsLinkedHashMap <> ();
      for (final Map.Entry <File, EJDMDefinitionType> aEntry : m_aDefs.entrySet ())
        if (aEntry.getValue ().equals (EJDMDefinitionType.CLASS))
          aRestClasses.put (aEntry.getKey (), new MutableInt (0));
      final int nMaxCount = aRestClasses.size ();
      while (aRestClasses.isNotEmpty ())
      {
        final File aFile = aRestClasses.getFirstKey ();
        final MutableInt aCount = aRestClasses.remove (aFile);
        aInfoMsgs.clear ();
        aErrorMsgs.clear ();
        final JDMGenClass aClassGen = JDMProcessor.this.readClassDef (aFile, aInfoMsgs::add, aErrorMsgs::add);
        if (aClassGen == null)
        {
          if (aCount.intValue () >= nMaxCount)
          {
            aErrorHdl.onReadError (EJDMDefinitionType.CLASS, aFile, aInfoMsgs, aErrorMsgs);
            // Don't add again
          }
          else
          {
            // Retry later by putting at the end of the map
            aCount.inc ();
            aRestClasses.put (aFile, aCount);
          }
        }
        else
        {
          // Reading successful
          aInfoMsgs.forEach (m_aDefaultInfoHdl);
          aErrorMsgs.forEach (m_aDefaultErrorHdl);
        }
      }
    }
  }

  @Nonnull
  public MultiReader reader ()
  {
    return new MultiReader ();
  }
}
