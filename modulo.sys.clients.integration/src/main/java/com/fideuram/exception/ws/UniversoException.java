package com.fideuram.exception.ws;



/**
 * @author Giorgio Desideri
 *
 */
public class UniversoException extends CrmStampeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8523834296631856534L;

	
	/**
	 * 
	 */
	public UniversoException() {
		super();
	}

	/**
	 * @param message
	 * @param thrw
	 */
	public UniversoException(String message, Throwable thrw) {
		super(message, thrw);
	}

	/**
	 * @param message
	 */
	public UniversoException(String message) {
		super(message);
	}

	/**
	 * @param thrw
	 */
	public UniversoException(Throwable thrw) {
		super(thrw);
	}

	
}
