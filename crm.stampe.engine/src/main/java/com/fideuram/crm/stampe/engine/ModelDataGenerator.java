/**
 *
 */
package com.fideuram.crm.stampe.engine;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.fideuram.attori.bo.impl.Destinatari;
import com.fideuram.controllers.DestinatariLettera;
import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.converters.PolizzaBuilder;
import com.fideuram.crm.stampe.exception.StampeInfoException;
import com.fideuram.crm.stampe.generatori.DescrizioniAssemblate;
import com.fideuram.crm.stampe.interfacce.IComunicazioneDatiInputManager;
import com.fideuram.crm.stampe.lettere.DescrizioniComuni;
import com.fideuram.crm.stampe.lettere.LetteraAvvisiScadenza;
import com.fideuram.crm.stampe.lettere.LetteraAvvisiScadenzaPA;
import com.fideuram.crm.stampe.lettere.LetteraCaricamentiCPP;
import com.fideuram.crm.stampe.lettere.LetteraConversioneInRendita;
import com.fideuram.crm.stampe.lettere.LetteraCreditLine;
import com.fideuram.crm.stampe.lettere.LetteraDecumulo;
import com.fideuram.crm.stampe.lettere.LetteraDettaglioPratiche;
import com.fideuram.crm.stampe.lettere.LetteraDisponibilita;
import com.fideuram.crm.stampe.lettere.LetteraEccedenza;
import com.fideuram.crm.stampe.lettere.LetteraGenerica;
import com.fideuram.crm.stampe.lettere.LetteraLiquidazioniSPI;
import com.fideuram.crm.stampe.lettere.LetteraMassimoValoreUL;
import com.fideuram.crm.stampe.lettere.LetteraOpzioneAnticipata;
import com.fideuram.crm.stampe.lettere.LetteraOpzioneCambioFrazionamento;
import com.fideuram.crm.stampe.lettere.LetteraOpzioneCertezza;
import com.fideuram.crm.stampe.lettere.LetteraOpzioneProroga;
import com.fideuram.crm.stampe.lettere.LetteraOpzioneRamo3;
import com.fideuram.crm.stampe.lettere.LetteraOpzioneReversibilita;
import com.fideuram.crm.stampe.lettere.LetteraPraticheLegali;
import com.fideuram.crm.stampe.lettere.LetteraPraticheLegaliAccertamento;
import com.fideuram.crm.stampe.lettere.LetteraPraticheLegaliAccessi;
import com.fideuram.crm.stampe.lettere.LetteraPraticheLegaliDissequestro;
import com.fideuram.crm.stampe.lettere.LetteraPraticheLegaliPignoramentoAE;
import com.fideuram.crm.stampe.lettere.LetteraPraticheLegaliPignoramentoPrivato;
import com.fideuram.crm.stampe.lettere.LetteraPremiPagati;
import com.fideuram.crm.stampe.lettere.LetteraPrestazioniAssicurate;
import com.fideuram.crm.stampe.lettere.LetteraPreventivoConversioneRendita;
import com.fideuram.crm.stampe.lettere.LetteraPrevidenza;
import com.fideuram.crm.stampe.lettere.LetteraRiduzione;
import com.fideuram.crm.stampe.lettere.LetteraRiscattoAnticipato;
import com.fideuram.crm.stampe.lettere.LetteraRiscattoAnticipatoAl;
import com.fideuram.crm.stampe.lettere.LetteraRiscattoParzialePuntuale;
import com.fideuram.crm.stampe.lettere.LetteraRiscattoParzialeTendenza;
import com.fideuram.crm.stampe.lettere.LetteraRiscattoTermine;
import com.fideuram.crm.stampe.lettere.LetteraSimulatoreFPA;
import com.fideuram.crm.stampe.lettere.LetteraSimulazioniSPI;
import com.fideuram.crm.stampe.lettere.LetteraSinistro;
import com.fideuram.crm.stampe.lettere.LetteraSpiegazioneConteggi_R_3;
import com.fideuram.crm.stampe.lettere.LetteraSpiegazioneConteggi_R_I;
import com.fideuram.crm.stampe.lettere.RischiComuni;
import com.fideuram.crm.stampe.manager.FactoryManagers;
import com.fideuram.crm.stampe.model.Contraente;
import com.fideuram.crm.stampe.model.Indirizzo;
import com.fideuram.crm.stampe.model.Lettera;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.crm.stampe.model.Persona;
import com.fideuram.crm.stampe.model.Polizza;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.PolizzaVO;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.ws.CrmException;
import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.PucException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.stampe.cache.ClientWs;
import com.fideuram.stampe.dao.DaoException;
import com.fideuram.stampe.dao.tronconi.TronconiManagaer;
import com.fideuram.stampe.domande.ControllerDiPolizza;
import com.fideuram.stampe.domande.DomandaException;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.puc.service.impl.StampeServiceImpl;

