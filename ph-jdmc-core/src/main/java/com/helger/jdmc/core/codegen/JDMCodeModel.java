package com.helger.jdmc.core.codegen;

import javax.annotation.Nonnull;

import com.helger.jcodemodel.AbstractJType;
import com.helger.jcodemodel.JCodeModel;
import com.helger.jdmc.core.datamodel.EJDMMultiplicity;
import com.helger.jdmc.core.datamodel.JDMType;

public class JDMCodeModel extends JCodeModel
{
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

    return super.ref (aType.getFQCN ());
  }
}
