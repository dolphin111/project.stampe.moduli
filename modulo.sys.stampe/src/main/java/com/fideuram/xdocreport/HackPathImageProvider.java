package com.fideuram.xdocreport;

import fr.opensagres.xdocreport.core.document.ImageFormat;
import fr.opensagres.xdocreport.document.images.AbstractInputStreamImageProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by
 * User: logan
 * Date: 11/06/12
 * Time: 12.32
 */
public class HackPathImageProvider extends AbstractInputStreamImageProvider {

    private final String resourceName;
    private final ImageFormat imageFormat;


    public HackPathImageProvider(String resourceName) {
        super(false);
        this.resourceName = resourceName;
        this.imageFormat = ImageFormat.getFormatByResourceName(resourceName);
    }

    @Override
    protected InputStream getInputStream() throws IOException {
        return new FileInputStream(resourceName);
    }

    public ImageFormat getImageFormat() {
        return imageFormat;
    }

}