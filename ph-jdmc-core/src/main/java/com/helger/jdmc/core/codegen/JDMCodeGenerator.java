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
package com.helger.jdmc.core.codegen;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.Map;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.NotThreadSafe;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.commons.collection.CollectionHelper;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.collection.impl.ICommonsOrderedSet;
import com.helger.commons.io.file.FileOperationManager;
import com.helger.commons.string.StringHelper;
import com.helger.jcodemodel.EClassType;
import com.helger.jcodemodel.JAnnotationUse;
import com.helger.jcodemodel.JClassAlreadyExistsException;
import com.helger.jcodemodel.JDefinedClass;
import com.helger.jcodemodel.JMethod;
import com.helger.jcodemodel.JMod;
import com.helger.jcodemodel.JVar;
import com.helger.jcodemodel.fmt.JTextFile;
import com.helger.jcodemodel.writer.JCMWriter;
import com.helger.jcodemodel.writer.ProgressCodeWriter.IProgressTracker;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMEnum;
import com.helger.jdmc.core.datamodel.JDMType;

@NotThreadSafe
public class JDMCodeGenerator
{
  public static final String AUTHOR = "JDMCodeGenerator";
  private static final Logger LOGGER = LoggerFactory.getLogger (JDMCodeGenerator.class);

  private final JDMProcessor m_aProcessor;
  private final JDMCodeGenSettings m_aSettings = new JDMCodeGenSettings ();

  public JDMCodeGenerator (@Nonnull final JDMProcessor aProcessor)
  {
    ValueEnforcer.notNull (aProcessor, "Processor");
    m_aProcessor = aProcessor;
  }

  @Nonnull
  @ReturnsMutableObject
  public final JDMCodeGenSettings settings ()
  {
    return m_aSettings;
  }

  public void createMainJavaClasses (@Nonnull final JDMCodeModel cm, @Nonnull final ICommonsList <JDMClass> aClasses)
  {
    try
    {
      for (final JDMClass aClass : aClasses)
      {
        final JDefinedClass jInterface = JDMCodeGenBase.createMainJavaInterface (m_aProcessor, m_aSettings, cm, aClass);
        final JDefinedClass jDomainClass = JDMCodeGenBase.createMainJavaClass (m_aProcessor,
                                                                               m_aSettings,
                                                                               cm,
                                                                               aClass,
                                                                               jInterface);
        JDMCodeGenMicroTypeConverter.createMainMicroTypeConverterClass (m_aSettings, cm, aClass, jDomainClass);
      }
      JDMCodeGenMicroTypeConverter.createMainMicroTypeConverterRegistrarClass (cm, aClasses);
    }
    catch (final JClassAlreadyExistsException ex)
    {
      throw new IllegalStateException (ex);
    }
  }

  public void createTestJavaSelfTest (@Nonnull final JDMCodeModel cm)
  {
    try
    {
      final JDefinedClass jTestClass = cm._class (JMod.PUBLIC | JMod.FINAL,
                                                  AbstractJDMClassType.getFQCN (m_aProcessor.getDestinationPackageName (),
                                                                                "JDMSelfTest"),
                                                  EClassType.CLASS);
      jTestClass.javadoc ().add ("This is the self-test class of JDM\n");
      jTestClass.javadoc ().add ("This class was initially automatically created\n");
      jTestClass.javadoc ().addAuthor ().add (AUTHOR);

      final JMethod jMethod = jTestClass.method (JMod.PUBLIC, cm.VOID, "testSetterAndGetter");
      jMethod.annotate (Test.class);
      jMethod.annotate (SuppressWarnings.class)
             .paramArray (JAnnotationUse.SPECIAL_KEY_VALUE, new String [] { "unused", "cast" });

      int nCount = 0;
      for (final JDMType aType : CollectionHelper.getSorted (m_aProcessor.getContext ().types ().getTypes (),
                                                             Comparator.comparing (JDMType::getClassName)))
      {
        final JVar aVar = jMethod.body ().decl (cm.ref (aType, EJDMMultiplicity.MANDATORY), "var" + nCount);
        jMethod.body ().assign (aVar, aType.createTestValue (cm));
        if (!aType.isPrimitive () && aType.isImmutable ())
          jMethod.body ().add (cm.ref (Assert.class).staticInvoke ("assertNotNull").arg (aVar));

        ++nCount;
      }
    }
    catch (final JClassAlreadyExistsException ex)
    {
      throw new IllegalStateException (ex);
    }
  }

  /**
   * Run the main code creation
   *
   * @param aDestDir
   *        The directory to create the code in. Must stop before "src". The
   *        folders "src/main/java" and "src/test/java" are appended on demand.
   * @throws IOException
   *         On write error
   */
  public void createCode (@Nonnull final File aDestDir) throws IOException
  {
    ValueEnforcer.notNull (aDestDir, "DestDir");

    final ICommonsList <JDMClass> aClasses = m_aProcessor.getAllReadClasses ();
    final ICommonsList <JDMEnum> aEnums = m_aProcessor.getAllReadEnums ();

    {
      final File aSrcMainJava = new File (aDestDir, "src/main/java");
      final File aSrcMainResources = new File (aDestDir, "src/main/resources");

      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcMainJava);
      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcMainResources);

      final JDMCodeModel cm = new JDMCodeModel (m_aProcessor);

      // Create all classes
      createMainJavaClasses (cm, aClasses);

      // Create all enums
      JDMCodeGenEnum.createMainJavaEnums (cm, aEnums);

      // Create all resources before writing
      for (final Map.Entry <String, ICommonsOrderedSet <String>> aEntry : cm.spiImplMap ().getAll ())
      {
        final String sContent = StringHelper.getImploded ('\n', aEntry.getValue ()) + "\n";
        cm._package ("META-INF.services")
          .addResourceFile (JTextFile.createFully (aEntry.getKey (), StandardCharsets.UTF_8, sContent));
      }

      new JCMWriter (cm).setCharset (StandardCharsets.UTF_8)
                        .setIndentString ("  ")
                        .build (aSrcMainJava, aSrcMainResources, (IProgressTracker) null);
    }

    {
      final File aSrcTestJava = new File (aDestDir, "src/test/java");
      final File aSrcTestResources = new File (aDestDir, "src/test/resources");

      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcTestJava);
      FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (aSrcTestResources);

      final JDMCodeModel cm = new JDMCodeModel (m_aProcessor);

      createTestJavaSelfTest (cm);

      // Create all classes
      JDMCodeGenBase.createTestJavaClasses (m_aSettings, cm, aClasses);

      // Create all enums
      JDMCodeGenEnum.createTestJavaEnums (cm, aEnums);

      new JCMWriter (cm).setCharset (StandardCharsets.UTF_8)
                        .setIndentString ("  ")
                        .build (aSrcTestJava, aSrcTestResources, (IProgressTracker) null);
    }

    LOGGER.info ("Done creating code in " + aDestDir.getAbsolutePath ());
  }
}
