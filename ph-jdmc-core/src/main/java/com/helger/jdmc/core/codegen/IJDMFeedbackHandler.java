package com.helger.jdmc.core.codegen;

import javax.annotation.Nullable;

public interface IJDMFeedbackHandler
{
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
