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
package com.helger.jdmc.core.codegen;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.collection.impl.ICommonsOrderedSet;
import com.helger.commons.io.file.FileOperationManager;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.fmt.JTextFile;
import com.helger.jcodemodel.writer.JCMWriter;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMEnum;

@NotThreadSafe
public class JDMCodeGenerator
{
  public static final String AUTHOR = "JDMCodeGenerator";
  private static final Logger LOGGER = LoggerFactory.getLogger (JDMCodeGenerator.class);

  private final JDMProcessor m_aProcessor;
  private final JDMCodeGenSettings m_aDefaultSettings = new JDMCodeGenSettings ();

  public JDMCodeGenerator (@Nonnull final JDMProcessor aProcessor)
  {
    ValueEnforcer.notNull (aProcessor, "Processor");
    m_aProcessor = aProcessor;
  }

  @Nonnull
  @ReturnsMutableObject
  public final JDMCodeGenSettings defaultSettings ()
  {
    return m_aDefaultSettings;
  }

  private static void _createMetaInfServices (@Nonnull final JDMCodeModel cm)
  {
    for (final Map.Entry <String, ICommonsOrderedSet <String>> aEntry : cm.spiImplMap ().getAll ())
    {
      final String sContent = StringHelper.getImploded ('\n', aEntry.getValue ()) + "\n";
      cm._package ("META-INF.services")
        .addResourceFile (JTextFile.createFully (aEntry.getKey (), StandardCharsets.UTF_8, sContent));
    }
  }

  /**
   * Run the main code creation
   *
   * @param aDestDir
   *        The directory to create the code in. Must stop before "src". The
   *        folders "src/main/java" and "src/test/java" are appended on demand.
   * @throws Exception
   *         On IO error or on misconfiguration
   */
  public void createCode (@Nonnull final File aDestDir) throws Exception
  {
    ValueEnforcer.notNull (aDestDir, "DestDir");
    final IJDMFeedbackHandler aFeedbackHdl = new IJDMFeedbackHandler ()
    {
      public void onWarning (final String sMsg, final Throwable aException)
      {
        LOGGER.warn (sMsg, aException);
      }

      public void onError (final String sMsg, final Throwable aException) throws Exception
      {
        throw new IllegalStateException (sMsg, aException);
      }
    };
    createCode (new File (aDestDir, "src/main/java"),
                new File (aDestDir, "src/main/resources"),
                new File (aDestDir, "src/test/java"),
                new File (aDestDir, "src/test/resources"),
                aFeedbackHdl);
  }

