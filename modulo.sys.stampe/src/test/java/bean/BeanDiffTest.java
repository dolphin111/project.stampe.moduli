package bean;

import com.fideuram.utils.BeanDiff;
import com.fideuram.exception.ClassOriginException;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import mock.Mock;

import java.util.Enumeration;
import java.util.Hashtable;

/**
 * Created by
 * User: logan
 * Date: 15/02/12
 * Time: 18.25
 */
public class BeanDiffTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(BeanDiffTest.class );
    }

    public void testDiff()  {
        Hashtable h= null;
        try {
            h = new BeanDiff().getDiff(Mock.getM1(), Mock.getM2());
            assertTrue(h.size()>0);
            Enumeration e = h.keys();
            for (int i=0;i<h.size();i++){
                String s = e.nextElement().toString();
                System.out.print(s +" " + h.get(s));
            }
        } catch (ClassOriginException e) {
            e.printStackTrace();
        }

    }

   

}

