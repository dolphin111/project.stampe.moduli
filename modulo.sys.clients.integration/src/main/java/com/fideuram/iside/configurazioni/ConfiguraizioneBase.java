package com.fideuram.iside.configurazioni;

import com.fideuram.iside.IsideConfiguration;
import com.fideuram.utils.DateUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by
 * User: logan
 * Date: 15/03/13
 * Time: 10.59
 */
public class ConfiguraizioneBase extends IsideConfiguration {
    public ConfiguraizioneBase() throws DatatypeConfigurationException {
        GregorianCalendar gregorianCreazione = (GregorianCalendar) DateUtils.getCalendar(new Date());
        this.dataCreazione= DatatypeFactory.newInstance().newXMLGregorianCalendar( gregorianCreazione );
        this.dataScanner  = this.dataCreazione;
    }
}