/**
 * @author Giorgio Desideri
 *
 */
public class ModelDataGenerator {

	private Modello modello = null;

	private InputDataModel input = null;

	/**
	 * Costruttore
     * @param input
     */
	public ModelDataGenerator(InputDataModel input) {
		this.input = input;
	}
  	/**
	 * Crea il modello della lettera, con tutti i dati relativi.
	 * @return modello
	 * @throws CrmStampeException
	 */
	public Modello createModelloLettera() throws StampeInfoException,
            WebServiceClientException,
            DomandaException,
            DestinatariException, PucException, UniversoException, CrmException, DaoException {                                               {
		// Domanda
 		DomandaVO domanda = input.getDomanda();
        String tipocomunicazione=   input.getComunicazione().getTipo().getCodice();
        
        //todo verificare questa regola
        if(domanda.getPolizze().size()==0){
         if (!(tipocomunicazione.equals("1")) &&
             !(tipocomunicazione.equals("2")) &&
             !(tipocomunicazione.equals("8")) &&
             !(tipocomunicazione.equals("9")) &&
             !(tipocomunicazione.equals("A"))) {
            throw new StampeInfoException("La domanda: " + domanda.getID() + " non contiene Polizze" );
         }
        }

		// ComunicazioneVO comunicazione = input.getComunicazione();
		modello = new Modello();

		List<Polizza> listaPolizze = new ArrayList<Polizza>();

		/** Multicontraenza **/
		
		List<Contraente> listaContraenti = new ArrayList<Contraente>();
		Map<String, List<Polizza>> divisionePerContraente = new HashMap<String, List<Polizza>>();
		
		/*********************/

        List<Polizza> tmp;

		// Scorro le polizze
		for (PolizzaVO polizza : domanda.getPolizze()) {
			LoggingUtils.debug("PER DOMANDA " +domanda.getID()+  " Inzio elaborazione polizza : "+ polizza.getNumeroPolizza());

            Polizza p=null;

            int idTemplate =input.getDomanda().getDescrizioneDomanda().getTemplate().getID();
                p = PolizzaBuilder.buildPolizza(
                        polizza.getNumeroPolizza(), true,
                        input.getTriplettaDomanda(),
                        input.getScenario(), idTemplate,tipocomunicazione, input.getDomanda(),input.getComunicazione().getID());
			if (p != null) {
				LoggingUtils.debug("OK. Polizza (" + polizza.getNumeroPolizza() + ") elaborata.");
				
				listaPolizze.add(p);

				/** Multicontraenza **/
				
				if(divisionePerContraente.get(p.getContraente().getDenominazione() + "_" + p.getContraente().getDataNascita()) == null)  {
                    tmp = new ArrayList<Polizza>();
				} else {
					tmp = divisionePerContraente.get(p.getContraente().getDenominazione() + "_" + p.getContraente().getDataNascita());
				}

                tmp.add(p);
				divisionePerContraente.put(p.getContraente().getDenominazione() + "_" + p.getContraente().getDataNascita(), tmp);
				
				/*********************/

				//for (TronconeVO t : domanda.getDescrizioneDomanda().getTemplate().getTronconi()) {
				//	p.addTroncone(t.getNomeTroncone(), t.getFrase());
				//}
                p.setTronconi(new TronconiManagaer().getMapTronconi(p.getProdotto(),domanda.getDescrizioneDomanda().getTemplate().getTronconi()));
			}
		}
		
		/** Multicontraenza **/
		
		for (Map.Entry<String, List<Polizza>> entry : divisionePerContraente.entrySet()) {
            
			Contraente c = new Contraente(entry.getValue().get(0).getContraente());
            if (domanda.getRichiedente() != null) {
				c.setCodiceFiscale(domanda.getRichiedente().getCodiceFiscale());
			}
			else if (domanda.getReclamante() != null) {
				c.setCodiceFiscale(domanda.getReclamante().getCodiceFiscale());
			}
			c.setPolizze(entry.getValue());
			listaContraenti.add(c);
		}
		
		modello.setContraenti(listaContraenti);
		
		/*********************/
		
		// Memorizzo l'elenco delle polizze costruite
		modello.setPolizze(listaPolizze);
        if(listaPolizze.size()==0||(listaPolizze.size()>0&&!listaPolizze.get(0).isCollettiva()))
            setDestinatariLettera(input.getComunicazione());
        else
            setDestinatariLetteraCollettive(listaPolizze.get(0),input.getComunicazione());

        if (!(tipocomunicazione.equals("2")) &&
            !(tipocomunicazione.equals("8")) &&
            !(tipocomunicazione.equals("9")) &&
            !(tipocomunicazione.equals("A"))) {
            // Init dei dati generali riguardanti le persone
            if(tipocomunicazione.equals("1")&&(domanda.getPolizze().size()==0)){
                setDatiGeneraliLetteraSenzaPolizza();
            }else {
                setDatiGeneraliLettera();
            }
            // Init dei dati relativi alla lettera specifica
		    setDatiLetteraSpecifica();
        } else{
            setDatiGeneraliLetteraReclamo();
        }
        
        if (tipocomunicazione.equals("CL") || tipocomunicazione.equals("SCL")) {
        	setDatiGeneraliLetteraReclamo();
        }

		LoggingUtils.debug("Fine creazione Modello");

		return modello;
	    }
    }

