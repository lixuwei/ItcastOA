package com.lee.study.itcastoa.exception;

public class PostException extends Exception {

	private static final long serialVersionUID = 1L;

	public PostException(String message){
        super(message);
    }

    public PostException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
