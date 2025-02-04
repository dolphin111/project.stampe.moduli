package com.fideuram.crm.stampe.lettere;

import java.util.ArrayList;
import java.util.List;

import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.CoefficienteCpp;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.puc.service.impl.CaricamentiCppVO;
import com.fideuram.puc.service.impl.CaricamentiCppVORamoIII;
import com.fideuram.puc.service.impl.ServiceException_Exception;

/**
 * @author Giorgio Desideri
 *
 */
public class LetteraCaricamentiCPP extends LetteraEngine {

    public LetteraCaricamentiCPP(int comID) throws WebServiceClientException {
        super(comID);
    }

    /**
     * @param dest
     * @throws CrmStampeException 
     */
    public  void completaPolizza(Polizza dest) throws WebServiceClientException, PucException, StampeInfoException {
    	String stampaCppText = null;
        if ("1".equals(dest.getRamoMinisteriale())) {
        	
        	try {

				// Prendo dal PUC l alista dei caricametni secondo l apolkizza
				List<CaricamentiCppVO> listaCaricamenti = pucS.listCaricamentiCppByPolizza(new Long(dest.getNumero()));
				
				ArrayList<CoefficienteCpp> listaCoefficienti = new ArrayList<CoefficienteCpp>(); 
				dest.setListaCoefficientiCpp(listaCoefficienti);
				
				CoefficienteCpp coefficiente = null;
				for(CaricamentiCppVO caricamento : listaCaricamenti) {
					coefficiente = new CoefficienteCpp();
					
					if(caricamento.getCoefficiente() != null)
						coefficiente.setCoefficiente(caricamento.getCoefficiente());
					
					if(caricamento.getAppendice() != null)
						coefficiente.setAppendice(caricamento.getAppendice());
					
					if(caricamento.getCodiceTariffa() != null)
						coefficiente.setTariffa(caricamento.getCodiceTariffa());
					
					// Aggiungo coefficiente alla lista				
					listaCoefficienti.add(coefficiente);
				}

			} catch (ServiceException_Exception e) {
				throw new PucException(e.getMessage());
			}
			
        } else {
        	///Ramo 3°
        	try {
				List<CaricamentiCppVORamoIII> listaCaricamenti = pucS.listCaricamentiCppByPolizzaRamoIII(new Long(dest.getNumero()));
				ArrayList<CaricamentiCppVORamoIII> listaCoefficienti = new ArrayList<CaricamentiCppVORamoIII>(); 
				dest.setListaCaricamentiCppVORamoIII(listaCoefficienti);
				
				CaricamentiCppVORamoIII coefficiente = null;
				for(CaricamentiCppVORamoIII caricamento : listaCaricamenti) {
					coefficiente = new CaricamentiCppVORamoIII();
					
					if(caricamento.getDescrizione() != null)
						coefficiente.setDescrizione(caricamento.getDescrizione());
					
					if(caricamento.getPercentualeCaricamento() != null)
						coefficiente.setPercentualeCaricamento(caricamento.getPercentualeCaricamento());
					
					if(caricamento.getTipoTitolo() != null)
						coefficiente.setTipoTitolo(caricamento.getTipoTitolo());
					
					// Aggiungo coefficiente alla lista				
					listaCoefficienti.add(coefficiente);
				}
			}catch (ServiceException_Exception e) {
				throw new PucException(e.getMessage());
			} 
        }
        
        // Costruisco la stringa
        stampaCppText = costruisciStampaCppText(dest);

        // Aggiugno attributo
        dest.addAttributo("stampaCPP", stampaCppText);
        
        //-----------  PRESTAZIONI ASSICURATE -------------------
        TabellaPrestazioniAssicurate.impostaTabellaPrestazioniAssicurate(dest);

    }

	/**
	 * Costruisce l'attributo da stampare
	 * 
	 * @param polizza	{@link com.fideuram.crm.stampe.model.Modello}
	 * 
	 * @return	{@linkplain java.lang.String}
	 */
	private static String costruisciStampaCppText(Polizza polizza)throws StampeInfoException {
		StringBuffer buffer = new StringBuffer();
		if ("1".equals(polizza.getRamoMinisteriale())) {
			if( (polizza.getListaCoefficientiCpp() != null) 
				&& (!polizza.getListaCoefficientiCpp().isEmpty())) {
				// Frase iniziale
				buffer.append("La percentuale di caricamento applicate è pari al:\n");
				
				for(CoefficienteCpp current : polizza.getListaCoefficientiCpp()) {
					String appendix = "base";
					
					if(current.getAppendice() > 0)
						appendix = current.getAppendice().toString(); 
					
					buffer.append(
							"- " 
							+ current.getCoefficiente() 
							+ "% di ciascun premio netto corrisposto per la garanzia "
							+ appendix 
							+ " (tar. "
							+ current.getTariffa()
							+ ")\n");
				}
			}
			else {
				throw new StampeInfoException("Lista Caricamenti CPP non valorizzata");
			}
		}else{
			//RAMO 3°
			if( (polizza.getListaCaricamentiCppVORamoIII() != null) 
					&& (!polizza.getListaCaricamentiCppVORamoIII().isEmpty())) {
					// Frase iniziale
				buffer.append("La percentuale di caricamento applicate è pari al:\n\n");
					String descrizione = "";
					for(CaricamentiCppVORamoIII current : polizza.getListaCaricamentiCppVORamoIII()) {
						descrizione = decodificaDescrizione(current.getTipoTitolo().trim());						
						buffer.append(
								"- " 
								+ current.getPercentualeCaricamento() 
								+ "% "+descrizione								
								+ "\n");						
					}
					buffer.append("\nI caricamenti sono stati applicati in base alla Classe di Patrimonio Potenziale assegnata al contratto (CPP) e al cumulo dei versamenti effettuati sul contratto (CVN).");
				}
				else {
					throw new StampeInfoException("Lista Caricamenti CPP RAMO 3 non valorizzata");
				}
		}
		
		return buffer.toString();
	}

	private static String decodificaDescrizione(String tipoTitolo) {
		String descrizioneFinale = "";
		if(tipoTitolo.equals("01"))
			descrizioneFinale = "per la prima rata di prima annualità";
		if(tipoTitolo.equals("02"))
			descrizioneFinale = "per il premio unico";
		if(tipoTitolo.equals("03"))
			descrizioneFinale = "per le rate di prima annualità";
		if(tipoTitolo.equals("04"))
			descrizioneFinale = "(media delle percentuali applicate) per le rate di annualità successive";
		if(tipoTitolo.equals("05"))
			descrizioneFinale = "per la rata estemporanea di prima annualità";
		if(tipoTitolo.equals("06"))
			descrizioneFinale = "per la rata estemporanea di annualità successiva";
		return descrizioneFinale;
	}
}
