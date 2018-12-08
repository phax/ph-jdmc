/**
 * Copyright (C) 2014-2018 Philip Helger (www.helger.com)
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
package com.helger.maven.jdmc;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import org.apache.maven.model.Resource;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import com.helger.commons.charset.CharsetHelper;
import com.helger.commons.io.file.FileOperationManager;
import com.helger.commons.string.StringHelper;
import com.helger.commons.system.ENewLineMode;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.codegen.JDMCodeGenerator;

/**
 * @description Convert JDM files to Java Code
 */
@Mojo (name = "jdmc", defaultPhase = LifecyclePhase.GENERATE_SOURCES, threadSafe = true)
public final class JDMCMojo extends AbstractMojo
{
  /**
   * The Maven Project.
   */
  @Parameter (property = "project", required = true, readonly = true)
  private MavenProject project;

  /**
   * The directory where the JDM files reside. It must be an existing directory.
   * Defaults to <code>src/main/resources/jdmc</code>.
   */
  @Parameter (property = "sourceDirectory", defaultValue = "${basedir}/src/main/jdmc", required = true)
  private File sourceDirectory;

  /**
   * The encoding of the source JDM files to be used. Default is UTF-8.
   */
  @Parameter (property = "sourceEncoding", defaultValue = "${project.build.sourceEncoding}")
  private String sourceEncoding = StandardCharsets.UTF_8.name ();

  /**
   * The list of source enum definitions, relative to the source directory.
   */
  @Parameter (property = "sourceEnumDef")
  private List <String> sourceEnumDef;

  /**
   * The list of source class definitions, relative to the source directory.
   */
  @Parameter (property = "sourceClassDef")
  private List <String> sourceClassDef;

  /**
   * The fully qualified target package name of the created source files.
   */
  @Parameter (property = "packageName", required = true)
  private String packageName;

  /**
   * Prefix to be added to all class names.
   */
  @Parameter (property = "classNamePrefix")
  private String classNamePrefix;

  /**
   * Suffix to be added to all class names.
   */
  @Parameter (property = "classNameSuffix")
  private String classNameSuffix;

  /**
   * Shall the created classes are using the ph- BusinessObject base classes?
   */
  @Parameter (property = "useBusinessObject", defaultValue = "false")
  private boolean useBusinessObject = false;

  /**
   * Shall the created domain objects have setters, that are package private (if
   * <code>true</code>) or public (if <code>false</code>).
   */
  @Parameter (property = "settersPackagePrivate", defaultValue = "true")
  private boolean settersPackagePrivate = true;

  /**
   * The encoding of the created Java files. Defaults to UTF-8.
   */
  @Parameter (property = "targetEncoding")
  private String targetEncoding = StandardCharsets.UTF_8.name ();

  /**
   * The target directory for "main" Java code.
   */
  @Parameter (property = "targetMainJava", defaultValue = "${basedir}/src/main/java", required = true)
  private File targetMainJava;

  /**
   * The target directory for "main" resource files.
   */
  @Parameter (property = "targetMainResources", defaultValue = "${basedir}/src/main/resources", required = true)
  private File targetMainResources;

  /**
   * The target directory for "test" Java code.
   */
  @Parameter (property = "targetTestJava", defaultValue = "${basedir}/src/test/java", required = true)
  private File targetTestJava;

  /**
   * The target directory for "test" resource files.
   */
  @Parameter (property = "targetTestResources", defaultValue = "${basedir}/src/test/resources", required = true)
  private File targetTestResources;

  /**
   * The new line mode to be used for writing the files. Valid values are
   * <code>win</code> to use "\r\n", <code>unix</code> to use "\n",
   * <code>mac</code> to use "\r" or <code>system</code> to use the system
   * default line ending. By default the OS default new line mode is used.
   */
  @Parameter (property = "newLineMode")
  private ENewLineMode newLineMode = ENewLineMode.DEFAULT;

  public void setSourceDirectory (final File aDir)
  {
    sourceDirectory = aDir;
    if (!sourceDirectory.isAbsolute ())
      sourceDirectory = new File (project.getBasedir (), aDir.getPath ());
    if (!sourceDirectory.exists ())
      getLog ().error ("JDM source directory '" + sourceDirectory + "' does not exist!");
  }

  public void setSourceEncoding (final String sSourceEncoding)
  {
    // Throws an exception on an illegal charset
    CharsetHelper.getCharsetFromName (sSourceEncoding);
    sourceEncoding = sSourceEncoding;
  }

  public void setSourceEnumDef (final List <String> aCollection)
  {
    sourceEnumDef = new ArrayList <> ();
    if (aCollection != null)
    {
      for (final String sName : aCollection)
        if (StringHelper.hasText (sName))
          sourceEnumDef.add (sName);
    }
  }

