import java.io.File;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.dao.metodiPagamento.MetodiPagamentoParseCsv;
import com.fideuram.exception.CollettiveFileDataReadException;
import com.fideuram.exception.StampaCollettiveException;
import com.fideuram.manager.metodiPagamento.MetodiPagamentoManager;
import com.fideuram.manager.tdp.TDPManagerRiepilogo;
import com.fideuram.modello.metodiPagamento.ListMetodiPagamento;
import com.fideuram.modello.metodiPagamento.MetodiPagamento;


public class MetodiPagamentoTest extends TestCase {
	
	 public static Test suite() {
	        return new TestSuite(MetodiPagamentoTest.class );
	    }
	 
	public void testGenerazioneMetodiPagamento() throws CollettiveFileDataReadException, StampaCollettiveException, Exception {
        String filename = "D://test/MANDATO_PAGAMENTO BIS.TXT";
        File file = new File(filename);
        byte[] pdf = MetodiPagamentoManager.getPdfMetodiPagamento(file);
        assertTrue(null!=pdf);
        assertTrue(pdf.length>0);
		}
	
	  public static void main(String[] args) throws CollettiveFileDataReadException, Exception {
		  MetodiPagamentoTest test = new MetodiPagamentoTest();
		  test.testGenerazioneMetodiPagamento();
		}
}
