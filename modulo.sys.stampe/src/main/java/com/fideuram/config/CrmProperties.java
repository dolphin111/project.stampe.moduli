package com.fideuram.config;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import java.io.*;
import java.lang.reflect.Method;
import java.security.Key;
import java.util.Properties;

/**
 * @author Giuseppe Luciani
 * @author Giorgio Desideri
 *
 */
@SuppressWarnings("restriction")
public final class CrmProperties {
	
    private static Properties props = null;
    private static final String STRING_3DES = "{3DES}";

    public static void resetProperty(){
        if(props!=null)
            props=null;
    }

    /**
     * @param name
     * @return
     */
    public static String getProperty(String name) {
        if ((props == null)||(props.size()==0)) {
            loadProperties();
        }

        String val = props.getProperty(name);
        
        if (val != null && val.startsWith(STRING_3DES)) {
            String copy = val.substring(STRING_3DES.length());
            val = decrypt(copy);
        }
        return val;

    }
    /**
     * @param msg
     * @param e
     */
    private static void log(String msg, Throwable e) {
        try {
            Class<?> logging = Class.forName("com.fideuram.utils.LoggingUtils");
            Method m = logging.getMethod("error", String.class, Throwable.class);
            m.invoke(null, msg, e);
        } catch(Exception err) {
            if (msg != null) System.out.println(msg);
            if (e != null) e.printStackTrace();
        }
    }

    /**
     * 
     */
    private static void loadProperties() {
        props = new Properties();
        String pf=System.getProperty("crm.config.file");
        //if(System.getProperty("stampe.home")!=null){
        //   System.out.print("STAMPE.HOME !=NULL");
        //   pf = System.getProperty("stampe.home")+"/config/crm-config.properties";
        //}else{
        //   System.out.print("STAMPE.HOME ==NULL");
           //pf = System.getProperty("crm.config.file");
        //}
        System.out.print("Il file di config e': " + pf + "\n");
        //String pf = System.getProperty("crm.config.file");
        //String pf = System.getenv("STAMPE_HOME")+"/config/crm-config.properties";
        // - todo x betaProd scegli Questa - String pf = System.getProperty("stampe.home")+"/config/crm-config.properties";
        InputStream is = null;
        try {
            is = new FileInputStream(pf);
            props.load(is);
            is.close();
        } catch (FileNotFoundException e) {
            log("File di configurazione '" + pf + "' non trovato", e);
        } catch(IOException err) {
            log("Errore nel caricamento del file di configurazione '" + pf + "'", err);
        }
    }

    /**
     * @param encrypted
     * @return
     */
    private static String decrypt(String encrypted) {
        String result = null;
        Key key;
        try {
            key = getKey();

            Cipher cipher = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);

            BASE64Decoder decoder = new BASE64Decoder();
            byte[] raw = decoder.decodeBuffer(encrypted);
            byte[] stringBytes = cipher.doFinal(raw);

            result = new String(stringBytes, "UTF8");
        } catch (Exception e) {
            log(e.getMessage(), e);
        }

        return result;
    }

    /**
     * @param clear
     * @return
     */
    private static String encrypt(String clear) {
        String result = null;
        Key key;
        try {
            key = getKey();

            Cipher cipher = Cipher.getInstance("DESEDE/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] stringBytes = clear.getBytes("UTF8");
            byte[] raw = cipher.doFinal(stringBytes);
            BASE64Encoder encoder = new BASE64Encoder();

            result = encoder.encode(raw);
        } catch (Exception e) {
            log(e.getMessage(), e);
        }

        return result;
    }

    /**
     * @return
     * @throws Exception
     */
    private static Key getKey() throws Exception {
        Key key = null;
        InputStream is = (new CrmProperties()).getClass().getClassLoader().getResourceAsStream("crm.key");
        ObjectInputStream in = new ObjectInputStream(is);
        key = (Key) in.readObject();
        in.close();
        is.close();
        return key;
    }

//    private static void generateKey() throws Exception {
//        KeyGenerator generator = KeyGenerator.getInstance("DESEDE");
//        generator.init(new SecureRandom());
//        Key key = generator.generateKey();
//        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("com.fideuram.utils.config.3des.key"));
//        out.writeObject(key);
//        out.close();
//    }

    public static void main(String[] a) throws Exception {
//        String clear = "pippo";
//        String encrypted = encrypt(clear);
//        System.out.println("Originale: " + clear);
//        System.out.println("Criptata: " + encrypted);
//        System.out.println("Decriptata: " + decrypt(encrypted));
//
//        System.out.println(getProperty("crm.password"));

        if (a != null && a.length > 0) {
            System.out.println(STRING_3DES + encrypt(a[0]));
        } else {
            System.out.println("Usage:");
            System.out.println("java -jar CRM_Config.jar <testodacriptare>");
        }
        System.exit(0);
    }

}
