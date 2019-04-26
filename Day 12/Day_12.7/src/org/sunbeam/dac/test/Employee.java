package org.sunbeam.dac.test;

import java.io.Serializable;

public class Employee implements Comparable<Employee>, Serializable
{
	private String name;
	private int empid;
	private float salary;
	
	public Employee() 
	{	}
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
	public void setEmpid(int empid) 
	{
		this.empid = empid;
	}
	public float getSalary() 
	{
		return salary;
	}
	@Override
	public int compareTo(Employee other) 
	{
		return this.empid - other.empid;
	}
	@Override
	public boolean equals(Object obj) 
	{
		if( obj != null )
		{
			Employee other = (Employee) obj;
			if( this.empid == other.empid )
				return true;
		}
		return false;
	}
	@Override
	public String toString() 
	{
		return String.format("%-20s%-5d%-10.2f", this.name, this.empid, this.salary);
	}
}
