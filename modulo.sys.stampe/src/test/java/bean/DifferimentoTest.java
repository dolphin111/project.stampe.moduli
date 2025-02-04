package bean;

import com.fideuram.utils.DateUtils;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Created
 * User: logan
 * Date: 23/10/13
 * Time: 9.26
 */
public class DifferimentoTest extends TestCase {
    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(DifferimentoTest.class );
    }



    /**
     * Scopo verificare che per data1   "30-12-2003" e data2 "31-12-2013"
     * il risultato sia: È MAGGIORE DI 10 ANNI.
     * @throws ParseException
     */
    public void testDiffMaggioreDi10anni() throws ParseException {
           assert DateUtils.isDateDiffMajorOfQuanto("30/12/2003", "31/12/2013", "dd-MM-yyyy", Calendar.YEAR, 10);
           //assert DateUtils.isDateDiffMajorOfQuanto("30-12-2003", "31-12-2013", "dd-MM-yyyy", Calendar.YEAR, 10);
    }

    /**
     * Scopo verificare che per data1   "2003-12-31" e data2 "2013-12-31"
     * il risultato sia: NON È MAGGIORE DI 10 ANNI.
     * La logica direbbe che siamo di un giorno oltre i dieci anni, ma così deve essere
     * @throws ParseException
     */
    public void testDiffUguale10anni() throws ParseException {
           assert !(DateUtils.isDateDiffMajorOfQuanto("2003-12-31", "2013-12-31", "yyyy-MM-dd", Calendar.YEAR, 10));
    }

    /**
     * Scopo verificare che per data1   "2003-12-31" e data2 "2013-12-29"
     * il risultato sia: NON È MAGGIORE DI 10 ANNI.
     * @throws ParseException
     */
    public void testDiffMinore10anni() throws ParseException {
           assert !(DateUtils.isDateDiffMajorOfQuanto("2003-12-31", "2013-12-29", "yyyy-MM-dd", Calendar.YEAR, 10));
    }
}
