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
 * Time: 16.58
 * To change this template use File | Settings | File Templates.
 */
public class From002r2_2FvInsieme extends MockBase001 {
    public static PolizzaTrasformabile getMock(String tipoPremio) throws ParseException, TrasformazioneException {
        Polizza p= getPolizza();
        p.setTipoPremio(tipoPremio);
        PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme Facile");
        polizzaTrasformabile.setPolizza(p);
        polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 202));
        return polizzaTrasformabile;
    }

    public static void main(String args[]){
        FacadeTrasformazioni facadeTrasformazioni = new FacadeTrasformazioni();
        try {
            Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From002r2_2FvInsieme.getMock("R"), 801)), CrmProperties.getProperty("crm.services.temp.path"), "From002PRed012010FvInsieme.pdf");
            Streamer.saveToFile(PdfFactory.getPdfFromOdt(facadeTrasformazioni.elaboraTrasformazioneCanaleFV(From002r2_2FvInsieme.getMock("U"), 801)), CrmProperties.getProperty("crm.services.temp.path"), "From002PUed012010FvInsieme.pdf");
            
            System.out.println("Fine");
            
        } catch (TrasformazioneException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
