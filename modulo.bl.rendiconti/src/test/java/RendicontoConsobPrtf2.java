import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.consob.ProcessoPRTFConsob;
import com.fideuram.processo.rendiconti.isvap.ProcessoPrtf2Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.RtfConsob;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Prtf2Isvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created
 * User: v801068
 * Date: 17/02/14
 * Time: 12.31
 */
public class RendicontoConsobPrtf2 {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoConsobPrtf2");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"CONSOB_PRTF2.xml");
        RtfConsob prtf = (RtfConsob) Converter.xml2Object(new RtfConsob(), file);
        byte[]  bytes = new ProcessoPRTFConsob().stampa(prtf);
     //   StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "ConsobPrtf2.odt");

        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "ConsobPrtf2.pdf");
    }
}
