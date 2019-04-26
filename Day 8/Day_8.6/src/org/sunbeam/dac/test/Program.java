package org.sunbeam.dac.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Program
{	
	public static void main1(String[] args) 
	{
		ArrayList<Integer> list1 = new ArrayList<>( );
		
		List<Integer> list2 = new ArrayList<>( );
		
		Collection<Integer> list3 = new ArrayList<>( );
	}
	public static void main2(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>( 7 );
	}
	public static void main3(String[] args) 
	{
		//Collection<Integer> c = new LinkedList<>( );
		//List<Integer> c = new LinkedList<>( );
		LinkedList<Integer> c = new LinkedList<>( );
		c.add(10);
		c.add(20);
		c.add(30);	
		List<Integer> list = new ArrayList<Integer>( c );
	}
	public static void main4(String[] args) 
	{
		List<Integer> list = new ArrayList<>( );
		list.add(10);
		list.add(300);
		list.add(40);
		list.add(50);
		list.set(1, 30);
		list.add(1, 20);
		
		int element = 0;
		for( int index = 0; index < list.size(); ++ index )
		{
			element = list.get(index);
			System.out.println(element);
		}	
	}
	public static void main5(String[] args) 
	{
		List<Integer> list = new ArrayList<>( );
		list.add(10);
		list.add(300);
		list.add(40);
		list.add(50);
		list.set(1, 30);
		list.add(1, 20);
		
		int element = list.get(list.size());
		System.out.println(element);	//IndexOutOfBoundsException
	}
	public static void main6(String[] args) 
	{
		int[] arr = new int[ ] { 10, 20, 30 };
		int element = arr[ arr.length ]; //ArrayIndexOutOfBoundsException
	}
	public static void main7(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		int element = list.get(list.size());//IndexOutOfBoundsException
	}
	public static void main8(String[] args) 
	{
		String str = "SunBeam";
		char ch = str.charAt( str.length());
		System.out.println( ch ); //StringIndexOutOfBoundsException
	}	
	public static void main9(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		for( int element : list )
			System.out.println(element);
	}
	public static void main(String[] args) 
	{
		List<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
	
		list.forEach(System.out::println);
	}	
}
