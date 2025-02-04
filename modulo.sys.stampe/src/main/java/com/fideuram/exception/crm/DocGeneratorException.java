package com.fideuram.exception.crm;

/**
 * Created by
 * User: logan
 * Date: 13/06/11
 * Time: 11.30
 */
public class DocGeneratorException extends Exception{

	private static final long serialVersionUID = -4609883780927182467L;


	public DocGeneratorException() {
	}

	/**
	 * @param arg0
	 */
	public DocGeneratorException(String arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 */
	public DocGeneratorException(Throwable arg0) {
		super(arg0);
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public DocGeneratorException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}
}
