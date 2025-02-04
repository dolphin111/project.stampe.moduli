package com.fideuram.file.io;

import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.utils.LoggingUtils;
import com.fideuram.config.CrmProperties;
import org.jdom.JDOMException;
import org.jopendocument.dom.ODSingleXMLDocument;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 24/05/13
 * Time: 11.33
 */
public class OdtMerge {
    private String dir;
    private String nomefile;


    public OdtMerge(String dir, String nomefile) {
        this.dir = dir;
        this.nomefile = nomefile;
    }

    public OdtMerge( String dir) {
        this.dir = dir;
        this.nomefile = new Date().getTime()+".odt";
    }

    public OdtMerge() {
        this.dir = CrmProperties.getProperty("crm.services.temp.path");
        this.nomefile = new Date().getTime()+".odt";
    }

   /**
    * Questo metodo provvede a mergiare due o più file odt
    * @throws DocGeneratorException
    */
    public byte[] mergeFileProdotti(List<File> fileProdotti) throws DocGeneratorException {
        byte[] documentoFinale = null;
        File root = null;

        for (File f : fileProdotti) {
            try{
                if (root == null) {
                    root = f;
                } else {
                    ODSingleXMLDocument p1 = ODSingleXMLDocument.createFromFile(root);
                    ODSingleXMLDocument p2 = ODSingleXMLDocument.createFromFile(f);
                    p1.add(p2);
                    p1.saveAs(root);
                }
            } catch (IOException e) {
                LoggingUtils.error(e);
                throw new DocGeneratorException("IOException",e);
            } catch (JDOMException e) {
                LoggingUtils.error(e);
                throw new DocGeneratorException("JDOMException",e);
            }
        }

        if (root != null) {
            try {
                documentoFinale = loadFromFile(root);
            } catch (IOException e) {
                LoggingUtils.error(e);
                throw new DocGeneratorException("IOException",e);
            }
        }
        return documentoFinale;
    }


    /**
     * @param f
     * @return
     * @throws IOException
     */
    public static byte[] loadFromFile(File f) throws IOException {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        FileInputStream is = null;

        try {
            int letti = 0;
            byte[] buf = new byte[1024];
            is = new FileInputStream(f);

            while ((letti = is.read(buf)) > -1) {
                os.write(buf, 0, letti);
            }

            os.flush();

        } catch (IOException e) {
            throw e;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {
                    LoggingUtils.warn(e, e);
                }
            }
        }

        return os.toByteArray();
    }


    public static void main(String args[]){

    }
}
