package com.fideuram.xdocreport;

import com.fideuram.config.CrmProperties;
import com.fideuram.factory.StreamerFactory;
import com.fideuram.utils.LoggingUtils;
import fr.opensagres.xdocreport.document.images.IImageProvider;

import java.io.File;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: v801068
 * Date: 16/01/14
 * Time: 11.13
 */
public class CostruttoreImmagini {
    /**
     *
     * @param grafico
     * @return
     * @throws Exception
     */
    /*public IImageProvider getImageProvider(byte[] grafico) throws Exception {
        if(null==grafico)
            return new ImageProviderFactory().getImageProvider(null);
        String pathfile= CrmProperties.getProperty("crm.services.temp.path");
        String filename=new Date().getTime()+".png";
        StreamerFactory.saveFile(grafico, pathfile, filename);
        IImageProvider i= new ImageProviderFactory().getImageProvider(pathfile+filename);
        return i;
    }*/

    public IImageProvider getImageProvider(byte[] grafico) throws Exception {
       return getImageProvider(grafico,CrmProperties.getProperty("crm.services.temp.path"));
    }

    public IImageProvider getImageProvider(byte[] grafico, String path) throws Exception {
        if(null==grafico)
            return new ImageProviderFactory().getImageProvider(null);
        String filename=new Date().getTime()+".png";
        File f = StreamerFactory.saveFile(grafico, path, filename);
        //IImageProvider i= new ImageProviderFactory().getImageProvider(path+filename);
        IImageProvider i= new ImageProviderFactory().getImageProvider(f.getCanonicalPath());
        return i;
    }
}
