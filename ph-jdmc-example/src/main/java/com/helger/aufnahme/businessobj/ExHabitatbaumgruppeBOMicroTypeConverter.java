/*
 * Copyright (C) 2018-2024 Philip Helger (www.helger.com)
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.MicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExHabitatbaumgruppeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExHabitatbaumgruppeBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExHabitatbaumgruppeBO>
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
  public IMicroElement convertToMicroElement(@Nonnull final ExHabitatbaumgruppeBO aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_HBGNR, aValue.getHBGNr());
    for (final File aItem: aValue.pics()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_PICS).setAttributeWithConversion("value", aItem);
    }
    for (final IExBiotopbaumBO aItem: aValue.HBGzBB()) {
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
  public ExHabitatbaumgruppeBO convertToNative(@Nonnull final IMicroElement aElement) {
    final int nHBGNr = aElement.getAttributeValueAsInt(ATTR_HBGNR, -1);
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_PICS)) {
      aPics.add(aChild.getAttributeValueWithConversion("value", File.class));
    }
    final ICommonsList<IExBiotopbaumBO> aHBGzBB = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_HBGZBB)) {
      aHBGzBB.add(MicroTypeConverter.convertToNative(aChild, ExBiotopbaumBO.class));
    }
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final String sStandort = MicroHelper.getChildTextContent(aElement, ELEMENT_STANDORT);
    final boolean bOneLevel = aElement.getAttributeValueAsBool(ATTR_ONELEVEL, false);
    final boolean bLight = aElement.getAttributeValueAsBool(ATTR_LIGHT, false);
    final boolean bClosedCrown = aElement.getAttributeValueAsBool(ATTR_CLOSEDCROWN, false);
    final boolean bNoSun = aElement.getAttributeValueAsBool(ATTR_NOSUN, false);
    final boolean bHomogen = aElement.getAttributeValueAsBool(ATTR_HOMOGEN, false);
    final EExExpositionBO eExposition = EExExpositionBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_EXPOSITION));
    final String sHanglage = MicroHelper.getChildTextContent(aElement, ELEMENT_HANGLAGE);
    final int nAreaSize = aElement.getAttributeValueAsInt(ATTR_AREASIZE, -1);
    final boolean bOnlyBB = aElement.getAttributeValueAsBool(ATTR_ONLYBB, false);
    final String sBeschreibung = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIBUNG);
    return new ExHabitatbaumgruppeBO(super.getStubObject(aElement), nHBGNr, aPics, aHBGzBB, aDate, sStandort, bOneLevel, bLight, bClosedCrown, bNoSun, bHomogen, eExposition, sHanglage, nAreaSize, bOnlyBB, sBeschreibung);
  }
}
