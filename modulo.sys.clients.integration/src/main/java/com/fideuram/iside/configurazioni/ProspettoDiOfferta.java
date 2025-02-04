package com.fideuram.iside.configurazioni;
import javax.xml.datatype.DatatypeConfigurationException;

/**
 * Created by
 * User: logan
 * Date: 11/12/12
 * Time: 12.08
 */
public class ProspettoDiOfferta extends ConfiguraizioneBase{
    public ProspettoDiOfferta() throws DatatypeConfigurationException {
        super();
        this.codiceMimeType="text/pdf";
        this.codiceTipologia="PO";     //todo verificare che sia questa la label corretta
        this.label="MOD_SERV_PB";      //todo verificare che sia questa la label corretta
    }
}
