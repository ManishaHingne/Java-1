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
	public static void readRecord( String pathname )throws Exception
	{
		try( BufferedReader reader = new BufferedReader(new FileReader(new File(pathname))))
		{
			String line = "";
			while( ( line = reader.readLine()) != null )
				System.out.println(line);
		}
	}
	public static void main(String[] args) 
	{
		String pathname = "../Day_12.11/src/org/sunbeam/dac/test/Program.java";
		try
		{
			Program.readRecord(pathname);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}
}
