package com.helger.jdmc.core.datamodel;

import javax.annotation.Nonnull;

import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JCodeModel;

public interface IJDMTypeTestValueCreator
{
  @Nonnull
  IJExpression createTestValue (@Nonnull JCodeModel cm);
}
