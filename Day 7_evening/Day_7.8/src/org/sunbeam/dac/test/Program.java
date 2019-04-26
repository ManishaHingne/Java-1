package org.sunbeam.dac.test;

interface A
{
	int num1 = 10;
	//public static final int num1;
	
	void print( );
	//public abstract void print( );
}
class B implements A
{
	@Override
	public void print() 
	{
		System.out.println("Num1	:	"+A.num1);
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		A a = new B( ); //Upcasting
		a.print(); //DMD
	}
}
