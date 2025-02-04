package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Decumulo;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.puc.service.impl.DecumuloVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

public class LetteraDecumulo extends LetteraEngine{
    public LetteraDecumulo(int comID) throws WebServiceClientException {
        super(comID);
    }


    public void completaPolizza(Polizza polizza, DomandaVO domanda) throws PucException, DaoException, WebServiceClientException {
        Decumulo decumulo = new PucDao(comID).getDecumulo(polizza.getNumero(),domanda);
        polizza.setDecumulo(decumulo);
        LoggingUtils.info("toString Polizza-->["+polizza.toString()+"]");
    }



    /**
	 * @throws CrmStampeException
	 * @throws ServiceException_Exception 
	 */
/*	public void completaPolizza(Polizza polizza, DomandaVO domanda) throws StampeInfoException, WebServiceClientException, PucException {

		String percentuale = "";
		String frazionamento = "";
		for (ValoreInputVO v : domanda.getValoriInput()) {
			LoggingUtils.info("stampa log: ["+domanda.getValoriInput()+"]");
            for (int tipo : Costanti.INPUT_DECUMULO) {
                if (tipo == v.getDatoInput().getId()) {
                    try {                    	
                    	percentuale = v.getValore();
                    } catch (Exception e) {
                    	LoggingUtils.error("in INPUT_DECUMULO:"+e.getMessage());
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
        }


		for (ValoreInputVO v : domanda.getValoriInput()) {
			for (int tipo : Costanti.INPUT_FRAZIONAMENTO) {
				if (tipo == v.getDatoInput().getId()) {
					try {                    	
						frazionamento = v.getValore();
					} catch (Exception e) {
						LoggingUtils.error("in INPUT_FRAZIONAMENTO:"+e.getMessage());
						throw new RuntimeException(e);
					}
					break;
				}
			}
		}


        DecumuloVO dec = null;
        try {
            dec = pucS.getDecumulo(polizza.getNumero(), percentuale,frazionamento);
        } catch (ServiceException_Exception e) {
             throw new PucException("Errore per LetteraDecumulo polizza: " + polizza.getNumero()  +", Il controvalore quote non può esssre 0",e);
        }
        Decumulo decumulo = new Decumulo();
		if(dec != null){
            if(dec.getControvaloreQuote()==0){
                LoggingUtils.info("Errore per LetteraDecumulo polizza: " + polizza.getNumero()  +", Il controvalore quote non può essere 0");
                throw new StampeInfoException("Errore per LetteraDecumulo polizza: " + polizza.getNumero()  +", Il controvalore quote non può essere 0");
            }
			decumulo.setControvaloreQuote(NumberUtils.format(
                    dec.getControvaloreQuote(),
                    Costanti.SEPARATORE_MIGLIAIA,
                    Costanti.SEPARATORE_DECIMALI, 2));
					
			decumulo.setPercentuale(NumberUtils.format(
						dec.getPercentuale(),
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI,2));
			
			//int frazionamentoInt = 1;
			if(frazionamento.equalsIgnoreCase("S")){
					//frazionamentoInt = 2;
					frazionamento = "Semestrale";
			}
			if(frazionamento.equalsIgnoreCase("Q")){
					//frazionamentoInt = 3;
					frazionamento = "Quadrimestrale";
			}
			if(frazionamento.equalsIgnoreCase("T")){
					//frazionamentoInt = 4;
					frazionamento = "Trimestrale";
			}
			if(frazionamento.equalsIgnoreCase("B")){
					//frazionamentoInt = 6;
					frazionamento = "Bimestrale";
			}
			if(frazionamento.equalsIgnoreCase("M")){
					//frazionamentoInt = 12;
					frazionamento = "Mensile";
			}
			//double importoCedola = dec.getImportoDecumulo()/frazionamentoInt;
			
			decumulo.setFrazionamento(frazionamento);
			
			decumulo.setImportoCedola( NumberUtils.format(
                    dec.getImportoDecumulo(),
					Costanti.SEPARATORE_MIGLIAIA, 
					Costanti.SEPARATORE_DECIMALI,2));
			
			decumulo.setDataNav(DateUtils.formatDate(dec.getDataRiferimentoNav().toGregorianCalendar(), Costanti.FORMATO_DATA));
		}			
		polizza.setDecumulo(decumulo);
		LoggingUtils.info("toString Polizza-->["+polizza.toString()+"]");




    }*/
}