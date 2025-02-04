package ws.stampe.rendiconti;

import com.fideuram.crm.stampe.ServiceLocator;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.stampeservice.Risposta;
import com.fideuram.stampeservice.Stampe;
import com.fideuram.stampeservice.TrasportBean;
import com.fideuram.utils.LoggingUtils;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * User: V801068
 * Date: 13/02/15
 * Time: 9.59
 */
public class RendicontiCustomMassivoTest extends TestCase {

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RendicontiCustomMassivoTest.class );
    }

    public void testWorkInputList() throws IOException {
        String input= "C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Anomalie\\rendiconti\\input\\";
        ArrayList<String> l = new ArrayList<String>();
        File f = new File(input);
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                l.add(files[i]);
            }
        }
        for (int i=0;i<l.size();i++){
            String nomefile=l.get(i);
            String xml =getXmlString(new File(input+nomefile));
            TrasportBean trasportBean=new TrasportBean();
            trasportBean.setAction("6016");
            trasportBean.setXml(xml);
            try {
                Stampe Stampe=new ServiceLocator().getStampe();
                //Risposta r =Stampe.generatePdf(trasportBean);
                Risposta r =Stampe.generateOdt(trasportBean);
                //assertNotNull(r.getStreams());
                //assertTrue(r.getStreams().get(0).length > 1000);
                StreamerFactory.saveFile(r.getStreams().get(0), "C:\\Users\\v801068\\Dropbox\\Public\\Fideuram\\TEMP\\Anomalie\\rendiconti\\output\\", nomefile + ".odt");
            } catch (Exception e) {
                assert false;
                LoggingUtils.error(e);
            }
        }
    }

    private String getXmlString(File file) throws IOException {
        return FileUtils.readFileToString(file);
    }
}
