package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * Created by V801068 on 07/05/14.
 */
public class ValorePrestitoTest {
    public  static void main(String args[]) {
        new CrmStampeService().elaboraMessaggio(10310112);  //produzione
        //new CrmStampeService().elaboraMessaggio(9914912);   //produzione
        //new CrmStampeService().elaboraMessaggio(8226617);   //collaudo     //va in errore su lettera decupito!!! Cosa ci entra?
    }
}
