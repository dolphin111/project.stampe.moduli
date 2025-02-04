package ws.proxy.pdf;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.pdfconverter.Converter;
import com.fideuram.pdfconverter.ConverterException;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created with
 * User: v801068
 * Date: 24/01/14
 * Time: 15.20
 */
public class PdfConverter {
    @Test
    public void testProxy() {
        Converter converter= null;
        try {
            converter =   ClientWsFactory.getInstance().getPdfConverterClient();
        } catch (WebServiceClientException e) {
            assert false;
        }
        assert(converter != null);
    }

    @Test
    public void testConversione(){
        File file=new File("C:\\Stampe\\out\\cud\\odt\\FCCLLD42E17C236X.odt");
        Converter converter= null;
        try {
            converter =   ClientWsFactory.getInstance().getPdfConverterClient();
            byte[] odt= StreamerFactory.getStreamFromFile(file);
            byte[] pdf= converter.odt2Pdf(odt);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"),"testConversione.pdf");
        } catch (WebServiceClientException e) {
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (ConverterException e) {
            assert false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
