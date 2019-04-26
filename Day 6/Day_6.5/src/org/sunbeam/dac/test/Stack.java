package org.sunbeam.dac.test;

public class Stack 
{
	private LinkedList list = new  LinkedList();
	public boolean stack( )
	{
		return list.empty();
	}
	public void push( int element )
	{
		list.addFirst(element);
	}
	public int peek( ) throws StackUnderflowException 
	{
		try 
		{
			return list.getElement();
		}
		catch (Exception cause) 
		{
			throw new StackUnderflowException("Stack is empty", cause);
		}
	}
	public void pop( ) throws StackUnderflowException
	{
		try 
		{
			list.removeFirst();
		}
		catch (Exception cause) 
		{
			throw new StackUnderflowException("Stack is empty", cause);
		}
	}
}
