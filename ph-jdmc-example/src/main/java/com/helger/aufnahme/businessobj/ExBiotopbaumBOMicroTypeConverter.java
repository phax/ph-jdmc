/*
 * Copyright (C) 2018-2022 Philip Helger (www.helger.com)
 * philip[at]helger[dot]com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.MicroTypeConverter;
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
  public IMicroElement convertToMicroElement(@Nonnull final ExBiotopbaumBO aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_BBNR, aValue.getBBNr());
    for (final File aItem: aValue.pics()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_PICS).setAttributeWithConversion("value", aItem);
    }
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    for (final EExBiotopbaumTypeBO aItem: aValue.type()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_TYPE).setAttribute("value", aItem.getID());
    }
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
    for (final IExCaveTypeBO aItem: aValue.caves()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_CAVES));
    }
    for (final IExTrunkSizeBO aItem: aValue.trunk()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_TRUNK));
    }
    aElement.setAttribute(ATTR_VITALITY, aValue.getVitality().getID());
    for (final EExSpecialStructureBO aItem: aValue.specialStructure()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_SPECIALSTRUCTURE).setAttribute("value", aItem.getID());
    }
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
    for (final IExBiotopbaumDeadwoodBO aItem: aValue.deadwoodCats()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_DEADWOODCATS));
    }
    for (final IExBiotopbaumDecompositionDegreeBO aItem: aValue.deadwoodDoD()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_DEADWOODDOD));
    }
    return aElement;
  }

  @Nonnull
  public ExBiotopbaumBO convertToNative(@Nonnull final IMicroElement aElement) {
    final int nBBNr = aElement.getAttributeValueAsInt(ATTR_BBNR, -1);
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_PICS)) {
      aPics.add(aChild.getAttributeValueWithConversion("value", File.class));
    }
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final ICommonsList<EExBiotopbaumTypeBO> aType = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_TYPE)) {
      aType.add(EExBiotopbaumTypeBO.getFromIDOrNull(aChild.getAttributeValue("value")));
    }
    final String sLocation = MicroHelper.getChildTextContent(aElement, ELEMENT_LOCATION);
    final EExExpositionBO eExposition = EExExpositionBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_EXPOSITION));
    final String sHanglage = MicroHelper.getChildTextContent(aElement, ELEMENT_HANGLAGE);
    final boolean bEinschichtig = aElement.getAttributeValueAsBool(ATTR_EINSCHICHTIG, false);
    final boolean bSolitary = aElement.getAttributeValueAsBool(ATTR_SOLITARY, false);
    final boolean bLightLocation = aElement.getAttributeValueAsBool(ATTR_LIGHTLOCATION, false);
    final boolean bClosedCrown = aElement.getAttributeValueAsBool(ATTR_CLOSEDCROWN, false);
    final boolean bNoSun = aElement.getAttributeValueAsBool(ATTR_NOSUN, false);
    final boolean bUeberSun = aElement.getAttributeValueAsBool(ATTR_UEBERSUN, false);
    final boolean bHomogene = aElement.getAttributeValueAsBool(ATTR_HOMOGENE, false);
    final String sBeschreibung = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIBUNG);
    final EExTreeKindBO eTreeKind = EExTreeKindBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TREEKIND));
    final ICommonsList<IExCaveTypeBO> aCaves = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_CAVES)) {
      aCaves.add(MicroTypeConverter.convertToNative(aChild, ExCaveTypeBO.class));
    }
    final ICommonsList<IExTrunkSizeBO> aTrunk = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_TRUNK)) {
      aTrunk.add(MicroTypeConverter.convertToNative(aChild, ExTrunkSizeBO.class));
    }
    final EExVitalityBO eVitality = EExVitalityBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_VITALITY));
    final ICommonsList<EExSpecialStructureBO> aSpecialStructure = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_SPECIALSTRUCTURE)) {
      aSpecialStructure.add(EExSpecialStructureBO.getFromIDOrNull(aChild.getAttributeValue("value")));
    }
    final String sOtherSpecial = MicroHelper.getChildTextContent(aElement, ELEMENT_OTHERSPECIAL);
    final boolean bAspirant = aElement.getAttributeValueAsBool(ATTR_ASPIRANT, false);
    final String sAspirantDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_ASPIRANTDESC);
    final boolean bMarked = aElement.getAttributeValueAsBool(ATTR_MARKED, false);
    final String sMarkedDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_MARKEDDESC);
    final ICommonsList<IExBiotopbaumDeadwoodBO> aDeadwoodCats = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_DEADWOODCATS)) {
      aDeadwoodCats.add(MicroTypeConverter.convertToNative(aChild, ExBiotopbaumDeadwoodBO.class));
    }
    final ICommonsList<IExBiotopbaumDecompositionDegreeBO> aDeadwoodDoD = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_DEADWOODDOD)) {
      aDeadwoodDoD.add(MicroTypeConverter.convertToNative(aChild, ExBiotopbaumDecompositionDegreeBO.class));
    }
    return new ExBiotopbaumBO(super.getStubObject(aElement), nBBNr, aPics, aDate, aType, sLocation, eExposition, sHanglage, bEinschichtig, bSolitary, bLightLocation, bClosedCrown, bNoSun, bUeberSun, bHomogene, sBeschreibung, eTreeKind, aCaves, aTrunk, eVitality, aSpecialStructure, sOtherSpecial, bAspirant, sAspirantDesc, bMarked, sMarkedDesc, aDeadwoodCats, aDeadwoodDoD);
  }
}
