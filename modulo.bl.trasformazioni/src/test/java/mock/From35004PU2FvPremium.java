package mock;

import com.fideuram.exception.TrasformazioneException;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;

import java.text.ParseException;

/**
 * Created by V801068 on 27/03/14.
 */
public class From35004PU2FvPremium extends MockBasePU {


    public static PolizzaTrasformabile getMock() throws ParseException, TrasformazioneException {
        PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme Premium 35004");
        polizzaTrasformabile.setPolizza(getPolizza());
        polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 35004));
        return polizzaTrasformabile;
    }
}
