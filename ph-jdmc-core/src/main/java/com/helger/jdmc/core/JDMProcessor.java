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

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.Nonempty;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.id.IHasID;
import com.helger.commons.io.file.FilenameHelper;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.lang.GenericReflection;
import com.helger.commons.name.IHasDisplayName;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JCommentPart;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JEnumConstant;
import com.helger.jcodemodel.JExpr;
import com.helger.jcodemodel.JJavaName;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;
import com.helger.jcodemodel.writer.JCMWriter;
import com.helger.jcodemodel.writer.ProgressCodeWriter.IProgressTracker;
import com.helger.jdmc.core.datamodel.AbstractJDMType;
import com.helger.jdmc.core.datamodel.EJDMBaseType;
import com.helger.jdmc.core.datamodel.EJDMConstraintType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
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
public class JDMProcessor
{
  private static final Logger LOGGER = LoggerFactory.getLogger (JDMProcessor.class);

  private final String m_sDestinationPackageName;
  private final JDMContext m_aContext = new JDMContext ();
  private final ICommonsList <AbstractJDMType> m_aTypes = new CommonsArrayList <> ();

  public JDMProcessor (@Nonnull final String sDestinationPackageName)
  {
    m_sDestinationPackageName = sDestinationPackageName;
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
  private IJsonObject _parseJson (@Nonnull final File aSrcFile)
  {
    LOGGER.info ("Parsing JSON '" + aSrcFile.getAbsolutePath () + "'");

    final CollectingJsonParserHandler aHandler = new CollectingJsonParserHandler ();
    JsonReader.parseJson (new FileSystemResource (aSrcFile).getReader (StandardCharsets.UTF_8), aHandler, x -> {
      x.setTrackPosition (true);
    }, ex -> LOGGER.error (ex.getMessage ()));
    final IJson aJson = aHandler.getJson ();
    if (aJson == null)
    {
      LOGGER.error ("Failed to parse JSON");
      return null;
    }

    if (!aJson.isObject ())
    {
      LOGGER.error ("Parsed JSON is not an object");
      return null;
    }

    return aJson.getAsObject ();
  }

  @Nullable
  public JDMClass readClassDef (@Nonnull final File aSrcFile)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

    final IJsonObject aJsonObj = _parseJson (aSrcFile);
    if (aJsonObj == null)
      return null;

    final String sLocalClassName = FilenameHelper.getBaseName (aSrcFile);
    final JDMClass ret = new JDMClass (m_sDestinationPackageName, sLocalClassName);

    for (final Map.Entry <String, IJson> aFieldEntry : aJsonObj)
    {
      final String sFieldName = aFieldEntry.getKey ();
      final IJson aFieldDef = aFieldEntry.getValue ();

      if (StringHelper.hasNoText (sFieldName))
      {
        LOGGER.error ("The field name may not be empty");
        return null;
      }
      if (!isValidIdentifier (sFieldName))
      {
        LOGGER.error ("The field name '" + sFieldName + "' is not a valid identifier");
        return null;
      }
      if (ret.fields ().containsAny (x -> x.getFieldName ().equals (sFieldName)))
      {
        LOGGER.error ("Another field with name '" + sFieldName + "' is already present");
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
                LOGGER.error ("The field definition of '" + sFieldName + "' is inconsistent");
                return null;
              }

        }
        else
        {
          LOGGER.error ("The field definition of '" + sFieldName + "' is neither a value nor an array");
          return null;
        }

      // Check for +/?/* suffixes
      final EJDMMultiplicity eMultiplicity = EJDMMultiplicity.getFromTypeName (sTypeName);
      final String sEffectiveTypeName = sTypeName.substring (0,
                                                             sTypeName.length () -
                                                                eMultiplicity.getSuffix ().length ());
      if (StringHelper.hasNoText (sEffectiveTypeName))
      {
        LOGGER.error ("The field definition of '" + sFieldName + "' has no typename");
        return null;
      }
      final JDMType aType = m_aContext.types ().findType (sEffectiveTypeName);
      if (aType == null)
      {
        LOGGER.error ("The typename '" + sEffectiveTypeName + "' is unknown");
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
            LOGGER.error ("Field '" + sFieldName + "' defines unknown constraint '" + sConstraintName + "'");
            return null;
          }
          if (!eConstraintType.isApplicableOn (eFieldBaseType))
          {
            LOGGER.error ("Field '" +
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
            LOGGER.error ("Field '" +
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
                  LOGGER.error ("Field '" +
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
    if (ret.fields ().isEmpty ())
    {
      LOGGER.error ("No fields found");
      return null;
    }

    // Upon success, register this type
    m_aContext.types ().registerType (ret);
    m_aTypes.add (ret);

    return ret;
  }

  @Nullable
  public JDMEnum readEnumDef (@Nonnull final File aSrcFile)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

    final IJsonObject aJsonObj = _parseJson (aSrcFile);
    if (aJsonObj == null)
      return null;

    final String sLocalClassName = FilenameHelper.getBaseName (aSrcFile);
    final JDMEnum ret = new JDMEnum (m_sDestinationPackageName, sLocalClassName);

    for (final Map.Entry <String, IJson> aFieldEntry : aJsonObj)
    {
      final String sEnumConstantName = aFieldEntry.getKey ();
      final IJson aEnumConstantDef = aFieldEntry.getValue ();

      if (StringHelper.hasNoText (sEnumConstantName))
      {
        LOGGER.error ("The enum constant name may not be empty");
        return null;
      }
      if (!isValidIdentifier (sEnumConstantName))
      {
        LOGGER.error ("The enum constant name '" + sEnumConstantName + "' is not a valid identifier");
        return null;
      }
      if (ret.enumConstants ().containsAny (x -> x.getName ().equals (sEnumConstantName)))
      {
        LOGGER.error ("Another enum constant with name '" + sEnumConstantName + "' is already present");
        return null;
      }

      String sID;
      String sDisplayName;
      final String sComment;
      if (aEnumConstantDef.isValue ())
      {
        // ID
        final IJsonValue aValue = aEnumConstantDef.getAsValue ();
        sID = aValue.getAsString ();
        sDisplayName = null;
        sComment = null;
      }
      else
        if (aEnumConstantDef.isArray ())
        {
          // [ID] or
          // [ID, DisplayName] or
          // [ID, DisplayName, Comment]
          final IJsonArray aArray = aEnumConstantDef.getAsArray ();
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
              LOGGER.error ("The enum constant definition of '" +
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
              LOGGER.error ("The enum constant definition of '" + sEnumConstantName + "' is inconsistent (comment)");
              return null;
            }
        }
        else
        {
          LOGGER.error ("The enum constant definition of '" + sEnumConstantName + "' is neither a value nor an array");
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
      LOGGER.error ("No enum constant found");
      return null;
    }

    // Upon success, register this type
    m_aContext.types ().registerType (ret);
    m_aTypes.add (ret);

    return ret;
  }

  @Nonnull
  private JDefinedClass _createJavaInterface (@Nonnull final JCodeModel cm,
                                              @Nonnull final JDMClass aClass) throws JClassAlreadyExistsException
  {
    final JDefinedClass jInterface = cm._class (JMod.PUBLIC, aClass.getFQInterfaceName (), EClassType.INTERFACE);
    jInterface._implements (Serializable.class);
    jInterface.javadoc ().add ("<p>Interface for class {@link " + aClass.getClassName () + "}</p>\n");
    jInterface.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jInterface.javadoc ().addAuthor ().add ("JDMProcessor");

    for (final JDMField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsPrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);
      // Create getter

      // Find type name
      final String sJavaTypeName1 = aField.getType ().getJavaFQCN (eMultiplicity);
      final String sJavaTypeName2;
      final AbstractJDMType aExistingClass = m_aTypes.findFirst (x -> x.getFQClassName ().equals (sJavaTypeName1));
      if (aExistingClass != null && aExistingClass instanceof JDMClass)
      {
        // It's one of our created classes - add an "I" prefix
        sJavaTypeName2 = aExistingClass.getFQInterfaceName ();
      }
      else
        sJavaTypeName2 = sJavaTypeName1;
      final boolean bIsStringType = "String".equals (sJavaTypeName2);

      // List or field?
      AbstractJType jReturnType = cm.ref (sJavaTypeName2);
      if (eMultiplicity.isOpenEnded ())
        jReturnType = cm.ref (ICommonsList.class).narrow (jReturnType);

      final JMethod aMethodGet = jInterface.method (0,
                                                    jReturnType,
                                                    aField.getMethodGetterName (eMultiplicity.isOpenEnded ()));

      // Annotations
      if (!bIsPrimitive)
      {
        if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
          aMethodGet.annotate (Nullable.class);
        else
          aMethodGet.annotate (Nonnull.class);
        if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
          aMethodGet.annotate (Nonempty.class);
        if (eMultiplicity.isOpenEnded ())
          aMethodGet.annotate (ReturnsMutableObject.class);
      }

      // Java docs
      {
        if (aField.hasComment ())
          aMethodGet.javadoc ().add (aField.getComment ());
        else
          aMethodGet.javadoc ().add ("Get the value of " + aField.getOriginalFieldName () + ".");

        final JCommentPart aReturn = aMethodGet.javadoc ().addReturn ();
        aReturn.add ("The requested value.");
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            aReturn.add (" May be <code>null</code>.");
          else
          {
            if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
              aReturn.add (" May neither be <code>null</code> nor empty.");
            else
              aReturn.add (" May not be <code>null</code>.");
          }
        }
      }

      if (!bIsPrimitive && eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
      {
        // Create the default "hasXXX" method
        final JMethod aMethodHas = jInterface.method (JMod.DEFAULT, cm.BOOLEAN, aField.getMethodHasName ());
        if (bIsStringType)
        {
          aMethodHas.body ()
                    ._return (cm.ref (StringHelper.class).staticInvoke ("hasText").arg (JExpr.invoke (aMethodGet)));
        }
        else
          aMethodHas.body ()._return (JExpr.invoke (aMethodGet).neNull ());
      }
    }
    return jInterface;
  }

  private void _createJavaClass (@Nonnull final JCodeModel cm,
                                 @Nonnull final JDMClass aClass,
                                 @Nonnull final JDefinedClass jInterface) throws JClassAlreadyExistsException
  {
    final JDefinedClass jClass = cm._class (JMod.PUBLIC, aClass.getFQClassName (), EClassType.CLASS);
    jClass._implements (jInterface);
    jClass.javadoc ().add ("<p>Default implementation of {@link " + aClass.getFQInterfaceName () + "}</p>\n");
    jClass.javadoc ().add ("<p>This class was initially automatically created</p>\n");
    jClass.javadoc ().addAuthor ().add ("JDMProcessor");

    for (final JDMField aField : aClass.fields ())
    {
      final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
      final boolean bIsPrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);

      // Create getter

      // Find type name
      final String sJavaTypeName1 = aField.getType ().getJavaFQCN (eMultiplicity);
      final String sJavaTypeName2;
      final AbstractJDMType aExistingClass = m_aTypes.findFirst (x -> x.getFQClassName ().equals (sJavaTypeName1));
      if (aExistingClass != null && aExistingClass instanceof JDMClass)
      {
        // It's one of our created classes - add an "I" prefix
        sJavaTypeName2 = aExistingClass.getFQInterfaceName ();
      }
      else
        sJavaTypeName2 = sJavaTypeName1;
      final boolean bIsStringType = "String".equals (sJavaTypeName2);

      // List or field?
      AbstractJType jFieldType = cm.ref (sJavaTypeName2);
      if (eMultiplicity.isOpenEnded ())
        jFieldType = cm.ref (ICommonsList.class).narrow (jFieldType);

      // Class field
      final JVar jField = jClass.field (JMod.PRIVATE, jFieldType, aField.getJavaMemberName (eMultiplicity));

      // Getter
      {
        final JMethod aMethodGet = jClass.method (JMod.PUBLIC | JMod.FINAL,
                                                  jFieldType,
                                                  aField.getMethodGetterName (eMultiplicity.isOpenEnded ()));

        // Annotations
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            aMethodGet.annotate (Nullable.class);
          else
            aMethodGet.annotate (Nonnull.class);
          if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
            aMethodGet.annotate (Nonempty.class);
          if (eMultiplicity.isOpenEnded ())
            aMethodGet.annotate (ReturnsMutableObject.class);
        }
        aMethodGet.body ()._return (jField);
      }

      // Setter
      {
        final JMethod aMethodSet = jClass.method (JMod.PUBLIC | JMod.FINAL, cm.VOID, aField.getMethodSetterName ());
        final JVar jParam = aMethodSet.param (jFieldType, aField.getJavaVarName (eMultiplicity));
        if (!bIsPrimitive)
        {
          if (eMultiplicity.isMin0 () && !eMultiplicity.isOpenEnded ())
            jParam.annotate (Nullable.class);
          else
            jParam.annotate (Nonnull.class);
          if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
            jParam.annotate (Nonempty.class);
        }
        aMethodSet.body ().assign (jField, jParam);
      }
    }
  }

  public void createJavaClasses (@Nonnull final JCodeModel cm, @Nonnull final ICommonsList <JDMClass> aClasses)
  {
    for (final JDMClass aClass : aClasses)
    {
      try
      {
        final JDefinedClass jInterface = _createJavaInterface (cm, aClass);
        _createJavaClass (cm, aClass, jInterface);
      }
      catch (final JClassAlreadyExistsException ex)
      {
        throw new IllegalStateException (ex);
      }
    }
  }

  public void createJavaEnums (@Nonnull final JCodeModel cm, @Nonnull final ICommonsList <JDMEnum> aEnums)
  {
    final AbstractJType jString = cm.ref (String.class);
    for (final JDMEnum aEnum : aEnums)
    {
      try
      {
        final JDefinedClass jEnum = cm._class (JMod.PUBLIC, aEnum.getFQClassName (), EClassType.ENUM);
        jEnum._implements (cm.ref (IHasID.class).narrow (jString));
        jEnum._implements (cm.ref (IHasDisplayName.class));
        jEnum.javadoc ().add ("This class was initially automatically created\n");
        jEnum.javadoc ().addAuthor ().add ("JDMProcessor");

        for (final JDMEnumConstant aEnumConstant : aEnum.enumConstants ())
        {
          final JEnumConstant jEnumConstant = jEnum.enumConstant (aEnumConstant.getName ())
                                                   .arg (JExpr.lit (aEnumConstant.getID ()))
                                                   .arg (JExpr.lit (aEnumConstant.getDisplayName ()));
          if (aEnumConstant.hasComment ())
            jEnumConstant.javadoc ().add (aEnumConstant.getComment ());
        }

        final JVar jFieldID = jEnum.field (JMod.PRIVATE | JMod.FINAL, jString, "m_sID");
        final JVar jFieldDisplayName = jEnum.field (JMod.PRIVATE | JMod.FINAL, jString, "m_sDisplayName");

        {
          final JMethod jMethod = jEnum.constructor (JMod.PRIVATE);
          final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
          jID.annotate (Nonnull.class);
          jID.annotate (Nonempty.class);
          final JVar jDisplayName = jMethod.param (JMod.FINAL, jString, "sDisplayName");
          jDisplayName.annotate (Nonnull.class);
          jDisplayName.annotate (Nonempty.class);
          jMethod.body ().assign (jFieldID, jID);
          jMethod.body ().assign (jFieldDisplayName, jDisplayName);
        }

        {
          final JMethod jMethod = jEnum.method (JMod.PUBLIC, jString, "getID");
          jMethod.annotate (Nonnull.class);
          jMethod.annotate (Nonempty.class);
          jMethod.body ()._return (jFieldID);
        }

        {
          final JMethod jMethod = jEnum.method (JMod.PUBLIC, jString, "getDisplayName");
          jMethod.annotate (Nonnull.class);
          jMethod.annotate (Nonempty.class);
          jMethod.body ()._return (jFieldDisplayName);
        }

        {
          final JMethod jMethod = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrNull");
          jMethod.annotate (Nullable.class);
          final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
          jID.annotate (Nullable.class);
          jMethod.body ()
                 ._return (cm.ref (EnumHelper.class)
                             .staticInvoke ("getFromIDOrNull")
                             .arg (jEnum.dotclass ())
                             .arg (jID));
        }

        {
          final JMethod jMethod = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrDefault");
          jMethod.annotate (Nullable.class);
          final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
          jID.annotate (Nullable.class);
          final JVar jDefault = jMethod.param (JMod.FINAL, jEnum, "eDefault");
          jDefault.annotate (Nullable.class);
          jMethod.body ()
                 ._return (cm.ref (EnumHelper.class)
                             .staticInvoke ("getFromIDOrDefault")
                             .arg (jEnum.dotclass ())
                             .arg (jID)
                             .arg (jDefault));
        }

        {
          final JMethod jMethod = jEnum.method (JMod.PUBLIC | JMod.STATIC, jEnum, "getFromIDOrThrow");
          jMethod.annotate (Nonnull.class);
          final JVar jID = jMethod.param (JMod.FINAL, jString, "sID");
          jID.annotate (Nullable.class);
          jMethod.body ()
                 ._return (cm.ref (EnumHelper.class)
                             .staticInvoke ("getFromIDOrThrow")
                             .arg (jEnum.dotclass ())
                             .arg (jID));
        }
      }
      catch (final JClassAlreadyExistsException ex)
      {
        throw new IllegalStateException (ex);
      }
    }
  }

  public void createCode (@Nonnull final File aDestDir) throws IOException
  {
    final JCodeModel cm = new JCodeModel ();

    // Create all classes
    final ICommonsList <JDMClass> aClasses = CommonsArrayList.createFiltered (m_aTypes,
                                                                              x -> x instanceof JDMClass,
                                                                              (Function <AbstractJDMType, JDMClass>) x -> (JDMClass) x);
    createJavaClasses (cm, aClasses);

    // Create all enums
    final ICommonsList <JDMEnum> aEnums = CommonsArrayList.createFiltered (m_aTypes,
                                                                           x -> x instanceof JDMEnum,
                                                                           (Function <AbstractJDMType, JDMEnum>) x -> (JDMEnum) x);
    createJavaEnums (cm, aEnums);

    new JCMWriter (cm).setCharset (StandardCharsets.UTF_8)
                      .setIndentString ("  ")
                      .build (aDestDir, (IProgressTracker) null);
    LOGGER.info ("Done creating code in " + aDestDir.getAbsolutePath ());
  }
}
