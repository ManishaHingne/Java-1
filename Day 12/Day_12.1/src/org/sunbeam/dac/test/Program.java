package org.sunbeam.dac.test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Program 
{
	public static void main1(String[] args) 
	{
		//String pathname = "/Users/sandeepkulange/Documents/Demo.rtf";
		String pathname = "/Users/sandeepkulange/Programs/Core_Java/DAC/Editor";
		File file = new File(pathname);
		if( file.exists())
		{
			if( file.isDirectory())
			{	
				File[] files = file.listFiles();
				for (File f : files) 
				{
					if( !f.isHidden())
					System.out.println(f.getName());
				}
			}
			else
			{
				System.out.println("File Name	:	"+file.getName());
				System.out.println("Parent Name	:	"+file.getParent());
				System.out.println("Length	:	"+file.length());
				Date date = new Date( file.lastModified());
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				System.out.println("Last Modified	:	"+sdf.format(date));
						
			}
		}
		else
			System.out.println(pathname+" does not exist");
	}
	public static void main2(String[] args) 
	{
		try
		{
			File file = new File("Temp.txt");
			//file.createNewFile();
			file.delete();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) 
	{
		try
		{
			File file = new File("Temp");
			//file.mkdir();
			file.delete();
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
