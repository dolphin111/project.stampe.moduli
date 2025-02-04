import com.fideuram.config.CrmProperties;
import com.fideuram.crm.stampe.serviceclient.ClientWsFactory;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.ante.ProcessoAnte551Fulaa;
import com.fideuram.processo.rendiconti.ante.ProcessoAnte551Prtf;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Fulaa;
import com.fideuram.stampe.modello.rendiconti.prodotto.ante551.Prtf;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 14/02/14
 * Time: 18.39
 */
public class RendicontoAnte551Prtf {
    public static void main(String args[]) throws Exception {
        LoggingUtils.info("RendicontoAnte551Prtf");
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"ANTE551_PRTF.xml");
        Prtf prtf = (Prtf) Converter.xml2Object(new Prtf(), file);
        byte[]  bytes = new ProcessoAnte551Prtf().stampa(prtf);
    //    StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "Ante551Prtf.odt");

        //Convertito in pdf
        bytes = ClientWsFactory.getInstance().getPdfConverterClient().odt2Pdf(bytes);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "Ante551Prtf.pdf");
    }
}
