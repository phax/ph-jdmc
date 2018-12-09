package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExReservatBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExReservatBOManager
  extends AbstractPhotonMapBasedWALDAO<IExReservatBO, ExReservatBO>
{

  public ExReservatBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExReservatBO.class, sFilename);
  }

  public ExReservatBOManager(
    @Nullable
    final String sFilename,
    @Nonnull
    final AbstractMapBasedWALDAO.InitSettings<ExReservatBO> aInitSettings)
    throws DAOException
  {
    super(ExReservatBO.class, sFilename, aInitSettings);
  }
}
