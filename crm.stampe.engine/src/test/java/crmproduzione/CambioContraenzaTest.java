package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * User: V801068
 * Date: 07/10/14
 * Time: 11.23
 */
public class CambioContraenzaTest {
    public  static void main(String args[]) {
        new CrmStampeService().elaboraMessaggio(10205841);   //produzione
    }
}
