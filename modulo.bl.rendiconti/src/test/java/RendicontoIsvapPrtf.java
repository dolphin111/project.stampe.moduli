import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.isvap.ProcessoFapIsvap;
import com.fideuram.processo.rendiconti.isvap.ProcessoPrtfIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.PrtfIsvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created
 * User: v801068
 * Date: 17/02/14
 * Time: 12.15
 */
public class RendicontoIsvapPrtf {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoIsvapPrtf");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ISVAP_PRTF.xml");
        PrtfIsvap prtf = (PrtfIsvap) Converter.xml2Object(new PrtfIsvap(), file);
        byte[]  bytes = new ProcessoPrtfIsvap().stampa(prtf);
      //  StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapPrtf.odt");
        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapPrtf.pdf");
    }
}
