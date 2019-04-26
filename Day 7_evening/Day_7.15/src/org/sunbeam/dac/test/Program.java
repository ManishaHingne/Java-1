package org.sunbeam.dac.test;

import java.time.LocalDateTime;
import java.util.ArrayList;

class Date implements Cloneable
{
	private int day;
	private int month;
	private int year;
	public Date() 
	{
		LocalDateTime ldt = LocalDateTime.now();
		this.day = ldt.getDayOfMonth();
		this.month = ldt.getMonthValue();
		this.year = ldt.getYear();
	}
	public Date(int day, int month, int year) 
	{
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date clone( ) throws CloneNotSupportedException
	{
 		Date other = (Date) super.clone();
		return other;
	}
	@Override
	public String toString() 
	{
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}
}
class Employee  implements Cloneable
{
	int empid;
	float salary;
	Date joinDate;
	public Employee( int empid, float salary, int day, int month, int year )
	{
		this.empid = empid;
		this.salary = salary;
		this.joinDate = new Date(day, month, year);
	}
	public Employee clone( ) throws CloneNotSupportedException
	{
 		Employee other = (Employee) super.clone();
 		other.joinDate = this.joinDate.clone();
 		return other;
	}
	@Override
	public String toString() 
	{
		return "Employee [empid=" + empid + ", salary=" + salary + ", joinDate=" + joinDate + "]";
	}
	
}
public class Program
{
	public static void main(String[] args) 
	{
		try
		{
			Employee emp1 = new Employee(11, 25000, 1, 1, 2018);
			Employee emp2 = emp1.clone();
		}
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	}
	public static void main2(String[] args) 
	{
		ArrayList<Integer> list1 = new  ArrayList<Integer>();
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		ArrayList<Integer> list2 =  (ArrayList<Integer>) list1.clone();
		for( Integer element : list2 )
			System.out.println(element );
		
	}
	public static void main1(String[] args) 
	{
		try
		{
			Date dt1 = new Date( 18, 04, 2019 );
			Date dt2 = dt1.clone();
			if( dt1 == dt2 )
				System.out.println("Equal");
			else
				System.out.println("Not Equal");
		}
		catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
	}
}
