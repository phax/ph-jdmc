package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.dao.wal.AbstractMapBasedWALDAO;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nonnull;
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

  public ExBiotopbaumBOManager(
    @Nullable
    final String sFilename,
    @Nonnull
    final AbstractMapBasedWALDAO.InitSettings<ExBiotopbaumBO> aInitSettings)
    throws DAOException
  {
    super(ExBiotopbaumBO.class, sFilename, aInitSettings);
  }
}
