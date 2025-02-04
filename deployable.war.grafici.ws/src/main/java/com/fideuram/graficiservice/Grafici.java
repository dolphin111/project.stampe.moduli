package com.fideuram.graficiservice;

import com.fideuram.chart.exception.GraphException;
import com.fideuram.chart.lab.ConfigurationGraph;
import com.fideuram.chart.lab.bar.IstogrammaEngine;
import com.fideuram.chart.lab.bar.bean.Barre;
import com.fideuram.chart.lab.line.LineaMonthEngine;
import com.fideuram.chart.lab.line.bean.Linee;
import com.fideuram.chart.mock.prospetti.grafici2015.barra.LG01RA_B;
import com.fideuram.chart.mock.prospetti.grafici2015.linea.LG01RA_L;
import com.fideuram.graficiservice.response.Risposta;
import com.fideuram.utils.Base64EncodeImage;
import com.fideuram.config.CrmProperties;
import exception.FaultBean;
import exception.GraficiWsException;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.WebServiceContext;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class Grafici {
    //http://localhost:7001/crm.grafici.web/GraficiService?WSDL

    @Resource
    private WebServiceContext context;

    @WebMethod
    public String testIntegration(){
        return "Modulo WEB-WS Stampe - Presente";
    }


    @WebMethod
    public Risposta getIstogramma(Barre obj, ConfigurationGraph configurationGraph) throws GraficiWsException {
        try {
            IstogrammaEngine istogrammaEngine=new IstogrammaEngine();
            String _tmpdir=getTmpDir();
            String destFile= ""+new Date().getTime();
            istogrammaEngine.generate(obj,_tmpdir,destFile,configurationGraph);
            byte[] grafico= istogrammaEngine.getFile(_tmpdir,destFile);
            return getRisposta(grafico);
        } catch (IOException e) {
            throw new GraficiWsException("Errore di IO : ",new FaultBean(e.getMessage()));
        }
    }

    @WebMethod
    public Risposta getGraficoLinea(Linee obj, ConfigurationGraph configurationGraph) throws GraficiWsException {
        try {
            LineaMonthEngine lineaMonthEngine=new LineaMonthEngine();
            String _tmpdir=getTmpDir();
            String destFile= ""+new Date().getTime();
            lineaMonthEngine.generate(obj,_tmpdir,destFile,configurationGraph);
            byte[] grafico= lineaMonthEngine.getFile(_tmpdir,destFile+"linea");
            return getRisposta(grafico);
        } catch (IOException e) {
           throw new GraficiWsException("Errore di IO : ",new FaultBean(e.getMessage()));
        }
    }

    private Risposta getRisposta(byte[] grafico) {
            String  encoded= Base64EncodeImage.encodeImage(grafico);
            Risposta risposta = new Risposta();
            risposta.setStreamType("png");
            risposta.setStreamBase64(encoded);
            risposta.setEsito(true);
            return risposta;
    }



    private static String getTmpDir(){
        String dir= CrmProperties.getProperty("crm.services.temp.path")+""+new Date().getTime();
        boolean success=  (new File(dir)).mkdirs();
        dir=dir+"/";
        return dir;
    }
    
    public static void main(String args[]) throws GraficiWsException, GraphException {
        Barre barre =LG01RA_B.getMock();
        //Risposta rb =new Grafici().getIstogramma(barre,LG01RA_B.getConfigurationBar());
        
        //Linee linee= LG01RA_L.getMockSommavillaFvInsieme();
        //Risposta rl=new Grafici().getGraficoLinea(linee,LG01RA_L.getConfigurationBar());

    }
}
