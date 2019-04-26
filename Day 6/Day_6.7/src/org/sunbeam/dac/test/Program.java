package org.sunbeam.dac.test;

abstract class A
{
	private int num1;
	public A( int num1 ) //Sole Ctor
	{
		this.num1 = num1;
	}
	public void print( )
	{
		System.out.println("Num1	:	"+this.num1);
	}
}
class B extends A
{
	private int num2;
	public B( int num1, int num2 )
	{
		super( num1 );
		this.num2 = num2;
	}
	public void print( )
	{
		super.print();
		System.out.println("Num2	:	"+this.num2);
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		B b = new B( 10, 20 );
		b.print();
	}
}
