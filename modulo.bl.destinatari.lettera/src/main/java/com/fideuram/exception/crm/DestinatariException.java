package com.fideuram.exception.crm;

/**
 * Created by
 * User: logan
 * Date: 10/10/11
 * Time: 11.02
 */
public class DestinatariException extends Exception{
       private static final long serialVersionUID = -1L;


        public DestinatariException() {}

        /**
         * @param arg0
         */
        public DestinatariException(String arg0) {
            super(arg0);
        }

        /**
         * @param arg0
         */
        public DestinatariException(Throwable arg0) {
            super(arg0);
        }

        /**
         * @param arg0
         * @param arg1
         */
        public DestinatariException(String arg0, Throwable arg1) {
            super(arg0, arg1);
        }
}
