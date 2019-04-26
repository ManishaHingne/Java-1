package org.sunbeam.dac.test;

interface A
{
	int num1 = 10;
}
interface B
{
	int num1 = 20;
}
interface C extends A, B
{
	int num1 = 30;
}
public class Program
{
	public static void main(String[] args) 
	{
		System.out.println("Num1	:	"+A.num1); //Ok : 10
		System.out.println("Num1	:	"+C.num1); //Ok : 30
		
		
		System.out.println("Num1	:	"+B.num1); //Ok : 20
		System.out.println("Num1	:	"+C.num1); //Ok : 30
		
	}
}
