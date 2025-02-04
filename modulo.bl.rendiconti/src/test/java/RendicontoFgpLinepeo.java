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
 * Time: 12.00
 * To change this template use File | Settings | File Templates.
 */
public class RendicontoFgpLinepeo {
    public static void main(String args[]) throws Exception {
        File file = new File(CrmProperties.getProperty("crm.services.input.path")+"FGPLinepeo.xml");
        Fgp fgp = (Fgp) Converter.xml2Object(new Fgp(), file);
        byte[]  bytes = new ProcessoFgp().stampa(fgp,6012);
        StreamerFactory.saveFile(bytes, CrmProperties.getProperty("crm.services.temp.path"), "FgpLinepeo.odt");

    }
}
