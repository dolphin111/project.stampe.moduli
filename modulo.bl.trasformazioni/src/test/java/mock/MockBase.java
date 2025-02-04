package mock;

import com.fideuram.modello.PolizzaTrasformabile;
import com.fideuram.stampe.modello.attori.Assicurato;
import com.fideuram.stampe.modello.attori.Contraente;
import com.fideuram.stampe.modello.attori.PrivateBanker;
import com.fideuram.utils.DateUtils;

/**
 * Created by I
 * User: logan
 * Date: 12/03/13
 * Time: 11.28
 */
public class MockBase {
    protected static PolizzaTrasformabile getTrasfomazione(){
        PolizzaTrasformabile polizzaTrasformabile = new PolizzaTrasformabile();
        polizzaTrasformabile.setDecorrenza("01-01-2012");
        polizzaTrasformabile.setScadenza("01-01-2022");
        polizzaTrasformabile.setDurata("8 anni e 9 mesi");
        polizzaTrasformabile.setCanale("1");
        polizzaTrasformabile.setDataProposta(DateUtils.formatNow("dd-MM-yyyy"));
        polizzaTrasformabile.setDataNav(DateUtils.formatNow("dd-MM-yyyy"));
        polizzaTrasformabile.setNumeroSchedaTrasformazione("123456789012345");
        polizzaTrasformabile.setControvalorePolizza("123.456");
        return polizzaTrasformabile;
    }
    
    protected static Assicurato getAssicurato(){
        Assicurato assicurato = new Assicurato();
        assicurato.setNome("STEFANO");
        assicurato.setCognome("LENZI");
        return assicurato;
    }

    protected static Contraente getContraente(){
        Contraente contraente = new Contraente();
        contraente.setNome("STEFANO");
        contraente.setCognome("LENZI");
        return contraente;
    }

    protected static PrivateBanker getPrivateBanker(){
        PrivateBanker privateBanker = new PrivateBanker();
        privateBanker.setNome("LUCIANO");
        privateBanker.setCognome("NERI");
        privateBanker.setCodice("014106");
        //privateBanker.setRete("BFI");
        privateBanker.setRete("SPI");
        return privateBanker;
    }
}
