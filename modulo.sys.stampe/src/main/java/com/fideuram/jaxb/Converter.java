package com.fideuram.jaxb;


import com.fideuram.config.CrmProperties;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 24/09/12
 * Time: 11.00
 */
public class Converter {
    public static String objectToXml(Object obj) throws JAXBException, IOException {
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        //marshaller.marshal(obj, System.out);
        File f = new File(CrmProperties.getProperty("crm.services.temp.path") + new Date().getTime()+".xml");
        marshaller.marshal(obj, f);
        String xml= FileUtils.readFileToString(f);
        f.delete();
        return xml;
    }

    public static boolean objectToXmlFile(Object obj, String pathNomefile) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(obj, new File(pathNomefile));
        return true;
    }



    /**
     * restituisce l'oggetto valorizzato
     * @param obj
     * @param xml
     * @return
     * @throws JAXBException
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static Object xml2Object(Object obj, File xml) throws JAXBException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        obj =unmarshaller.unmarshal(xml);
        return obj;
    }

    public static Object xml2Object(Object obj, String xml) throws JAXBException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        JAXBContext jc = JAXBContext.newInstance(obj.getClass());
        Unmarshaller unmarshaller = jc.createUnmarshaller();
       // unmarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringReader reader = new StringReader(xml);
        obj =unmarshaller.unmarshal(reader);
        return obj;
    }


}
