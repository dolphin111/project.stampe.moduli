/**
 * 
 */
package com.fideuram.crm.stampe.engine;

import com.fideuram.costanti.Costanti;
import com.fideuram.crm.stampe.model.Modello;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.utils.StringUtils;
import com.fideuram.config.CrmProperties;
import net.sf.jooreports.templates.DocumentTemplate;
import net.sf.jooreports.templates.DocumentTemplateFactory;

import java.io.*;
import java.util.Map;

/**
 * @author Giorgio Desideri
 *
 */
public class DocumentFileWriter {

	/**
	 * @param template
	 * @param data
	 * 
	 * @return
	 */
	public static byte[] mergeData(byte[] template, String data, String tripletta) {
        ByteArrayOutputStream docStream = new ByteArrayOutputStream();
        File fTemplate = null;
        File fXml = null;
        try {
            File tempPath = new File(CrmProperties.getProperty(Costanti.CRM_SERVICES_TEMP_PATH));
            String templateName = "template_" + System.currentTimeMillis() + ".odt";
            fTemplate = new File(tempPath, templateName);
            OutputStream os = new FileOutputStream(fTemplate);
            os.write(template);
            os.flush();
            os.close();

            String xmlName = StringUtils.replaceString(templateName, "odt", "xml");
            fXml = new File(tempPath, xmlName);
            OutputStream osXml = new FileOutputStream(fXml);
            osXml.write(data.getBytes());
            osXml.flush();
            osXml.close();

            // Deserialize oggetto
            Map<String, Object> map = Modello.fromXml(data);


            System.out.println(tempPath + "/" + templateName);

            // Creazione factory
            DocumentTemplateFactory documentTemplateFactory = new DocumentTemplateFactory();
            
            // Creazione del documento ODT
            DocumentTemplate templateODT = 
            	documentTemplateFactory.getTemplate(
            			new File(tempPath, templateName));

            // Merging data
            templateODT.createDocument(map, docStream);
            if("true".equals(CrmProperties.getProperty(Costanti.CRM_STAMPE_TEST))) {
                new File(tempPath, templateName);
            } else   {
                (new File(tempPath, templateName)).delete();
            }

        } catch (Exception err) {
           	LoggingUtils.error(err, err);
        	LoggingUtils.error(err, err.getCause());
            throw new RuntimeException(err);
        }finally{
        	fTemplate.delete();
        	fXml.delete();
        }

        return docStream.toByteArray();
    }
	
}
