package mock;

import com.fideuram.exception.TrasformazioneException;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;

import java.text.ParseException;

/**
 * Created by
 * User: logan
 * Date: 12/03/13
 * Time: 12.34
 */
public class From18005PR2FvInsieme extends MockBasePR {

    public static PolizzaTrasformabile getMock() throws ParseException, TrasformazioneException {
        PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme");
        polizzaTrasformabile.setPolizza(getPolizza());
        polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 18005));
        return polizzaTrasformabile;
    }
}
