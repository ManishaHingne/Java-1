package org.sunbeam.dac.test;

class Box< N extends Number >	//N extends Number --> Bounded Type Parameter 
{
	private N object;
	public N getObject() 
	{
		return object;
	}
	public void setObject(N object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Box<Number> b1 = new Box<>(); //Ok
		
		Box<Integer> b2 = new Box<>();	//Ok
		
		Box< Double > b3 = new Box<>();	//OK
		
		//Box< Boolean > b4 = new Box<>();	//Not Ok
		
		//Box< String > b = new Box<>(); //Not OK
	}
}
