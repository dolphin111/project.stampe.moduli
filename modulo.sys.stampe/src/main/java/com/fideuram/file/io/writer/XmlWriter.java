package com.fideuram.file.io.writer;

import com.fideuram.costanti.Costanti;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.StringUtils;
import com.fideuram.config.CrmProperties;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by
 * User: logan
 * Date: 22/06/11
 * Time: 16.16
 */
public class XmlWriter {

    public static void scriviStoXml(String data, String tripletta) throws IOException {
         File tempPath = new File(CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH));
         String xmlName = StringUtils.replaceString(tripletta, "_"+System.currentTimeMillis(), ".xml");

         OutputStream osXml = new FileOutputStream(new File(tempPath, xmlName));
                  osXml.write(data.getBytes());
                  LoggingUtils.debug("template" + data);
                  osXml.flush();
                  osXml.close();
    }

    public static void scriviStoXml(String data, String xmlName, String path) throws IOException {
        File tempPath = new File(path);
        OutputStream osXml = new FileOutputStream(new File(tempPath, xmlName));
        osXml.write(data.getBytes());
        LoggingUtils.debug("Salvo XML" + xmlName);
        osXml.flush();
        osXml.close();
    }
}