    /**
	 * Inizializzo all'interno del modello i dati riguardanti la lettera e le
	 * persone interessate (Contraente e Private Banker).
	 *
	 * @throws CrmStampeException
	 */
    private void setDatiGeneraliLetteraReclamo() {
        LoggingUtils.debug("inizio elaborazione dati generali (lettera Reclamo)");
		// Creazione della lettera
		Lettera lettera = new Lettera();
		//set del numero di comunicazione aggiunto per la lettera Reclamo
		String comunicazioneId = String.valueOf(input.getComunicazione().getID());
		lettera.setComunicazioneId(comunicazioneId);
        if(isWithPolizza(input.getComunicazione())){

            lettera.setCodaOggetto(modello.getPolizze().get(0).getNumero());
            lettera.setDenominazioneContraente(modello.getPolizze().get(0).getContraente().getDenominazione());
            if(modello.getPolizze().get(0).getDescrizioneFondoSintetica().equalsIgnoreCase("Previdenza")){
                lettera.setOggetto( "Posizione \"" + modello.getPolizze().get(0).getDescrizioneCommerciale().trim()+ "\" n. ");
                lettera.setEtichettaDenominazione("Aderente: ");
                lettera.setLetteraPrevidenza(true);
            }else{
                lettera.setOggetto( "Polizza \"" + modello.getPolizze().get(0).getDescrizioneCommerciale().trim()+ "\" n. ");
                lettera.setEtichettaDenominazione("Contraente: ");
            }
        }
        lettera.setDescrizioneDomanda(input.getDomanda().getDescrizioneDomanda().getDescrizione());
        lettera.setDataCreazione(DateUtils.formatDate(input.getComunicazione().getDataCreazione(),"dd/MM/yyyy"));
        lettera.setTipoProponente(DescrizioniAssemblate.getCapolettera(modello.getProponente()));
        
        if("M".equalsIgnoreCase(input.getDomanda().getReclamante().getSesso())) {
        	lettera.setTitoloReclamante("Gentile Signore");
        } else if("F".equalsIgnoreCase(input.getDomanda().getReclamante().getSesso())) {
        	lettera.setTitoloReclamante("Gentile Signora");
        } else {
        	lettera.setTitoloReclamante("Spettabile Società");
        }
        
        setDatiComuniLettera(lettera);
	}

