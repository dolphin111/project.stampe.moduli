
package com.fideuram.credenziali.parser;


import com.fideuram.exception.CredenzialiException;
import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.attori.Individuo;
import com.fideuram.stampe.modello.attori.Recapito;
import com.fideuram.stampe.modello.sicurezza.AreaRiservata;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * User: V801068
 * Date: 11/09/14
 * Time: 12.19
 */
public class PinVo2AreaRiservata {

    public String getXmlAreaRiservata(String xmlPinVo) throws CredenzialiException {
        try {
            return Converter.objectToXml(getAreaRiservata(xmlPinVo));
        } catch (JAXBException e) {
            throw new CredenzialiException(e);
        } catch (IOException e) {
            throw new CredenzialiException(e);
        }
    }

    public AreaRiservata getAreaRiservata(String xmlPinVo) throws CredenzialiException {
        PinVo pinVo =  getPinVo(xmlPinVo);
        AreaRiservata areaRiservata=new AreaRiservata();
        areaRiservata.setIndividuo(getSmandruppato(pinVo));
        areaRiservata.setUserId(pinVo.getUser());
        areaRiservata.setPasswd(pinVo.getPassword());
        return areaRiservata;
    }
    /**
     * Mi ricavo il PinVo dall'xml che ci ha inviato il PUC
     * @param xml
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws javax.xml.bind.JAXBException
     */
    private PinVo getPinVo(String xml) throws CredenzialiException {
        try {
            return (PinVo) Converter.xml2Object(new PinVo(), xml);
        } catch (JAXBException e) {
            throw new CredenzialiException(e);
        } catch (ClassNotFoundException e) {
            throw new CredenzialiException(e);
        } catch (IllegalAccessException e) {
            throw new CredenzialiException(e);
        } catch (InstantiationException e) {
            throw new CredenzialiException(e);
        }
    }


    private Individuo getSmandruppato(PinVo pinVo){
        Individuo persona   = new Individuo();
        Recapito indirizzo  = new Recapito();

        persona.setCognome(pinVo.getCognome());
        persona.setNome(pinVo.getNome());
        persona.setRagioneSociale(pinVo.getRagioneSociale());
        persona.setSesso(pinVo.getSesso());

        indirizzo.setVia(pinVo.getIndirizzo());
        indirizzo.setProvincia(pinVo.getProvincia());
        indirizzo.setComune(pinVo.getCitta());
        indirizzo.setCap(pinVo.getCap());
        persona.setIndirizzo(indirizzo);
        return persona;
    }

  /*  public static void main(String args[]) throws GenericsException {

        PinVo2AreaRiservata pinVo2AreaRiservata=new PinVo2AreaRiservata();
        pinVo2AreaRiservata.getPinVo(prova);

    }*/
}
