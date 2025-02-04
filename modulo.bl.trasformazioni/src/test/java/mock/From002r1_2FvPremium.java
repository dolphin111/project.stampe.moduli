package mock;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TrasformazioneException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.processo.FacadeTrasformazioni;
import com.fideuram.stampe.modello.polizza.Polizza;
import com.fideuram.utils.Streamer;

import java.text.ParseException;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 04/09/15
 * Time: 16.40
 */
public class From002r1_2FvPremium extends MockBase001 {
    public static PolizzaTrasformabile getMock(String tipoPremio) throws ParseException, TrasformazioneException {
        Polizza p= getPolizza();
        p.setTipoPremio(tipoPremio);
        PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme Premium");
        polizzaTrasformabile.setPolizza(p);
        polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 201));
        return polizzaTrasformabile;
    }

    public static void main(String args[]){
        FacadeTrasformazioni facadeTrasformazioni = new FacadeTrasformazioni();
        try {
            Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From002r1_2FvPremium.getMock("R"), 803)), CrmProperties.getProperty("crm.services.temp.path"), "From002PRed012009_FvPremium.pdf");
            Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From002r1_2FvPremium.getMock("U"), 803)), CrmProperties.getProperty("crm.services.temp.path"), "From002PUed012009_FvPremium.pdf");
        } catch (TrasformazioneException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