	/**
	 * Inizializzo all'interno del modello i dati riguardanti la lettera e le
	 * persone interessate (Contraente e Private Banker).
	 *
	 * @throws CrmStampeException
	 */
    private void setDatiGeneraliLettera() {
		LoggingUtils.debug("inizio elaborazione dati generali (lettera)");

		// Creazione della lettera
		Lettera lettera = new Lettera();

		// Denominazione Contraente
		Persona contraente = modello.getPolizze().get(0).getContraente();
		lettera.setDenominazioneContraente(contraente.getDenominazione().toUpperCase());
        setDatiComuniLettera(lettera);
	}

    private void setDatiGeneraliLetteraSenzaPolizza(){
        LoggingUtils.debug("inizio elaborazione dati generali (lettera)");

        // Creazione della lettera
        Lettera lettera = new Lettera();

        lettera.setDenominazioneContraente(modello.getProponente().getDenominazione().toUpperCase());
        setDatiComuniLettera(lettera);
    }


    private void setDatiComuniLettera(Lettera lettera) {
        ComunicazioneVO comunicazione = input.getComunicazione();
        if (comunicazione.getNumeroProtocollo() != null
				&& !"".equals(comunicazione.getNumeroProtocollo())) {
			lettera.setProtocollo(comunicazione.getNumeroProtocollo());
			lettera.setLabelProtocollo("Prot. n.");

		} else {
			lettera.setProtocollo("");
			lettera.setLabelProtocollo("");
		}
        lettera.setData(DateUtils.formatDate(new Date(), Costanti.FORMATO_DATA));
        lettera.setCodiceIside("");
        lettera.setCitta("");
        lettera.setUtente(comunicazione.getAssegnatario().getSigla());
            if (modello.getProponente().getIndirizzo().isModificato()){
               lettera.setIndirizzoModificato(true);
            }
        modello.setLettera(lettera);
        LoggingUtils.debug("Fine elaborazione dati generali");
    }

