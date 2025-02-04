package com.fideuram.crm.stampe.generatori;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.stampe.engine.InputDataModel;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Lettera;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.StringUtils;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 01/06/11
 * Time: 11.30
 */
public class LetteraReclamo extends LetteraEngine{

    public LetteraReclamo(int comID) throws WebServiceClientException {
        super(comID);
    }

    public String getXml(String comID) throws WebServiceClientException, PucException, StampeInfoException, CrmException {
        Modello modello = new Modello();
        modello.setLettera(new Lettera());
        getComunicazione(comID); //recupera la comunicazione dal CRM-WS
        sortDomande();
        Polizza polizzaRiferimento = getPolizzaByDomanda(Integer.decode(comID),listaDomande.get(0)).get(0);
        modello.setLettera(getIntestazione(comunicazione,modello));
        if(comunicazione.getAssegnatario().getSigla()!=null)
            modello.getLettera().setUtente(comunicazione.getAssegnatario().getSigla());
        else
            modello.getLettera().setUtente("");

        for(DomandaVO domanda : listaDomande) {
            modello.setPolizze(getPolizzaByDomanda(Integer.decode(comID),domanda));
        }

        return modello.toXml();
    }



    private InputDataModel getInputDataModel(DomandaVO d, String scenario){
          return  new InputDataModel(comunicazione, d, scenario,  getTripletta(d));
    }



    private Lettera getIntestazione(ComunicazioneVO comunicazione, Modello modello) throws WebServiceClientException, PucException {
        com.fideuram.puc.service.impl.InfoPolizzaVO polizza = null; //prendo gli altri dati della polizza dal PUC
        try {
            polizza = pucS.getDatiPolizzaByPolizza(new Long(comunicazione.getPolizze()));
        } catch (ServiceException_Exception e) {
           throw new PucException(e);
        }


        Lettera lettera=new Lettera();
        lettera.setData(comunicazione.getDataCreazione().toString());
        lettera.setProtocollo(comunicazione.getNumeroProtocollo());
        lettera.setOggetto("Posizione \"" + StringUtils.blankString(polizza.getDescrizioneProdotto())+"\" n." + polizza.getPolizza());
        //lettera.setDenominazioneContraente(polizza.getContraente().getDenominazione());

        lettera.setTipoProponente(DescrizioniAssemblate.getCapolettera(modello.getProponente()));
        return lettera;
    }




}
