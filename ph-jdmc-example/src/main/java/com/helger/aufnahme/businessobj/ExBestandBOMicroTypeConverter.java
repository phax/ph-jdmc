/**
 * Copyright (C) 2018-2019 Philip Helger (www.helger.com)
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
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExBestandBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExBestandBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExBestandBO>
{
  private static final String ATTR_BNR = "bnr";
  private static final String ELEMENT_PICS = "pics";
  private static final String ATTR_DATE = "date";
  private static final String ELEMENT_VERORTUNG = "verortung";
  private static final String ELEMENT_BZHBG = "bzhbg";
  private static final String ATTR_AREASIZE = "areasize";
  private static final String ATTR_AREASIZELONG = "areasizelong";
  private static final String ATTR_AREASIZEFLOAT = "areasizefloat";
  private static final String ATTR_AREASIZEDOUBLE = "areasizedouble";
  private static final String ELEMENT_BESCHREIB = "beschreib";
  private static final String ATTR_SAMEAGE = "sameage";
  private static final String ATTR_ONELEVEL = "onelevel";
  private static final String ATTR_STOCKTYPE = "stocktype";
  private static final String ATTR_STOCKTYPEOPT = "stocktypeopt";
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
  public IMicroElement convertToMicroElement(@Nonnull final ExBestandBO aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_BNR, aValue.getBNr());
    for (final File aItem: aValue.pics()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_PICS).setAttributeWithConversion("value", aItem);
    }
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    if (aValue.hasVerortung()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_VERORTUNG).appendText(aValue.getVerortung());
    }
    for (final IExHabitatbaumgruppeBO aItem: aValue.BZHBG()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_BZHBG));
    }
    aElement.setAttributeWithConversion(ATTR_AREASIZE, aValue.getAreaSize());
    aElement.setAttributeWithConversion(ATTR_AREASIZELONG, aValue.getAreaSizeLong());
    aElement.setAttributeWithConversion(ATTR_AREASIZEFLOAT, aValue.getAreaSizeFloat());
    aElement.setAttributeWithConversion(ATTR_AREASIZEDOUBLE, aValue.getAreaSizeDouble());
    aElement.appendElement(sNamespaceURI, ELEMENT_BESCHREIB).appendText(aValue.getBeschreib());
    aElement.setAttribute(ATTR_SAMEAGE, aValue.isSameAge());
    aElement.setAttribute(ATTR_ONELEVEL, aValue.isOneLevel());
    aElement.setAttribute(ATTR_STOCKTYPE, aValue.getStockType().getID());
    if (aValue.hasStockTypeOpt()) {
      aElement.setAttribute(ATTR_STOCKTYPEOPT, aValue.getStockTypeOpt().getID());
    }
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
  public ExBestandBO convertToNative(@Nonnull final IMicroElement aElement) {
    final int nBNr = aElement.getAttributeValueAsInt(ATTR_BNR, -1);
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_PICS)) {
      aPics.add(aChild.getAttributeValueWithConversion("value", File.class));
    }
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final String sVerortung = MicroHelper.getChildTextContent(aElement, ELEMENT_VERORTUNG);
    final ICommonsList<IExHabitatbaumgruppeBO> aBZHBG = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_BZHBG)) {
      aBZHBG.add(MicroTypeConverter.convertToNative(aChild, ExHabitatbaumgruppeBO.class));
    }
    final Integer aAreaSize = aElement.getAttributeValueWithConversion(ATTR_AREASIZE, Integer.class);
    final Long aAreaSizeLong = aElement.getAttributeValueWithConversion(ATTR_AREASIZELONG, Long.class);
    final Float aAreaSizeFloat = aElement.getAttributeValueWithConversion(ATTR_AREASIZEFLOAT, Float.class);
    final Double aAreaSizeDouble = aElement.getAttributeValueWithConversion(ATTR_AREASIZEDOUBLE, Double.class);
    final String sBeschreib = MicroHelper.getChildTextContent(aElement, ELEMENT_BESCHREIB);
    final boolean bSameAge = aElement.getAttributeValueAsBool(ATTR_SAMEAGE, false);
    final boolean bOneLevel = aElement.getAttributeValueAsBool(ATTR_ONELEVEL, false);
    final EExStockTypeBO eStockType = EExStockTypeBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_STOCKTYPE));
    final EExStockTypeBO eStockTypeOpt = EExStockTypeBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_STOCKTYPEOPT));
    final String sUsageDescription = MicroHelper.getChildTextContent(aElement, ELEMENT_USAGEDESCRIPTION);
    final String sGesellschaft = MicroHelper.getChildTextContent(aElement, ELEMENT_GESELLSCHAFT);
    final boolean bKronenschluss = aElement.getAttributeValueAsBool(ATTR_KRONENSCHLUSS, false);
    final boolean bLightWoods = aElement.getAttributeValueAsBool(ATTR_LIGHTWOODS, false);
    final boolean bUnterwuchs = aElement.getAttributeValueAsBool(ATTR_UNTERWUCHS, false);
    final EExStockDeadwoodBO eTotSteh = EExStockDeadwoodBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TOT_STEH));
    final String sTotStehBesch = MicroHelper.getChildTextContent(aElement, ELEMENT_TOT_STEH_BESCH);
    final EExStockDeadwoodBO eTotLieg = EExStockDeadwoodBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_TOT_LIEG));
    final String sTotLiegBesch = MicroHelper.getChildTextContent(aElement, ELEMENT_TOT_LIEG_BESCH);
    return new ExBestandBO(super.getStubObject(aElement), nBNr, aPics, aDate, sVerortung, aBZHBG, aAreaSize, aAreaSizeLong, aAreaSizeFloat, aAreaSizeDouble, sBeschreib, bSameAge, bOneLevel, eStockType, eStockTypeOpt, sUsageDescription, sGesellschaft, bKronenschluss, bLightWoods, bUnterwuchs, eTotSteh, sTotStehBesch, eTotLieg, sTotLiegBesch);
  }
}
