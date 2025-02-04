package ws.converter;

import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.exception.ws.WebServiceClientException;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.file.io.reader.Reader;
import com.fideuram.pdfconverter.Converter;
import com.fideuram.pdfconverter.ConverterException;
import org.junit.Test;

/**
 * Created with
 * User: v801068
 * Date: 24/01/14
 * Time: 15.25
 */
public class ConversioneToPdfTest {
    @Test
    public void testConversione() {
        Converter converter = null;
        try {
            converter = ClientWsFactory.getInstance().getPdfConverterClient();
            byte[] pdf = converter.odt2Pdf(getStream());
            assert (converter != null);
            StreamerFactory.saveFile(pdf, CrmProperties.getProperty("crm.services.temp.path"), "EsitoTestConversioneToPDF.pdf");
        } catch (WebServiceClientException e) {
            assert false;
        } catch (ConverterException e) {
            assert false;
        } catch (Exception e) {
            assert false;
        }
    }


    private byte[] getStream() throws DocGeneratorException {
        return new Reader().loadFile(CrmProperties.getProperty("crm.stampe.system.storage.0.home") + "SO1P.odt");
    }

}
