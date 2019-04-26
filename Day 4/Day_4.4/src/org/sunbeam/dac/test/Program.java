package org.sunbeam.dac.test;

public class Program
{
	public static void sum ( int... arr )
	{
		int result = 0;
		for( int index = 0; index < arr.length; ++ index )
			result = result + arr[ index ];
		System.out.println("Result	:	"+result);
	}
	public static void main(String[] args) 
	{
		sum( );
		sum( 10, 20 );
		sum( 10, 20, 30 );
		sum( 10, 20, 30, 40 );
		sum( 10, 20, 30, 40, 50 );
		sum( 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 );
	}
}
