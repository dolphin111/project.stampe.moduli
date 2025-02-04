package com.fideuram.modello.xml;

import com.fideuram.jaxb.Converter;
import com.fideuram.modello.attori.Contraente;
import com.fideuram.modello.polizza.Polizza;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 17.27
 */
public class XmlPolizzaConverter {
    public static Polizza getPolizza(String xml) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        LoggingUtils.debug("XmlPolizzaConverter° in conversione ---->   \n "+xml);
        Polizza polizza= (Polizza) Converter.xml2Object(new Polizza(), xml);
        return polizza;
    }
}
