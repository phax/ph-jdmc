package com.helger.aufnahme.businessobj;

import com.helger.dao.DAOException;
import com.helger.photon.basic.app.dao.AbstractPhotonMapBasedWALDAO;
import javax.annotation.Nullable;


/**
 * <p>Default Manager implementation of for class {@link com.helger.aufnahme.businessobj.ExBiotopbaumDecompositionDegreeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumDecompositionDegreeBOManager
  extends AbstractPhotonMapBasedWALDAO<IExBiotopbaumDecompositionDegreeBO, ExBiotopbaumDecompositionDegreeBO>
{

  public ExBiotopbaumDecompositionDegreeBOManager(
    @Nullable
    final String sFilename)
    throws DAOException
  {
    super(ExBiotopbaumDecompositionDegreeBO.class, sFilename);
  }
}
