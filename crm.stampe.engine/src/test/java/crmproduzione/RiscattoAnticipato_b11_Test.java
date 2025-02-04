package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * User: V801068
 * Date: 07/10/14
 * Time: 11.13
 */
public class RiscattoAnticipato_b11_Test {
    public  static void main(String args[]) {
        new CrmStampeService().elaboraMessaggio(10295446);      //produzione
    }
}
