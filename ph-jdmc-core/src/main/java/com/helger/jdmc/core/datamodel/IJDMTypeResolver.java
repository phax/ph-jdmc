package com.helger.jdmc.core.datamodel;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public interface IJDMTypeResolver
{
  @Nullable
  AbstractJDMClassType findTypeByName (@Nonnull String sFQCN);
}
