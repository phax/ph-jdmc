package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IStichprobeDeadwood}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMProcessor
 */
public class StichprobeDeadwood
  extends AbstractBusinessObject
  implements IStichprobeDeadwood
{
  public static final ObjectType OT = new ObjectType("StichprobeDeadwood");
  private EDecompositionDegreeClass m_eDoD;
  private ETreeKind m_eTreeKind;
  private int m_nLength;
  private int m_nBHD;

  public StichprobeDeadwood(
    @Nonnull
    final EDecompositionDegreeClass eDoD,
    @Nonnull
    final ETreeKind eTreeKind, final int nLength, final int nBHD) {
    this(StubObject.createForCurrentUser(), eDoD, eTreeKind, nLength, nBHD);
  }

  protected StichprobeDeadwood(final StubObject aStubObject,
    @Nonnull
    final EDecompositionDegreeClass eDoD,
    @Nonnull
    final ETreeKind eTreeKind, final int nLength, final int nBHD) {
    super(aStubObject);
    setDoD(eDoD);
    setTreeKind(eTreeKind);
    setLength(nLength);
    setBHD(nBHD);
  }

  @Nonnull
  public final ObjectType getObjectType() {
    return OT;
  }

  @Nonnull
  public final EDecompositionDegreeClass getDoD() {
    return m_eDoD;
  }

  @Nonnull
  public final EChange setDoD(
    @Nonnull
    final EDecompositionDegreeClass eDoD) {
    ValueEnforcer.notNull(eDoD, "DoD");
    if (eDoD.equals(m_eDoD)) {
      return EChange.UNCHANGED;
    }
    m_eDoD = eDoD;
    return EChange.CHANGED;
  }

  @Nonnull
  public final ETreeKind getTreeKind() {
    return m_eTreeKind;
  }

  @Nonnull
  public final EChange setTreeKind(
    @Nonnull
    final ETreeKind eTreeKind) {
    ValueEnforcer.notNull(eTreeKind, "TreeKind");
    if (eTreeKind.equals(m_eTreeKind)) {
      return EChange.UNCHANGED;
    }
    m_eTreeKind = eTreeKind;
    return EChange.CHANGED;
  }

  public final int getLength() {
    return m_nLength;
  }

  @Nonnull
  public final EChange setLength(final int nLength) {
    if (nLength == m_nLength) {
      return EChange.UNCHANGED;
    }
    m_nLength = nLength;
    return EChange.CHANGED;
  }

  public final int getBHD() {
    return m_nBHD;
  }

  @Nonnull
  public final EChange setBHD(final int nBHD) {
    if (nBHD == m_nBHD) {
      return EChange.UNCHANGED;
    }
    m_nBHD = nBHD;
    return EChange.CHANGED;
  }
}
