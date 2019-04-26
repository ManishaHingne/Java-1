package org.sunbeam.dac.test;

import java.util.Arrays;

class Employee implements Comparable<Employee>
{
	private String name;
	private int empid;
	private float salary;
	public Employee(String name, int empid, float salary) 
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	public String getName()
	{
		return name;
	}
	public int getEmpid()
	{
		return empid;
	}
	public float getSalary()
	{
		return salary;
	}
	@Override
	public int compareTo(Employee other ) 
	{
		if( this.empid < other.empid )
			return -1;
		else if( this.empid > other.empid )
			return 1;
		return 0;
	}
	/*@Override
	public int compareTo(Employee other ) 
	{
		return this.empid - other.empid;
	}*/
	/*@Override
	public int compareTo(Employee other ) 
	{
		return (int) (this.salary - other.salary);
	}*/
	/*@Override
	public int compareTo(Employee other ) 
	{
		return this.name.compareTo(other.name);
	}*/
	@Override
	public String toString() 
	{
		return String.format("%-20s%-5d%-10.2f", this.name, this.empid, this.salary);
	}
}
public class Program
{
	public static Employee[] getEmployees( )
	{
		Employee[] arr = new Employee[ 5 ];
		arr[ 0 ] = new Employee("Umesh", 50, 50000);
		arr[ 1 ] = new Employee("Amit", 10, 40000);
		arr[ 2 ] = new Employee("Prashant", 40, 30000);
		arr[ 3 ] = new Employee("Yogesh", 20, 20000);
		arr[ 4 ] = new Employee("Nitin", 30, 10000);
		return arr;
	}
	public static void print(Employee[] employees)
	{
		if( employees != null )
		{
			for (Employee emp : employees) 
				System.out.println(emp.toString());
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Employee[] employees = Program.getEmployees();
		Program.print( employees );
		
		Arrays.sort( employees );
		Program.print( employees );
	}
}
