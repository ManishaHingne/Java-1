package org.sunbeam.dac.test;

import java.util.Scanner;

import org.sunbeam.dac.dao.BookDao;
import org.sunbeam.dac.pojo.Book;

public class Program
{	
	static Scanner sc = new Scanner(System.in);
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Insert Book");
		System.out.println("2.Update Book");
		System.out.println("3.Delete Book");
		System.out.println("4.Print Book(s)");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		try( BookDao dao = new BookDao())
		{
			int choice;
			while( ( choice = Program.menuList( ) ) != 0 )
			{
				switch( choice )
				{
				case 1:
					Book book = new Book(1025,"OS","Operating System Concept","Galvin",550);
					dao.insert(book);
					break;
				case 2:
					dao.update(1025, 575);
					break;
				case 3:
					dao.delete(1025);
					break;
				case 4:
					dao.getBooks().forEach(System.out::println);
					break;
				}
			}
		}
		catch( Exception ex )
		{
			ex.printStackTrace();
		}
	}
}
