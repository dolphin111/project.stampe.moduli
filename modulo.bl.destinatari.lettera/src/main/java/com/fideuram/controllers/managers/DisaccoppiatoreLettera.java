package com.fideuram.controllers.managers;

import com.fideuram.attori.bo.IPersona;
import com.fideuram.attori.bo.impl.Altro;
import com.fideuram.attori.bo.impl.AreaManager;
import com.fideuram.attori.bo.impl.Contraente;
import com.fideuram.attori.bo.impl.DatoreLavoro;
import com.fideuram.attori.bo.impl.DivisionalManager;
import com.fideuram.attori.bo.impl.Indirizzo;
import com.fideuram.attori.bo.impl.PrimoAssicurato;
import com.fideuram.attori.bo.impl.PrivateBanker;
import com.fideuram.attori.bo.impl.RegionalManager;
import com.fideuram.controllers.DaoDestinatariLettera;
import com.fideuram.crm.vo.AnagraficaCRMVO;
import com.fideuram.crm.vo.ComunicazioneVO;
import com.fideuram.crm.vo.DomandaVO;
import com.fideuram.crm.vo.PolizzaVO;
import com.fideuram.exception.crm.DestinatariException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.puc.service.impl.DettaglioAnagraficaVO;
import com.fideuram.puc.service.impl.StampeServiceImpl;
import com.fideuram.utils.DateUtils;
import com.fideuram.utils.LoggingUtils;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Hashtable;
import java.util.List;

/**
 * Created by
 * User: logan
 * Date: 18/10/11
 * Time: 15.07
 */
public class DisaccoppiatoreLettera extends DaoDestinatariLettera {
    public static String RUOLO_PUC_BANKER = "Banker";
    public static String RUOLO_PUC_AREA_MANAGER = "Area Manager";
    public static String RUOLO_PUC_DIVISIONAL_MANAGER = "Divisional Manager";
    public static String RUOLO_PUC_REGIONAL_MANAGER = "Regional Manager";
    public static String RUOLO_PUC_CONTRAENTE = "Contraente";
    public static String RUOLO_PUC_ALTRO = "altro";
	public static String RUOLO_PUC_CONTRAENTE_DATORELAVORO = "Datore Lavoro";
	public static String RUOLO_PUC_PRIMOASSICURATO = "PrimoAssicurato";
	public static String RUOLO_PUC_SECONDOASSICURATO = "SecondoAssicurato";
	public static String RUOLO_PUC_BENEFICIARIO = "Beneficiario";
	public static String RUOLO_PUC_LEGALERAPPRESENTANTE = "LegaleRappresentante";
	public static String TIPO_CONTRAENTE = "Contraente";
	public static String TIPO_PRIVATE_BANKER = "Private Banker";
    public static String TIPO_AREA_MANAGER = "Area Manager";
    public static String TIPO_DIVISIONAL_MANAGER = "Divisional Manager";
    public static String TIPO_REGIONAL_MANAGER = "Regional Manager";
	public static String TIPO_MANAGER_DI_RETE = "Manager di Rete";
	public static String TIPO_DATORE_LAVORO = "Datore Lavoro";
	public static String TIPO_ADERENTE = "Aderente";
	public static String TIPO_ASSICURATO = "Assicurato";
	public static String TIPO_ALTRO = "altro";

    private ComunicazioneVO comunicazioneVO=null;
    private PolizzaVO       polizzaVO=null;        //è se sempre la comunicazioneVO.getDomande().get(0).getPolizze().get(0)
    private Hashtable       anagrafiche;


    public DisaccoppiatoreLettera(StampeServiceImpl pucS) throws WebServiceClientException {
          super(pucS);
          this.pucS=pucS;
    }


    public IPersona getPrivateBankerByPolizza(PolizzaVO polizzaVO) throws DestinatariException {
        PrivateBanker pb = (PrivateBanker) getCUstomObjectPersona(TIPO_PRIVATE_BANKER,polizzaVO);
        DettaglioAnagraficaVO _davo = (DettaglioAnagraficaVO) getAnagrafica(TIPO_PRIVATE_BANKER, polizzaVO);
        if((_davo!=null)&&(_davo.getStatoBanker()!=null)){
            if((!_davo.getStatoBanker().trim().equalsIgnoreCase("T"))||(!_davo.getStatoBanker().trim().equalsIgnoreCase("TEMINATO"))){
                pb = (PrivateBanker) beanUtils(pb, _davo);
            }
        }else{
            _davo =getPagliaccio();
            _davo.setIsPersonaFisicaGiuridica(true);
            pb = (PrivateBanker) beanUtils(pb, _davo);
        }
        return pb;
    }


