package com.fideuram.xdocreport;

import com.fideuram.config.CrmProperties;
import com.fideuram.costanti.TemplateSystem;
import fr.opensagres.xdocreport.document.images.IImageProvider;

/**
 * Created with
 * User: logan
 * Date: 08/07/13
 * Time: 17.48
 */
public class ImageProviderFactory {


    /**
     * @param fileName     /path/nomecompleto
     * @return
     */
    public IImageProvider getImageProvider(String fileName){
        if(null==fileName)
            return new HackPathImageProvider(CrmProperties.getProperty(TemplateSystem.LOCATION_TEMPLATE)+"romulano.png");
        return new HackPathImageProvider(fileName);
    }

}
