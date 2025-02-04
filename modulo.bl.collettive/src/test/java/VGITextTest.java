import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.manager.metodiPagamento.MetodiPagamentoManager;
import com.fideuram.manager.vgitext.VGITextManager;
import com.itextpdf.text.Document;


public class VGITextTest extends TestCase {
	
	 public static Test suite() {
	        return new TestSuite(VGITextTest.class );
	    }
	 
	 public void testGenerazioneVGItext() throws CollettiveFileDataReadException, StampaCollettiveException, Exception {
	        String filename = "D://test/STANETT.2013-06-11-11.28.09.TXT";
	        File file = new File(filename);
	        //byte[] pdf = MetodiPagamentoManager.getPdfMetodiPagamento(file);
	        Document pdf = VGITextManager.print(file);
	        assertTrue(null!=pdf);
			}
		
		  public static void main(String[] args) throws CollettiveFileDataReadException, Exception {
			  VGITextTest test = new VGITextTest();
			  test.testGenerazioneVGItext();
			}


}
