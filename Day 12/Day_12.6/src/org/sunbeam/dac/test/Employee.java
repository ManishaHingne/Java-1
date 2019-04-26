package org.sunbeam.dac.test;

import java.io.Serializable;

public class Employee implements Serializable
{
	private static final long serialVersionUID = -690720167963860969L;
	private String name;
	private int empid;
	private transient float salary;
	public Employee(String name, int empid, float salary) 
	{
		this.name = name;
		this.empid = empid;
		this.salary = salary;
	}
	@Override
	public String toString() 
	{
		return "Employee [name=" + name + ", empid=" + empid + ", salary=" + salary + "]";
	}
}
