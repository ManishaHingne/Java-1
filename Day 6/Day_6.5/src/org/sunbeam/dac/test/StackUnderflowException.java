package org.sunbeam.dac.test;

public class StackUnderflowException extends Exception 
{
	public StackUnderflowException() 
	{
		super();
	}

	public StackUnderflowException(String message, Throwable cause) 
	{
		super(message, cause);
	}

	public StackUnderflowException(String message) 
	{
		super(message);
	}
}
