package com.fideuram.stampeservice.controller;

import com.fideuram.StatoServizi;
import com.fideuram.crm.stampe.engine.DecodificatoreRichieste;
import com.fideuram.crm.stampe.engine.FormatoRichiesto;
import com.fideuram.crm.stampe.engine.processi.IdentificatoreProcesso;
import com.fideuram.crm.stampe.engine.processi.ProcessoBase;
import com.fideuram.crm.stampe.engine.processi.avvisi.AvvisiScadenza;
import com.fideuram.crm.stampe.engine.processi.decumulo.Decumulo;
import com.fideuram.crm.stampe.engine.processi.opzioni.IpotesiOpzione;
import com.fideuram.crm.stampe.engine.processi.opzioni.ProcessOpzioni;
import com.fideuram.crm.stampe.engine.processi.riscatti.RiscattiRiduzioni;
import com.fideuram.crm.stampe.engine.processi.riscattoParzialeTendenza.RiscattoParzialeTendenza;
import com.fideuram.crm.stampe.engine.processi.scadenzaPremi.AvvisiScadenzaPremi;
import com.fideuram.crm.stampe.engine.processi.simulazioniSpi.SimulazioniSPI;
import com.fideuram.crm.stampe.engine.processi.spiegazioneConteggiLiqSPI.SpiegazioneConteggiLiquidazioneSPI;
import com.fideuram.crm.stampe.engine.processi.statoPratica.StatoPratica;
import com.fideuram.dao.PucDao;
import com.fideuram.decoder.MapperProcessiCrm;
import com.fideuram.exception.AssetException;
import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.facade.AssetFacade;
import com.fideuram.facade.DisplayPolizzaFacade;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.modello.xml.XmlPolizzaConverter;
import com.fideuram.processo.FacadeCredenziali;
import com.fideuram.puc.service.impl.ServiceException_Exception;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.request.FacadeRendiconti;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import com.fideuram.exception.RendicontiException;


/**
 * Created
 * User: v801068
 * Date: 26/11/13
 * Time: 9.59
 */
@Deprecated
public class ControllerAction {


    /**
     * @param modello
     * @param azione
     * @return  Object
     */
    public Object elaborazioneODT(String modello, int azione) throws DocGeneratorException {
        byte[] doc= (byte[]) getDocumento(modello, azione, FormatoRichiesto.ODT);
        return doc;
    }




