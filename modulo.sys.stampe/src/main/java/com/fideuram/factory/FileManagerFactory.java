package com.fideuram.factory;

import com.fideuram.exception.ConfigurationDirecotryException;
import com.fideuram.exception.crm.DocGeneratorException;
import com.fideuram.file.io.FileManager;
import com.fideuram.file.io.OdtMerge;

import java.io.File;
import java.util.List;

/**
 * Created with
 * User: logan
 * Date: 13/05/13
 * Time: 18.33
 */
public class FileManagerFactory {
    public static File[] getFileFromDir(String dir) throws ConfigurationDirecotryException {
        return FileManager.getFiles(dir);
    }

    public static byte[] mergeOdtFiles(List<File> files) throws DocGeneratorException {
        OdtMerge odtMerge = new OdtMerge();
        return odtMerge.mergeFileProdotti(files);
    }
}
