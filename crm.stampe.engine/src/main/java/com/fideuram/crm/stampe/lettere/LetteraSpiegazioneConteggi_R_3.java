package com.fideuram.crm.stampe.lettere;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.*;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.puc.service.impl.*;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Giorgio Desideri
 * 
 */
public class LetteraSpiegazioneConteggi_R_3 extends LetteraEngine {
	static double totaleValoreRiscattoCIA = 0;

    public LetteraSpiegazioneConteggi_R_3(int comID) throws WebServiceClientException {
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
            throws StampeInfoException, WebServiceClientException, PucException{
		try {			

	    	// Richiamo webService per il richimo di ctvAccantonateCG e ctvAccantonateCM
	    	CommissioniFEPolizzaVO commFEPolizzaVo = pucS.getCommissioniFEByPolizza(new Long(polizza.getNumero()));
	    	
	    	// Richiamo webService per il reperimento della descrizione prodotto
	    	InfoPolizzaVO datiPolizza = pucS.getDatiPolizzaByPolizza(new Long(polizza.getNumero()));




	    	// Lista delle pratiche
			List<String> pratiche = Inputs.getListaPratiche(domanda);

			// Scorro la lista
			if(!pratiche.isEmpty()) { 				
				ArrayList<PraticaSpiegazioneConteggi> listaPratiche = new ArrayList<PraticaSpiegazioneConteggi>();
				
				polizza.setListaPraticheConteggi(listaPratiche);
								
				// Scorro le pratiche passate
				for(String numeroPratica : pratiche) {
					// Lista delle spiegazioni
					SpiegazioneConteggiVO spiegazione =	pucS.getSpiegazioneConteggiByPolizzaPratica(new Long(polizza.getNumero()),new Long(numeroPratica));

                    if(spiegazione==null){
                        throw new PucException("Errore dal Puc. getSpiegazioneConteggiByPolizzaPratica restituisce 'null' per le seguenti polizza e pratica: "
                                +polizza.getNumero()+" ," + numeroPratica);
                    }

					
					// Creazione pratica
					PraticaSpiegazioneConteggi pratica = new PraticaSpiegazioneConteggi();
					pratica.setNumeroPratica(numeroPratica);

                    //ELIMINO A SEGUITO SEGNALAZIONE BUG 30
					//START
					//if(commFEPolizzaVo.getCtvAccantonateCG()!=null)
					//	pratica.setCtvAccantonateCG(commFEPolizzaVo.getCtvAccantonateCG());
					//else
					//	pratica.setCtvAccantonateCG(0);
					//if(commFEPolizzaVo.getCtvAccantonateCM()!=null)
					//	pratica.setCtvAccantonateCM(commFEPolizzaVo.getCtvAccantonateCM());
					//else
					//	pratica.setCtvAccantonateCM(0);


                    pratica.setCtvDaInizioAnnoCG(commFEPolizzaVo.getCtvDaInizioAnnoCG()!=null?commFEPolizzaVo.getCtvDaInizioAnnoCG():0);
                    pratica.setCtvDaInizioAnnoCM(commFEPolizzaVo.getCtvDaInizioAnnoCM()!=null?commFEPolizzaVo.getCtvDaInizioAnnoCM():0);

                    //FINE PER BUG 30

					if(datiPolizza.getDescrizioneProdotto()!=null)
						pratica.setDescrizioneProdotto(datiPolizza.getDescrizioneProdotto());
					else
						pratica.setDescrizioneProdotto("");
					

					double totaleImportoNettoTermine = 0.00;
                    double importoNettoTermine =0.00;
                    List<SpiegazioneConteggi8> spiegazioneConteggi8= spiegazione.getSpiegazioneConteggi8();
                    if (spiegazioneConteggi8 !=null)   {
                    	SpiegazioneConteggi8 _spiegazione8= spiegazioneConteggi8.get(0);
                        totaleImportoNettoTermine = _spiegazione8.getImportoNettoTermine();

                    }
					
					// parametri globali
					createParametriGlobaliPratica(spiegazione, pratica, polizza,totaleImportoNettoTermine);

					// tabella primaria					
					/* COLONE*/
					String tipoLiquidazione = spiegazione.getSpiegazioneConteggi1().get(0).getCodAttivita();
					// Liquidazione "24" ---> RISCATTO PARZIALE
					if("24".equals(tipoLiquidazione)) {
						tabellaRiscattoParziale(spiegazione, pratica);
					}// Liquidazione "04" ---> RISCATTO TOTALE
					else if("04".equals(tipoLiquidazione)) {
						tabellaRiscattoTotale(spiegazione, pratica);
					}// Liquidazione "10" ---> RISCATTO SCADENZA
					else if("10".equals(tipoLiquidazione)) {
						tabellaRiscattoScadenza(spiegazione, pratica);
					}
					/* END COLONE*/
					
					//tabella imposte
					createTabellaImposte(spiegazione, pratica);

					//Bug 518 data 04-04-2016
                    /*String s1 = pratica.getTotaleValoreRiscatto().replace(".","").replace(',','.');
                    String s2 = pratica.getTotaleImposta()!=null?pratica.getTotaleImposta().replace(".","").replace(',','.'):"0.00";
                    double d= Double.parseDouble(s1)-Double.parseDouble(s2);
                    pratica.setValoreRiscattoNetto(
                            NumberUtils.formatCurrency(
                                    d,
                                    Costanti.SEPARATORE_MIGLIAIA,
                                    Costanti.SEPARATORE_DECIMALI));*/
					
					//DA IMPLEMENTARE COLONE
					//prendere i dati da spiegazione quando saranno disponibili
					double totaleValoreRiscattoTermine = 0.00;
					double coefficenteRiscattoTermine =0.00;
                    //List<SpiegazioneConteggi8> spiegazioneConteggi8= spiegazione.getSpiegazioneConteggi8();
                    if((spiegazioneConteggi8!=null)&&(spiegazioneConteggi8.size()>0)){
                        SpiegazioneConteggi8 _spiegazione8= spiegazioneConteggi8.get(0);
                        totaleValoreRiscattoTermine=_spiegazione8.getValoreRiscattoLordo();
                        coefficenteRiscattoTermine=_spiegazione8.getCoefficienteRiscatto();
                    }
                    //controllo per la visualizzazione della tabella n.4 del template (salvo modifiche)
                    if((polizza.getTipoPrestazione() != null && polizza.getTipoPrestazione().equalsIgnoreCase("r")) && 
                       (polizza.getDescrizioneFondoSintetica() != null && polizza.getDescrizioneFondoSintetica().equalsIgnoreCase("ful"))){                    
						pratica.setTotaleValoreRiscattoTermine(NumberUtils.formatCurrency(
								totaleValoreRiscattoTermine, 
								Costanti.SEPARATORE_MIGLIAIA, 
								Costanti.SEPARATORE_DECIMALI) );
                    }else{
                    	pratica.setTotaleValoreRiscattoTermine(NumberUtils.formatCurrency(
								0.00, 
								Costanti.SEPARATORE_MIGLIAIA, 
								Costanti.SEPARATORE_DECIMALI) );
                    }
					
					pratica.setCoefficenteRiscattoTermine(NumberUtils.formatCurrency(
							coefficenteRiscattoTermine,
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI) );
					//END DA IMPLEMENTARE COLONE
					
					/* COLONE 20120217            */
					pratica.setTotaleImportoNettoTermine(NumberUtils.formatCurrency(
							totaleImportoNettoTermine,
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI) );
					//controllo CIA 08/06/2012 visualizzazione tabella
					boolean testCIA = false;
					if (polizza.getTipoPrestazione().equalsIgnoreCase("r") && totaleImportoNettoTermine < totaleValoreRiscattoCIA && !tipoLiquidazione.equals("10"))
						testCIA = true;

					pratica.setTestTotaleImportoNettoTermine(testCIA);
					
					//chiamata al servizio listDatiPratichaByPolizza del PUC per la valorizzazione della dataRichiesta  
					List<PraticaVO> listPraticheBy = pucS.listDatiPratichaByPolizza(new Long(polizza.getNumero()));
					String nPratica = pratica.getNumeroPratica();
					for(int i=0;i<listPraticheBy.size();i++){
						PraticaVO praticaVO = (PraticaVO)listPraticheBy.get(i);
						String nPraticaVO = String.valueOf(praticaVO.getNPratica());
						if(nPraticaVO.equalsIgnoreCase(nPratica)){
							pratica.setDataRichiesta(StringUtils.blankString(DateUtils.getNullSefeCalendar(praticaVO.getDRichiesta())));
						}
					}


                    List<DettaglioFiscalitaPolizzeVO> listaDatiFiscalita=pucS.listDettaglioFiscalitaPolizzeAperteByNumeroPratica(pratica.getNumeroPratica());
                  //  List<DettaglioFiscalitaPolizzeVO> listaDatiFiscalita=pucS.listDettaglioFiscalitaPolizzeAperteByNumeroPratica("5431671");

                    for (int i=0; i< listaDatiFiscalita.size(); i++) {
                        DettaglioFiscalitaPolizzeVO beanFiscalita= listaDatiFiscalita.get(i);
                        //Tipo L sta ad indicare il Bollo
                        if (beanFiscalita.getTipoImposta().equalsIgnoreCase("L")){
                              pratica.setImpostaBolloFiscalita(NumberUtils.formatCurrency(
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
                            pratica.setTabellaImpostaSostitutiva(beanImposta);
                        }
                        if (beanFiscalita.getTipoImposta().equalsIgnoreCase("3")){
                            pratica.setTabellaRitenutaImposta(beanImposta);
                        }


                    }
					// Aggiungi pratica
					listaPratiche.add(pratica);				
				}
			} else{
				throw new StampeInfoException("Errore y11 - Lista Pratiche Vuota");
	        }

		} catch (NumberFormatException e) {
			LoggingUtils.error(e, e);
            throw new StampeInfoException("Errore y11 - "+  e.getMessage());
		} catch (ServiceException_Exception e) {
			LoggingUtils.error(e, e);
            throw new PucException("Errore y11 - "+  e.getMessage());
		}
    }
	
	private static void tabellaRiscattoParziale(SpiegazioneConteggiVO spiegazione, PraticaSpiegazioneConteggi pratica) {
		double totaleQuote = 0;
		double totaleControvalute = 0;
		double totaleValoreRiscatto = 0;
		List<SpiegazioneConteggi8> spiegazioneConteggi8= spiegazione.getSpiegazioneConteggi8();
		ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione2> tabella = new ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione2>();
		for(SpiegazioneConteggi8 conteggio : spiegazioneConteggi8) {
			PraticaSpiegazioneConteggiRecordTipoLiquidazione2 record = 	new PraticaSpiegazioneConteggiRecordTipoLiquidazione2();
			//Applicazione
			record.setApplicazione(""+conteggio.getAppendice());				
			
			//Data Disinvestimento
			record.setDataDisinvestimento(DateUtils.formatDate(
					conteggio.getDataDisinvestimentoNav(),
					Costanti.FORMATO_DATA));			
			
			//Fondo Interno
			record.setFondoInterno(conteggio.getCodiceFondo());
            record.setNumeroQuote(String.valueOf(conteggio.getQuoteDisinvestite()));
            record.setQuotazioneUnitaria(String.valueOf(conteggio.getValoreNav()));
			//Numero Quote Disinvestite
		/*	record.setNumeroQuote(
					NumberUtils.formatQuote(
							conteggio.getQuoteDisinvestite(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI));				
			//Quotazione unitaria
			record.setQuotazioneUnitaria(
					NumberUtils.formatQuote(
						conteggio.getValoreNav(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));		*/
			//Controvaluta quota
			record.setControvaloreQuote(
					NumberUtils.formatCurrency(
						conteggio.getControvaloreDisinvestimento(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));				
			//Coefficente di riscatto
			record.setCoefficienteRiscatto(
					NumberUtils.formatCoefficiente(
						conteggio.getCoefficienteRiscatto(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));				
			//Valore di riscatto lordo
			record.setValoreRiscatto(
					NumberUtils.formatCurrency(
						conteggio.getValoreRiscattoLordo(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));				
			// Aggiungo record alla tabella
			tabella.add(record);
			
			// Incremento counters
			totaleQuote += conteggio.getQuoteDisinvestite();
			totaleControvalute += conteggio.getControvaloreDisinvestimento();
			totaleValoreRiscatto += conteggio.getValoreRiscattoLordo();
			totaleValoreRiscattoCIA += conteggio.getValoreRiscattoLordo();
		}
		// Set tabella dentro la pratica
		pratica.setTabella1(tabella);


		
		// set dei Totali
		pratica.setTotaleQuote( NumberUtils.formatQuote(
				totaleQuote, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));
		
		pratica.setTotaleControvalute( NumberUtils.formatCurrency(
				totaleControvalute, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));
		
		pratica.setTotaleValoreRiscatto( NumberUtils.formatCurrency(
				totaleValoreRiscatto, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));

		//Bug 518 data 04-04-2016
		// eseguo una sovrascrittura ai valori settati in precedenza
		/*pratica.setValoreRiscattoLordo(
                NumberUtils.formatCurrency(
                        totaleValoreRiscatto,
                        Costanti.SEPARATORE_MIGLIAIA,
                        Costanti.SEPARATORE_DECIMALI));*/

	}
	
	private static void tabellaRiscattoTotale(SpiegazioneConteggiVO spiegazione, PraticaSpiegazioneConteggi pratica) {
		double totaleQuote = 0;
		double totaleControvalute = 0;
		double totaleValoreRiscatto = 0;
		List<SpiegazioneConteggi8> spiegazioneConteggi8= spiegazione.getSpiegazioneConteggi8();
		
		ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione4> tabella = new ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione4>();		
		for(SpiegazioneConteggi8 conteggio : spiegazioneConteggi8) {
			PraticaSpiegazioneConteggiRecordTipoLiquidazione4 record =	new PraticaSpiegazioneConteggiRecordTipoLiquidazione4();
			//Applicazione
			record.setApplicazione(""+conteggio.getAppendice());
			//Fondo Interno
			record.setFondoInterno(conteggio.getCodiceFondo());

            record.setNumeroQuote(String.valueOf(conteggio.getQuoteDisinvestite()));
            record.setQuotazioneUnitaria(String.valueOf(conteggio.getValoreNav()));
            //Numero Quote Disinvestite
		/*	record.setNumeroQuote(
					NumberUtils.formatQuote(
							conteggio.getQuoteDisinvestite(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
			//Quotazione unitaria
			record.setQuotazioneUnitaria(
					NumberUtils.formatQuote(
						conteggio.getValoreNav(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));		*/

			//Controvaluta quota
			record.setControvaloreQuote(
					NumberUtils.formatCurrency(
						conteggio.getControvaloreDisinvestimento(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));
			//Coefficente di riscatto
			record.setCoefficienteRiscatto(
					NumberUtils.formatCoefficiente(
						conteggio.getCoefficienteRiscatto(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));	
			//Valore di riscatto lordo
			record.setValoreRiscatto(
					NumberUtils.formatCurrency(
						conteggio.getValoreRiscattoLordo(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));				
			// Aggiungo record alla tabella
			tabella.add(record);
			
			// Incremento counters
			totaleQuote += conteggio.getQuoteDisinvestite();
			totaleControvalute += conteggio.getControvaloreDisinvestimento();
			totaleValoreRiscatto += conteggio.getValoreRiscattoLordo();
			totaleValoreRiscattoCIA += conteggio.getValoreRiscattoLordo();
		}
		// Set tabella dentro la pratica
		pratica.setTabella2(tabella);
		
		// set dei Totali
		pratica.setTotaleQuote( NumberUtils.formatQuote(
				totaleQuote, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));
		
		pratica.setTotaleControvalute( NumberUtils.formatCurrency(
				totaleControvalute, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));
		
		pratica.setTotaleValoreRiscatto( NumberUtils.formatCurrency(
				totaleValoreRiscatto, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));

		//Bug 518 data 04-04-2016
		// eseguo una sovrascrittura ai valori settati in precedenza
		/*pratica.setValoreRiscattoLordo(
				NumberUtils.formatCurrency(
					totaleValoreRiscatto, 
					Costanti.SEPARATORE_MIGLIAIA, 
					Costanti.SEPARATORE_DECIMALI));*/
		//Bug 518 data 04-04-2016
		pratica.setRiscattoTotale(true);
	}

	private static void tabellaRiscattoScadenza(SpiegazioneConteggiVO spiegazione, PraticaSpiegazioneConteggi pratica) {
		double totaleQuote = 0;
		double totaleControvalute = 0;
		double totaleValoreRiscatto = 0;
		List<SpiegazioneConteggi8> spiegazioneConteggi8= spiegazione.getSpiegazioneConteggi8();
		ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione1> tabella =	new ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione1>();
		
		for(SpiegazioneConteggi8 conteggio : spiegazioneConteggi8) {
			PraticaSpiegazioneConteggiRecordTipoLiquidazione1 record =	new PraticaSpiegazioneConteggiRecordTipoLiquidazione1();
			//Applicazione
			record.setApplicazione(""+conteggio.getAppendice());
			//Fondo Interno
			record.setFondoInterno(conteggio.getCodiceFondo());

            record.setNumeroQuote(String.valueOf(conteggio.getQuoteDisinvestite()));
            record.setQuotazioneUnitaria(String.valueOf(conteggio.getValoreNav()));
            //Numero Quote Disinvestite
		/*	record.setNumeroQuote(
					NumberUtils.formatQuote(
							conteggio.getQuoteDisinvestite(),
							Costanti.SEPARATORE_MIGLIAIA,
							Costanti.SEPARATORE_DECIMALI));
			//Quotazione unitaria
			record.setQuotazioneUnitaria(
					NumberUtils.formatQuote(
						conteggio.getValoreNav(),
						Costanti.SEPARATORE_MIGLIAIA,
						Costanti.SEPARATORE_DECIMALI));		*/

			//Controvaluta quota
			record.setControvaloreQuote(
					NumberUtils.formatCurrency(
						conteggio.getControvaloreDisinvestimento(), 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));
			// Coeff. conversione, Coeff. riscatto, Valore riscatto
			if( (spiegazione.getSpiegazioneConteggi8() != null) && (!spiegazione.getSpiegazioneConteggi8().isEmpty())){
				for(SpiegazioneConteggi8 spiegConteggi8 : spiegazione.getSpiegazioneConteggi8()){
					Double coeffB = conteggio.getCoefficienteConversioneRendita();
					//Double coeffC = spiegConteggi8.getCoefficienteRiscatto();
					Double coeffC = conteggio.getCoefficienteRiscatto();
					//Double valoreA = conteggio.getControvaloreDisinvestimento();
					
					// Coefficente Conversione (B)
					record.setCoefficienteConversioneB(
							NumberUtils.formatCoefficienteB(
									coeffB, 
									Costanti.SEPARATORE_MIGLIAIA, 
									Costanti.SEPARATORE_DECIMALI));
					
					// Coefficente Riscatto (C)
					record.setCoefficienteConversioneC(
							NumberUtils.formatCoefficiente(
									coeffC, 
									Costanti.SEPARATORE_MIGLIAIA, 
									Costanti.SEPARATORE_DECIMALI));
					
					// Valore di riscatto
					//Double totale = (valoreA * coeffC) / coeffB;
					Double totale = conteggio.getValoreRiscattoLordo();
					record.setValoreRiscatto(
							NumberUtils.formatCurrency(
									totale, 
									Costanti.SEPARATORE_MIGLIAIA, 
									Costanti.SEPARATORE_DECIMALI));
										
				}
			}else{
				record.setCoefficienteConversioneB("");
				record.setCoefficienteConversioneC("");
				
				// Valore riscatto
				record.setValoreRiscatto(
						NumberUtils.formatCurrency(
							conteggio.getValoreRiscattoLordo(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI));
				
				// Incremento counter in modo localizzato
				totaleValoreRiscatto += conteggio.getValoreRiscattoLordo();
			}			
			tabella.add(record);			
			totaleValoreRiscatto += conteggio.getValoreRiscattoLordo();
			// Incremento counters
			totaleQuote += conteggio.getQuoteDisinvestite();
			totaleControvalute += conteggio.getControvaloreDisinvestimento();
			totaleValoreRiscattoCIA += conteggio.getValoreRiscattoLordo();
		}
		// Set tabella dentro la pratica
		pratica.setTabella3(tabella);
		
		// set dei Totali
		pratica.setTotaleQuote( NumberUtils.formatQuote(
				totaleQuote, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));
		
		pratica.setTotaleControvalute( NumberUtils.formatCurrency(
				totaleControvalute, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));
		
		pratica.setTotaleValoreRiscatto( NumberUtils.formatCurrency(
				totaleValoreRiscatto, 
				Costanti.SEPARATORE_MIGLIAIA, 
				Costanti.SEPARATORE_DECIMALI));

		//Bug 518 data 04-04-2016
		// eseguo una sovrascrittura ai valori settati in precedenza
		/*pratica.setValoreRiscattoLordo(
				NumberUtils.formatCurrency(
					totaleValoreRiscatto, 
					Costanti.SEPARATORE_MIGLIAIA, 
					Costanti.SEPARATORE_DECIMALI));*/




	}

	/**
	 * @param spiegazione
	 * @param pratica
	 */
	private static void createParametriGlobaliPratica( SpiegazioneConteggiVO spiegazione,PraticaSpiegazioneConteggi pratica, Polizza polizza, double importoNettoTermine) 
	{
		// Primo elemento di spiegazione conteggi
		SpiegazioneConteggi1 spiegConteggi1 = spiegazione.getSpiegazioneConteggi1().get(0);
		SpiegazioneConteggi2 spiegConteggi2 = spiegazione.getSpiegazioneConteggi2();
		
		
		// Parametri globali pratica
		String tipoLiquidazione = spiegConteggi1.getCodAttivita();

		//Bug 518 data 04-04-2016
		// Label
		if (!"24".equals(tipoLiquidazione)) {
			pratica.setLabelValoreRicattoLordo("TOTALE LORDO DI EURO");
			pratica.setLabelValoreRicattoNetto("TOTALE NETTO DI EURO");
		}

		else {
			pratica.setLabelValoreRicattoLordo("LORDO DI EURO");
			pratica.setLabelValoreRicattoNetto("NETTO DI EURO");
		}

		// Valore Riscatto Lordo
		if ((spiegConteggi2 != null)
				&& (spiegConteggi2.getValoreRiscattoLordoLiquidato() != null)) 
		{
			pratica.setValoreRiscattoLordo(
					NumberUtils.formatCurrency(
						spiegazione.getSpiegazioneConteggi2().getValoreRiscattoLordoLiquidato(),
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));
		}

		else
			pratica.setValoreRiscattoLordo("");

		// Valore riscatto Netto
		if ( spiegazione.getValoreRiscattoNettoLiquidato() != null) {
			pratica.setValoreRiscattoNetto(
					NumberUtils.formatCurrency(
						spiegazione.getValoreRiscattoNettoLiquidato(),
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));
		} else
			pratica.setValoreRiscattoNetto("");

		// Data liquidazione
		pratica.setDataLiquidazione(
				DateUtils.formatDate(
						spiegazione.getSpiegazioneConteggi1().get(0).getDataLiquidazione(),
						Costanti.FORMATO_DATA));

		// Data valuta
		pratica.setDataValuta(
				DateUtils.formatDate(
						spiegazione.getSpiegazioneConteggi2().getDataValuta(),
						Costanti.FORMATO_DATA));

		// Frase Finale in base al tipoLiquidazione
		if ("24".equals(tipoLiquidazione)) {
			pratica.setFraseFinale("");
			pratica.setDescrizioneLiquidazione("Riscatto Parziale");
		}

		else if ("04".equals(tipoLiquidazione)) {
			//Double valore = spiegazione.getValoreRiscattoNettoLiquidato();
			pratica.setDescrizioneLiquidazione("Riscatto Totale");
			
			if (spiegConteggi1.getValoreRiscattoLordo() > importoNettoTermine ) {
				pratica.setFraseFinale(
						"Occorre precisare che, come descritto nelle Condizioni "
						+ "contrattuali, il valore di riscatto non può comunque risultare superiore al "
						+ "valore di riscatto al termine del periodo di differimento. Qualora si verifichi "
						+ "tale circostanza, come accaduto nel caso di specie, la Compagnia riconosce come "
						+ "somma liquidabile immediatamente l'importo del capitale al termine. Quest'ultimo "
						+ "valore viene determinato moltiplicando la rendita maturata alla data di liquidazione "
						+ "per il coefficiente di riscatto.");
			} else
				pratica.setFraseFinale("");
		} 
		
		else if ("10".equals(tipoLiquidazione)) {
			pratica.setDescrizioneLiquidazione("Scadenza");
			
			pratica.setFraseFinale("Qualora siano stati corrisposti tutti i premi pattuiti e "
					+ "non siano stati effettuati riscatti, la prestazione assicurata al termine "
					+ "del periodo di differimento non potrà essere inferiore all'importo della "
					+ "Prestazione Minima Garantita a Scadenza.");

		}
		
		// Gestione interessi di mora
		if( (polizza.getLiquidazioni() != null) && (!polizza.getLiquidazioni().isEmpty())) {
			Liquidazione liquidazione = polizza.getLiquidazioni().get(0);
			
			String interessiMora = liquidazione.getInteressiMora();
			String interessiRitPagamento = liquidazione.getIntRitPag();
						
			if(!Costanti.ZERO_STRING_FORMATTED.equals(interessiMora))
				pratica.setInteressiMoraPolizza(interessiMora);
			
			if(!Costanti.ZERO_STRING_FORMATTED.equals(interessiRitPagamento))
				pratica.setInteressiRitardatoPagamentoPolizza(interessiRitPagamento);
			
			// Eccedenza della polizza
			if(!"".equals(polizza.getEccedenza()))
				pratica.setEccedenzaPolizza(polizza.getEccedenza());
		}	
		
	}		
	
	/**
     * Questo crea la tablla 4 relativa a spiegazione conteggi R3
	 * @param spiegazione
	 * @return
	 */
	private static void createTabellaImposte(SpiegazioneConteggiVO spiegazione, PraticaSpiegazioneConteggi pratica) {		
		double totaleImponibile = 0;
		double totaleImposta = 0;
		
		List<SpiegazioneConteggi3> lista3 = spiegazione.getSpiegazioneConteggi3();
		if(lista3 != null && lista3.size() > 0){
			ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale> tabella = new ArrayList<PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale>();
			for(SpiegazioneConteggi3 conteggio : lista3) {
				PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale record =	new PraticaSpiegazioneConteggiRecordTipoLiquidazione2Opzionale();
				
				//TODO da implementare il controllo per quanto riguarda gli interessi di mora
				if(conteggio.getTipoImpostaID()!= null && conteggio.getTipoImpostaID().trim().equalsIgnoreCase("A")){
					pratica.setInteressiMoraPolizza(NumberUtils.formatCurrency(
							conteggio.getImponibile(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI) );
				}

                //SE è STATA PAGATA L'IMPOSTA DI BOLLO
                if(conteggio.getTipoImpostaID().equalsIgnoreCase("L")||conteggio.getTipoImpostaID().equalsIgnoreCase("P")){
                    pratica.setHasImpostaDiBollo(true);
                }

				// data disinvestimento
				record.setDataDisinvestimento(
						DateUtils.formatDate(
							conteggio.getDataValutaDisinvestimento(),
							Costanti.FORMATO_DATA) );

				// tipo imposta
				record.setTipoImposta(conteggio.getDescrizioneTipoImposta().trim());

				// imponibile
				record.setImponibile(
						NumberUtils.formatCurrency(
							conteggio.getImponibile(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI) );

				// Aliquota
				// Aliquota
				record.setAliquota(
						NumberUtils.formatQuote(
							conteggio.getPercentualeAliquotaImposta(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI));

				// Imposta
				record.setImposta(
						NumberUtils.formatCurrency(
							conteggio.getImposta(), 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI));

				tabella.add(record);
				
				// Incremento counters
				totaleImponibile += conteggio.getImponibile();
				totaleImposta += conteggio.getImposta();
			}
            //TODO IF IMPOSTA >0
			pratica.setTabella4(tabella);
			//setto i totali
			pratica.setTotaleImponibile(				
					NumberUtils.formatCurrency(
							totaleImponibile, 
							Costanti.SEPARATORE_MIGLIAIA, 
							Costanti.SEPARATORE_DECIMALI));
			
			pratica.setTotaleImposta(
					NumberUtils.formatCurrency(
						totaleImposta, 
						Costanti.SEPARATORE_MIGLIAIA, 
						Costanti.SEPARATORE_DECIMALI));
		}
	}	
}