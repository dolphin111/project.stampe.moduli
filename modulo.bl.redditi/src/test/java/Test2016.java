import com.fideuram.config.CrmProperties;
import com.fideuram.exception.Cu2015Exception;
import com.fideuram.processo.FacadeCu2016;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: V801068
 * Date: 25/01/16
 * Time: 11.13
 * To change this template use File | Settings | File Templates.
 */
public class Test2016 {
    private static  String cudInput;
    public static void main(String args[]) throws IOException, Cu2015Exception {
        List<String> l = getListInputXmlFiles();
        for (int i=0;i<l.size();i++){
            String nomefile=l.get(i);
            String xml =getXmlString(new File(cudInput+nomefile));
            int anno=2016;
            new FacadeCu2016().generaCu2016(xml);
        }
    }

    /**
     * elenco dei file in input
     * @return
     */
    private static List<String> getListInputXmlFiles(){
        cudInput= CrmProperties.getProperty("cud.input");
        ArrayList<String> result = new ArrayList<String>();
        File f = new File(cudInput);
        if (f.isDirectory()) {
            String files[] = f.list();
            for (int i = 0; i < files.length; i++) {
                result.add(files[i]);
            }
        }
        return result;
    }

    private static  String getXmlString(File file) throws IOException {
        return FileUtils.readFileToString(file);
    }

}
