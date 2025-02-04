package com.fideuram.utils;

import org.apache.commons.codec.binary.Base64;

import java.io.IOException;

/**
 * Created by
 * User: logan
 * Date: 05/12/12
 * Time: 11.44
 */
public class Base64EncodeImage {

    public static String encodeImage(byte[] imageByteArray){
        return Base64.encodeBase64String(imageByteArray);
    }
    
    public static byte[] decodeImage(String imageDataString){
        return Base64.decodeBase64(imageDataString);
    }
    
    
    public static void main(String args[]) throws IOException {
        byte[] img=Streamer.getFile("/tmp/x.png");
        String stringaccia = encodeImageHtml(img);
        System.out.println(stringaccia);
    }

    public static String encodeImageHtml(byte[] imageByteArray){
        String html="<img alt=\"\" src=\"data:image/png;base64,";
        html=html+ Base64.encodeBase64String(imageByteArray);
        html=html+ "\"/>";
        return html;
    }
}
