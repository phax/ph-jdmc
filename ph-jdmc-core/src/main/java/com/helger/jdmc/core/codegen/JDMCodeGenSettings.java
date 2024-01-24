/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
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

import java.io.Serializable;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.ReturnsMutableCopy;
import com.helger.commons.lang.ICloneable;
import com.helger.commons.system.ENewLineMode;
import com.helger.jcodemodel.writer.ProgressCodeWriter.IProgressTracker;
import com.helger.tenancy.IBusinessObject;

/**
 * Code generation settings. They can be cloned to create "per class" settings.
 *
 * @author Philip Helger
 */
@NotThreadSafe
public class JDMCodeGenSettings implements Serializable, ICloneable <JDMCodeGenSettings>
{
  // Global init settings
  private boolean m_bReadExistingSPIFiles = false;
  // Per class settings
  private boolean m_bUseBusinessObject = false;
  private boolean m_bSetterArePackagePrivate = true;
  private boolean m_bCreateMicroTypeConverter = true;
  private boolean m_bCreateManager = true;
  // Global output settings
  private Charset m_aCharset = StandardCharsets.UTF_8;
  private ENewLineMode m_eNewLineMode = ENewLineMode.DEFAULT;
  private String m_sIndentString = "  ";
  private IProgressTracker m_aProgressTracker;

  public JDMCodeGenSettings ()
  {}

  public JDMCodeGenSettings (@Nonnull final JDMCodeGenSettings aOther)
  {
    setReadExistingSPIFiles (aOther.isReadExistingSPIFiles ());
    setUseBusinessObject (aOther.isUseBusinessObject ());
    setSetterArePackagePrivate (aOther.isSetterArePackagePrivate ());
    setCreateMicroTypeConverter (aOther.isCreateMicroTypeConverter ());
    setCreateManager (aOther.isCreateManager ());
    setCharset (aOther.getCharset ());
    setNewLineMode (aOther.getNewLineMode ());
    setIndentString (aOther.getIndentString ());
    setProgressTracker (aOther.getProgressTracker ());
  }

  public final boolean isReadExistingSPIFiles ()
  {
    return m_bReadExistingSPIFiles;
  }

  /**
   * Should existing SPI META-INF/services files be read or not. By default this
   * does not happen.
   *
   * @param bReadExistingSPIFiles
   *        <code>true</code> to read them, <code>false</code> if not.
   * @return this for chaining
   */
  @Nonnull
  public final JDMCodeGenSettings setReadExistingSPIFiles (final boolean bReadExistingSPIFiles)
  {
    m_bReadExistingSPIFiles = bReadExistingSPIFiles;
    return this;
  }

  public final boolean isUseBusinessObject ()
  {
    return m_bUseBusinessObject;
  }

  /**
   * Should the {@link IBusinessObject} base interface etc. be used for the
   * created objects?
   *
   * @param bUseBusinessObject
   *        <code>true</code> to enable it, <code>false</code> to disable it.
   * @return this for chaining
   */
  @Nonnull
  public final JDMCodeGenSettings setUseBusinessObject (final boolean bUseBusinessObject)
  {
    m_bUseBusinessObject = bUseBusinessObject;
    return this;
  }

  public final boolean isSetterArePackagePrivate ()
  {
    return m_bSetterArePackagePrivate;
  }

  /**
   * Should the setter of the domain object implementation package private or
   * public.
   *
   * @param bSetterArePackagePrivate
   *        <code>true</code> for package private, <code>false</code> for
   *        public.
   * @return this for chaining
   */
  @Nonnull
  public final JDMCodeGenSettings setSetterArePackagePrivate (final boolean bSetterArePackagePrivate)
  {
    m_bSetterArePackagePrivate = bSetterArePackagePrivate;
    return this;
  }

  public final boolean isCreateMicroTypeConverter ()
  {
    return m_bCreateMicroTypeConverter;
  }

  @Nonnull
  public final JDMCodeGenSettings setCreateMicroTypeConverter (final boolean bCreateMicroTypeConverter)
  {
    m_bCreateMicroTypeConverter = bCreateMicroTypeConverter;
    return this;
  }

  public final boolean isCreateManager ()
  {
    return m_bCreateManager;
  }

  public final boolean canCreateManager ()
  {
    return m_bCreateManager && m_bUseBusinessObject && m_bCreateMicroTypeConverter;
  }

  @Nonnull
  public final JDMCodeGenSettings setCreateManager (final boolean bCreateManager)
  {
    m_bCreateManager = bCreateManager;
    return this;
  }

  @Nonnull
  public final Charset getCharset ()
  {
    return m_aCharset;
  }

  @Nonnull
  public final JDMCodeGenSettings setCharset (@Nonnull final Charset aCharset)
  {
    ValueEnforcer.notNull (aCharset, "Charset");
    m_aCharset = aCharset;
    return this;
  }

  @Nonnull
  public final ENewLineMode getNewLineMode ()
  {
    return m_eNewLineMode;
  }

  @Nonnull
  public final JDMCodeGenSettings setNewLineMode (@Nonnull final ENewLineMode eNewLineMode)
  {
    ValueEnforcer.notNull (eNewLineMode, "NewLineMode");
    m_eNewLineMode = eNewLineMode;
    return this;
  }

  @Nonnull
  public final String getIndentString ()
  {
    return m_sIndentString;
  }

  @Nonnull
  public final JDMCodeGenSettings setIndentString (@Nonnull final String sIndentString)
  {
    ValueEnforcer.notNull (sIndentString, "IndentString");
    m_sIndentString = sIndentString;
    return this;
  }

  @Nullable
  public final IProgressTracker getProgressTracker ()
  {
    return m_aProgressTracker;
  }

  @Nonnull
  public final JDMCodeGenSettings setProgressTracker (@Nullable final IProgressTracker aProgressTracker)
  {
    m_aProgressTracker = aProgressTracker;
    return this;
  }

  public void checkConsistency (@Nonnull final IJDMFeedbackHandler aErrorHandler) throws Exception
  {
    if (m_bCreateManager)
    {
      if (!m_bUseBusinessObject)
        aErrorHandler.onError ("Managers can only be created if businessObject usage is enabled", null);
      if (!m_bCreateMicroTypeConverter)
        aErrorHandler.onError ("Managers can only be created if MicroTypeConverter creation is enabled", null);
    }
  }

  @Nonnull
  @ReturnsMutableCopy
  public JDMCodeGenSettings getClone ()
  {
    return new JDMCodeGenSettings (this);
  }
}
