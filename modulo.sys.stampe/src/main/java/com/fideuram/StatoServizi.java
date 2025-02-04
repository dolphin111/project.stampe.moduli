package com.fideuram;

import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Created with
 * User: logan
 * Date: 03/10/13
 * Time: 9.25
 */
public class StatoServizi {
    private static Properties prop;

    public static boolean isAbilitato(int richiesta){
        if(null==prop){
            setup();
        }

        if(null!=prop.getProperty(""+richiesta))
            return true;
        else
            return false;
    }

    private static void setup()  {
        prop=new Properties();
        String fileServiziProperties = CrmProperties.getProperty("stampe.template.mapping");
        try {
            FileInputStream fis = new FileInputStream(fileServiziProperties);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            prop.load(isr);
        } catch (IOException e) {
            LoggingUtils.error("errore io <<stampe.template.mapping>>");
        }
    }

    public static void main(String args[]){
        System.out.println("");
        System.out.println("7 --- " + isAbilitato(7));
        System.out.println("16 --- " + isAbilitato(16));
        System.out.println("17 --- " + isAbilitato(17));
        System.out.println("18 --- " + isAbilitato(18));
    }
}
