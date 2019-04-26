package org.sunbeam.dac.test;

import java.util.Arrays;
import java.util.Scanner;

public class Program
{
	public static void main1(String[] args) 
	{
		//int arr[][];	//Ok
		//int[] arr[];	//Ok
		//int[][] arr;	//Ok
		
		int[][] arr = new int[ 2 ][ 3 ];
	}
	public static void main2(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[ 2 ][ 3 ];
		
		for( int row = 0; row < arr.length; ++ row )
		{
			for( int col = 0; col < arr[ row ].length; ++ col )
			{
				System.out.print("Enter element	:	");
				arr[ row ][ col ] = sc.nextInt();
			}
		}
		for( int row = 0; row < arr.length; ++ row )
		{
			for( int col = 0; col < arr[ row ].length; ++ col )
			{
				System.out.print(arr[ row ][ col ] +"	");
			}
			System.out.println();
		}
	}
	public static void main3(String[] args) 
	{
		//int[][] arr = new int[  ][  ] { {11,22,33}, {44,55,66} };
									  
	  int[][] arr = { 
						{11,22,33},
						{44,55,66} 
				   };
		
		for( int row = 0; row < arr.length; ++ row )
		{
			for( int col = 0; col < arr[ row ].length; ++ col )
			{
				System.out.print(arr[ row ][ col ] +"	");
			}
			System.out.println();
		}
		
	}
	public static void main4(String[] args) 
	{
		int[][] arr = new int[  ][  ] { {11,22,33}, {44,55,66} };
		for( int index = 0; index < arr.length; ++ index )
			System.out.println(Arrays.toString(  arr[ index ] )  );
	}
	public static void main(String[] args) 
	{
		int[][] arr = new int[  ][  ] { {11,22,33}, {44,55,66} };
		for( int[] i : arr )
		{
			for( int  j : i )
				System.out.print(j+"	");
			System.out.println();
		}
	}
}
