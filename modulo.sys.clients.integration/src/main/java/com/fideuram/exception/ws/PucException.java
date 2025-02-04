package com.fideuram.exception.ws;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 16.08
 */
public class PucException extends Exception{
        private static final long serialVersionUID = -1L;


        public PucException() {}

        /**
         * @param arg0
         */
        public PucException(String arg0) {
            super(arg0);
        }

        /**
         * @param arg0
         */
        public PucException(Throwable arg0) {
            super(arg0);
        }

        /**
         * @param arg0
         * @param arg1
         */
        public PucException(String arg0, Throwable arg1) {
            super(arg0, arg1);
        }
}