  public void setSourceClassDef (final List <String> aCollection)
  {
    sourceClassDef = new ArrayList <> ();
    if (aCollection != null)
    {
      for (final String sName : aCollection)
        if (StringHelper.hasText (sName))
          sourceClassDef.add (sName);
    }
  }

  public void setPackageName (final String sPackageName)
  {
    packageName = sPackageName;
  }

  public void setClassNamePrefix (final String sClassNamePrefix)
  {
    classNamePrefix = sClassNamePrefix;
  }

  public void setClassNameSuffix (final String sClassNameSuffix)
  {
    classNameSuffix = sClassNameSuffix;
  }

  public void setUseBusinessObject (final boolean b)
  {
    useBusinessObject = b;
  }

  public void setSettersPackagePrivate (final boolean b)
  {
    settersPackagePrivate = b;
  }

  @Nonnull
  private File _ensureTargetDirectory (@Nonnull final File aSrc)
  {
    File ret = aSrc;
    if (!ret.isAbsolute ())
      ret = new File (project.getBasedir (), ret.getPath ());
    FileOperationManager.INSTANCE.createDirRecursiveIfNotExisting (ret);
    if (!ret.exists ())
      getLog ().error ("JDM target directory '" + ret + "' does not exist!");
    return ret;
  }

  public void setTargetMainJava (final File aDir)
  {
    targetMainJava = _ensureTargetDirectory (aDir);
  }

  public void setTargetMainResources (final File aDir)
  {
    targetMainResources = _ensureTargetDirectory (aDir);
  }

  public void setTargetTestJava (final File aDir)
  {
    targetTestJava = _ensureTargetDirectory (aDir);
  }

  public void setTargetTestResources (final File aDir)
  {
    targetTestResources = _ensureTargetDirectory (aDir);
  }

  public void setTargetEncoding (final String sTargetEncoding)
  {
    // Throws an exception on an illegal charset
    CharsetHelper.getCharsetFromName (sTargetEncoding);
    targetEncoding = sTargetEncoding;
  }

  public void setNewLineMode (final String sNewLineMode)
  {
    if ("win".equalsIgnoreCase (sNewLineMode) || "windows".equalsIgnoreCase (sNewLineMode))
      newLineMode = ENewLineMode.WINDOWS;
    else
      if ("linux".equalsIgnoreCase (sNewLineMode) || "unix".equalsIgnoreCase (sNewLineMode))
        newLineMode = ENewLineMode.UNIX;
      else
        if ("mac".equalsIgnoreCase (sNewLineMode) || "apple".equalsIgnoreCase (sNewLineMode))
          newLineMode = ENewLineMode.MAC;
        else
          if ("system".equalsIgnoreCase (sNewLineMode) ||
              "os".equalsIgnoreCase (sNewLineMode) ||
              "default".equalsIgnoreCase (sNewLineMode))
            newLineMode = ENewLineMode.DEFAULT;
  }

  public void execute () throws MojoExecutionException
  {
    // Read stuff
    final JDMProcessor p = new JDMProcessor (packageName).setSourceCharset (Charset.forName (sourceEncoding))
                                                         .setClassNamePrefix (classNamePrefix)
                                                         .setClassNameSuffix (classNameSuffix);
    if (sourceEnumDef != null)
      for (final String sEnumDef : sourceEnumDef)
        p.readEnumDef (new File (sourceDirectory, sEnumDef));
    if (sourceClassDef != null)
      for (final String sClassDef : sourceClassDef)
        p.readClassDef (new File (sourceDirectory, sClassDef));

    // Start code generation
    final JDMCodeGenerator cg = new JDMCodeGenerator (p);
    cg.settings ()
      .setUseBusinessObject (useBusinessObject)
      .setSetterArePackagePrivate (settersPackagePrivate)
      .setReadExistingSPIFiles (true)
      .setCharset (Charset.forName (targetEncoding))
      .setNewLineMode (newLineMode)
      .setIndentString ("  ");
    try
    {
      cg.createCode (targetMainJava, targetMainResources, targetTestJava, targetTestResources);
    }
    catch (final IOException ex)
    {
      throw new MojoExecutionException ("IO error in Java code generation", ex);
    }

    // Add output directories to project
    project.addCompileSourceRoot (targetMainJava.getAbsolutePath ());
    {
      final Resource aResource = new Resource ();
      aResource.setDirectory (targetMainResources.getAbsolutePath ());
      aResource.addInclude ("**/*");
      aResource.setFiltering (false);
      project.addResource (aResource);
    }
    project.addTestCompileSourceRoot (targetTestJava.getAbsolutePath ());
    {
      final Resource aResource = new Resource ();
      aResource.setDirectory (targetTestResources.getAbsolutePath ());
      aResource.addInclude ("**/*");
      aResource.setFiltering (false);
      project.addTestResource (aResource);
    }
  }
}
