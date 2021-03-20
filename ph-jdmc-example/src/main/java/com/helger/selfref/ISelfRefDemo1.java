package com.helger.selfref;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nullable;


/**
 * <p>Interface for class {@link SelfRefDemo1}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface ISelfRefDemo1
  extends IBusinessObject
{

  /**
   * Get the value of dummy1.
   * 
   * @return
   *     The requested value. May be <code>null</code>.
   */
  @Nullable
  com.helger.selfref.ISelfRefDemo1 getDummy1();

  default boolean hasDummy1() {
    return (getDummy1()!= null);
  }
}
