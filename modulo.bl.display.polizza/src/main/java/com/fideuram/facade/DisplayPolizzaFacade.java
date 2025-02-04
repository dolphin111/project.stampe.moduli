package com.fideuram.facade;

import com.fideuram.exception.DisplayPolizzaException;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.factory.OdtFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.factory.TemplateFactory;
import com.fideuram.file.TempDir;
import com.fideuram.modello.RichiestaDocumento;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.modello.xml.XmlPolizzaConverter;
import com.fideuram.utils.LoggingUtils;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;

/**
 * Created by 
 * User: logan
 * Date: 10/04/13
 * Time: 17.15
 */
public class DisplayPolizzaFacade {
    private String tmpdir;

    public byte[] elaboraOdt(Polizza polizza, int richiesta) throws DisplayPolizzaException {
        LoggingUtils.info("DisplayPolizzaFacade 4.0.2 + RICHIESTA " +richiesta);
        try {
            byte[] template=null;
            polizza.setRichiestaDocumento(new RichiestaDocumento(richiesta,""));
            LoggingUtils.info("PARSE XML TO BEANS ESEGUITO! QUESTO E' IL NUMERO POLIZZA TROVATO: " + polizza.getDatiTecnici().getNumeroPolizza());
            template= TemplateFactory.getTemplateFromRichiesta(richiesta);
            LoggingUtils.info("PRENDO IL TEMPLATE RELATIVO ALLA RICHIESTA " + richiesta);
            File file = new OdtFactory().generateOdtWithFreemarker(template, polizza);
            LoggingUtils.info("DOCUMENTO GENERATO: " + richiesta);
            byte[] stream= new byte[0];
            stream = StreamerFactory.getStreamFromFile(file);
            LoggingUtils.info("STREAM: " + richiesta + " "+stream.toString());
            tmpdir=file.getParent();
            //file.delete();
            return stream;
        } catch (TemplateLoaderExcepion e) {
            throw new DisplayPolizzaException(e.getMessage(),e);
        } catch (IOException e) {
            throw new DisplayPolizzaException("Errore di I/O:"+e.getMessage(),e);
        }finally {
            TempDir.clean(tmpdir);
        }
    }

    /**
     * <br>Questo metodo restituisce un documento in formato Odt</br>
     * <br>relativo ai dati polizza passati in formato xml</br>
     *
     * @param xml dati polizza
     * @param richiesta  tipo template da utilizzare
     * @return  type byte[]
     */
    public byte[] elaboraOdt(String xml, int richiesta) throws DisplayPolizzaException {
        LoggingUtils.debug("ATTIVATO IL DISPLAY POLIZZA  4.0.2  PER LA RICHIESTA: >> " + richiesta);
        Polizza polizza= null;
        byte[] template=null;
        try {
            polizza = XmlPolizzaConverter.getPolizza(xml);
            return elaboraOdt(polizza,richiesta);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new DisplayPolizzaException("Errore durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new DisplayPolizzaException("Errore di ClassNotFoundException durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new DisplayPolizzaException("Errore di InstantiationException durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new DisplayPolizzaException("Errore di IllegalAccessException durante la fase di conversione xml2Polizza:"+e.getMessage(),e);
        }
    }
}
