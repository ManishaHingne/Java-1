package org.sunbeam.dac.test;

import java.util.Scanner;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( int[] element )
	{
		System.out.print("Enter element	:	");
		element[ 0 ] = sc.nextInt();
	}
	public static void printRecord( int element )
	{
		System.out.println("Popped element is	:	"+element);
	}
	public static StackOperation menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Push");
		System.out.println("2.Pop");
		System.out.print("Enter choice	:	");
		return StackOperation.values()[ sc.nextInt() ];
		
		/*StackOperation[] arr = StackOperation.values();
		int choice = sc.nextInt();
		return arr[ choice ];*/
	}
	public static void main(String[] args) 
	{
		StackOperation choice;
		int[] element = new int[ 1 ];
		Stack stack = new Stack( 3 );
		while( ( choice = Program.menuList( ) ) != StackOperation.EXIT )
		{
			try 
			{
				switch( choice )
				{
				case PUSH:
					Program.acceptRecord(element);
					stack.push(element[ 0 ] );
					break;
				case POP:
					element[ 0 ] = stack.peek();
					Program.printRecord(element[ 0 ]);
					stack.pop();
					break;
				}
			}
			catch (StackOverflowException | StackUnderflowException e) 
			{
				System.out.println(e.getMessage());
			}
		}
	}
}
