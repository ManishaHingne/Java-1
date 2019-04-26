package org.sunbeam.dac.test;

import java.util.Date;

public class Program 
{
	public static void print1( Object object )
	{
		System.out.println(object);
	}
	
	public static <T> void print2( T object )
	{
		System.out.println(object);
	}
	
	public static <T extends Number > void print( T object )
	{
		System.out.println(object);
	}
	public static void main(String[] args) 
	{
		Program.print( 10 );
		Program.print( 20.5 );
		Program.print( "DAC" );
		Program.print( new Date() );
	}
}
