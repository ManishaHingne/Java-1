package org.sunbeam.dac.test;

import java.util.List;

public class Institute
{
	private List<Staff> staffList;
	private Institute( )
	{	}
	private static Institute instance;
	public static Institute getInstance( )
	{
		if( instance == null )
			instance = new Institute();
		return instance;
	}
	public void setStaffList(List<Staff> staffList) 
	{
		this.staffList = staffList;
	}
	public void addStaff( Staff staff )
	{
		if( this.staffList != null )
			this.staffList.add(staff);
	}
	public Staff findStaff( int staffId )
	{
		Staff key = new TeachingStaff();
		key.setId(staffId);
		if( this.staffList.contains(key ) )
		{
			int index = this.staffList.indexOf( key );
			return this.staffList.get(index);
		}
		return null;
	}
	public boolean removeStaff( int staffId )
	{
		Staff key = new NonTeachingStaff();
		key.setId(staffId);
		if( this.staffList.contains(key))
		{
			this.staffList.remove(key);
			return true;
		}
		return false;
	}
	public void printStaffList( )
	{
		if( this.staffList != null )
			this.staffList.forEach(System.out::println);
	}
}
