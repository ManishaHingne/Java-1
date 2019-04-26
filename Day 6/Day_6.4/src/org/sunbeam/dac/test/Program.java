package org.sunbeam.dac.test;
class Node
{
	int element;
	Node next;
	public Node( int element )
	{	
		this.element = element;
	}
}
class LinkedList
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
	public void addLast( int element )
	{
		Node newNode = new Node( element );
		if( this.empty() )
		{
			this.head = newNode;
			this.tail = newNode;
		}
		else
		{
			this.tail.next = newNode;
			this.tail = newNode;
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
	public void removeLast( ) throws Exception
	{
		if( this.empty())
			throw new Exception("Linked List is empty");
		else if( this.head == this.tail )
			this.head = this.tail = null;
		else
		{
			Node trav  = this.head;
			while( trav.next != this.tail )
				trav = trav.next;
			trav.next = null;
			this.tail = trav;
		}
	}
	public void printList( ) throws Exception
	{
		if( this.empty() )
			throw new Exception("Linked List is empty");
		Node trav = this.head;
		while( trav != null )
		{
			System.out.print(trav.element+" ");
			trav = trav.next;
		}
		System.out.println();
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		try 
		{
			LinkedList list = new LinkedList();
			list.addLast(20);
			list.addLast(30);
			list.addLast(40);
			list.addLast(50);
			list.addFirst(10);
		
			list.removeFirst();
			list.removeLast();
			
			list.printList();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
