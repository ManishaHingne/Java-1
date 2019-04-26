package org.sunbeam.dac.test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Program 
{
	public static void main1(String[] args) 
	{
		Queue<Integer> que = new ArrayDeque< >();
		que.offer(10);
		que.offer(20);
		que.offer(30);
		que.offer(40);
		que.offer(50);
		
		int element = 0;
		while( !que.isEmpty())
		{
			element = que.peek();
			System.out.println("Removed element is : "+element);
			que.poll();
		}
	}
	public static void main2(String[] args) 
	{
		Deque<Integer> que = new ArrayDeque< >();
		que.offer(30);
		que.offer(40);
		que.offerFirst(20);
		que.offerFirst(10);
		que.offerFirst(5);
		que.offerLast(50);
		que.offerLast(60);
		
		que.pollFirst();
		que.pollLast();
		
		int element = 0;
		while( !que.isEmpty())
		{
			element = que.peek();
			System.out.println("Removed element is : "+element);
			que.poll();
		}
	}
	public static void main(String[] args) 
	{
		Deque<Integer> stack = new  ArrayDeque< >();
		stack.offerFirst(10);
		stack.offerFirst(20);
		stack.offerFirst(30);
		
		int element = 0;
		while( !stack.isEmpty() )
		{
			element = stack.peekFirst();
			System.out.println("Popped element is	:	"+element);
			stack.pollFirst();
		}
	}
}