    public IPersona getContraenteByPolizza(PolizzaVO polizzaVO) throws DestinatariException {
        Contraente contraente = (Contraente) beanUtils(new Contraente(), (DettaglioAnagraficaVO) getAnagrafica(TIPO_CONTRAENTE, polizzaVO));
        return contraente;
    }

    public IPersona getProponenteByComunicazione(ComunicazioneVO comunicazioneVO) throws DestinatariException {
        configura(comunicazioneVO);
        IPersona proponente = null;

        proponente = getCUstomObjectPersona(comunicazioneVO.getProponente().getTipoAnagrafica().getDescrizione(), polizzaVO);      //p può essere  null (caso reclami senza polizza)

        if ((comunicazioneVO.getProponente().getCodiceFiscale() == null) || (comunicazioneVO.getPolizze()==null))
        {
            //questo scenario significa che il proponente non censito nel PUC
            //ma si è cesito onLine con l'operatore CRM... probabilmente è "ALTRO"

            //....altra cosa: se la polizza è null si dovrebbe trattare di uno dei famiggerati casi di Reclamo senza Polizza
            try{
            proponente = beanUtils(proponente, comunicazioneVO.getProponente());
            }catch (Exception e){
                throw new DestinatariException(e.getMessage());
            }
           // comunicazioneVO.getIndirizzoLettera();
        } else {
            if (proponente instanceof PrivateBanker) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di PrivateBanker per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_PRIVATE_BANKER, polizzaVO));
            }
            if (proponente instanceof AreaManager) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di AreaManager per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_AREA_MANAGER, polizzaVO));
            }
            if (proponente instanceof DivisionalManager) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di DivisionalManager per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_DIVISIONAL_MANAGER, polizzaVO));
            }
            if (proponente instanceof RegionalManager) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di RegionalManager per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_REGIONAL_MANAGER, polizzaVO));
            }
            if (proponente instanceof Contraente) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di Contraente per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_CONTRAENTE, polizzaVO));
            }
            if (proponente instanceof DatoreLavoro) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di DatoreLavoro per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_DATORE_LAVORO, polizzaVO));
            }
            if (proponente instanceof PrimoAssicurato) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di PrimoAssicurato per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
                beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_ASSICURATO, polizzaVO));
            }
            if (proponente instanceof Altro) {
            	LoggingUtils.info("Proponente [" + comunicazioneVO.getProponente().getCodiceFiscale() + "] e' un'istanza di Altro per la polizza [" + polizzaVO.getNumeroPolizza() + "]");
            	beanUtils(proponente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_ALTRO, polizzaVO));
            }

        }
        
        //LoggingUtils.info("Proponente indirizzo (prima del modificato): " + (proponente.getIndirizzo() == null ? "null": proponente.getIndirizzo().toString()) );
        
        if ( (comunicazioneVO.getIndirizzoLettera() !=null )&& (comunicazioneVO.getIndirizzoLettera().isIndirizzoModificato() == true)) {
            Indirizzo i = new Indirizzo();
            i.setVia(comunicazioneVO.getIndirizzoLettera().getIndirizzo());
            i.setCitta(comunicazioneVO.getIndirizzoLettera().getComune());
            i.setProvincia(comunicazioneVO.getIndirizzoLettera().getProvincia());
            i.setCap(comunicazioneVO.getIndirizzoLettera().getCap());
            i.setModificato(true);
            proponente.setIndirizzo(i);
        }
        
        //LoggingUtils.info("Proponente indirizzo (dopo il modificato): " + (proponente.getIndirizzo() == null ? "null": proponente.getIndirizzo().toString()) );

        LoggingUtils.info("COMID >>>>> " + comunicazioneVO.getID());
        LoggingUtils.info("PROPONENTE >>>>> " + comunicazioneVO.getProponente().getTipoAnagrafica().getDescrizione());
        LoggingUtils.info("PROPONENTE >>>>> " + proponente.getDenominazione());
        return proponente;
    }

    public IPersona getRichiedenteByComunicazioneDomanda(ComunicazioneVO comunicazioneVO, DomandaVO domandaVO) throws DestinatariException {
        IPersona richiedente = null;

        if (isReclamo(comunicazioneVO)) {
            LoggingUtils.info("IS RECLAMANTE >>>>> " + domandaVO.getReclamante().getTipoAnagrafica().getDescrizione());
            richiedente = getCUstomObjectPersona(domandaVO.getReclamante().getTipoAnagrafica().getDescrizione(), polizzaVO);
            //cf =domandaVO.getCodiceFiscaleReclamante();
        } else {
            LoggingUtils.info("IS RICHIEDENTE >>>>> " + domandaVO.getRichiedente().getTipoAnagrafica().getDescrizione());
            richiedente = getCUstomObjectPersona(domandaVO.getRichiedente().getTipoAnagrafica().getDescrizione(), polizzaVO);
            //cf =domandaVO.getCodiceFiscaleRichiedente();
        }
        LoggingUtils.info("COMID >>>>> " + comunicazioneVO.getID());
        //PolizzaVO p = comunicazioneVO.getDomande().get(0).getPolizze().get(0);
        if (richiedente instanceof PrivateBanker) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di PrivateBanker per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_PRIVATE_BANKER, polizzaVO));
        }
        else if (richiedente instanceof AreaManager) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di AreaManager per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_AREA_MANAGER, polizzaVO));
        }
        else if (richiedente instanceof DivisionalManager) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di DivisionalManager per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_DIVISIONAL_MANAGER, polizzaVO));
        }
        else if (richiedente instanceof RegionalManager) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di RegionalManager per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_REGIONAL_MANAGER, polizzaVO));
        }
        else if (richiedente instanceof Contraente) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di Contraente per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_CONTRAENTE, polizzaVO));
        }
        else if (richiedente instanceof DatoreLavoro) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di DatoreLavoro per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_DATORE_LAVORO, polizzaVO));
        }
        else if (richiedente instanceof PrimoAssicurato) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di PrimoAssicurato per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_ASSICURATO, polizzaVO));
        }
        else if (richiedente instanceof Altro) {
        	if (!isReclamo(comunicazioneVO)) {
        		LoggingUtils.info("Richiedente [" + (domandaVO.getRichiedente().getCodiceFiscale() == null ? "null" : domandaVO.getRichiedente().getCodiceFiscale()) + "] e' un'istanza di Altro per la polizza [" + ( polizzaVO == null ? "Domanda generica senza polizza" : polizzaVO.getNumeroPolizza() ) + "]");
        	}
        	//richiedente = beanUtils(richiedente, (DettaglioAnagraficaVO) getAnagrafica(TIPO_ALTRO, p));
            try {
                if (isReclamo(comunicazioneVO)) {
                    richiedente = beanUtils(richiedente, domandaVO.getReclamante());
                } else {
                    richiedente = beanUtils(richiedente, domandaVO.getRichiedente());
                }
            } catch (Exception e) {
                throw new DestinatariException(e.getMessage());
            }
        }
        
        //LoggingUtils.info("Richiedente indirizzo: " + (richiedente.getIndirizzo() == null ? "null" : richiedente.getIndirizzo().toString()) );

        LoggingUtils.info("RICHIEDENTE >>>>> " + richiedente.getDenominazione());
        return richiedente;
    }

    /**
     * Questo metodo restituisce la specifica implementazione dell'oggetto IPersona
     *
     * @param tipo
     * @return una fra le seguenti 3 implementazioni di IPersona:  PrivateBanker,  Contraente, Altro
     */
    private IPersona getCUstomObjectPersona(String tipo, PolizzaVO polizzaVO) throws DestinatariException {
         if (TIPO_PRIVATE_BANKER.equalsIgnoreCase(tipo)||TIPO_MANAGER_DI_RETE.equalsIgnoreCase(tipo)) {
            PrivateBanker pb = new PrivateBanker();
            if(polizzaVO!=null){
               return setRete(pb, polizzaVO);
            }else{
               return pb;
            }
        } else if (TIPO_AREA_MANAGER.equalsIgnoreCase(tipo)) {
            AreaManager am = new AreaManager();
            if(polizzaVO!=null){
               return setRete(am, polizzaVO);
            }else{
               return am;
            }
        } else if (TIPO_DIVISIONAL_MANAGER.equalsIgnoreCase(tipo)) {
            DivisionalManager dm = new DivisionalManager();
            if(polizzaVO!=null){
               return setRete(dm, polizzaVO);
            }else{
               return dm;
            }
        } else if (TIPO_REGIONAL_MANAGER.equalsIgnoreCase(tipo)) {
            RegionalManager rm = new RegionalManager();
            if(polizzaVO!=null){
               return setRete(rm, polizzaVO);
            }else{
               return rm;
            }
        } else if (TIPO_CONTRAENTE.equalsIgnoreCase(tipo)) {
            return new Contraente();
        } else if (TIPO_ADERENTE.equalsIgnoreCase(tipo)) {
            return new Contraente();
        } else if (TIPO_DATORE_LAVORO.equalsIgnoreCase(tipo)) {
            return new DatoreLavoro();
        } else if (TIPO_ASSICURATO.equalsIgnoreCase(tipo)) {
            return new PrimoAssicurato();
        } else if (tipo != null) {
            return new Altro();
        }
        return null;
    }


    /**
     * @param persona
     * @param _anagrafica
     * @return
     */
    private IPersona beanUtils(IPersona persona, DettaglioAnagraficaVO _anagrafica) throws DestinatariException {
        try{
            if((_anagrafica.isIsPersonaFisicaGiuridica()==null)||(_anagrafica.isIsPersonaFisicaGiuridica()))
                persona.setDenominazione(_anagrafica.getCognome(), _anagrafica.getNome());
            else
                persona.setDenominazione(_anagrafica.getRagioneSociale(),"");
            persona.setIndirizzo(_anagrafica.getIndirizzo(),                                   //INDIRIZZO
                    _anagrafica.getComune(),
                    _anagrafica.getCap(),
                    _anagrafica.getProvincia());
            if (_anagrafica.getDataNascita() != null) {
                persona.setDataNascita(DateUtils.getNullSefeCalendar(_anagrafica.getDataNascita()));
            }
            if (_anagrafica.getSesso() != null) {
                persona.setSesso(_anagrafica.getSesso());
            }
        }catch(Exception e){
            throw new DestinatariException("ERRORE da <DETTAGLIO ANAGRAFICA BY POLIZZA (PUC)> \n\n NOME ATTORE: " + _anagrafica.getCognome() +"\n INDIRIZZO: "+_anagrafica.getIndirizzo());
        }
        return persona;
    }

    /**
     * Si usa solamente per i casi di cambio indirizzo. Questo caso arriva direttamente dal CRM ed usa un altro vo:AnagraficaDomandaVO
     *
     *
     * @param persona
     * @param _anagrafica
     * @return
     */
    private IPersona beanUtils(IPersona persona, AnagraficaCRMVO _anagrafica) throws Exception {
        persona.setDenominazione(_anagrafica.getCognome(), _anagrafica.getNome());         //NOMINATIVO
        
        try{
            persona.setIndirizzo(_anagrafica.getIndirizzo(),                                   //INDIRIZZO
                    _anagrafica.getComune(),
                    _anagrafica.getCap(),
                    _anagrafica.getProvincia().getSigla());
            persona.setSesso(_anagrafica.getSesso());
        }catch(Exception e){
            throw new Exception("ERRORE da <ANAGRAFICA CRM> \n\n NOME ATTORE: " + _anagrafica.getCognome() +"\n INDIRIZZO: "+_anagrafica.getIndirizzo() +"\n TIPO ATTORE "+ _anagrafica.getTipoAnagrafica().getDescrizione());
        }
        return persona;
    }



    public boolean isReclamo(ComunicazioneVO comunicazioneVO) {
        String codiceComunicazione =   comunicazioneVO.getTipo().getCodice();
        if((codiceComunicazione.equalsIgnoreCase("8"))||
           (codiceComunicazione.equalsIgnoreCase("2"))||
           (codiceComunicazione.equalsIgnoreCase("9"))||
           (codiceComunicazione.equalsIgnoreCase("A"))||
           (codiceComunicazione.equalsIgnoreCase("CL"))||
           (codiceComunicazione.equalsIgnoreCase("SCL"))) {
            return true;
        }
        return false;
    }

    private PrivateBanker setRete(PrivateBanker pb, PolizzaVO polizzaVO) throws DestinatariException {
        com.fideuram.puc.service.impl.PolizzaVO _ccc = getPolizzaVO(polizzaVO.getNumeroPolizza());
        if ("BFI".equals(_ccc.getRete())) {
            //pb.setReteVendita(isReclamo(comunicazioneVO)?"FIDEURAM S.p.A.":"BANCA FIDEURAM S.p.A.");
            pb.setReteVendita(isReclamo(comunicazioneVO)?"Fideuram - Intesa Sanpaolo Private Banking":"BANCA FIDEURAM S.p.a");
        } else if ("SPI".equals(_ccc.getRete())) {
            pb.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("ISPB".equals(_ccc.getRete())) {
            pb.setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
        } else if ("IWB".equals(_ccc.getRete())) {
        	pb.setReteVendita("IW SIM S.p.A.");
        }
        
        return pb;
    }
    
    private AreaManager setRete(AreaManager am, PolizzaVO polizzaVO) throws DestinatariException {
        com.fideuram.puc.service.impl.PolizzaVO _ccc = getPolizzaVO(polizzaVO.getNumeroPolizza());
        if ("BFI".equals(_ccc.getRete())) {
            am.setReteVendita(isReclamo(comunicazioneVO)?"Fideuram - Intesa Sanpaolo Private Banking":"Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("SPI".equals(_ccc.getRete())) {
            am.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("ISPB".equals(_ccc.getRete())) {
            am.setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
        } else if ("IWB".equals(_ccc.getRete())) {
        	am.setReteVendita("IW SIM S.p.A.");
        }
        return am;
    }
    
    private DivisionalManager setRete(DivisionalManager dm, PolizzaVO polizzaVO) throws DestinatariException {
        com.fideuram.puc.service.impl.PolizzaVO _ccc = getPolizzaVO(polizzaVO.getNumeroPolizza());
        if ("BFI".equals(_ccc.getRete())) {
            dm.setReteVendita(isReclamo(comunicazioneVO)?"Fideuram - Intesa Sanpaolo Private Banking":"Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("SPI".equals(_ccc.getRete())) {
            dm.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("ISPB".equals(_ccc.getRete())) {
            dm.setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
        } else if ("IWB".equals(_ccc.getRete())) {
        	dm.setReteVendita("IW SIM S.p.A.");
        }
        return dm;
    }
    
    private RegionalManager setRete(RegionalManager rm, PolizzaVO polizzaVO) throws DestinatariException {
        com.fideuram.puc.service.impl.PolizzaVO _ccc = getPolizzaVO(polizzaVO.getNumeroPolizza());
        if ("BFI".equals(_ccc.getRete())) {
            rm.setReteVendita(isReclamo(comunicazioneVO)?"Fideuram - Intesa Sanpaolo Private Banking":"Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("SPI".equals(_ccc.getRete())) {
            rm.setReteVendita("Fideuram - Intesa Sanpaolo Private Banking");
        } else if ("ISPB".equals(_ccc.getRete())) {
            rm.setReteVendita("Intesa Sanpaolo Private Banking S.p.A.");
        } else if ("IWB".equals(_ccc.getRete())) {
        	rm.setReteVendita("IW SIM S.p.A.");
        }
        return rm;
    }

    /**
     * Questo metodo carica l'HASH delle anagrafiche con tutti gli attori   <br>
     * provenienti da pucS.listAnagraficheByPolizza
     * @param polizzaVO
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void setAnagrafica(PolizzaVO polizzaVO) throws DestinatariException {
        if(polizzaVO!=null){
            List<DettaglioAnagraficaVO> _voS = null;

            if (anagrafiche == null) {

                anagrafiche = new Hashtable();
                _voS = getAnagrafichePolizza(polizzaVO.getNumeroPolizza());
                
                DettaglioAnagraficaVO vo;
                for (int i = 0; i < _voS.size(); i++) {
                    vo = _voS.get(i);
                    if (RUOLO_PUC_CONTRAENTE.equals(vo.getRuolo())) {
                        anagrafiche.put(TIPO_CONTRAENTE, vo);
                        LoggingUtils.info("Trovato CONTRAENTE --> " + vo.getCognome() + " (CF-PIVA = [" + vo.getCodiceFiscale() + "])");
                    } else if (RUOLO_PUC_BANKER.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_PRIVATE_BANKER, vo);
                        LoggingUtils.info("Trovato PRIVATE BANKER --> " + vo.getCognome() + " (CF-PIVA = [" + vo.getCodiceFiscale() + "])");
                    } else if (RUOLO_PUC_AREA_MANAGER.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_AREA_MANAGER, vo);
                        LoggingUtils.info("Trovato AREA MANAGER --> " + vo.getCognome() + " (CF-PIVA = [" + vo.getCodiceFiscale() + "])");
                    } else if (RUOLO_PUC_DIVISIONAL_MANAGER.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_DIVISIONAL_MANAGER, vo);
                        LoggingUtils.info("Trovato DIVISIONAL MANAGER --> " + vo.getCognome() + " (CF-PIVA = [" + vo.getCodiceFiscale() + "])");
                    } else if (RUOLO_PUC_REGIONAL_MANAGER.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_REGIONAL_MANAGER, vo);
                        LoggingUtils.info("Trovato REGIONAL MANAGER --> " + vo.getCognome() + " (CF-PIVA = [" + vo.getCodiceFiscale() + "])");
                    } else if (RUOLO_PUC_CONTRAENTE_DATORELAVORO.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_DATORE_LAVORO, vo);
                        LoggingUtils.info("Trovato DATORE LAVORO --> " + (vo.getCognome() == null ? vo.getRagioneSociale() : vo.getCognome()) + " (CF-PIVA = [" + (vo.getCodiceFiscale() == null ? vo.getPartitaIva() : vo.getCodiceFiscale()) + "])");
                    } else if (RUOLO_PUC_PRIMOASSICURATO.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_ASSICURATO, vo);
                        LoggingUtils.info("Trovato PRIMO ASSICURATO --> " + vo.getCognome() + " (CF-PIVA = [" + (vo.getCodiceFiscale() == null ? vo.getPartitaIva() : vo.getCodiceFiscale()) + "])");
                    } else if (RUOLO_PUC_SECONDOASSICURATO.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_ALTRO, vo);
                        LoggingUtils.info("Trovato ALTRO/SECONDO ASSICURATO --> " + vo.getCognome() + " (CF-PIVA = [" + (vo.getCodiceFiscale() == null ? vo.getPartitaIva() : vo.getCodiceFiscale()) + "])");
                    } else if (RUOLO_PUC_BENEFICIARIO.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_ALTRO, vo);
                        LoggingUtils.info("Trovato ALTRO/BENEFICIARIO --> " + vo.getCognome() + " (CF-PIVA = [" + (vo.getCodiceFiscale() == null ? vo.getPartitaIva() : vo.getCodiceFiscale()) + "])");
                    } else if (RUOLO_PUC_LEGALERAPPRESENTANTE.equalsIgnoreCase(vo.getRuolo())) {
                        anagrafiche.put(TIPO_ALTRO, vo);
                        LoggingUtils.info("Trovato ALTRO/LEGALE RAPPRESENTANTE --> " + vo.getCognome() + " (CF-PIVA = [" + (vo.getCodiceFiscale() == null ? vo.getPartitaIva() : vo.getCodiceFiscale()) + "])");
                    } else {
                        anagrafiche.put(TIPO_ALTRO, vo);
                        LoggingUtils.info("Trovato ALTRO --> " + vo.getCognome() + " (CF-PIVA = [" + (vo.getCodiceFiscale() == null ? vo.getPartitaIva() : vo.getCodiceFiscale()) + "])");

                    }
                }
            }
        }else{
            setAnagraficaSenzaPolizza();
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void setAnagraficaSenzaPolizza() throws DestinatariException {
        if (comunicazioneVO == null)
            throw new DestinatariException("Errore ComunicazioneVO null in setAnagraficaSenzaPolizza");
       
        if (anagrafiche == null) {
            anagrafiche = new Hashtable();
            try {
                DettaglioAnagraficaVO pucvo=new DettaglioAnagraficaVO();
                String _tipo=null;
                if (isReclamo(comunicazioneVO)) {
                    _tipo = comunicazioneVO.getDomande().get(0).getReclamante().getTipoAnagrafica().getDescrizione();
                    BeanUtils.copyProperties(pucvo, comunicazioneVO.getDomande().get(0).getReclamante());
                } else {
                    //quì in teoria mi aspetto che nn ci entri mai...
                    _tipo = comunicazioneVO.getDomande().get(0).getRichiedente().getTipoAnagrafica().getDescrizione();
                    BeanUtils.copyProperties(pucvo, comunicazioneVO.getDomande().get(0).getRichiedente());
                    //todo verificare se BeanUtils recupera correttamente la provincia
                }
                if(TIPO_PRIVATE_BANKER.equalsIgnoreCase(_tipo)){
                    anagrafiche.put(TIPO_PRIVATE_BANKER,pucvo);
                    LoggingUtils.info("setAnagraficaSenzaPolizza --> Caricamento di PRIVATE_BANKER --> "+pucvo.getCognome());
                } else if(TIPO_CONTRAENTE.equalsIgnoreCase(_tipo)){
                    anagrafiche.put(TIPO_CONTRAENTE,pucvo);
                    LoggingUtils.info("setAnagraficaSenzaPolizza --> Caricamento di CONTRAENTE --> "+pucvo.getCognome());
                } else {
                    anagrafiche.put(TIPO_ALTRO, pucvo);
                    LoggingUtils.info("setAnagraficaSenzaPolizza --> Caricamento di ALTRO --> "+pucvo.getCognome());
                }

            } catch (IllegalAccessException e) {
                throw new DestinatariException("Errore nel Travaso del Bean di anagrafica di crm verso DettaglioAnagraficaVO del puc" + e.getMessage());
            } catch (InvocationTargetException e) {
                throw new DestinatariException("Errore nel Travaso del Bean di anagrafica di crm verso DettaglioAnagraficaVO del puc" + e.getMessage());
            }
        }
    }

    private DettaglioAnagraficaVO getAnagrafica(String ruolo, PolizzaVO polizzaVO) throws DestinatariException {
    	
        if (anagrafiche == null) {
            setAnagrafica(polizzaVO);
        }
        if (anagrafiche.containsKey(ruolo)) {
            return (DettaglioAnagraficaVO) anagrafiche.get(ruolo);
        } else {
            // throw new CrmException("Errore RUOLO non trovato" + ruolo);
            LoggingUtils.debug("Private Banker Nn trovato e allora inserisco il مهرج");
            return getPagliaccio();
        }
    }

    private void configura(ComunicazioneVO comunicazioneVO){
        this.comunicazioneVO  = comunicazioneVO;
        if((comunicazioneVO.getDomande().get(0).getPolizze()!=null)&&
          (comunicazioneVO.getDomande().get(0).getPolizze().size()>0)){
            polizzaVO = comunicazioneVO.getDomande().get(0).getPolizze().get(0);
        }
    }

    /**
     * Restituisce un oggetto vuoto le cui proprietà sono tutte !null
     * viene invocato solo nel caso in cui non si trovano i dati del PB
     * @deprecated
     * @return
     */
    private DettaglioAnagraficaVO getPagliaccio(){
        DettaglioAnagraficaVO _voPagliaccio =  new DettaglioAnagraficaVO();
            _voPagliaccio.setCodiceFiscale("");
            _voPagliaccio.setCognome("");
            _voPagliaccio.setNome("");
            _voPagliaccio.setNazione("");
            _voPagliaccio.setPartitaIva("");
            _voPagliaccio.setIndirizzo("");
            _voPagliaccio.setCap("");
            _voPagliaccio.setComune("");
            _voPagliaccio.setProvincia("");
            _voPagliaccio.setRuolo("");
            _voPagliaccio.setSesso("");

        return _voPagliaccio;
    }

}
