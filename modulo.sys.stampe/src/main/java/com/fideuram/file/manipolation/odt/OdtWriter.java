package com.fideuram.file.manipolation.odt;

import com.fideuram.bean.Immagini;
import com.fideuram.costanti.Costanti;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Map;

/**
 * Created by
 * User: logan
 * Date: 22/06/11
 * Time: 16.08
 */
public class OdtWriter extends GenericWriter{

    public byte[] mergeData(byte[] template, Map map) {
         Immagini immagini =new Immagini();
         map.put("immangine",immagini);

         ByteArrayOutputStream docStream = new ByteArrayOutputStream();
         OutputStream os = null;
         File f = null;
          try {

              File tempPath = new File(CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH));
              String templateName = "template_" + System.currentTimeMillis() + ".odt";

              LoggingUtils.debug("IL SISTEMA SI APPRESTA A GENERARE IL SEGUENTE DOCUMENTO" + tempPath + "/" + templateName);

              /*
               Questo è ridondante però serve a fase e quindi forse a noi per via del fatto ke molti tmplate
               risiedeno su dbase. Siccome sto coso lo deve legge pe forza.
               */
              f = new  File(tempPath, templateName);
              os = new FileOutputStream(f);
                        LoggingUtils.debug("os" + os.toString());
                        os.write(template);
                        os.flush();
                        os.close();
			

              // Creazione factory
              DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();

              // Creazione del documento ODT
              DocumentTemplate templateODT =
                  documentTemplateFactory.getTemplate(
                          new File(tempPath, templateName));

              // Merging data
              templateODT.createDocument(map, docStream);

              //DocumentFileWriter.saveToFile(docStream.toByteArray(), tempPath, templateName);



          } catch (Exception err) {
              LoggingUtils.error(err, err);
              LoggingUtils.error(err, err.getCause());
              throw new RuntimeException(err);
          }finally{
        	  f.delete();
          }
          return    docStream.toByteArray();

    }
}
