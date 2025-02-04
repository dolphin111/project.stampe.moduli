package mock;

import com.fideuram.stampe.modello.polizza.Polizza;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 21/08/15
 * Time: 14.18
 * To change this template use File | Settings | File Templates.
 */
public class MockBase001 extends MockBase {
    protected static Polizza getPolizza(){
        Polizza polizza = new Polizza();
        polizza.setNumero("7673504");
        polizza.setNomeCommercialeProdotto("Fideuram Vita Insieme Facile");
        polizza.setAssicurato(getAssicurato());
        polizza.setContraente(getContraente());
        polizza.setPrivateBanker(getPrivateBanker());
        return polizza;
    }
}
