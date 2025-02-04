package mock;


import com.fideuram.exception.TrasformazioneException;
import com.fideuram.modello.ContrattoOrigineFactory;
import com.fideuram.modello.PolizzaTrasformabile;

import java.text.ParseException;

/**
 * Created by V801068 on 20/03/14.
 */
public class From18001PR2FvFacile extends MockBasePR {
    public static PolizzaTrasformabile getMock() throws ParseException, TrasformazioneException {
        PolizzaTrasformabile polizzaTrasformabile = getTrasfomazione();
        polizzaTrasformabile.setNomeCommercialeProdottoDestinazione("Fideuram Vita Insieme Facile");
        polizzaTrasformabile.setPolizza(getPolizza());
        polizzaTrasformabile.setOrigine(ContrattoOrigineFactory.getContratto(polizzaTrasformabile.getPolizza(), 18001));
        return polizzaTrasformabile;
    }
}
