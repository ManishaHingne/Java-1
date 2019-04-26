package org.sunbeam.dac.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static void writeRecord( String pathname )throws Exception
	{
		try( BufferedWriter writer = new BufferedWriter(new FileWriter(new File(pathname))))
		{
			writer.write("Diploma in Advanced Computing");
			writer.newLine();
			writer.write("SunBeam Pune");
			writer.newLine();
			writer.write("Pincode : 414037");
		}
	}
	public static void readRecord( String pathname )throws Exception
	{
		try( BufferedReader reader = new BufferedReader(new FileReader(new File(pathname))))
		{
			String line = "";
			while( ( line = reader.readLine()) != null )
				System.out.println(line);
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
		String pathname = "File.txt";
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
