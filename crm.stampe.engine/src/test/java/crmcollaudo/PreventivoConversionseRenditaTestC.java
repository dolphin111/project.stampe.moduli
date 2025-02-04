package crmcollaudo;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 18/03/15
 * Time: 10.45
 */
public class PreventivoConversionseRenditaTestC {
    public  static void main(String args[]) {
        new CrmStampeService().elaboraMessaggio(8226782);    //Bug 2
    }
}
