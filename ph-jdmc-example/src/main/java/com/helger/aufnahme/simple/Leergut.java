package com.helger.aufnahme.simple;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.type.ObjectType;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.simple.ILeergut}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class Leergut
  implements ILeergut
{
  public static final ObjectType OT = new ObjectType("Leergut");

  public Leergut() {
  }

  public Leergut(
    @Nonnull
    final ILeergut aOther) {
    ValueEnforcer.notNull(aOther, "Other");
  }
}
