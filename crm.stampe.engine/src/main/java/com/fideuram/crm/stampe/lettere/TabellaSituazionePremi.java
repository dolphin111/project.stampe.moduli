package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

public class TabellaSituazionePremi extends LetteraEngine {

    public TabellaSituazionePremi(int comID) throws WebServiceClientException {
        super(comID);
    }

    public void impostaTabellaSituazionePremi(Polizza dest, boolean root) throws WebServiceClientException, PucException {
        dest.addAttributo("dataRiferimentoSituazionePremi", dest.getAttributo("dataValutazione"));

        //DESCRIZIONE SITUAZIONE PREMI
        dest.addAttributo("descrizioneSituazionePremi", dest.getTroncone("SituazPremiTotalePremi"));

        if (root) {
            if (dest.isPraticheAperte() && !("GV").equalsIgnoreCase(dest.getCodiceGruppo())) {
                //TODO da rivedere quando ciccio sa
            	if(!dest.getLiquidazioni().get(0).getData().equals("")){
            		dest.addAttributo("dataRiferimentoSituazionePremi", dest.getLiquidazioni().get(0).getData());
            		dest.addAttributo("descrizioneSituazionePremi", dest.getTroncone("SituazPremiTotalePremiDataLiquidazione"));
            	}
            }
        } else {
            dest.addAttributo("dataRiferimentoSituazionePremi", dest.getDataEmissione());
        }

        if ("GR".equalsIgnoreCase(dest.getCodiceSottostato()) ||
                ("GD".equalsIgnoreCase(dest.getCodiceSottostato()))) {
            dest.addAttributo("dataRiferimentoSituazionePremi", dest.getDataFineDifferimento());
            dest.addAttributo("descrizioneSituazionePremi", dest.getTroncone("SituazPremiTotalePremiDataFineDiff"));
        }

        //SOMMATORIA PREMI UNICI/ANNUI
        dest.addAttributo("sommaPremiUnici", dest.getPremiUnici());
        dest.addAttributo("sommaPremiAnnui", dest.getPremiAnnui());

        //CONTROVALORE QUOTE SOLO PER POLIZZE UNIT LINKED
        dest.addAttributo("labelControvaloreQuote", "");
        dest.addAttributo("dataControvaloreQuote", "");
        dest.addAttributo("valoreControvaloreQuote", "");
        dest.addAttributo("descrizioneControvaloreQuote", "");

        if (root){
            if (dest.getControvaloreQuote() != null && !"".equals(dest.getControvaloreQuote())) {                
                if ("80".equals(dest.getProdotto())) {
                    com.fideuram.puc.service.impl.PrestazioneFIP80VO pr = null;
                    try {
                        pr = pucS.getPrestazioniFIP80ByNumeroPolizza(dest.getNumero());
                    } catch (ServiceException_Exception e) {
                       throw new PucException(e);
                    }
                    dest.addAttributo("labelControvaloreQuote", "VALORE DELLA PRESTAZIONE");
                	String dataControvaloreQuote = DateUtils.formatDate(pr.getDataControvaloreQuote(), "dd/MM/yyyy");
                	dest.addAttributo("dataControvaloreQuote", dataControvaloreQuote);
                	String controvaloreQuote = NumberUtils.getNullSefeCurrency(pr.getTotalePrestazioneFIP80 ());
                	dest.addAttributo("valoreControvaloreQuote", controvaloreQuote);
                	dest.addAttributo("descrizioneControvaloreQuote", dest.getTroncone("SituazPremiFIP80"));
                    dest.addAttributo("descrizioneControvaloreQuote", dest.getTroncone("SituazPremiFIP80"));
                } else {                    
                    dest.addAttributo("labelControvaloreQuote", "CONTROVALORE delle QUOTE");
                    dest.addAttributo("dataControvaloreQuote", dest.getDataRiferimentoQuote());
                    dest.addAttributo("valoreControvaloreQuote", dest.getControvaloreQuote());
                    dest.addAttributo("descrizioneControvaloreQuote", dest.getTroncone("SituazPremiControvalore"));
                }
            }
        }

        //PREMI DA INCASSARE SOLO PER POLIZZE TRADIZIONALI
        dest.addAttributo("premiDaIncassare", ""); 
        dest.addAttributo("dataPremiDaIncassare", "");
        dest.addAttributo("descrizionePremiDaIncassare", "");
        if (root){
            if (dest.getPremiDaIncassare() != null && !"".equals(dest.getPremiDaIncassare())) {
                dest.addAttributo("dataPremiDaIncassare", dest.getDataPremiDaIncassare());
                dest.addAttributo("premiDaIncassare", dest.getPremiDaIncassare());
                dest.addAttributo("descrizionePremiDaIncassare", dest.getTroncone("SituazPremiRatadiPremio"));
            }
        }
    }
}