package com.lee.study.itcastoa.exception;

public class PersonException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public PersonException(String message) {
		super(message);
		}
	
	public PersonException(String message,Throwable throwable ){
		super(message, throwable);
	}
}
