package com.helger.aufnahme.businessobj;

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
 * @author JDMCodeGenerator
 */
public enum EExCaveTypeBO
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

  private EExCaveTypeBO(@Nonnull @Nonempty final String sID, @Nonnull @Nonempty final String sDisplayName) {
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
  public static EExCaveTypeBO getFromIDOrNull(@Nullable final String sID) {
    return EnumHelper.getFromIDOrNull(EExCaveTypeBO.class, sID);
  }

  @Nullable
  public static EExCaveTypeBO getFromIDOrDefault(@Nullable final String sID, @Nullable final EExCaveTypeBO eDefault) {
    return EnumHelper.getFromIDOrDefault(EExCaveTypeBO.class, sID, eDefault);
  }

  @Nonnull
  public static EExCaveTypeBO getFromIDOrThrow(@Nullable final String sID) {
    return EnumHelper.getFromIDOrThrow(EExCaveTypeBO.class, sID);
  }
}
