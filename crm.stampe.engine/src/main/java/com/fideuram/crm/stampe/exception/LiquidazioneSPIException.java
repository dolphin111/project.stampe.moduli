package com.fideuram.crm.stampe.exception;

/**
 * Created by
 * User: logan
 * Date: 13/05/11
 * Time: 14.07
 * Questa eccezione è specifica per il caso di richesta liquidazione di  una polizza SPI
 */
public class LiquidazioneSPIException extends StampeInfoException {
        public LiquidazioneSPIException() { }

        public LiquidazioneSPIException(String message) {
            super(message);
        }

        public LiquidazioneSPIException(Throwable cause) {
            super(cause);
        }
}
