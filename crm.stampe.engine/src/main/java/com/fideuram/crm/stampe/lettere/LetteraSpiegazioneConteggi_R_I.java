package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.stampe.model.Imposta;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.lettere.spConteggiRI.TabellaRiscattoTotParz;
import com.fideuram.crm.stampe.lettere.spConteggiRI.TabellaScadenza;
import com.fideuram.crm.stampe.lettere.spConteggiRI.TabellaSinistro;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.spiegazioneConteggioRamoI.SpiegazioneConteggiRamoI;
import com.fideuram.puc.service.impl.DettaglioFiscalitaPolizzeVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.SpiegazioneConteggiRamoIVO;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;

import java.util.ArrayList;
import java.util.List;

public class LetteraSpiegazioneConteggi_R_I extends LetteraEngine{
    public LetteraSpiegazioneConteggi_R_I(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param polizza
	 * @param modello
	 * @param comunicazione
	 * @param domanda
	 * @param root
	 */
	public void completaPolizza(Polizza polizza, Modello modello,ComunicazioneVO comunicazione,DomandaVO domanda,boolean root)
            throws StampeInfoException, WebServiceClientException, PucException {
		try {			
	    	// Lista delle pratiche
	    	int[]tipo = {36};
			List<String> pratiche = Inputs.getListaPratiche(domanda, tipo);
			
			if(!pratiche.isEmpty()) { 
				ArrayList<SpiegazioneConteggiRamoI> listaSpiegazioneConteggiRamoI = new ArrayList<SpiegazioneConteggiRamoI>();
				for(String numeroPratica : pratiche) {
					SpiegazioneConteggiRamoI spiegazioneConteggiRamoI = new SpiegazioneConteggiRamoI();
					SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO = pucS.getSpiegazioneConteggiRamoI(new Long(numeroPratica));
					
					if(spiegazioneConteggiRamoIVO==null){
                        throw new PucException("Errore dal Puc. getSpiegazioneConteggiRamoI restituisce 'null' per le seguenti polizza e pratica: "
                                +polizza.getNumero()+" ," + numeroPratica);
                    }
					
					String codicePratica = spiegazioneConteggiRamoIVO.getCodicePratica();
					
					if( codicePratica != null && !codicePratica.equals("")){
						//setto la data richiesta che è comune a tutti i template
						if(spiegazioneConteggiRamoIVO.getDataRichiesta() != null){
							spiegazioneConteggiRamoI.setDataRichiesta(DateUtils.formatDate(spiegazioneConteggiRamoIVO.getDataRichiesta().toGregorianCalendar(),
									                                                       Costanti.FORMATO_DATA));
						}
						//setto i dati generali della lettera
						setDatiGeneraliLettera(spiegazioneConteggiRamoIVO,spiegazioneConteggiRamoI);						
						//RISCATTO TOTALE/PARZIALE
						if("1".equals(codicePratica) || "2".equals(codicePratica)){
							spiegazioneConteggiRamoI = TabellaRiscattoTotParz.setTabella(spiegazioneConteggiRamoIVO, spiegazioneConteggiRamoI);
						}
						//SINISTRO
						else if("3".equals(codicePratica)){
							spiegazioneConteggiRamoI = TabellaSinistro.setTabella(spiegazioneConteggiRamoIVO, spiegazioneConteggiRamoI);							
						}
						//SCADENZA
						else if("5".equals(codicePratica)){
							spiegazioneConteggiRamoI = TabellaScadenza.setTabella(spiegazioneConteggiRamoIVO, spiegazioneConteggiRamoI);							
						}
					}else{
						throw new StampeInfoException("Errore il codice pratica non è valida perchè è : "+codicePratica);
					}


                    List<DettaglioFiscalitaPolizzeVO> listaDatiFiscalita=pucS.listDettaglioFiscalitaPolizzeAperteByNumeroPratica(numeroPratica);
                   // List<DettaglioFiscalitaPolizzeVO> listaDatiFiscalita=pucS.listDettaglioFiscalitaPolizzeAperteByNumeroPratica("5412275");

                    for (int i=0; i< listaDatiFiscalita.size(); i++) {
                        DettaglioFiscalitaPolizzeVO beanFiscalita= listaDatiFiscalita.get(i);
                        //Tipo L sta ad indicare il Bollo
                        if (beanFiscalita.getTipoImposta().equalsIgnoreCase("L")){
                            spiegazioneConteggiRamoI.setImpostaBolloFiscalita(NumberUtils.formatCurrency(
                                    beanFiscalita.getImposta(),
                                    Costanti.SEPARATORE_MIGLIAIA,
                                    Costanti.SEPARATORE_DECIMALI));
                        }

                        Imposta beanImposta =new Imposta();
                        beanImposta.setImponibileLordoAltriInvestimentiPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoAltriInvestimentiPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileLordoAltriInvestimentiPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoAltriInvestimentiPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileLordoAnte2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoAnte2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImposta(NumberUtils.formatCurrency(
                                beanFiscalita.getImposta(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setImponibileLordoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setImponibileLordoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        //Percentuale
                        beanImposta.setPercentualeTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getPercentualeTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));
                        //Percentuale
                        beanImposta.setPercentualeTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getPercentualeTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setImponibileLordoTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileLordoTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setPercentualeVisentin(String.valueOf(beanFiscalita.getPercentualeVisentin() + "%"));


                        beanImposta.setRiduzioneVisentinAnte2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinAnte2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));



                        beanImposta.setTotaleImponibileLordo(NumberUtils.formatCurrency(
                                beanFiscalita.getTotaleImponibileLordo(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setTotaleRiduzionePerPeriodo(NumberUtils.formatCurrency(
                                beanFiscalita.getTotaleRiduzionePerPeriodo(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setRiduzionePerTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setRiduzionePerTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setTotaleRiduzionePerTitoliDiStato(NumberUtils.formatCurrency(
                                beanFiscalita.getTotaleRiduzionePerTitoliDiStato(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setTotaleImponibileRidotto(NumberUtils.formatCurrency(
                                beanFiscalita.getTotaleImponibileRidotto(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));




                        beanImposta.setRiduzioneVisentinAnte2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinAnte2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setRiduzionePerTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setRiduzionePerTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setRiduzioneVisentinTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setRiduzioneVisentinTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setRiduzioneVisentinAltriInvestimentiPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinAltriInvestimentiPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setRiduzioneVisentinAltriInvestimentiPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinAltriInvestimentiPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setRiduzioneVisentinTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzioneVisentinTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));




                        beanImposta.setRiduzionePerPeriodoAnte2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerPeriodoAnte2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));



                        beanImposta.setRiduzionePerPeriodoAltriInvestimentiçPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerPeriodoAltriInvestimentiçPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));



                        beanImposta.setImponibileRidottoAltriInvestimentiPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoAltriInvestimentiPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setImponibileRidottoAltriInvestimentiPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoAltriInvestimentiPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setImponibileRidottoAnte2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoAnte2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileRidottoTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileRidottoTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileLordoTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setRiduzionePerTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setRiduzionePerTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getRiduzionePerTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileRidottoAnte2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoAnte2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileRidottoTitoliDiStatoPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoTitoliDiStatoPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));
                        beanImposta.setImponibileRidottoAltriInvestimentiPost2012(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoAltriInvestimentiPost2012(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileRidottoTitoliDiStatoPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoTitoliDiStatoPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));

                        beanImposta.setImponibileRidottoAltriInvestimentiPost2014(NumberUtils.formatCurrency(
                                beanFiscalita.getImponibileRidottoAltriInvestimentiPost2014(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));


                        beanImposta.setTotaleRiduzioneVisentin(NumberUtils.formatCurrency(
                                beanFiscalita.getTotaleRiduzioneVisentin(),
                                Costanti.SEPARATORE_MIGLIAIA,
                                Costanti.SEPARATORE_DECIMALI));



                        if (beanFiscalita.getTipoImposta().equalsIgnoreCase("7")){
                            spiegazioneConteggiRamoI.setTabellaImpostaSostitutiva(beanImposta);
                        }
                        if (beanFiscalita.getTipoImposta().equalsIgnoreCase("3")){
                            spiegazioneConteggiRamoI.setTabellaRitenutaImposta(beanImposta);
                        }


                    }
					listaSpiegazioneConteggiRamoI.add(spiegazioneConteggiRamoI);
					polizza.setListaSpiegazioneConteggiRamoI(listaSpiegazioneConteggiRamoI);
				}				
			}else{
                throw new StampeInfoException("Inputs.getListaPratiche ha restituito un elenco vuoto e quindi non è possibile richiedere al PUC la spiegazione conteggi");
            }
		}catch (NumberFormatException e) {
			LoggingUtils.error(e, e);
            throw new StampeInfoException(e.getMessage());
		} catch (ServiceException_Exception e) {
			LoggingUtils.error(e, e);
            throw new PucException(e.getMessage());
		}			
	}

	/**
	 * Il metodo ha lo scopo d'impostare i valori comuni a tutti i template relativi alla lettera spiegazione conteggi ramo I
	 * @param spiegazioneConteggiRamoIVO oggetto restituito dal servizio del PUC
	 * @param spiegazioneConteggiRamoI oggetto delle stampe che sarà visualizzato nel template
	 */
	private static void setDatiGeneraliLettera(SpiegazioneConteggiRamoIVO spiegazioneConteggiRamoIVO,SpiegazioneConteggiRamoI spiegazioneConteggiRamoI) {
		spiegazioneConteggiRamoI.setNumeroPolizza(""+spiegazioneConteggiRamoIVO.getNumeroPolizza());
		spiegazioneConteggiRamoI.setNumeroPratica(""+spiegazioneConteggiRamoIVO.getNumeroPratica());
		spiegazioneConteggiRamoI.setDescrizioneLiquidazione(spiegazioneConteggiRamoIVO.getDescrizioneLiquidazione());
		spiegazioneConteggiRamoI.setAssicurato(spiegazioneConteggiRamoIVO.getAssicurato());
		spiegazioneConteggiRamoI.setContraente(spiegazioneConteggiRamoIVO.getContraente());
		spiegazioneConteggiRamoI.setDataRichiesta(DateUtils.formatDate(
													spiegazioneConteggiRamoIVO.getDataRichiesta().toGregorianCalendar(),
													Costanti.FORMATO_DATA));
	}
}