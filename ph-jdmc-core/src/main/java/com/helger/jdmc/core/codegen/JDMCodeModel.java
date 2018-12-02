package com.helger.jdmc.core.codegen;

import javax.annotation.Nonnull;

import com.helger.commons.ValueEnforcer;
import com.helger.jcodemodel.AbstractJClass;
import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jdmc.core.JDMProcessor;
import com.helger.jdmc.core.datamodel.AbstractJDMClassType;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMClass;
import com.helger.jdmc.core.datamodel.JDMType;

final class JDMCodeModel extends JCodeModel
{
  private final JDMProcessor m_aProcessor;

  public JDMCodeModel (@Nonnull final JDMProcessor aProcessor)
  {
    ValueEnforcer.notNull (aProcessor, "Processor");
    m_aProcessor = aProcessor;
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
