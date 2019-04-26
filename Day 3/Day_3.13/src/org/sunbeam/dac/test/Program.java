package org.sunbeam.dac.test;

import java.util.Arrays;
import java.util.Scanner;

public class Program
{
	public static void main1(String[] args) 
	{
		//int arr[ 3 ];	//C/C++
		
		//int arr[];	//Ok
		
		//int[] arr;	//Ok
		
		int[] arr = new int[ 3 ];
	}
	public static void main2(String[] args) 
	{
		int[] arr = new int[ 3 ];
		for( int index = 0; index < 3; ++ index )
			System.out.println(arr[ index ] );
	}
	public static void main4(String[] args) 
	{
		//int[] arr = new int[  ] { 10, 20, 30 };
		int[] arr = { 10, 20, 30 };
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(arr[ index ] );
	}
	public static void main5(String[] args) 
	{
		int[] arr = new int[  ] { 10, 20, 30 };
		for (int element : arr) 
			System.out.println(element);
	}
	public static void main6(String[] args) 
	{
		int[] arr = new int[  ] { 10, 20, 30 };
		//System.out.println(arr.toString());	//[I@7852e922
		System.out.println(Arrays.toString(arr));	//[10, 20, 30]
	}
	public static void main7(String[] args) 
	{
		//int[] arr = new int[ -3 ]; //NegativeArraySizeException
		int[] arr = new int[ ] { 10, 20, 30 };	//Ok
		//int element = arr[ arr.length ];	//ArrayIndexOutOfBoundsException
		int element = arr[ -1 ];	//ArrayIndexOutOfBoundsException
		System.out.println(element);
	}
	public static void main8(String[] args) 
	{
		int[] arr = new int[ ] { 50, 10, 40, 20, 30 };	//Ok
		
		System.out.println(Arrays.toString( arr ));
		Arrays.sort(arr);// Dual-Pivot Quicksort 
		System.out.println(Arrays.toString( arr ));
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[ 3 ];
		for( int index = 0; index < arr.length; ++ index )
		{
			System.out.print("Enter element	:	");
			arr[ index ] = sc.nextInt();
		}
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(arr[ index ]);
	}
}
