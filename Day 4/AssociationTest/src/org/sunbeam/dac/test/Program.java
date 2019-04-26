package org.sunbeam.dac.test;

import org.sunbeam.dac.lib.Date;
import org.sunbeam.dac.lib.Employee;

public class Program 
{
	
	public static void main(String[] args) 
	{
		Date dt = new Date();
		System.out.println(dt.toString());
		
		Employee emp = new Employee("ABC", 12, 25000, 1, 4, 1990);
		System.out.println(emp.toString());
				
	}
}
