package org.sunbeam.dac.test;

import java.util.Scanner;

class Test implements AutoCloseable
{
	@Override
	public void close() throws Exception 
	{	}
}
public class Program
{
	public static void main(String[] args)  
	{
		try( Scanner sc = new Scanner(System.in)))
		{
			int num1 = 10;
			int num2 = 2;
			int result = num1 / num2;

		}
		catch (Exception e)
		{
			System.out.println("Inside catch block");
			e.printStackTrace();
			System.exit( 0 );
		}
	}
	public static void main1(String[] args)  
	{
		Scanner sc = null;
		try
		{
			System.out.println("Inside try block");
			sc = new Scanner(System.in);
			
			int num1 = 10;
			int num2 = 0;
			int result = num1 / num2;
			System.exit(0);
		}
		catch (Exception e)
		{
			System.out.println("Inside catch block");
			e.printStackTrace();
			System.exit( 0 );
		}
		finally 
		{
			System.out.println("Inside finally block");
			sc.close();
		}
	}
}
