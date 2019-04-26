package org.sunbeam.dac.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Program 
{
	static Scanner sc = new Scanner(System.in);
	public static Account[] getAccounts( )
	{
		Account[] arr = new Account[ 5 ];
		arr[ 0 ] = new Account(101,"Saving",75000);
		arr[ 1 ] = new Account(215,"Current",50000);
		arr[ 2 ] = new Account(413,"Loan",125000);
		arr[ 3 ] = new Account(351,"Pention",25000);
		arr[ 4 ] = new Account(148,"Joint",250000);
		return arr;
	}
	public static Customer[] getCustomers( )
	{
		Customer[] arr = new Customer[ 5 ];
		arr[ 0 ] = new Customer("Sarang","sarang@gmail.com","11111");
		arr[ 1 ] = new Customer("Nitin","nitin@gmail.com","22222");
		arr[ 2 ] = new Customer("Prashant","prashant@gmail.com","33333");
		arr[ 3 ] = new Customer("Rupesh","rupesh@gmail.com","44444");
		arr[ 4 ] = new Customer("Amol","amol@gmail.com","55555");
		return arr;
	}
	public static void acceptRecord( int[] accountNumber )
	{
		System.out.print("Enter account number	:	");
		accountNumber[ 0 ] = sc.nextInt();
	}
	private static void printRecord(Customer value)
	{
		if( value != null )
			System.out.println(value.toString());
		else
			System.out.println("Account not found");
	}
	private static void printRecord( boolean removedStatus )
	{
		if( removedStatus )
			System.out.println("Entry is removed");
		else
			System.out.println("Entry is not removed");
	}
	public static int menuList( )
	{
		System.out.println("0.Exit");
		System.out.println("1.Add Entry");
		System.out.println("2.Find Entry");
		System.out.println("3.Remove Entry");
		System.out.println("Print Entries");
		System.out.print("Enter choice	:	");
		return sc.nextInt();
	}
	public static void main(String[] args) 
	{
		int choice;
		int[] accountNumber = new int[ 1 ];
		MapTest test = new  MapTest();
		//test.setMap(new Hashtable<Account, Customer>());
		//test.setMap(new HashMap<Account, Customer>());
		//test.setMap(new LinkedHashMap<Account, Customer>());
		test.setMap(new TreeMap<Account, Customer>());
		
		while( ( choice = Program.menuList( ) ) != 0 )
		{
			switch( choice )
			{
			case 1:
				Account[] accounts = Program.getAccounts();
				Customer[] customers = Program.getCustomers();
				test.addEntry( accounts, customers );
				break;
			case 2:
				Program.acceptRecord(accountNumber);
				Customer value =  test.findEntry( accountNumber[ 0 ] );
				Program.printRecord( value );
				break;
			case 3:
				Program.acceptRecord(accountNumber);
				boolean removedStatus = test.removeEntry( accountNumber[ 0 ] );
				Program.printRecord(removedStatus);
				break;
			case 4:
				test.printEntries();
				break;
			}
		}
	}
}

