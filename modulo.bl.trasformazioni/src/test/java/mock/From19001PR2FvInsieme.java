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
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 03/08/15
 * Time: 17.16
 */
public class From19001PR2FvInsieme extends MockBase19PR {
    public static PolizzaTrasformabile getMock() throws ParseException, TrasformazioneException {
        PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme");
        polizzaTrasformabile.setPolizza(getPolizza());
        polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 19001));
        return polizzaTrasformabile;
    }


    public static void main(String args[]){
        FacadeTrasformazioni facadeTrasformazioni = new FacadeTrasformazioni();
        try {
            Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From19001PR2FvInsieme.getMock(), 801)), CrmProperties.getProperty("crm.services.temp.path"), "FvInsieme19001PR.pdf");
        } catch (TrasformazioneException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
