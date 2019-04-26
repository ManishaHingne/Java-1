package org.sunbeam.dac.test;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		try
		{
			System.out.print("Num1	:	");
			int num1 = sc.nextInt();
			System.out.print("Num2	:	");
			int num2 = sc.nextInt();
			if( num2 == 0 )
				throw new ArithmeticException("Divide by zero exception");
			int result = num1 / num2;
			System.out.println("Result	:	"+result);
		}
		catch (ArithmeticException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) 
		{
			System.out.println(e.getMessage());
		}
		catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
}
