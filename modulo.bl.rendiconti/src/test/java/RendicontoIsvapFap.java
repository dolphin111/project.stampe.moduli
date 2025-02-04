import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.isvap.ProcessoFapIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FapIsvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 17/02/14
 * Time: 12.12
 */
public class RendicontoIsvapFap {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoIsvapFap");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ISVAP_FAP.xml");
        FapIsvap fap = (FapIsvap) Converter.xml2Object(new FapIsvap(), file);
        byte[]  bytes = new ProcessoFapIsvap().stampa(fap);
        //StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapFap.odt");
        
        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapFap.pdf");
    }
}
