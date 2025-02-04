package com.fideuram;

import com.fideuram.exception.TemplateLoaderExcepion;
import com.fideuram.template.manager.TemplateFSLoader;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URI;

/**
 * Created by
 * User: logan
 * Date: 18/01/12
 * Time: 11.02
 */
public class TemplateLoaderTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TemplateLoaderTest.class );
    }


    public void testLoadTemplate() throws TemplateLoaderExcepion {
        TemplateFSLoader tl = new TemplateFSLoader();
        byte [] template = tl.getTemplateByNome("B11_4538.odt");
        assertNotNull(template);
        try {
            saveToFile(template, new URI("/tmp/"),"B11_4538.odt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static File saveToFile(byte[] stream, URI uri, String nomefile) throws  Exception {

        File out = new File( uri + nomefile);

        FileOutputStream os = null;

        try {
            os = new FileOutputStream(out);
            os.write(stream);
            os.flush();

        } catch (Throwable t) {
            throw new Exception("CICCIO NUN FUNZIONA QUALCOSA"+ t.getMessage());

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
