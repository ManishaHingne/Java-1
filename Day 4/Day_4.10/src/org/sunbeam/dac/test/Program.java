package org.sunbeam.dac.test;

class Singleton
{
	private Singleton( )
	{	}
	private static Singleton instance = null;
	public static Singleton getInstance()
	{
		if( Singleton.instance == null )
			Singleton.instance = new Singleton();
		return Singleton.instance;
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
	}
}
