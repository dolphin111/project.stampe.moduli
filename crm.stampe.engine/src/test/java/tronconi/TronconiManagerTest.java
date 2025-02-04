package tronconi;

import com.fideuram.crm.vo.TronconeVO;
import com.fideuram.iside.IsideResponce;
import com.fideuram.stampe.dao.tronconi.TronconiManagaer;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * User: V801068
 * Date: 08/04/15
 * Time: 12.24
 */
public class TronconiManagerTest  extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(TronconiManagerTest.class );
    }

    public void testReplace(){
        try {
            TronconiManagaer t = new TronconiManagaer();
            Map<String, String> test= t.getMapTronconi("90",getMOck());
            assertTrue(test.containsKey("SituazPremiTotalePremi"));
            assertTrue(test.get("SituazPremiTotalePremi").contains("netti"));
            assertFalse(test.get("SituazPremiTotalePremi").contains("lordi"));
            assertTrue(test.containsKey("ProvaKeDeveRimanereInrtonsa"));
            assertTrue(test.get("ProvaKeDeveRimanereInrtonsa").contains("lordi"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static List<TronconeVO> getMOck(){
        List<TronconeVO> tronconeVOs= new ArrayList<TronconeVO>();
        TronconeVO vo1 =new TronconeVO();
        vo1.setNomeTroncone("SituazPremiTotalePremi");
        vo1.setFrase("Totale premi lordi complessivamente....");
        tronconeVOs.add(vo1);

        TronconeVO vo2 =new TronconeVO();
        vo2.setNomeTroncone("SituazPremiTotalePremiDataLiquidazione");
        vo2.setFrase("Totale premi lordi complessivamente corrisposti fino alla data di riferimento (data di liquidazione)...");
        tronconeVOs.add(vo2);

        TronconeVO vo3 =new TronconeVO();
        vo3.setNomeTroncone("ProvaKeDeveRimanereInrtonsa");
        vo3.setFrase("Totale premi lordi complessivamente corrisposti fino alla data di riferimento (data di liquidazione)...");
        tronconeVOs.add(vo3);
        return tronconeVOs;
    }
}
