package mock;

import com.fideuram.stampe.modello.polizza.Polizza;

/**
 * Created by
 * User: logan
 * Date: 12/03/13
 * Time: 11.28
 */
public class MockBasePU extends MockBase {
    protected static Polizza getPolizza(){
        Polizza polizza = new Polizza();
        polizza.setNumero("7673504");
        polizza.setNomeCommercialeProdotto("Financial Age Protection 2");
        polizza.setAssicurato(getAssicurato());
        polizza.setContraente(getContraente());
        polizza.setPrivateBanker(getPrivateBanker());
        polizza.setTipoPremio("U");
        return polizza;
    }
}
