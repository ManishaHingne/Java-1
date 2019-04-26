package org.sunbeam.dac.test;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	private static void acceptRecord(Book book)
	{
		System.out.print("Book id	:	");
		book.setId(sc.nextInt());
		System.out.print("Book Name	:	");
		sc.nextLine();
		book.setName(sc.nextLine());
		System.out.print("Author Name	:	");
		book.setAuthor(sc.nextLine());
		System.out.print("Price	:	");
		book.setPrice(sc.nextFloat());
	}
	private static void acceptRecord(int[] bookId)
	{
		System.out.print("Enter book id	:	");
		bookId[ 0 ] = sc.nextInt();
	}
	private static void printRecord(Book book)
	{
		if( book != null )
			System.out.println(book.toString());
		else
			System.out.println("Book not found");
	}
	private static void printRecord(boolean removedStatus) 
	{
		if( removedStatus )
			System.out.println("Book is removed");
		else
			System.out.println("Book is not removed");
	}
	public static int menuList( )
	{
		System.out.println("0.Exit.");
		System.out.println("1.Add Book.");
		System.out.println("2.Find Book.");
		System.out.println("3.Remove Book.");
		System.out.println("4.Print Book(s).");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] bookId = new int[ 1 ];
		SetTest test = new SetTest();
		//test.setBookList(new HashSet<Book>());
		//test.setBookList(new LinkedHashSet<Book>());
		//test.setBookList(new TreeSet<Book>());
		test.setBookList(new TreeSet<Book>( new SortById() ));
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			Book book = null;
			switch( choice )
			{
			case 1:
				book = new Book();
				Program.acceptRecord( book );
				test.add( book );
				break;
			case 2:
				Program.acceptRecord( bookId );
				book = test.find( bookId[ 0 ] );
				Program.printRecord( book );
				break;
			case 3:
				Program.acceptRecord( bookId );
				boolean removedStatus = test.remove( bookId[ 0 ] );
				Program.printRecord(removedStatus);
				break;
			case 4:
				test.print( );
				break;
				
			}
		}
	}
	
	
	
	
}
