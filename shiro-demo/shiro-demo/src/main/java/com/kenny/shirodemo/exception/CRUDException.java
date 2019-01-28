package com.kenny.shirodemo.exception;

public class CRUDException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -724901854051418063L;

	public CRUDException() {
		super();
	}
	
	public CRUDException(String msg) {
		super(msg);
	}
	
	public CRUDException(Throwable t) {
		super(t);
	}
	
}
