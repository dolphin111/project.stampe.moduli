package com.fideuram.crm.stampe.lettere;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Fondo;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.RiscattoParzialeTendenzaBean;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.ValoreInputVO;
import com.fideuram.puc.service.impl.*;
import com.fideuram.utils.NumberUtils;

public class LetteraRiscattoParzialeTendenza extends LetteraEngine{
    public LetteraRiscattoParzialeTendenza(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
     *
     * @param polizza
     * @param domanda
     * @throws WebServiceClientException
     * @throws PucException
     */
	public void completaPolizza(Polizza polizza, DomandaVO domanda) throws WebServiceClientException, PucException {
		//BigDecimal importoDaRiscattare = null;
		String importo = "";
		for (ValoreInputVO v : domanda.getValoriInput()) {
            for (int tipo : Costanti.INPUT_RISCATTO_PARZIALE_TENDENZA) {
                if (tipo == v.getDatoInput().getId()) {
                    try {
                    	//importoDaRiscattare = new BigDecimal(v.getValore());
                    	importo = v.getValore();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
            }
        }
        RiscattoParzialeInTendenzaVO riscatto = null;
        try {
            riscatto = pucS.getRiscattoParzialeTendenza(polizza.getNumero(), importo);
        } catch (ServiceException_Exception e) {
           throw new PucException(e);
        }
        RiscattoParzialeTendenzaBean riscattoTendenza = new RiscattoParzialeTendenzaBean();
		riscattoTendenza.setImportoUtente(NumberUtils.format(
									riscatto.getImportoRichiesto(),
									Costanti.SEPARATORE_MIGLIAIA,
									Costanti.SEPARATORE_DECIMALI,2));
		if(riscatto != null){
			impostaTabellaRiscattoAnticipato(polizza);
			if(riscatto.getRamoI() != null){
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");	
				String today = formatter.format(currentDate.getTime());
				RamoIVO r1 = riscatto.getRamoI();
				riscattoTendenza.setDataValutazione(today);
//				if(r1.getValoreRiscattoLordo() != null && !r1.getValoreRiscattoLordo().equals("0")){
//					riscattoTendenza.setRiscattoAnticipato(r1.getValoreRiscattoLordo());
//				}else{
//					riscattoTendenza.setRiscattoAnticipato("0,00");
//				}
//				if(r1.getCommissioniRiscatto() != null && !r1.getCommissioniRiscatto().equals("0")){
//					riscattoTendenza.setCosto(r1.getCommissioniRiscatto());
//				}else{
//					riscattoTendenza.setCosto("0,00");
//				}
//				if(r1.getCapitaleRiscatto() != null && !r1.getCapitaleRiscatto().equals("")){
//					riscattoTendenza.setPrestazione(r1.getCapitaleRiscatto());	
//				}else{
//					riscattoTendenza.setPrestazione("0,00");
//				}
				
//				ArrayList<Fondo> listFondo = new ArrayList<Fondo>();
//				Fondo fondo = new Fondo();
//				listFondo.add(fondo);
//				riscattoTendenza.setListFondi(listFondo);
				
				riscattoTendenza.setTotaleControvaloreQuoteLiquidate(r1.getCapitaleRiscatto());
				if(r1.getCommissioniRiscatto() != null && !r1.getCommissioniRiscatto().equals("0")){
					riscattoTendenza.setCosto(r1.getCommissioniRiscatto());
				}else{
					riscattoTendenza.setCosto("0,00");
				}
				if(r1.getValoreRiscattoLordo() != null && !r1.getValoreRiscattoLordo().equals("0")){
					riscattoTendenza.setRiscattoAnticipato(r1.getValoreRiscattoLordo());
				}else{
					riscattoTendenza.setRiscattoAnticipato("0,00");
				}
				//
				riscattoTendenza.setTotaleQuoteLiquidate(r1.getImportoRichiesto() != null ? r1.getImportoRichiesto() : "0,00");
				
				if(r1.getValoreRiscattoNetto() != null && !r1.getValoreRiscattoNetto().equals("")){
					riscattoTendenza.setPrestazione(r1.getValoreRiscattoNetto());	
				}else{
					riscattoTendenza.setPrestazione(importo);
				}	
				
				
								
			}else if(riscatto.getRamoIII() != null){
				RamoIIIVO r3 = riscatto.getRamoIII();
				
				Calendar currentDate = Calendar.getInstance();
				SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy");	
				String today = formatter.format(currentDate.getTime());
				String data = today;
				
				if(r3.getDrifcontrovalorequote()!=null && !r3.getDrifcontrovalorequote().equals("")) {
					String anno = r3.getDrifcontrovalorequote().substring(0, 4);
					String mese = r3.getDrifcontrovalorequote().substring(5, 7);
					String giorno = r3.getDrifcontrovalorequote().substring(8, 10);
					data = giorno+"/"+mese+"/"+anno;
				}
							
				riscattoTendenza.setIsFondo(false);
												
				riscattoTendenza.setDataValutazione(data);
				List<FondoVO> listFonfoPuc =  r3.getFondo();
				ArrayList<Fondo> listFondo = null;
				if(listFonfoPuc != null && listFonfoPuc.size() > 0){
					riscattoTendenza.setIsFondo(true);
					Fondo fondo = null;
					listFondo = new ArrayList<Fondo>();
					for(int i=0;i<listFonfoPuc.size();i++){
						fondo = new Fondo();
						fondo.setFondoInternoOicr(listFonfoPuc.get(i).getDescrizioneFondo());
						fondo.setQuote(listFonfoPuc.get(i).getQuote());
						fondo.setValoreQuota(listFonfoPuc.get(i).getValorenav());
						fondo.setControvaloreQuoteLiquidate(listFonfoPuc.get(i).getCtvquote());
						listFondo.add(fondo);
					}
				}
				
				if(listFondo != null) {
					riscattoTendenza.setListFondi(listFondo);
				}else {
					ArrayList<Fondo> listFondoM =  new ArrayList<Fondo>();
					Fondo f = new Fondo();
					f.setFondoInternoOicr("");
					f.setQuote("");
					f.setValoreQuota("");
					f.setControvaloreQuoteLiquidate("");
					listFondoM.add(f);
					
					riscattoTendenza.setListFondi(listFondoM);
				}
												
				if(r3.getTotalecontrovalorequoteliquidate() != null && !r3.getTotalecontrovalorequoteliquidate().equals("0")){
					riscattoTendenza.setTotaleControvaloreQuoteLiquidate(r3.getTotalecontrovalorequoteliquidate());
				}else{
					riscattoTendenza.setTotaleControvaloreQuoteLiquidate("0,00");
				}
							
				if(r3.getCommissioni() != null && !r3.getCommissioni().equals("0")){
					riscattoTendenza.setCosto(r3.getCommissioni());
				}else{
					riscattoTendenza.setCosto("0,00");
				}
				
				if(r3.getValoreriscattolordo() != null && !r3.getValoreriscattolordo().equals("0")){
					riscattoTendenza.setRiscattoAnticipato(r3.getValoreriscattolordo());
				}else{
					riscattoTendenza.setRiscattoAnticipato("0,00");
				}
				
				//
				if(r3.getTotalequoteliquidate() != null && !r3.getTotalequoteliquidate().equals("0")){
					riscattoTendenza.setTotaleQuoteLiquidate(r3.getTotalequoteliquidate());
				}else{
					riscattoTendenza.setTotaleQuoteLiquidate("0,00");
				}
				
				if(r3.getRiscattoanticipato() != null && !r3.getRiscattoanticipato().equals("")){
					riscattoTendenza.setPrestazione(r3.getRiscattoanticipato());	
				}else {
					riscattoTendenza.setPrestazione(importo);
				}
				
			}
		}		
		polizza.setRiscattoParzialeTendenza(riscattoTendenza);
	}

	private static void impostaTabellaRiscattoAnticipato(Polizza polizza) {
		polizza.addAttributo("labelDescrRiscattoValoreLiquidabile", polizza.getTroncone("DescrRiscattoValoreLiquidabileRisc1")+".");
		polizza.addAttributo("labelDescrCosto", polizza.getTroncone("DescrCosto"));
		polizza.addAttributo("labelDescrRiscParziale", polizza.getTroncone("DescrRiscParziale"));
	}
	
	
}