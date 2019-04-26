package org.sunbeam.dac.test;

class InstanceCounter
{
	private static int count;
	public InstanceCounter() 
	{
		++ InstanceCounter.count;
	}
	public static int getCount() 
	{
		return count;
	}
}
public class Program
{
	public static void main(String[] args) 
	{
		InstanceCounter ic1 = new InstanceCounter();
		InstanceCounter ic2 = new InstanceCounter();
		InstanceCounter ic3 = new InstanceCounter();
		
		
		System.out.println("Count	:	"+InstanceCounter.getCount());
	}
}