	/**
	 * Inserisce nel modello i dati della lettera specifica, identificata dalla
	 * tripletta contenuta nella domanda.
	 *
	 */
	private void setDatiLetteraSpecifica() throws StampeInfoException,
            WebServiceClientException,
            DomandaException, UniversoException, PucException, CrmException, DaoException {
		ComunicazioneVO comunicazione = input.getComunicazione();
		DomandaVO domanda = input.getDomanda();
		String tripletta = input.getTriplettaDomanda();

		LoggingUtils.info("Inizio elaborazione dati specifici lettera ( "+ tripletta + " )");
		// Completamento polizza

		for (Polizza polizza : modello.getPolizze()) {
            new DescrizioniComuni(comunicazione.getID()).completaIntestazione(polizza, modello, comunicazione, domanda);
            int nuovaTripletta= domanda.getDescrizioneDomandaOriginaleId();

            //int codiceTemplate= CodificatoreTriplette.getCodiceTemplate(tripletta);
            switch (nuovaTripletta){
	            case 946:
	            	new LetteraDettaglioPratiche(comunicazione.getID()).completaPolizza(polizza,domanda, modello);
	            	break;
                case 88:  //VALORE PRESTITO
                case 913: //COMMISSIONI FONDI ESTERNI
                case 915: //RISCATTO TOTALE
                case 916: //RISCATTO PARZIALE
                case 951: //SCADENZA
                case 952: //SCADENZA PERIODICA
                case 953: //SINISTRO A SCADENZA
                case 1010: //RISCATTO PARZIALE
                   // new ControllerDiPolizza(comunicazione.getID()).configuraDomanda(nuovaTripletta,polizza);
                    new ControllerDiPolizza(comunicazione.getID()).configuraDomanda(domanda,polizza);
                    break;
                default:
                    if (Costanti.CODICE_LETTERA_GENERICA.equalsIgnoreCase(tripletta)) {
                        new LetteraGenerica(comunicazione.getID()).completaPolizza(comunicazione.getID(),polizza, true);
                    } else if (Costanti.CODICE_RISCHI_COMUNI.equalsIgnoreCase(tripletta)) {
                        new RischiComuni(comunicazione.getID()).completaPolizza(polizza, true);
                    } else if (Costanti.CODICE_PRESTAZIONI_ASSICURATE.equalsIgnoreCase(tripletta)) {
                        LetteraPrestazioniAssicurate.completaPolizza(polizza);
                    } else if (Costanti.CODICE_RISCATTO_ANTICIPATO.equalsIgnoreCase(tripletta)) {
                        new LetteraRiscattoAnticipato(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_RISCATTO_TERMINE.equalsIgnoreCase(tripletta)
                            || Costanti.CODICE_RISCATTO_TERMINE_PU_AGG.equalsIgnoreCase(tripletta)
                            || Costanti.CODICE_RISCATTO_TERMINE_AMPLIAMENTO.equalsIgnoreCase(tripletta)
                            || Costanti.CODICE_RISCATTO_TERMINE_RIATTIVAZIONE.equalsIgnoreCase(tripletta)){
                        new LetteraRiscattoTermine(comunicazione.getID()).completaPolizza(polizza, modello, comunicazione, domanda, true);
                    } else if (Costanti.CODICE_CONVERSIONE_RENDITA.equalsIgnoreCase(tripletta)) {
                        new LetteraConversioneInRendita(comunicazione.getID()).completaPolizza(polizza, domanda);
                    } else if (Costanti.CODICE_PREVENTIVO_CONVERSIONE_RENDITA.equalsIgnoreCase(tripletta)) {
                        new LetteraPreventivoConversioneRendita(comunicazione.getID()).completaPolizza(polizza, domanda);
                    } else if (Costanti.CODICE_RISCATTO_ANTICIPATO_AL.equalsIgnoreCase(tripletta)) {
                        new LetteraRiscattoAnticipatoAl(comunicazione.getID()).completaPolizza(polizza, domanda);
                    } else if (Costanti.CODICE_ECCEDENZA.equalsIgnoreCase(tripletta)) {
                        LetteraEccedenza.completaPolizza(polizza);
                    } else if (Costanti.CODICE_CARICAMENTI_CPP.equalsIgnoreCase(tripletta)) {
                        new LetteraCaricamentiCPP(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_SINISTRO.equalsIgnoreCase(tripletta)) {
                        LetteraSinistro.completaPolizza(polizza);
                    } else if (Costanti.CODICE_DISPONIBILITA.equalsIgnoreCase(tripletta)) {
                        LetteraDisponibilita.completaPolizza(polizza);
                    } else if (Costanti.CODICE_RIDUZIONE.equalsIgnoreCase(tripletta)) {
                        new LetteraRiduzione(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_PREMI_PAGATI.equalsIgnoreCase(tripletta)) {
                        new LetteraPremiPagati(comunicazione.getID()).completaPolizza(polizza,domanda);
                    } else if (Costanti.CODICE_SPIEGAZIONE_CONTEGGI.equalsIgnoreCase(tripletta)) {
                        new LetteraSpiegazioneConteggi_R_3(comunicazione.getID()).completaPolizza(polizza, modello,comunicazione, domanda, true);
                    } else if (Costanti.CODICE_OPZIONE_REVERSIBILITA.equalsIgnoreCase(tripletta)) {
                        new LetteraOpzioneReversibilita(comunicazione.getID()).completaPolizza(polizza, domanda);
                    } else if (Costanti.CODICE_OPZIONE_CERTEZZA.equalsIgnoreCase(tripletta)) {
                        new LetteraOpzioneCertezza(comunicazione.getID()).completaPolizza(polizza, domanda, true);
                    } else if (Costanti.CODICE_OPZIONE_PROROGA.equalsIgnoreCase(tripletta)) {
                        new LetteraOpzioneProroga(comunicazione.getID()).completaPolizza(polizza, domanda);
                    } else if (Costanti.CODICE_OPZIONE_CAMBIOFRAZ.equalsIgnoreCase(tripletta)) {
                        new LetteraOpzioneCambioFrazionamento(comunicazione.getID()).completaPolizza(polizza,domanda);
                    } else if (Costanti.CODICE_OPZIONE_ANTICIPATA.equalsIgnoreCase(tripletta)) {
                        new LetteraOpzioneAnticipata(comunicazione.getID()).completaPolizza(polizza, domanda);
                    } else if (Costanti.CODICE_LIQUIDAZIONI_SPI.equalsIgnoreCase(tripletta)) {
                        new LetteraLiquidazioniSPI(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_OPZIONE_REVERSIBILITA_SPI.equalsIgnoreCase(tripletta)) {
                        //todo per ora non fa nulla
                    } else if (Costanti.CODICE_RISCATTO_A_TERMINE_SPI.equalsIgnoreCase(tripletta)) {
                        new LetteraSimulazioniSPI(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_AVVISI_SCADENZA_SPI.equalsIgnoreCase(tripletta)) {
                        new LetteraAvvisiScadenza(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_AVVISI_SCADENZA_PA.equalsIgnoreCase(tripletta)) {
                        new LetteraAvvisiScadenzaPA(comunicazione.getID()).completaPolizza(polizza);
                    } else if (Costanti.CODICE_OPZIONE_RAMO_III.equalsIgnoreCase(tripletta)) {
                        IComunicazioneDatiInputManager inputs = FactoryManagers.getComunicazioneInputManager();
                        new LetteraOpzioneRamo3(comunicazione.getID()).completaPolizza(polizza, inputs.getOpzioniRamo3InputVO(domanda, Long.parseLong(polizza.getNumero())));
                    } else if(Costanti.CODICE_SPIEGAZIONE_CONTEGGI_R1.equalsIgnoreCase(tripletta)){
                        new LetteraSpiegazioneConteggi_R_I(comunicazione.getID()).completaPolizza(polizza, modello, comunicazione, domanda, true);
                    }else if(Costanti.CODICE_LETTERA_PREVIDENZA.equalsIgnoreCase(tripletta)){
                        LetteraPrevidenza.completaPolizza(polizza, modello, comunicazione, domanda, true);
                    }else if (Costanti.CODICE_RISCATTO_PARZIALE_TENDENZA.equalsIgnoreCase(tripletta)) {
                        new LetteraRiscattoParzialeTendenza(comunicazione.getID()).completaPolizza(polizza, domanda);
                    }else if(Costanti.CODICE_RISCATTO_PARZIALE_PUNTUALE.equalsIgnoreCase(tripletta)){
                        new LetteraRiscattoParzialePuntuale(comunicazione.getID()).completaPolizza(polizza, domanda);
                    }else if(Costanti.CODICE_DECUMULO.equalsIgnoreCase(tripletta)){
                        new LetteraDecumulo(comunicazione.getID()).completaPolizza(polizza, domanda);
                    }else if(Costanti.CODICE_DISPONIBILITA.equalsIgnoreCase(tripletta)){
                        LetteraDisponibilita.completaPolizza(polizza);
                    }else if(Costanti.CODICE_SIMULAZIONEFPA.equalsIgnoreCase(tripletta)){
                        new LetteraSimulatoreFPA(comunicazione.getID()).completaPolizza(polizza,domanda);
                    }else if(Costanti.CODICE_CREDIT_LINE.equalsIgnoreCase(tripletta)){
                        new LetteraCreditLine(comunicazione.getID()).completaPolizza(comunicazione.getID(),polizza, true);
                    }else if(Costanti.CODICE_MASSIMO_VALORE_UL.equalsIgnoreCase(tripletta)){
                        new LetteraMassimoValoreUL(comunicazione.getID()).completaPolizza(comunicazione.getID(),polizza,true);
                    }else if(Costanti.CODICE_PRATICHELEGALI_SEQUESTRO.equalsIgnoreCase(tripletta)){ 			// Sequestro
                        new LetteraPraticheLegali(comunicazione.getID()).completaPolizza(polizza, domanda, comunicazione);
                    }else if(Costanti.CODICE_PRATICHELEGALI_ACCERTAMENTO.equalsIgnoreCase(tripletta)){ 			// Accertamento
                        new LetteraPraticheLegaliAccertamento(comunicazione.getID()).completaPolizza(polizza, domanda, comunicazione);
                    }else if(Costanti.CODICE_PRATICHELEGALI_DISSEQUESTRO.equalsIgnoreCase(tripletta)){ 			// Dissequestro
                        new LetteraPraticheLegaliDissequestro(comunicazione.getID()).completaPolizza(polizza, domanda);
                    }else if(Costanti.CODICE_PRATICHELEGALI_PIGNORAMENTO_PRIVATO.equalsIgnoreCase(tripletta)){ 	// Pignoramento privato
                        new LetteraPraticheLegaliPignoramentoPrivato(comunicazione.getID()).completaPolizza(polizza, domanda, comunicazione);
                    }else if(Costanti.CODICE_PRATICHELEGALI_PIGNORAMENTO_AE.equalsIgnoreCase(tripletta)){ 		// Pignoramento AE
                        new LetteraPraticheLegaliPignoramentoAE(comunicazione.getID()).completaPolizza(polizza, domanda, comunicazione);
                    }else if(Costanti.CODICE_PRATICHELEGALI_ACCESSI.equalsIgnoreCase(tripletta)){ 				// Accessi
                        new LetteraPraticheLegaliAccessi(comunicazione.getID()).completaPolizza(polizza, domanda);
                    }
            }
		}

		LoggingUtils.info("Fine elaborazione dati specifici lettera ( "+ tripletta + " )");
	}

    private void setDestinatariLettera(ComunicazioneVO comunicazione) throws DestinatariException, WebServiceClientException {
        DestinatariLettera destinatariLettera = new DestinatariLettera(comunicazione, (StampeServiceImpl) new ClientWs().getPucClient(comunicazione.getID()));
        Destinatari destinatari= destinatariLettera.configuraDestinatari();
        modello.setProponente(destinatari.getProponente());
        if(destinatari.getRichiedente()!=null)
          modello.setRichiedente(destinatari.getRichiedente());
        if(destinatari.getPerConoscenza()!=null)
          modello.setAltro(destinatari.getPerConoscenza().get(0));
    }


    /**
     * Questo metodo è stato fatto per identificare i destinatari collettive la cui costrzione passa per logiche diverse
     * @param polizza
     * @throws DestinatariException
     * @throws WebServiceClientException
     */
    private void setDestinatariLetteraCollettive(Polizza polizza, ComunicazioneVO c) throws DestinatariException, WebServiceClientException {
        DestinatariLettera destinatariLettera = new DestinatariLettera((StampeServiceImpl) new ClientWs().getPucClient(c.getID()));
        Destinatari destinatari= destinatariLettera.configuraDestinatariCollettive(polizza.getNumero());
        modello.setProponente(destinatari.getProponente());
        Persona p = new Persona();
        Indirizzo i = new Indirizzo();
        try {
            BeanUtils.copyProperties(i,destinatari.getProponente().getIndirizzo());
        } catch (IllegalAccessException e) {
           LoggingUtils.error(e);
        } catch (InvocationTargetException e) {
           LoggingUtils.error(e);
        }
        p.setDenominazione(destinatari.getProponente().getDenominazione());
        p.setIndirizzo(i);
        polizza.setContraente(p);
        //todo eliminare le classi Persona e sue Eredi e Indirizzo sostituirle con quelle provenienti da destinatari lettera
    }


    private boolean isWithPolizza(ComunicazioneVO comunicazioneVO){
        return (comunicazioneVO.getDomande().get(0).getPolizze() != null) &&
                (comunicazioneVO.getDomande().get(0).getPolizze().size() > 0);
    }

}
