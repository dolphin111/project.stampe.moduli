package com.fideuram.processo;

import com.fideuram.exception.Cu2015Exception;
import com.fideuram.jaxb.Converter;
import com.fideuram.printer.stampa2016.ordinario.PrinterCu2016Ordinario;
import com.fideuram.printer.stampa2016.sintetico.PrinterCu2016Sintetico;
import com.fideuram.prova.Cud2016Mock;
import com.fideuram.stampe.modello.redditi.d2016.Cud2016;
import com.fideuram.utils.LoggingUtils;
import com.itextpdf.text.DocumentException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * User: V801068
 * Date: 07/01/16
 * Time: 18.18
 */
public class FacadeCu2016 {
    public void generaCu2016(String datiInXml) throws Cu2015Exception {

        try {
            Cud2016 c = parseXml2Bean(datiInXml);

            //new PrinterCu2016Ordinario(c).generateCud2016();
            new PrinterCu2016Sintetico(c).generateCud2016();
        } catch (IOException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (DocumentException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            throw new Cu2015Exception("",e);
        }
    }
    private Cud2016 parseXml2Bean(String datiInXml) throws ClassNotFoundException, InstantiationException, IllegalAccessException, JAXBException {
        Cud2016 cud = new Cud2016();
        cud= (Cud2016) Converter.xml2Object(cud, datiInXml);
        return cud;
    }

    public static void main(String args[]) throws JAXBException, IOException, Cu2015Exception {
        LoggingUtils.info("START");
        String xml=Cud2016Mock.getXmlMock();
        LoggingUtils.info(xml);

        for(int i=0;i<1;i++){
            new FacadeCu2016().generaCu2016(xml);
        }
        LoggingUtils.info("FINE");
    }
}
