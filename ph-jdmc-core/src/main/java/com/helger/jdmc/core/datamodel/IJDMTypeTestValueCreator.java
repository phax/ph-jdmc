package com.helger.jdmc.core.datamodel;

import java.io.Serializable;

import javax.annotation.Nonnull;

import com.helger.jcodemodel.IJExpression;
import com.helger.jcodemodel.JCodeModel;

public interface IJDMTypeTestValueCreator extends Serializable
{
  @Nonnull
  IJExpression createTestValue (@Nonnull JCodeModel cm);
}
