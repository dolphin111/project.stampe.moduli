import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.isvap.ProcessoFaoIsvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.FaoIsvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 17/02/14
 * Time: 12.18
 */
public class RendicontoIsvapFao {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoIsvapFao");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ISVAP_FAO.xml");
        FaoIsvap fao = (FaoIsvap) Converter.xml2Object(new FaoIsvap(), file);
        byte[]  bytes = new ProcessoFaoIsvap().stampa(fao);
     //   StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapFao.odt");


        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "IsvapFao.pdf");
    }
}
