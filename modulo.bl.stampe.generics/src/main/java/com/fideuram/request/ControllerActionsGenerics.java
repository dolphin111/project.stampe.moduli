package com.fideuram.request;

import com.fideuram.costanti.Errori;
import com.fideuram.decoder.MapperProcessiCrm;
import com.fideuram.exception.GenericsException;
import com.fideuram.exception.PrinterFreemarkerException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.*;
import com.fideuram.stampe.modello.contraenza.*;
import com.fideuram.stampe.modello.fpa.SimulatoriFPA;
import com.fideuram.stampe.modello.preventivi.Preventivo;
import com.fideuram.stampe.modello.previdenza.Previdenza;
import com.fideuram.stampe.modello.previdenza.PrevidenzaTrasferimentoInput;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;
import com.fideuram.stampe.modello.richiestaDocumentiMancantiSinistro.RichiestaDocumentiMancantiSinistro;
import com.fideuram.stampe.modello.richiestaFacta.RichiestaFacta;
import com.fideuram.stampe.modello.variazioneBeneficiario.AppendiceVB;
import com.fideuram.stampe.modello.variazioneBeneficiario.RifiutoVB;
import com.fideuram.stampe.modello.variazioneBeneficiario.SollecitoVB;
import com.fideuram.stampe.modello.variazioneBeneficiario.VariazioneBeneficiario;
import com.fideuram.stampe.modello.workflowliquidativo.RifiutoWFL;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by V801068 on 14/05/14.
 */
public class ControllerActionsGenerics {

    public static final String  ERROR_CODICE_ACTION_CRM_BONITA_NON_RICONOSCIUTIO ="Errore: IL CODICE PER IL MAPPING DELLA ACTION CRM/BONITA NON E' RICONOSCIUTO";

    /**
     * Se si sta usando questo elabora processo significa che la action è in formato String quindi
     * è una chiamata proveniente Da CRM/Bonita per conto del Puc (ci stanno girando un codice puc)
     * relativo ai processi liquidativi.
     *
     *
     * @param xml
     * @param azione
     * @return
     * @throws GenericsException
     */
    public Object elaboraProcesso(String xml,String azione) throws GenericsException {
         Integer _azione= MapperProcessiCrm.decodeProcess(azione);
         if(null==_azione)
             throw new GenericsException(ERROR_CODICE_ACTION_CRM_BONITA_NON_RICONOSCIUTIO);
         return elaboraProcesso(xml,_azione);
    }

