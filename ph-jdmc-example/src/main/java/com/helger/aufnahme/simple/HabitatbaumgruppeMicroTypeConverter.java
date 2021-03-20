package com.helger.aufnahme.simple;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.IMicroTypeConverter;
import com.helger.xml.microdom.convert.MicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.IHabitatbaumgruppe}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class HabitatbaumgruppeMicroTypeConverter
  implements IMicroTypeConverter<Habitatbaumgruppe>
{
  private static final String ATTR_HBGNR = "hbgnr";
  private static final String ELEMENT_PICS = "pics";
  private static final String ELEMENT_HBGZBB = "hbgzbb";
  private static final String ATTR_DATE = "date";
  private static final String ELEMENT_STANDORT = "standort";
  private static final String ATTR_ONELEVEL = "onelevel";
  private static final String ATTR_LIGHT = "light";
  private static final String ATTR_CLOSEDCROWN = "closedcrown";
  private static final String ATTR_NOSUN = "nosun";
  private static final String ATTR_HOMOGEN = "homogen";
  private static final String ATTR_EXPOSITION = "exposition";
  private static final String ELEMENT_HANGLAGE = "hanglage";
  private static final String ATTR_AREASIZE = "areasize";
  private static final String ATTR_ONLYBB = "onlybb";
  private static final String ELEMENT_BESCHREIBUNG = "beschreibung";

  @Nonnull
  public IMicroElement convertToMicroElement(@Nonnull final Habitatbaumgruppe aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_HBGNR, aValue.getHBGNr());
    for (final File aItem: aValue.pics()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_PICS).setAttributeWithConversion("value", aItem);
    }
    for (final IBiotopbaum aItem: aValue.HBGzBB()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_HBGZBB));
    }
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    aElement.appendElement(sNamespaceURI, ELEMENT_STANDORT).appendText(aValue.getStandort());
    aElement.setAttribute(ATTR_ONELEVEL, aValue.isOneLevel());
    aElement.setAttribute(ATTR_LIGHT, aValue.isLight());
    aElement.setAttribute(ATTR_CLOSEDCROWN, aValue.isClosedCrown());
    aElement.setAttribute(ATTR_NOSUN, aValue.isNoSun());
    aElement.setAttribute(ATTR_HOMOGEN, aValue.isHomogen());
    aElement.setAttribute(ATTR_EXPOSITION, aValue.getExposition().getID());
    if (aValue.hasHanglage()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_HANGLAGE).appendText(aValue.getHanglage());
    }
    aElement.setAttribute(ATTR_AREASIZE, aValue.getAreaSize());
    aElement.setAttribute(ATTR_ONLYBB, aValue.isOnlyBB());
    aElement.appendElement(sNamespaceURI, ELEMENT_BESCHREIBUNG).appendText(aValue.getBeschreibung());
    return aElement;
  }

  @Nonnull
  public Habitatbaumgruppe convertToNative(@Nonnull final IMicroElement aElement) {
    final int nHBGNr = aElement.getAttributeValueAsInt(ATTR_HBGNR, -1);
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_PICS)) {
      aPics.add(aChild.getAttributeValueWithConversion("value", File.class));
    }
    final ICommonsList<IBiotopbaum> aHBGzBB = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_HBGZBB)) {
      aHBGzBB.add(MicroTypeConverter.convertToNative(aChild, Biotopbaum.class));
    }
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final String sStandort = MicroHelper.getChildTextContent(aElement, ELEMENT_STANDORT);
    final boolean bOneLevel = aElement.getAttributeValueAsBool(ATTR_ONELEVEL, false);
    final boolean bLight = aElement.getAttributeValueAsBool(ATTR_LIGHT, false);
    final boolean bClosedCrown = aElement.getAttributeValueAsBool(ATTR_CLOSEDCROWN, false);
    final boolean bNoSun = aElement.getAttributeValueAsBool(ATTR_NOSUN, false);
    final boolean bHomogen = aElement.getAttributeValueAsBool(ATTR_HOMOGEN, false);
    final EExposition eExposition = EExposition.getFromIDOrNull(aElement.getAttributeValue(ATTR_EXPOSITION));
    final String sHanglage = MicroHelper.getChildTextContent(aElement, ELEMENT_HANGLAGE);
    final int nAreaSize = aElement.getAttributeValueAsInt(ATTR_AREASIZE, -1);
    final boolean bOnlyBB = aElement.getAttributeValueAsBool(ATTR_ONLYBB, false);
    final String sBeschreibung = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIBUNG);
    return new Habitatbaumgruppe(nHBGNr, aPics, aHBGzBB, aDate, sStandort, bOneLevel, bLight, bClosedCrown, bNoSun, bHomogen, eExposition, sHanglage, nAreaSize, bOnlyBB, sBeschreibung);
  }
}
