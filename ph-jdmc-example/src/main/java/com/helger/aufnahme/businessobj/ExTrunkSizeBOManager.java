package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExTrunkSizeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExTrunkSizeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExTrunkSizeBO, ExTrunkSizeBO>
{

  public ExTrunkSizeBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExTrunkSizeBO.class, sFilename);
  }

  public ExTrunkSizeBOManager(
    @Nullable
    final String sFilename,
    @Nonnull
    final AbstractMapBasedWALDAO.InitSettings<ExTrunkSizeBO> aInitSettings)
    throws DAOException
  {
    super(ExTrunkSizeBO.class, sFilename, aInitSettings);
  }
}
