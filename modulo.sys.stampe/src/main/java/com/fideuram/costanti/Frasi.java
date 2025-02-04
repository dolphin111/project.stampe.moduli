package com.fideuram.costanti;

import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import java.io.*;
import java.util.Properties;

/**
 * Created by
 * User: logan
 * Date: 23/10/12
 * Time: 14.27
 */
public class Frasi {
    private static Properties prop;


    public static String getFrase(String key) 
    {
        if(null==prop){
            setup();
        }
        String p = prop.getProperty(key);
        return p;
    }

    private static void setup()  {
        prop=new Properties();

        String fileFrasi = CrmProperties.getProperty("stampe.frasi.file");
        try {
            FileInputStream fis = new FileInputStream(fileFrasi);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            prop.load(isr);
            //prop.load(fis);
        } catch (IOException e) {
            LoggingUtils.debug("errore io <<frasi.properties>>");
        }
    }
    
    
    public static  void main(String args[]){
        prop=new Properties();
        String fileFrasi = CrmProperties.getProperty("stampe.frasi.file");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(fileFrasi);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            prop.load(isr);
            System.out.print(prop.getProperty("grafici.suc.1"));
        } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
