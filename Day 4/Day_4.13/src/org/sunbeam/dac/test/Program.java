package org.sunbeam.dac.test;

enum Day
{
	SUN("SunDay",1),MON("MonDay"),TUE(3);
	
	private String dayName;
	private int dayNumber;
	
	private Day(int dayNumber )
	{
		this.dayNumber = dayNumber;
	}
	private Day( String dayName )
	{
		this.dayName = dayName;
	}
	private Day(String dayName, int dayNumber) 
	{
		this.dayName = dayName;
		this.dayNumber = dayNumber;
	}
	public String getDayName() 
	{
		return dayName;
	}
	public int getDayNumber() 
	{
		return dayNumber;
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		Day[] days = Day.values();
		for (Day day : days) 
		{
			System.out.printf("%-10s%-5d%-10s%-5d\n",day.name(), day.ordinal(), day.getDayName(), day.getDayNumber());
		}
	}
}
