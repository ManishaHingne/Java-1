package org.sunbeam.dac.test;

import java.text.SimpleDateFormat;
import java.util.Date;

class Box<T>	// T --> Type Parameter 
{
	private T object;
	public T getObject() 
	{
		return object;
	}
	public void setObject(T object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main1(String[] args) 
	{
		Box<Date> b3 = new Box<Date>( ); //Date --> Type Argument
		Date date = new Date(119, 03, 18);
		b3.setObject( date );
		//String str =  (String) b3.getObject(); //Compiler Error
		Date dt = b3.getObject(); //OK
		
		String str = new SimpleDateFormat("dd/MM/yyyy").format(dt);
		System.out.println(str);
	}
	public static void main(String[] args) 
	{
		Box<Date> b1 = new Box<Date>(); //Ok
		
		Box<Date> b2 = new Box< >( ); //Ok
		
		Box b3 = new Box(); //Ok : Box --> Raw Type
		//Box<Object> b3 = new Box<>(); //Ok
		
		//Box<int> b4 = new Box<>(); //Not Ok
		
		Box<Integer> b4 = new Box<>(); //Not Ok
		
	}
	public static void main3(String[] args) 
	{
		Box b1 = new Box();
		int num1 = 10;
		b1.setObject(num1); //Auto-Boxing
		
		Integer i1 = (Integer) b1.getObject(); //Downcasting
		//int num2 = i1.intValue();//UnBoxing 
		int num2 = i1; //Auto-UnBoxing
		System.out.println(num2);
	}
}
