package com.fideuram.crm.stampe.lettere;

import java.util.ArrayList;
import java.util.StringTokenizer;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Fondo;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.RiscattoParzialePuntualeBean;
import com.fideuram.crm.stampe.serviceclient.bi.WSRiscattoParzialePuntualeBean;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;

public class LetteraRiscattoParzialePuntuale extends LetteraEngine{

    public LetteraRiscattoParzialePuntuale(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza polizza, DomandaVO domanda) throws WebServiceClientException {
		//NuovoUniversoClientWS universoClient = (NuovoUniversoClientWS)ClientWsFactory.getInstance().getUniversoClient();
		String quoteFondo = null;
		for (ValoreInputVO v : domanda.getValoriInput()) {
			for (int tipo : Costanti.INPUT_RISCATTO_PARZIALE_PUNTUALE) {
				if (tipo == v.getDatoInput().getId()) {
					try {
						quoteFondo = v.getValore();
					} catch (Exception e) {
						throw new RuntimeException(e);
					}
					break;
				}
			}
		}
			
		RiscattoParzialePuntualeBean riscattoPuntuale = new RiscattoParzialePuntualeBean();
		if(quoteFondo != null && !quoteFondo.equals("")){
			ArrayList<Fondo> listFondiInput = new ArrayList<Fondo>();
			Fondo fInput = new Fondo();
			StringTokenizer token = new StringTokenizer(quoteFondo, ";");
			while(token.hasMoreElements()){
				String input = (String)token.nextToken();
				String fondoOICR = input.substring(0,input.indexOf("-"));
				String quote = input.substring(input.indexOf("-"), input.length());
				fInput.setFondoInternoOicr(fondoOICR);
				fInput.setQuote(quote);
				listFondiInput.add(fInput);
			}
			riscattoPuntuale.setListFondiInput(listFondiInput);
		}
		

		WSRiscattoParzialePuntualeBean beanPuntuale = null;
        try {
            beanPuntuale = uniS.getRiscattoParzialePA(polizza.getNumero(), null, quoteFondo, 16);
        } catch (UniversoException e) {
            throw new WebServiceClientException(e.getCause());
        }

        polizza.setRiscattoParzialePuntuale(riscattoPuntuale);
	}
}