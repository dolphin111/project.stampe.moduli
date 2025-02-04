import com.fideuram.dao.tdp.TdpDao;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.manager.tdp.TDPManagerRiepilogo;
import com.fideuram.modello.tdp.Collettive;
import com.fideuram.modello.tdp.elaborati.RiepilogoTDP;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.File;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * User: logan
 * Date: 10/05/13
 * Time: 12.13
 * To change this template use File | Settings | File Templates.
 */
public class RiepilogoTdpTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(RiepilogoTdpTest.class );
    }

    public void testParserRiepilogo() throws CollettiveFileDataReadException, IOException {
        String filename = "D://test/VD101_RIEPILOGO_130529_161449505.txt";
        TdpDao tdpDao = new TdpDao();
        File file = new File(filename);
        Collettive collettive = tdpDao.getRiepilogoTDP(file);
        RiepilogoTDP riepilogoTDP = collettive.getRiepiloghi().get(0);
        assertTrue(null!=riepilogoTDP);
        assertTrue(riepilogoTDP.getCollettiva().trim().equals("5985"));
    }

    public void testGenerazioneRiepilogoPdf() throws CollettiveFileDataReadException, StampaCollettiveException, Exception {
        String filename = "D://test/VD101_RIEPILOGO_130529_161449505.txt";
        File file = new File(filename);
        byte[] pdf = TDPManagerRiepilogo.getPdfRiepilogoTDP(file);
        assertTrue(null!=pdf);
        assertTrue(pdf.length>0);
    }
    
    public static void main(String[] args) throws CollettiveFileDataReadException, Exception {
    	RiepilogoTdpTest test = new RiepilogoTdpTest();
		test.testGenerazioneRiepilogoPdf();
	}

}
