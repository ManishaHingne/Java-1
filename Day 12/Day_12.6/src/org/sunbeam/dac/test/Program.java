package org.sunbeam.dac.test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static void writeRecord( String pathname )throws Exception
	{
		try( ObjectOutputStream outputStream = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream(new File(pathname))));)
		{	
			Employee emp = new Employee("Sandeep", 33, 45000.50f);
			outputStream.writeObject(emp);
		}
	}
	public static void readRecord( String pathname )throws Exception
	{
		try( ObjectInputStream inputStream = new ObjectInputStream( new BufferedInputStream(new FileInputStream(new File(pathname))));)
		{	
			Employee emp =  (Employee) inputStream.readObject();
			System.out.println(emp.toString());
		}
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Write Record");
		System.out.println("2.Read Record");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		String pathname = "File.dat";
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			try
			{
				switch( choice )
				{
				case 1:
					Program.writeRecord(pathname);
					break;
				case 2:
					Program.readRecord(pathname);
					break;
				}
			}
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
}
