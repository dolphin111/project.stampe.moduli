package com.fideuram.exception.ws;

/**
 * Created by
 * User: logan
 * Date: 06/10/11
 * Time: 14.10
 */
public class CrmException extends Exception{

	private static final long serialVersionUID = -1L;


	public CrmException() {}

	/**
	 * @param arg0
	 */
	public CrmException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public CrmException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public CrmException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
