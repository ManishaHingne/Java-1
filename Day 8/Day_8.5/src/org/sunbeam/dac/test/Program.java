package org.sunbeam.dac.test;

import java.util.Arrays;
import java.util.Comparator;

abstract class Person implements Comparable<Person>
{
	private String name;
	public Person( String name ) 
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	@Override
	public int compareTo(Person other) 
	{
		return this.name.compareTo(other.name);
	}
	@Override
	public String toString() 
	{
		return this.name;
	}
}
class Student extends Person
{
	private int rollNumber;
	public Student( String name, int rollNumber ) 
	{
		super( name );
		this.rollNumber = rollNumber;
	}
	public int getRollNumber() 
	{
		return rollNumber;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d", super.toString(), this.rollNumber);
	}
}
class Employee extends Person
{
	private int empid;
	public Employee( String name, int empid ) 
	{
		super( name );
		this.empid = empid;
	}
	public int getEmpid()
	{
		return empid;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d", super.toString(), this.empid);
	}
}
class SortById implements Comparator<Person>
{
	@Override
	public int compare(Person p1, Person p2) 
	{
		if( p1 instanceof Employee && p2 instanceof Employee )
		{
			Employee emp1 = (Employee) p1;
			Employee emp2 = (Employee) p2;
			return emp1.getEmpid() - emp2.getEmpid();
		}
		else if(  p1 instanceof Student && p2 instanceof Student )
		{
			Student s1 = (Student) p1;
			Student s2 = (Student) p2;
			return s1.getRollNumber() - s2.getRollNumber();
		}
		else if( p1 instanceof Student && p2 instanceof Employee )
		{
			Student s1 = (Student) p1;
			Employee emp2 = (Employee) p2;
			return s1.getRollNumber() - emp2.getEmpid();
		}
		else
		{
			Employee emp1 = (Employee) p1;
			Student s2 = (Student) p2;
			return emp1.getEmpid() - s2.getRollNumber();
		}
	}
}
public class Program
{	
	public static Person[] getPersons( )
	{
		Person[] arr = new Person[ 5 ];
		arr[ 0 ] = new Student("Nitin", 15);
		arr[ 1 ] = new Employee("Yogesh", 11);
		arr[ 2 ] = new Student("Amol", 14);
		arr[ 3 ] = new Employee("Sachin", 12);
		arr[ 4 ] = new Student("Rahul", 13);
		return arr;
	}
	public static void print( Person[] persons )
	{
		if( persons != null )
		{
			for (Person person : persons)
				System.out.println(person.toString());
			System.out.println();
		}
	}
	public static void main(String[] args) 
	{
		Person[] persons = Program.getPersons();
		Program.print(persons);
		
		Comparator<Person> comparator = new SortById();
		Arrays.sort( persons , comparator);
		Program.print(persons);
	}
}
