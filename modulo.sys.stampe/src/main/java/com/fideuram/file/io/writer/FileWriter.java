package com.fideuram.file.io.writer;

import com.fideuram.exception.crm.DocGeneratorException;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * Created by
 * User: logan
 * Date: 21/06/12
 * Time: 14.17
 */
public class FileWriter {

    public static File saveToFile(byte[] stream, URI uri, String nomefile) throws DocGeneratorException {
        File out = new File(  uri.getPath()+ nomefile);
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(out);
            os.write(stream);
            os.flush();
        } catch (Throwable t) {
            throw new DocGeneratorException("CICCIO NUN FUNZIONA QUALCOSA"+ t.getMessage());
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                }
            }
        }
        return out;
    }
}
