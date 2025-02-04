package com.fideuram.crm.stampe.serviceclient.universo;

import com.fideuram.exception.ws.CrmStampeException;
import com.fideuram.exception.ws.UniversoException;
import com.fideuram.crm.stampe.serviceclient.bi.ClientWSUniverso;

/**
 * Created
 * User: logan
 * Date: 02/09/11
 * Time: 10.27
 */
@Deprecated
public  class UniversoServiceManager {
        private static UniversoServiceManager instance = null;
        private ClientUniverso oldUniverso = null;
        private ClientUniverso newUniverso = null;

        public  ClientUniverso prestazioniAssicurate(){return oldUniverso;}
        public  ClientUniverso riscattoPolizzeAperte(){return newUniverso;}
        public  ClientUniverso riscattoPolizzeChiuse(){return newUniverso;}
        public  ClientUniverso conversioneInRendita() {return oldUniverso;}
        public  ClientUniverso riduzione()            {return newUniverso;}
        public  ClientUniverso reversibilita()        {return newUniverso;}
        public  ClientUniverso certezza()             {return newUniverso;}
        public  ClientUniverso opzProroga()           {return oldUniverso;}
        public  ClientUniverso getOpzCambioFraz()     {return oldUniverso;}


        public UniversoServiceManager() throws UniversoException {
             this.oldUniverso=  new ClientWSUniverso();
             //this.newUniverso=  new NuovoUniversoClientWS();
        }

        /**
         * @return
         *
         * @throws Exception
         */
        public static synchronized UniversoServiceManager getInstance() throws CrmStampeException {
            if(instance == null) {
                instance = new UniversoServiceManager();
            }

            return instance;
        }

}