    public Object elaboraProcesso(String xml,int azione) throws GenericsException {
        LoggingUtils.debug("ControllerActions 1.0.3 - Azione richiesta: "+azione);
        try{
            switch (azione){
                //case 16:
                //case 17:
                //case 18:
                //case 19:
                //    AreaRiservata areaRiservata;
                //    try{
                //        areaRiservata = (AreaRiservata) Converter.xml2Object(new AreaRiservata(), xml);
                //    }catch (Exception e){
                //        areaRiservata = new PinVo2AreaRiservata().getAreaRiservata(xml);
                //    }
                //    return new PrinterSicurezza(areaRiservata,azione).start();
	            case 20: 
	            	LoggingUtils.info("Controller Action Generic 20 "+xml);
	            	SimulatoriFPA simulazione = (SimulatoriFPA) Converter.xml2Object(new SimulatoriFPA(), xml);
	            	return new PrinterSimulatoriFPA(simulazione, azione).start();
                case 918:
                	
                case 950:   //Preventivo Conversione Rendita
                    Preventivo preventivo =   (Preventivo) Converter.xml2Object(new Preventivo(), xml);
                    //LoggingUtils.debug("TRONCONE DESCRIZIONE RENDITA ANNUA "+preventivo.getVitalizio().getDescrizioneRenditaAnnua(preventivo.getProdotto().getFamigliaProdotto().getCodice(),preventivo.isPreventivoDiCalcoloRateo()));
                    return new PrinterPreventivo(preventivo,azione).start();
                case 1000:  //Appendice Richiesta Cambio Contraenza - contraente vivo
                    AppendiceCC acc = (AppendiceCC) Converter.xml2Object(new AppendiceCC(), xml);
                    return new PrinterCC(acc,azione).start();

                case 1001:  //Appendice Richiesta Cambio Contraenza - contraente deceduto
                    acc = (AppendiceCC) Converter.xml2Object(new AppendiceCC(), xml);
                    acc.getCausale().setCausale(CausaleCC.CAMBIO_CONTRAENZA_PER_DECESSO);
                    return new PrinterCC(acc,azione).start();
                case 1002:  //Appendice Richiesta Cambio Beneficiario - vecchio beneficiario deceduto
                    LoggingUtils.info("Controller Action Generic 1002 "+xml);
                    CambioBenficiario cb = (CambioBenficiario) Converter.xml2Object(new CambioBenficiario(), xml);
                    return new PrinterCB(cb,azione).start();
                case 1003:  //Richiesta Trasferimento a Fondo Previdenziale In Ingresso
                case 1004:  //Richiesta Trasferimento a Fondo Previdenziale In Ingresso  RICHIESTA DEI DATI FISCALI
                case 1005:  //Richiesta Trasferimento a Fondo Previdenziale In Ingresso  SENZA SEGUITO
                    LoggingUtils.info("Controller Action Generic "+ azione +xml);
                    PrevidenzaTrasferimentoInput pti = (PrevidenzaTrasferimentoInput) Converter.xml2Object(new PrevidenzaTrasferimentoInput(), xml);
                    return new PrinterPrevidenza(pti,azione).start();
                case 1010:  //Richiesta Cambio Contraenza
                case 1012:  //Rifiuto Cambio Contraenza
                    CambioContraenza cc = (CambioContraenza) Converter.xml2Object(new CambioContraenza(), xml);
                    return new PrinterCC(cc,azione).start();
                case 1011:  //Sollecito Richiesta Cambio Contraenza
                    SollecitoCC sollecitoCC = (SollecitoCC)  Converter.xml2Object(new SollecitoCC(), xml);
                    return new PrinterCC(sollecitoCC,azione).start();
                case 1020:  //Richiesta Variazione Beneficiario
                    VariazioneBeneficiario vb = (VariazioneBeneficiario) Converter.xml2Object(new VariazioneBeneficiario(), xml);
                    return new PrinterVB(vb,azione).start();
                case 1021:  //Sollecito Variazione Beneficiario
                    SollecitoVB sollecitoVD = (SollecitoVB)  Converter.xml2Object(new SollecitoVB(), xml);
                    return new PrinterVB(sollecitoVD,azione).start();
                case 1022:  //Appendice Richiesta Variazione Beneficiario
                    AppendiceVB avb = (AppendiceVB) Converter.xml2Object(new AppendiceVB(), xml);
                    return new PrinterVB(avb,azione).startAppendiceVB();
                case 1023:  //Rifiuto Richiesta Variazione Beneficiario
                    RifiutoVB rvb = (RifiutoVB) Converter.xml2Object(new RifiutoVB(), xml);
                    return new PrinterVB(rvb,azione).start();
                case 1024:  //Richiesta Documenti Mancanti Sinistro
                	RichiestaDocumentiMancantiSinistro rdms = (RichiestaDocumentiMancantiSinistro) Converter.xml2Object(new RichiestaDocumentiMancantiSinistro(), xml);
                    return new PrinterRDMS(rdms,azione).start();
                case 1100: //PREVIDENZA BONIFICO
                    VersamentiPrevidenza versamentiPrevidenza = (VersamentiPrevidenza) Converter.xml2Object(new VersamentiPrevidenza(), xml);
                    return new PrinterPrevidenza(versamentiPrevidenza,azione).start();
                case 1101: //PREVIDENZA DISTINTA PAGAMENTI
                    versamentiPrevidenza = (VersamentiPrevidenza) Converter.xml2Object(new VersamentiPrevidenza(), xml);
                    return new PrinterPrevidenza(versamentiPrevidenza,versamentiPrevidenza.getDistinta().getInLavorazione()?11011:azione).start();
                case 1104: //PREVIDENZA MODULO 4
                case 1105: //PREVIDENZA MODULO 5
                case 1106: //PREVIDENZA MODULO 6
                case 1107: //PREVIDENZA MODULO 7
                case 1108: //PREVIDENZA MODULO 8
                case 1109: //PREVIDENZA MODULO 9
                case 1110: //PREVIDENZA MODULO 10
                case 1112: //PREVIDENZA MODULO 12
                case 1114: //PREVIDENZA MODULO 14
                case 1115: //PREVIDENZA MODULO 15
                case 1116: //PREVIDENZA MODULO 16
                case 1119: //PREVIDENZA MODULO 19   //SINISTRO
                case 1120: //PREVIDENZA MODULO 20
                    Previdenza  p = (Previdenza) Converter.xml2Object(new Previdenza(), xml);
                    return new PrinterPrevidenza(p,azione).start();
                case 1121: //WORKFLOW LIQUIDATIVO Rifiuto A
                case 1122: //WORKFLOW LIQUIDATIVO Rifiuto B
                case 1123: //WORKFLOW LIQUIDATIVO Rifiuto C
                case 1124: //WORKFLOW LIQUIDATIVO Rifiuto D
                case 1125: //WORKFLOW LIQUIDATIVO Rifiuto G
                case 1126: //WORKFLOW LIQUIDATIVO Rifiuto  Senza Seguito liquidazione
                	RifiutoWFL  r = (RifiutoWFL) Converter.xml2Object(new RifiutoWFL(), xml);
                    return new PrinterWFL(r,azione).start();
                case 1118: //PREVIDENZA MODULO 17   //TRASFERIMENOTO IN INGRESSO: LETTERA INDIRIZZATA ALL'ADERENTE
                    p = (Previdenza) Converter.xml2Object(new Previdenza(), xml);
                    List<Integer> i=new ArrayList<Integer>();
                    if(p.getDocumentazione().getDocIntgrativa().size()>0)
                        i.add(11181);
                    if(p.getDocumentazione().getDocIntegrativaAderente().size()>0)
                        i.add(11182);
                    int[] actions=new int[i.size()];
                    for (int x=0;x<i.size();x++){actions[x]=i.get(x);}
                    return new PrinterPrevidenza(p,azione).start(actions);

                    //if(p.getDocumentazione().getDocIntgrativa().size()>0){
                    //  return new PrinterPrevidenza(p,azione).start(new int[]{11181, 11182});
                    //}else{
                    //  return new PrinterPrevidenza(p,azione).start(new int[]{11182});
                    //}
                case 1127:
                	RichiestaFacta rfPrimoInvio = (RichiestaFacta) Converter.xml2Object(new RichiestaFacta(), xml);
                    return new PrinterFacta(rfPrimoInvio,azione).start();
                case 1128:
                	RichiestaFacta rfSollecito = (RichiestaFacta) Converter.xml2Object(new RichiestaFacta(), xml);
                    return new PrinterFacta(rfSollecito,azione).start();
                case 1129:
                	RichiestaFacta rfAltriSolleciti = (RichiestaFacta) Converter.xml2Object(new RichiestaFacta(), xml);
                    return new PrinterFacta(rfAltriSolleciti,azione).start();
                default:
                    LoggingUtils.debug("ERRORE - Richiesto un Rendiconto, ma non è stato specificato il Tipo. Es: FAO, PRTF2=  "+azione);
                    throw new GenericsException(Errori.ERROR_TYPE);
            }
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new GenericsException(Errori.ERROR_XML +e.getMessage(),e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new GenericsException(Errori.ERROR_NOTFOUND +e.getMessage(),e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new GenericsException(Errori.ERROR_INSTANCE +e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new GenericsException(Errori.ERROR_ILLEGAL + e.getMessage(),e);
        } catch (PrinterFreemarkerException e) {
            LoggingUtils.error(e);
            throw new GenericsException(Errori.ERROR_FREEMARKER + e.getMessage(),e);
        } catch (TemplateLoaderExcepion e) {
            LoggingUtils.error(e);
            throw new GenericsException(Errori.ERROR_TEMPLATE + e.getMessage(),e);
        }
    }
}
