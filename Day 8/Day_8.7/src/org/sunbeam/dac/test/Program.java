package org.sunbeam.dac.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class Program
{	
	public static void main1(String[] args) 
	{
		List<Integer> list = Arrays.asList(10, 20, 30, 40, 50 );
		list.forEach(System.out::println);
		System.out.println(list.getClass().getSimpleName());//ArrayList
		System.out.println(list.toString());
	}
	public static void main2(String[] args) 
	{
		List<Integer> tempList = new ArrayList<>( );
		tempList.add(60);
		tempList.add(70);
		tempList.add(80);
		
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 50; count = count + 10 )
			list.add(count);
		//list.addAll(tempList);
		list.addAll(2,tempList);
		list.forEach(System.out::println);
	}	
	public static void main3(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
		
		Integer key = new Integer(50 );
		if( list.contains(key))
		{
			int index = list.indexOf(key);
			
			int element = list.get(index);
			System.out.println(element);
		}
		else
			System.out.println(key+" not found");
	}	
	public static void main4(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
		
		Integer key = new Integer(50 );
		if( list.contains(key))
		{
			int index = list.indexOf(key);
			int element = list.remove(index);
			System.out.println(element);
		}
		else
			System.out.println(key+" not found");
	}	
	public static void main5(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
		
		Integer key = new Integer(50 );
		if( list.contains(key))
		{
			boolean removedStatus = list.remove(key);
			System.out.println(removedStatus);
		}
		else
			System.out.println(key+" not found");
	}
	public static void main6(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
		
		Collection<Integer> keys = new ArrayList<Integer>();
		keys.add(40);
		keys.add(50);
		keys.add(60);
	
		if( list.containsAll(keys))
		{
			//list.removeAll(keys);
			list.retainAll(keys);
			list.forEach(System.out::println);
		}
		else
			System.out.println("key not found");
	}
	public static void main7(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
	
		Object[] arr = list.toArray();
		System.out.println(Arrays.toString( arr ) );
		
		Integer[] intArray = new Integer[  list.size() ];
		list.toArray(intArray);
		
		System.out.println(Arrays.toString( intArray ) );
		
	}
	public static void main8(String[] args) 
	{
		List<Integer> list = new ArrayList<>( );
		list.add(50);
		list.add(10);
		list.add(40);
		list.add(30);
		list.add(20);
		
		//Collections.sort( list  );
		list.sort(null);
		
		list.forEach(System.out::println);
	}
	public static void main(String[] args) 
	{
		List<Integer> list = new ArrayList<Integer>();
		for( int count = 10; count <= 100; count = count + 10 )
			list.add(count);
		
		int element = 0;
		
		//ListIterator<Integer> itr = list.listIterator();
		//ListIterator<Integer> itr = list.listIterator( 3 );
		ListIterator<Integer> itr = list.listIterator( list.size() );
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