    private Object getDocumento(String data, int richiesta, int formato) throws DocGeneratorException {
        LoggingUtils.info("CONTROLLER - ACTION RICHIESTA: " + richiesta);
        LoggingUtils.debug("DATI IN INGRESSO: " + data);

        richiesta = DecodificatoreRichieste.decodificaRichiesta(richiesta);

        //Verifico se il servizio esiste e se è abilitato
        if(StatoServizi.isAbilitato(richiesta)==false){
            LoggingUtils.info("ActionSwitcher --> la richiesta: " + richiesta + "non è stata riconosciuta o è disabilitata");
            throw new DocGeneratorException("Richiesta non riconosciuta o disabilitata");
        }


        ProcessoBase pb = null;
        Polizza p;
        try{
            switch (richiesta) {
                case(0):    // SALDI ASSET
                    return new AssetFacade().elaboraOdt(data,richiesta);
                case(4604)://RIDUZIONE POLIZZA
                    pb= new RiscattiRiduzioni();
                    return pb.getDocumento(data,richiesta,formato);
                case(4555)://PRESTAZIONI A SCADENZA
                    pb= new RiscattiRiduzioni();
                    return pb.getDocumento(data,richiesta,formato);
                case(5001)://OPZIONE_R1_ANTICIPATA
                    pb= new ProcessOpzioni();
                case(8557)://OPZIONE AVVISO DI SCADENZA       //EX case(34907):
                    pb = new AvvisiScadenza();
                    return pb.getDocumento(data,richiesta,formato);
                case(1)://STATO PRATICA
                    pb = new StatoPratica();
                    return pb.getDocumento(data,richiesta,formato);
                case(2)://IPOTESI DI OPZIONE
                    pb = new IpotesiOpzione();
                    return pb.getDocumento(data,richiesta,formato);
                case(4)://AVVISO SCADENZA PREMIO (NON ANCORA IMPLEMENTATO)
                    pb = new AvvisiScadenzaPremi();
                    return pb.getDocumento(data, richiesta, formato);
                case(8)://SIMULAZIONI SPI
                    pb = new SimulazioniSPI();
                    return pb.getDocumento(data, richiesta, formato);
                case(10)://SPIEGAZIONE CONTEGGI LIQUIDAZIONE SPI
                    pb = new SpiegazioneConteggiLiquidazioneSPI();
                    return pb.getDocumento(data, richiesta, formato);
                case(14)://RISCATTO PARZIALE TENDENZA
                    pb = new RiscattoParzialeTendenza();
                    return pb.getDocumento(data, richiesta, formato);
                case(15)://DECUMULO
                    pb = new Decumulo();
                    return pb.getDocumento(data, richiesta, formato);

                //todo chiamare il generatore odt o tagliare case 16:   //AREA RISERVATA CLIENTI
                //todo chiamare il generatore odt o tagliare case 17:   //AREA RISERVATA CLIENTI
                //todo chiamare il generatore odt o tagliare case 18:   //AREA RISERVATA WEB DATORI
                //todo chiamare il generatore odt o tagliare case 19:   //AREA RISERVATA WEB DATORI
                //todo chiamare il generatore odt o tagliare     return new FacadeCredenziali().stampa(data,richiesta);
                 case 1000: //Appendice Richiesta Cambio Contraenza     - contraente vivo
                 case 1001: //Appendice Richiesta Cambio Contraenza     - contraente deceduto
                 case 1002: //Appendice Richiesta Cambio Beneficiario   - vecchio beneficiario deceduto
                 case 1003: //Previdenza: Richiesta Trasferimento in ingresso
                 case 1004: //Previdenza: Richiesta Trasferimento in ingresso RICHIESTA DATI FISCALI
                 case 1010: //Richiesta Cambio Contraenza
                 case 1011: //Sollecito Richiesta Cambio Contraenza
                 case 1012: //Rifiuto Cambio Contraenza
                 case 1100: //PREVIDENZA BONIFICO
                 case 1101: //PREVIDENZA DISTINTA
                 case 1104: //PREVIDENZA MODULO 4
                 case 1105: //PREVIDENZA MODULO 5
                 case 1106: //PREVIDENZA MODULO 6
                 case 1107: //PREVIDENZA MODULO 7
                 case 1108: //PREVIDENZA MODULO 8
                 case 1109: //PREVIDENZA MODULO 9
                 case 1110: //PREVIDENZA MODULO 10
                 case 1112: //PREVIDENZA MODULO 12
                 case 1114: //PREVIDENZA MODULO 14
                 case 1115: //PREVIDENZA MODULO 14
                 case 1116: //PREVIDENZA MODULO 16
                 case 1118: //PREVIDENZA MODULO 18   //TRASFERIMENOTO IN INGRESSO: LETTERA INDIRIZZATA ALL'ADERENTE
                 case 1119: //PREVIDENZA MODULO 19   //SINISTRO
                 case 1020: //Richiesta Variazione Beneficiario
                 case 1021: //Sollecito Variazione Beneficiario
                 case 1022: //Appendice Variazione Beneficiario
                 case 1023: //Rifiuto Variazione Beneficiario
                     return new ControllerActionsGenerics().elaboraProcesso(data,richiesta);
                 case(6000):
                 case(6001):
                 case(6002):
                 case(6003):
                 case(6004):
                 case(6005):
                 case(6006):
                 case(6007):
                 case(6008):
                 case(6009):
                 case(6010):
                 case(6011):
                 case(6012):
                 case(6013):
                 case(6014):
                 case(6015):
                 case(6016): //rendiconto mensile dei fondi dedicati
                 case(6017):
                 case(6018):
                    LoggingUtils.info("ENTRO NEI RENDICONTI CON LA RICHIESTA "+richiesta);
                    FacadeRendiconti f=new FacadeRendiconti();
                    return f.elaboraProcesso(richiesta,data);
                default:
                    return getOdtFromDisplayPolizza(data, richiesta);
            }
        } catch (DisplayPolizzaException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (InstantiationException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (IllegalAccessException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (JAXBException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (AssetException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (RendicontiException e) {
            throw new DocGeneratorException(e.getMessage());
        } catch (Exception e) {
            throw new DocGeneratorException(e.getMessage());
        }
    }
    /**
     * PROCESSI EFFETTIVAMENTE RICONOSCIUTI:
     * case(5):     //DISPLAY POLIZZA DATI SINTETICI
     * case(501):   //DISPLAY POLIZZA DATI SINTETICI PREVIDENZA
     * case(510):   //RICHIESTA PROIEZIONE BONUS
     * case(502):   //ICHIESTA ESTRATTO CONTO PREVMI VERSATI"
     * case(3):     //NUOVO RISCATTO ANTICIPATO
     * case(9):     //RISCATTO ANTICIPATO SPI
     * case(4538):  //RISCATTO ANTICIPATO
     * case(7):     //AVVISI SCADENZA SPI
     * case(11):    //ANDAMENTI E RISULTATI
     * case(12):    //SALDI E ASSET
     * case(13):    //AVVISI SCADENZA RI e RIII
     * case(16):    //AREA RISERVATA
     * case(17):    //AREA RISERVATA RIGENERA PASSWORD
     * case(601):   //Anticipazione Fondo Pensione Aperto
     * @param data
     * @param richiesta
     * @return
     */
    private Object getOdtFromDisplayPolizza(String data, int richiesta) throws ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            JAXBException,
            DocGeneratorException,
            DisplayPolizzaException,
            ServiceException_Exception,
            WebServiceClientException {
        LoggingUtils.debug("RICHIESTA PER DISPLAY POLIZZA: " + richiesta);
        Polizza p;
        switch (richiesta) {
            case(5)://DISPLAY POLIZZA DATI SINTETICI
                p= XmlPolizzaConverter.getPolizza(data);
                if(null!=p.getPrevidenza()){
                    richiesta=501;
                }else {
                    //solo se non è una richiesta di previdenza
                    p.setVariazioniContrattuali(new PucDao().getVariazioniContrattuali(p.getDatiTecnici().getNumeroPolizza()));
                }
                return new DisplayPolizzaFacade().elaboraOdt(p, richiesta);
            case(12)://Saldi asset
                p= XmlPolizzaConverter.getPolizza(data);
                if((p.getDatiTecnici().getProdotto().getCodice().equalsIgnoreCase("MIXT1") ||
                    p.getDatiTecnici().getProdotto().getCodice().equalsIgnoreCase("MIXT3")
                    ) && p.getDatiTecnici().getProdotto().getTipoRamoLayout().equalsIgnoreCase("X")){
                    richiesta=1201;
                }
            default:
                return new DisplayPolizzaFacade().elaboraOdt(data,richiesta);

        }
    }
}
