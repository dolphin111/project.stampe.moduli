import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.consob.ProcessoFap3Consob;
import com.fideuram.processo.rendiconti.isvap.ProcessoFap3Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.consob.Fap3Consob;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Fap3Isvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created
 * User: v801068
 * Date: 17/02/14
 * Time: 12.34
 */
public class RendicontoConsobFap3 {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoConsobFap3");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"CONSOB_FAP3.xml");
        Fap3Consob fap3 = (Fap3Consob) Converter.xml2Object(new Fap3Consob(), file);
        byte[]  bytes = new ProcessoFap3Consob().stampa(fap3);
     //   StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "ConsobFap3.odt");

        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "ConsobFap3.pdf");
    }
}
