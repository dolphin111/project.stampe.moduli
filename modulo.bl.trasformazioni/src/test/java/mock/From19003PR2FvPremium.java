package mock;

import com.fideuram.config.CrmProperties;
import com.fideuram.exception.TrasformazioneException;
import com.fideuram.factory.PdfFactory;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.processo.FacadeTrasformazioni;
import com.fideuram.utils.Streamer;

import java.text.ParseException;

/**
 * User: V801068
 * Date: 03/08/15
 * Time: 16.05
 */
public class From19003PR2FvPremium extends MockBase19PR {
        public static PolizzaTrasformabile getMock() throws ParseException, TrasformazioneException {
            PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
            polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme Premium");
            polizzaTrasformabile.setPolizza(getPolizza());
            polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 19003));
            return polizzaTrasformabile;
        }

    public static void main(String args[]){
        FacadeTrasformazioni facadeTrasformazioni = new FacadeTrasformazioni();
        try {
            Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From19003PR2FvPremium.getMock(), 803)), CrmProperties.getProperty("crm.services.temp.path"), "FvPremium19003PR.pdf");
        } catch (TrasformazioneException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
