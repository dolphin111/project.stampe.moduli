package com.fideuram.xml;

import com.fideuram.jaxb.Converter;
import com.fideuram.stampe.modello.asset.FondoInvestimentoGlobale;
import com.fideuram.utils.LoggingUtils;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 17.27
 */
public class XmlAssetConverter {

    public static FondoInvestimentoGlobale getBeans(String xml) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        LoggingUtils.info("XmlAssetConverter° in conversione ---->   "+xml);
        FondoInvestimentoGlobale asset= (FondoInvestimentoGlobale) Converter.xml2Object(new FondoInvestimentoGlobale(), xml);
        LoggingUtils.info("XmlAssetConverter°:  PROCESSO DI CONVERSIONE CONCLUSO" );
        return asset;
    }

    public static String getXml(FondoInvestimentoGlobale fig) throws JAXBException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        String asset=  Converter.objectToXml(fig);
        LoggingUtils.info("XmlAssetConverter°:  PROCESSO DI CONVERSIONE CONCLUSO" );
        return asset;
    }

}
