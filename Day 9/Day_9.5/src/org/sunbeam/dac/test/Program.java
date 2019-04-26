package org.sunbeam.dac.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Program 
{
	public static Map<Integer, String> getMap( )
	{
		Map<Integer, String> map = new Hashtable<>( );
		map.put(1,"DAC");
		map.put(2,"DMC");
		map.put(3,"DESD");
		map.put(4,"DBDA");
		map.put(5,"PRECAT");
		return map;
	}
	private static void printKeys(Map<Integer, String> map) 
	{
		if( map != null )
		{
			Set<Integer> keys = map.keySet();
			for( Integer key : keys )
				System.out.println(key);
		}
	}
	private static void printValues(Map<Integer, String> map) 
	{
		if( map != null )
		{
			Collection<String> values = map.values();
			for( String value : values )
				System.out.println(value);
		}
	}
	private static void printEntries(Map<Integer, String> map) 
	{
		if( map != null )
		{
			Set<Entry<Integer, String>> entries = map.entrySet();
			for (Entry<Integer, String> entry : entries) 
			{
				Integer key = entry.getKey();
				String value = entry.getValue();
				System.out.println(key+"	"+value);
			}
		}
	}
	private static void printValue(Map<Integer, String> map, int number ) 
	{
		if( map != null )
		{
			Integer key = new Integer(number);
			if( map.containsKey(key))
			{
				String value =  map.get(key);
				System.out.println(key+"	"+value);
			}
			else
				System.out.println(number+" not found");
		}
	}
	private static void removeEntry(Map<Integer, String> map, int number) 
	{
		if( map != null )
		{
			Integer key = new Integer(number);
			if( map.containsKey(key))
			{
				String value = map.remove( key );
				System.out.println(key+"	"+value+" is removed");
			}
			else
				System.out.println(number+" not found");
		}
	}
	public static void main(String[] args) 
	{
		Map<Integer, String> map = Program.getMap();
		//Program.printKeys( map );
		//Program.printValues( map );
		//Program.printEntries( map );
		//Program.printValue(map, 3 );
		//Program.removeEntry(map, 30 );
		
		//Collection<String> values = map.values();
		//List<String> list = new ArrayList<String>(values);
		
		List<String> list = new ArrayList<String>( map.values() ); 
	}
}

