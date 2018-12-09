package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBiotopbaumBO, ExBiotopbaumBO>
{

  public ExBiotopbaumBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExBiotopbaumBO.class, sFilename);
  }
}
