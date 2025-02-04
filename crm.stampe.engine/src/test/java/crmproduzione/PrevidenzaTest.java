package crmproduzione;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * Created by V801068 on 07/05/14.
 */
public class PrevidenzaTest {
    public  static void main(String args[]) {
        new CrmStampeService().elaboraMessaggio(10152058);
    }
}
