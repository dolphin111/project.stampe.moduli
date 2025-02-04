

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.fideuram.crm.stampe.engine.CrmStampeService;

/**
 * Utilizzare jdk 1.8 con compiler 1.6
 * quando si crea il pacchetto rimettere jdk 1.6
 */
public class ElaboraMessaggioTest  extends TestCase {
	
	
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(ElaboraMessaggioTest.class );
    }

    public void test(){
        try {
        	
    		new CrmStampeService().elaboraMessaggio(12893823);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }



}
