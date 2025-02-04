package com.fideuram.iside;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.IsideException;
import com.fideuram.iside.facade.DocumentoIsideBean;
import com.fideuram.utils.DateUtils;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with
 * User: v801068
 * Date: 05/12/13
 * Time: 15.07
 */
public class Backup2Iside {

    public IsideResponce saveToIside(byte[] documento, String nome, String data, String idFondo) throws IsideException {
        DocumentoIsideBean documentoIsideBean= new DocumentoIsideBean();
        documentoIsideBean.setCodiceTipologia(CrmProperties.getProperty("documento.codice.tipologia"));
        documentoIsideBean.setDimensione(000000);
        documentoIsideBean.setLabel("MOD_SERV_PB");
        documentoIsideBean.setNumPolizza(CrmProperties.getProperty("documento.polizza.fittizia").concat(idFondo));
        documentoIsideBean.setCodiceMimeType(CrmProperties.getProperty("documento.mime.type"));
        documentoIsideBean.setFile(documento);
        documentoIsideBean.setNomeFile(nome);
        documentoIsideBean.setUtente("StampeUser");
        try {
            GregorianCalendar gregorianCreazione = (GregorianCalendar) DateUtils.getCalendar(new Date());
            GregorianCalendar gregorianScanner = gregorianCreazione;
            documentoIsideBean.setDataCreazione(DatatypeFactory.newInstance().newXMLGregorianCalendar( gregorianCreazione ));
            documentoIsideBean.setDataScanner(DatatypeFactory.newInstance().newXMLGregorianCalendar( gregorianScanner ));
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        IsideManager isideManager = new IsideManager();
        return isideManager.storeFile(documentoIsideBean);
    }

}
