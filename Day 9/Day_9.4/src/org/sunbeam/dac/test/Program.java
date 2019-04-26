package org.sunbeam.dac.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Queue;

public class Program 
{
	public static Dictionary<Integer, String> getDictionary( )
	{
		Dictionary<Integer, String> d = new Hashtable<>();
		d.put(1, "DAC");
		d.put(2, "Wimc");
		d.put(3, "PreDAC");
		return d;
	}
	public static void printKeys( Dictionary<Integer, String> d )
	{
		int key = 0;
		Enumeration<Integer> e = d.keys();
		while( e.hasMoreElements( ) )
		{
			key = e.nextElement();
			System.out.println(key);
		}		
	}
	public static void printValues( Dictionary<Integer, String> d )
	{
		String value = "";
		Enumeration<String> e = d.elements();
		while( e.hasMoreElements())
		{
			value = e.nextElement();
			System.out.println(value);
		}
	}
	public static void printKeyValuePair( Dictionary<Integer, String> d )
	{
		Integer key = null;
		String value = null;
		Enumeration<Integer> e = d.keys();
		while( e.hasMoreElements( ) )
		{
			key = e.nextElement();
			value =  d.get(key);
			System.out.println(key+"	"+value);
		}		
	}
	public static void removeEntry( Dictionary<Integer, String> d, int value )
	{
		Integer key = new Integer(value);	
		d.remove(key);
	}
	public static void main(String[] args) 
	{
		Dictionary<Integer, String> d = Program.getDictionary();
		
		//Program.printKeys(d);
		//Program.printValues(d);
		//Program.printKeyValuePair(d);
		//Program.removeEntry(d, 2);
		//Program.printKeyValuePair(d);
		System.out.println("Count	:	"+d.size());
	}
}

