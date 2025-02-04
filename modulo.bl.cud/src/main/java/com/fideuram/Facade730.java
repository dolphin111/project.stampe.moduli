package com.fideuram;

import com.fideuram.config.CrmProperties;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.cud.Cud;
import com.fideuram.stampe.modello.cud.CUD;
import com.fideuram.utils.LoggingUtils;

import javax.xml.bind.JAXBException;
import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created
 * User: v801068
 * Date: 25/02/14
 * Time: 20.08
 */
public class Facade730 {

    public List<String> indexhXmlFile() {
        ArrayList<String> result = new ArrayList<String>();
        File f = new File(CrmProperties.getProperty("cud.xml.temp.path"));
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                result.add(files[i]);
            }
        }
        return result;
    }

    /**
     * @param xml
     * @return
     */
    public void stampaOdtFromXml(String xml){
        LoggingUtils.info("INIZIO");
        //mi leggo sto cazzo di xml
        File fileXml = new File(CrmProperties.getProperty("cud.xml.temp.path")+xml);
        CUD cud = null;
        try {
            cud = (CUD) Converter.xml2Object(new CUD(),fileXml);
            File odt= new Cud().stampa(cud,xml.replace("xml","odt"));
            fileXml.delete();
            LoggingUtils.info("FINE");
            //byte[] odt= StreamerFactory.getStreamFromFile(file);
        } catch (JAXBException e) {
            LoggingUtils.error(e);
            generaErrore(xml);
        } catch (ClassNotFoundException e) {
            LoggingUtils.error(e);
            generaErrore(xml);
        } catch (IllegalAccessException e) {
            LoggingUtils.error(e);
            generaErrore(xml);
        } catch (InstantiationException e) {
            LoggingUtils.error(e);
            generaErrore(xml);
        } catch (Exception e) {
            LoggingUtils.error(e);
            generaErrore(xml);
        }
    }


    public static void generaErrore(String  codFis)
    {
        try {
            PrintWriter writer = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(CrmProperties.getProperty("cud.errori.temp.path")+ "Errori.txt",
                                    true)));

            Date date = new Date();
            writer.write(date+": "+codFis+"\n");
            writer.close();
        } catch (IOException e) {
            LoggingUtils.error(e);
        }
    }

    public void stampaTutto(){
        Facade730 f= new Facade730();
        List<String> files=f.indexhXmlFile();
        for(int i=0; i<files.size();i++){
             f.stampaOdtFromXml(files.get(i));
        }
    }

    public static void main(String args[]){
        new Facade730().stampaTutto();
       /* Facade730 f= new Facade730();
        List<String> files=f.indexhXmlFile();
        for(int i=0; i<files.size();i++){
            new Facade730().stampaOdtFromXml(files.get(i));
        }*/
    }

}
