package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExCaveTypeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExCaveTypeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExCaveTypeBO, ExCaveTypeBO>
{

  public ExCaveTypeBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExCaveTypeBO.class, sFilename);
  }

  public ExCaveTypeBOManager(
    @Nullable
    final String sFilename,
    @Nonnull
    final AbstractMapBasedWALDAO.InitSettings<ExCaveTypeBO> aInitSettings)
    throws DAOException
  {
    super(ExCaveTypeBO.class, sFilename, aInitSettings);
  }
}
