package com.assigment.to.exception;

/**
 * Custom Exception to be handled throughout the application
 * @author tarunagarwal
 *
 */
public class KnapshakException extends Exception {

	private static final long serialVersionUID = 2307649817939459066L;
	
	Throwable cause;

	public KnapshakException(Throwable cause) {
		super();
		this.cause = cause;
	}
	
	public KnapshakException() {
		super();
	}	
}
