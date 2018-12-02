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
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.simple.IBiotopbaum}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class BiotopbaumMicroTypeConverter
  implements IMicroTypeConverter<Biotopbaum>
{
  private static final String ATTR_BBNR = "bbnr";
  private static final String ELEMENT_PICS = "pics";
  private static final String ATTR_DATE = "date";
  private static final String ELEMENT_TYPE = "type";
  private static final String ELEMENT_LOCATION = "location";
  private static final String ATTR_EXPOSITION = "exposition";
  private static final String ELEMENT_HANGLAGE = "hanglage";
  private static final String ATTR_EINSCHICHTIG = "einschichtig";
  private static final String ATTR_SOLITARY = "solitary";
  private static final String ATTR_LIGHTLOCATION = "lightlocation";
  private static final String ATTR_CLOSEDCROWN = "closedcrown";
  private static final String ATTR_NOSUN = "nosun";
  private static final String ATTR_UEBERSUN = "uebersun";
  private static final String ATTR_HOMOGENE = "homogene";
  private static final String ELEMENT_BESCHREIBUNG = "beschreibung";
  private static final String ATTR_TREEKIND = "treekind";
  private static final String ELEMENT_CAVES = "caves";
  private static final String ELEMENT_TRUNK = "trunk";
  private static final String ATTR_VITALITY = "vitality";
  private static final String ELEMENT_SPECIALSTRUCTURE = "specialstructure";
  private static final String ELEMENT_OTHERSPECIAL = "otherspecial";
  private static final String ATTR_ASPIRANT = "aspirant";
  private static final String ELEMENT_ASPIRANTDESC = "aspirantdesc";
  private static final String ATTR_MARKED = "marked";
  private static final String ELEMENT_MARKEDDESC = "markeddesc";
  private static final String ELEMENT_DEADWOODCATS = "deadwoodcats";
  private static final String ELEMENT_DEADWOODDOD = "deadwooddod";

  @Nonnull
  public IMicroElement convertToMicroElement(
    @Nonnull
    final Biotopbaum aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    aElement.setAttribute(ATTR_BBNR, aValue.getBBNr());
    // TODO File::pics
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    // TODO EBiotopbaumType::type
    if (aValue.hasLocation()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_LOCATION).appendText(aValue.getLocation());
    }
    aElement.setAttribute(ATTR_EXPOSITION, aValue.getExposition().getID());
    if (aValue.hasHanglage()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_HANGLAGE).appendText(aValue.getHanglage());
    }
    aElement.setAttribute(ATTR_EINSCHICHTIG, aValue.isEinschichtig());
    aElement.setAttribute(ATTR_SOLITARY, aValue.isSolitary());
    aElement.setAttribute(ATTR_LIGHTLOCATION, aValue.isLightLocation());
    aElement.setAttribute(ATTR_CLOSEDCROWN, aValue.isClosedCrown());
    aElement.setAttribute(ATTR_NOSUN, aValue.isNoSun());
    aElement.setAttribute(ATTR_UEBERSUN, aValue.isUeberSun());
    aElement.setAttribute(ATTR_HOMOGENE, aValue.isHomogene());
    aElement.appendElement(sNamespaceURI, ELEMENT_BESCHREIBUNG).appendText(aValue.getBeschreibung());
    aElement.setAttribute(ATTR_TREEKIND, aValue.getTreeKind().getID());
    // TODO CaveType::caves
    // TODO TrunkSize::trunk
    aElement.setAttribute(ATTR_VITALITY, aValue.getVitality().getID());
    // TODO ESpecialStructure::specialStructure
    if (aValue.hasOtherSpecial()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_OTHERSPECIAL).appendText(aValue.getOtherSpecial());
    }
    aElement.setAttribute(ATTR_ASPIRANT, aValue.isAspirant());
    if (aValue.hasAspirantDesc()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_ASPIRANTDESC).appendText(aValue.getAspirantDesc());
    }
    aElement.setAttribute(ATTR_MARKED, aValue.isMarked());
    if (aValue.hasMarkedDesc()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_MARKEDDESC).appendText(aValue.getMarkedDesc());
    }
    // TODO BiotopbaumDeadwood::deadwoodCats
    // TODO BiotopbaumDecompositionDegree::deadwoodDoD
    return aElement;
  }

  @Nonnull
  public Biotopbaum convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final int nBBNr = aElement.getAttributeValueAsInt(ATTR_BBNR, -1);
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final ICommonsList<EBiotopbaumType> eType = new CommonsArrayList<>();
    final String sLocation = MicroHelper.getChildTextContent(aElement, ELEMENT_LOCATION);
    final EExposition eExposition = EExposition.getFromIDOrNull(aElement.getAttributeValue(ATTR_EXPOSITION));
    final String sHanglage = MicroHelper.getChildTextContent(aElement, ELEMENT_HANGLAGE);
    final boolean bEinschichtig = aElement.getAttributeValueAsBool(ATTR_EINSCHICHTIG, false);
    final boolean bSolitary = aElement.getAttributeValueAsBool(ATTR_SOLITARY, false);
    final boolean bLightLocation = aElement.getAttributeValueAsBool(ATTR_LIGHTLOCATION, false);
    final boolean bClosedCrown = aElement.getAttributeValueAsBool(ATTR_CLOSEDCROWN, false);
    final boolean bNoSun = aElement.getAttributeValueAsBool(ATTR_NOSUN, false);
    final boolean bUeberSun = aElement.getAttributeValueAsBool(ATTR_UEBERSUN, false);
    final boolean bHomogene = aElement.getAttributeValueAsBool(ATTR_HOMOGENE, false);
    final String sBeschreibung = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIBUNG);
    final ETreeKind eTreeKind = ETreeKind.getFromIDOrNull(aElement.getAttributeValue(ATTR_TREEKIND));
    final ICommonsList<CaveType> aCaves = new CommonsArrayList<>();
    final ICommonsList<TrunkSize> aTrunk = new CommonsArrayList<>();
    final EVitality eVitality = EVitality.getFromIDOrNull(aElement.getAttributeValue(ATTR_VITALITY));
    final ICommonsList<ESpecialStructure> eSpecialStructure = new CommonsArrayList<>();
    final String sOtherSpecial = MicroHelper.getChildTextContent(aElement, ELEMENT_OTHERSPECIAL);
    final boolean bAspirant = aElement.getAttributeValueAsBool(ATTR_ASPIRANT, false);
    final String sAspirantDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_ASPIRANTDESC);
    final boolean bMarked = aElement.getAttributeValueAsBool(ATTR_MARKED, false);
    final String sMarkedDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_MARKEDDESC);
    final ICommonsList<BiotopbaumDeadwood> aDeadwoodCats = new CommonsArrayList<>();
    final ICommonsList<BiotopbaumDecompositionDegree> aDeadwoodDoD = new CommonsArrayList<>();
    return new Biotopbaum(nBBNr, aPics, aDate, eType, sLocation, eExposition, sHanglage, bEinschichtig, bSolitary, bLightLocation, bClosedCrown, bNoSun, bUeberSun, bHomogene, sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, eSpecialStructure, sOtherSpecial, bAspirant, sAspirantDesc, bMarked, sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
  }
}
