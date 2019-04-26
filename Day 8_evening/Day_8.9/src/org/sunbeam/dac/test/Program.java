package org.sunbeam.dac.test;

public class Program
{
	public static void main(String[] args) 
	{
		int choice;
		InstituteTest test = new InstituteTest( );
		while( ( choice = InstituteTest.instituteMenuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				test.addStaff( );
				break;
			case 2:
				test.findStaff();
				break;
			case 3:
				test.removeStaff();
				break;
			case 4:
				test.printStaffList();
				break;
			}
		}
	}
}
