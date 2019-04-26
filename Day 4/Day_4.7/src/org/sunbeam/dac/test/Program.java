package org.sunbeam.dac.test;
public class Program
{
	private static int count;
	public static void print( )
	{
		//private static int count;	//Error
		++ count;
		System.out.println("Count	:	"+count);
	}
	public static void main(String[] args) 
	{	
		Program.print();	//1
		Program.print();	//2
		Program.print();	//3
	}
}
