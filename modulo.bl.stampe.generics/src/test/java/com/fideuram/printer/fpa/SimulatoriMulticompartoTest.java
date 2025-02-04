package com.fideuram.printer.fpa;

import com.fideuram.exception.GenericsException;
import com.fideuram.jaxb.Converter;
import com.fideuram.request.ControllerActionsGenerics;
import com.fideuram.stampe.modello.previdenza.Previdenza;
import com.fideuram.stampe.modello.previdenza.versamenti.Bonifico;
import com.fideuram.stampe.modello.previdenza.versamenti.VersamentiPrevidenza;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.IOUtils;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;

/**
 * User: V801068
 * Date: 24/07/14
 * Time: 15.10
 */
public class SimulatoriMulticompartoTest {
    public static void main(String args[]){
        try {
			new SimulatoriMulticompartoTest().test("simulatiMulticompartoFPA.xml");
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    public void test(String richiesta) throws ParserConfigurationException, SAXException{
        try {
        	URL url = Thread.currentThread().getContextClassLoader().getResource(richiesta);
        	File file = new File(url.getPath());
        	InputStream is = new FileInputStream(file);
        	String xml = IOUtils.toString( is  );
            byte[] response = (byte[]) new ControllerActionsGenerics().elaboraProcesso(xml, 20);
            
            PrintWriter writer = new PrintWriter("C:/app/CRMStampe/temp/output.odt", "UTF-8");
            writer.println(response);
            writer.close();
            
            System.out.println(response.toString());
        } catch (GenericsException e) {
            LoggingUtils.error(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getXml(VersamentiPrevidenza b) throws JAXBException, IOException {
        return Converter.objectToXml(b);
    }

}
