package mock;

import com.fideuram.stampe.modello.polizza.Polizza;

/**
 * User: V801068
 * Date: 05/08/15
 * Time: 10.27
 */
public class MockBase19PR extends MockBase {
    protected static Polizza getPolizza(){
        Polizza polizza = new Polizza();
        polizza.setNumero("7673504");
        polizza.setNomeCommercialeProdotto("Financial Age Protection Alta Fedeltà");
        polizza.setAssicurato(getAssicurato());
        polizza.setContraente(getContraente());
        polizza.setPrivateBanker(getPrivateBanker());
        polizza.setTipoPremio("R");
        return polizza;
    }
}
