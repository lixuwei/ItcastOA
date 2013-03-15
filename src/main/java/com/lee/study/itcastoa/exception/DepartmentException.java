package com.lee.study.itcastoa.exception;
/**
 * Department业务操作抛出的异常
 * @author lee
 *	
 * 2013-3-4  下午9:59:33
 */
public class DepartmentException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1501278466002927272L;
	
	
	public DepartmentException( String message )
    {
        super( message );
    }

    public DepartmentException( String message, Throwable throwable )
    {
        super( message, throwable );
    }
}
