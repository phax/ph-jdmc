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
package com.helger.jdmc.core.codegen;

import java.io.Serializable;

import javax.annotation.Nullable;

/**
 * JDM feedback handler for warnings and errors.
 *
 * @author Philip Helger
 */
public interface IJDMFeedbackHandler extends Serializable
{
  /**
   * Log a warning without an exception
   *
   * @param sMsg
   *        Message. May be <code>null</code>.
   * @see #onWarning(String, Throwable)
   */
  default void onWarning (@Nullable final String sMsg)
  {
    onWarning (sMsg, null);
  }

  /**
   * Log a warning.
   *
   * @param sMsg
   *        Message. May be <code>null</code>.
   * @param aException
   *        Exception that occurred. May be <code>null</code>.
   * @see #onWarning(String)
   */
  void onWarning (@Nullable String sMsg, @Nullable Throwable aException);

  /**
   * An error occurred. Throw an exception.
   *
   * @param sMsg
   *        Error message. May be <code>null</code>.
   * @param aException
   *        Exception that occurred. May be <code>null</code>.
   * @throws Exception
   *         Should always throw an exception.
   */
  void onError (@Nullable String sMsg, @Nullable Throwable aException) throws Exception;
}
