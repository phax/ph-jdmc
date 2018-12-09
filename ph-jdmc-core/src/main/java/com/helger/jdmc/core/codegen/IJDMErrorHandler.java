package com.helger.jdmc.core.codegen;

import javax.annotation.Nullable;

public interface IJDMErrorHandler
{
  void onError (@Nullable String sMsg, @Nullable Throwable aCause) throws Exception;
}
