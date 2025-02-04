package com.fideuram.factory;

import com.fideuram.utils.Streamer;

import java.io.File;
import java.io.IOException;
import java.net.URI;

/**
 * Created by
 * User: logan
 * Date: 16/04/13
 * Time: 14.58
 */
public class StreamerFactory {
    public static byte[] getStreamFromFile(File file) throws IOException {
        byte[] stream= Streamer.getFile(file.getCanonicalPath());
        return stream;
    }

    public static File  saveFile(byte[] doc, URI uri, String nomefile) throws Exception {
        return Streamer.saveToFile(doc,uri,nomefile);
    }

    public static File  saveFile(byte[] doc, String path, String nomefile) throws Exception {
        return  Streamer.saveToFile(doc,path,nomefile);
    }
}
