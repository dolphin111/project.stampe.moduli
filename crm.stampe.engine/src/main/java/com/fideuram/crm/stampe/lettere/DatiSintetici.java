package com.fideuram.crm.stampe.lettere;

import java.util.List;

import com.fideuram.crm.stampe.generatori.LetteraEngine;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.crm.stampe.model.Indirizzo;
import com.fideuram.crm.stampe.model.Persona;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.stampe.model.PrivateBanker;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return.AltriDati;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return.DatiTecnici;
import com.fideuram.puc.service.impl.GetDatiSinteticiPolizzaResponse.Return.FigureContrattuali;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.stampe.dao.PucDao;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.NumberUtils;
import com.fideuram.utils.StringUtils;

public class DatiSintetici  extends LetteraEngine  {

	public DatiSintetici(int comID) throws WebServiceClientException {
		super(comID);
		// TODO Auto-generated constructor stub
	}
	
    public void impostaDatiSintetici(Polizza dest, boolean root) throws WebServiceClientException, PucException {
    	StampeServiceImpl pucClient = (StampeServiceImpl) new ClientWs().getPucClient(comID);
        Polizza target = (Polizza) new PucDao(comID).getDatiPolizza(Long.decode(dest.getNumero()));
        
        if(!target.isCollettiva()){
            getDatiDettaglioAnagrafica(pucClient, target);
            getDatiSintetici(pucClient, target);
        }
        
        
         
    }
    
    private static void getDatiSintetici(StampeServiceImpl service,
            Polizza targetPolizza) throws PucException {
    	Return polizzaDati = null;
    	try {
    		polizzaDati = service.getDatiSinteticiPolizza(new Long(targetPolizza
                    .getNumero()));
        } catch (ServiceException_Exception e) {
            throw new PucException(e);
        }
    	if(polizzaDati.equals(null))
    		return;
    	else{
    		DatiTecnici dt = polizzaDati.getDatiTecnici();
    		AltriDati ad = polizzaDati.getAltriDati();
    		FigureContrattuali fc = polizzaDati.getFigureContrattuali();
    		
    		if(!dt.getStato().equals(null))
    			targetPolizza.setStatoDT(dt.getStato());
    		
    		if(!ad.getVincolo().equals(null))
    			targetPolizza.setVincolo(ad.getVincolo().isAttivo());
    		
    		if(!ad.getDecumuloCedola().equals(null))
    			targetPolizza.setDecumuloAttivo(ad.getDecumuloCedola().isAttivo());
    		
    		targetPolizza.setImponibileCongelamento(ad.getImponibileCongelamento());
    		
    		targetPolizza.setImportoPianoProgrammatoVersamenti(ad.getImportoPianoProgrammatoVersamenti());
    		
    		targetPolizza.setDetraibiltaFiscale(ad.getDetraibilitaFiscale().isStato());
    		
    		targetPolizza.setPolizzaScudata(ad.isPolizzaScudata());
    		
    		targetPolizza.setImpostaBolloMaturata(ad.getImpostaBolloMaturata());  
    		
    		targetPolizza.setIsVariazioneContrattuale(ad.isIsVariazioneContrattuale());
    		
    		targetPolizza.setTipoClasseBonus(ad.getTipoClasseBonus());
    		
    		targetPolizza.setRiallocazioneGuidata(ad.isIsRiallocazioneGuidata());
    		
    		if(!fc.getBeneficiarioVita().equals(null))
    			targetPolizza.setBeneficiarioVita(fc.getBeneficiarioVita());
    		
    		if(!fc.getBeneficiarioMorte().equals(null))
    			targetPolizza.setBeneficiarioMorte(fc.getBeneficiarioMorte());
    		
    	}
    }
    
    private static void getDatiDettaglioAnagrafica(StampeServiceImpl service,
    		Polizza targetPolizza) throws PucException {
    	// Dettaglio Anagrafica
    	List<DettaglioAnagraficaVO> listaAnagrafica = null;
    	try {
    		listaAnagrafica = service
    				.listAnagraficheConBeneficiariByPolizza(new Long(targetPolizza
    						.getNumero()));
    	} catch (ServiceException_Exception e) {
    		throw new PucException(e);
    	}

    	if ((listaAnagrafica == null) || (listaAnagrafica.isEmpty()))
    		return;

    	for (DettaglioAnagraficaVO anagrafica : listaAnagrafica) {
    		Persona persona = new Persona();

    		if ("Banker".equals(anagrafica.getRuolo())) {
    			persona = new PrivateBanker();

    			if ("BFI".equals(targetPolizza.getReteVendita())) {
    				((PrivateBanker) persona)
    				.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
    			} else if ("SPI".equals(targetPolizza.getReteVendita())){
    				((PrivateBanker) persona)
    				.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
    			} else if ("ISPB".equals(targetPolizza.getReteVendita())) {
    				((PrivateBanker) persona)
    				.setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
    			} else if ("IWB".equals(targetPolizza.getReteVendita())) {
    				((PrivateBanker) persona)
    				.setReteVendita("IW SIM S.p.A.");
    			}
    		}

    		String denominazione;

    		denominazione = (anagrafica.getCognome() == null) ? ""
    				: anagrafica.getCognome().trim().toUpperCase();

    		denominazione += " "
    				+ ((anagrafica.getNome() == null) ? "" : anagrafica
    						.getNome().trim().toUpperCase());

    		denominazione += " "
    				+ ((anagrafica.getRagioneSociale() == null) ? ""
    						: anagrafica.getRagioneSociale().trim()
    						.toUpperCase());


    		persona.setDenominazione(denominazione.trim());
    		persona.setDataNascita(DateUtils.getNullSefeCalendar(anagrafica
    				.getDataNascita()));
    		persona.setSesso(StringUtils.blankString(anagrafica.getSesso()));

    		Indirizzo i = new Indirizzo();

    		i.setCap(StringUtils.blankString(anagrafica.getCap()));
    		i.setCitta(anagrafica.getComune() != null ? anagrafica
    				.getComune().toUpperCase() : "");
    		i.setProvincia(anagrafica.getProvincia() != null ? anagrafica
    				.getProvincia().toUpperCase() : "");
    		i.setVia(anagrafica.getIndirizzo() != null ? anagrafica
    				.getIndirizzo().toUpperCase() : "");

    		persona.setIndirizzo(i);

    		if ("PrimoAssicurato".equals(anagrafica.getRuolo())) {
    			targetPolizza.setAssicurato(persona);

    		} else if ("Contraente".equals(anagrafica.getRuolo())) {
    			targetPolizza.setContraente(persona);


    		} else if ("Banker".equals(anagrafica.getRuolo())) {
    			targetPolizza.setPrivateBanker((PrivateBanker) persona);
    		}
    	}


    }
    
    
    

	

}
