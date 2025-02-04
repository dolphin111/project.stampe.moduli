package com.fideuram.iside.configurazioni;

import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Created by
 * User: logan
 * Date: 15/03/13
 * Time: 10.58
 */
public class PO extends ConfiguraizioneBase {
    public PO() throws DatatypeConfigurationException {
        super();
        this.codiceMimeType="text/pdf";
        this.codiceTipologia="PO";     //todo verificare che sia questa la label corretta
        this.label="MOD_SERV_PB";      //todo verificare che sia questa la label corretta
    }
}
