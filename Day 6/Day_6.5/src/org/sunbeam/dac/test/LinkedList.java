package org.sunbeam.dac.test;

public class LinkedList
{
	private Node head;
	private Node tail;
	public boolean empty( )
	{
		return this.head == null;
	}
	public void addFirst( int element )
	{
		Node newNode = new Node( element );
		if( this.empty() )
		{
			this.tail = newNode;
			this.head = newNode;
		}
		else
		{
			newNode.next = this.head;
			this.head = newNode;
		}
	}
	
	public int getElement( ) throws Exception
	{
		if( this.empty())
			throw new Exception("Linked List is empty");
		return this.head.element;
	}
	public void removeFirst( ) throws Exception
	{
		if( this.empty())
			throw new Exception("Linked List is empty");
		else if( this.head == this.tail )
			this.head = this.tail = null;
		else
			this.head = this.head.next;
	}
}
