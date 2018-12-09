package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExHabitatbaumgruppeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExHabitatbaumgruppeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExHabitatbaumgruppeBO, ExHabitatbaumgruppeBO>
{

  public ExHabitatbaumgruppeBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExHabitatbaumgruppeBO.class, sFilename);
  }
}
