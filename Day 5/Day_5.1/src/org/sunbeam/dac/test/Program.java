package org.sunbeam.dac.test;
class Person
{
	private String name;
	private int age;
	public Person() 
	{
		this.name = "";
		this.age = 0;
	}
	public Person( String name, int age ) 
	{
		this.name = name;
		this.age = age;
	}
	public void showRecord( )
	{
		System.out.println("Name	:	"+this.name);
		System.out.println("Age	:	"+this.age);
	}
	public void printRecord( )
	{
		System.out.println("Name	:	"+this.name);
		System.out.println("Age	:	"+this.age);
	}
	@Override
	public String toString()
	{	
		return String.format("%-15s%-5d",this.name, this.age);
	}
}
class Employee extends Person
{
	private int empid;
	private float salary;
	public Employee() 
	{
		super( );
		this.empid = 0;
		this.salary = 0;
	}
	public Employee( String name, int age, int empid, float salary )  
	{
		super( name, age );
		this.empid = empid;
		this.salary = salary;
	}
	public void displayRecord( )
	{
		this.showRecord();
		//super.showRecord();
		System.out.println("Empid	:	"+this.empid);
		System.out.println("Salary	:	"+this.salary);
	}
	public void printRecord( )
	{
		super.printRecord();
		System.out.println("Empid	:	"+this.empid);
		System.out.println("Salary	:	"+this.salary);
	}
	@Override
	public String toString() 
	{
		return String.format("%s %-5d%-10.2f", super.toString(), this.empid, this.salary);
	}
}
public class Program
{
	public static void main1(String[] args) 
	{
		Person p = new Employee("ABC",23,1125,25000);
		p.showRecord();
		Employee emp = (Employee) p;	//Downcasting
		emp.displayRecord();
	}
	public static void main2(String[] args) 
	{
		Person p = null;
		Employee emp = (Employee) p;
		emp.displayRecord();	//NullPointerException
	}
	public static void main3(String[] args) 
	{
		Person p = new Employee();	//Upcasting
		Employee emp = (Employee) p;	//Downcasting
		emp.displayRecord();	//Employee.displayRecord()
	}
	public static void main(String[] args) 
	{
		Person p = new Person();
		Employee emp = (Employee) p; //Downcasing
		emp.displayRecord();	//ClassCastException
	}
}
