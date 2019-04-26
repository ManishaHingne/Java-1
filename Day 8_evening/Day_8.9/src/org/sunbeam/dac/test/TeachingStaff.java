package org.sunbeam.dac.test;

public class TeachingStaff extends Staff
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