  /**
   * Run the main code creation
   *
   * @param aDirMainJava
   *        The directory to create the "main" Java code in.
   * @param aDirMainResources
   *        The directory to create the "main" resources in.
   * @param aDirTestJava
   *        The directory to create the "test" Java code in.
   * @param aDirTestResources
   *        The directory to create the "test" resources in.
   * @param aFeedbackHandler
   *        Feedback handler for reporting issues. May not be <code>null</code>.
   * @throws Exception
   *         for the error handler
   */
  public void createCode (@Nonnull final File aDirMainJava,
                          @Nonnull final File aDirMainResources,
                          @Nonnull final File aDirTestJava,
                          @Nonnull final File aDirTestResources,
                          @Nonnull final IJDMFeedbackHandler aFeedbackHandler) throws Exception
  {
    ValueEnforcer.notNull (aDirMainJava, "DirMainJava");
    ValueEnforcer.notNull (aDirMainResources, "DirMainResources");
    ValueEnforcer.notNull (aDirTestJava, "DirTestJava");
    ValueEnforcer.notNull (aDirTestResources, "DirTestResources");
    ValueEnforcer.notNull (aFeedbackHandler, "FeedbackHandler");

    // Before we started, check the settings consistency
    m_aDefaultSettings.checkConsistency (aFeedbackHandler);

    FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aDirMainJava);
    FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aDirMainResources);
    FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aDirTestJava);
    FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aDirTestResources);

    final ICommonsList <JDMClass> aClasses = m_aProcessor.getAllReadClasses ();
    final ICommonsList <JDMEnum> aEnums = m_aProcessor.getAllReadEnums ();

    try
    {
      final JDMCodeModel cm = new JDMCodeModel (m_aProcessor);
      if (m_aDefaultSettings.isReadExistingSPIFiles ())
        cm.spiImplMap ().readInitial (aDirMainResources);

      // Create all classes
      final ICommonsList <JDMClass> aMicroTypeConvertersCreated = new CommonsArrayList <> ();
      for (final JDMClass aClass : aClasses)
      {
        // Create a copy of the settings
        final JDMCodeGenSettings aPerClassSettings = m_aDefaultSettings.getClone ();
        aClass.settings ().applyToSettings (aPerClassSettings);

        final JDefinedClass jInterface = JDMCodeGenBase.createMainJavaInterface (m_aProcessor,
                                                                                 aPerClassSettings,
                                                                                 cm,
                                                                                 aClass);
        final JDefinedClass jDomainClass = JDMCodeGenBase.createMainJavaClass (aPerClassSettings,
                                                                               cm,
                                                                               aClass,
                                                                               jInterface);

        if (aPerClassSettings.isCreateMicroTypeConverter ())
        {
          JDMCodeGenMicroTypeConverter.createMainMicroTypeConverterClass (aPerClassSettings, cm, aClass, jDomainClass);
          aMicroTypeConvertersCreated.add (aClass);
        }

        if (aPerClassSettings.canCreateManager ())
        {
          if (aClass.fields ().isEmpty ())
            aFeedbackHandler.onWarning ("Creating a manager for class '" +
                                        aClass.getClassName () +
                                        "' which has no fields. So the manager is pretty useless.");
          JDMCodeGenManager.createMainManagerClass (cm, aClass, jInterface, jDomainClass);
        }
      }

      // Create all enums
      JDMCodeGenEnum.createMainJavaEnums (cm, aEnums);

      // create for all
      if (aMicroTypeConvertersCreated.isNotEmpty ())
        JDMCodeGenMicroTypeConverter.createMainMicroTypeConverterRegistrarClass (m_aProcessor.getDestinationPackageName (),
                                                                                 cm,
                                                                                 aMicroTypeConvertersCreated);

      // Create all resources as last thing before writing
      _createMetaInfServices (cm);

      new JCMWriter (cm).setCharset (m_aDefaultSettings.getCharset ())
                        .setNewLine (m_aDefaultSettings.getNewLineMode ().getText ())
                        .setIndentString (m_aDefaultSettings.getIndentString ())
                        .build (aDirMainJava, aDirMainResources, m_aDefaultSettings.getProgressTracker ());
    }
    catch (final JClassAlreadyExistsException ex)
    {
      aFeedbackHandler.onError (ex.getMessage (), ex.getCause ());
    }

    try
    {
      final JDMCodeModel cm = new JDMCodeModel (m_aProcessor);
      if (m_aDefaultSettings.isReadExistingSPIFiles ())
        cm.spiImplMap ().readInitial (aDirTestResources);

      JDMCodeGenTest.createTestJavaSelfTest (m_aProcessor, m_aDefaultSettings, cm);

      if (aClasses.isNotEmpty ())
        JDMCodeGenTest.createSPITest (m_aProcessor.getDestinationPackageName (), cm);

      // Create test classes for all domain classes
      for (final JDMClass aClass : aClasses)
      {
        // Create a copy of the settings
        final JDMCodeGenSettings aPerClassSettings = m_aDefaultSettings.getClone ();
        aClass.settings ().applyToSettings (aPerClassSettings);

        JDMCodeGenTest.createTestJavaClass (aPerClassSettings, cm, aClass);
      }

      // Create all enums
      JDMCodeGenEnum.createTestJavaEnums (cm, aEnums);

      // Create all resources as last thing before writing
      _createMetaInfServices (cm);

      new JCMWriter (cm).setCharset (m_aDefaultSettings.getCharset ())
                        .setNewLine (m_aDefaultSettings.getNewLineMode ().getText ())
                        .setIndentString (m_aDefaultSettings.getIndentString ())
                        .build (aDirTestJava, aDirTestResources, m_aDefaultSettings.getProgressTracker ());
    }
    catch (final JClassAlreadyExistsException ex)
    {
      aFeedbackHandler.onError (ex.getMessage (), ex.getCause ());
    }

    LOGGER.info ("Done creating code from JDM files");
  }
}
