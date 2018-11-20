package com.helger.aufnahme.businessobj;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link CaveType}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface ICaveType
  extends IBusinessObject
{

  /**
   * Get the value of clazz.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ECaveClass getClazz();

  /**
   * Get the value of type.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  ECaveType getType();
}
