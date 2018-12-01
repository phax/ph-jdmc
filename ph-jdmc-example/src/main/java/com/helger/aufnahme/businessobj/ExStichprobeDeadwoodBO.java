package com.helger.aufnahme.businessobj;

import com.helger.commons.ValueEnforcer;
import com.helger.commons.state.EChange;
import com.helger.commons.string.ToStringGenerator;
import com.helger.commons.type.ObjectType;
import com.helger.photon.security.object.StubObject;
import com.helger.tenancy.AbstractBusinessObject;
import javax.annotation.Nonnull;


/**
 * <p>Default implementation of {@link com.helger.aufnahme.businessobj.IExStichprobeDeadwoodBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExStichprobeDeadwoodBO
  extends AbstractBusinessObject
  implements IExStichprobeDeadwoodBO
{
  public static final ObjectType OT = new ObjectType("ExStichprobeDeadwoodBO");
  private EExDecompositionDegreeClassBO m_eDoD;
  private EExTreeKindBO m_eTreeKind;
  private int m_nLength;
  private int m_nBHD;

  public ExStichprobeDeadwoodBO(
    @Nonnull
    final EExDecompositionDegreeClassBO eDoD,
    @Nonnull
    final EExTreeKindBO eTreeKind, final int nLength, final int nBHD) {
    this(StubObject.createForCurrentUser(), eDoD, eTreeKind, nLength, nBHD);
  }

  protected ExStichprobeDeadwoodBO(final StubObject aStubObject,
    @Nonnull
    final EExDecompositionDegreeClassBO eDoD,
    @Nonnull
    final EExTreeKindBO eTreeKind, final int nLength, final int nBHD) {
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

  @Override
  public String toString() {
    return ToStringGenerator.getDerived(super.toString()).append("DoD", m_eDoD).append("treeKind", m_eTreeKind).append("length", m_nLength).append("BHD", m_nBHD).getToString();
  }

  @Nonnull
  public final EExDecompositionDegreeClassBO getDoD() {
    return m_eDoD;
  }

  @Nonnull
  final EChange setDoD(
    @Nonnull
    final EExDecompositionDegreeClassBO eDoD) {
    ValueEnforcer.notNull(eDoD, "DoD");
    if (eDoD.equals(m_eDoD)) {
      return EChange.UNCHANGED;
    }
    m_eDoD = eDoD;
    return EChange.CHANGED;
  }

  @Nonnull
  public final EExTreeKindBO getTreeKind() {
    return m_eTreeKind;
  }

  @Nonnull
  final EChange setTreeKind(
    @Nonnull
    final EExTreeKindBO eTreeKind) {
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
  final EChange setLength(final int nLength) {
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
  final EChange setBHD(final int nBHD) {
    if (nBHD == m_nBHD) {
      return EChange.UNCHANGED;
    }
    m_nBHD = nBHD;
    return EChange.CHANGED;
  }
}
