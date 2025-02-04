package com.fideuram.processo;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.ConguaglioException;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.conguaglio.PrinterConguaglio;
import com.fideuram.stampe.modello.rendita.Prestazione;
import com.fideuram.stampe.modello.rendita.Prestazioni;
import com.fideuram.test.PrestazioneCreditoMock;
import com.fideuram.test.PrestazioneDebitoMock;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: V801068
 * Date: 21/11/14
 * Time: 12.04
 */
public class FacadeConguaglio {


    public void generaConguaglioBase(File xmlPrestazioni)throws Exception {
        Prestazioni cr = (Prestazioni) Converter.xml2Object(new Prestazioni(), xmlPrestazioni);
        String tipo="";
        for (int i = 0; i < cr.getPrestazione().size(); i++) {
            //Il tipo mi indica se è un debito o un credito
            tipo=cr.getTipo();
            Prestazione prestazione = cr.getPrestazione().get(i);
            new PrinterConguaglio(prestazione,tipo).generateConguaglio(tipo);
            LoggingUtils.info(" Elaboro il codice fiscale " + prestazione.getCodiceFiscale());
        }
    }


  /*  public void generaConguaglio(String datiInXml) throws ConguaglioException {

        try {
            Prestazione c = parseXml2Bean(datiInXml);
             new PrinterConguaglio(c).generateConguaglio();
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new ConguaglioException("",e);
        } catch (DocumentException e) {
            LoggingUtils.error(e);
            throw new ConguaglioException("",e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new ConguaglioException("",e);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new ConguaglioException("",e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new ConguaglioException("",e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new ConguaglioException("",e);
        }
    }      */

    private Prestazione parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
       Prestazione  prestazione= new Prestazione();
       prestazione= (Prestazione) Converter.xml2Object(prestazione, datiInXml);
       return prestazione;
    }

    public static void main1(String args[]) throws JAXBException, IOException, ConguaglioException {
        LoggingUtils.info("START");
        LoggingUtils.info(PrestazioneCreditoMock.getXmlMock());
        for(int i=0;i<1;i++){
        //    new FacadeConguaglio().generaConguaglio(PrestazioneCreditoMock.getXmlMock());
        }
        LoggingUtils.info("FINE");
    }


    public static void main(String args[])  throws JAXBException, IOException, ConguaglioException{
        new FacadeConguaglio().listaFile();
        LoggingUtils.info("FINE");
    }


    public void listaFile() throws JAXBException, IOException, ConguaglioException{

        String prestazioniInput= CrmProperties.getProperty("prestazione.input");
        List<String> listaFile = new ArrayList<String>();


        File f = new File(prestazioniInput);
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                File file = new File(prestazioniInput+ File.separator + files[i]);
                if (!file.isDirectory()) {
                    try {
                        new FacadeConguaglio().generaConguaglioBase(file);
                    } catch (Exception e) {
                        throw new ConguaglioException("",e);
                    }
                }
        }
     }

    }



}

