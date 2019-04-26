package org.sunbeam.dac.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class Program 
{
	public static void main1(String[] args) 
	{
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		while( !stack.empty())
		{
			int element = stack.peek();
			System.out.println(element);
			stack.pop();
		}
	}
	public static void main2(String[] args) 
	{
		List<Integer> list = new LinkedList<Integer>( );
		list.add(10);
		list.add(20);
		list.add(30);
		
		Integer key = new Integer(20);
		if( list.contains(key))
		{
			int index = list.indexOf(key);
			list.remove(index);
		}
		
		for( int element : list )
		{
			System.out.println(element);
		}
	}
	public static void main(String[] args) 
	{
		//Set<Integer> set = new HashSet<>();
		//Set<Integer> set = new LinkedHashSet<Integer>();
		Set<Integer> set = new TreeSet<Integer>();
		set.add(110);
		set.add(15);
		set.add(58);
		set.add(200);
		set.add(150);
		
		set.add(110);
		set.add(15);
		set.add(58);
		set.add(200);
		set.add(150);
		
		set.add(null);
		
		for( int element : set )
			System.out.println(element);
	}
}
