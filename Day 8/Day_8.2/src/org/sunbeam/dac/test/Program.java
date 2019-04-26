package org.sunbeam.dac.test;

import java.util.Arrays;

public class Program
{
	public static void print( int[] arr )
	{
		if( arr != null )
		{
			for( int element : arr )
				System.out.print(element+" ");
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		int[] arr = new int[ ] { 50, 10, 40, 20, 30 };
		Program.print(arr);
		Arrays.sort( arr ); //Dual-Pivot Quicksort
		Program.print(arr);
	}
}
