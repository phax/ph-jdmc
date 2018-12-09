package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nonnull;
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

  public ExHabitatbaumgruppeBOManager(
    @Nullable
    final String sFilename,
    @Nonnull
    final AbstractMapBasedWALDAO.InitSettings<ExHabitatbaumgruppeBO> aInitSettings)
    throws DAOException
  {
    super(ExHabitatbaumgruppeBO.class, sFilename, aInitSettings);
  }
}
