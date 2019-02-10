package com.helger.aufnahme.businessobj;

import java.io.File;
import java.time.LocalDate;
import com.helger.commons.collection.impl.CommonsArrayList;
import com.helger.commons.collection.impl.ICommonsList;
import com.helger.commons.functional.IFunction;
import com.helger.photon.security.object.AbstractBusinessObjectMicroTypeConverter;
import com.helger.xml.microdom.IMicroElement;
import com.helger.xml.microdom.MicroElement;
import com.helger.xml.microdom.convert.MicroTypeConverter;
import com.helger.xml.microdom.util.MicroHelper;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;


/**
 * <p>Default MicroTypeConverter implementation of {@link com.helger.aufnahme.businessobj.IExStichprobeBO}</p>
 * <p>This class was initially automatically created</p>
 * 
 * 
 * @author JDMCodeGenerator
 */
public class ExStichprobeBOMicroTypeConverter
  extends AbstractBusinessObjectMicroTypeConverter<ExStichprobeBO>
{
  private static final String ATTR_STICHNR = "stichnr";
  private static final String ATTR_STICHNRZR = "stichnrzr";
  private static final String ELEMENT_PICS = "pics";
  private static final String ATTR_DATE = "date";
  private static final String ATTR_SIZE = "size";
  private static final String ATTR_EXPOSITION = "exposition";
  private static final String ELEMENT_HANGLAGE = "hanglage";
  private static final String ELEMENT_GESELLSCHAFT = "gesellschaft";
  private static final String ATTR_BKL0 = "bkl0";
  private static final String ATTR_BKL1 = "bkl1";
  private static final String ATTR_BKL2 = "bkl2";
  private static final String ATTR_BKL3 = "bkl3";
  private static final String ATTR_BKL4 = "bkl4";
  private static final String ATTR_BKL5 = "bkl5";
  private static final String ATTR_BKL6 = "bkl6";
  private static final String ATTR_BKL7 = "bkl7";
  private static final String ATTR_BKL8 = "bkl8";
  private static final String ATTR_BKL9 = "bkl9";
  private static final String ELEMENT_USAGE = "usage";
  private static final String ELEMENT_USAGEDESC = "usagedesc";
  private static final String ELEMENT_TREES = "trees";
  private static final String ELEMENT_DESC = "desc";
  private static final String ATTR_SAMEAGE = "sameage";
  private static final String ATTR_ONELEVEL = "onelevel";
  private static final String ELEMENT_TOT_STEH = "totsteh";
  private static final String ELEMENT_TOT_LIEG_1 = "totlieg1";
  private static final String ELEMENT_TOT_LIEG_2 = "totlieg2";
  private final IFunction<String, ? extends IExReservatBO> m_aResolverExReservatBO;

  public ExStichprobeBOMicroTypeConverter(@Nonnull IFunction<String, ? extends IExReservatBO> aResolverExReservatBO) {
    m_aResolverExReservatBO = aResolverExReservatBO;
  }

  @Nonnull
  public IMicroElement convertToMicroElement(@Nonnull final ExStichprobeBO aValue, @Nullable final String sNamespaceURI, @Nonnull final String sTagName) {
    final IMicroElement aElement = new MicroElement(sNamespaceURI, sTagName);
    super.setObjectFields(aValue, aElement);
    aElement.setAttribute(ATTR_STICHNR, aValue.getStichNr());
    aElement.setAttribute(ATTR_STICHNRZR, aValue.getStichNrzR().getID());
    for (final File aItem: aValue.pics()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_PICS).setAttributeWithConversion("value", aItem);
    }
    aElement.setAttributeWithConversion(ATTR_DATE, aValue.getDate());
    aElement.setAttribute(ATTR_SIZE, aValue.getSize());
    aElement.setAttribute(ATTR_EXPOSITION, aValue.getExposition().getID());
    if (aValue.hasHanglage()) {
      aElement.appendElement(sNamespaceURI, ELEMENT_HANGLAGE).appendText(aValue.getHanglage());
    }
    aElement.appendElement(sNamespaceURI, ELEMENT_GESELLSCHAFT).appendText(aValue.getGesellschaft());
    aElement.setAttribute(ATTR_BKL0, aValue.getBKL0());
    aElement.setAttribute(ATTR_BKL1, aValue.getBKL1());
    aElement.setAttribute(ATTR_BKL2, aValue.getBKL2());
    aElement.setAttribute(ATTR_BKL3, aValue.getBKL3());
    aElement.setAttribute(ATTR_BKL4, aValue.getBKL4());
    aElement.setAttribute(ATTR_BKL5, aValue.getBKL5());
    aElement.setAttribute(ATTR_BKL6, aValue.getBKL6());
    aElement.setAttribute(ATTR_BKL7, aValue.getBKL7());
    aElement.setAttribute(ATTR_BKL8, aValue.getBKL8());
    aElement.setAttribute(ATTR_BKL9, aValue.getBKL9());
    aElement.appendElement(sNamespaceURI, ELEMENT_USAGE).appendText(aValue.getUsage());
    aElement.appendElement(sNamespaceURI, ELEMENT_USAGEDESC).appendText(aValue.getUsageDesc());
    for (final IExBiotopbaumBO aItem: aValue.trees()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_TREES));
    }
    aElement.appendElement(sNamespaceURI, ELEMENT_DESC).appendText(aValue.getDesc());
    aElement.setAttribute(ATTR_SAMEAGE, aValue.isSameAge());
    aElement.setAttribute(ATTR_ONELEVEL, aValue.isOneLevel());
    for (final IExStichprobeDeadwoodBO aItem: aValue.totSteh()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_TOT_STEH));
    }
    for (final IExStichprobeDeadwoodBO aItem: aValue.totLieg1()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_TOT_LIEG_1));
    }
    for (final IExStichprobeDeadwoodBO aItem: aValue.totLieg2()) {
      aElement.appendChild(MicroTypeConverter.convertToMicroElement(aItem, sNamespaceURI, ELEMENT_TOT_LIEG_2));
    }
    return aElement;
  }

  @Nonnull
  public ExStichprobeBO convertToNative(@Nonnull final IMicroElement aElement) {
    final int nStichNr = aElement.getAttributeValueAsInt(ATTR_STICHNR, -1);
    final IExReservatBO aStichNrzR = m_aResolverExReservatBO.apply(aElement.getAttributeValue(ATTR_STICHNRZR));
    final ICommonsList<File> aPics = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_PICS)) {
      aPics.add(aChild.getAttributeValueWithConversion("value", File.class));
    }
    final LocalDate aDate = aElement.getAttributeValueWithConversion(ATTR_DATE, LocalDate.class);
    final int nSize = aElement.getAttributeValueAsInt(ATTR_SIZE, -1);
    final EExExpositionBO eExposition = EExExpositionBO.getFromIDOrNull(aElement.getAttributeValue(ATTR_EXPOSITION));
    final String sHanglage = MicroHelper.getChildTextContent(aElement, ELEMENT_HANGLAGE);
    final String sGesellschaft = MicroHelper.getChildTextContent(aElement, ELEMENT_GESELLSCHAFT);
    final double dBKL0 = aElement.getAttributeValueAsDouble(ATTR_BKL0, Double.NaN);
    final double dBKL1 = aElement.getAttributeValueAsDouble(ATTR_BKL1, Double.NaN);
    final double dBKL2 = aElement.getAttributeValueAsDouble(ATTR_BKL2, Double.NaN);
    final double dBKL3 = aElement.getAttributeValueAsDouble(ATTR_BKL3, Double.NaN);
    final double dBKL4 = aElement.getAttributeValueAsDouble(ATTR_BKL4, Double.NaN);
    final double dBKL5 = aElement.getAttributeValueAsDouble(ATTR_BKL5, Double.NaN);
    final double dBKL6 = aElement.getAttributeValueAsDouble(ATTR_BKL6, Double.NaN);
    final double dBKL7 = aElement.getAttributeValueAsDouble(ATTR_BKL7, Double.NaN);
    final double dBKL8 = aElement.getAttributeValueAsDouble(ATTR_BKL8, Double.NaN);
    final double dBKL9 = aElement.getAttributeValueAsDouble(ATTR_BKL9, Double.NaN);
    final String sUsage = MicroHelper.getChildTextContent(aElement, ELEMENT_USAGE);
    final String sUsageDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_USAGEDESC);
    final ICommonsList<IExBiotopbaumBO> aTrees = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_TREES)) {
      aTrees.add(MicroTypeConverter.convertToNative(aChild, ExBiotopbaumBO.class));
    }
    final String sDesc = MicroHelper.getChildTextContent(aElement, ELEMENT_DESC);
    final boolean bSameAge = aElement.getAttributeValueAsBool(ATTR_SAMEAGE, false);
    final boolean bOneLevel = aElement.getAttributeValueAsBool(ATTR_ONELEVEL, false);
    final ICommonsList<IExStichprobeDeadwoodBO> aTotSteh = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_TOT_STEH)) {
      aTotSteh.add(MicroTypeConverter.convertToNative(aChild, ExStichprobeDeadwoodBO.class));
    }
    final ICommonsList<IExStichprobeDeadwoodBO> aTotLieg1 = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_TOT_LIEG_1)) {
      aTotLieg1 .add(MicroTypeConverter.convertToNative(aChild, ExStichprobeDeadwoodBO.class));
    }
    final ICommonsList<IExStichprobeDeadwoodBO> aTotLieg2 = new CommonsArrayList<>();
    for (final IMicroElement aChild: aElement.getAllChildElements(ELEMENT_TOT_LIEG_2)) {
      aTotLieg2 .add(MicroTypeConverter.convertToNative(aChild, ExStichprobeDeadwoodBO.class));
    }
    return new ExStichprobeBO(super.getStubObject(aElement), nStichNr, aStichNrzR, aPics, aDate, nSize, eExposition, sHanglage, sGesellschaft, dBKL0, dBKL1, dBKL2, dBKL3, dBKL4, dBKL5, dBKL6, dBKL7, dBKL8, dBKL9, sUsage, sUsageDesc, aTrees, sDesc, bSameAge, bOneLevel, aTotSteh, aTotLieg1, aTotLieg2);
  }
}
