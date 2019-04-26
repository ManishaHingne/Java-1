package org.sunbeam.dac.test;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class Program 
{
	public static void main(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		int element = 0;
		Enumeration<Integer> e = v.elements();
		while( e.hasMoreElements())
		{
			element = e.nextElement();
			System.out.println(element);
			if( element == 30 )
				v.add(40);
		}
	}
	public static void main2(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		int element = 0;
		Iterator<Integer> itr = v.iterator();
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.println(element);
//			if( element == 30 )
//				v.add(40);
		}
	}
	public static void main3(String[] args) 
	{
		Vector<Integer> v = new Vector<Integer>();
		v.add(10);
		v.add(20);
		v.add(30);
		
		int element = 0;
		ListIterator<Integer> itr = v.listIterator();
		while( itr.hasNext())
		{
			element = itr.next();
			System.out.print(element+"	");
		}
		System.out.println();
		while( itr.hasPrevious())
		{
			element = itr.previous();
			System.out.print(element+"	");
		}
	}
}
