import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.isvap.ProcessoPrtf2Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Prtf2Isvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created
 * User: v801068
 * Date: 17/02/14
 * Time: 12.29
 */
public class RendicontoIsvapPrtf2 {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoIsvapPrtf2");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ISVAP_PRTF2.xml");
        Prtf2Isvap prtf = (Prtf2Isvap) Converter.xml2Object(new Prtf2Isvap(), file);
        byte[]  bytes = new ProcessoPrtf2Isvap().stampa(prtf);
     //   StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapPrtf2.odt");

        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapPrtf2.pdf");
    }
}
