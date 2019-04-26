package org.sunbeam.dac.test;

import java.util.Calendar;
import java.util.Scanner;

abstract class Staff
{
	private String name;
	private int id;
	protected float salary;
	public Staff() 
	{	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getName() 
	{
		return name;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getId() 
	{
		return id;
	}
	
	public float getSalary() 
	{
		return salary;
	}
	
	public abstract void calculateSalary( );
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d%-10.2f", this.name, this.id, this.salary );
	}
}
class TeachingStaff extends Staff
{
	private int theorySessionCount;
	public TeachingStaff() 
	{	}
	public void setTheorySessionCount(int theorySessionCount) 
	{
		this.theorySessionCount = theorySessionCount;
	}
	public void calculateSalary( )
	{
		this.salary = 800 * this.theorySessionCount;
	}
}
class NonTeachingStaff extends Staff
{
	private int labSessionCount;
	public NonTeachingStaff() 
	{	}
	public void setLabSessionCount(int labSessionCount) 
	{
		this.labSessionCount = labSessionCount;
	}
	public void calculateSalary( )
	{
		this.salary = 500 * this.labSessionCount;
	}
}
class StaffFactory
{
	public static Staff getInstance( int choice )
	{
		switch( choice )
		{
		case 1:
			return new TeachingStaff();
		case 2:
			return new NonTeachingStaff();
		}
		return null;
	}
}
class StaffTest
{
	static Scanner sc = new Scanner(System.in);
	private Staff staff;
	public void setStaff(Staff staff) 
	{
		this.staff = staff;
	}
	public void acceptRecord(  )
	{
		if( this.staff != null )
		{
			System.out.print("Name	:	");
			sc.nextLine();
			staff.setName(sc.nextLine());
			System.out.print("Id	:	");
			staff.setId(sc.nextInt());
			if( staff instanceof TeachingStaff )
			{
				TeachingStaff teachingStaff = (TeachingStaff) staff;
				System.out.print("Theory Session Count	:	");
				teachingStaff.setTheorySessionCount(sc.nextInt());
			}
			else
			{
				NonTeachingStaff nonTeachingStaff = (NonTeachingStaff) staff;
				System.out.print("Lab Session Count	:	");
				nonTeachingStaff.setLabSessionCount(sc.nextInt());
			}
			this.staff.calculateSalary(); //Dynamic Method Dispatch
		}
	}
	public void printRecord(  )
	{
		if( this.staff != null )
			System.out.println(staff.toString());
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Teaching Staff");
		System.out.println("2.Non Teaching Staff");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
}

public class Program
{	
	public static void main(String[] args) 
	{
		int choice;
		StaffTest test = new StaffTest();
		while( ( choice = StaffTest.menuList( ) ) != 0 )
		{
			test.setStaff(StaffFactory.getInstance(choice));
			test.acceptRecord();
			test.printRecord();
		}
	}
}
