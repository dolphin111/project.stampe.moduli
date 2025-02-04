package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * User: V801068
 * Date: 07/10/14
 * Time: 11.20
 */
public class PreventivoConversioneRenditaTest {
    public  static void main(String args[]) {
       // new CrmStampeService().elaboraMessaggio(8226613);    //SIMULAZIONE RENDITA  collaudo
      // new CrmStampeService().elaboraMessaggio(8226789);    //SIMULAZIONE PREMIO   collaudo
       // new CrmStampeService().elaboraMessaggio(8226787);    //PREVENTIVO DI CONVERSIONE IN RENDITA IN  COLL
       // new CrmStampeService().elaboraMessaggio(10289467);   //PREVENTIVO DI CONVERSIONE IN RENDITA IN  PROD

       // new CrmStampeService().elaboraMessaggio(10295212);   //TCK 838    IN PROD

        new CrmStampeService().elaboraMessaggio(10473974);    //Bug 2
    }
}
