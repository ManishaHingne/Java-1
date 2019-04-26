package org.sunbeam.dac.test;

import java.util.Scanner;

enum Color	//Color.class
{
	RED, GREEN, BLUE
}
public class Program	//Program.class
{
	public static void main1(String[] args) 
	{
		System.out.println(Color.RED.name());
		System.out.println(Color.RED.ordinal());
	}
	public static void main2(String[] args) 
	{
		Color color = Color.RED;
		System.out.printf("%-10s%-5d\n",color.name(), color.ordinal());
	}
	public static void main3(String[] args) 
	{
		Color[] colors = Color.values();
		for (Color color : colors) 
			System.out.printf("%-10s%-5d\n",color.name(), color.ordinal());	
	}
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Name	:	");
		String name = sc.nextLine();
		Color color = Color.valueOf(name.toUpperCase());
		System.out.printf("%-10s%-5d\n",color.name(), color.ordinal());
	}
}
