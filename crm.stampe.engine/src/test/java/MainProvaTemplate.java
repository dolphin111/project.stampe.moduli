import com.fideuram.crm.stampe.engine.DocumentFileWriter;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 05/04/11
 * Time: 12.25
 */
public class MainProvaTemplate {
    public static void main(String args[]){
        MainProvaTemplate pt = new MainProvaTemplate();
        //String xml          = CrmProperties.getProperty("a11.xml");
    	//String template     = CrmProperties.getProperty("a11.template");
    	//String documento    = CrmProperties.getProperty("crm.services.temp.out")+ "/a11_documento.odt";

        String xml          = "/develop/fidrenew/crm.stampe/crm.stampe.engine/src/test/resources/xml/b2_v2.xml";
        String template     = "/develop/fidrenew/crm.stampe/crm.stampe.engine/src/test/resources/template/b2-RiscattoTermine.odt";
        String documento    = "/tmp/b2_documento.odt";
        try {
            byte[] xmlData = pt.readData(xml);
            byte[] templateData = pt.readData(template);
         	byte[] doc = DocumentFileWriter.mergeData(templateData, new String(xmlData),"y1100");
		    FileOutputStream fout = new FileOutputStream(documento);
			fout.write(doc);
			fout.close();
        } catch (IOException e) {
			e.printStackTrace();

		}

    }


    protected byte[] readData(String path) {
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
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
    }
}
