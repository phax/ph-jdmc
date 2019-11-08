package com.helger.aufnahme.small;

import java.io.Serializable;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link CaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface ICaveType
  extends Serializable
{

  /**
   * Get the value of clazz.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ECaveClass getClazz();

  @Nonnull
  default String getClazzID() {
    return getClazz().getID();
  }

  /**
   * Höhlentyp
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ECaveType getType();

  @Nonnull
  default String getTypeID() {
    return getType().getID();
  }
}
