package org.sunbeam.dac.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;

public class Program
{
	static Scanner sc = new Scanner(System.in);
	public static Employee[] getEmployees( )
	{
		Employee[] arr = new  Employee[ 10 ];
		arr[ 0 ] = new Employee("Prashant",20,95000);
		arr[ 1 ] = new Employee("Amol",11,90000);
		arr[ 2 ] = new Employee("Umesh",19,85000);
		arr[ 3 ] = new Employee("Nitin",12,80000);
		arr[ 4 ] = new Employee("Rahul",18,75000);
		arr[ 5 ] = new Employee("Yogesh",13,70000);
		arr[ 6 ] = new Employee("Sachin",17,65000);
		arr[ 7 ] = new Employee("Ganesh",14,60000);
		arr[ 8 ] = new Employee("Mukesh",16,55000);
		arr[ 9 ] = new Employee("Faiyaj",15,50000);
		return arr;
	}
	public static void acceptRecord( int[] empid )
	{
		System.out.print("Enter empid	:	");
		empid[ 0 ] = sc.nextInt();
	}
	public static void printRecord( Employee value )
	{
		if( value != null )
			System.out.println(value.toString());
		else
			System.out.println("Employee not found");
	}
	public static void printRecord( boolean removedStatus )
	{
		if( removedStatus )
			System.out.println("Employee is removed");
		else
			System.out.println("Employee is not removed");
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Record");
		System.out.println("2.Find Record");
		System.out.println("3.Remove Record");
		System.out.println("4.Print Record(Sorted)");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static int subMenuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Name");
		System.out.println("2.Empid");
		System.out.println("3.Salary");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] empid = new int[ 1 ];
		ListTest test = new ListTest();
		test.setEmpList(new ArrayList<Employee>());
		//test.setEmpList(new Vector<Employee>());
		//test.setEmpList(new LinkedList<Employee>());
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				Employee[] employees = Program.getEmployees();
				test.addRecord( employees );
				break;
			case 2:
				Program.acceptRecord(empid);
				Employee value  = test.findRecord( empid[ 0 ] );
				Program.printRecord(value);
				break;
			case 3:
				Program.acceptRecord(empid);
				boolean removedStatus = test.removeRecord( empid[ 0 ] );
				Program.printRecord(removedStatus);
				break;
			case 4:
				while( ( choice = Program.subMenuList( ) ) != 0 )
				{
					Comparator<Employee> comparator = null;
					switch( choice )
					{
					case 1:
						comparator = new SortByName();
						break;
					case 2:
						comparator = new SortByEmpid();
						break;
					case 3:
						comparator =  new SortBySalary();
						break;
					}
					test.print( comparator );
				}
				break;
			}
		}
	}
}
