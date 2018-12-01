package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.util.MicroHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExBiotopbaumBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBiotopbaumBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExBiotopbaumBO>
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
    final ExBiotopbaumBO aValue,
    @Nullable
    final String sNamespaceURI,
    @Nonnull
    final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_BBNR, aValue.getBBNr());
    // TODO File::pics
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    // TODO EExBiotopbaumTypeBO::type
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
    // TODO ExCaveTypeBO::caves
    // TODO ExTrunkSizeBO::trunk
    aElement.setAttribute(ATTR_VITALITY, aValue.getVitality().getID());
    // TODO EExSpecialStructureBO::specialStructure
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
    // TODO ExBiotopbaumDeadwoodBO::deadwoodCats
    // TODO ExBiotopbaumDecompositionDegreeBO::deadwoodDoD
    return aElement;
  }

  @Nonnull
  public ExBiotopbaumBO convertToNative(
    @Nonnull
    final IMicroElement aElement) {
    final int nBBNr = aElement.getAttributeValueWithConversion(ATTR_BBNR, int.class);
    // TODO File::pics
    final ICommonsList<File> aPics;
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    // TODO EExBiotopbaumTypeBO::type
    final ICommonsList<EExBiotopbaumTypeBO> eType;
    final String sLocation = MicroHelper.getChildTextContent(aElement, ELEMENT_LOCATION);
    final EExExpositionBO eExposition = EExExpositionBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_EXPOSITION));
    final String sHanglage = MicroHelper.getChildTextContent(aElement, ELEMENT_HANGLAGE);
    final boolean bEinschichtig = aElement.getAttributeValueWithConversion(ATTR_EINSCHICHTIG, boolean.class);
    final boolean bSolitary = aElement.getAttributeValueWithConversion(ATTR_SOLITARY, boolean.class);
    final boolean bLightLocation = aElement.getAttributeValueWithConversion(ATTR_LIGHTLOCATION, boolean.class);
    final boolean bClosedCrown = aElement.getAttributeValueWithConversion(ATTR_CLOSEDCROWN, boolean.class);
    final boolean bNoSun = aElement.getAttributeValueWithConversion(ATTR_NOSUN, boolean.class);
    final boolean bUeberSun = aElement.getAttributeValueWithConversion(ATTR_UEBERSUN, boolean.class);
    final boolean bHomogene = aElement.getAttributeValueWithConversion(ATTR_HOMOGENE, boolean.class);
    final String sBeschreibung = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIBUNG);
    final EExTreeKindBO eTreeKind = EExTreeKindBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TREEKIND));
    // TODO ExCaveTypeBO::caves
    final ICommonsList<ExCaveTypeBO> aCaves;
    // TODO ExTrunkSizeBO::trunk
    final ICommonsList<ExTrunkSizeBO> aTrunk;
    final EExVitalityBO eVitality = EExVitalityBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_VITALITY));
    // TODO EExSpecialStructureBO::specialStructure
    final ICommonsList<EExSpecialStructureBO> eSpecialStructure;
    final String sOtherSpecial = MicroHelper.getChildTextContent(aElement, ELEMENT_OTHERSPECIAL);
    final boolean bAspirant = aElement.getAttributeValueWithConversion(ATTR_ASPIRANT, boolean.class);
    final String sAspirantDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_ASPIRANTDESC);
    final boolean bMarked = aElement.getAttributeValueWithConversion(ATTR_MARKED, boolean.class);
    final String sMarkedDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_MARKEDDESC);
    // TODO ExBiotopbaumDeadwoodBO::deadwoodCats
    final ICommonsList<ExBiotopbaumDeadwoodBO> aDeadwoodCats;
    // TODO ExBiotopbaumDecompositionDegreeBO::deadwoodDoD
    final ICommonsList<ExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD;
    return new ExBiotopbaumBO(super.getStubObject(aElement), nBBNr, aPics, aDate, eType, sLocation, eExposition, sHanglage, bEinschichtig, bSolitary, bLightLocation, bClosedCrown, bNoSun, bUeberSun, bHomogene, sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, eSpecialStructure, sOtherSpecial, bAspirant, sAspirantDesc, bMarked, sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
  }
}
