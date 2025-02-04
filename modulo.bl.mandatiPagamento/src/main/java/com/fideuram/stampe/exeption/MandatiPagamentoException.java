package com.fideuram.stampe.exeption;

@SuppressWarnings("serial")
public class MandatiPagamentoException extends Exception{
    public MandatiPagamentoException() {
        super();
    }

    public MandatiPagamentoException(String message) {
        super(message);
    }

    public MandatiPagamentoException(String message,  Throwable cause) {
        super(message, cause);
    }
}
