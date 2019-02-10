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
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.CommonsTreeSet;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.collection.impl.ICommonsOrderedSet;
import com.helger.commons.collection.impl.ICommonsSortedSet;
import com.helger.commons.io.file.FileOperationManager;
import com.helger.commons.string.StringHelper;
import com.helger.graph.IMutableDirectedGraphNode;
import com.helger.graph.iterate.DirectedGraphIteratorForward;
import com.helger.graph.simple.SimpleDirectedGraph;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.fmt.JTextFile;
import com.helger.jcodemodel.writer.JCMWriter;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.JDMGenClass;
import com.helger.jdmc.core.datamodel.JDMGenEnum;
import com.helger.jdmc.core.datamodel.JDMGenField;

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

  @Nonnull
  private static SimpleDirectedGraph _createTypeGraph (@Nonnull final ICommonsList <JDMGenClass> aReadClasses)
  {
    final SimpleDirectedGraph aGraph = new SimpleDirectedGraph ();

    // Create a node for each class
    for (final JDMGenClass aClass : aReadClasses)
      aGraph.createNode (aClass.getClassName ());

    // Connect all fields via relations
    for (final JDMGenClass aClass : aReadClasses)
    {
      final IMutableDirectedGraphNode aClassNode = aGraph.getNodeOfID (aClass.getClassName ());
      for (final JDMGenField aField : aClass.fields ())
      {
        final String sNodeID = aField.getType ().getShortName ();
        final IMutableDirectedGraphNode aFieldNode = aGraph.getNodeOfID (sNodeID);
        if (aFieldNode != null)
        {
          // Ensure to draw the connection only once. Happens if type A
          // references type B with multiple fields
          if (!aClassNode.isConnectedWith (aFieldNode))
            aGraph.createRelation (aClassNode, aFieldNode);
        }
      }
    }
    return aGraph;
  }

  private static void _createMetaInfServices (@Nonnull final JDMCodeModel cm)
  {
    for (final Map.Entry <String, ICommonsOrderedSet <String>> aEntry : cm.spiImplMap ().getAll ())
    {
      final String sContent = StringHelper.getImploded ('\n', aEntry.getValue ()) + "\n";
      // Fake directory
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
      public void onWarning (@Nullable final String sMsg, @Nullable final Throwable aException)
      {
        LOGGER.warn (sMsg, aException);
      }

      public void onError (@Nonnull final String sMsg, @Nullable final Throwable aException) throws Exception
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
   *         for the feedback handler implementation
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

    final ICommonsList <JDMGenClass> aClasses = m_aProcessor.getAllReadClasses ();
    final ICommonsList <JDMGenEnum> aEnums = m_aProcessor.getAllReadEnums ();

    final SimpleDirectedGraph aGraph = _createTypeGraph (aClasses);
    if (aGraph.containsCycles ())
    {
      // At least one cycle is contained
      // This should be impossible to create, because of eager type resolution
      // during parsing
      final ICommonsSortedSet <String> aCycleClassNames = new CommonsTreeSet <> ();
      for (final IMutableDirectedGraphNode aCurNode : aGraph.getAllNodes ().values ())
      {
        final DirectedGraphIteratorForward it = new DirectedGraphIteratorForward (aCurNode);
        while (it.hasNext () && !it.hasCycles ())
          it.next ();
        if (it.hasCycles ())
          aCycleClassNames.add (aCurNode.getID ());
      }
      aFeedbackHandler.onWarning ("The type graph contains at least one cycle. Involved classes are: " +
                                  aCycleClassNames);
    }

    try
    {
      final JDMCodeModel cm = new JDMCodeModel (m_aProcessor);
      if (m_aDefaultSettings.isReadExistingSPIFiles ())
        cm.spiImplMap ().readInitial (aDirMainResources);

      // Create all classes
      final ICommonsList <JDMGenClass> aMicroTypeConvertersCreated = new CommonsArrayList <> ();
      for (final JDMGenClass aClass : aClasses)
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
      for (final JDMGenClass aClass : aClasses)
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
