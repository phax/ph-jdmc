package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumDeadwoodBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBiotopbaumDeadwoodBO, ExBiotopbaumDeadwoodBO>
{

  public ExBiotopbaumDeadwoodBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExBiotopbaumDeadwoodBO.class, sFilename);
  }

  public ExBiotopbaumDeadwoodBOManager(
    @Nullable
    final String sFilename,
    @Nonnull
    final AbstractMapBasedWALDAO.InitSettings<ExBiotopbaumDeadwoodBO> aInitSettings)
    throws DAOException
  {
    super(ExBiotopbaumDeadwoodBO.class, sFilename, aInitSettings);
  }
}
