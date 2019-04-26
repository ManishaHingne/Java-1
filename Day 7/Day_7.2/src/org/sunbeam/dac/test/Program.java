package org.sunbeam.dac.test;

import java.text.SimpleDateFormat;
import java.util.Date;

class Box
{
	private Object object;
	public Object getObject() 
	{
		return object;
	}
	public void setObject(Object object) 
	{
		this.object = object;
	}
}
public class Program 
{
	public static void main(String[] args) 
	{
		Box b3 = new Box( );
		Date date = new Date(119, 03, 18);
		b3.setObject(date); //Upcasting
		String str =  (String) b3.getObject(); //ClassCastException
	}
	public static void main2(String[] args) 
	{
		Box b2 = new Box( );
		Date date = new Date(119, 03, 18);
		b2.setObject(date); //Upcasting
		
		Date dt = (Date) b2.getObject();
		String str = new SimpleDateFormat("dd/MM/yyyy")
							.format(dt);
		System.out.println(str);
	}
	public static void main1(String[] args) 
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
