package org.sunbeam.dac.test;
class Complex
{
	private int real;
	private int imag;
	public Complex(int real, int imag)
	{
		this.real = real;
		this.imag = imag;
	}
	public void setReal(int real) 
	{
		this.real = real;
	}
	public void setImag(int imag) 
	{
		this.imag = imag;
	}
	@Override
	public String toString()
	{
		return "Complex [real=" + real + ", imag=" + imag + "]";
	}
}
public class Program
{
	public static void main(String[] args) 
	{	
		final Complex c1 = new Complex( 10,20);
		c1.setReal(100);	//Ok
		c1.setImag(200);	//Ok
		
		c1 = new Complex( 50,60);	//Compiler Error

	}
}
