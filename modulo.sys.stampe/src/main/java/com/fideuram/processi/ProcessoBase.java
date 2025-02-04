package com.fideuram.processi;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.file.TempDir;
import com.fideuram.file.io.OdtMerge;
import com.fideuram.template.TemplateFinder;
import com.itextpdf.text.pdf.qrcode.ByteArray;
import org.jopendocument.dom.ODSingleXMLDocument;
import org.jopendocument.dom.OOUtils;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created
 * User: V801068
 * Date: 10/01/14
 * Time: 15.49
 */
public class ProcessoBase {
    protected String                percorso;

    public ProcessoBase() {
        percorso= TempDir.getTmpDir();
    }

    protected InputStream getTemplate(String template) throws TemplateLoaderExcepion {
        return new ByteArrayInputStream(TemplateFinder.getTemplate(template));
    }

    protected InputStream getTemplate(String lettera, String template) throws TemplateLoaderExcepion {
        File l=new File(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+lettera);
        File t=new File(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+template);
        ArrayList list=new ArrayList();
        list.add(l);
        list.add(t);
        byte [] _template=null;
        try {
              _template=new OdtMerge().mergeFileProdotti(list);
              StreamerFactory.saveFile(_template, CrmProperties.getProperty("crm.services.temp.path"), "merge.odt");
              return new ByteArrayInputStream(_template);
        } catch (DocGeneratorException e) {
            e.printStackTrace();
            throw new TemplateLoaderExcepion(e);
        } catch (Exception e) {
            throw new TemplateLoaderExcepion(e);
        }


    }
}
