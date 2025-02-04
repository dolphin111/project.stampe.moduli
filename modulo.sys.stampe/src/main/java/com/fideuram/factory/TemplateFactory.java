package com.fideuram.factory;

import com.fideuram.costanti.TemplateSystem;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import com.itextpdf.text.Image;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * Created by
 * User: logan
 * Date: 10/04/13
 * Time: 17.21
 */
public class TemplateFactory {
    private static Properties prop;



    public static byte[] getTemplateFromRichiesta(int richiesta) throws TemplateLoaderExcepion {
        String nomeTemplate=getNomeTemplate(""+richiesta);
        LoggingUtils.debug("Questo sistema usa il seguente encoding: " + Charset.defaultCharset().displayName() );
        LoggingUtils.info("RICHIESTA: " + richiesta + " - TEMPLATE RICHIESTO: " + nomeTemplate);
        return TemplateLoaderFactory.getLoader().getTemplateByNome(nomeTemplate);
    }

    public static String getNomeTemplate(String key)
    {
        if(null==prop){
            setup();
        }
        String p = prop.getProperty(key);
        return p;
    }

    public static String getPathNomeTemplate(String key)
    {
        String _template     = CrmProperties.getProperty(TemplateSystem.LOCATION_TEMPLATE);
        _template     = _template.concat(getNomeTemplate(key)) ;
        return _template;
    }



    private static void setup()  {
        prop=new Properties();

        String indiceTemplates = CrmProperties.getProperty("stampe.template.mapping");
        try {
            FileInputStream fis = new FileInputStream(indiceTemplates);
            InputStreamReader isr = new InputStreamReader(fis, "UTF8");
            prop.load(isr);
        } catch (IOException e) {
            LoggingUtils.error("errore io <<stampe.template.mapping>>");
        }
    }
}
