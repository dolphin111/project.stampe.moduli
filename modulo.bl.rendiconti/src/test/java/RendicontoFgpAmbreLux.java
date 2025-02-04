import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.fgp.ProcessoFgp;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 25/02/15
 * Time: 11.58
 * To change this template use File | Settings | File Templates.
 */
public class RendicontoFgpAmbreLux {
    public static void main(String args[]) throws Exception {
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"FGPAmbre.xml");
        Fgp fgp = (Fgp) Converter.xml2Object(new Fgp(), file);
        byte[]  bytes = new ProcessoFgp().stampa(fgp,6017);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "FGPAmbre.odt");

        file = new File(CrmProperties.getProperty("crm.services.input.path")+"FGPLux.xml");
        fgp = (Fgp) Converter.xml2Object(new Fgp(), file);
        bytes = new ProcessoFgp().stampa(fgp,6017);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "FGPLux.odt");
    }
}
