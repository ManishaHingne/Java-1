package org.sunbeam.dac.test;

import java.util.Iterator;

class Node
{
	int element;
	Node next;
	public Node( int element )
	{
		this.element = element;
	}
}

class LinkedList implements Iterable<Integer>
{
	private Node head;
	private Node tail;
	public boolean empty( )
	{
		return this.head == null;
	}
	public void addLast( int element )
	{
		Node newNode = new Node( element );
		if( this.empty( ) )
			this.head = newNode;
		else
			this.tail.next = newNode;
		this.tail = newNode;
	}
	@Override
	public Iterator<Integer> iterator() 
	{
		Iterator<Integer> itr = new LinkedListIterator( this.head );
		return itr;
	}	
}
class LinkedListIterator implements Iterator<Integer>
{
	private Node node;
	public LinkedListIterator( Node node )
	{
		this.node = node;
	}
	@Override
	public boolean hasNext() 
	{
		if( this.node != null )
			return true;
		return false;
	}
	@Override
	public Integer next() 
	{
		int element = this.node.element;
		this.node = this.node.next;
		return element;
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		LinkedList list = new LinkedList();
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		
		/*Iterator<Integer> itr = list.iterator();
		int element = 0;
		while( itr.hasNext( ) )
		{
			element = itr.next();
			System.out.println(element);
		}*/
		
		for( int element : list )
			System.out.println(element);
	}
}
