package com.fideuram.crm.stampe.lettere.spConteggiRI;

import java.util.ArrayList;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.RiepilogoImposte;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.SpiegazioneConteggiRamoI;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.TipoPraticaScadenza;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni.DettaglioLiquidazioneScadenza;
import com.fideuram.puc.service.impl.DettaglioLiquidazioneScadenzaVO;
import com.fideuram.puc.service.impl.RiepilogoImposteVO;
import com.fideuram.puc.service.impl.SpiegazioneConteggiRamoIVO;
import com.fideuram.puc.service.impl.TipoPraticaScadenzaVO;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

public class TabellaScadenza {
	
	/**
	 * metodo pubblico che restituisce un oggetto valorizzato con i dati di un'altro oggetto proveniente dal puc
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 * @return spiegazioneConteggiRamoI oggetto valorizzato con i dati del puc
	 */
	public static SpiegazioneConteggiRamoI setTabella(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI){
		setDatiScadenza(spiegazioneConteggiRamoIVO, spiegazioneConteggiRamoI);
		return spiegazioneConteggiRamoI;
	}
	
	/**
	 * il metodo si occupa di valorizzare i dati di scadenza dell'oggetto da visualizzare nelle stampe
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 * @return spiegazioneConteggiRamoI oggetto valorizzato con i dati del puc
	 */
	private static SpiegazioneConteggiRamoI setDatiScadenza(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI) {
		TipoPraticaScadenza tipoPraticaScadenza = new TipoPraticaScadenza();
		TipoPraticaScadenzaVO tipoPraticaScadenzaVO = spiegazioneConteggiRamoIVO.getTipoPraticaScadenza();
		
		tipoPraticaScadenza.setValoreRiscattoLordo(tipoPraticaScadenzaVO.getValoreRiscattoLordo());
		tipoPraticaScadenza.setValoreRiscattoNetto(tipoPraticaScadenzaVO.getValoreRiscattoNetto());
		tipoPraticaScadenza.setInteressiMora(tipoPraticaScadenzaVO.getInteressiMora());
		tipoPraticaScadenza.setInteressiRitardatoPagamento(tipoPraticaScadenzaVO.getInteressiRitardatoPagamento());
		tipoPraticaScadenza.setValoreImportoPagato(tipoPraticaScadenzaVO.getValoreImportoPagato());

		if(tipoPraticaScadenzaVO.getDataLiquidazione() != null){
			tipoPraticaScadenza.setDataLiquidazione(DateUtils.formatDate(
														tipoPraticaScadenzaVO.getDataLiquidazione().toGregorianCalendar(),
														Costanti.FORMATO_DATA));
		}else{
			tipoPraticaScadenza.setDataLiquidazione("");
		}
		if(tipoPraticaScadenzaVO.getDataValuta() != null){
			tipoPraticaScadenza.setDataValuta(DateUtils.formatDate(
														tipoPraticaScadenzaVO.getDataValuta().toGregorianCalendar(),
														Costanti.FORMATO_DATA));
		}else{
			tipoPraticaScadenza.setDataValuta("");
		}
		
		ArrayList<DettaglioLiquidazioneScadenzaVO> listDettaglioLiquidazioneScadenzaVO = (ArrayList<DettaglioLiquidazioneScadenzaVO>)tipoPraticaScadenzaVO.getListDettaglioLiquidazione();
		if(listDettaglioLiquidazioneScadenzaVO != null && listDettaglioLiquidazioneScadenzaVO.size()>0){
			ArrayList<DettaglioLiquidazioneScadenza>  listDettaglioLiquidazione = new ArrayList<DettaglioLiquidazioneScadenza>();
			DettaglioLiquidazioneScadenzaVO dettaglioLiquidazioneScadenzaVO = null;
			DettaglioLiquidazioneScadenza dettaglioLiquidazioneScadenza = null;
			double totPrestazioneBase = 0;			
			double totPrestazioneTotaleLorda = 0;
			for(int i=0;i<listDettaglioLiquidazioneScadenzaVO.size();i++){
				dettaglioLiquidazioneScadenza = new DettaglioLiquidazioneScadenza();
				dettaglioLiquidazioneScadenzaVO = listDettaglioLiquidazioneScadenzaVO.get(i);
				
				dettaglioLiquidazioneScadenza.setNumeroAppendice(String.valueOf(dettaglioLiquidazioneScadenzaVO.getNumeroAppendice()));
				dettaglioLiquidazioneScadenza.setTariffa(dettaglioLiquidazioneScadenzaVO.getTariffa());
				dettaglioLiquidazioneScadenza.setPrestazione(NumberUtils.format(
																dettaglioLiquidazioneScadenzaVO.getPrestazione(), 
																Costanti.SEPARATORE_MIGLIAIA, 
																Costanti.SEPARATORE_DECIMALI,2));
				dettaglioLiquidazioneScadenza.setCoefficenteRiscatto(NumberUtils.format(
																dettaglioLiquidazioneScadenzaVO.getCoefficenteRiscatto(), 
																Costanti.SEPARATORE_MIGLIAIA, 
																Costanti.SEPARATORE_DECIMALI,6));
				dettaglioLiquidazioneScadenza.setPrestazioneTotaleLorda(dettaglioLiquidazioneScadenzaVO.getPrestazioneTotaleLorda());
				
				totPrestazioneBase += dettaglioLiquidazioneScadenzaVO.getPrestazione();				
				totPrestazioneTotaleLorda += dettaglioLiquidazioneScadenzaVO.getPrestazioneTotaleLorda();
				
				listDettaglioLiquidazione.add(dettaglioLiquidazioneScadenza);
			}
			//SET DEI TOTALI
			tipoPraticaScadenza.setTotPrestazioneBase(totPrestazioneBase);
			tipoPraticaScadenza.setTotPrestazioneTotaleLorda(totPrestazioneTotaleLorda);
			
			tipoPraticaScadenza.setListDettaglioLiquidazione(listDettaglioLiquidazione);			
		}
		
		ArrayList<RiepilogoImposteVO> listRiepilogoImposteVO = (ArrayList<RiepilogoImposteVO>)tipoPraticaScadenzaVO.getListRiepilogoImposte();
		if(listRiepilogoImposteVO != null && listRiepilogoImposteVO.size()>0){
			ArrayList<RiepilogoImposte> listRiepilogoImposte = new ArrayList<RiepilogoImposte>();
			RiepilogoImposteVO riepilogoImposteVO = null;
			RiepilogoImposte riepilogoImposte = null;
			double totImponibile = 0;
			double totImposta = 0;
			for(int i=0;i<listRiepilogoImposteVO.size();i++){
				riepilogoImposte = new RiepilogoImposte();
				riepilogoImposteVO = listRiepilogoImposteVO.get(i);
				
				riepilogoImposte.setDescrizioneImposte(riepilogoImposteVO.getDescrizioneImposte());
				riepilogoImposte.setImponibile(riepilogoImposteVO.getImponibile());
				riepilogoImposte.setAliquota(NumberUtils.formatQuote(
														riepilogoImposteVO.getAliquota(),
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI));
				riepilogoImposte.setImposta(riepilogoImposteVO.getImposta());
				
				totImponibile += riepilogoImposteVO.getImponibile();
				totImposta += riepilogoImposteVO.getImposta();
				listRiepilogoImposte.add(riepilogoImposte);
			}
			tipoPraticaScadenza.setTotImponibile(totImponibile);
			tipoPraticaScadenza.setTotImposta(totImposta);
			
			tipoPraticaScadenza.setListRiepilogoImposte(listRiepilogoImposte);
		}		
		spiegazioneConteggiRamoI.setTipoPraticaScadenza(tipoPraticaScadenza);
		return spiegazioneConteggiRamoI;
	}
}
