package com.fideuram.crm.stampe.lettere.spConteggiRI;

import java.util.ArrayList;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.RiepilogoImposte;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.SpiegazioneConteggiRamoI;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.TipoPraticaRiscatto;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni.DettaglioLiquidazioneRiscatto;
import com.fideuram.puc.service.impl.DettaglioLiquidazioneRiscattoVO;
import com.fideuram.puc.service.impl.RiepilogoImposteVO;
import com.fideuram.puc.service.impl.SpiegazioneConteggiRamoIVO;
import com.fideuram.puc.service.impl.TipoPraticaRiscattoVO;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;

public class TabellaRiscattoTotParz {
	
	/**
	 * metodo pubblico che restituisce un oggetto valorizzato con i dati di un'altro oggetto proveniente dal puc
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 * @return spiegazioneConteggiRamoI oggetto valorizzato con i dati del puc
	 */
	public static SpiegazioneConteggiRamoI setTabella(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI){
		setDatiRiscattoTotParz(spiegazioneConteggiRamoIVO, spiegazioneConteggiRamoI);
		return spiegazioneConteggiRamoI;
	}
	
	/**
	 * il metodo si occupa di valorizzare i dati di riscatto dell'oggetto da visualizzare nelle stampe
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 * @return spiegazioneConteggiRamoI oggetto valorizzato con i dati del puc
	 */
	private static SpiegazioneConteggiRamoI setDatiRiscattoTotParz(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI) {
		TipoPraticaRiscatto tipoPraticaRiscatto = new TipoPraticaRiscatto();
		TipoPraticaRiscattoVO tipoPraticaRiscattoVO = spiegazioneConteggiRamoIVO.getTipoPraticaRiscatto();
		
		
		tipoPraticaRiscatto.setValoreRiscattoLordo(tipoPraticaRiscattoVO.getValoreRiscattoLordo());
		tipoPraticaRiscatto.setValoreRiscattoNetto(tipoPraticaRiscattoVO.getValoreRiscattoNetto());
		tipoPraticaRiscatto.setInteressiMora(tipoPraticaRiscattoVO.getInteressiMora());
		tipoPraticaRiscatto.setInteressiRitardatoPagamento(tipoPraticaRiscattoVO.getInteressiRitardatoPagamento());
		tipoPraticaRiscatto.setValoreImportoPagato(tipoPraticaRiscattoVO.getValoreImportoPagato());
		if(tipoPraticaRiscattoVO.getDataLiquidazione() != null){
			tipoPraticaRiscatto.setDataLiquidazione(DateUtils.formatDate(
													tipoPraticaRiscattoVO.getDataLiquidazione().toGregorianCalendar(),
													Costanti.FORMATO_DATA));
		}else{
			tipoPraticaRiscatto.setDataLiquidazione("");
		}
		if(tipoPraticaRiscattoVO.getDataValuta() != null){
			tipoPraticaRiscatto.setDataValuta(DateUtils.formatDate(
													tipoPraticaRiscattoVO.getDataValuta().toGregorianCalendar(),
													Costanti.FORMATO_DATA));
		}else{
			tipoPraticaRiscatto.setDataValuta("");
		}
		
		ArrayList<DettaglioLiquidazioneRiscattoVO>  listDettaglioLiquidazioneRiscattoVO = (ArrayList<DettaglioLiquidazioneRiscattoVO>)tipoPraticaRiscattoVO.getListDettaglioLiquidazione();
		if(listDettaglioLiquidazioneRiscattoVO != null && listDettaglioLiquidazioneRiscattoVO.size()>0){
			ArrayList<DettaglioLiquidazioneRiscatto>  listDettaglioLiquidazione = new ArrayList<DettaglioLiquidazioneRiscatto>();
			DettaglioLiquidazioneRiscattoVO dettaglioLiquidazioneRiscattoVO = null;
			DettaglioLiquidazioneRiscatto dettaglioLiquidazioneRiscatto = null;			
			double totRiservaMatematica = 0;
			double totCapitaleCasoMorte = 0;			
			double totValoreDiRiscatto = 0;
			double totEccedenza = 0;
			for(int i=0;i<listDettaglioLiquidazioneRiscattoVO.size();i++){
				dettaglioLiquidazioneRiscatto = new DettaglioLiquidazioneRiscatto();
				dettaglioLiquidazioneRiscattoVO = listDettaglioLiquidazioneRiscattoVO.get(i);
				
				dettaglioLiquidazioneRiscatto.setNumeroAppendice(String.valueOf(dettaglioLiquidazioneRiscattoVO.getNumeroAppendice()));
				dettaglioLiquidazioneRiscatto.setTariffa(dettaglioLiquidazioneRiscattoVO.getTariffa());
				
				dettaglioLiquidazioneRiscatto.setRiservaMatematica(dettaglioLiquidazioneRiscattoVO.getRiservaMatematica());
				dettaglioLiquidazioneRiscatto.setCapitaleCasoMorte(dettaglioLiquidazioneRiscattoVO.getCapitaleCasoMorte());
				dettaglioLiquidazioneRiscatto.setCostoLiquidazione(dettaglioLiquidazioneRiscattoVO.getCostoLiquidazione());
				dettaglioLiquidazioneRiscatto.setValoreRiscatto(dettaglioLiquidazioneRiscattoVO.getValoreRiscatto());
				dettaglioLiquidazioneRiscatto.setEccedenza(dettaglioLiquidazioneRiscattoVO.getEccedenza());
				
				//TOTALI				
				totRiservaMatematica += dettaglioLiquidazioneRiscattoVO.getRiservaMatematica();
				totCapitaleCasoMorte += dettaglioLiquidazioneRiscattoVO.getCapitaleCasoMorte();				
				totValoreDiRiscatto += dettaglioLiquidazioneRiscattoVO.getValoreRiscatto();
				totEccedenza += dettaglioLiquidazioneRiscattoVO.getEccedenza();
				
				listDettaglioLiquidazione.add(dettaglioLiquidazioneRiscatto);
			}
			//SET DEI TOTALI			
            tipoPraticaRiscatto.setTotRiservaMatematica(totRiservaMatematica);
			tipoPraticaRiscatto.setTotCapitaleCasoMorte(totCapitaleCasoMorte);
			tipoPraticaRiscatto.setTotValoreDiRiscatto(totValoreDiRiscatto);
			tipoPraticaRiscatto.setTotEccedenza(totEccedenza);
			tipoPraticaRiscatto.setListDettaglioLiquidazione(listDettaglioLiquidazione);
		}
		
		ArrayList<RiepilogoImposteVO> listRiepilogoImposteVO = (ArrayList<RiepilogoImposteVO>)tipoPraticaRiscattoVO.getListRiepilogoImposte();
		if(listRiepilogoImposteVO != null && listRiepilogoImposteVO.size()>0){
			ArrayList<RiepilogoImposte> listRiepilogoImposte = new ArrayList<RiepilogoImposte>();
			RiepilogoImposteVO riepilogoImposteVO = null;
			RiepilogoImposte riepilogoImposte = new RiepilogoImposte();
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
			tipoPraticaRiscatto.setTotImponibile(totImponibile);
			tipoPraticaRiscatto.setTotImposta(totImposta);
			
			tipoPraticaRiscatto.setListRiepilogoImposte(listRiepilogoImposte);
		}		
		spiegazioneConteggiRamoI.setTipoPraticaRiscatto(tipoPraticaRiscatto);
		return spiegazioneConteggiRamoI;
	}
}
