package com.fideuram.bean;

import com.fideuram.config.CrmProperties;
import com.fideuram.xdocreport.ImageProviderFactory;
import fr.opensagres.xdocreport.document.images.IImageProvider;

/**
 * Created by V801068 on 14/04/14.
 */
public class Immagini {
    @Deprecated private IImageProvider piedino;              //COLORI
    private IImageProvider piedinoBiancoNero;
    private IImageProvider piedinoColore;
    private IImageProvider firma;
    private IImageProvider logoIndirizzoPal;
    private IImageProvider logoIndirizzoBN;

    @Deprecated
    public IImageProvider getPiedino() throws Exception {
        if(null==piedino)
            //piedino= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+"piedino.jpg");
            //piedino= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images.loghi")+"piedino.png");
            piedino= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images")+"piedino.colore.png");
        return piedino;
    }

    public IImageProvider getPiedinoBiancoNero() throws Exception {
        if(null==piedinoBiancoNero)
            //piedino= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+"piedino.jpg");
            //piedino= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images.loghi")+"piedinoBN.png");
            piedinoBiancoNero= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images")+"piedino.png");
        return piedinoBiancoNero;
    }

    public IImageProvider getPiedinoColore() {
        if(null==piedinoColore)
            piedinoColore= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images")+"piedino.colore.png");
        return piedinoColore;
    }

    public IImageProvider getFirma() throws Exception {
        if(null==firma)
            //firma= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("crm.stampe.system.storage.0.home")+"firma.png");
            firma= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images")+"firmafrance.png");
        return firma;
    }

    public IImageProvider getLogoIndirizzoPal() throws Exception {
        if(null==logoIndirizzoPal)
            logoIndirizzoPal= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images")+"logoIndirizzo.png");
        return logoIndirizzoPal;
    }

    public IImageProvider getLogoIndirizzoBN() throws Exception {
        if(null==logoIndirizzoBN)
            //logoIndirizzoBN= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images.loghi")+"logoIndirizzoBN.png");
            logoIndirizzoBN= new ImageProviderFactory().getImageProvider(CrmProperties.getProperty("stampe.fs.images")+"logoIndirizzoBN.png");
        return logoIndirizzoBN;
    }


}
