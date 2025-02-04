package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 07/10/14
 * Time: 11.17
 * To change this template use File | Settings | File Templates.
 */
public class RiscattiTest {
    public  static void main(String args[]) {
        new CrmStampeService().elaboraMessaggio(8226622);   //riscatto TOTALE collaudo
        new CrmStampeService().elaboraMessaggio(8226619);   //riscatto PARZIALE collaudo
    }
}
