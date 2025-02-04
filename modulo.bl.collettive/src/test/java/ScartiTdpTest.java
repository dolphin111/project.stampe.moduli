import com.fideuram.dao.tdp.TdpDao;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.manager.tdp.TDPManagerScarti;
import com.fideuram.modello.tdp.Collettive;
import com.fideuram.modello.tdp.scarti.ScartoTDP;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.IOException;


/**
 * Created by
 * User: logan
 * Date: 09/05/13
 * Time: 10.50
 */
public class ScartiTdpTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ScartiTdpTest.class );
    }

    public void testParserScarti() throws CollettiveFileDataReadException, IOException {
        String filename = "D:/test/VD101_SCARTI_130611_155550184.txt";
        TdpDao scartiDao = new TdpDao();
        File file = new File(filename);
        Collettive collettive = scartiDao.getScartoTDP(file);
        ScartoTDP scarto = collettive.getScarti().get(0);
        assertTrue(null!=scarto);
        assertTrue(scarto.getCollettiva().trim().equals("5985"));
    }

    public void testGenerazioneScartiPdf() throws CollettiveFileDataReadException, Exception {
        String filename = "D:/test/VD101_SCARTI_130611_155550184.txt";
        File file = new File(filename);
        byte[] pdf = new byte[0];
        try {
            pdf = TDPManagerScarti.getPdfScartiTDP(file);
        } catch (StampaCollettiveException e) {
            throw new CollettiveFileDataReadException(e.getMessage());
        }
        assertTrue(null!=pdf);
        assertTrue(pdf.length>0);
    }
    public static void main(String[] args) throws CollettiveFileDataReadException, Exception {
		ScartiTdpTest test = new ScartiTdpTest();
		test.testGenerazioneScartiPdf();
	}



}
