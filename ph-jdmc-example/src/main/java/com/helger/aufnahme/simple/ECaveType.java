package com.helger.aufnahme.simple;

import com.helger.commons.annotation.Nonempty;
import com.helger.commons.id.IHasID;
import com.helger.commons.lang.EnumHelper;
import com.helger.commons.name.IHasDisplayName;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * This class was initially automatically created
 * 
 * 
 * @author JDMProcessor
 */
public enum ECaveType
  implements IHasID<String> , IHasDisplayName
{
  _1("1", "abstehende Rinde /  Rindentasche"),
  _2("2", "Faul- Spalth\u00f6hle < 5 cm (nicht tierischer Ursprung)"),
  _3("3", "Faul- Spalth\u00f6hle \u2265 5 cm (nicht tierischer Ursprung)"),
  _4("4", "Faulh\u00f6hle- Spalth\u00f6hle  > 10 cm (nicht tierischer Ursprung)"),
  _5("5", "Hohler Stamm"),
  _6("6", "Stammfu\u00dfh\u00f6hle"),
  _7("7", "begonnene H\u00f6hlen (Initialen)"),
  _8("8", "eindeutige Spechth\u00f6hle < 5 cm"),
  _9("9", "eindeutige Spechth\u00f6hle \u2265 5 cm"),
  _10("10", "Gro\u00dfh\u00f6hle > 10 cm "),
  OTHER("other", "Sonstige");
  private final String m_sID;
  private final String m_sDisplayName;

  private ECaveType(
    @Nonnull
    @Nonempty
    final String sID,
    @Nonnull
    @Nonempty
    final String sDisplayName) {
    m_sID = sID;
    m_sDisplayName = sDisplayName;
  }

  @Nonnull
  @Nonempty
  public String getID() {
    return m_sID;
  }

  @Nonnull
  @Nonempty
  public String getDisplayName() {
    return m_sDisplayName;
  }

  @Nullable
  public static ECaveType getFromIDOrNull(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrNull(ECaveType.class, sID);
  }

  @Nullable
  public static ECaveType getFromIDOrDefault(
    @Nullable
    final String sID,
    @Nullable
    final ECaveType eDefault) {
    return EnumHelper.getFromIDOrDefault(ECaveType.class, sID, eDefault);
  }

  @Nonnull
  public static ECaveType getFromIDOrThrow(
    @Nullable
    final String sID) {
    return EnumHelper.getFromIDOrThrow(ECaveType.class, sID);
  }
}
