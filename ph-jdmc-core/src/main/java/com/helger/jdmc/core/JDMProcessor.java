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

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.util.Map;

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
import com.helger.commons.io.file.FilenameHelper;
import com.helger.commons.io.resource.FileSystemResource;
import com.helger.commons.lang.GenericReflection;
import com.helger.commons.regex.RegExHelper;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jcodemodel.JCommentPart;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.writer.JCMWriter;
import com.helger.jcodemodel.writer.ProgressCodeWriter.IProgressTracker;
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
  private final ICommonsList <JDMClass> m_aClasses = new CommonsArrayList <> ();

  public JDMProcessor (@Nonnull final String sDestinationPackageName)
  {
    m_sDestinationPackageName = sDestinationPackageName;
  }

  @Nullable
  public JDMClass processFile (@Nonnull final File aSrcFile)
  {
    ValueEnforcer.notNull (aSrcFile, "SrcFile");

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

    final String sLocalClassName = FilenameHelper.getBaseName (aSrcFile);
    final JDMClass ret = new JDMClass (m_sDestinationPackageName, sLocalClassName);

    for (final Map.Entry <String, IJson> aFieldEntry : aJson.getAsObject ())
    {
      final String sFieldName = aFieldEntry.getKey ();
      final IJson aFieldDef = aFieldEntry.getValue ();

      if (StringHelper.hasNoText (sFieldName))
      {
        LOGGER.error ("The field name may not be empty");
        return null;
      }
      if (!RegExHelper.getAsIdentifier (sFieldName).equals (sFieldName))
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

          // Define type
          final EJDMConstraintType eConstraint = EJDMConstraintType.getFromIDOrNull (sConstraintName);
          if (eConstraint == null)
          {
            LOGGER.error ("Field '" + sFieldName + "' defines unknown constraint '" + sConstraintName + "'");
            return null;
          }
          if (!eConstraint.isApplicableOn (eFieldBaseType))
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
          final boolean bIsMultiValueConstraint = eConstraint.getConstraintDataType ().isMultiValue ();
          final ICommonsList <IJson> aConstraintDataElements = new CommonsArrayList <> ();
          if (bIsMultiValueConstraint)
          {
            if (aConstraintDef.isArray ())
              aConstraintDataElements.addAll (aConstraintDef.getAsArray ());
            else
              if (aConstraintDef.isValue ())
                aConstraintDataElements.add (aConstraintDef.getAsValue ());
              else
              {
                LOGGER.error ("Field '" +
                              sFieldName +
                              "' defines constraint '" +
                              sConstraintName +
                              "' which requires a single value or a list of values");
                return null;
              }
          }
          else
          {
            if (aConstraintDef.isValue ())
              aConstraintDataElements.add (aConstraintDef.getAsValue ());
            else
            {
              LOGGER.error ("Field '" +
                            sFieldName +
                            "' defines constraint '" +
                            sConstraintName +
                            "' which requires a single value");
              return null;
            }
          }
          EJDMBaseType eConstraintElementType;
          boolean bConvert = false;
          switch (eConstraint.getConstraintDataType ())
          {
            case DEPENDS_MULTI_VALUE:
            case DEPENDS_SINGLE_VALUE:
              if (eFieldBaseType.isString () || eFieldBaseType.isNumeric ())
                eConstraintElementType = eFieldBaseType;
              else
              {
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
          final ICommonsList <Serializable> aValues = new CommonsArrayList <> (aConstraintDataElements.size ());
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
                for (final IJson aItem : aConstraintDataElements)
                  aValues.add ((Serializable) aItem.getAsValue ().getConvertedValue (aTargetClass));
              }
              else
                for (final IJson aItem : aConstraintDataElements)
                  aValues.add (aItem.getAsValue ().getAsString ());
              break;
            }
            case INTEGER:
              for (final IJson aItem : aConstraintDataElements)
                aValues.add (aItem.getAsValue ().getAsBigInteger ());
              break;
            case DOUBLE:
              for (final IJson aItem : aConstraintDataElements)
                aValues.add (aItem.getAsValue ().getAsBigDecimal ());
              break;
            default:
              throw new IllegalStateException ("Internal inconsistency");
          }
          aConstraints.add (new JDMConstraint (eConstraint, aValues));
        }
      }

      ret.fields ().add (new JDMField (sFieldName, aType, eMultiplicity, sComment, aConstraints));
    }
    if (ret.fields ().isEmpty ())
    {
      LOGGER.error ("No fields found");
      return null;
    }

    // Upon success, register this type
    m_aContext.types ().registerType (ret);
    m_aClasses.add (ret);

    return ret;
  }

  public void extractCommonEnums ()
  {
    // TODO
  }

  public void createJavaClasses (@Nonnull final File aDestDir) throws IOException
  {
    // Create all classes
    createJavaClasses (aDestDir, m_aClasses);
  }

  public void createJavaClasses (@Nonnull final File aDestDir,
                                 @Nonnull final ICommonsList <JDMClass> aClasses) throws IOException
  {
    final JCodeModel cm = new JCodeModel ();
    for (final JDMClass aClass : aClasses)
    {
      try
      {
        final JDefinedClass aInterface = cm._class (JMod.PUBLIC, aClass.getFQInterfaceName (), EClassType.INTERFACE);
        aInterface._implements (Serializable.class);
        aInterface.javadoc ().add ("Interface for class " + aClass.getClassName () + "\n");
        aInterface.javadoc ().add ("This class was initially automatically created\n");
        aInterface.javadoc ().addAuthor ().add ("JDMProcessor");

        for (final JDMField aField : aClass.fields ())
        {
          final EJDMMultiplicity eMultiplicity = aField.getMultiplicity ();
          final boolean bIsPrimitive = aField.getType ().isJavaPrimitive (eMultiplicity);
          // Create getter

          // Find type name
          final String sJavaTypeName1 = aField.getType ().getJavaFQCN (eMultiplicity);
          final String sJavaTypeName2;
          final JDMClass aExistingClass = m_aClasses.findFirst (x -> x.getFQClassName ().equals (sJavaTypeName1));
          if (aExistingClass != null)
          {
            // It's one of our created classes - add an "I" prefix
            sJavaTypeName2 = aExistingClass.getFQInterfaceName ();
          }
          else
            sJavaTypeName2 = sJavaTypeName1;

          // List or field?
          AbstractJType jType = cm.ref (sJavaTypeName2);
          if (eMultiplicity.isOpenEnded ())
            jType = cm.ref (ICommonsList.class).narrow (jType);

          final JMethod aMethod = aInterface.method (0, jType, aField.getGetterName (eMultiplicity.isOpenEnded ()));

          // Annotations
          if (!bIsPrimitive)
          {
            if (eMultiplicity.isMin0 ())
              aMethod.annotate (Nullable.class);
            else
              aMethod.annotate (Nonnull.class);
            if (eMultiplicity.isOpenEnded () && eMultiplicity.isMin1 ())
              aMethod.annotate (Nonempty.class);
            if (eMultiplicity.isOpenEnded ())
              aMethod.annotate (ReturnsMutableObject.class);
          }

          // Java docs
          {
            if (aField.hasComment ())
              aMethod.javadoc ().add (aField.getComment ());
            else
              aMethod.javadoc ().add ("Get the value of " + aField.getOriginalFieldName () + ".");

            final JCommentPart aReturn = aMethod.javadoc ().addReturn ();
            aReturn.add ("The requested value.");
            if (!bIsPrimitive)
            {
              if (eMultiplicity.isMin0 ())
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
        }
      }
      catch (final JClassAlreadyExistsException ex)
      {
        throw new IllegalStateException (ex);
      }
    }

    new JCMWriter (cm).setCharset (StandardCharsets.UTF_8)
                      .setIndentString ("  ")
                      .build (aDestDir, (IProgressTracker) null);
    LOGGER.info ("Done creating code in " + aDestDir.getAbsolutePath ());
  }
}
