package com.fideuram.file.io.reader;

import com.fideuram.costanti.TemplateSystem;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by
 * User: logan
 * Date: 14/06/11
 * Time: 14.12
 */
public class Reader {



       /**
        *
        * @param template
        * @return byte[]
        */
       protected byte[] getTemplate(String template) throws DocGeneratorException {
            String _template     = CrmProperties.getProperty(TemplateSystem.LOCATION_TEMPLATE);
            _template     = _template.concat(template) ;
            return readData(_template);
       }

       public byte[] loadFile(String path)throws DocGeneratorException {
           return readData(path);
       }

      /**
        * @param path
        * @return byte[]
        */
       protected byte[] readData(String path) throws DocGeneratorException {
           LoggingUtils.info("Reader.class Tento di leggere il template dal seguente Path -->: " + path);
           byte[] data = null;

           try {
               // Lettura template
               FileInputStream fin = new FileInputStream(path);
               ByteArrayOutputStream bout = new ByteArrayOutputStream();

               byte[] buf = new byte[1024];
               int letti;

               while ((letti = fin.read(buf)) > -1) {
                   bout.write(buf, 0, letti);
               }
               fin.close();

               data = bout.toByteArray();
               bout.close();

           } catch (FileNotFoundException e) {
                LoggingUtils.debug("Reader.class: File non trovato" + e.getMessage());
                throw new DocGeneratorException("Reader.class: File non trovato",e);


           } catch (IOException e) {
                LoggingUtils.debug("Reader.class: IOException" + e.getMessage());
                throw new DocGeneratorException("Reader.class: IOException e",e);
           }

           return data;
       }

}
