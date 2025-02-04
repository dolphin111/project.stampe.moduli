package com.fideuram.printer.mock;

import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.preventivi.*;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;

/**
 * User: V801068
 * Date: 21/07/14
 * Time: 9.30
 */
public class PreventivoConversioneRenditaMock {
   public static void main(String args[]){
       try {
           PreventivoConversioneRenditaMock.getXmlMock();
       } catch (JAXBException e) {
           LoggingUtils.error(e);
       } catch (IOException e) {
           LoggingUtils.error(e);
       }
   }

   public static Preventivo getBeanMock(){
       Preventivo p = new Preventivo();
       p.setProdotto(getProdotto());
       p.setAssicurato(ContraenteMock.getAssicurato());
       p.setRateo(getRateo());
       p.setVitalizio(getVitalizio());
       return p;
   }

    public static String getXmlMock() throws JAXBException, IOException {
       Preventivo p= getBeanMock();
       String xml= Converter.objectToXml(p);
       LoggingUtils.info(xml);
       return xml;
    }

    private static Prodotto getProdotto(){
        Prodotto p = new Prodotto();
        p.setCodice("RSV4");
        p.setFamigliaProdotto(getFamigliaProdotto());
        return p;
    }

    private static FamigliaProdotto getFamigliaProdotto(){
        FamigliaProdotto f= new FamigliaProdotto();
        f.setCodice(1);
        f.setDescrizione("Fideuram Vita Insieme");
        return f;
    }

    private static Rateo getRateo(){
        Rateo r = new Rateo();
        r.setImportoPremio("1234.00");
        r.setDurataMinima(15);
        r.setDecorrenza(new Date());
        r.setDecumulo(50);
        return r;
    }

    private static RenditaVitalizia getVitalizio() {
        RenditaVitalizia r= new RenditaVitalizia();
        r.setRenditaAnnua(1000.00);
        r.setDataRiferimento(new Date());
        return r;
    }


}

