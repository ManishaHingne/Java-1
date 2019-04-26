package org.sunbeam.dac.test;
public class Program
{
	public int num1 = 10;
	public static int num2 = 20;
	public static void main(String[] args) 
	{
		//System.out.println("Num1	:	"+num1);	//Not Ok
		Program p = new Program();
		System.out.println("Num1	:	"+p.num1);	// Ok
		System.out.println("Num2	:	"+num2);	//Ok
	}
}
