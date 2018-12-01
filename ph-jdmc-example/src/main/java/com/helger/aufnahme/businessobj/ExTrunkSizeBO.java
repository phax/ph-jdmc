package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExTrunkSizeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExTrunkSizeBO
  extends AbstractBusinessObject
  implements IExTrunkSizeBO
{
  public static final ObjectType OT = new ObjectType("ExTrunkSizeBO");
  private int m_nBHD;
  private ExETreeHeightBO m_eHeight;

  public ExTrunkSizeBO(final int nBHD,
    @Nonnull
    final ExETreeHeightBO eHeight) {
    this(StubObject.createForCurrentUser(), nBHD, eHeight);
  }

  protected ExTrunkSizeBO(final StubObject aStubObject, final int nBHD,
    @Nonnull
    final ExETreeHeightBO eHeight) {
    super(aStubObject);
    setBHD(nBHD);
    setHeight(eHeight);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("BHD", m_nBHD).append("height", m_eHeight).getToString();
  }

  public final int getBHD() {
    return m_nBHD;
  }

  @Nonnull
  final EChange setBHD(final int nBHD) {
    if (nBHD == m_nBHD) {
      return EChange.UNCHANGED;
    }
    m_nBHD = nBHD;
    return EChange.CHANGED;
  }

  @Nonnull
  public final ExETreeHeightBO getHeight() {
    return m_eHeight;
  }

  @Nonnull
  final EChange setHeight(
    @Nonnull
    final ExETreeHeightBO eHeight) {
    ValueEnforcer.notNull(eHeight, "Height");
    if (eHeight.equals(m_eHeight)) {
      return EChange.UNCHANGED;
    }
    m_eHeight = eHeight;
    return EChange.CHANGED;
  }
}
