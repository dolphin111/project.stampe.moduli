import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.ante.ProcessoAnte551Fao;
import com.fideuram.processo.rendiconti.isvap.ProcessoFap3Isvap;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fao;
import com.fideuram.stampe.modello.rendiconti.prodotto.isvap.Fap3Isvap;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 14/02/14
 * Time: 18.39
 */
public class RendicontoAnte551Fao {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoAnte551Fao");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ANTE551_FAO.xml");
        Fao fao = (Fao) Converter.xml2Object(new Fao(), file);
        byte[]  bytes = new ProcessoAnte551Fao().stampa(fao);
      //  StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "Ante551Fao.odt");

        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "Ante551Fao.pdf");
    }
}
