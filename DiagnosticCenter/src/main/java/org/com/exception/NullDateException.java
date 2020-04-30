package org.com.exception;

public class NullDateException extends Exception {


	private static final long serialVersionUID = 1L;
	String errorMessage;
	public NullDateException(String errorMessage)
	{
		this.errorMessage=errorMessage;
	}
	public String toString() {
		return errorMessage;
	}
}
