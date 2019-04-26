package org.sunbeam.dac.test;
class Test
{
	private int num1;			//Instance Variable
	private int num2;			//Instance Variable
	private static int num3;	//class level Variable
	
	static	//Static Initializer block	
	{
		Test.num3 = 30; 
	}
	public Test() 
	{
		this.num1 = 10;
		this.num2 = 20;
	}
	public Test( int num1, int num2 ) 
	{
		this.num1 = num1;
		this.num2 = num2;
	}
	public int getNum1() 
	{
		return num1;
	}
	public void setNum1(int num1)
	{
		this.num1 = num1;
	}
	public int getNum2()
	{
		return num2;
	}
	public void setNum2(int num2)
	{
		this.num2 = num2;
	}
	public static int getNum3() 
	{
		return num3;
	}
	public static void setNum3(int num3) 
	{
		Test.num3 = num3;
	}
}
public class Program
{
	public static void acceptRecord( Test t1 )
	{
		t1.setNum1(500);
		t1.setNum2(600);
		Test.setNum3(700);
	}
	public static void printRecord( Test t1  )
	{
		System.out.println("Num1	:	"+t1.getNum1());
		System.out.println("Num2	:	"+t1.getNum2());
		System.out.println("Num3	:	"+Test.getNum3());
	}
	public static void main(String[] args) 
	{	
		Test t1 = new Test( );
		
		Program.acceptRecord( t1 );
		
		Program.printRecord( t1 );
	}
}
