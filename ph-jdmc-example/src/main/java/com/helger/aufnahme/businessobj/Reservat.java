package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IReservat}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class Reservat
  extends AbstractBusinessObject
  implements IReservat
{
  public static final ObjectType OT = new ObjectType("Reservat");
  private int m_nRNr;
  private String m_sName;
  private int m_nAreaSize;

  public Reservat(final int nRNr,
    @Nonnull
    final String sName, final int nAreaSize) {
    this(StubObject.createForCurrentUser(), nRNr, sName, nAreaSize);
  }

  protected Reservat(final StubObject aStubObject, final int nRNr,
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

  public final int getRNr() {
    return m_nRNr;
  }

  @Nonnull
  public final EChange setRNr(final int nRNr) {
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
  public final EChange setName(
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
  public final EChange setAreaSize(final int nAreaSize) {
    if (nAreaSize == m_nAreaSize) {
      return EChange.UNCHANGED;
    }
    m_nAreaSize = nAreaSize;
    return EChange.CHANGED;
  }
}
