package org.sunbeam.dac.test;

import java.util.ArrayList;
import java.util.Scanner;

public class InstituteTest
{
	static Scanner sc = new Scanner(System.in);
	Institute institute = Institute.getInstance();
	public InstituteTest() 
	{
		institute.setStaffList(new ArrayList<Staff>());
	}
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
		staff.calculateSalary();
	}
	public void addStaff() 
	{
		int choice;
		while( ( choice = InstituteTest.staffMenuList( ) ) != 0 )
		{
			Staff staff = StaffFactory.getInstance(choice);
			if( staff != null )
			{
				InstituteTest.acceptRecord(staff);
				this.institute.addStaff(staff);
			}
		}
	}
	public static void printStaff( Staff staff )
	{
		if( staff != null )
			System.out.println(staff.toString());
		else
			System.out.println("Staff not found");
	}
	public void findStaff( )
	{
		System.out.print("Enter staff id	:	");
		Staff staff =  this.institute.findStaff(sc.nextInt());
		InstituteTest.printStaff(staff);
	}
	public void removeStaff( )
	{
		System.out.print("Enter staff id	:	");
		boolean removedStatus =  this.institute.removeStaff(sc.nextInt());
		System.out.println((removedStatus ? "Staff is removed": "Staff is not removed"));
	}

	public void printStaffList( )
	{
		this.institute.printStaffList();
	}
	public static int staffMenuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Teaching Staff");
		System.out.println("2.Non Teaching Staff");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static int instituteMenuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Staff");
		System.out.println("2.Find Staff");
		System.out.println("3.Remove Staff");
		System.out.println("4.Print Staff");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	@Override
	protected void finalize() throws Throwable 
	{
		if( sc !=null )
			sc.close();
	}
}
