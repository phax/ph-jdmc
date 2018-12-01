package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExReservatBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExReservatBO
  extends AbstractBusinessObject
  implements IExReservatBO
{
  public static final ObjectType OT = new ObjectType("ExReservatBO");
  private int m_nRNr;
  private String m_sName;
  private int m_nAreaSize;

  public ExReservatBO(final int nRNr,
    @Nonnull
    final String sName, final int nAreaSize) {
    this(StubObject.createForCurrentUser(), nRNr, sName, nAreaSize);
  }

  protected ExReservatBO(final StubObject aStubObject, final int nRNr,
    @Nonnull
    final String sName, final int nAreaSize) {
    super(aStubObject);
    setRNr(nRNr);
    setName(sName);
    setAreaSize(nAreaSize);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("RNr", m_nRNr).append("name", m_sName).append("areaSize", m_nAreaSize).getToString();
  }

  public final int getRNr() {
    return m_nRNr;
  }

  @Nonnull
  final EChange setRNr(final int nRNr) {
    if (nRNr == m_nRNr) {
      return EChange.UNCHANGED;
    }
    m_nRNr = nRNr;
    return EChange.CHANGED;
  }

  @Nonnull
  public final String getName() {
    return m_sName;
  }

  @Nonnull
  final EChange setName(
    @Nonnull
    final String sName) {
    ValueEnforcer.notNull(sName, "Name");
    if (sName.equals(m_sName)) {
      return EChange.UNCHANGED;
    }
    m_sName = sName;
    return EChange.CHANGED;
  }

  public final int getAreaSize() {
    return m_nAreaSize;
  }

  @Nonnull
  final EChange setAreaSize(final int nAreaSize) {
    if (nAreaSize == m_nAreaSize) {
      return EChange.UNCHANGED;
    }
    m_nAreaSize = nAreaSize;
    return EChange.CHANGED;
  }
}
