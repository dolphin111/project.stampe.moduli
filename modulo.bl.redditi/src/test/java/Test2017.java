
import com.fideuram.config.CudProperties;
import com.fideuram.exception.Cu2015Exception;
import com.fideuram.processo.FacadeCu2017;

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
public class Test2017 {
    private static  String cudInput;
    public static void main(String args[]) throws IOException, Cu2015Exception {
    	System.out.println("Inizio");
        List<String> l = getListInputXmlFiles();
        System.out.println("1");
        for (int i=0;i<l.size();i++){
            System.out.println("dentro for");
            String nomefile=l.get(i);
            System.out.println("nome file " + nomefile);

            String xml =getXmlString(new File(cudInput+nomefile));
            new FacadeCu2017().generaCu2017(xml);
            
            System.out.println("Fine");
        }
    }

    /**
     * elenco dei file in input
     * @return
     */
    private static List<String> getListInputXmlFiles(){
    	System.out.println("prop "+ CudProperties.getProperty("cud.input"));
        cudInput= CudProperties.getProperty("cud.input");
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
