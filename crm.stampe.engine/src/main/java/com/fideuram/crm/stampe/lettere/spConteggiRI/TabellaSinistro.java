package com.fideuram.crm.stampe.lettere.spConteggiRI;

import java.util.ArrayList;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.SpiegazioneConteggiRamoI;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.TipoPraticaSinistro;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.dettaglioLiquidazioni.DettaglioLiquidazioneSinistro;
import com.fideuram.puc.service.impl.DettaglioLiquidazioneSinistroVO;
import com.fideuram.puc.service.impl.SpiegazioneConteggiRamoIVO;
import com.fideuram.puc.service.impl.TipoPraticaSinistroVo;
import com.fideuram.utils.NumberUtils;

public class TabellaSinistro {
	
	/**
	 * metodo pubblico che restituisce un oggetto valorizzato con i dati di un'altro oggetto proveniente dal puc
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 * @return spiegazioneConteggiRamoI oggetto valorizzato con i dati del puc
	 */
	public static SpiegazioneConteggiRamoI setTabella(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI){
		setDatiSinistro(spiegazioneConteggiRamoIVO, spiegazioneConteggiRamoI);
		return spiegazioneConteggiRamoI;
	}

	/**
	 * il metodo si occupa di valorizzare i dati di sinistro dell'oggetto da visualizzare nelle stampe
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 * @return spiegazioneConteggiRamoI oggetto valorizzato con i dati del puc
	 */
	private static SpiegazioneConteggiRamoI setDatiSinistro(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI) {
		TipoPraticaSinistro tipoPraticaSinistro = new TipoPraticaSinistro();
		TipoPraticaSinistroVo tipoPraticaSinistroVo = spiegazioneConteggiRamoIVO.getTipoPraticaSinistro();
		
		tipoPraticaSinistro.setValoreSinistro(NumberUtils.format(
														tipoPraticaSinistroVo.getValoreSinistro(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
		tipoPraticaSinistro.setInteressiMora(NumberUtils.format(
														tipoPraticaSinistroVo.getInteressiMora(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
		tipoPraticaSinistro.setInteressiRitardatoPagamento(NumberUtils.format(
														tipoPraticaSinistroVo.getInteressiRitardatoPagamento(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
		
		ArrayList<DettaglioLiquidazioneSinistroVO> listDettaglioLiquidazioneSinistroVO = (ArrayList<DettaglioLiquidazioneSinistroVO>)tipoPraticaSinistroVo.getListDettaglioLiquidazione();
		if(listDettaglioLiquidazioneSinistroVO != null && listDettaglioLiquidazioneSinistroVO.size()>0){
			ArrayList<DettaglioLiquidazioneSinistro>  listDettaglioLiquidazione = new ArrayList<DettaglioLiquidazioneSinistro>();
			DettaglioLiquidazioneSinistroVO dettaglioLiquidazioneSinistroVO = null;
			DettaglioLiquidazioneSinistro dettaglioLiquidazioneSinistro = null;
			double totPrestazione = 0;
			double totRivalutazione = 0;
			double totBonus = 0;
			double totControassicurazione = 0;;			
			double totPrestazioneCasoMorte = 0;
			for(int i=0;i<listDettaglioLiquidazioneSinistroVO.size();i++){
				dettaglioLiquidazioneSinistro = new DettaglioLiquidazioneSinistro();
				dettaglioLiquidazioneSinistroVO = listDettaglioLiquidazioneSinistroVO.get(i);
				
				dettaglioLiquidazioneSinistro.setTariffa(dettaglioLiquidazioneSinistroVO.getTariffa());
				dettaglioLiquidazioneSinistro.setPrestazione(NumberUtils.format(
														dettaglioLiquidazioneSinistroVO.getPrestazione(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
				dettaglioLiquidazioneSinistro.setRivalutazione(NumberUtils.format(
														dettaglioLiquidazioneSinistroVO.getRivalutazione(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
				dettaglioLiquidazioneSinistro.setBonus(NumberUtils.format(
														dettaglioLiquidazioneSinistroVO.getBonus(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
				dettaglioLiquidazioneSinistro.setControAssicurazione(NumberUtils.format(
														dettaglioLiquidazioneSinistroVO.getControAssicurazione(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
				dettaglioLiquidazioneSinistro.setAnnualita(NumberUtils.format(
														dettaglioLiquidazioneSinistroVO.getAnnualita(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
				dettaglioLiquidazioneSinistro.setPrestazioneCasoMorte(NumberUtils.format(
														dettaglioLiquidazioneSinistroVO.getPrestazioneCasoMorte(), 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));				
				
				totPrestazione += dettaglioLiquidazioneSinistroVO.getPrestazione();
				totRivalutazione += dettaglioLiquidazioneSinistroVO.getRivalutazione();
				totBonus += dettaglioLiquidazioneSinistroVO.getBonus();
				totControassicurazione += dettaglioLiquidazioneSinistroVO.getControAssicurazione();
				totPrestazioneCasoMorte += dettaglioLiquidazioneSinistroVO.getPrestazioneCasoMorte();
				
				listDettaglioLiquidazione.add(dettaglioLiquidazioneSinistro);
			}
			tipoPraticaSinistro.setTotPrestazione(NumberUtils.format(
														totPrestazione, 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
			tipoPraticaSinistro.setTotRivalutazione(NumberUtils.format(
														totRivalutazione, 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
			tipoPraticaSinistro.setTotBonus(NumberUtils.format(
														totBonus, 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));	
			tipoPraticaSinistro.setTotControassicurazione(NumberUtils.format(
														totControassicurazione, 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
			tipoPraticaSinistro.setTotPrestazioneCasoMorte(NumberUtils.format(
														totPrestazioneCasoMorte, 
														Costanti.SEPARATORE_MIGLIAIA, 
														Costanti.SEPARATORE_DECIMALI,2));
			
			tipoPraticaSinistro.setListDettaglioLiquidazione(listDettaglioLiquidazione);
		}
		spiegazioneConteggiRamoI.setTipoPraticaSinistro(tipoPraticaSinistro);
		return spiegazioneConteggiRamoI;
	}
}
