package org.sunbeam.dac.test;

import java.net.InetAddress;

public class Program 
{
	public static void main(String[] args) throws Exception
	{
		InetAddress host = InetAddress.getLocalHost();
		String name =  host.getHostName();
		String address = host.getHostAddress();
		System.out.println(name+"	"+address);
	}
}
