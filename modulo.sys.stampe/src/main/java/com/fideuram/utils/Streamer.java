package com.fideuram.utils;

import java.io.*;
import java.net.URI;

/**
 * Created by
 * User: logan
 * Date: 25/09/12
 * Time: 14.44
 */
public class Streamer {
    public static byte[] getFile(String file) throws IOException {
        FileInputStream fin = new FileInputStream(file);
        return getByteArray(fin);
    }

    /**
     * @param fin
     * @return
     * @throws java.io.IOException
     */
    public static byte[] getByteArray(FileInputStream fin) throws IOException {
        byte[] data = null;
        try {
            // Lettura template
            ByteArrayOutputStream bout = new ByteArrayOutputStream();

            byte[] buf = new byte[1024];
            int letti;

            while ((letti = fin.read(buf)) > -1) {
                bout.write(buf, 0, letti);
            }
            fin.close();

            data = bout.toByteArray();
            bout.close();

        } catch (IOException e) {
            throw new IOException("Reader.class: IOException e",e);
        }

        return data;

    }


    public static File saveToFile(byte[] stream, String path, String nomefile) throws Exception {
        File out = new File( path+ nomefile);
        return save2file(stream,out);
    }

    public static File saveToFile(byte[] stream, URI uri, String nomefile) throws Exception {
        File out = new File(  uri.getPath()+ nomefile);
        return save2file(stream, out);
    }

    private static File save2file(byte[] stream,File out) throws Exception {
        FileOutputStream os = null;
        try {
            os = new FileOutputStream(out);
            os.write(stream);
            os.flush();
        } catch (Throwable t) {
            throw new Exception("CICCIO NUN FUNZIONA QUALCOSA"+ t.getMessage());
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (Exception e) {
                	LoggingUtils.error(e.getMessage());
                	os = null;
                }
            }
        }
        return out;
    }
    
    public static void main(String args[]){
        try {
            byte[] b =Streamer.getFile("/develop/Fideuram/out/tmp/bla.jpg");
            String s = Base64EncodeImage.encodeImage(b);
            saveToFile(b, new URI("/tmp/"), "prova.png");
            

           System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

   
}
