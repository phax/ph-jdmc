package com.helger.aufnahme.businessobj;

import com.helger.tenancy.IBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Interface for class {@link ExCaveTypeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public interface IExCaveTypeBO
  extends IBusinessObject
{

  /**
   * Get the value of clazz.
   * 
   * @return
   *     The requested value. May not be <code>null</code>.
   */
  @Nonnull
  EExCaveClassBO getClazz();

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
  EExCaveTypeBO getType();

  @Nonnull
  default String getTypeID() {
    return getType().getID();
  }
}
