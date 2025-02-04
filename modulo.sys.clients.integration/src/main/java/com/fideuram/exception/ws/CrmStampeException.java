/**
 * 
 */
package com.fideuram.exception.ws;

/**
 * @author Giorgio Desideri
 *
 */
public class CrmStampeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4609883780927182467L;

	/**
	 * 
	 */
	public CrmStampeException() {
	}

	/**
	 * @param arg0
	 */
	public CrmStampeException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public CrmStampeException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CrmStampeException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
