package org.sunbeam.dac.test;

public abstract class Staff
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
	public boolean equals(Object obj)
	{
		if( obj != null )
		{
			Staff other = (Staff) obj;
			if( this.id == other.id )
				return true;
		}
		return false;
	}
	@Override
	public String toString() 
	{
		return String.format("%-15s%-5d%-10.2f", this.name, this.id, this.salary );
	}
}
