package com.fideuram.stampeservice;

import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.preventivo.modello.Preventivo;
import com.fideuram.preventivo.modello.PreventivoFVI;
import com.fideuram.preventivo.modello.PreventivoFVO;
import com.fideuram.preventivo.servizi.FacadePreventivi;
import com.fideuram.request.FacadeProspetti;
import com.fideuram.stampeservice.controller.ActionDecoder;
import com.fideuram.stampeservice.controller.OdtRequest;
import com.fideuram.stampeservice.controller.PdfRequest;
import com.fideuram.stampeservice.request.KeyValue;
import com.fideuram.stampeservice.request.TrasportBean;
import com.fideuram.stampeservice.response.Risposta;
import com.fideuram.utils.LoggingUtils;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Stampe {
    //http://10.13.66.113:7001/stampe.ws/StampeService?wsdl

    @Resource
    private WebServiceContext context;

    @WebMethod
    public String getVersion()
    {
        LoggingUtils.info("GET VERSION");

        return  "stampe.ws.war_0.0.2";
    }

    @WebMethod
    public String testIntegration(){
        return "Modulo WEB-WS Stampe - Presente";
    }

    /**
     * Questo metodo carica i valori di input se ce ne sono in un Hashtable.
     * @param obj
     * @return Hashtable
     */
    private Hashtable getImputs(TrasportBean obj){
        Hashtable h = new Hashtable();
        if(obj.getInput()!=null){
            List<KeyValue> inputs = obj.getInput();
            if(inputs!=null){
                for (int i=0; i<inputs.size();i++){
                    KeyValue keyValue= inputs.get(i);
                    h.put(keyValue.getKey(),keyValue.getValue());
                }
            }
        }
        return h;
    }

    /**
     * @param obj
     * @return
     * @throws StampeWsException
     */
    @WebMethod
    public Risposta generateOdt(TrasportBean obj) throws StampeWsException {
        LoggingUtils.info("GENERATE ODT 4.0.2 + RICHIESTA " + obj.getAction());
        return incapulaRisposta(new OdtRequest().stampa(obj.getXml(), ActionDecoder.decode( obj.getAction())));
    }

    /**
     *
     * @param obj
     * @return
     * @throws StampeWsException
     */
    @WebMethod
    public Risposta generatePdf(TrasportBean obj) throws StampeWsException {
        LoggingUtils.info("GENERATE PDF 4.0.1 + RICHIESTA " + obj.getAction());
        return incapulaRisposta(new PdfRequest().stampa(obj.getXml(), ActionDecoder.decode( obj.getAction())));

    }

    private Risposta incapulaRisposta(byte[] doc){
        Risposta r = new Risposta();
        r.getStreams().add(doc);
        if(doc!=null&&doc.length>2)
            r.setEsito(true);
        return r;
    }

    @WebMethod
    public byte[] getOdtFromXml(String xml, String tripletta) throws StampeWsException {
        LoggingUtils.info("STRANAMENTE STAI CHIAMANDO ODT-FROMXML 4.0.1 + RICHIESTA " + tripletta);
        return new OdtRequest().stampa(xml, ActionDecoder.decode(tripletta));
    }

    @WebMethod
    public byte[] getPdfFromXml(String xml, String tripletta) throws StampeWsException {
        LoggingUtils.info("STRANAMENTE STAI CHIAMANDO PDF-FROMXML 4.0.1 + RICHIESTA " + tripletta);
        return new PdfRequest().stampa(xml, ActionDecoder.decode(tripletta));
    }

    @WebMethod
    public byte[] stampaPreventivo(Preventivo preventivo, String tripletta) throws StampeWsException {
        LoggingUtils.info("STAMPA PREVENTIVO 4.0.1" + preventivo.getNumeroPreventivo());
        try {
            return  new FacadePreventivi().getDocumento(preventivo,tripletta);
        } catch (DocGeneratorException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        }
    }
    
    @WebMethod
    public byte[] stampaPreventivoFVI(PreventivoFVI preventivo, String tripletta) throws StampeWsException {
        LoggingUtils.info("STAMPA PREVENTIVO_FVI 4.0.1" + preventivo.getNumeroPreventivo());
        try {
            return  new FacadePreventivi().getDocumento(preventivo,tripletta);
        } catch (DocGeneratorException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        }
    }

    /**
     * Servizio ASINCRONO esposto per la generazione dei prospetti di offferta
     * @param obj
     * @throws StampeWsException
     */
    @WebMethod
    public void elaboraProspetto(TrasportBean obj) throws StampeWsException {
        LoggingUtils.info("PROSPETTI 4.0.1");
        detachProcess(obj);
    }

    /**
     * Servizio ASINCRONO esposto per la generazione dei processi di Stampa
     * @param obj
     * @throws StampeWsException
     */
    @WebMethod
    public void elaboraProcessoAsinc(TrasportBean obj) throws StampeWsException {
        LoggingUtils.info("PROSPETTI 4.0.1");
        detachPdfProcess(obj);
    }

    static ExecutorService executorService = Executors.newCachedThreadPool();

    private void detachPdfProcess(TrasportBean obj) {
        final TrasportBean xxx = obj;
        executorService.execute(new Runnable() {
            public void run() {
                try {
                    byte[] pdf=getPdfFromXml(xxx.getXml(),xxx.getAction());
                } catch (StampeWsException e) {
                    //todo salva errore
                    LoggingUtils.error(e);
                }
            }
        });

    }
    /**
     * <br> Metodo Asyncrono
     *
     * <br> questo metodo è stato creato per risolvere ad un problema transazionale del Puc,
     * <br> il quale (visti i tempi di elaborazione dei prospetti) andava fisso in TimOut e
     * <br> e quindi in RollBack.
     *
     * <br> detachProcess quindi ha il compito di creare un thead separato
     * <br> nel quale invocare "FacadeProspetti().elaboraProcesso(..)"
     * @param obj
     *
     * SI STA USANDO UNA QUEUE QUINDI NON PIù USATO
     */
    @Deprecated
    private void detachProcess(TrasportBean obj) {
       final TrasportBean xxx = obj;
        int action=Integer.decode(xxx.getAction());
        executorService.execute(new Runnable() {
            public void run() {
                new FacadeProspetti().elaboraProcesso(Integer.decode(xxx.getAction()),xxx.getXml(),getImputs(xxx));
            }
        });
    }

    @WebMethod
    public byte[] stampaPreventivoFVO(PreventivoFVO preventivo, String tripletta) throws StampeWsException {
        LoggingUtils.info("STAMPA PREVENTIVO_FVO, preventivo:" + preventivo.getNumeroPreventivo()+", tripletta: "+tripletta);
        try {
            return  new FacadePreventivi().getDocumento(preventivo,tripletta);
        } catch (DocGeneratorException e) {
            throw new StampeWsException(e.getMessage(),new FaultBean(e.getMessage()));
        }
    }






}
