import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.isvap.ProcessoFap3Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Fap3Isvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 13/02/14
 * Time: 18.43
 */
public class RendicontoIsvapFap3 {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoIsvapFap3");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ISVAP_FAP3.xml");
        Fap3Isvap fap3 = (Fap3Isvap) Converter.xml2Object(new Fap3Isvap(), file);
        byte[]  bytes = new ProcessoFap3Isvap().stampa(fap3);
     //   StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapFap3.odt");

        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapFap3.pdf");
    }


}
