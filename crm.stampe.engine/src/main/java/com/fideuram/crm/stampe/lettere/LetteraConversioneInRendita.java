package com.fideuram.crm.stampe.lettere;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.factory.FormatterFactory;
import com.fideuram.puc.service.impl.DettaglioCoefficienteRenditaFrazionataVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.PolizzaQuery;

import java.text.ParseException;

/**
 * @author Giuseppe Luciani
 * @author Lidia Castrovillari
 * @author Giorgio Desideri
 *
 * IMPORTANTE QUESTA LETTERA VIENE UTILIZZATA SOLO POLIZZE DI CAPITALE RAMO I
 */
public class LetteraConversioneInRendita extends LetteraEngine {

    public LetteraConversioneInRendita(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
	 * @param dest
	 * @throws CrmStampeException
	 */
	public void completaPolizza(Polizza dest, DomandaVO dom) throws StampeInfoException, WebServiceClientException, PucException, DaoException {

		//------------ CASO VITA per diverso da vita Intera------------
		new TabellaValoreRiscattoTermine(comID).impostaTabellaValoreRiscatto(dest);

        if(PolizzaQuery.isMacroFamigliaMatch(dest,PolizzaQuery.FIDEURAM_VITA_INSIEME)||
           PolizzaQuery.isMacroFamigliaMatch(dest,PolizzaQuery.GARANZIA_E_VALORE))
           dest.addAttributo("labelTabellaValutazione", "STIMA RENDITA VITALIZIA LORDA");

        String tripletta =  dom.getDescrizioneDomanda().getVecchioliv1() +
                            dom.getDescrizioneDomanda().getVecchioliv2() +
                            dom.getDescrizioneDomanda().getVecchioliv3();

     		//-----------  CHIAMATA MOTORE UNIVERSO-------------------
		String polizza = dest.getNumero();
		String dataValutazione = dest.getAttributo("dataValutazione");

        try {

            DettaglioCoefficienteRenditaFrazionataVO d = pucS.getSimulatoreConversioneRenditaByPolizza(dest.getNumero(), dest.getDurataMinima(), dest.getPremioAggiuntivo());
            dest.addAttributo("renditaAnnuale", FormatterFactory.getStandardImporto(Double.valueOf(d.getRenditaAnnuale())));

            dest.addAttributo("dataRiferimentoRiscatto", getDataRiferimento(dest));

            if(!dest.getProdotto().trim().equalsIgnoreCase("RS0U1") && !dest.getProdotto().trim().equalsIgnoreCase("RS0U2")
                    && !dest.getProdotto().trim().equalsIgnoreCase("RM0U1") && !dest.getProdotto().trim().equalsIgnoreCase("RB0U1")
                    && !dest.getProdotto().trim().equalsIgnoreCase("RB0U2") && !dest.getProdotto().trim().equalsIgnoreCase("RV0U1")
                    && !dest.getProdotto().trim().equalsIgnoreCase("RP") && !dest.getProdotto().trim().equalsIgnoreCase("RG0T2")
                    && !dest.getProdotto().trim().equalsIgnoreCase("RG0T1"))
            {
                dest.addAttributo("dataRiferimentoRiscatto", dest.getDataErogazioneRendita());
            }  else {
                dest.addAttributo("dataRiferimentoRiscatto", getDataRiferimento(dest));
            }


            dest.addAttributo("importoDaConvertire", FormatterFactory.getStandardImporto(Double.valueOf(d.getImportoDaConvertire())));
            dest.setPremioAggiuntivo(!dest.getPremioAggiuntivo().trim().equals("")?FormatterFactory.getStandardImporto(Double.valueOf(dest.getPremioAggiuntivo())):"");
            dest.setDifferimento();
            setDescrizioneRiscatto(dest);                                                                                   //CARICO I TRONCONI

        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        } catch (ParseException e) {
            throw new StampeInfoException(e);
        }

    }

    private String getDataRiferimento(Polizza dest){
           String ggMM=dest.getDataEmissione().substring(0,6);
           Integer anno=Integer.decode(dest.getDataEmissione().substring(6,10));
           Integer durata=Integer.decode(!dest.getDurataMinima().trim().equals("")?dest.getDurataMinima():"0");
           Integer totale= anno+durata+1;
           return ggMM+totale;
    }


    /**
     * Logiche secondo Feature#64 di Redmine
     * compone il testo da stampare nel documento come spiegazione  dell'importo oggetto del ricatto
     * @param dest        la Polizza di destinazione dei dati
     */
    private static void setDescrizioneRiscatto(Polizza dest) throws ParseException {


        if(dest.getRamoMinisteriale().equalsIgnoreCase("3")){
            if((dest.getProdotto().trim().equalsIgnoreCase("PR001")||(dest.getProdotto().trim().equalsIgnoreCase("PR002")))){
                String descrizione=dest.getTroncone("ConversioneRenditaPR");
                if(dest.getProdotto().trim().equalsIgnoreCase("PR002"))
                      descrizione= descrizione+ dest.getTroncone("ConversioneRenditaPR002");
                dest.addAttributo("descrizioneRendita",descrizione);
            }else{
                if((dest.getProdotto().trim().equalsIgnoreCase("80"))){
                    dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaFIP80"));
                }else{
                	if(dest.getDifferimento().getDataFine().equals("")){
                		dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMaggiore20"));
                	}
                	else{
	                    if(dest.getDifferimento().isMaggioreAnni(10) && dest.getDifferimento().isMinoreAnni(20)){
	                        dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMaggiore10"));
	                    }
	                    if(dest.getDifferimento().isMaggioreAnni(20)){
	                        dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMaggiore20"));
	                    }
	                    if(dest.getDifferimento().isMinoreAnni(10)){
	                        dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaDiffMinore10"));
	                    }
                	}
                }
            }
           
           if(dest.getProdotto().trim().equalsIgnoreCase("RS0U1") || dest.getProdotto().trim().equalsIgnoreCase("RS0U2")
        		   || dest.getProdotto().trim().equalsIgnoreCase("RM0U1") || dest.getProdotto().trim().equalsIgnoreCase("RB0U1")
        		   || dest.getProdotto().trim().equalsIgnoreCase("RB0U2") || dest.getProdotto().trim().equalsIgnoreCase("RV0U1"))
           {
        	   String attributo =  dest.getTroncone("ConversioneRenditaFVI");
               //dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaFVI"));
               if(dest.getProdotto().trim().equalsIgnoreCase("RV0U1")&&(dest.getDurataMinima().trim().equals("1"))){
                  attributo=attributo.replace("trascorsi 10 anni","trascorso 1 anno");
               }
               dest.addAttributo("descrizioneRendita",attributo);
           }
           
        }else if(dest.getRamoMinisteriale().equalsIgnoreCase("1")){
            if((dest.getProdotto().trim().equalsIgnoreCase("53"))||(dest.getProdotto().trim().equalsIgnoreCase("54"))){
                dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaCerta"));
            }
            if(dest.getProdotto().trim().equalsIgnoreCase("RP") || dest.getProdotto().trim().equalsIgnoreCase("RG0T2")
            		|| dest.getProdotto().trim().equalsIgnoreCase("RG0T1")){
                dest.addAttributo("descrizioneRendita", dest.getTroncone("ConversioneRenditaGV"));
            }
        }

    }



            /*

            ClientUniverso universoWs = ClientWsFactory.getInstance().getUniversoClient();
            WSConversioneinRenditaBean bean = universoWs.getConversioneInRendita(polizza, dataValutazione);

            if (bean != null) {
                dest.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());
            }



            if (bean != null) {
            // verificare se l'importo delle PrestazioniVita sono uguali a renditaIniziale restituito dal motore.
            dest.addAttributo("importoPrestazioniVita", bean.getRenditaIniziale());
            dest.addAttributo("importoRiscatto", bean.getValoreDiRiscattoTotaleLordo());
        }*/
    // Se VITA INTERA
		/*if ("VI".equals(dest.getCodiceGruppo())) {
		    dest.addAttributo("importoPrestazioniMorte", "");
	    	dest.addAttributo("dataRiferimentoPrestazioniMorte", dest.getDataFineDifferimento());
		    dest.addAttributo("descrizionePrestazioniMorte", dest.getTroncone("PrestMorteCapitaleMaturato"));


			dest.addAttributo("dataRiferimentoRiscatto", dest.getDataErogazioneRendita());
			dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrConversionerenditaVitalizia"));

			if ("VIVA".equalsIgnoreCase(dest.getCodiceFondo().trim())) {
				dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
						+ dest.getTroncone("DescrConversione"));
			} else {
				dest.addAttributo("descrizioneRiscatto", dest.getAttributo("descrizioneRiscatto")
						+ dest.getTroncone("DescrConversione1999"));
			}
		} else {	//  Se Globale Vita
			dest.addAttributo("dataRiferimentoPrestazioniVita", dest.getDataErogazioneRendita());
	        dest.addAttributo("descrizionePrestazioniVita", dest.getTroncone("PrestVitaRenditaAnnuaLordaVitalizia"));


			dest.addAttributo("dataRiferimentoRiscatto", dest.getDataFineDifferimento());
			dest.addAttributo("descrizioneRiscatto", dest.getTroncone("DescrValoreRiscattoLordoFD"));

			// DescrRichiesta 1mese o 3mesi o Tempestiva
			DescrizioniComuni.impostaDescrizioneRichiesta(dest);
		}*/


}
