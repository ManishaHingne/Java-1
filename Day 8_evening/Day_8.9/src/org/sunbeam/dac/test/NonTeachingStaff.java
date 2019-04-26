package org.sunbeam.dac.test;

public class NonTeachingStaff extends Staff
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
