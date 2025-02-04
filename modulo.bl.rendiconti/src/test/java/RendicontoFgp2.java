import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.fgp.ProcessoFgp;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;
import com.fideuram.utils.LoggingUtils;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 24/02/15
 * Time: 10.00
 * To change this template use File | Settings | File Templates.
 */
public class RendicontoFgp2 {
    public static void main(String args[]) throws Exception {
        //TODO CUSTOMIZZARE UNA CHIAMATA PER OGNI TIPO DI FGP
        // 6015 = RendicontoFGP_2EQUILIBRIO.odt
        for (int i=0; i < 2; i++)  {
            File file = new File(CrmProperties.getProperty("crm.services.input.path")+"FGP2-"+i+".xml");
            Fgp fgp = (Fgp) Converter.xml2Object(new Fgp(), file);
            byte[]  bytes = new ProcessoFgp().stampa(fgp,6014);
            StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "Fgp2-"+i+".odt");
        }
    }
}
