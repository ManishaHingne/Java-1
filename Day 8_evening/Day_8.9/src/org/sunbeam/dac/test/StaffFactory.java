package org.sunbeam.dac.test;

public class StaffFactory 
{
	public static Staff getInstance( int choice )
	{
		switch( choice )
		{
		case 1:	return new TeachingStaff();
		case 2:	return new NonTeachingStaff();
		}
		return null;
	}
}
