package com.fideuram.file;


import com.fideuram.config.CrmProperties;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by
 * User: logan
 * Date: 06/02/13
 * Time: 8.38
 */
public class TempDir {
    public static String getTmpDirByName(String nome){
        new Timestamp(new Date().getTime()).getNanos();
        String dir= CrmProperties.getProperty("crm.services.temp.path")+"_"+nome+"_"+new Date().getTime();
        boolean success=  (new File(dir)).mkdirs();
        dir=dir+"/";
        return dir;
    }

    public static String getTmpDir(){
        return getTmpDirByName("");
    }

    public static void clean(String dir){
        File path = new File(dir);
        if( path.exists() ) {
            File[] files = path.listFiles();
            for(int i=0; i<files.length; i++) {
                if(files[i].isDirectory()) {
                    //todo
                }
                else {
                    files[i].delete();
                }
            }
        }
        path.delete();
    }
}
