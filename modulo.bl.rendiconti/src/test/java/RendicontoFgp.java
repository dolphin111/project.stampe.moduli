import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.fgp.ProcessoFgp;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with
 * User: v801068
 * Date: 17/02/14
 * Time: 10.42
 */
public class RendicontoFgp {
    public static void main(String args[]) throws Exception {
      //      6015 = RendicontoFGP_2EQUILIBRIO.odt      */
        for (int i=0; i < 1; i++)  {
            File file = new File(CrmProperties.getProperty("crm.services.input.path")+"FGP-"+i+".xml");
            Fgp fgp = (Fgp) Converter.xml2Object(new Fgp(), file);
            byte[]  bytes = new ProcessoFgp().stampa(fgp,6011);
            StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "Fgp" +i+".odt");
        }

    }
}
