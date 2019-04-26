package org.sunbeam.dac.test;

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
public class Program
{
	static Scanner sc = new Scanner(System.in);
	public static void acceptRecord( Staff staff )
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
	}
	public static void printRecord( Staff staff )
	{
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
	public static void main(String[] args) 
	{
		int choice;
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			Staff staff = null;
			switch( choice )
			{
			case 1:
				staff = new TeachingStaff(); //Upcasting
				break;
			case 2:
				staff = new NonTeachingStaff(); //Upcasting
				break;
			}
			if( staff != null )
			{
				Program.acceptRecord(staff);
				staff.calculateSalary( );
				Program.printRecord(staff);
			}
		}
	}
}
