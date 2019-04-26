package org.sunbeam.dac.test;

public class Program
{
	public static void swap( int[] arr2 )
	{
		int temp = arr2[ 0 ];
		arr2[ 0 ] = arr2[ 1 ];
		arr2[ 1 ] = temp;
	}
	public static void main(String[] args) 
	{
		int a = 10;
		int b = 20;
		int[] arr1 = new int[  ] { a, b };
		Program.swap( arr1 );
		a = arr1[ 0 ];	b = arr1[ 1 ];
		System.out.println("A	:	"+a);
		System.out.println("B	:	"+b);
	}
}
