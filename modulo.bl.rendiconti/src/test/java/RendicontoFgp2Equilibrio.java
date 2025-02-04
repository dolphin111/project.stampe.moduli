import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.jaxb.Converter;
import com.fideuram.processo.rendiconti.fgp.ProcessoFgp;
import com.fideuram.stampe.modello.rendiconti.prodotto.fgp.Fgp;

import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: v801092
 * Date: 24/02/15
 * Time: 15.21
 * To change this template use File | Settings | File Templates.
 */
public class RendicontoFgp2Equilibrio {
    public static void main(String args[]) throws Exception {
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"FGP2_LINEDDA.xml");
        Fgp fgp = (Fgp) Converter.xml2Object(new Fgp(), file);
        byte[]  bytes = new ProcessoFgp().stampa(fgp,6018);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "FGP2_LINEDDA.odt");
    }
}
