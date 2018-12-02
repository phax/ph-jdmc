package com.helger.aufnahme.simple;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.IBestand}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class BestandMicroTypeConverter
  implements IMicroTypeConverter<Bestand>
{
  private static final String ATTR_BNR = "bnr";
  private static final String ELEMENT_PICS = "pics";
  private static final String ATTR_DATE = "date";
  private static final String ELEMENT_VERORTUNG = "verortung";
  private static final String ELEMENT_BZHBG = "bzhbg";
  private static final String ATTR_AREASIZE = "areasize";
  private static final String ELEMENT_BESCHREIB = "beschreib";
  private static final String ATTR_SAMEAGE = "sameage";
  private static final String ATTR_ONELEVEL = "onelevel";
  private static final String ATTR_STOCKTYPE = "stocktype";
  private static final String ELEMENT_USAGEDESCRIPTION = "usagedescription";
  private static final String ELEMENT_GESELLSCHAFT = "gesellschaft";
  private static final String ATTR_KRONENSCHLUSS = "kronenschluss";
  private static final String ATTR_LIGHTWOODS = "lightwoods";
  private static final String ATTR_UNTERWUCHS = "unterwuchs";
  private static final String ATTR_TOT_STEH = "totsteh";
  private static final String ELEMENT_TOT_STEH_BESCH = "totstehbesch";
  private static final String ATTR_TOT_LIEG = "totlieg";
  private static final String ELEMENT_TOT_LIEG_BESCH = "totliegbesch";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final Bestand aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_BNR, aValue.getBNr());
    // TODO File::pics
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    if (aValue.hasVerortung()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_VERORTUNG).appendText(aValue.getVerortung());
    }
    // TODO Habitatbaumgruppe::BZHBG
    aElement.setAttribute(ATTR_AREASIZE, aValue.getAreaSize());
    aElement.appendElement(sNamespaceURI, ELEMENT_BESCHREIB).appendText(aValue.getBeschreib());
    aElement.setAttribute(ATTR_SAMEAGE, aValue.isSameAge());
    aElement.setAttribute(ATTR_ONELEVEL, aValue.isOneLevel());
    aElement.setAttribute(ATTR_STOCKTYPE, aValue.getStockType().getID());
    aElement.appendElement(sNamespaceURI, ELEMENT_USAGEDESCRIPTION).appendText(aValue.getUsageDescription());
    aElement.appendElement(sNamespaceURI, ELEMENT_GESELLSCHAFT).appendText(aValue.getGesellschaft());
    aElement.setAttribute(ATTR_KRONENSCHLUSS, aValue.isKronenschluss());
    aElement.setAttribute(ATTR_LIGHTWOODS, aValue.isLightWoods());
    aElement.setAttribute(ATTR_UNTERWUCHS, aValue.isUnterwuchs());
    aElement.setAttribute(ATTR_TOT_STEH, aValue.getTotSteh().getID());
    aElement.appendElement(sNamespaceURI, ELEMENT_TOT_STEH_BESCH).appendText(aValue.getTotStehBesch());
    aElement.setAttribute(ATTR_TOT_LIEG, aValue.getTotLieg().getID());
    aElement.appendElement(sNamespaceURI, ELEMENT_TOT_LIEG_BESCH).appendText(aValue.getTotLiegBesch());
    return aElement;
  }

  @Nonnull
  public Bestand convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final int nBNr = aElement.getAttributeValueAsInt(ATTR_BNR, -1);
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final String sVerortung = MicroHelper.getChildTextContent(aElement, ELEMENT_VERORTUNG);
    final ICommonsList<Habitatbaumgruppe> aBZHBG = new CommonsArrayList<>();
    final int nAreaSize = aElement.getAttributeValueAsInt(ATTR_AREASIZE, -1);
    final String sBeschreib = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIB);
    final boolean bSameAge = aElement.getAttributeValueAsBool(ATTR_SAMEAGE, false);
    final boolean bOneLevel = aElement.getAttributeValueAsBool(ATTR_ONELEVEL, false);
    final EStockType eStockType = EStockType.getFromIDOrNull(aElement.getAttributeValue(ATTR_STOCKTYPE));
    final String sUsageDescription = MicroHelper.getChildTextContent(aElement, ELEMENT_USAGEDESCRIPTION);
    final String sGesellschaft = MicroHelper.getChildTextContent(aElement, ELEMENT_GESELLSCHAFT);
    final boolean bKronenschluss = aElement.getAttributeValueAsBool(ATTR_KRONENSCHLUSS, false);
    final boolean bLightWoods = aElement.getAttributeValueAsBool(ATTR_LIGHTWOODS, false);
    final boolean bUnterwuchs = aElement.getAttributeValueAsBool(ATTR_UNTERWUCHS, false);
    final EStockDeadwood eTotSteh = EStockDeadwood.getFromIDOrNull(aElement.getAttributeValue(ATTR_TOT_STEH));
    final String sTotStehBesch = MicroHelper.getChildTextContent(aElement, ELEMENT_TOT_STEH_BESCH);
    final EStockDeadwood eTotLieg = EStockDeadwood.getFromIDOrNull(aElement.getAttributeValue(ATTR_TOT_LIEG));
    final String sTotLiegBesch = MicroHelper.getChildTextContent(aElement, ELEMENT_TOT_LIEG_BESCH);
    return new Bestand(nBNr, aPics, aDate, sVerortung, aBZHBG, nAreaSize, sBeschreib, bSameAge, bOneLevel, eStockType, sUsageDescription, sGesellschaft, bKronenschluss, bLightWoods, bUnterwuchs, eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
  }
}
