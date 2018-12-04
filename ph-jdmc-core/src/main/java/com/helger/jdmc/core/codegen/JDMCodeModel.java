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

import javax.annotation.Nonnull;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.annotation.ReturnsMutableObject;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.IJDMTypeResolver;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMType;

public final class JDMCodeModel extends JCodeModel
{
  private final IJDMTypeResolver m_aProcessor;
  private final SPIImplMap m_aSPIImplMap = new SPIImplMap ();

  public JDMCodeModel (@Nonnull final IJDMTypeResolver aProcessor)
  {
    ValueEnforcer.notNull (aProcessor, "Processor");
    m_aProcessor = aProcessor;
  }

  @Nonnull
  @ReturnsMutableObject
  public final SPIImplMap spiImplMap ()
  {
    return m_aSPIImplMap;
  }

  @Nonnull
  public AbstractJClass ref (@Nonnull final JDMType aType)
  {
    String sTypeName = aType.getFQCN ();
    final AbstractJDMClassType aExistingClass = m_aProcessor.findTypeByName (sTypeName);
    if (aExistingClass != null && aExistingClass instanceof JDMClass)
    {
      // It's one of our created classes - add an "I" prefix
      sTypeName = aExistingClass.getFQInterfaceName ();
    }
    return super.ref (sTypeName);
  }

  @Nonnull
  public AbstractJType ref (@Nonnull final JDMType aType, @Nonnull final EJDMMultiplicity eMultiplicity)
  {
    if (aType.isJavaPrimitive (eMultiplicity))
    {
      final String sShortName = aType.getShortName ();
      if ("boolean".equals (sShortName))
        return BOOLEAN;
      if ("byte".equals (sShortName))
        return BYTE;
      if ("char".equals (sShortName))
        return CHAR;
      if ("double".equals (sShortName))
        return DOUBLE;
      if ("float".equals (sShortName))
        return FLOAT;
      if ("int".equals (sShortName))
        return INT;
      if ("long".equals (sShortName))
        return LONG;
      if ("short".equals (sShortName))
        return SHORT;
      throw new IllegalStateException ("Unexpected primitive type " + sShortName);
    }

    return ref (aType);
  }
}
