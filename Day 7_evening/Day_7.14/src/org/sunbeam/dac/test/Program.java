package org.sunbeam.dac.test;

interface A
{
	void f1( );
	void f2( );
	void f3( );
}
abstract class B implements A //B--> Adaptor class
{
	public void f1() {	}
	public void f2() {	}
	public void f3() {	}
}
class C extends B
{
	@Override
	public void f2() 
	{	
		System.out.println("C.f2");
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		A a = new C( );
		a.f2();
	}
}
