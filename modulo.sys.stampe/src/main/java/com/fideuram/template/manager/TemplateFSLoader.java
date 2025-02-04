package com.fideuram.template.manager;

import com.fideuram.costanti.TemplateSystem;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by 
 * User: logan
 * Date: 19/12/11
 * Time: 18.53
 */
public class TemplateFSLoader extends TemplateLoader{

    public byte[] getTemplateByNome(String template) throws TemplateLoaderExcepion {
        String _template     = CrmProperties.getProperty(TemplateSystem.LOCATION_TEMPLATE);
        _template     = _template.concat(template) ;
        //LoggingUtils.info("- getTemplateByNome -> Loading: "+_template);
        try {
            byte[] _bytes =  readData(_template.trim());
            return _bytes;
        } catch (IOException e) {
            throw new TemplateLoaderExcepion("Errore di IOExeption nel loading del template : \n\n"+template +"\n\n",e);
        }
    }



    /**
     * @param path
     * @return
     */
    protected byte[] readData(String path) throws IOException {
        byte[] data = null;

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

        return data;
    }

}
