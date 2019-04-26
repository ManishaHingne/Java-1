package org.sunbeam.dac.test;

interface A
{
	int num1 = 10;
}
interface B
{
	int num2 = 20;
}
interface C extends A, B
{
	int num3 = 30;
}
public class Program
{
	public static void main(String[] args) 
	{
		System.out.println("Num1	:	"+A.num1); //Ok : 10
		System.out.println("Num1	:	"+C.num1); //Ok : 10
		
		System.out.println("Num2	:	"+B.num2); //Ok : 20
		System.out.println("Num2	:	"+C.num2); //Ok : 20
		
		System.out.println("Num3	:	"+C.num3); //Ok : 30
		
	}
}
